package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import com.squareup.okhttp.CipherSuite;
import com.squareup.okhttp.TlsVersion;
import io.grpc.InternalChannelz;
import io.grpc.InternalMetadata;
import io.grpc.Metadata;
import io.grpc.internal.TransportFrameUtil;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.framed.Header;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckReturnValue;

class Utils {
    static final int CONNECTION_STREAM_ID = 0;
    static final float DEFAULT_WINDOW_UPDATE_RATIO = 0.5f;
    private static final Logger log = Logger.getLogger(Utils.class.getName());

    public static Metadata convertHeaders(List<Header> list) {
        return InternalMetadata.newMetadata(convertHeadersToArray(list));
    }

    public static Metadata convertTrailers(List<Header> list) {
        return InternalMetadata.newMetadata(convertHeadersToArray(list));
    }

    @CheckReturnValue
    private static byte[][] convertHeadersToArray(List<Header> list) {
        byte[][] bArr = new byte[(list.size() * 2)][];
        int i = 0;
        for (Header next : list) {
            int i2 = i + 1;
            bArr[i] = next.name.toByteArray();
            i = i2 + 1;
            bArr[i2] = next.value.toByteArray();
        }
        return TransportFrameUtil.toRawSerializedHeaders(bArr);
    }

    static ConnectionSpec convertSpec(com.squareup.okhttp.ConnectionSpec connectionSpec) {
        Preconditions.checkArgument(connectionSpec.isTls(), "plaintext ConnectionSpec is not accepted");
        List<TlsVersion> tlsVersions = connectionSpec.tlsVersions();
        String[] strArr = new String[tlsVersions.size()];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = tlsVersions.get(i).javaName();
        }
        List<CipherSuite> cipherSuites = connectionSpec.cipherSuites();
        io.grpc.okhttp.internal.CipherSuite[] cipherSuiteArr = new io.grpc.okhttp.internal.CipherSuite[cipherSuites.size()];
        for (int i2 = 0; i2 < cipherSuiteArr.length; i2++) {
            cipherSuiteArr[i2] = io.grpc.okhttp.internal.CipherSuite.valueOf(cipherSuites.get(i2).name());
        }
        return new ConnectionSpec.Builder(connectionSpec.isTls()).supportsTlsExtensions(connectionSpec.supportsTlsExtensions()).tlsVersions(strArr).cipherSuites(cipherSuiteArr).build();
    }

    static InternalChannelz.SocketOptions getSocketOptions(Socket socket) {
        InternalChannelz.SocketOptions.Builder builder = new InternalChannelz.SocketOptions.Builder();
        try {
            builder.setSocketOptionLingerSeconds(Integer.valueOf(socket.getSoLinger()));
        } catch (SocketException e) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", e);
            builder.addOption("SO_LINGER", "channelz_internal_error");
        }
        try {
            builder.setSocketOptionTimeoutMillis(Integer.valueOf(socket.getSoTimeout()));
        } catch (Exception e2) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", e2);
            builder.addOption("SO_TIMEOUT", "channelz_internal_error");
        }
        try {
            builder.addOption("TCP_NODELAY", socket.getTcpNoDelay());
        } catch (SocketException e3) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", e3);
            builder.addOption("TCP_NODELAY", "channelz_internal_error");
        }
        try {
            builder.addOption("SO_REUSEADDR", socket.getReuseAddress());
        } catch (SocketException e4) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", e4);
            builder.addOption("SO_REUSEADDR", "channelz_internal_error");
        }
        try {
            builder.addOption("SO_SNDBUF", socket.getSendBufferSize());
        } catch (SocketException e5) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", e5);
            builder.addOption("SO_SNDBUF", "channelz_internal_error");
        }
        try {
            builder.addOption("SO_RECVBUF", socket.getReceiveBufferSize());
        } catch (SocketException e6) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", e6);
            builder.addOption("SO_RECVBUF", "channelz_internal_error");
        }
        try {
            builder.addOption("SO_KEEPALIVE", socket.getKeepAlive());
        } catch (SocketException e7) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", e7);
            builder.addOption("SO_KEEPALIVE", "channelz_internal_error");
        }
        try {
            builder.addOption("SO_OOBINLINE", socket.getOOBInline());
        } catch (SocketException e8) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", e8);
            builder.addOption("SO_OOBINLINE", "channelz_internal_error");
        }
        try {
            builder.addOption("IP_TOS", socket.getTrafficClass());
        } catch (SocketException e9) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", e9);
            builder.addOption("IP_TOS", "channelz_internal_error");
        }
        return builder.build();
    }

    private Utils() {
    }
}

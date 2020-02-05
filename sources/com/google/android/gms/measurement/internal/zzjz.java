package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzjz extends SSLSocket {
    private final SSLSocket zza;

    zzjz(zzka zzka, SSLSocket sSLSocket) {
        this.zza = sSLSocket;
    }

    public final void setEnabledProtocols(String[] strArr) {
        if (strArr != null && Arrays.asList(strArr).contains("SSLv3")) {
            ArrayList arrayList = new ArrayList(Arrays.asList(this.zza.getEnabledProtocols()));
            if (arrayList.size() > 1) {
                arrayList.remove("SSLv3");
            }
            strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        this.zza.setEnabledProtocols(strArr);
    }

    public final String[] getSupportedCipherSuites() {
        return this.zza.getSupportedCipherSuites();
    }

    public final String[] getEnabledCipherSuites() {
        return this.zza.getEnabledCipherSuites();
    }

    public final void setEnabledCipherSuites(String[] strArr) {
        this.zza.setEnabledCipherSuites(strArr);
    }

    public final String[] getSupportedProtocols() {
        return this.zza.getSupportedProtocols();
    }

    public final String[] getEnabledProtocols() {
        return this.zza.getEnabledProtocols();
    }

    public final SSLSession getSession() {
        return this.zza.getSession();
    }

    public final void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.zza.addHandshakeCompletedListener(handshakeCompletedListener);
    }

    public final void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.zza.removeHandshakeCompletedListener(handshakeCompletedListener);
    }

    public final void startHandshake() throws IOException {
        this.zza.startHandshake();
    }

    public final void setUseClientMode(boolean z) {
        this.zza.setUseClientMode(z);
    }

    public final boolean getUseClientMode() {
        return this.zza.getUseClientMode();
    }

    public final void setNeedClientAuth(boolean z) {
        this.zza.setNeedClientAuth(z);
    }

    public final void setWantClientAuth(boolean z) {
        this.zza.setWantClientAuth(z);
    }

    public final boolean getNeedClientAuth() {
        return this.zza.getNeedClientAuth();
    }

    public final boolean getWantClientAuth() {
        return this.zza.getWantClientAuth();
    }

    public final void setEnableSessionCreation(boolean z) {
        this.zza.setEnableSessionCreation(z);
    }

    public final boolean getEnableSessionCreation() {
        return this.zza.getEnableSessionCreation();
    }

    public final void bind(SocketAddress socketAddress) throws IOException {
        this.zza.bind(socketAddress);
    }

    public final synchronized void close() throws IOException {
        this.zza.close();
    }

    public final void connect(SocketAddress socketAddress) throws IOException {
        this.zza.connect(socketAddress);
    }

    public final void connect(SocketAddress socketAddress, int i) throws IOException {
        this.zza.connect(socketAddress, i);
    }

    public final SocketChannel getChannel() {
        return this.zza.getChannel();
    }

    public final InetAddress getInetAddress() {
        return this.zza.getInetAddress();
    }

    public final InputStream getInputStream() throws IOException {
        return this.zza.getInputStream();
    }

    public final boolean getKeepAlive() throws SocketException {
        return this.zza.getKeepAlive();
    }

    public final InetAddress getLocalAddress() {
        return this.zza.getLocalAddress();
    }

    public final int getLocalPort() {
        return this.zza.getLocalPort();
    }

    public final SocketAddress getLocalSocketAddress() {
        return this.zza.getLocalSocketAddress();
    }

    public final boolean getOOBInline() throws SocketException {
        return this.zza.getOOBInline();
    }

    public final OutputStream getOutputStream() throws IOException {
        return this.zza.getOutputStream();
    }

    public final int getPort() {
        return this.zza.getPort();
    }

    public final synchronized int getReceiveBufferSize() throws SocketException {
        return this.zza.getReceiveBufferSize();
    }

    public final SocketAddress getRemoteSocketAddress() {
        return this.zza.getRemoteSocketAddress();
    }

    public final boolean getReuseAddress() throws SocketException {
        return this.zza.getReuseAddress();
    }

    public final synchronized int getSendBufferSize() throws SocketException {
        return this.zza.getSendBufferSize();
    }

    public final int getSoLinger() throws SocketException {
        return this.zza.getSoLinger();
    }

    public final synchronized int getSoTimeout() throws SocketException {
        return this.zza.getSoTimeout();
    }

    public final boolean getTcpNoDelay() throws SocketException {
        return this.zza.getTcpNoDelay();
    }

    public final int getTrafficClass() throws SocketException {
        return this.zza.getTrafficClass();
    }

    public final boolean isBound() {
        return this.zza.isBound();
    }

    public final boolean isClosed() {
        return this.zza.isClosed();
    }

    public final boolean isConnected() {
        return this.zza.isConnected();
    }

    public final boolean isInputShutdown() {
        return this.zza.isInputShutdown();
    }

    public final boolean isOutputShutdown() {
        return this.zza.isOutputShutdown();
    }

    public final void sendUrgentData(int i) throws IOException {
        this.zza.sendUrgentData(i);
    }

    public final void setKeepAlive(boolean z) throws SocketException {
        this.zza.setKeepAlive(z);
    }

    public final void setOOBInline(boolean z) throws SocketException {
        this.zza.setOOBInline(z);
    }

    public final void setPerformancePreferences(int i, int i2, int i3) {
        this.zza.setPerformancePreferences(i, i2, i3);
    }

    public final synchronized void setReceiveBufferSize(int i) throws SocketException {
        this.zza.setReceiveBufferSize(i);
    }

    public final void setReuseAddress(boolean z) throws SocketException {
        this.zza.setReuseAddress(z);
    }

    public final synchronized void setSendBufferSize(int i) throws SocketException {
        this.zza.setSendBufferSize(i);
    }

    public final void setSoLinger(boolean z, int i) throws SocketException {
        this.zza.setSoLinger(z, i);
    }

    public final synchronized void setSoTimeout(int i) throws SocketException {
        this.zza.setSoTimeout(i);
    }

    public final void setTcpNoDelay(boolean z) throws SocketException {
        this.zza.setTcpNoDelay(z);
    }

    public final void setTrafficClass(int i) throws SocketException {
        this.zza.setTrafficClass(i);
    }

    public final void shutdownInput() throws IOException {
        this.zza.shutdownInput();
    }

    public final void shutdownOutput() throws IOException {
        this.zza.shutdownOutput();
    }

    public final String toString() {
        return this.zza.toString();
    }

    public final boolean equals(Object obj) {
        return this.zza.equals(obj);
    }
}

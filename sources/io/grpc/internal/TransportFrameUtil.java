package io.grpc.internal;

import com.google.common.base.Charsets;
import com.google.common.io.BaseEncoding;
import io.grpc.InternalMetadata;
import io.grpc.Metadata;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.annotation.CheckReturnValue;

public final class TransportFrameUtil {
    private static final byte[] binaryHeaderSuffixBytes = Metadata.BINARY_HEADER_SUFFIX.getBytes(Charsets.US_ASCII);
    private static final Logger logger = Logger.getLogger(TransportFrameUtil.class.getName());

    public static byte[][] toHttp2Headers(Metadata metadata) {
        byte[][] serialize = InternalMetadata.serialize(metadata);
        if (serialize == null) {
            return new byte[0][];
        }
        int i = 0;
        for (int i2 = 0; i2 < serialize.length; i2 += 2) {
            byte[] bArr = serialize[i2];
            byte[] bArr2 = serialize[i2 + 1];
            if (endsWith(bArr, binaryHeaderSuffixBytes)) {
                serialize[i] = bArr;
                serialize[i + 1] = InternalMetadata.BASE64_ENCODING_OMIT_PADDING.encode(bArr2).getBytes(Charsets.US_ASCII);
            } else if (isSpecCompliantAscii(bArr2)) {
                serialize[i] = bArr;
                serialize[i + 1] = bArr2;
            } else {
                String str = new String(bArr, Charsets.US_ASCII);
                Logger logger2 = logger;
                logger2.warning("Metadata key=" + str + ", value=" + Arrays.toString(bArr2) + " contains invalid ASCII characters");
            }
            i += 2;
        }
        if (i == serialize.length) {
            return serialize;
        }
        return (byte[][]) Arrays.copyOfRange(serialize, 0, i);
    }

    @CheckReturnValue
    public static byte[][] toRawSerializedHeaders(byte[][] bArr) {
        for (int i = 0; i < bArr.length; i += 2) {
            byte[] bArr2 = bArr[i];
            int i2 = i + 1;
            byte[] bArr3 = bArr[i2];
            if (endsWith(bArr2, binaryHeaderSuffixBytes)) {
                for (byte b : bArr3) {
                    if (b == 44) {
                        return serializeHeadersWithCommasInBin(bArr, i);
                    }
                }
                bArr[i2] = BaseEncoding.base64().decode(new String(bArr3, Charsets.US_ASCII));
            }
        }
        return bArr;
    }

    private static byte[][] serializeHeadersWithCommasInBin(byte[][] bArr, int i) {
        ArrayList arrayList = new ArrayList(bArr.length + 10);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(bArr[i2]);
        }
        while (i < bArr.length) {
            byte[] bArr2 = bArr[i];
            byte[] bArr3 = bArr[i + 1];
            if (!endsWith(bArr2, binaryHeaderSuffixBytes)) {
                arrayList.add(bArr2);
                arrayList.add(bArr3);
            } else {
                int i3 = 0;
                for (int i4 = 0; i4 <= bArr3.length; i4++) {
                    if (i4 == bArr3.length || bArr3[i4] == 44) {
                        byte[] decode = BaseEncoding.base64().decode(new String(bArr3, i3, i4 - i3, Charsets.US_ASCII));
                        arrayList.add(bArr2);
                        arrayList.add(decode);
                        i3 = i4 + 1;
                    }
                }
            }
            i += 2;
        }
        return (byte[][]) arrayList.toArray(new byte[0][]);
    }

    private static boolean endsWith(byte[] bArr, byte[] bArr2) {
        int length = bArr.length - bArr2.length;
        if (length < 0) {
            return false;
        }
        for (int i = length; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i - length]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSpecCompliantAscii(byte[] bArr) {
        for (byte b : bArr) {
            if (b < 32 || b > 126) {
                return false;
            }
        }
        return true;
    }

    private TransportFrameUtil() {
    }
}

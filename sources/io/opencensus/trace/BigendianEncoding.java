package io.opencensus.trace;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import io.opencensus.internal.Utils;
import java.util.Arrays;

final class BigendianEncoding {
    private static final String ALPHABET = "0123456789abcdef";
    private static final int ASCII_CHARACTERS = 128;
    static final int BYTE_BASE16 = 2;
    private static final byte[] DECODING = buildDecodingArray();
    private static final char[] ENCODING = buildEncodingArray();
    static final int LONG_BASE16 = 16;
    static final int LONG_BYTES = 8;

    private static char[] buildEncodingArray() {
        char[] cArr = new char[512];
        for (int i = 0; i < 256; i++) {
            cArr[i] = ALPHABET.charAt(i >>> 4);
            cArr[i | 256] = ALPHABET.charAt(i & 15);
        }
        return cArr;
    }

    private static byte[] buildDecodingArray() {
        byte[] bArr = new byte[128];
        Arrays.fill(bArr, (byte) -1);
        for (int i = 0; i < 16; i++) {
            bArr[ALPHABET.charAt(i)] = (byte) i;
        }
        return bArr;
    }

    static long longFromByteArray(byte[] bArr, int i) {
        Utils.checkArgument(bArr.length >= i + 8, "array too small");
        return (((long) bArr[i + 7]) & 255) | ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8);
    }

    static void longToByteArray(long j, byte[] bArr, int i) {
        Utils.checkArgument(bArr.length >= i + 8, "array too small");
        bArr[i + 7] = (byte) ((int) (j & 255));
        bArr[i + 6] = (byte) ((int) ((j >> 8) & 255));
        bArr[i + 5] = (byte) ((int) ((j >> 16) & 255));
        bArr[i + 4] = (byte) ((int) ((j >> 24) & 255));
        bArr[i + 3] = (byte) ((int) ((j >> 32) & 255));
        bArr[i + 2] = (byte) ((int) ((j >> 40) & 255));
        bArr[i + 1] = (byte) ((int) ((j >> 48) & 255));
        bArr[i] = (byte) ((int) ((j >> 56) & 255));
    }

    static long longFromBase16String(CharSequence charSequence, int i) {
        Utils.checkArgument(charSequence.length() >= i + 16, "chars too small");
        return (((long) decodeByte(charSequence.charAt(i + 14), charSequence.charAt(i + 15))) & 255) | ((((long) decodeByte(charSequence.charAt(i), charSequence.charAt(i + 1))) & 255) << 56) | ((((long) decodeByte(charSequence.charAt(i + 2), charSequence.charAt(i + 3))) & 255) << 48) | ((((long) decodeByte(charSequence.charAt(i + 4), charSequence.charAt(i + 5))) & 255) << 40) | ((((long) decodeByte(charSequence.charAt(i + 6), charSequence.charAt(i + 7))) & 255) << 32) | ((((long) decodeByte(charSequence.charAt(i + 8), charSequence.charAt(i + 9))) & 255) << 24) | ((((long) decodeByte(charSequence.charAt(i + 10), charSequence.charAt(i + 11))) & 255) << 16) | ((((long) decodeByte(charSequence.charAt(i + 12), charSequence.charAt(i + 13))) & 255) << 8);
    }

    static void longToBase16String(long j, char[] cArr, int i) {
        byteToBase16((byte) ((int) ((j >> 56) & 255)), cArr, i);
        byteToBase16((byte) ((int) ((j >> 48) & 255)), cArr, i + 2);
        byteToBase16((byte) ((int) ((j >> 40) & 255)), cArr, i + 4);
        byteToBase16((byte) ((int) ((j >> 32) & 255)), cArr, i + 6);
        byteToBase16((byte) ((int) ((j >> 24) & 255)), cArr, i + 8);
        byteToBase16((byte) ((int) ((j >> 16) & 255)), cArr, i + 10);
        byteToBase16((byte) ((int) ((j >> 8) & 255)), cArr, i + 12);
        byteToBase16((byte) ((int) (j & 255)), cArr, i + 14);
    }

    static void byteToBase16String(byte b, char[] cArr, int i) {
        byteToBase16(b, cArr, i);
    }

    static byte byteFromBase16String(CharSequence charSequence, int i) {
        Utils.checkArgument(charSequence.length() >= i + 2, "chars too small");
        return decodeByte(charSequence.charAt(i), charSequence.charAt(i + 1));
    }

    private static byte decodeByte(char c, char c2) {
        boolean z = true;
        boolean z2 = c2 < 128 && DECODING[c2] != -1;
        Utils.checkArgument(z2, "invalid character " + c2);
        if (c >= 128 || DECODING[c] == -1) {
            z = false;
        }
        Utils.checkArgument(z, "invalid character " + c);
        byte[] bArr = DECODING;
        return (byte) ((bArr[c] << 4) | bArr[c2]);
    }

    private static void byteToBase16(byte b, char[] cArr, int i) {
        byte b2 = b & UnsignedBytes.MAX_VALUE;
        char[] cArr2 = ENCODING;
        cArr[i] = cArr2[b2];
        cArr[i + 1] = cArr2[b2 | Ascii.NUL];
    }

    private BigendianEncoding() {
    }
}

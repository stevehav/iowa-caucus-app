package com.google.zxing.datamatrix.encoder;

import com.adobe.xmp.XMPError;
import com.drew.metadata.exif.ExifDirectoryBase;
import com.drew.metadata.exif.makernotes.CanonMakernoteDirectory;
import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import com.facebook.imageutils.JfifUtil;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.logging.type.LogSeverity;

public final class ErrorCorrection {
    private static final int[] ALOG = new int[255];
    private static final int[][] FACTORS = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, NikonType2MakernoteDirectory.TAG_DIGITAL_ZOOM, 240, 92, ExifDirectoryBase.TAG_NEW_SUBFILE_TYPE}, new int[]{28, 24, NikonType2MakernoteDirectory.TAG_AF_TUNE, NikonType2MakernoteDirectory.TAG_DELETED_IMAGE_COUNT, 223, 248, 116, 255, 110, 61}, new int[]{NikonType2MakernoteDirectory.TAG_UNKNOWN_30, 138, 205, 12, 194, NikonType2MakernoteDirectory.TAG_FLASH_INFO, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, 142, 213, 97, 178, 100, 242}, new int[]{NikonType2MakernoteDirectory.TAG_SCENE_ASSIST, 97, JfifUtil.MARKER_SOFn, 252, 95, 9, 157, 119, 138, 45, 18, 186, 83, NikonType2MakernoteDirectory.TAG_AF_TUNE}, new int[]{83, 195, 100, 39, 188, 75, 66, 61, 241, 213, 109, 129, 94, ExifDirectoryBase.TAG_NEW_SUBFILE_TYPE, JfifUtil.MARKER_APP1, 48, 90, 188}, new int[]{15, 195, 244, 9, 233, 71, NikonType2MakernoteDirectory.TAG_FLASH_INFO, 2, 188, 160, 153, 145, 253, 79, 108, 82, 27, 174, 186, NikonType2MakernoteDirectory.TAG_IMAGE_STABILISATION}, new int[]{52, 190, 88, 205, 109, 39, 176, 21, NikonType2MakernoteDirectory.TAG_UNKNOWN_10, 197, 251, 223, NikonType2MakernoteDirectory.TAG_UNKNOWN_10, 21, 5, NikonType2MakernoteDirectory.TAG_IMAGE_STABILISATION, ExifDirectoryBase.TAG_NEW_SUBFILE_TYPE, PanasonicMakernoteDirectory.TAG_CLEAR_RETOUCH, 12, NikonType2MakernoteDirectory.TAG_UNKNOWN_48, NikonType2MakernoteDirectory.TAG_FILE_INFO, 96, 50, 193}, new int[]{211, 231, 43, 97, 71, 96, 103, 174, 37, 151, 170, 53, 75, 34, 249, PanasonicMakernoteDirectory.TAG_INTELLIGENT_D_RANGE, 17, 138, 110, 213, 141, 136, 120, 151, 233, NikonType2MakernoteDirectory.TAG_FLASH_INFO, 93, 255}, new int[]{245, 127, 242, JfifUtil.MARKER_SOS, NikonType2MakernoteDirectory.TAG_ADAPTER, ExponentialBackoffSender.RND_MAX, 162, NikonType2MakernoteDirectory.TAG_UNKNOWN_48, 102, 120, 84, 179, 220, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, NikonType2MakernoteDirectory.TAG_UNKNOWN_30, NikonType2MakernoteDirectory.TAG_FILE_INFO, 59, 25, JfifUtil.MARKER_APP1, 98, 81, 112}, new int[]{77, 193, 137, 31, 19, 38, 22, 153, 247, 105, 122, 2, 245, NikonType2MakernoteDirectory.TAG_MANUAL_FOCUS_DISTANCE, 242, 8, NikonType2MakernoteDirectory.TAG_UNKNOWN_30, 95, 100, 9, NikonType2MakernoteDirectory.TAG_EXPOSURE_SEQUENCE_NUMBER, 105, 214, 111, 57, PanasonicMakernoteDirectory.TAG_INTELLIGENT_D_RANGE, 21, 1, 253, 57, 54, 101, 248, XMPError.BADRDF, 69, 50, 150, 177, 226, 5, 9, 5}, new int[]{245, NikonType2MakernoteDirectory.TAG_LENS, NikonType2MakernoteDirectory.TAG_IMAGE_STABILISATION, 223, 96, 32, 117, 22, 238, NikonType2MakernoteDirectory.TAG_MANUAL_FOCUS_DISTANCE, 238, 231, 205, 188, 237, 87, 191, 106, 16, 147, 118, 23, 37, 90, 170, 205, 131, 88, 120, 100, 66, 138, 186, 240, 82, 44, 176, 87, NikonType2MakernoteDirectory.TAG_UNKNOWN_49, 147, 160, NikonType2MakernoteDirectory.TAG_UNKNOWN_30, 69, 213, 92, 253, JfifUtil.MARKER_APP1, 19}, new int[]{NikonType2MakernoteDirectory.TAG_UNKNOWN_30, 9, 223, 238, 12, 17, 220, 208, 100, 29, NikonType2MakernoteDirectory.TAG_UNKNOWN_30, 170, 230, JfifUtil.MARKER_SOFn, JfifUtil.MARKER_RST7, 235, 150, 159, 36, 223, 38, LogSeverity.INFO_VALUE, NikonType2MakernoteDirectory.TAG_LENS, 54, 228, 146, JfifUtil.MARKER_SOS, 234, 117, XMPError.BADXMP, 29, 232, 144, 238, 22, 150, XMPError.BADXML, 117, 62, 207, 164, 13, 137, 245, 127, 67, 247, 28, NikonType2MakernoteDirectory.TAG_UNKNOWN_10, 43, XMPError.BADXMP, 107, 233, 53, 143, 46}, new int[]{242, 93, 169, 50, 144, 210, 39, 118, XMPError.BADRDF, 188, XMPError.BADXML, NikonType2MakernoteDirectory.TAG_UNKNOWN_50, 143, 108, 196, 37, NikonType2MakernoteDirectory.TAG_AF_TUNE, 112, NikonType2MakernoteDirectory.TAG_DIGITAL_ZOOM, 230, 245, 63, 197, 190, ExponentialBackoffSender.RND_MAX, 106, NikonType2MakernoteDirectory.TAG_AF_TUNE, 221, NikonType2MakernoteDirectory.TAG_UNKNOWN_30, 64, 114, 71, CanonMakernoteDirectory.TAG_TONE_CURVE_TABLE, 44, 147, 6, 27, JfifUtil.MARKER_SOS, 51, 63, 87, 10, 40, NikonType2MakernoteDirectory.TAG_ADAPTER, 188, 17, 163, 31, 176, 170, 4, 107, 232, 7, 94, NikonType2MakernoteDirectory.TAG_DELETED_IMAGE_COUNT, CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY, PanasonicMakernoteDirectory.TAG_CLEAR_RETOUCH, 86, 47, 11, XMPError.BADSTREAM}, new int[]{220, 228, NikonType2MakernoteDirectory.TAG_AF_RESPONSE, 89, 251, 149, 159, 56, 89, 33, 147, 244, 154, 36, 73, 127, 213, 136, 248, 180, 234, 197, 158, 177, 68, 122, 93, 213, 15, 160, 227, 236, 66, NikonType2MakernoteDirectory.TAG_LENS_STOPS, 153, NikonType2MakernoteDirectory.TAG_AF_TUNE, XMPError.BADRDF, NikonType2MakernoteDirectory.TAG_EXPOSURE_SEQUENCE_NUMBER, 179, 25, 220, 232, 96, 210, 231, 136, 223, 239, NikonType2MakernoteDirectory.TAG_UNKNOWN_48, 241, 59, 52, NikonType2MakernoteDirectory.TAG_IMAGE_STABILISATION, 25, 49, 232, 211, NikonType2MakernoteDirectory.TAG_UNKNOWN_50, 64, 54, 108, 153, NikonType2MakernoteDirectory.TAG_LENS, 63, 96, 103, 82, 186}};
    private static final int[] FACTOR_SETS = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[] LOG = new int[256];
    private static final int MODULO_VALUE = 301;

    static {
        int i = 1;
        for (int i2 = 0; i2 < 255; i2++) {
            ALOG[i2] = i;
            LOG[i] = i2;
            i <<= 1;
            if (i >= 256) {
                i ^= 301;
            }
        }
    }

    private ErrorCorrection() {
    }

    public static String encodeECC200(String str, SymbolInfo symbolInfo) {
        if (str.length() == symbolInfo.getDataCapacity()) {
            StringBuilder sb = new StringBuilder(symbolInfo.getDataCapacity() + symbolInfo.getErrorCodewords());
            sb.append(str);
            int interleavedBlockCount = symbolInfo.getInterleavedBlockCount();
            if (interleavedBlockCount == 1) {
                sb.append(createECCBlock(str, symbolInfo.getErrorCodewords()));
            } else {
                sb.setLength(sb.capacity());
                int[] iArr = new int[interleavedBlockCount];
                int[] iArr2 = new int[interleavedBlockCount];
                int[] iArr3 = new int[interleavedBlockCount];
                int i = 0;
                while (i < interleavedBlockCount) {
                    int i2 = i + 1;
                    iArr[i] = symbolInfo.getDataLengthForInterleavedBlock(i2);
                    iArr2[i] = symbolInfo.getErrorLengthForInterleavedBlock(i2);
                    iArr3[i] = 0;
                    if (i > 0) {
                        iArr3[i] = iArr3[i - 1] + iArr[i];
                    }
                    i = i2;
                }
                for (int i3 = 0; i3 < interleavedBlockCount; i3++) {
                    StringBuilder sb2 = new StringBuilder(iArr[i3]);
                    for (int i4 = i3; i4 < symbolInfo.getDataCapacity(); i4 += interleavedBlockCount) {
                        sb2.append(str.charAt(i4));
                    }
                    String createECCBlock = createECCBlock(sb2.toString(), iArr2[i3]);
                    int i5 = i3;
                    int i6 = 0;
                    while (i5 < iArr2[i3] * interleavedBlockCount) {
                        sb.setCharAt(symbolInfo.getDataCapacity() + i5, createECCBlock.charAt(i6));
                        i5 += interleavedBlockCount;
                        i6++;
                    }
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
    }

    private static String createECCBlock(CharSequence charSequence, int i) {
        return createECCBlock(charSequence, 0, charSequence.length(), i);
    }

    private static String createECCBlock(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = 0;
        while (true) {
            int[] iArr = FACTOR_SETS;
            if (i4 >= iArr.length) {
                i4 = -1;
                break;
            } else if (iArr[i4] == i3) {
                break;
            } else {
                i4++;
            }
        }
        if (i4 >= 0) {
            int[] iArr2 = FACTORS[i4];
            char[] cArr = new char[i3];
            for (int i5 = 0; i5 < i3; i5++) {
                cArr[i5] = 0;
            }
            for (int i6 = i; i6 < i + i2; i6++) {
                int i7 = i3 - 1;
                char charAt = cArr[i7] ^ charSequence.charAt(i6);
                while (i7 > 0) {
                    if (charAt == 0 || iArr2[i7] == 0) {
                        cArr[i7] = cArr[i7 - 1];
                    } else {
                        char c = cArr[i7 - 1];
                        int[] iArr3 = ALOG;
                        int[] iArr4 = LOG;
                        cArr[i7] = (char) (c ^ iArr3[(iArr4[charAt] + iArr4[iArr2[i7]]) % 255]);
                    }
                    i7--;
                }
                if (charAt == 0 || iArr2[0] == 0) {
                    cArr[0] = 0;
                } else {
                    int[] iArr5 = ALOG;
                    int[] iArr6 = LOG;
                    cArr[0] = (char) iArr5[(iArr6[charAt] + iArr6[iArr2[0]]) % 255];
                }
            }
            char[] cArr2 = new char[i3];
            for (int i8 = 0; i8 < i3; i8++) {
                cArr2[i8] = cArr[(i3 - i8) - 1];
            }
            return String.valueOf(cArr2);
        }
        throw new IllegalArgumentException("Illegal number of error correction codewords specified: ".concat(String.valueOf(i3)));
    }
}

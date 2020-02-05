package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

final class DecodedBitStreamParser {
    private static final int AL = 28;
    private static final int AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final BigInteger[] EXP900;
    private static final int LL = 27;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_ADDRESSEE = 4;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_CHECKSUM = 6;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_FILE_NAME = 0;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_FILE_SIZE = 5;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_SEGMENT_COUNT = 1;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_SENDER = 3;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_TIME_STAMP = 2;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final char[] MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final int ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;
    private static final int PL = 25;
    private static final int PS = 29;
    private static final char[] PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;

    private enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900);
        EXP900[1] = valueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = EXP900;
            if (i < bigIntegerArr2.length) {
                bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(valueOf);
                i++;
            } else {
                return;
            }
        }
    }

    private DecodedBitStreamParser() {
    }

    static DecoderResult decode(int[] iArr, String str) throws FormatException {
        int i;
        StringBuilder sb = new StringBuilder(iArr.length << 1);
        Charset charset = StandardCharsets.ISO_8859_1;
        int i2 = iArr[1];
        PDF417ResultMetadata pDF417ResultMetadata = new PDF417ResultMetadata();
        int i3 = 2;
        while (i3 < iArr[0]) {
            if (i2 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                switch (i2) {
                    case TEXT_COMPACTION_MODE_LATCH /*900*/:
                        i = textCompaction(iArr, i3, sb);
                        break;
                    case BYTE_COMPACTION_MODE_LATCH /*901*/:
                        i = byteCompaction(i2, iArr, charset, i3, sb);
                        break;
                    case NUMERIC_COMPACTION_MODE_LATCH /*902*/:
                        i = numericCompaction(iArr, i3, sb);
                        break;
                    default:
                        switch (i2) {
                            case MACRO_PDF417_TERMINATOR /*922*/:
                            case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                                throw FormatException.getFormatInstance();
                            case BYTE_COMPACTION_MODE_LATCH_6 /*924*/:
                                break;
                            case ECI_USER_DEFINED /*925*/:
                                i = i3 + 1;
                                break;
                            case ECI_GENERAL_PURPOSE /*926*/:
                                i = i3 + 2;
                                break;
                            case ECI_CHARSET /*927*/:
                                i = i3 + 1;
                                charset = Charset.forName(CharacterSetECI.getCharacterSetECIByValue(iArr[i3]).name());
                                break;
                            case 928:
                                i = decodeMacroBlock(iArr, i3, pDF417ResultMetadata);
                                break;
                            default:
                                i = textCompaction(iArr, i3 - 1, sb);
                                break;
                        }
                        i = byteCompaction(i2, iArr, charset, i3, sb);
                        break;
                }
            } else {
                i = i3 + 1;
                sb.append((char) iArr[i3]);
            }
            if (i < iArr.length) {
                i3 = i + 1;
                i2 = iArr[i];
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (sb.length() != 0) {
            DecoderResult decoderResult = new DecoderResult((byte[]) null, sb.toString(), (List<byte[]>) null, str);
            decoderResult.setOther(pDF417ResultMetadata);
            return decoderResult;
        }
        throw FormatException.getFormatInstance();
    }

    static int decodeMacroBlock(int[] iArr, int i, PDF417ResultMetadata pDF417ResultMetadata) throws FormatException {
        if (i + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            int i2 = i;
            int i3 = 0;
            while (i3 < 2) {
                iArr2[i3] = iArr[i2];
                i3++;
                i2++;
            }
            pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
            StringBuilder sb = new StringBuilder();
            int textCompaction = textCompaction(iArr, i2, sb);
            pDF417ResultMetadata.setFileId(sb.toString());
            int i4 = iArr[textCompaction] == BEGIN_MACRO_PDF417_OPTIONAL_FIELD ? textCompaction + 1 : -1;
            while (textCompaction < iArr[0]) {
                int i5 = iArr[textCompaction];
                if (i5 == MACRO_PDF417_TERMINATOR) {
                    textCompaction++;
                    pDF417ResultMetadata.setLastSegment(true);
                } else if (i5 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
                    int i6 = textCompaction + 1;
                    switch (iArr[i6]) {
                        case 0:
                            StringBuilder sb2 = new StringBuilder();
                            textCompaction = textCompaction(iArr, i6 + 1, sb2);
                            pDF417ResultMetadata.setFileName(sb2.toString());
                            break;
                        case 1:
                            StringBuilder sb3 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i6 + 1, sb3);
                            pDF417ResultMetadata.setSegmentCount(Integer.parseInt(sb3.toString()));
                            break;
                        case 2:
                            StringBuilder sb4 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i6 + 1, sb4);
                            pDF417ResultMetadata.setTimestamp(Long.parseLong(sb4.toString()));
                            break;
                        case 3:
                            StringBuilder sb5 = new StringBuilder();
                            textCompaction = textCompaction(iArr, i6 + 1, sb5);
                            pDF417ResultMetadata.setSender(sb5.toString());
                            break;
                        case 4:
                            StringBuilder sb6 = new StringBuilder();
                            textCompaction = textCompaction(iArr, i6 + 1, sb6);
                            pDF417ResultMetadata.setAddressee(sb6.toString());
                            break;
                        case 5:
                            StringBuilder sb7 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i6 + 1, sb7);
                            pDF417ResultMetadata.setFileSize(Long.parseLong(sb7.toString()));
                            break;
                        case 6:
                            StringBuilder sb8 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i6 + 1, sb8);
                            pDF417ResultMetadata.setChecksum(Integer.parseInt(sb8.toString()));
                            break;
                        default:
                            throw FormatException.getFormatInstance();
                    }
                } else {
                    throw FormatException.getFormatInstance();
                }
            }
            if (i4 != -1) {
                int i7 = textCompaction - i4;
                if (pDF417ResultMetadata.isLastSegment()) {
                    i7--;
                }
                pDF417ResultMetadata.setOptionalData(Arrays.copyOfRange(iArr, i4, i7 + i4));
            }
            return textCompaction;
        }
        throw FormatException.getFormatInstance();
    }

    private static int textCompaction(int[] iArr, int i, StringBuilder sb) {
        int[] iArr2 = new int[((iArr[0] - i) << 1)];
        int[] iArr3 = new int[((iArr[0] - i) << 1)];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i4 < TEXT_COMPACTION_MODE_LATCH) {
                iArr2[i2] = i4 / 30;
                iArr2[i2 + 1] = i4 % 30;
                i2 += 2;
            } else if (i4 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                if (i4 != 928) {
                    switch (i4) {
                        case TEXT_COMPACTION_MODE_LATCH /*900*/:
                            iArr2[i2] = TEXT_COMPACTION_MODE_LATCH;
                            i2++;
                            break;
                        case BYTE_COMPACTION_MODE_LATCH /*901*/:
                        case NUMERIC_COMPACTION_MODE_LATCH /*902*/:
                            break;
                        default:
                            switch (i4) {
                                case MACRO_PDF417_TERMINATOR /*922*/:
                                case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                                case BYTE_COMPACTION_MODE_LATCH_6 /*924*/:
                                    break;
                            }
                    }
                }
                i = i3 - 1;
                z = true;
            } else {
                iArr2[i2] = MODE_SHIFT_TO_BYTE_COMPACTION_MODE;
                i = i3 + 1;
                iArr3[i2] = iArr[i3];
                i2++;
            }
            i = i3;
        }
        decodeTextCompaction(iArr2, iArr3, i2, sb);
        return i;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
        r4 = r1;
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c7, code lost:
        r4 = (char) r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00d3, code lost:
        r4 = 0;
        r11 = r3;
        r3 = r1;
        r1 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00de, code lost:
        r4 = ' ';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00eb, code lost:
        if (r4 == 0) goto L_0x00f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00ed, code lost:
        r15.append(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00f0, code lost:
        r0 = r0 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void decodeTextCompaction(int[] r12, int[] r13, int r14, java.lang.StringBuilder r15) {
        /*
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            r2 = 0
            r3 = r1
            r1 = r0
            r0 = 0
        L_0x0008:
            if (r0 >= r14) goto L_0x00f4
            r4 = r12[r0]
            int[] r5 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.AnonymousClass1.$SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode
            int r6 = r1.ordinal()
            r5 = r5[r6]
            r6 = 32
            r7 = 29
            r8 = 26
            r9 = 913(0x391, float:1.28E-42)
            r10 = 900(0x384, float:1.261E-42)
            switch(r5) {
                case 1: goto L_0x00c3;
                case 2: goto L_0x00a3;
                case 3: goto L_0x0077;
                case 4: goto L_0x0057;
                case 5: goto L_0x0042;
                case 6: goto L_0x0023;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x00ea
        L_0x0023:
            if (r4 >= r7) goto L_0x002a
            char[] r1 = PUNCT_CHARS
            char r1 = r1[r4]
            goto L_0x0047
        L_0x002a:
            if (r4 == r7) goto L_0x003e
            if (r4 == r10) goto L_0x003a
            if (r4 == r9) goto L_0x0031
            goto L_0x0037
        L_0x0031:
            r1 = r13[r0]
            char r1 = (char) r1
            r15.append(r1)
        L_0x0037:
            r1 = r3
            goto L_0x00ea
        L_0x003a:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00ea
        L_0x003e:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00ea
        L_0x0042:
            if (r4 >= r8) goto L_0x004b
            int r4 = r4 + 65
            char r1 = (char) r4
        L_0x0047:
            r4 = r1
            r1 = r3
            goto L_0x00eb
        L_0x004b:
            if (r4 == r8) goto L_0x0054
            if (r4 == r10) goto L_0x0050
            goto L_0x0037
        L_0x0050:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00ea
        L_0x0054:
            r1 = r3
            goto L_0x00de
        L_0x0057:
            if (r4 >= r7) goto L_0x005f
            char[] r5 = PUNCT_CHARS
            char r4 = r5[r4]
            goto L_0x00eb
        L_0x005f:
            if (r4 == r7) goto L_0x0073
            if (r4 == r10) goto L_0x006f
            if (r4 == r9) goto L_0x0067
            goto L_0x00ea
        L_0x0067:
            r4 = r13[r0]
            char r4 = (char) r4
            r15.append(r4)
            goto L_0x00ea
        L_0x006f:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00ea
        L_0x0073:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00ea
        L_0x0077:
            r5 = 25
            if (r4 >= r5) goto L_0x0081
            char[] r5 = MIXED_CHARS
            char r4 = r5[r4]
            goto L_0x00eb
        L_0x0081:
            if (r4 == r10) goto L_0x00a0
            if (r4 == r9) goto L_0x0099
            switch(r4) {
                case 25: goto L_0x0095;
                case 26: goto L_0x00de;
                case 27: goto L_0x0091;
                case 28: goto L_0x008d;
                case 29: goto L_0x008a;
                default: goto L_0x0088;
            }
        L_0x0088:
            goto L_0x00ea
        L_0x008a:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
            goto L_0x00d3
        L_0x008d:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00ea
        L_0x0091:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER
            goto L_0x00ea
        L_0x0095:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT
            goto L_0x00ea
        L_0x0099:
            r4 = r13[r0]
            char r4 = (char) r4
            r15.append(r4)
            goto L_0x00ea
        L_0x00a0:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00ea
        L_0x00a3:
            if (r4 >= r8) goto L_0x00a8
            int r4 = r4 + 97
            goto L_0x00c7
        L_0x00a8:
            if (r4 == r10) goto L_0x00c0
            if (r4 == r9) goto L_0x00b9
            switch(r4) {
                case 26: goto L_0x00de;
                case 27: goto L_0x00b6;
                case 28: goto L_0x00b3;
                case 29: goto L_0x00b0;
                default: goto L_0x00af;
            }
        L_0x00af:
            goto L_0x00ea
        L_0x00b0:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
            goto L_0x00d3
        L_0x00b3:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED
            goto L_0x00ea
        L_0x00b6:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA_SHIFT
            goto L_0x00d3
        L_0x00b9:
            r4 = r13[r0]
            char r4 = (char) r4
            r15.append(r4)
            goto L_0x00ea
        L_0x00c0:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00ea
        L_0x00c3:
            if (r4 >= r8) goto L_0x00c9
            int r4 = r4 + 65
        L_0x00c7:
            char r4 = (char) r4
            goto L_0x00eb
        L_0x00c9:
            if (r4 == r10) goto L_0x00e8
            if (r4 == r9) goto L_0x00e1
            switch(r4) {
                case 26: goto L_0x00de;
                case 27: goto L_0x00db;
                case 28: goto L_0x00d8;
                case 29: goto L_0x00d1;
                default: goto L_0x00d0;
            }
        L_0x00d0:
            goto L_0x00ea
        L_0x00d1:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
        L_0x00d3:
            r4 = 0
            r11 = r3
            r3 = r1
            r1 = r11
            goto L_0x00eb
        L_0x00d8:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED
            goto L_0x00ea
        L_0x00db:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER
            goto L_0x00ea
        L_0x00de:
            r4 = 32
            goto L_0x00eb
        L_0x00e1:
            r4 = r13[r0]
            char r4 = (char) r4
            r15.append(r4)
            goto L_0x00ea
        L_0x00e8:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
        L_0x00ea:
            r4 = 0
        L_0x00eb:
            if (r4 == 0) goto L_0x00f0
            r15.append(r4)
        L_0x00f0:
            int r0 = r0 + 1
            goto L_0x0008
        L_0x00f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.decodeTextCompaction(int[], int[], int, java.lang.StringBuilder):void");
    }

    private static int byteCompaction(int i, int[] iArr, Charset charset, int i2, StringBuilder sb) {
        int i3;
        long j;
        int i4;
        int i5;
        int i6 = i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        long j2 = 900;
        int i7 = 6;
        if (i6 == BYTE_COMPACTION_MODE_LATCH) {
            int[] iArr2 = new int[6];
            int i8 = i2 + 1;
            int i9 = iArr[i2];
            boolean z = false;
            while (true) {
                i5 = 0;
                long j3 = 0;
                while (i4 < iArr[0] && !z) {
                    int i10 = i5 + 1;
                    iArr2[i5] = i9;
                    j3 = (j3 * j) + ((long) i9);
                    int i11 = i4 + 1;
                    i9 = iArr[i4];
                    if (i9 != 928) {
                        switch (i9) {
                            case TEXT_COMPACTION_MODE_LATCH /*900*/:
                            case BYTE_COMPACTION_MODE_LATCH /*901*/:
                            case NUMERIC_COMPACTION_MODE_LATCH /*902*/:
                                break;
                            default:
                                switch (i9) {
                                    case MACRO_PDF417_TERMINATOR /*922*/:
                                    case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                                    case BYTE_COMPACTION_MODE_LATCH_6 /*924*/:
                                        break;
                                    default:
                                        if (i10 % 5 != 0 || i10 <= 0) {
                                            z = z;
                                            i4 = i11;
                                            i5 = i10;
                                            j = 900;
                                            i7 = 6;
                                            break;
                                        } else {
                                            int i12 = 0;
                                            while (i12 < i7) {
                                                byteArrayOutputStream.write((byte) ((int) (j3 >> ((5 - i12) * 8))));
                                                i12++;
                                                i7 = 6;
                                                z = z;
                                            }
                                            boolean z2 = z;
                                            i8 = i11;
                                            j2 = 900;
                                        }
                                }
                                break;
                        }
                    }
                    i4 = i11 - 1;
                    i5 = i10;
                    j = 900;
                    i7 = 6;
                    z = true;
                }
            }
            if (i4 == iArr[0] && i9 < TEXT_COMPACTION_MODE_LATCH) {
                iArr2[i5] = i9;
                i5++;
            }
            for (int i13 = 0; i13 < i5; i13++) {
                byteArrayOutputStream.write((byte) iArr2[i13]);
            }
            i3 = i4;
        } else if (i6 != BYTE_COMPACTION_MODE_LATCH_6) {
            i3 = i2;
        } else {
            i3 = i2;
            boolean z3 = false;
            while (true) {
                int i14 = 0;
                long j4 = 0;
                while (i3 < iArr[0] && !z3) {
                    int i15 = i3 + 1;
                    int i16 = iArr[i3];
                    if (i16 < TEXT_COMPACTION_MODE_LATCH) {
                        i14++;
                        j4 = (j4 * 900) + ((long) i16);
                    } else {
                        if (i16 != 928) {
                            switch (i16) {
                                case TEXT_COMPACTION_MODE_LATCH /*900*/:
                                case BYTE_COMPACTION_MODE_LATCH /*901*/:
                                case NUMERIC_COMPACTION_MODE_LATCH /*902*/:
                                    break;
                                default:
                                    switch (i16) {
                                        case MACRO_PDF417_TERMINATOR /*922*/:
                                        case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                                        case BYTE_COMPACTION_MODE_LATCH_6 /*924*/:
                                            break;
                                    }
                            }
                        }
                        i3 = i15 - 1;
                        z3 = true;
                        if (i14 % 5 != 0 && i14 > 0) {
                            for (int i17 = 0; i17 < 6; i17++) {
                                byteArrayOutputStream.write((byte) ((int) (j4 >> ((5 - i17) * 8))));
                            }
                        }
                    }
                    i3 = i15;
                    if (i14 % 5 != 0) {
                    }
                }
            }
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i3;
    }

    private static int numericCompaction(int[] iArr, int i, StringBuilder sb) throws FormatException {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i3 == iArr[0]) {
                z = true;
            }
            if (i4 < TEXT_COMPACTION_MODE_LATCH) {
                iArr2[i2] = i4;
                i2++;
            } else {
                if (!(i4 == TEXT_COMPACTION_MODE_LATCH || i4 == BYTE_COMPACTION_MODE_LATCH || i4 == 928)) {
                    switch (i4) {
                        case MACRO_PDF417_TERMINATOR /*922*/:
                        case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                        case BYTE_COMPACTION_MODE_LATCH_6 /*924*/:
                            break;
                    }
                }
                i3--;
                z = true;
            }
            if ((i2 % 15 == 0 || i4 == NUMERIC_COMPACTION_MODE_LATCH || z) && i2 > 0) {
                sb.append(decodeBase900toBase10(iArr2, i2));
                i2 = 0;
            }
            i = i3;
        }
        return i;
    }

    private static String decodeBase900toBase10(int[] iArr, int i) throws FormatException {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigInteger = bigInteger.add(EXP900[(i - i2) - 1].multiply(BigInteger.valueOf((long) iArr[i2])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }
}

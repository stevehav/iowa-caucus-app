package com.google.zxing.qrcode.decoder;

import com.google.zxing.qrcode.decoder.Version;

final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int i, byte[] bArr) {
        this.numDataCodewords = i;
        this.codewords = bArr;
    }

    static DataBlock[] getDataBlocks(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length == version.getTotalCodewords()) {
            Version.ECBlocks eCBlocksForLevel = version.getECBlocksForLevel(errorCorrectionLevel);
            Version.ECB[] eCBlocks = eCBlocksForLevel.getECBlocks();
            int i = 0;
            for (Version.ECB count : eCBlocks) {
                i += count.getCount();
            }
            DataBlock[] dataBlockArr = new DataBlock[i];
            int length = eCBlocks.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                Version.ECB ecb = eCBlocks[i2];
                int i4 = i3;
                int i5 = 0;
                while (i5 < ecb.getCount()) {
                    int dataCodewords = ecb.getDataCodewords();
                    dataBlockArr[i4] = new DataBlock(dataCodewords, new byte[(eCBlocksForLevel.getECCodewordsPerBlock() + dataCodewords)]);
                    i5++;
                    i4++;
                }
                i2++;
                i3 = i4;
            }
            int length2 = dataBlockArr[0].codewords.length;
            int length3 = dataBlockArr.length - 1;
            while (length3 >= 0 && dataBlockArr[length3].codewords.length != length2) {
                length3--;
            }
            int i6 = length3 + 1;
            int eCCodewordsPerBlock = length2 - eCBlocksForLevel.getECCodewordsPerBlock();
            int i7 = 0;
            int i8 = 0;
            while (i7 < eCCodewordsPerBlock) {
                int i9 = i8;
                int i10 = 0;
                while (i10 < i3) {
                    dataBlockArr[i10].codewords[i7] = bArr[i9];
                    i10++;
                    i9++;
                }
                i7++;
                i8 = i9;
            }
            int i11 = i6;
            while (i11 < i3) {
                dataBlockArr[i11].codewords[eCCodewordsPerBlock] = bArr[i8];
                i11++;
                i8++;
            }
            int length4 = dataBlockArr[0].codewords.length;
            while (eCCodewordsPerBlock < length4) {
                int i12 = i8;
                int i13 = 0;
                while (i13 < i3) {
                    dataBlockArr[i13].codewords[i13 < i6 ? eCCodewordsPerBlock : eCCodewordsPerBlock + 1] = bArr[i12];
                    i13++;
                    i12++;
                }
                eCCodewordsPerBlock++;
                i8 = i12;
            }
            return dataBlockArr;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public int getNumDataCodewords() {
        return this.numDataCodewords;
    }

    /* access modifiers changed from: package-private */
    public byte[] getCodewords() {
        return this.codewords;
    }
}

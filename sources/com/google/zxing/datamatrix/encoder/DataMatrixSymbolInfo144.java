package com.google.zxing.datamatrix.encoder;

import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;

final class DataMatrixSymbolInfo144 extends SymbolInfo {
    public int getDataLengthForInterleavedBlock(int i) {
        return i <= 8 ? NikonType2MakernoteDirectory.TAG_SCENE_ASSIST : NikonType2MakernoteDirectory.TAG_UNKNOWN_10;
    }

    public int getInterleavedBlockCount() {
        return 10;
    }

    DataMatrixSymbolInfo144() {
        super(false, 1558, 620, 22, 22, 36, -1, 62);
    }
}

package com.drew.imaging.png;

import com.drew.lang.SequentialByteArrayReader;
import com.drew.lang.annotations.NotNull;
import java.io.IOException;

public class PngChromaticities {
    private final int _blueX;
    private final int _blueY;
    private final int _greenX;
    private final int _greenY;
    private final int _redX;
    private final int _redY;
    private final int _whitePointX;
    private final int _whitePointY;

    public PngChromaticities(@NotNull byte[] bArr) throws PngProcessingException {
        if (bArr.length == 32) {
            SequentialByteArrayReader sequentialByteArrayReader = new SequentialByteArrayReader(bArr);
            try {
                this._whitePointX = sequentialByteArrayReader.getInt32();
                this._whitePointY = sequentialByteArrayReader.getInt32();
                this._redX = sequentialByteArrayReader.getInt32();
                this._redY = sequentialByteArrayReader.getInt32();
                this._greenX = sequentialByteArrayReader.getInt32();
                this._greenY = sequentialByteArrayReader.getInt32();
                this._blueX = sequentialByteArrayReader.getInt32();
                this._blueY = sequentialByteArrayReader.getInt32();
            } catch (IOException e) {
                throw new PngProcessingException((Throwable) e);
            }
        } else {
            throw new PngProcessingException("Invalid number of bytes");
        }
    }

    public int getWhitePointX() {
        return this._whitePointX;
    }

    public int getWhitePointY() {
        return this._whitePointY;
    }

    public int getRedX() {
        return this._redX;
    }

    public int getRedY() {
        return this._redY;
    }

    public int getGreenX() {
        return this._greenX;
    }

    public int getGreenY() {
        return this._greenY;
    }

    public int getBlueX() {
        return this._blueX;
    }

    public int getBlueY() {
        return this._blueY;
    }
}

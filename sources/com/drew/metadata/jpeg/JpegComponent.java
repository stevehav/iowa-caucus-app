package com.drew.metadata.jpeg;

import com.drew.lang.annotations.NotNull;
import java.io.Serializable;

public class JpegComponent implements Serializable {
    private static final long serialVersionUID = 61121257899091914L;
    private final int _componentId;
    private final int _quantizationTableNumber;
    private final int _samplingFactorByte;

    public JpegComponent(int i, int i2, int i3) {
        this._componentId = i;
        this._samplingFactorByte = i2;
        this._quantizationTableNumber = i3;
    }

    public int getComponentId() {
        return this._componentId;
    }

    @NotNull
    public String getComponentName() {
        int i = this._componentId;
        if (i == 1) {
            return "Y";
        }
        if (i == 2) {
            return "Cb";
        }
        if (i == 3) {
            return "Cr";
        }
        if (i == 4) {
            return "I";
        }
        if (i == 5) {
            return "Q";
        }
        return String.format("Unknown (%s)", new Object[]{Integer.valueOf(i)});
    }

    public int getQuantizationTableNumber() {
        return this._quantizationTableNumber;
    }

    public int getHorizontalSamplingFactor() {
        return (this._samplingFactorByte >> 4) & 15;
    }

    public int getVerticalSamplingFactor() {
        return this._samplingFactorByte & 15;
    }

    @NotNull
    public String toString() {
        return String.format("Quantization table %d, Sampling factors %d horiz/%d vert", new Object[]{Integer.valueOf(this._quantizationTableNumber), Integer.valueOf(getHorizontalSamplingFactor()), Integer.valueOf(getVerticalSamplingFactor())});
    }
}

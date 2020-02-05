package com.drew.metadata.exif.makernotes;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.TagDescriptor;

public class SigmaMakernoteDescriptor extends TagDescriptor<SigmaMakernoteDirectory> {
    public SigmaMakernoteDescriptor(@NotNull SigmaMakernoteDirectory sigmaMakernoteDirectory) {
        super(sigmaMakernoteDirectory);
    }

    public String getDescription(int i) {
        if (i == 8) {
            return getExposureModeDescription();
        }
        if (i != 9) {
            return super.getDescription(i);
        }
        return getMeteringModeDescription();
    }

    @Nullable
    private String getMeteringModeDescription() {
        String string = ((SigmaMakernoteDirectory) this._directory).getString(9);
        if (string == null || string.length() == 0) {
            return null;
        }
        char charAt = string.charAt(0);
        if (charAt == '8') {
            return "Multi Segment";
        }
        if (charAt != 'A') {
            return charAt != 'C' ? string : "Center Weighted Average";
        }
        return "Average";
    }

    @Nullable
    private String getExposureModeDescription() {
        String string = ((SigmaMakernoteDirectory) this._directory).getString(8);
        if (string == null || string.length() == 0) {
            return null;
        }
        char charAt = string.charAt(0);
        if (charAt == 'A') {
            return "Aperture Priority AE";
        }
        if (charAt == 'M') {
            return "Manual";
        }
        if (charAt != 'P') {
            return charAt != 'S' ? string : "Shutter Speed Priority AE";
        }
        return "Program AE";
    }
}

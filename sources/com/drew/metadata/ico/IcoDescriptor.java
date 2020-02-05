package com.drew.metadata.ico;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.TagDescriptor;

public class IcoDescriptor extends TagDescriptor<IcoDirectory> {
    public IcoDescriptor(@NotNull IcoDirectory icoDirectory) {
        super(icoDirectory);
    }

    public String getDescription(int i) {
        if (i == 1) {
            return getImageTypeDescription();
        }
        if (i == 2) {
            return getImageWidthDescription();
        }
        if (i == 3) {
            return getImageHeightDescription();
        }
        if (i != 4) {
            return super.getDescription(i);
        }
        return getColourPaletteSizeDescription();
    }

    @Nullable
    public String getImageTypeDescription() {
        return getIndexedDescription(1, 1, "Icon", "Cursor");
    }

    @Nullable
    public String getImageWidthDescription() {
        Integer integer = ((IcoDirectory) this._directory).getInteger(2);
        if (integer == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(integer.intValue() == 0 ? 256 : integer.intValue());
        sb.append(" pixels");
        return sb.toString();
    }

    @Nullable
    public String getImageHeightDescription() {
        Integer integer = ((IcoDirectory) this._directory).getInteger(3);
        if (integer == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(integer.intValue() == 0 ? 256 : integer.intValue());
        sb.append(" pixels");
        return sb.toString();
    }

    @Nullable
    public String getColourPaletteSizeDescription() {
        Integer integer = ((IcoDirectory) this._directory).getInteger(4);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() == 0) {
            return "No palette";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(integer);
        sb.append(" colour");
        sb.append(integer.intValue() == 1 ? "" : "s");
        return sb.toString();
    }
}

package com.adobe.xmp.options;

public final class ParseOptions extends Options {
    public static final int ACCEPT_LATIN_1 = 16;
    public static final int DISALLOW_DOCTYPE = 64;
    public static final int FIX_CONTROL_CHARS = 8;
    public static final int OMIT_NORMALIZATION = 32;
    public static final int REQUIRE_XMP_META = 1;
    public static final int STRICT_ALIASING = 4;

    public ParseOptions() {
        setOption(88, true);
    }

    /* access modifiers changed from: protected */
    public String defineOptionName(int i) {
        if (i == 1) {
            return "REQUIRE_XMP_META";
        }
        if (i == 4) {
            return "STRICT_ALIASING";
        }
        if (i == 8) {
            return "FIX_CONTROL_CHARS";
        }
        if (i == 16) {
            return "ACCEPT_LATIN_1";
        }
        if (i == 32) {
            return "OMIT_NORMALIZATION";
        }
        if (i != 64) {
            return null;
        }
        return "DISALLOW_DOCTYPE";
    }

    public boolean getAcceptLatin1() {
        return getOption(16);
    }

    public boolean getDisallowDoctype() {
        return getOption(64);
    }

    public boolean getFixControlChars() {
        return getOption(8);
    }

    public boolean getOmitNormalization() {
        return getOption(32);
    }

    public boolean getRequireXMPMeta() {
        return getOption(1);
    }

    public boolean getStrictAliasing() {
        return getOption(4);
    }

    /* access modifiers changed from: protected */
    public int getValidOptions() {
        return 125;
    }

    public ParseOptions setAcceptLatin1(boolean z) {
        setOption(16, z);
        return this;
    }

    public ParseOptions setDisallowDoctype(boolean z) {
        setOption(64, z);
        return this;
    }

    public ParseOptions setFixControlChars(boolean z) {
        setOption(8, z);
        return this;
    }

    public ParseOptions setOmitNormalization(boolean z) {
        setOption(32, z);
        return this;
    }

    public ParseOptions setRequireXMPMeta(boolean z) {
        setOption(1, z);
        return this;
    }

    public ParseOptions setStrictAliasing(boolean z) {
        setOption(4, z);
        return this;
    }
}

package com.adobe.xmp.options;

import com.adobe.xmp.XMPException;

public final class AliasOptions extends Options {
    public static final int PROP_ARRAY = 512;
    public static final int PROP_ARRAY_ALTERNATE = 2048;
    public static final int PROP_ARRAY_ALT_TEXT = 4096;
    public static final int PROP_ARRAY_ORDERED = 1024;
    public static final int PROP_DIRECT = 0;

    public AliasOptions() {
    }

    public AliasOptions(int i) throws XMPException {
        super(i);
    }

    /* access modifiers changed from: protected */
    public String defineOptionName(int i) {
        if (i == 0) {
            return "PROP_DIRECT";
        }
        if (i == 512) {
            return "ARRAY";
        }
        if (i == 1024) {
            return "ARRAY_ORDERED";
        }
        if (i == 2048) {
            return "ARRAY_ALTERNATE";
        }
        if (i != 4096) {
            return null;
        }
        return "ARRAY_ALT_TEXT";
    }

    /* access modifiers changed from: protected */
    public int getValidOptions() {
        return 7680;
    }

    public boolean isArray() {
        return getOption(512);
    }

    public boolean isArrayAltText() {
        return getOption(4096);
    }

    public boolean isArrayAlternate() {
        return getOption(2048);
    }

    public boolean isArrayOrdered() {
        return getOption(1024);
    }

    public boolean isSimple() {
        return getOptions() == 0;
    }

    public AliasOptions setArray(boolean z) {
        setOption(512, z);
        return this;
    }

    public AliasOptions setArrayAltText(boolean z) {
        setOption(7680, z);
        return this;
    }

    public AliasOptions setArrayAlternate(boolean z) {
        setOption(3584, z);
        return this;
    }

    public AliasOptions setArrayOrdered(boolean z) {
        setOption(1536, z);
        return this;
    }

    public PropertyOptions toPropertyOptions() throws XMPException {
        return new PropertyOptions(getOptions());
    }
}

package com.google.android.gms.internal.vision;

import java.io.IOException;

public final class zzjs extends IOException {
    public zzjs(String str) {
        super(str);
    }

    public zzjs(String str, Exception exc) {
        super(str, exc);
    }

    static zzjs zzht() {
        return new zzjs("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzjs zzhu() {
        return new zzjs("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzjs zzhv() {
        return new zzjs("CodedInputStream encountered a malformed varint.");
    }
}

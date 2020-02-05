package com.google.android.gms.internal.clearcut;

import java.io.IOException;

public class zzco extends IOException {
    private zzdo zzkw = null;

    public zzco(String str) {
        super(str);
    }

    static zzco zzbl() {
        return new zzco("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzco zzbm() {
        return new zzco("Protocol message contained an invalid tag (zero).");
    }

    static zzcp zzbn() {
        return new zzcp("Protocol message tag had invalid wire type.");
    }

    static zzco zzbo() {
        return new zzco("Failed to parse the message.");
    }

    static zzco zzbp() {
        return new zzco("Protocol message had invalid UTF-8.");
    }

    public final zzco zzg(zzdo zzdo) {
        this.zzkw = zzdo;
        return this;
    }
}

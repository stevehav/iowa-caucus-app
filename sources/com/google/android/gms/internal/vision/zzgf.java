package com.google.android.gms.internal.vision;

import java.io.IOException;

public class zzgf extends IOException {
    private zzhf zzxq = null;

    public zzgf(String str) {
        super(str);
    }

    public final zzgf zzg(zzhf zzhf) {
        this.zzxq = zzhf;
        return this;
    }

    static zzgf zzfh() {
        return new zzgf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzgf zzfi() {
        return new zzgf("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzgf zzfj() {
        return new zzgf("CodedInputStream encountered a malformed varint.");
    }

    static zzgf zzfk() {
        return new zzgf("Protocol message contained an invalid tag (zero).");
    }

    static zzgf zzfl() {
        return new zzgf("Protocol message end-group tag did not match expected tag.");
    }

    static zzgg zzfm() {
        return new zzgg("Protocol message tag had invalid wire type.");
    }

    static zzgf zzfn() {
        return new zzgf("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    static zzgf zzfo() {
        return new zzgf("Failed to parse the message.");
    }

    static zzgf zzfp() {
        return new zzgf("Protocol message had invalid UTF-8.");
    }
}

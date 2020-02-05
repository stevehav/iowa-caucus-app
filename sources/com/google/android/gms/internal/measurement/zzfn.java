package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public class zzfn extends IOException {
    private zzgn zza = null;

    public zzfn(String str) {
        super(str);
    }

    public final zzfn zza(zzgn zzgn) {
        this.zza = zzgn;
        return this;
    }

    static zzfn zza() {
        return new zzfn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzfn zzb() {
        return new zzfn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzfn zzc() {
        return new zzfn("CodedInputStream encountered a malformed varint.");
    }

    static zzfn zzd() {
        return new zzfn("Protocol message contained an invalid tag (zero).");
    }

    static zzfn zze() {
        return new zzfn("Protocol message end-group tag did not match expected tag.");
    }

    static zzfm zzf() {
        return new zzfm("Protocol message tag had invalid wire type.");
    }

    static zzfn zzg() {
        return new zzfn("Failed to parse the message.");
    }

    static zzfn zzh() {
        return new zzfn("Protocol message had invalid UTF-8.");
    }
}

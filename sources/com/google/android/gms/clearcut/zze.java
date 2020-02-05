package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.clearcut.zzha;
import com.google.android.gms.internal.clearcut.zzr;
import com.google.android.gms.phenotype.ExperimentTokens;
import java.util.Arrays;

@SafeParcelable.Class(creator = "LogEventParcelableCreator")
@SafeParcelable.Reserved({1})
public final class zze extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zze> CREATOR = new zzf();
    public final zzha zzaa;
    @SafeParcelable.Field(id = 2)
    public zzr zzag;
    @SafeParcelable.Field(id = 3)
    public byte[] zzah;
    @SafeParcelable.Field(id = 4)
    private int[] zzai;
    @SafeParcelable.Field(id = 5)
    private String[] zzaj;
    @SafeParcelable.Field(id = 6)
    private int[] zzak;
    @SafeParcelable.Field(id = 7)
    private byte[][] zzal;
    @SafeParcelable.Field(id = 9)
    private ExperimentTokens[] zzam;
    public final ClearcutLogger.zzb zzan;
    public final ClearcutLogger.zzb zzt;
    @SafeParcelable.Field(defaultValue = "true", id = 8)
    private boolean zzz;

    public zze(zzr zzr, zzha zzha, ClearcutLogger.zzb zzb, ClearcutLogger.zzb zzb2, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr, ExperimentTokens[] experimentTokensArr, boolean z) {
        this.zzag = zzr;
        this.zzaa = zzha;
        this.zzt = zzb;
        this.zzan = null;
        this.zzai = iArr;
        this.zzaj = null;
        this.zzak = iArr2;
        this.zzal = null;
        this.zzam = null;
        this.zzz = z;
    }

    @SafeParcelable.Constructor
    zze(@SafeParcelable.Param(id = 2) zzr zzr, @SafeParcelable.Param(id = 3) byte[] bArr, @SafeParcelable.Param(id = 4) int[] iArr, @SafeParcelable.Param(id = 5) String[] strArr, @SafeParcelable.Param(id = 6) int[] iArr2, @SafeParcelable.Param(id = 7) byte[][] bArr2, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) ExperimentTokens[] experimentTokensArr) {
        this.zzag = zzr;
        this.zzah = bArr;
        this.zzai = iArr;
        this.zzaj = strArr;
        this.zzaa = null;
        this.zzt = null;
        this.zzan = null;
        this.zzak = iArr2;
        this.zzal = bArr2;
        this.zzam = experimentTokensArr;
        this.zzz = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zze) {
            zze zze = (zze) obj;
            return Objects.equal(this.zzag, zze.zzag) && Arrays.equals(this.zzah, zze.zzah) && Arrays.equals(this.zzai, zze.zzai) && Arrays.equals(this.zzaj, zze.zzaj) && Objects.equal(this.zzaa, zze.zzaa) && Objects.equal(this.zzt, zze.zzt) && Objects.equal(this.zzan, zze.zzan) && Arrays.equals(this.zzak, zze.zzak) && Arrays.deepEquals(this.zzal, zze.zzal) && Arrays.equals(this.zzam, zze.zzam) && this.zzz == zze.zzz;
        }
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzag, this.zzah, this.zzai, this.zzaj, this.zzaa, this.zzt, this.zzan, this.zzak, this.zzal, this.zzam, Boolean.valueOf(this.zzz));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LogEventParcelable[");
        sb.append(this.zzag);
        sb.append(", LogEventBytes: ");
        byte[] bArr = this.zzah;
        sb.append(bArr == null ? null : new String(bArr));
        sb.append(", TestCodes: ");
        sb.append(Arrays.toString(this.zzai));
        sb.append(", MendelPackages: ");
        sb.append(Arrays.toString(this.zzaj));
        sb.append(", LogEvent: ");
        sb.append(this.zzaa);
        sb.append(", ExtensionProducer: ");
        sb.append(this.zzt);
        sb.append(", VeProducer: ");
        sb.append(this.zzan);
        sb.append(", ExperimentIDs: ");
        sb.append(Arrays.toString(this.zzak));
        sb.append(", ExperimentTokens: ");
        sb.append(Arrays.toString(this.zzal));
        sb.append(", ExperimentTokensParcelables: ");
        sb.append(Arrays.toString(this.zzam));
        sb.append(", AddPhenotypeExperimentTokens: ");
        sb.append(this.zzz);
        sb.append("]");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzag, i, false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzah, false);
        SafeParcelWriter.writeIntArray(parcel, 4, this.zzai, false);
        SafeParcelWriter.writeStringArray(parcel, 5, this.zzaj, false);
        SafeParcelWriter.writeIntArray(parcel, 6, this.zzak, false);
        SafeParcelWriter.writeByteArrayArray(parcel, 7, this.zzal, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzz);
        SafeParcelWriter.writeTypedArray(parcel, 9, this.zzam, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

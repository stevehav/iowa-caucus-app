package com.google.android.gms.phenotype;

import com.google.android.gms.phenotype.PhenotypeFlag;

final /* synthetic */ class zzo implements PhenotypeFlag.zza {
    private final PhenotypeFlag zzat;
    private final zza zzau;

    zzo(PhenotypeFlag phenotypeFlag, zza zza) {
        this.zzat = phenotypeFlag;
        this.zzau = zza;
    }

    public final Object zzh() {
        return this.zzau.zza().get(this.zzat.zzap);
    }
}

package com.google.android.gms.flags;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.flags.Flag;
import java.util.ArrayList;
import java.util.Collection;

public class FlagRegistry {
    private final Collection<Flag> zzg = new ArrayList();
    private final Collection<Flag.StringFlag> zzh = new ArrayList();
    private final Collection<Flag.StringFlag> zzi = new ArrayList();

    public final void zza(Flag flag) {
        this.zzg.add(flag);
    }

    @KeepForSdk
    public static void initialize(Context context) {
        Singletons.zzd().initialize(context);
    }
}

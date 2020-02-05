package com.google.android.gms.flags;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@KeepForSdk
@Retention(RetentionPolicy.SOURCE)
public @interface FlagSource {
    @KeepForSdk
    public static final int G = 0;
}

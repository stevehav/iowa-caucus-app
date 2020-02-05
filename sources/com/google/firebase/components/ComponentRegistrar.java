package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;

@KeepForSdk
/* compiled from: com.google.firebase:firebase-common@@17.1.0 */
public interface ComponentRegistrar {
    @KeepForSdk
    List<Component<?>> getComponents();
}

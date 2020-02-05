package com.google.firebase.events;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* compiled from: com.google.firebase:firebase-common@@17.1.0 */
public interface EventHandler<T> {
    @KeepForSdk
    void handle(Event<T> event);
}

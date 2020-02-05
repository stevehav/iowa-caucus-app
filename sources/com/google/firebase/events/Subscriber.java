package com.google.firebase.events;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.Executor;

@KeepForSdk
/* compiled from: com.google.firebase:firebase-common@@17.1.0 */
public interface Subscriber {
    @KeepForSdk
    <T> void subscribe(Class<T> cls, EventHandler<? super T> eventHandler);

    @KeepForSdk
    <T> void subscribe(Class<T> cls, Executor executor, EventHandler<? super T> eventHandler);

    @KeepForSdk
    <T> void unsubscribe(Class<T> cls, EventHandler<? super T> eventHandler);
}

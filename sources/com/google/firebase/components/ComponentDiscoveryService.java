package com.google.firebase.components;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* compiled from: com.google.firebase:firebase-common@@17.1.0 */
public class ComponentDiscoveryService extends Service {
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }
}

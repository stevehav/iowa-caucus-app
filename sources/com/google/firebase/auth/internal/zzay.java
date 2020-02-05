package com.google.firebase.auth.internal;

import android.content.Intent;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzay {
    @VisibleForTesting
    private static final Map<String, String> zza;

    public static void zza(Intent intent, Status status) {
        SafeParcelableSerializer.serializeToIntentExtra(status, intent, "com.google.firebase.auth.internal.STATUS");
    }

    public static boolean zza(Intent intent) {
        Preconditions.checkNotNull(intent);
        return intent.hasExtra("com.google.firebase.auth.internal.STATUS");
    }

    public static Status zzb(Intent intent) {
        Preconditions.checkNotNull(intent);
        Preconditions.checkArgument(zza(intent));
        return (Status) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "com.google.firebase.auth.internal.STATUS", Status.CREATOR);
    }

    static {
        HashMap hashMap = new HashMap();
        zza = hashMap;
        hashMap.put("auth/invalid-provider-id", "INVALID_PROVIDER_ID");
        zza.put("auth/invalid-cert-hash", "INVALID_CERT_HASH");
        zza.put("auth/network-request-failed", "WEB_NETWORK_REQUEST_FAILED");
        zza.put("auth/web-storage-unsupported", "WEB_STORAGE_UNSUPPORTED");
        zza.put("auth/operation-not-allowed", "OPERATION_NOT_ALLOWED");
    }
}

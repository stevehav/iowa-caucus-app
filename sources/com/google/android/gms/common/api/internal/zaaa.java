package com.google.android.gms.common.api.internal;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collections;
import java.util.Map;

final class zaaa implements OnCompleteListener<Map<zai<?>, String>> {
    private final /* synthetic */ zax zafi;
    private SignInConnectionListener zafj;

    zaaa(zax zax, SignInConnectionListener signInConnectionListener) {
        this.zafi = zax;
        this.zafj = signInConnectionListener;
    }

    /* access modifiers changed from: package-private */
    public final void cancel() {
        this.zafj.onComplete();
    }

    public final void onComplete(@NonNull Task<Map<zai<?>, String>> task) {
        this.zafi.zaeo.lock();
        try {
            if (!this.zafi.zafd) {
                this.zafj.onComplete();
                return;
            }
            if (task.isSuccessful()) {
                Map unused = this.zafi.zaff = new ArrayMap(this.zafi.zaev.size());
                for (zaw zak : this.zafi.zaev.values()) {
                    this.zafi.zaff.put(zak.zak(), ConnectionResult.RESULT_SUCCESS);
                }
            } else if (task.getException() instanceof AvailabilityException) {
                AvailabilityException availabilityException = (AvailabilityException) task.getException();
                if (this.zafi.zafb) {
                    Map unused2 = this.zafi.zaff = new ArrayMap(this.zafi.zaev.size());
                    for (zaw zaw : this.zafi.zaev.values()) {
                        zai zak2 = zaw.zak();
                        ConnectionResult connectionResult = availabilityException.getConnectionResult(zaw);
                        if (this.zafi.zaa((zaw<?>) zaw, connectionResult)) {
                            this.zafi.zaff.put(zak2, new ConnectionResult(16));
                        } else {
                            this.zafi.zaff.put(zak2, connectionResult);
                        }
                    }
                } else {
                    Map unused3 = this.zafi.zaff = availabilityException.zaj();
                }
            } else {
                Log.e("ConnectionlessGAC", "Unexpected availability exception", task.getException());
                Map unused4 = this.zafi.zaff = Collections.emptyMap();
            }
            if (this.zafi.isConnected()) {
                this.zafi.zafe.putAll(this.zafi.zaff);
                if (this.zafi.zaaf() == null) {
                    this.zafi.zaad();
                    this.zafi.zaae();
                    this.zafi.zaez.signalAll();
                }
            }
            this.zafj.onComplete();
            this.zafi.zaeo.unlock();
        } finally {
            this.zafi.zaeo.unlock();
        }
    }
}

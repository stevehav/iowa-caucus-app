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

final class zaz implements OnCompleteListener<Map<zai<?>, String>> {
    private final /* synthetic */ zax zafi;

    private zaz(zax zax) {
        this.zafi = zax;
    }

    public final void onComplete(@NonNull Task<Map<zai<?>, String>> task) {
        this.zafi.zaeo.lock();
        try {
            if (this.zafi.zafd) {
                if (task.isSuccessful()) {
                    Map unused = this.zafi.zafe = new ArrayMap(this.zafi.zaeu.size());
                    for (zaw zak : this.zafi.zaeu.values()) {
                        this.zafi.zafe.put(zak.zak(), ConnectionResult.RESULT_SUCCESS);
                    }
                } else if (task.getException() instanceof AvailabilityException) {
                    AvailabilityException availabilityException = (AvailabilityException) task.getException();
                    if (this.zafi.zafb) {
                        Map unused2 = this.zafi.zafe = new ArrayMap(this.zafi.zaeu.size());
                        for (zaw zaw : this.zafi.zaeu.values()) {
                            zai zak2 = zaw.zak();
                            ConnectionResult connectionResult = availabilityException.getConnectionResult(zaw);
                            if (this.zafi.zaa((zaw<?>) zaw, connectionResult)) {
                                this.zafi.zafe.put(zak2, new ConnectionResult(16));
                            } else {
                                this.zafi.zafe.put(zak2, connectionResult);
                            }
                        }
                    } else {
                        Map unused3 = this.zafi.zafe = availabilityException.zaj();
                    }
                    ConnectionResult unused4 = this.zafi.zafh = this.zafi.zaaf();
                } else {
                    Log.e("ConnectionlessGAC", "Unexpected availability exception", task.getException());
                    Map unused5 = this.zafi.zafe = Collections.emptyMap();
                    ConnectionResult unused6 = this.zafi.zafh = new ConnectionResult(8);
                }
                if (this.zafi.zaff != null) {
                    this.zafi.zafe.putAll(this.zafi.zaff);
                    ConnectionResult unused7 = this.zafi.zafh = this.zafi.zaaf();
                }
                if (this.zafi.zafh == null) {
                    this.zafi.zaad();
                    this.zafi.zaae();
                } else {
                    boolean unused8 = this.zafi.zafd = false;
                    this.zafi.zaex.zac(this.zafi.zafh);
                }
                this.zafi.zaez.signalAll();
                this.zafi.zaeo.unlock();
            }
        } finally {
            this.zafi.zaeo.unlock();
        }
    }
}

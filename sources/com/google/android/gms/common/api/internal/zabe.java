package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zabe implements zabs, zar {
    private final Context mContext;
    private final Api.AbstractClientBuilder<? extends zad, SignInOptions> zace;
    final zaaw zaee;
    /* access modifiers changed from: private */
    public final Lock zaeo;
    private final ClientSettings zaet;
    private final Map<Api<?>, Boolean> zaew;
    private final GoogleApiAvailabilityLight zaey;
    final Map<Api.AnyClientKey<?>, Api.Client> zagz;
    private final Condition zahn;
    private final zabg zaho;
    final Map<Api.AnyClientKey<?>, ConnectionResult> zahp = new HashMap();
    /* access modifiers changed from: private */
    public volatile zabd zahq;
    private ConnectionResult zahr = null;
    int zahs;
    final zabt zaht;

    public zabe(Context context, zaaw zaaw, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, ArrayList<zaq> arrayList, zabt zabt) {
        this.mContext = context;
        this.zaeo = lock;
        this.zaey = googleApiAvailabilityLight;
        this.zagz = map;
        this.zaet = clientSettings;
        this.zaew = map2;
        this.zace = abstractClientBuilder;
        this.zaee = zaaw;
        this.zaht = zabt;
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            ((zaq) obj).zaa(this);
        }
        this.zaho = new zabg(this, looper);
        this.zahn = lock.newCondition();
        this.zahq = new zaav(this);
    }

    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        return false;
    }

    public final void maybeSignOut() {
    }

    @GuardedBy("mLock")
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(@NonNull T t) {
        t.zau();
        return this.zahq.enqueue(t);
    }

    @GuardedBy("mLock")
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(@NonNull T t) {
        t.zau();
        return this.zahq.execute(t);
    }

    @GuardedBy("mLock")
    public final void connect() {
        this.zahq.connect();
    }

    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect() {
        connect();
        while (isConnecting()) {
            try {
                this.zahn.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, (PendingIntent) null);
            }
        }
        if (isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.zahr;
        if (connectionResult != null) {
            return connectionResult;
        }
        return new ConnectionResult(13, (PendingIntent) null);
    }

    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        connect();
        long nanos = timeUnit.toNanos(j);
        while (isConnecting()) {
            if (nanos <= 0) {
                try {
                    disconnect();
                    return new ConnectionResult(14, (PendingIntent) null);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return new ConnectionResult(15, (PendingIntent) null);
                }
            } else {
                nanos = this.zahn.awaitNanos(nanos);
            }
        }
        if (isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.zahr;
        if (connectionResult != null) {
            return connectionResult;
        }
        return new ConnectionResult(13, (PendingIntent) null);
    }

    @GuardedBy("mLock")
    public final void disconnect() {
        if (this.zahq.disconnect()) {
            this.zahp.clear();
        }
    }

    @GuardedBy("mLock")
    @Nullable
    public final ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        Api.AnyClientKey<?> clientKey = api.getClientKey();
        if (!this.zagz.containsKey(clientKey)) {
            return null;
        }
        if (this.zagz.get(clientKey).isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        if (this.zahp.containsKey(clientKey)) {
            return this.zahp.get(clientKey);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void zaaz() {
        this.zaeo.lock();
        try {
            this.zahq = new zaak(this, this.zaet, this.zaew, this.zaey, this.zace, this.zaeo, this.mContext);
            this.zahq.begin();
            this.zahn.signalAll();
        } finally {
            this.zaeo.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zaba() {
        this.zaeo.lock();
        try {
            this.zaee.zaaw();
            this.zahq = new zaah(this);
            this.zahq.begin();
            this.zahn.signalAll();
        } finally {
            this.zaeo.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zaf(ConnectionResult connectionResult) {
        this.zaeo.lock();
        try {
            this.zahr = connectionResult;
            this.zahq = new zaav(this);
            this.zahq.begin();
            this.zahn.signalAll();
        } finally {
            this.zaeo.unlock();
        }
    }

    public final boolean isConnected() {
        return this.zahq instanceof zaah;
    }

    public final boolean isConnecting() {
        return this.zahq instanceof zaak;
    }

    @GuardedBy("mLock")
    public final void zaw() {
        if (isConnected()) {
            ((zaah) this.zahq).zaam();
        }
    }

    public final void zaa(@NonNull ConnectionResult connectionResult, @NonNull Api<?> api, boolean z) {
        this.zaeo.lock();
        try {
            this.zahq.zaa(connectionResult, api, z);
        } finally {
            this.zaeo.unlock();
        }
    }

    public final void onConnected(@Nullable Bundle bundle) {
        this.zaeo.lock();
        try {
            this.zahq.onConnected(bundle);
        } finally {
            this.zaeo.unlock();
        }
    }

    public final void onConnectionSuspended(int i) {
        this.zaeo.lock();
        try {
            this.zahq.onConnectionSuspended(i);
        } finally {
            this.zaeo.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zaa(zabf zabf) {
        this.zaho.sendMessage(this.zaho.obtainMessage(1, zabf));
    }

    /* access modifiers changed from: package-private */
    public final void zab(RuntimeException runtimeException) {
        this.zaho.sendMessage(this.zaho.obtainMessage(2, runtimeException));
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append(str).append("mState=").println(this.zahq);
        for (Api next : this.zaew.keySet()) {
            printWriter.append(str).append(next.getName()).println(":");
            this.zagz.get(next.getClientKey()).dump(concat, fileDescriptor, printWriter, strArr);
        }
    }
}

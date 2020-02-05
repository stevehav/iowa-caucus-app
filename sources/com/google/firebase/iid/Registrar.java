package com.google.firebase.iid;

import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

@KeepForSdk
@Keep
public final class Registrar implements ComponentRegistrar {
    @Keep
    public final List<Component<?>> getComponents() {
        return Arrays.asList(new Component[]{Component.builder(FirebaseInstanceId.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(Subscriber.class)).add(Dependency.required(UserAgentPublisher.class)).factory(zzap.zzcr).alwaysEager().build(), Component.builder(FirebaseInstanceIdInternal.class).add(Dependency.required(FirebaseInstanceId.class)).factory(zzao.zzcr).build(), LibraryVersionComponent.create("fire-iid", "18.0.0")});
    }

    private static class zza implements FirebaseInstanceIdInternal {
        private final FirebaseInstanceId zzct;

        public zza(FirebaseInstanceId firebaseInstanceId) {
            this.zzct = firebaseInstanceId;
        }

        public final String getId() {
            return this.zzct.getId();
        }

        public final String getToken() {
            return this.zzct.getToken();
        }
    }
}

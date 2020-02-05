package com.google.firebase.iid;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.io.IOException;

final class zzt implements Continuation<Bundle, String> {
    private final /* synthetic */ zzs zzbs;

    zzt(zzs zzs) {
        this.zzbs = zzs;
    }

    public final /* synthetic */ Object then(@NonNull Task task) throws Exception {
        return zzs.zza((Bundle) task.getResult(IOException.class));
    }
}

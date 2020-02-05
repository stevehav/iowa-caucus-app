package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Result;

public interface ResultCallback<R extends Result> {
    void onResult(@NonNull R r);
}

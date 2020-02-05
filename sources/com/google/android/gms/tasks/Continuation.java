package com.google.android.gms.tasks;

import androidx.annotation.NonNull;

public interface Continuation<TResult, TContinuationResult> {
    TContinuationResult then(@NonNull Task<TResult> task) throws Exception;
}

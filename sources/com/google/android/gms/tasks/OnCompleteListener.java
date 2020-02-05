package com.google.android.gms.tasks;

import androidx.annotation.NonNull;

public interface OnCompleteListener<TResult> {
    void onComplete(@NonNull Task<TResult> task);
}

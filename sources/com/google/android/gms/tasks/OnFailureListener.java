package com.google.android.gms.tasks;

import androidx.annotation.NonNull;

public interface OnFailureListener {
    void onFailure(@NonNull Exception exc);
}

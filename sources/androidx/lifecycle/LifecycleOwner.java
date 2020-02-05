package androidx.lifecycle;

import androidx.annotation.NonNull;

public interface LifecycleOwner {
    @NonNull
    Lifecycle getLifecycle();
}

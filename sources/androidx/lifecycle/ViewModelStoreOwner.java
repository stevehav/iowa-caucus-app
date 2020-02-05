package androidx.lifecycle;

import androidx.annotation.NonNull;

public interface ViewModelStoreOwner {
    @NonNull
    ViewModelStore getViewModelStore();
}

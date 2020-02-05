package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;

interface ViewGroupOverlayImpl extends ViewOverlayImpl {
    void add(@NonNull View view);

    void remove(@NonNull View view);
}

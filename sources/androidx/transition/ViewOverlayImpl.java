package androidx.transition;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

interface ViewOverlayImpl {
    void add(@NonNull Drawable drawable);

    void remove(@NonNull Drawable drawable);
}

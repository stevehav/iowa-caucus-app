package androidx.appcompat.widget;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface WithHint {
    @Nullable
    CharSequence getHint();
}

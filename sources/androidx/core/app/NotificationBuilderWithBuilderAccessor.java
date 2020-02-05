package androidx.core.app;

import android.app.Notification;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface NotificationBuilderWithBuilderAccessor {
    Notification.Builder getBuilder();
}

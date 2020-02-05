package android.support.v4.media.session;

import android.media.session.MediaSession;
import androidx.annotation.RequiresApi;

@RequiresApi(22)
class MediaSessionCompatApi22 {
    public static void setRatingType(Object obj, int i) {
        ((MediaSession) obj).setRatingType(i);
    }

    private MediaSessionCompatApi22() {
    }
}

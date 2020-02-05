package com.google.firebase.storage.internal;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import java.io.UnsupportedEncodingException;

/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
public class Slashes {
    @NonNull
    public static String preserveSlashEncode(@Nullable String str) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return slashize(Uri.encode(str));
    }

    @NonNull
    public static String slashize(@NonNull String str) {
        Preconditions.checkNotNull(str);
        return str.replace("%2F", "/");
    }

    @NonNull
    public static String unSlashize(@NonNull String str) {
        Preconditions.checkNotNull(str);
        return str.replace("/", "%2F");
    }

    @NonNull
    public static String normalizeSlashes(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!str.startsWith("/") && !str.endsWith("/") && !str.contains("//")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : str.split("/", -1)) {
            if (!TextUtils.isEmpty(str2)) {
                if (sb.length() > 0) {
                    sb.append("/");
                    sb.append(str2);
                } else {
                    sb.append(str2);
                }
            }
        }
        return sb.toString();
    }
}

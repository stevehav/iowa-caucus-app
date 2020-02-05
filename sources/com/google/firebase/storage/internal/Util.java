package com.google.firebase.storage.internal;

import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.storage.network.NetworkRequest;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
public class Util {
    public static final String ISO_8601_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    private static final int MAXIMUM_TOKEN_WAIT_TIME_MS = 30000;
    public static final int NETWORK_UNAVAILABLE = -2;
    private static final String TAG = "StorageUtil";

    public static long parseDateTime(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        String replaceAll = str.replaceAll("Z$", "-0000");
        try {
            return new SimpleDateFormat(ISO_8601_FORMAT, Locale.getDefault()).parse(replaceAll).getTime();
        } catch (ParseException e) {
            Log.w(TAG, "unable to parse datetime:" + replaceAll, e);
            return 0;
        }
    }

    public static boolean equals(@Nullable Object obj, @Nullable Object obj2) {
        return Objects.equal(obj, obj2);
    }

    private static String getAuthority() throws RemoteException {
        return NetworkRequest.getAuthority();
    }

    @Nullable
    public static Uri normalize(@NonNull FirebaseApp firebaseApp, @Nullable String str) throws UnsupportedEncodingException {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.toLowerCase().startsWith("gs://")) {
            String preserveSlashEncode = Slashes.preserveSlashEncode(Slashes.normalizeSlashes(str.substring(5)));
            return Uri.parse("gs://" + preserveSlashEncode);
        }
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (scheme == null || (!equals(scheme.toLowerCase(), UriUtil.HTTP_SCHEME) && !equals(scheme.toLowerCase(), UriUtil.HTTPS_SCHEME))) {
            Log.w(TAG, "FirebaseStorage is unable to support the scheme:" + scheme);
            throw new IllegalArgumentException("Uri scheme");
        }
        try {
            int indexOf = parse.getAuthority().toLowerCase().indexOf(getAuthority());
            String slashize = Slashes.slashize(parse.getEncodedPath());
            if (indexOf == 0 && slashize.startsWith("/")) {
                int indexOf2 = slashize.indexOf("/b/", 0);
                int i = indexOf2 + 3;
                int indexOf3 = slashize.indexOf("/", i);
                int indexOf4 = slashize.indexOf("/o/", 0);
                if (indexOf2 == -1 || indexOf3 == -1) {
                    Log.w(TAG, "Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
                    throw new IllegalArgumentException("Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
                }
                str2 = slashize.substring(i, indexOf3);
                slashize = indexOf4 != -1 ? slashize.substring(indexOf4 + 3) : "";
            } else if (indexOf > 1) {
                str2 = parse.getAuthority().substring(0, indexOf - 1);
            } else {
                Log.w(TAG, "Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
                throw new IllegalArgumentException("Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
            }
            Preconditions.checkNotEmpty(str2, "No bucket specified");
            return new Uri.Builder().scheme("gs").authority(str2).encodedPath(slashize).build();
        } catch (RemoteException unused) {
            throw new UnsupportedEncodingException("Could not parse Url because the Storage network layer did not load");
        }
    }

    @Nullable
    public static String getCurrentAuthToken(@Nullable InternalAuthProvider internalAuthProvider) {
        String str;
        if (internalAuthProvider != null) {
            try {
                str = ((GetTokenResult) Tasks.await(internalAuthProvider.getAccessToken(false), 30000, TimeUnit.MILLISECONDS)).getToken();
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                Log.e(TAG, "error getting token " + e);
            }
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        Log.w(TAG, "no auth token for request");
        return null;
    }
}

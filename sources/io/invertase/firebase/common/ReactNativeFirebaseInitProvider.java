package io.invertase.firebase.common;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.Nullable;
import io.invertase.firebase.app.ReactNativeFirebaseApp;
import io.invertase.firebase.interfaces.InitProvider;
import javax.annotation.OverridingMethodsMustInvokeSuper;

public class ReactNativeFirebaseInitProvider extends ContentProvider implements InitProvider {
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Nullable
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Nullable
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private static void checkContentProviderAuthority(ProviderInfo providerInfo, String str) {
        if (providerInfo != null && str.equals(providerInfo.authority)) {
            throw new IllegalStateException("Incorrect provider authority in manifest. This is most likely due to a missing applicationId variable in application's build.gradle.");
        }
    }

    public String getEmptyProviderAuthority() {
        throw new RuntimeException("STUB: getEmptyProviderAuthority override not implemented");
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        checkContentProviderAuthority(providerInfo, getEmptyProviderAuthority());
        super.attachInfo(context, providerInfo);
    }

    @OverridingMethodsMustInvokeSuper
    public boolean onCreate() {
        if (ReactNativeFirebaseApp.getApplicationContext() != null) {
            return false;
        }
        Context context = getContext();
        if (!(context == null || context.getApplicationContext() == null)) {
            context = context.getApplicationContext();
        }
        ReactNativeFirebaseApp.setApplicationContext(context);
        return false;
    }
}

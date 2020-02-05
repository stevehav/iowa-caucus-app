package com.facebook.react.modules.blob;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.Nullable;

public final class BlobProvider extends ContentProvider {
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

    public boolean onCreate() {
        return true;
    }

    @Nullable
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004d, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0052, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0053, code lost:
        r3 = r6;
        r6 = r5;
        r5 = r3;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.os.ParcelFileDescriptor openFile(android.net.Uri r5, java.lang.String r6) throws java.io.FileNotFoundException {
        /*
            r4 = this;
            java.lang.String r0 = "r"
            boolean r0 = r6.equals(r0)
            java.lang.String r1 = "Cannot open "
            if (r0 == 0) goto L_0x0087
            android.content.Context r6 = r4.getContext()
            android.content.Context r6 = r6.getApplicationContext()
            boolean r0 = r6 instanceof com.facebook.react.ReactApplication
            r2 = 0
            if (r0 == 0) goto L_0x002e
            com.facebook.react.ReactApplication r6 = (com.facebook.react.ReactApplication) r6
            com.facebook.react.ReactNativeHost r6 = r6.getReactNativeHost()
            com.facebook.react.ReactInstanceManager r6 = r6.getReactInstanceManager()
            com.facebook.react.bridge.ReactContext r6 = r6.getCurrentReactContext()
            java.lang.Class<com.facebook.react.modules.blob.BlobModule> r0 = com.facebook.react.modules.blob.BlobModule.class
            com.facebook.react.bridge.NativeModule r6 = r6.getNativeModule(r0)
            com.facebook.react.modules.blob.BlobModule r6 = (com.facebook.react.modules.blob.BlobModule) r6
            goto L_0x002f
        L_0x002e:
            r6 = r2
        L_0x002f:
            if (r6 == 0) goto L_0x007f
            byte[] r6 = r6.resolve((android.net.Uri) r5)
            if (r6 == 0) goto L_0x0061
            android.os.ParcelFileDescriptor[] r5 = android.os.ParcelFileDescriptor.createPipe()     // Catch:{ IOException -> 0x0060 }
            r0 = 0
            r0 = r5[r0]
            r1 = 1
            r5 = r5[r1]
            android.os.ParcelFileDescriptor$AutoCloseOutputStream r1 = new android.os.ParcelFileDescriptor$AutoCloseOutputStream     // Catch:{  }
            r1.<init>(r5)     // Catch:{  }
            r1.write(r6)     // Catch:{ Throwable -> 0x0050, all -> 0x004d }
            r1.close()     // Catch:{  }
            return r0
        L_0x004d:
            r5 = move-exception
            r6 = r2
            goto L_0x0056
        L_0x0050:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0052 }
        L_0x0052:
            r6 = move-exception
            r3 = r6
            r6 = r5
            r5 = r3
        L_0x0056:
            if (r6 == 0) goto L_0x005c
            r1.close()     // Catch:{ Throwable -> 0x005f }
            goto L_0x005f
        L_0x005c:
            r1.close()     // Catch:{  }
        L_0x005f:
            throw r5     // Catch:{  }
        L_0x0060:
            return r2
        L_0x0061:
            java.io.FileNotFoundException r6 = new java.io.FileNotFoundException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r5 = r5.toString()
            r0.append(r5)
            java.lang.String r5 = ", blob not found."
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r6.<init>(r5)
            throw r6
        L_0x007f:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.String r6 = "No blob module associated with BlobProvider"
            r5.<init>(r6)
            throw r5
        L_0x0087:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r5 = r5.toString()
            r2.append(r5)
            java.lang.String r5 = " in mode '"
            r2.append(r5)
            r2.append(r6)
            java.lang.String r5 = "'"
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.blob.BlobProvider.openFile(android.net.Uri, java.lang.String):android.os.ParcelFileDescriptor");
    }
}

package com.reactnativecommunity.cameraroll;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.annotation.Nullable;

@ReactModule(name = "RNCCameraRoll")
public class CameraRollModule extends ReactContextBaseJavaModule {
    private static final String ASSET_TYPE_ALL = "All";
    private static final String ASSET_TYPE_PHOTOS = "Photos";
    private static final String ASSET_TYPE_VIDEOS = "Videos";
    private static final String ERROR_UNABLE_TO_DELETE = "E_UNABLE_TO_DELETE";
    private static final String ERROR_UNABLE_TO_FILTER = "E_UNABLE_TO_FILTER";
    private static final String ERROR_UNABLE_TO_LOAD = "E_UNABLE_TO_LOAD";
    private static final String ERROR_UNABLE_TO_LOAD_PERMISSION = "E_UNABLE_TO_LOAD_PERMISSION";
    private static final String ERROR_UNABLE_TO_SAVE = "E_UNABLE_TO_SAVE";
    public static final String NAME = "RNCCameraRoll";
    /* access modifiers changed from: private */
    public static final String[] PROJECTION = {"_id", "mime_type", "bucket_display_name", "datetaken", "width", "height", "longitude", "latitude", "_data"};
    private static final String SELECTION_BUCKET = "bucket_display_name = ?";
    private static final String SELECTION_DATE_TAKEN = "datetaken < ?";

    public String getName() {
        return NAME;
    }

    public CameraRollModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void saveToCameraRoll(String str, ReadableMap readableMap, Promise promise) {
        new SaveToCameraRoll(getReactApplicationContext(), Uri.parse(str), readableMap, promise).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    private static class SaveToCameraRoll extends GuardedAsyncTask<Void, Void> {
        private final Context mContext;
        private final ReadableMap mOptions;
        /* access modifiers changed from: private */
        public final Promise mPromise;
        private final Uri mUri;

        public SaveToCameraRoll(ReactContext reactContext, Uri uri, ReadableMap readableMap, Promise promise) {
            super(reactContext);
            this.mContext = reactContext;
            this.mUri = uri;
            this.mPromise = promise;
            this.mOptions = readableMap;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x0145 A[SYNTHETIC, Splitter:B:71:0x0145] */
        /* JADX WARNING: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void doInBackgroundGuarded(java.lang.Void... r20) {
            /*
                r19 = this;
                r1 = r19
                java.lang.String r0 = "album"
                java.lang.String r2 = ""
                java.lang.String r3 = "Could not close output channel"
                java.lang.String r4 = "Could not close input channel"
                java.lang.String r5 = "ReactNative"
                java.io.File r6 = new java.io.File
                android.net.Uri r7 = r1.mUri
                java.lang.String r7 = r7.getPath()
                r6.<init>(r7)
                r7 = 0
                java.lang.String r8 = "mov"
                com.facebook.react.bridge.ReadableMap r9 = r1.mOptions     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                java.lang.String r10 = "type"
                java.lang.String r9 = r9.getString(r10)     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                boolean r8 = r8.equals(r9)     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                if (r8 == 0) goto L_0x002f
                java.lang.String r8 = android.os.Environment.DIRECTORY_MOVIES     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                java.io.File r8 = android.os.Environment.getExternalStoragePublicDirectory(r8)     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                goto L_0x0035
            L_0x002f:
                java.lang.String r8 = android.os.Environment.DIRECTORY_PICTURES     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                java.io.File r8 = android.os.Environment.getExternalStoragePublicDirectory(r8)     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
            L_0x0035:
                com.facebook.react.bridge.ReadableMap r9 = r1.mOptions     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                java.lang.String r9 = r9.getString(r0)     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                boolean r9 = r2.equals(r9)     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                java.lang.String r10 = "E_UNABLE_TO_LOAD"
                if (r9 != 0) goto L_0x0063
                java.io.File r9 = new java.io.File     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                com.facebook.react.bridge.ReadableMap r11 = r1.mOptions     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                java.lang.String r0 = r11.getString(r0)     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                r9.<init>(r8, r0)     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                boolean r0 = r9.exists()     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                if (r0 != 0) goto L_0x0062
                boolean r0 = r9.mkdirs()     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                if (r0 != 0) goto L_0x0062
                com.facebook.react.bridge.Promise r0 = r1.mPromise     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                java.lang.String r2 = "Album Directory not created. Did you request WRITE_EXTERNAL_STORAGE?"
                r0.reject((java.lang.String) r10, (java.lang.String) r2)     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                return
            L_0x0062:
                r8 = r9
            L_0x0063:
                boolean r0 = r8.isDirectory()     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                if (r0 != 0) goto L_0x0071
                com.facebook.react.bridge.Promise r0 = r1.mPromise     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                java.lang.String r2 = "External media storage directory not available"
                r0.reject((java.lang.String) r10, (java.lang.String) r2)     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                return
            L_0x0071:
                java.io.File r0 = new java.io.File     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                java.lang.String r9 = r6.getName()     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                r0.<init>(r8, r9)     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                java.lang.String r9 = r6.getName()     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                r10 = 46
                int r11 = r9.indexOf(r10)     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                r12 = 0
                if (r11 < 0) goto L_0x009a
                int r2 = r9.lastIndexOf(r10)     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                java.lang.String r2 = r9.substring(r12, r2)     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                int r10 = r9.lastIndexOf(r10)     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                java.lang.String r9 = r9.substring(r10)     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                r10 = r9
                r9 = r2
                goto L_0x009b
            L_0x009a:
                r10 = r2
            L_0x009b:
                r2 = 0
            L_0x009c:
                boolean r11 = r0.createNewFile()     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                if (r11 != 0) goto L_0x00c2
                java.io.File r0 = new java.io.File     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                r11.<init>()     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                r11.append(r9)     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                java.lang.String r13 = "_"
                r11.append(r13)     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                int r13 = r2 + 1
                r11.append(r2)     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                r11.append(r10)     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                java.lang.String r2 = r11.toString()     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                r0.<init>(r8, r2)     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                r2 = r13
                goto L_0x009c
            L_0x00c2:
                java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                r2.<init>(r6)     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                java.nio.channels.FileChannel r2 = r2.getChannel()     // Catch:{ IOException -> 0x0125, all -> 0x0121 }
                java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x011d, all -> 0x0119 }
                r6.<init>(r0)     // Catch:{ IOException -> 0x011d, all -> 0x0119 }
                java.nio.channels.FileChannel r6 = r6.getChannel()     // Catch:{ IOException -> 0x011d, all -> 0x0119 }
                r15 = 0
                long r17 = r2.size()     // Catch:{ IOException -> 0x0117, all -> 0x0115 }
                r13 = r6
                r14 = r2
                r13.transferFrom(r14, r15, r17)     // Catch:{ IOException -> 0x0117, all -> 0x0115 }
                r2.close()     // Catch:{ IOException -> 0x0117, all -> 0x0115 }
                r6.close()     // Catch:{ IOException -> 0x0117, all -> 0x0115 }
                android.content.Context r8 = r1.mContext     // Catch:{ IOException -> 0x0117, all -> 0x0115 }
                r9 = 1
                java.lang.String[] r9 = new java.lang.String[r9]     // Catch:{ IOException -> 0x0117, all -> 0x0115 }
                java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ IOException -> 0x0117, all -> 0x0115 }
                r9[r12] = r0     // Catch:{ IOException -> 0x0117, all -> 0x0115 }
                com.reactnativecommunity.cameraroll.CameraRollModule$SaveToCameraRoll$1 r0 = new com.reactnativecommunity.cameraroll.CameraRollModule$SaveToCameraRoll$1     // Catch:{ IOException -> 0x0117, all -> 0x0115 }
                r0.<init>()     // Catch:{ IOException -> 0x0117, all -> 0x0115 }
                android.media.MediaScannerConnection.scanFile(r8, r9, r7, r0)     // Catch:{ IOException -> 0x0117, all -> 0x0115 }
                if (r2 == 0) goto L_0x0109
                boolean r0 = r2.isOpen()
                if (r0 == 0) goto L_0x0109
                r2.close()     // Catch:{ IOException -> 0x0104 }
                goto L_0x0109
            L_0x0104:
                r0 = move-exception
                r2 = r0
                com.facebook.common.logging.FLog.e((java.lang.String) r5, (java.lang.String) r4, (java.lang.Throwable) r2)
            L_0x0109:
                if (r6 == 0) goto L_0x014e
                boolean r0 = r6.isOpen()
                if (r0 == 0) goto L_0x014e
                r6.close()     // Catch:{ IOException -> 0x0149 }
                goto L_0x014e
            L_0x0115:
                r0 = move-exception
                goto L_0x011b
            L_0x0117:
                r0 = move-exception
                goto L_0x011f
            L_0x0119:
                r0 = move-exception
                r6 = r7
            L_0x011b:
                r7 = r2
                goto L_0x0150
            L_0x011d:
                r0 = move-exception
                r6 = r7
            L_0x011f:
                r7 = r2
                goto L_0x0127
            L_0x0121:
                r0 = move-exception
                r2 = r0
                r6 = r7
                goto L_0x0151
            L_0x0125:
                r0 = move-exception
                r6 = r7
            L_0x0127:
                com.facebook.react.bridge.Promise r2 = r1.mPromise     // Catch:{ all -> 0x014f }
                r2.reject((java.lang.Throwable) r0)     // Catch:{ all -> 0x014f }
                if (r7 == 0) goto L_0x013d
                boolean r0 = r7.isOpen()
                if (r0 == 0) goto L_0x013d
                r7.close()     // Catch:{ IOException -> 0x0138 }
                goto L_0x013d
            L_0x0138:
                r0 = move-exception
                r2 = r0
                com.facebook.common.logging.FLog.e((java.lang.String) r5, (java.lang.String) r4, (java.lang.Throwable) r2)
            L_0x013d:
                if (r6 == 0) goto L_0x014e
                boolean r0 = r6.isOpen()
                if (r0 == 0) goto L_0x014e
                r6.close()     // Catch:{ IOException -> 0x0149 }
                goto L_0x014e
            L_0x0149:
                r0 = move-exception
                r2 = r0
                com.facebook.common.logging.FLog.e((java.lang.String) r5, (java.lang.String) r3, (java.lang.Throwable) r2)
            L_0x014e:
                return
            L_0x014f:
                r0 = move-exception
            L_0x0150:
                r2 = r0
            L_0x0151:
                if (r7 == 0) goto L_0x0162
                boolean r0 = r7.isOpen()
                if (r0 == 0) goto L_0x0162
                r7.close()     // Catch:{ IOException -> 0x015d }
                goto L_0x0162
            L_0x015d:
                r0 = move-exception
                r7 = r0
                com.facebook.common.logging.FLog.e((java.lang.String) r5, (java.lang.String) r4, (java.lang.Throwable) r7)
            L_0x0162:
                if (r6 == 0) goto L_0x0173
                boolean r0 = r6.isOpen()
                if (r0 == 0) goto L_0x0173
                r6.close()     // Catch:{ IOException -> 0x016e }
                goto L_0x0173
            L_0x016e:
                r0 = move-exception
                r4 = r0
                com.facebook.common.logging.FLog.e((java.lang.String) r5, (java.lang.String) r3, (java.lang.Throwable) r4)
            L_0x0173:
                goto L_0x0175
            L_0x0174:
                throw r2
            L_0x0175:
                goto L_0x0174
            */
            throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.cameraroll.CameraRollModule.SaveToCameraRoll.doInBackgroundGuarded(java.lang.Void[]):void");
        }
    }

    @ReactMethod
    public void getPhotos(ReadableMap readableMap, Promise promise) {
        new GetMediaTask(getReactApplicationContext(), readableMap.getInt("first"), readableMap.hasKey("after") ? readableMap.getString("after") : null, readableMap.hasKey("groupName") ? readableMap.getString("groupName") : null, readableMap.hasKey("mimeTypes") ? readableMap.getArray("mimeTypes") : null, readableMap.hasKey("assetType") ? readableMap.getString("assetType") : ASSET_TYPE_PHOTOS, promise).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    private static class GetMediaTask extends GuardedAsyncTask<Void, Void> {
        @Nullable
        private final String mAfter;
        private final String mAssetType;
        private final Context mContext;
        private final int mFirst;
        @Nullable
        private final String mGroupName;
        @Nullable
        private final ReadableArray mMimeTypes;
        private final Promise mPromise;

        private GetMediaTask(ReactContext reactContext, int i, @Nullable String str, @Nullable String str2, @Nullable ReadableArray readableArray, String str3, Promise promise) {
            super(reactContext);
            this.mContext = reactContext;
            this.mFirst = i;
            this.mAfter = str;
            this.mGroupName = str2;
            this.mMimeTypes = readableArray;
            this.mPromise = promise;
            this.mAssetType = str3;
        }

        /* access modifiers changed from: protected */
        public void doInBackgroundGuarded(Void... voidArr) {
            Cursor query;
            StringBuilder sb = new StringBuilder("1");
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(this.mAfter)) {
                sb.append(" AND datetaken < ?");
                arrayList.add(this.mAfter);
            }
            if (!TextUtils.isEmpty(this.mGroupName)) {
                sb.append(" AND bucket_display_name = ?");
                arrayList.add(this.mGroupName);
            }
            if (this.mAssetType.equals(CameraRollModule.ASSET_TYPE_PHOTOS)) {
                sb.append(" AND media_type = 1");
            } else if (this.mAssetType.equals(CameraRollModule.ASSET_TYPE_VIDEOS)) {
                sb.append(" AND media_type = 3");
            } else if (this.mAssetType.equals(CameraRollModule.ASSET_TYPE_ALL)) {
                sb.append(" AND media_type IN (3,1)");
            } else {
                Promise promise = this.mPromise;
                promise.reject(CameraRollModule.ERROR_UNABLE_TO_FILTER, "Invalid filter option: '" + this.mAssetType + "'. Expected one of '" + CameraRollModule.ASSET_TYPE_PHOTOS + "', '" + CameraRollModule.ASSET_TYPE_VIDEOS + "' or '" + CameraRollModule.ASSET_TYPE_ALL + "'.");
                return;
            }
            ReadableArray readableArray = this.mMimeTypes;
            if (readableArray != null && readableArray.size() > 0) {
                sb.append(" AND mime_type IN (");
                for (int i = 0; i < this.mMimeTypes.size(); i++) {
                    sb.append("?,");
                    arrayList.add(this.mMimeTypes.getString(i));
                }
                sb.replace(sb.length() - 1, sb.length(), ")");
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            ContentResolver contentResolver = this.mContext.getContentResolver();
            try {
                query = contentResolver.query(MediaStore.Files.getContentUri("external"), CameraRollModule.PROJECTION, sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]), "date_added DESC, date_modified DESC LIMIT " + (this.mFirst + 1));
                if (query == null) {
                    this.mPromise.reject(CameraRollModule.ERROR_UNABLE_TO_LOAD, "Could not get media");
                    return;
                }
                CameraRollModule.putEdges(contentResolver, query, writableNativeMap, this.mFirst);
                CameraRollModule.putPageInfo(query, writableNativeMap, this.mFirst);
                query.close();
                this.mPromise.resolve(writableNativeMap);
            } catch (SecurityException e) {
                this.mPromise.reject(CameraRollModule.ERROR_UNABLE_TO_LOAD_PERMISSION, "Could not get media: need READ_EXTERNAL_STORAGE permission", (Throwable) e);
            } catch (Throwable th) {
                query.close();
                this.mPromise.resolve(writableNativeMap);
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public static void putPageInfo(Cursor cursor, WritableMap writableMap, int i) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putBoolean("has_next_page", i < cursor.getCount());
        if (i < cursor.getCount()) {
            cursor.moveToPosition(i - 1);
            writableNativeMap.putString("end_cursor", cursor.getString(cursor.getColumnIndex("datetaken")));
        }
        writableMap.putMap("page_info", writableNativeMap);
    }

    /* access modifiers changed from: private */
    public static void putEdges(ContentResolver contentResolver, Cursor cursor, WritableMap writableMap, int i) {
        WritableNativeArray writableNativeArray;
        Cursor cursor2 = cursor;
        WritableNativeArray writableNativeArray2 = new WritableNativeArray();
        cursor.moveToFirst();
        int columnIndex = cursor2.getColumnIndex("_id");
        int columnIndex2 = cursor2.getColumnIndex("mime_type");
        int columnIndex3 = cursor2.getColumnIndex("bucket_display_name");
        int columnIndex4 = cursor2.getColumnIndex("datetaken");
        int columnIndex5 = cursor2.getColumnIndex("width");
        int columnIndex6 = cursor2.getColumnIndex("height");
        int columnIndex7 = cursor2.getColumnIndex("longitude");
        int columnIndex8 = cursor2.getColumnIndex("latitude");
        int columnIndex9 = cursor2.getColumnIndex("_data");
        int i2 = i;
        int i3 = 0;
        while (i3 < i2 && !cursor.isAfterLast()) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            WritableNativeMap writableNativeMap2 = new WritableNativeMap();
            WritableNativeMap writableNativeMap3 = writableNativeMap2;
            WritableNativeArray writableNativeArray3 = writableNativeArray2;
            WritableNativeMap writableNativeMap4 = writableNativeMap;
            int i4 = i3;
            int i5 = columnIndex;
            int i6 = columnIndex8;
            int i7 = columnIndex5;
            int i8 = columnIndex7;
            if (putImageInfo(contentResolver, cursor, writableNativeMap2, columnIndex, columnIndex5, columnIndex6, columnIndex9, columnIndex2)) {
                WritableNativeMap writableNativeMap5 = writableNativeMap3;
                putBasicNodeInfo(cursor2, writableNativeMap5, columnIndex2, columnIndex3, columnIndex4);
                putLocationInfo(cursor2, writableNativeMap5, i8, i6);
                writableNativeMap4.putMap("node", writableNativeMap5);
                writableNativeArray = writableNativeArray3;
                writableNativeArray.pushMap(writableNativeMap4);
            } else {
                writableNativeArray = writableNativeArray3;
                i4--;
            }
            cursor.moveToNext();
            i3 = i4 + 1;
            i2 = i;
            writableNativeArray2 = writableNativeArray;
            columnIndex8 = i6;
            columnIndex7 = i8;
            columnIndex = i5;
            columnIndex5 = i7;
        }
        writableMap.putArray("edges", writableNativeArray2);
    }

    private static void putBasicNodeInfo(Cursor cursor, WritableMap writableMap, int i, int i2, int i3) {
        writableMap.putString("type", cursor.getString(i));
        writableMap.putString("group_name", cursor.getString(i2));
        double d = (double) cursor.getLong(i3);
        Double.isNaN(d);
        writableMap.putDouble("timestamp", d / 1000.0d);
    }

    private static boolean putImageInfo(ContentResolver contentResolver, Cursor cursor, WritableMap writableMap, int i, int i2, int i3, int i4, int i5) {
        AssetFileDescriptor openAssetFileDescriptor;
        MediaMetadataRetriever mediaMetadataRetriever;
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        Uri parse = Uri.parse("file://" + cursor.getString(i4));
        String name = new File(cursor.getString(i4)).getName();
        writableNativeMap.putString("uri", parse.toString());
        writableNativeMap.putString("filename", name);
        float f = (float) cursor.getInt(i2);
        float f2 = (float) cursor.getInt(i3);
        String string = cursor.getString(i5);
        if (string != null && string.startsWith("video")) {
            try {
                openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(parse, "r");
                mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(openAssetFileDescriptor.getFileDescriptor());
                if (f <= 0.0f || f2 <= 0.0f) {
                    try {
                        f = (float) Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                        f2 = (float) Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                    } catch (NumberFormatException e) {
                        FLog.e(ReactConstants.TAG, "Number format exception occurred while trying to fetch video metadata for " + parse.toString(), (Throwable) e);
                        mediaMetadataRetriever.release();
                        openAssetFileDescriptor.close();
                        return false;
                    }
                }
                writableNativeMap.putInt("playableDuration", Integer.parseInt(mediaMetadataRetriever.extractMetadata(9)) / 1000);
                mediaMetadataRetriever.release();
                openAssetFileDescriptor.close();
            } catch (Exception e2) {
                FLog.e(ReactConstants.TAG, "Could not get video metadata for " + parse.toString(), (Throwable) e2);
                return false;
            } catch (Throwable th) {
                mediaMetadataRetriever.release();
                openAssetFileDescriptor.close();
                throw th;
            }
        }
        if (f <= 0.0f || f2 <= 0.0f) {
            try {
                AssetFileDescriptor openAssetFileDescriptor2 = contentResolver.openAssetFileDescriptor(parse, "r");
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFileDescriptor(openAssetFileDescriptor2.getFileDescriptor(), (Rect) null, options);
                float f3 = (float) options.outWidth;
                float f4 = (float) options.outHeight;
                openAssetFileDescriptor2.close();
                float f5 = f3;
                f2 = f4;
                f = f5;
            } catch (IOException e3) {
                FLog.e(ReactConstants.TAG, "Could not get width/height for " + parse.toString(), (Throwable) e3);
                return false;
            }
        }
        writableNativeMap.putDouble("width", (double) f);
        writableNativeMap.putDouble("height", (double) f2);
        writableMap.putMap("image", writableNativeMap);
        return true;
    }

    private static void putLocationInfo(Cursor cursor, WritableMap writableMap, int i, int i2) {
        double d = cursor.getDouble(i);
        double d2 = cursor.getDouble(i2);
        if (d > 0.0d || d2 > 0.0d) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putDouble("longitude", d);
            writableNativeMap.putDouble("latitude", d2);
            writableMap.putMap(FirebaseAnalytics.Param.LOCATION, writableNativeMap);
        }
    }

    @ReactMethod
    public void deletePhotos(ReadableArray readableArray, Promise promise) {
        if (readableArray.size() == 0) {
            promise.reject(ERROR_UNABLE_TO_DELETE, "Need at least one URI to delete");
        } else {
            new DeletePhotos(getReactApplicationContext(), readableArray, promise).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    private static class DeletePhotos extends GuardedAsyncTask<Void, Void> {
        private final Context mContext;
        private final Promise mPromise;
        private final ReadableArray mUris;

        public DeletePhotos(ReactContext reactContext, ReadableArray readableArray, Promise promise) {
            super(reactContext);
            this.mContext = reactContext;
            this.mUris = readableArray;
            this.mPromise = promise;
        }

        /* access modifiers changed from: protected */
        public void doInBackgroundGuarded(Void... voidArr) {
            ContentResolver contentResolver = this.mContext.getContentResolver();
            int i = 0;
            String[] strArr = {"_id"};
            String str = "?";
            for (int i2 = 1; i2 < this.mUris.size(); i2++) {
                str = str + ", ?";
            }
            String str2 = "_data IN (" + str + ")";
            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            String[] strArr2 = new String[this.mUris.size()];
            for (int i3 = 0; i3 < this.mUris.size(); i3++) {
                strArr2[i3] = Uri.parse(this.mUris.getString(i3)).getPath();
            }
            Cursor query = contentResolver.query(uri, strArr, str2, strArr2, (String) null);
            while (query.moveToNext()) {
                if (contentResolver.delete(ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, query.getLong(query.getColumnIndexOrThrow("_id"))), (String) null, (String[]) null) == 1) {
                    i++;
                }
            }
            query.close();
            if (i == this.mUris.size()) {
                this.mPromise.resolve((Object) null);
                return;
            }
            this.mPromise.reject(CameraRollModule.ERROR_UNABLE_TO_DELETE, "Could not delete all media, only deleted " + i + " photos.");
        }
    }
}

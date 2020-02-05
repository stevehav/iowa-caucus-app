package org.reactnative.camera.tasks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.AsyncTask;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import java.io.File;
import java.io.IOException;

public class ResolveTakenPictureAsyncTask extends AsyncTask<Void, Void, WritableMap> {
    private static final String ERROR_TAG = "E_TAKING_PICTURE_FAILED";
    private Bitmap mBitmap;
    private File mCacheDirectory;
    private int mDeviceOrientation;
    private byte[] mImageData;
    private ReadableMap mOptions;
    private PictureSavedDelegate mPictureSavedDelegate;
    private Promise mPromise;

    private int getImageRotation(int i) {
        if (i == 3) {
            return 180;
        }
        if (i != 6) {
            return i != 8 ? 0 : 270;
        }
        return 90;
    }

    public ResolveTakenPictureAsyncTask(byte[] bArr, Promise promise, ReadableMap readableMap, File file, int i, PictureSavedDelegate pictureSavedDelegate) {
        this.mPromise = promise;
        this.mOptions = readableMap;
        this.mImageData = bArr;
        this.mCacheDirectory = file;
        this.mDeviceOrientation = i;
        this.mPictureSavedDelegate = pictureSavedDelegate;
    }

    private int getQuality() {
        return (int) (this.mOptions.getDouble("quality") * 100.0d);
    }

    private void loadBitmap() throws IOException {
        if (this.mBitmap == null) {
            byte[] bArr = this.mImageData;
            this.mBitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        if (this.mBitmap == null) {
            throw new IOException("Failed to decode Image Bitmap");
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0258 A[SYNTHETIC, Splitter:B:118:0x0258] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x026a A[SYNTHETIC, Splitter:B:125:0x026a] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x027a A[SYNTHETIC, Splitter:B:132:0x027a] */
    /* JADX WARNING: Removed duplicated region for block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0072 A[Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ae A[Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b0 A[Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ba A[Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e2 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ef A[Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f0 A[Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0106 A[Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x011f A[Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:115:0x024c=Splitter:B:115:0x024c, B:122:0x025e=Splitter:B:122:0x025e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.react.bridge.WritableMap doInBackground(java.lang.Void... r17) {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r0 = "mirrorImage"
            java.lang.String r2 = "fixOrientation"
            java.lang.String r3 = "E_TAKING_PICTURE_FAILED"
            java.lang.String r4 = "exif"
            java.lang.String r5 = "writeExif"
            java.lang.String r6 = "width"
            com.facebook.react.bridge.WritableMap r7 = com.facebook.react.bridge.Arguments.createMap()
            int r8 = r1.mDeviceOrientation
            java.lang.String r9 = "deviceOrientation"
            r7.putInt(r9, r8)
            com.facebook.react.bridge.ReadableMap r8 = r1.mOptions
            java.lang.String r9 = "orientation"
            boolean r8 = r8.hasKey(r9)
            if (r8 == 0) goto L_0x002a
            com.facebook.react.bridge.ReadableMap r8 = r1.mOptions
            int r8 = r8.getInt(r9)
            goto L_0x002c
        L_0x002a:
            int r8 = r1.mDeviceOrientation
        L_0x002c:
            java.lang.String r9 = "pictureOrientation"
            r7.putInt(r9, r8)
            java.io.ByteArrayInputStream r9 = new java.io.ByteArrayInputStream     // Catch:{ NotFoundException -> 0x025c, IOException -> 0x024a, all -> 0x0246 }
            byte[] r10 = r1.mImageData     // Catch:{ NotFoundException -> 0x025c, IOException -> 0x024a, all -> 0x0246 }
            r9.<init>(r10)     // Catch:{ NotFoundException -> 0x025c, IOException -> 0x024a, all -> 0x0246 }
            com.facebook.react.bridge.ReadableMap r10 = r1.mOptions     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            boolean r10 = r10.hasKey(r2)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            java.lang.String r11 = "Orientation"
            r12 = 0
            r13 = 1
            if (r10 == 0) goto L_0x0068
            com.facebook.react.bridge.ReadableMap r10 = r1.mOptions     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            boolean r2 = r10.getBoolean(r2)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            if (r2 == 0) goto L_0x0068
            androidx.exifinterface.media.ExifInterface r2 = new androidx.exifinterface.media.ExifInterface     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r2.<init>((java.io.InputStream) r9)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            int r10 = r2.getAttributeInt(r11, r12)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            if (r10 == 0) goto L_0x0069
            r16.loadBitmap()     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            android.graphics.Bitmap r14 = r1.mBitmap     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            int r10 = r1.getImageRotation(r10)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            android.graphics.Bitmap r10 = r1.rotateBitmap(r14, r10)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r1.mBitmap = r10     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r10 = 1
            goto L_0x006a
        L_0x0068:
            r2 = 0
        L_0x0069:
            r10 = 0
        L_0x006a:
            com.facebook.react.bridge.ReadableMap r14 = r1.mOptions     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            boolean r14 = r14.hasKey(r6)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            if (r14 == 0) goto L_0x0083
            r16.loadBitmap()     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            android.graphics.Bitmap r14 = r1.mBitmap     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            com.facebook.react.bridge.ReadableMap r15 = r1.mOptions     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            int r15 = r15.getInt(r6)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            android.graphics.Bitmap r14 = r1.resizeBitmap(r14, r15)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r1.mBitmap = r14     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
        L_0x0083:
            com.facebook.react.bridge.ReadableMap r14 = r1.mOptions     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            boolean r14 = r14.hasKey(r0)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            if (r14 == 0) goto L_0x009e
            com.facebook.react.bridge.ReadableMap r14 = r1.mOptions     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            boolean r0 = r14.getBoolean(r0)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            if (r0 == 0) goto L_0x009e
            r16.loadBitmap()     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            android.graphics.Bitmap r0 = r1.mBitmap     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            android.graphics.Bitmap r0 = r1.flipHorizontally(r0)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r1.mBitmap = r0     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
        L_0x009e:
            com.facebook.react.bridge.ReadableMap r0 = r1.mOptions     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            boolean r0 = r0.hasKey(r4)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            if (r0 == 0) goto L_0x00b0
            com.facebook.react.bridge.ReadableMap r0 = r1.mOptions     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            boolean r0 = r0.getBoolean(r4)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            if (r0 == 0) goto L_0x00b0
            r0 = 1
            goto L_0x00b1
        L_0x00b0:
            r0 = 0
        L_0x00b1:
            com.facebook.react.bridge.ReadableMap r14 = r1.mOptions     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            boolean r14 = r14.hasKey(r5)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r15 = 2
            if (r14 == 0) goto L_0x00dc
            int[] r14 = org.reactnative.camera.tasks.ResolveTakenPictureAsyncTask.AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            com.facebook.react.bridge.ReadableMap r8 = r1.mOptions     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            com.facebook.react.bridge.ReadableType r8 = r8.getType(r5)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            int r8 = r8.ordinal()     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r8 = r14[r8]     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            if (r8 == r13) goto L_0x00d5
            if (r8 == r15) goto L_0x00cd
            goto L_0x00dc
        L_0x00cd:
            com.facebook.react.bridge.ReadableMap r8 = r1.mOptions     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            com.facebook.react.bridge.ReadableMap r8 = r8.getMap(r5)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r5 = 1
            goto L_0x00de
        L_0x00d5:
            com.facebook.react.bridge.ReadableMap r8 = r1.mOptions     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            boolean r5 = r8.getBoolean(r5)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            goto L_0x00dd
        L_0x00dc:
            r5 = 1
        L_0x00dd:
            r8 = 0
        L_0x00de:
            java.lang.String r14 = "height"
            if (r0 != 0) goto L_0x00e7
            if (r5 == 0) goto L_0x00e5
            goto L_0x00e7
        L_0x00e5:
            r2 = 0
            goto L_0x0122
        L_0x00e7:
            android.graphics.Bitmap r15 = r1.mBitmap     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            if (r15 != 0) goto L_0x00f2
            if (r8 != 0) goto L_0x00f2
            if (r0 == 0) goto L_0x00f0
            goto L_0x00f2
        L_0x00f0:
            r2 = 0
            goto L_0x0102
        L_0x00f2:
            if (r2 != 0) goto L_0x00f9
            androidx.exifinterface.media.ExifInterface r2 = new androidx.exifinterface.media.ExifInterface     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r2.<init>((java.io.InputStream) r9)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
        L_0x00f9:
            com.facebook.react.bridge.WritableMap r2 = org.reactnative.camera.RNCameraViewHelper.getExifData(r2)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            if (r8 == 0) goto L_0x0102
            r2.merge(r8)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
        L_0x0102:
            android.graphics.Bitmap r15 = r1.mBitmap     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            if (r15 == 0) goto L_0x011d
            android.graphics.Bitmap r15 = r1.mBitmap     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            int r15 = r15.getWidth()     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r2.putInt(r6, r15)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            android.graphics.Bitmap r15 = r1.mBitmap     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            int r15 = r15.getHeight()     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r2.putInt(r14, r15)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            if (r10 == 0) goto L_0x011d
            r2.putInt(r11, r13)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
        L_0x011d:
            if (r0 == 0) goto L_0x0122
            r7.putMap(r4, r2)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
        L_0x0122:
            android.graphics.Bitmap r0 = r1.mBitmap     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            java.lang.String r4 = "doNotSave"
            java.lang.String r10 = "base64"
            if (r0 != 0) goto L_0x01c0
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r0.<init>()     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r0.inJustDecodeBounds = r13     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            byte[] r2 = r1.mImageData     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            byte[] r11 = r1.mImageData     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            int r11 = r11.length     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            android.graphics.BitmapFactory.decodeByteArray(r2, r12, r11, r0)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            int r2 = r0.outWidth     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r7.putInt(r6, r2)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            int r0 = r0.outHeight     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r7.putInt(r14, r0)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            com.facebook.react.bridge.ReadableMap r0 = r1.mOptions     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            boolean r0 = r0.hasKey(r4)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            if (r0 == 0) goto L_0x0153
            com.facebook.react.bridge.ReadableMap r0 = r1.mOptions     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            boolean r0 = r0.getBoolean(r4)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            if (r0 != 0) goto L_0x01a5
        L_0x0153:
            java.io.File r0 = new java.io.File     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            java.io.File r2 = r1.mCacheDirectory     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            java.lang.String r4 = ".jpg"
            java.lang.String r2 = org.reactnative.camera.utils.RNFileUtils.getOutputFilePath(r2, r4)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r0.<init>(r2)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r0.createNewFile()     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r2.<init>(r0)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            byte[] r4 = r1.mImageData     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r2.write(r4)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r2.flush()     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r2.close()     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            if (r5 == 0) goto L_0x0187
            if (r8 == 0) goto L_0x0187
            androidx.exifinterface.media.ExifInterface r2 = new androidx.exifinterface.media.ExifInterface     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            java.lang.String r4 = r0.getAbsolutePath()     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r2.<init>((java.lang.String) r4)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            org.reactnative.camera.RNCameraViewHelper.setExifData(r2, r8)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r2.saveAttributes()     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            goto L_0x0198
        L_0x0187:
            if (r5 != 0) goto L_0x0198
            androidx.exifinterface.media.ExifInterface r2 = new androidx.exifinterface.media.ExifInterface     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            java.lang.String r4 = r0.getAbsolutePath()     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r2.<init>((java.lang.String) r4)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            org.reactnative.camera.RNCameraViewHelper.clearExifData(r2)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r2.saveAttributes()     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
        L_0x0198:
            android.net.Uri r0 = android.net.Uri.fromFile(r0)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            java.lang.String r0 = r0.toString()     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            java.lang.String r2 = "uri"
            r7.putString(r2, r0)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
        L_0x01a5:
            com.facebook.react.bridge.ReadableMap r0 = r1.mOptions     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            boolean r0 = r0.hasKey(r10)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            if (r0 == 0) goto L_0x0233
            com.facebook.react.bridge.ReadableMap r0 = r1.mOptions     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            boolean r0 = r0.getBoolean(r10)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            if (r0 == 0) goto L_0x0233
            byte[] r0 = r1.mImageData     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r2 = 2
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r2)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r7.putString(r10, r0)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            goto L_0x0233
        L_0x01c0:
            android.graphics.Bitmap r0 = r1.mBitmap     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            int r0 = r0.getWidth()     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r7.putInt(r6, r0)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            android.graphics.Bitmap r0 = r1.mBitmap     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            int r0 = r0.getHeight()     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r7.putInt(r14, r0)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r0.<init>()     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            android.graphics.Bitmap r6 = r1.mBitmap     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            android.graphics.Bitmap$CompressFormat r8 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            int r11 = r16.getQuality()     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r6.compress(r8, r11, r0)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            com.facebook.react.bridge.ReadableMap r6 = r1.mOptions     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            boolean r6 = r6.hasKey(r4)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            if (r6 == 0) goto L_0x01f2
            com.facebook.react.bridge.ReadableMap r6 = r1.mOptions     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            boolean r4 = r6.getBoolean(r4)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            if (r4 != 0) goto L_0x0217
        L_0x01f2:
            java.lang.String r4 = r1.writeStreamToFile(r0)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            if (r5 == 0) goto L_0x0205
            if (r2 == 0) goto L_0x0205
            androidx.exifinterface.media.ExifInterface r5 = new androidx.exifinterface.media.ExifInterface     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r5.<init>((java.lang.String) r4)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            org.reactnative.camera.RNCameraViewHelper.setExifData(r5, r2)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r5.saveAttributes()     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
        L_0x0205:
            java.io.File r2 = new java.io.File     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r2.<init>(r4)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            android.net.Uri r2 = android.net.Uri.fromFile(r2)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            java.lang.String r2 = r2.toString()     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            java.lang.String r4 = "uri"
            r7.putString(r4, r2)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
        L_0x0217:
            com.facebook.react.bridge.ReadableMap r2 = r1.mOptions     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            boolean r2 = r2.hasKey(r10)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            if (r2 == 0) goto L_0x0233
            com.facebook.react.bridge.ReadableMap r2 = r1.mOptions     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            boolean r2 = r2.getBoolean(r10)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            if (r2 == 0) goto L_0x0233
            byte[] r0 = r0.toByteArray()     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r2 = 2
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r2)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
            r7.putString(r10, r0)     // Catch:{ NotFoundException -> 0x0243, IOException -> 0x0240, all -> 0x023d }
        L_0x0233:
            r9.close()     // Catch:{ IOException -> 0x0237 }
            goto L_0x023c
        L_0x0237:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
        L_0x023c:
            return r7
        L_0x023d:
            r0 = move-exception
            r2 = r0
            goto L_0x0278
        L_0x0240:
            r0 = move-exception
            r8 = r9
            goto L_0x024c
        L_0x0243:
            r0 = move-exception
            r8 = r9
            goto L_0x025e
        L_0x0246:
            r0 = move-exception
            r2 = r0
            r9 = 0
            goto L_0x0278
        L_0x024a:
            r0 = move-exception
            r8 = 0
        L_0x024c:
            com.facebook.react.bridge.Promise r2 = r1.mPromise     // Catch:{ all -> 0x0275 }
            java.lang.String r4 = "An unknown I/O exception has occurred."
            r2.reject((java.lang.String) r3, (java.lang.String) r4, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0275 }
            r0.printStackTrace()     // Catch:{ all -> 0x0275 }
            if (r8 == 0) goto L_0x0273
            r8.close()     // Catch:{ IOException -> 0x026e }
            goto L_0x0273
        L_0x025c:
            r0 = move-exception
            r8 = 0
        L_0x025e:
            com.facebook.react.bridge.Promise r2 = r1.mPromise     // Catch:{ all -> 0x0275 }
            java.lang.String r4 = "Documents directory of the app could not be found."
            r2.reject((java.lang.String) r3, (java.lang.String) r4, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0275 }
            r0.printStackTrace()     // Catch:{ all -> 0x0275 }
            if (r8 == 0) goto L_0x0273
            r8.close()     // Catch:{ IOException -> 0x026e }
            goto L_0x0273
        L_0x026e:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
        L_0x0273:
            r2 = 0
            return r2
        L_0x0275:
            r0 = move-exception
            r2 = r0
            r9 = r8
        L_0x0278:
            if (r9 == 0) goto L_0x0283
            r9.close()     // Catch:{ IOException -> 0x027e }
            goto L_0x0283
        L_0x027e:
            r0 = move-exception
            r3 = r0
            r3.printStackTrace()
        L_0x0283:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.reactnative.camera.tasks.ResolveTakenPictureAsyncTask.doInBackground(java.lang.Void[]):com.facebook.react.bridge.WritableMap");
    }

    /* renamed from: org.reactnative.camera.tasks.ResolveTakenPictureAsyncTask$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType = new int[ReadableType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.facebook.react.bridge.ReadableType[] r0 = com.facebook.react.bridge.ReadableType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$bridge$ReadableType = r0
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Boolean     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x001f }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Map     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.reactnative.camera.tasks.ResolveTakenPictureAsyncTask.AnonymousClass1.<clinit>():void");
        }
    }

    private Bitmap rotateBitmap(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private Bitmap resizeBitmap(Bitmap bitmap, int i) {
        return Bitmap.createScaledBitmap(bitmap, i, (int) (((float) bitmap.getHeight()) * (((float) i) / ((float) bitmap.getWidth()))), true);
    }

    private Bitmap flipHorizontally(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.preScale(-1.0f, 1.0f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        r4 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x001f A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0001] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002a A[SYNTHETIC, Splitter:B:21:0x002a] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x002f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0035 A[SYNTHETIC, Splitter:B:29:0x0035] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String writeStreamToFile(java.io.ByteArrayOutputStream r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 0
            java.io.File r1 = r3.mCacheDirectory     // Catch:{ IOException -> 0x0021, all -> 0x001f }
            java.lang.String r2 = ".jpg"
            java.lang.String r1 = org.reactnative.camera.utils.RNFileUtils.getOutputFilePath(r1, r2)     // Catch:{ IOException -> 0x0021, all -> 0x001f }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x001c, all -> 0x001f }
            r2.<init>(r1)     // Catch:{ IOException -> 0x001c, all -> 0x001f }
            r4.writeTo(r2)     // Catch:{ IOException -> 0x001a }
            r2.close()     // Catch:{ IOException -> 0x0015 }
            goto L_0x002d
        L_0x0015:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x002d
        L_0x001a:
            r4 = move-exception
            goto L_0x0024
        L_0x001c:
            r4 = move-exception
            r2 = r0
            goto L_0x0024
        L_0x001f:
            r4 = move-exception
            goto L_0x0033
        L_0x0021:
            r4 = move-exception
            r1 = r0
            r2 = r1
        L_0x0024:
            r0 = r4
            r0.printStackTrace()     // Catch:{ all -> 0x0031 }
            if (r2 == 0) goto L_0x002d
            r2.close()     // Catch:{ IOException -> 0x0015 }
        L_0x002d:
            if (r0 != 0) goto L_0x0030
            return r1
        L_0x0030:
            throw r0
        L_0x0031:
            r4 = move-exception
            r0 = r2
        L_0x0033:
            if (r0 == 0) goto L_0x003d
            r0.close()     // Catch:{ IOException -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            r0 = move-exception
            r0.printStackTrace()
        L_0x003d:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.reactnative.camera.tasks.ResolveTakenPictureAsyncTask.writeStreamToFile(java.io.ByteArrayOutputStream):java.lang.String");
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(WritableMap writableMap) {
        super.onPostExecute(writableMap);
        if (writableMap == null) {
            return;
        }
        if (!this.mOptions.hasKey("fastMode") || !this.mOptions.getBoolean("fastMode")) {
            this.mPromise.resolve(writableMap);
            return;
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("id", this.mOptions.getInt("id"));
        createMap.putMap("data", writableMap);
        this.mPictureSavedDelegate.onPictureSaved(createMap);
    }
}

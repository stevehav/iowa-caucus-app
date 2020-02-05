package org.reactnative.camera.tasks;

import android.os.AsyncTask;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;

public class BarCodeScannerAsyncTask extends AsyncTask<Void, Void, Result> {
    private BarCodeScannerAsyncTaskDelegate mDelegate;
    private int mHeight;
    private byte[] mImageData;
    private final MultiFormatReader mMultiFormatReader;
    private int mWidth;

    public BarCodeScannerAsyncTask(BarCodeScannerAsyncTaskDelegate barCodeScannerAsyncTaskDelegate, MultiFormatReader multiFormatReader, byte[] bArr, int i, int i2) {
        this.mImageData = bArr;
        this.mWidth = i;
        this.mHeight = i2;
        this.mDelegate = barCodeScannerAsyncTaskDelegate;
        this.mMultiFormatReader = multiFormatReader;
    }

    /* access modifiers changed from: protected */
    public Result doInBackground(Void... voidArr) {
        Result decodeWithState;
        if (isCancelled() || this.mDelegate == null) {
            return null;
        }
        try {
            return this.mMultiFormatReader.decodeWithState(generateBitmapFromImageData(this.mImageData, this.mWidth, this.mHeight, false));
        } catch (NotFoundException unused) {
            try {
                decodeWithState = this.mMultiFormatReader.decodeWithState(generateBitmapFromImageData(rotateImage(this.mImageData, this.mWidth, this.mHeight), this.mHeight, this.mWidth, false));
            } catch (NotFoundException unused2) {
                try {
                    decodeWithState = this.mMultiFormatReader.decodeWithState(generateBitmapFromImageData(this.mImageData, this.mWidth, this.mHeight, true));
                } catch (NotFoundException unused3) {
                    try {
                        decodeWithState = this.mMultiFormatReader.decodeWithState(generateBitmapFromImageData(rotateImage(this.mImageData, this.mWidth, this.mHeight), this.mHeight, this.mWidth, true));
                    } catch (NotFoundException unused4) {
                        return null;
                    }
                }
            }
            return decodeWithState;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private byte[] rotateImage(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                bArr2[(((i4 * i2) + i2) - i3) - 1] = bArr[(i3 * i) + i4];
            }
        }
        return bArr2;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Result result) {
        super.onPostExecute(result);
        if (result != null) {
            this.mDelegate.onBarCodeRead(result, this.mWidth, this.mHeight);
        }
        this.mDelegate.onBarCodeScanningTaskCompleted();
    }

    private BinaryBitmap generateBitmapFromImageData(byte[] bArr, int i, int i2, boolean z) {
        PlanarYUVLuminanceSource planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr, i, i2, 0, 0, i, i2, false);
        if (z) {
            return new BinaryBitmap(new HybridBinarizer(planarYUVLuminanceSource.invert()));
        }
        return new BinaryBitmap(new HybridBinarizer(planarYUVLuminanceSource));
    }
}

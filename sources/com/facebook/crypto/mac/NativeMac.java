package com.facebook.crypto.mac;

import com.facebook.crypto.exception.CryptoInitializationException;
import com.facebook.crypto.proguard.annotations.DoNotStrip;
import com.facebook.crypto.util.Assertions;
import com.facebook.crypto.util.NativeCryptoLibrary;
import java.io.IOException;

@DoNotStrip
public class NativeMac {
    public static final String FAILURE = "Failure";
    public static final int KEY_LENGTH = 64;
    private static final String MAC_ALREADY_INIT = "Mac has already been initialized";
    private static final String MAC_NOT_FINALIZED = "Mac has not been finalized";
    private static final String MAC_NOT_INIT = "Mac has not been initialized";
    @DoNotStrip
    private long mCtxPtr;
    private STATE mCurrentState = STATE.UNINITIALIZED;
    private final NativeCryptoLibrary mNativeCryptoLibrary;

    private enum STATE {
        UNINITIALIZED,
        INITIALIZED,
        FINALIZED
    }

    private native int nativeDestroy();

    private native byte[] nativeDoFinal();

    private static native int nativeFailure();

    private native int nativeGetMacLength();

    private native int nativeInit(byte[] bArr, int i);

    private native int nativeUpdate(byte b);

    private native int nativeUpdate(byte[] bArr, int i, int i2);

    public NativeMac(NativeCryptoLibrary nativeCryptoLibrary) {
        this.mNativeCryptoLibrary = nativeCryptoLibrary;
    }

    public void init(byte[] bArr, int i) throws CryptoInitializationException, IOException {
        Assertions.checkState(this.mCurrentState == STATE.UNINITIALIZED, MAC_ALREADY_INIT);
        this.mNativeCryptoLibrary.ensureCryptoLoaded();
        if (nativeInit(bArr, i) != nativeFailure()) {
            this.mCurrentState = STATE.INITIALIZED;
            return;
        }
        throw new IOException("Failure");
    }

    public void update(byte b) throws IOException {
        Assertions.checkState(this.mCurrentState == STATE.INITIALIZED, MAC_NOT_INIT);
        if (nativeUpdate(b) == nativeFailure()) {
            throw new IOException("Failure");
        }
    }

    public void update(byte[] bArr, int i, int i2) throws IOException {
        Assertions.checkState(this.mCurrentState == STATE.INITIALIZED, MAC_NOT_INIT);
        if (nativeUpdate(bArr, i, i2) == nativeFailure()) {
            throw new IOException("Failure");
        }
    }

    public byte[] doFinal() throws IOException {
        Assertions.checkState(this.mCurrentState == STATE.INITIALIZED, MAC_NOT_INIT);
        this.mCurrentState = STATE.FINALIZED;
        byte[] nativeDoFinal = nativeDoFinal();
        if (nativeDoFinal != null) {
            return nativeDoFinal;
        }
        throw new IOException("Failure");
    }

    public void destroy() throws IOException {
        Assertions.checkState(this.mCurrentState == STATE.FINALIZED, MAC_NOT_FINALIZED);
        if (nativeDestroy() != nativeFailure()) {
            this.mCurrentState = STATE.UNINITIALIZED;
            return;
        }
        throw new IOException("Failure");
    }

    public int getMacLength() {
        return nativeGetMacLength();
    }
}

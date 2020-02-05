package com.facebook.crypto.util;

import com.facebook.crypto.exception.CryptoInitializationException;
import java.util.ArrayList;
import java.util.Iterator;

public class SystemNativeCryptoLibrary implements NativeCryptoLibrary {
    private static final ArrayList<String> LIBS = new ArrayList<String>() {
        {
            add("conceal");
        }
    };
    private boolean mLibrariesLoaded = false;
    private volatile UnsatisfiedLinkError mLinkError = null;
    private boolean mLoadLibraries = true;

    public synchronized void ensureCryptoLoaded() throws CryptoInitializationException {
        if (!loadLibraries()) {
            throw new CryptoInitializationException(this.mLinkError);
        }
    }

    private synchronized boolean loadLibraries() {
        if (!this.mLoadLibraries) {
            return this.mLibrariesLoaded;
        }
        try {
            Iterator<String> it = LIBS.iterator();
            while (it.hasNext()) {
                System.loadLibrary(it.next());
            }
            this.mLibrariesLoaded = true;
        } catch (UnsatisfiedLinkError e) {
            this.mLinkError = e;
            this.mLibrariesLoaded = false;
        }
        this.mLoadLibraries = false;
        return this.mLibrariesLoaded;
    }
}

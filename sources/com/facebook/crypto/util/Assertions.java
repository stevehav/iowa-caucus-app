package com.facebook.crypto.util;

import java.io.IOException;

public class Assertions {
    public static void checkState(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }

    public static void checkArgumentForIO(boolean z, String str) throws IOException {
        if (!z) {
            throw new IOException(str);
        }
    }
}

package com.google.firebase.storage;

import com.google.firebase.annotations.PublicApi;
import java.io.IOException;

@PublicApi
/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
class CancelException extends IOException {
    @PublicApi
    CancelException() {
        super("The operation was canceled.");
    }
}

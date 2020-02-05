package com.google.firebase.storage;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseException;
import com.google.firebase.annotations.PublicApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@PublicApi
/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
public class StorageException extends FirebaseException {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    @PublicApi
    public static final int ERROR_BUCKET_NOT_FOUND = -13011;
    @PublicApi
    public static final int ERROR_CANCELED = -13040;
    @PublicApi
    public static final int ERROR_INVALID_CHECKSUM = -13031;
    @PublicApi
    public static final int ERROR_NOT_AUTHENTICATED = -13020;
    @PublicApi
    public static final int ERROR_NOT_AUTHORIZED = -13021;
    @PublicApi
    public static final int ERROR_OBJECT_NOT_FOUND = -13010;
    @PublicApi
    public static final int ERROR_PROJECT_NOT_FOUND = -13012;
    @PublicApi
    public static final int ERROR_QUOTA_EXCEEDED = -13013;
    @PublicApi
    public static final int ERROR_RETRY_LIMIT_EXCEEDED = -13030;
    @PublicApi
    public static final int ERROR_UNKNOWN = -13000;
    private static final int NETWORK_UNAVAILABLE = -2;
    private static final String TAG = "StorageException";
    private Throwable cause;
    private String detailMessage;
    private final int errorCode;
    private final int httpResultCode;

    @PublicApi
    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
    public @interface ErrorCode {
    }

    static String getErrorMessageForCode(int i) {
        if (i == -13040) {
            return "The operation was cancelled.";
        }
        if (i == -13000) {
            return "An unknown error occurred, please check the HTTP result code and inner exception for server response.";
        }
        if (i == -13031) {
            return "Object has a checksum which does not match. Please retry the operation.";
        }
        if (i == -13030) {
            return "The operation retry limit has been exceeded.";
        }
        if (i == -13021) {
            return "User does not have permission to access this object.";
        }
        if (i == -13020) {
            return "User is not authenticated, please authenticate using Firebase Authentication and try again.";
        }
        switch (i) {
            case ERROR_QUOTA_EXCEEDED /*-13013*/:
                return "Quota for bucket exceeded, please view quota on www.firebase.google.com/storage.";
            case ERROR_PROJECT_NOT_FOUND /*-13012*/:
                return "Project does not exist.";
            case ERROR_BUCKET_NOT_FOUND /*-13011*/:
                return "Bucket does not exist.";
            case ERROR_OBJECT_NOT_FOUND /*-13010*/:
                return "Object does not exist at location.";
            default:
                return "An unknown error occurred, please check the HTTP result code and inner exception for server response.";
        }
    }

    private static boolean isResultSuccess(int i) {
        return i == 0 || (i >= 200 && i < 300);
    }

    StorageException(int i, Throwable th, int i2) {
        this.detailMessage = getErrorMessageForCode(i);
        this.cause = th;
        this.errorCode = i;
        this.httpResultCode = i2;
        Log.e(TAG, "StorageException has occurred.\n" + this.detailMessage + "\n Code: " + Integer.toString(this.errorCode) + " HttpResult: " + Integer.toString(this.httpResultCode));
        Throwable th2 = this.cause;
        if (th2 != null) {
            Log.e(TAG, th2.getMessage(), this.cause);
        }
    }

    private static int calculateErrorCode(Status status) {
        if (status.isCanceled()) {
            return ERROR_CANCELED;
        }
        return status.equals(Status.RESULT_TIMEOUT) ? ERROR_RETRY_LIMIT_EXCEEDED : ERROR_UNKNOWN;
    }

    private static int calculateErrorCode(@Nullable Throwable th, int i) {
        if (th instanceof CancelException) {
            return ERROR_CANCELED;
        }
        if (i == -2) {
            return ERROR_RETRY_LIMIT_EXCEEDED;
        }
        if (i == 401) {
            return ERROR_NOT_AUTHENTICATED;
        }
        if (i == 409) {
            return ERROR_INVALID_CHECKSUM;
        }
        if (i != 403) {
            return i != 404 ? ERROR_UNKNOWN : ERROR_OBJECT_NOT_FOUND;
        }
        return ERROR_NOT_AUTHORIZED;
    }

    @PublicApi
    @NonNull
    public static StorageException fromErrorStatus(@NonNull Status status) {
        Preconditions.checkNotNull(status);
        Preconditions.checkArgument(!status.isSuccess());
        return new StorageException(calculateErrorCode(status), (Throwable) null, 0);
    }

    @PublicApi
    @Nullable
    public static StorageException fromExceptionAndHttpCode(@Nullable Throwable th, int i) {
        if (th instanceof StorageException) {
            return (StorageException) th;
        }
        if (!isResultSuccess(i) || th != null) {
            return new StorageException(calculateErrorCode(th, i), th, i);
        }
        return null;
    }

    @PublicApi
    @NonNull
    public static StorageException fromException(@NonNull Throwable th) {
        return fromExceptionAndHttpCode(th, 0);
    }

    @PublicApi
    public String getMessage() {
        return this.detailMessage;
    }

    @PublicApi
    public synchronized Throwable getCause() {
        if (this.cause == this) {
            return null;
        }
        return this.cause;
    }

    @PublicApi
    public int getErrorCode() {
        return this.errorCode;
    }

    @PublicApi
    public int getHttpResultCode() {
        return this.httpResultCode;
    }

    @PublicApi
    public boolean getIsRecoverableException() {
        return getErrorCode() == -13030;
    }
}

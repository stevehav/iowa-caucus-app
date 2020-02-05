package com.google.firebase.auth.api.internal;

import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.android.gms.internal.firebase_auth.zzed;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.internal.zzu;
import com.google.firebase.auth.zzs;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzdw {
    @VisibleForTesting
    private static final SparseArray<Pair<String, String>> zza;

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ac, code lost:
        return new com.google.firebase.FirebaseApiNotAvailableException(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c2, code lost:
        return new com.google.firebase.auth.FirebaseAuthUserCollisionException(zza(r0), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00cc, code lost:
        return new com.google.firebase.auth.FirebaseAuthException(zza(r0), r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.firebase.FirebaseException zza(com.google.android.gms.common.api.Status r3) {
        /*
            int r0 = r3.getStatusCode()
            java.lang.String r1 = zzb(r0)
            java.lang.String r1 = zza(r1, r3)
            r2 = 17020(0x427c, float:2.385E-41)
            if (r0 == r2) goto L_0x00f1
            r2 = 17021(0x427d, float:2.3852E-41)
            if (r0 == r2) goto L_0x00e7
            r2 = 17051(0x429b, float:2.3894E-41)
            if (r0 == r2) goto L_0x00dd
            r2 = 17052(0x429c, float:2.3895E-41)
            if (r0 == r2) goto L_0x00d7
            r2 = 17057(0x42a1, float:2.3902E-41)
            if (r0 == r2) goto L_0x00cd
            r2 = 17058(0x42a2, float:2.3903E-41)
            if (r0 == r2) goto L_0x00cd
            java.lang.String r2 = "An internal error has occurred."
            switch(r0) {
                case 17000: goto L_0x00dd;
                case 17002: goto L_0x00dd;
                case 17004: goto L_0x00dd;
                case 17005: goto L_0x00e7;
                case 17006: goto L_0x00c3;
                case 17007: goto L_0x00b9;
                case 17008: goto L_0x00dd;
                case 17009: goto L_0x00dd;
                case 17010: goto L_0x00ad;
                case 17011: goto L_0x00e7;
                case 17012: goto L_0x00b9;
                case 17049: goto L_0x00dd;
                case 17068: goto L_0x00c3;
                case 17077: goto L_0x00dd;
                case 17079: goto L_0x00c3;
                case 17080: goto L_0x00a7;
                case 17081: goto L_0x00dd;
                case 17082: goto L_0x00dd;
                case 17083: goto L_0x00dd;
                case 17084: goto L_0x00dd;
                case 17085: goto L_0x00c3;
                case 17086: goto L_0x00c3;
                case 17087: goto L_0x00c3;
                case 17088: goto L_0x00c3;
                case 17089: goto L_0x00c3;
                case 17090: goto L_0x00c3;
                case 17091: goto L_0x00c3;
                case 17495: goto L_0x009b;
                case 17499: goto L_0x0091;
                default: goto L_0x0029;
            }
        L_0x0029:
            switch(r0) {
                case 17014: goto L_0x0087;
                case 17015: goto L_0x007b;
                case 17016: goto L_0x006f;
                case 17017: goto L_0x00e7;
                default: goto L_0x002c;
            }
        L_0x002c:
            switch(r0) {
                case 17024: goto L_0x00dd;
                case 17025: goto L_0x00b9;
                case 17026: goto L_0x0061;
                default: goto L_0x002f;
            }
        L_0x002f:
            switch(r0) {
                case 17028: goto L_0x00c3;
                case 17029: goto L_0x0057;
                case 17030: goto L_0x0057;
                case 17031: goto L_0x004d;
                case 17032: goto L_0x004d;
                case 17033: goto L_0x004d;
                case 17034: goto L_0x00dd;
                case 17035: goto L_0x00dd;
                default: goto L_0x0032;
            }
        L_0x0032:
            switch(r0) {
                case 17040: goto L_0x00c3;
                case 17041: goto L_0x00dd;
                case 17042: goto L_0x00dd;
                case 17043: goto L_0x00dd;
                case 17044: goto L_0x00dd;
                case 17045: goto L_0x00dd;
                case 17046: goto L_0x00dd;
                default: goto L_0x0035;
            }
        L_0x0035:
            switch(r0) {
                case 17061: goto L_0x0041;
                case 17062: goto L_0x00cd;
                case 17063: goto L_0x00a7;
                case 17064: goto L_0x00c3;
                case 17065: goto L_0x00cd;
                default: goto L_0x0038;
            }
        L_0x0038:
            switch(r0) {
                case 17071: goto L_0x00c3;
                case 17072: goto L_0x00c3;
                case 17073: goto L_0x00c3;
                case 17074: goto L_0x00c3;
                case 17075: goto L_0x00dd;
                default: goto L_0x003b;
            }
        L_0x003b:
            com.google.firebase.FirebaseException r3 = new com.google.firebase.FirebaseException
            r3.<init>(r2)
            return r3
        L_0x0041:
            java.lang.String r0 = "There was a failure in the connection between the web widget and the Firebase Auth backend."
            java.lang.String r3 = zza(r0, r3)
            com.google.firebase.FirebaseNetworkException r0 = new com.google.firebase.FirebaseNetworkException
            r0.<init>(r3)
            return r0
        L_0x004d:
            com.google.firebase.auth.FirebaseAuthEmailException r3 = new com.google.firebase.auth.FirebaseAuthEmailException
            java.lang.String r0 = zza((int) r0)
            r3.<init>(r0, r1)
            return r3
        L_0x0057:
            com.google.firebase.auth.FirebaseAuthActionCodeException r3 = new com.google.firebase.auth.FirebaseAuthActionCodeException
            java.lang.String r0 = zza((int) r0)
            r3.<init>(r0, r1)
            return r3
        L_0x0061:
            com.google.firebase.auth.FirebaseAuthWeakPasswordException r2 = new com.google.firebase.auth.FirebaseAuthWeakPasswordException
            java.lang.String r0 = zza((int) r0)
            java.lang.String r3 = r3.getStatusMessage()
            r2.<init>(r0, r1, r3)
            return r2
        L_0x006f:
            java.lang.String r0 = "User was not linked to an account with the given provider."
            java.lang.String r3 = zza(r0, r3)
            com.google.firebase.FirebaseException r0 = new com.google.firebase.FirebaseException
            r0.<init>(r3)
            return r0
        L_0x007b:
            java.lang.String r0 = "User has already been linked to the given provider."
            java.lang.String r3 = zza(r0, r3)
            com.google.firebase.FirebaseException r0 = new com.google.firebase.FirebaseException
            r0.<init>(r3)
            return r0
        L_0x0087:
            com.google.firebase.auth.FirebaseAuthRecentLoginRequiredException r3 = new com.google.firebase.auth.FirebaseAuthRecentLoginRequiredException
            java.lang.String r0 = zza((int) r0)
            r3.<init>(r0, r1)
            return r3
        L_0x0091:
            java.lang.String r3 = zza(r2, r3)
            com.google.firebase.FirebaseException r0 = new com.google.firebase.FirebaseException
            r0.<init>(r3)
            return r0
        L_0x009b:
            java.lang.String r0 = "Please sign in before trying to get a token."
            java.lang.String r3 = zza(r0, r3)
            com.google.firebase.internal.api.FirebaseNoSignedInUserException r0 = new com.google.firebase.internal.api.FirebaseNoSignedInUserException
            r0.<init>(r3)
            return r0
        L_0x00a7:
            com.google.firebase.FirebaseApiNotAvailableException r3 = new com.google.firebase.FirebaseApiNotAvailableException
            r3.<init>(r1)
            return r3
        L_0x00ad:
            java.lang.String r0 = "We have blocked all requests from this device due to unusual activity. Try again later."
            java.lang.String r3 = zza(r0, r3)
            com.google.firebase.FirebaseTooManyRequestsException r0 = new com.google.firebase.FirebaseTooManyRequestsException
            r0.<init>(r3)
            return r0
        L_0x00b9:
            com.google.firebase.auth.FirebaseAuthUserCollisionException r3 = new com.google.firebase.auth.FirebaseAuthUserCollisionException
            java.lang.String r0 = zza((int) r0)
            r3.<init>(r0, r1)
            return r3
        L_0x00c3:
            com.google.firebase.auth.FirebaseAuthException r3 = new com.google.firebase.auth.FirebaseAuthException
            java.lang.String r0 = zza((int) r0)
            r3.<init>(r0, r1)
            return r3
        L_0x00cd:
            com.google.firebase.auth.FirebaseAuthWebException r3 = new com.google.firebase.auth.FirebaseAuthWebException
            java.lang.String r0 = zza((int) r0)
            r3.<init>(r0, r1)
            return r3
        L_0x00d7:
            com.google.firebase.FirebaseTooManyRequestsException r3 = new com.google.firebase.FirebaseTooManyRequestsException
            r3.<init>(r1)
            return r3
        L_0x00dd:
            com.google.firebase.auth.FirebaseAuthInvalidCredentialsException r3 = new com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
            java.lang.String r0 = zza((int) r0)
            r3.<init>(r0, r1)
            return r3
        L_0x00e7:
            com.google.firebase.auth.FirebaseAuthInvalidUserException r3 = new com.google.firebase.auth.FirebaseAuthInvalidUserException
            java.lang.String r0 = zza((int) r0)
            r3.<init>(r0, r1)
            return r3
        L_0x00f1:
            java.lang.String r0 = "A network error (such as timeout, interrupted connection or unreachable host) has occurred."
            java.lang.String r3 = zza(r0, r3)
            com.google.firebase.FirebaseNetworkException r0 = new com.google.firebase.FirebaseNetworkException
            r0.<init>(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.api.internal.zzdw.zza(com.google.android.gms.common.api.Status):com.google.firebase.FirebaseException");
    }

    public static FirebaseAuthUserCollisionException zza(Status status, AuthCredential authCredential, @Nullable String str, @Nullable String str2) {
        int statusCode = status.getStatusCode();
        return new FirebaseAuthUserCollisionException(zza(statusCode), zza(zzb(statusCode), status)).zza(authCredential).zza(str).zzb(str2);
    }

    public static zzs zza(FirebaseAuth firebaseAuth, zzed zzed, @Nullable FirebaseUser firebaseUser) {
        zzao.zza(firebaseAuth);
        zzao.zza(zzed);
        Pair pair = zza.get(17078);
        return new zzs((String) pair.first, (String) pair.second, zzu.zza(zzed, firebaseAuth, firebaseUser));
    }

    private static String zza(String str, Status status) {
        if (TextUtils.isEmpty(status.getStatusMessage())) {
            return str;
        }
        return String.format(String.valueOf(str).concat(" [ %s ]"), new Object[]{status.getStatusMessage()});
    }

    private static String zza(int i) {
        Pair pair = zza.get(i);
        return pair != null ? (String) pair.first : "INTERNAL_ERROR";
    }

    private static String zzb(int i) {
        Pair pair = zza.get(i);
        return pair != null ? (String) pair.second : "An internal error has occurred.";
    }

    static {
        SparseArray<Pair<String, String>> sparseArray = new SparseArray<>();
        zza = sparseArray;
        sparseArray.put(FirebaseError.ERROR_INVALID_CUSTOM_TOKEN, new Pair("ERROR_INVALID_CUSTOM_TOKEN", "The custom token format is incorrect. Please check the documentation."));
        zza.put(FirebaseError.ERROR_CUSTOM_TOKEN_MISMATCH, new Pair("ERROR_CUSTOM_TOKEN_MISMATCH", "The custom token corresponds to a different audience."));
        zza.put(FirebaseError.ERROR_INVALID_CREDENTIAL, new Pair("ERROR_INVALID_CREDENTIAL", "The supplied auth credential is malformed or has expired."));
        zza.put(FirebaseError.ERROR_INVALID_EMAIL, new Pair("ERROR_INVALID_EMAIL", "The email address is badly formatted."));
        zza.put(FirebaseError.ERROR_WRONG_PASSWORD, new Pair("ERROR_WRONG_PASSWORD", "The password is invalid or the user does not have a password."));
        zza.put(FirebaseError.ERROR_USER_MISMATCH, new Pair("ERROR_USER_MISMATCH", "The supplied credentials do not correspond to the previously signed in user."));
        zza.put(FirebaseError.ERROR_REQUIRES_RECENT_LOGIN, new Pair("ERROR_REQUIRES_RECENT_LOGIN", "This operation is sensitive and requires recent authentication. Log in again before retrying this request."));
        zza.put(FirebaseError.ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL, new Pair("ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL", "An account already exists with the same email address but different sign-in credentials. Sign in using a provider associated with this email address."));
        zza.put(FirebaseError.ERROR_EMAIL_ALREADY_IN_USE, new Pair("ERROR_EMAIL_ALREADY_IN_USE", "The email address is already in use by another account."));
        zza.put(FirebaseError.ERROR_CREDENTIAL_ALREADY_IN_USE, new Pair("ERROR_CREDENTIAL_ALREADY_IN_USE", "This credential is already associated with a different user account."));
        zza.put(FirebaseError.ERROR_USER_DISABLED, new Pair("ERROR_USER_DISABLED", "The user account has been disabled by an administrator."));
        zza.put(FirebaseError.ERROR_USER_TOKEN_EXPIRED, new Pair("ERROR_USER_TOKEN_EXPIRED", "The user's credential is no longer valid. The user must sign in again."));
        zza.put(FirebaseError.ERROR_USER_NOT_FOUND, new Pair("ERROR_USER_NOT_FOUND", "There is no user record corresponding to this identifier. The user may have been deleted."));
        zza.put(FirebaseError.ERROR_INVALID_USER_TOKEN, new Pair("ERROR_INVALID_USER_TOKEN", "This user's credential isn't valid for this project. This can happen if the user's token has been tampered with, or if the user isn't for the project associated with this API key."));
        zza.put(FirebaseError.ERROR_OPERATION_NOT_ALLOWED, new Pair("ERROR_OPERATION_NOT_ALLOWED", "The given sign-in provider is disabled for this Firebase project. Enable it in the Firebase console, under the sign-in method tab of the Auth section."));
        zza.put(17026, new Pair("ERROR_WEAK_PASSWORD", "The given password is invalid."));
        zza.put(17029, new Pair("ERROR_EXPIRED_ACTION_CODE", "The out of band code has expired."));
        zza.put(17030, new Pair("ERROR_INVALID_ACTION_CODE", "The out of band code is invalid. This can happen if the code is malformed, expired, or has already been used."));
        zza.put(17031, new Pair("ERROR_INVALID_MESSAGE_PAYLOAD", "The email template corresponding to this action contains invalid characters in its message. Please fix by going to the Auth email templates section in the Firebase Console."));
        zza.put(17033, new Pair("ERROR_INVALID_RECIPIENT_EMAIL", "The email corresponding to this action failed to send as the provided recipient email address is invalid."));
        zza.put(17032, new Pair("ERROR_INVALID_SENDER", "The email template corresponding to this action contains an invalid sender email or name. Please fix by going to the Auth email templates section in the Firebase Console."));
        zza.put(17034, new Pair("ERROR_MISSING_EMAIL", "An email address must be provided."));
        zza.put(17035, new Pair("ERROR_MISSING_PASSWORD", "A password must be provided."));
        zza.put(17041, new Pair("ERROR_MISSING_PHONE_NUMBER", "To send verification codes, provide a phone number for the recipient."));
        zza.put(17042, new Pair("ERROR_INVALID_PHONE_NUMBER", "The format of the phone number provided is incorrect. Please enter the phone number in a format that can be parsed into E.164 format. E.164 phone numbers are written in the format [+][country code][subscriber number including area code]."));
        zza.put(17043, new Pair("ERROR_MISSING_VERIFICATION_CODE", "The Phone Auth Credential was created with an empty sms verification Code"));
        zza.put(17044, new Pair("ERROR_INVALID_VERIFICATION_CODE", "The sms verification code used to create the phone auth credential is invalid. Please resend the verification code sms and be sure use the verification code provided by the user."));
        zza.put(17045, new Pair("ERROR_MISSING_VERIFICATION_ID", "The Phone Auth Credential was created with an empty verification ID"));
        zza.put(17046, new Pair("ERROR_INVALID_VERIFICATION_ID", "The verification ID used to create the phone auth credential is invalid."));
        zza.put(17049, new Pair("ERROR_RETRY_PHONE_AUTH", "An error occurred during authentication using the PhoneAuthCredential. Please retry authentication."));
        zza.put(17051, new Pair("ERROR_SESSION_EXPIRED", "The sms code has expired. Please re-send the verification code to try again."));
        zza.put(17052, new Pair("ERROR_QUOTA_EXCEEDED", "The sms quota for this project has been exceeded."));
        zza.put(FirebaseError.ERROR_APP_NOT_AUTHORIZED, new Pair("ERROR_APP_NOT_AUTHORIZED", "This app is not authorized to use Firebase Authentication. Please verify that the correct package name and SHA-1 are configured in the Firebase Console."));
        zza.put(17063, new Pair("ERROR_API_NOT_AVAILABLE_WITHOUT_GPS", "The API that you are calling is not available on devices without Google Play Services."));
        zza.put(17062, new Pair("ERROR_WEB_INTERNAL_ERROR", "There was an internal error in the web widget."));
        zza.put(17064, new Pair("ERROR_INVALID_CERT_HASH", "There was an error while trying to get your package certificate hash."));
        zza.put(17065, new Pair("ERROR_WEB_STORAGE_UNSUPPORTED", "This browser is not supported or 3rd party cookies and data may be disabled."));
        zza.put(17040, new Pair("ERROR_MISSING_CONTINUE_URI", "A continue URL must be provided in the request."));
        zza.put(17068, new Pair("ERROR_DYNAMIC_LINK_NOT_ACTIVATED", "Please activate Dynamic Links in the Firebase Console and agree to the terms and conditions."));
        zza.put(17071, new Pair("ERROR_INVALID_PROVIDER_ID", "The provider ID provided for the attempted web operation is invalid."));
        zza.put(17057, new Pair("ERROR_WEB_CONTEXT_ALREADY_PRESENTED", "A headful operation is already in progress. Please wait for that to finish."));
        zza.put(17058, new Pair("ERROR_WEB_CONTEXT_CANCELED", "The web operation was canceled by the user."));
        zza.put(17072, new Pair("ERROR_TENANT_ID_MISMATCH", "The provided tenant ID does not match the Auth instance's tenant ID."));
        zza.put(17073, new Pair("ERROR_UNSUPPORTED_TENANT_OPERATION", "This operation is not supported in a multi-tenant context."));
        zza.put(17074, new Pair("ERROR_INVALID_DYNAMIC_LINK_DOMAIN", "The provided dynamic link domain is not configured or authorized for the current project."));
        zza.put(17075, new Pair("ERROR_REJECTED_CREDENTIAL", "The request contains malformed or mismatching credentials"));
        zza.put(17077, new Pair("ERROR_PHONE_NUMBER_NOT_FOUND", "The provided phone number does not match any of the second factor phone numbers associated with this user."));
        zza.put(17079, new Pair("ERROR_INVALID_TENANT_ID", "The Auth instance's tenant ID is invalid."));
        zza.put(17078, new Pair("ERROR_SECOND_FACTOR_REQUIRED", "Please complete a second factor challenge to finish signing into this account."));
        zza.put(17080, new Pair("ERROR_API_NOT_AVAILABLE", "The API that you are calling is not available."));
        zza.put(17081, new Pair("ERROR_MISSING_MULTI_FACTOR_SESSION", "The request is missing proof of first factor successful sign-in."));
        zza.put(17082, new Pair("ERROR_MISSING_MULTI_FACTOR_INFO", "No second factor identifier is provided."));
        zza.put(17083, new Pair("ERROR_INVALID_MULTI_FACTOR_SESSION", "The request does not contain a valid proof of first factor successful sign-in."));
        zza.put(17084, new Pair("ERROR_MULTI_FACTOR_INFO_NOT_FOUND", "The user does not have a second factor matching the identifier provided."));
        zza.put(17085, new Pair("ERROR_ADMIN_RESTRICTED_OPERATION", "This operation is restricted to administrators only."));
        zza.put(17086, new Pair("ERROR_UNVERIFIED_EMAIL", "This operation requires a verified email."));
        zza.put(17087, new Pair("ERROR_SECOND_FACTOR_ALREADY_ENROLLED", "The second factor is already enrolled on this account."));
        zza.put(17088, new Pair("ERROR_MAXIMUM_SECOND_FACTOR_COUNT_EXCEEDED", "The maximum allowed number of second factors on a user has been exceeded."));
        zza.put(17089, new Pair("ERROR_UNSUPPORTED_FIRST_FACTOR", "Enrolling a second factor or signing in with a multi-factor account requires sign-in with a supported first factor."));
        zza.put(17090, new Pair("ERROR_EMAIL_CHANGE_NEEDS_VERIFICATION", "Multi-factor users must always have a verified email."));
        zza.put(17091, new Pair("INTERNAL_SUCCESS_SIGN_OUT", "This is an internal error code indicating that the operation was successful but the user needs to be signed out."));
    }
}

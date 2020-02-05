package io.invertase.firebase.auth;

import android.app.Activity;
import android.net.Uri;
import android.os.Parcel;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.UserProfileChangeRequest;
import io.invertase.firebase.auth.ReactNativeFirebaseAuthModule;
import io.invertase.firebase.common.ReactNativeFirebaseEvent;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import io.invertase.firebase.common.SharedUtils;
import io.sentry.marshaller.json.JsonMarshaller;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

class ReactNativeFirebaseAuthModule extends ReactNativeFirebaseModule {
    private static final String TAG = "Auth";
    private static HashMap<String, FirebaseAuth.AuthStateListener> mAuthListeners = new HashMap<>();
    private static HashMap<String, FirebaseAuth.IdTokenListener> mIdTokenListeners = new HashMap<>();
    /* access modifiers changed from: private */
    public PhoneAuthCredential mCredential;
    /* access modifiers changed from: private */
    public PhoneAuthProvider.ForceResendingToken mForceResendingToken;
    private String mLastPhoneNumber;
    /* access modifiers changed from: private */
    public String mVerificationId;

    ReactNativeFirebaseAuthModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, TAG);
    }

    public void initialize() {
        super.initialize();
        Log.d(TAG, "instance-initialized");
    }

    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        Log.d(TAG, "instance-destroyed");
        Iterator<Map.Entry<String, FirebaseAuth.AuthStateListener>> it = mAuthListeners.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            FirebaseAuth.getInstance(FirebaseApp.getInstance((String) next.getKey())).removeAuthStateListener((FirebaseAuth.AuthStateListener) next.getValue());
            it.remove();
        }
        Iterator<Map.Entry<String, FirebaseAuth.IdTokenListener>> it2 = mIdTokenListeners.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry next2 = it2.next();
            FirebaseAuth.getInstance(FirebaseApp.getInstance((String) next2.getKey())).removeIdTokenListener((FirebaseAuth.IdTokenListener) next2.getValue());
            it2.remove();
        }
    }

    @ReactMethod
    public void addAuthStateListener(String str) {
        Log.d(TAG, "addAuthStateListener");
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        if (mAuthListeners.get(str) == null) {
            $$Lambda$ReactNativeFirebaseAuthModule$1ixZCmqjTrTmfmlsy4F5KeEt42o r1 = new FirebaseAuth.AuthStateListener(str) {
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void onAuthStateChanged(FirebaseAuth firebaseAuth) {
                    ReactNativeFirebaseAuthModule.this.lambda$addAuthStateListener$0$ReactNativeFirebaseAuthModule(this.f$1, firebaseAuth);
                }
            };
            instance.addAuthStateListener(r1);
            mAuthListeners.put(str, r1);
        }
    }

    public /* synthetic */ void lambda$addAuthStateListener$0$ReactNativeFirebaseAuthModule(String str, FirebaseAuth firebaseAuth) {
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        WritableMap createMap = Arguments.createMap();
        ReactNativeFirebaseEventEmitter sharedInstance = ReactNativeFirebaseEventEmitter.getSharedInstance();
        if (currentUser != null) {
            createMap.putString("appName", str);
            createMap.putMap("user", firebaseUserToMap(currentUser));
        } else {
            createMap.putString("appName", str);
        }
        Log.d(TAG, "addAuthStateListener:eventBody " + createMap.toString());
        sharedInstance.sendEvent(new ReactNativeFirebaseEvent("auth_state_changed", createMap, str));
    }

    @ReactMethod
    public void removeAuthStateListener(String str) {
        Log.d(TAG, "removeAuthStateListener");
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseAuth.AuthStateListener authStateListener = mAuthListeners.get(str);
        if (authStateListener != null) {
            instance.removeAuthStateListener(authStateListener);
            mAuthListeners.remove(str);
        }
    }

    @ReactMethod
    public void addIdTokenListener(String str) {
        Log.d(TAG, "addIdTokenListener");
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        if (!mIdTokenListeners.containsKey(str)) {
            $$Lambda$ReactNativeFirebaseAuthModule$5JqUkZF8Z54TMSLYILx1SQyKdw r1 = new FirebaseAuth.IdTokenListener(str) {
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void onIdTokenChanged(FirebaseAuth firebaseAuth) {
                    ReactNativeFirebaseAuthModule.this.lambda$addIdTokenListener$1$ReactNativeFirebaseAuthModule(this.f$1, firebaseAuth);
                }
            };
            instance.addIdTokenListener((FirebaseAuth.IdTokenListener) r1);
            mIdTokenListeners.put(str, r1);
        }
    }

    public /* synthetic */ void lambda$addIdTokenListener$1$ReactNativeFirebaseAuthModule(String str, FirebaseAuth firebaseAuth) {
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        ReactNativeFirebaseEventEmitter sharedInstance = ReactNativeFirebaseEventEmitter.getSharedInstance();
        WritableMap createMap = Arguments.createMap();
        if (currentUser != null) {
            createMap.putBoolean("authenticated", true);
            createMap.putString("appName", str);
            createMap.putMap("user", firebaseUserToMap(currentUser));
        } else {
            createMap.putString("appName", str);
            createMap.putBoolean("authenticated", false);
        }
        sharedInstance.sendEvent(new ReactNativeFirebaseEvent("auth_id_token_changed", createMap, str));
    }

    @ReactMethod
    public void removeIdTokenListener(String str) {
        Log.d(TAG, "removeIdTokenListener");
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseAuth.IdTokenListener idTokenListener = mIdTokenListeners.get(str);
        if (idTokenListener != null) {
            instance.removeIdTokenListener(idTokenListener);
            mIdTokenListeners.remove(str);
        }
    }

    @ReactMethod
    public void setAutoRetrievedSmsCodeForPhoneNumber(String str, String str2, String str3, Promise promise) {
        Log.d(TAG, "setAutoRetrievedSmsCodeForPhoneNumber");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).getFirebaseAuthSettings().setAutoRetrievedSmsCodeForPhoneNumber(str2, str3);
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void signOut(String str, Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        Log.d(TAG, "signOut");
        if (instance == null || instance.getCurrentUser() == null) {
            promiseNoUser(promise, true);
            return;
        }
        instance.signOut();
        promiseNoUser(promise, false);
    }

    @ReactMethod
    private void signInAnonymously(String str, Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        Log.d(TAG, "signInAnonymously");
        instance.signInAnonymously().addOnSuccessListener(new OnSuccessListener(promise) {
            private final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onSuccess(Object obj) {
                ReactNativeFirebaseAuthModule.this.lambda$signInAnonymously$2$ReactNativeFirebaseAuthModule(this.f$1, (AuthResult) obj);
            }
        }).addOnFailureListener(new OnFailureListener(promise) {
            private final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onFailure(Exception exc) {
                ReactNativeFirebaseAuthModule.this.lambda$signInAnonymously$3$ReactNativeFirebaseAuthModule(this.f$1, exc);
            }
        });
    }

    public /* synthetic */ void lambda$signInAnonymously$2$ReactNativeFirebaseAuthModule(Promise promise, AuthResult authResult) {
        Log.d(TAG, "signInAnonymously:onComplete:success");
        promiseWithAuthResult(authResult, promise);
    }

    public /* synthetic */ void lambda$signInAnonymously$3$ReactNativeFirebaseAuthModule(Promise promise, Exception exc) {
        Log.e(TAG, "signInAnonymously:onComplete:failure", exc);
        promiseRejectAuthException(promise, exc);
    }

    @ReactMethod
    private void createUserWithEmailAndPassword(String str, String str2, String str3, Promise promise) {
        Log.d(TAG, "createUserWithEmailAndPassword");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).createUserWithEmailAndPassword(str2, str3).addOnSuccessListener(new OnSuccessListener(promise) {
            private final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onSuccess(Object obj) {
                ReactNativeFirebaseAuthModule.this.lambda$createUserWithEmailAndPassword$4$ReactNativeFirebaseAuthModule(this.f$1, (AuthResult) obj);
            }
        }).addOnFailureListener(new OnFailureListener(promise) {
            private final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onFailure(Exception exc) {
                ReactNativeFirebaseAuthModule.this.lambda$createUserWithEmailAndPassword$5$ReactNativeFirebaseAuthModule(this.f$1, exc);
            }
        });
    }

    public /* synthetic */ void lambda$createUserWithEmailAndPassword$4$ReactNativeFirebaseAuthModule(Promise promise, AuthResult authResult) {
        Log.d(TAG, "createUserWithEmailAndPassword:onComplete:success");
        promiseWithAuthResult(authResult, promise);
        Log.d(TAG, "createUserWithEmailAndPassword:onComplete:promiseResolved");
    }

    public /* synthetic */ void lambda$createUserWithEmailAndPassword$5$ReactNativeFirebaseAuthModule(Promise promise, Exception exc) {
        Log.e(TAG, "createUserWithEmailAndPassword:onComplete:failure", exc);
        promiseRejectAuthException(promise, exc);
    }

    @ReactMethod
    private void signInWithEmailAndPassword(String str, String str2, String str3, Promise promise) {
        Log.d(TAG, "signInWithEmailAndPassword");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).signInWithEmailAndPassword(str2, str3).addOnSuccessListener(new OnSuccessListener(promise) {
            private final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onSuccess(Object obj) {
                ReactNativeFirebaseAuthModule.this.lambda$signInWithEmailAndPassword$6$ReactNativeFirebaseAuthModule(this.f$1, (AuthResult) obj);
            }
        }).addOnFailureListener(new OnFailureListener(promise) {
            private final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onFailure(Exception exc) {
                ReactNativeFirebaseAuthModule.this.lambda$signInWithEmailAndPassword$7$ReactNativeFirebaseAuthModule(this.f$1, exc);
            }
        });
    }

    public /* synthetic */ void lambda$signInWithEmailAndPassword$6$ReactNativeFirebaseAuthModule(Promise promise, AuthResult authResult) {
        Log.d(TAG, "signInWithEmailAndPassword:onComplete:success");
        promiseWithAuthResult(authResult, promise);
    }

    public /* synthetic */ void lambda$signInWithEmailAndPassword$7$ReactNativeFirebaseAuthModule(Promise promise, Exception exc) {
        Log.e(TAG, "signInWithEmailAndPassword:onComplete:failure", exc);
        promiseRejectAuthException(promise, exc);
    }

    @ReactMethod
    private void signInWithEmailLink(String str, String str2, String str3, Promise promise) {
        Log.d(TAG, "signInWithEmailLink");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).signInWithEmailLink(str2, str3).addOnSuccessListener(new OnSuccessListener(promise) {
            private final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onSuccess(Object obj) {
                ReactNativeFirebaseAuthModule.this.lambda$signInWithEmailLink$8$ReactNativeFirebaseAuthModule(this.f$1, (AuthResult) obj);
            }
        }).addOnFailureListener(new OnFailureListener(promise) {
            private final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onFailure(Exception exc) {
                ReactNativeFirebaseAuthModule.this.lambda$signInWithEmailLink$9$ReactNativeFirebaseAuthModule(this.f$1, exc);
            }
        });
    }

    public /* synthetic */ void lambda$signInWithEmailLink$8$ReactNativeFirebaseAuthModule(Promise promise, AuthResult authResult) {
        Log.d(TAG, "signInWithEmailLink:onComplete:success");
        promiseWithAuthResult(authResult, promise);
    }

    public /* synthetic */ void lambda$signInWithEmailLink$9$ReactNativeFirebaseAuthModule(Promise promise, Exception exc) {
        Log.e(TAG, "signInWithEmailLink:onComplete:failure", exc);
        promiseRejectAuthException(promise, exc);
    }

    @ReactMethod
    private void signInWithCustomToken(String str, String str2, Promise promise) {
        Log.d(TAG, "signInWithCustomToken");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).signInWithCustomToken(str2).addOnSuccessListener(new OnSuccessListener(promise) {
            private final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onSuccess(Object obj) {
                ReactNativeFirebaseAuthModule.this.lambda$signInWithCustomToken$10$ReactNativeFirebaseAuthModule(this.f$1, (AuthResult) obj);
            }
        }).addOnFailureListener(new OnFailureListener(promise) {
            private final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onFailure(Exception exc) {
                ReactNativeFirebaseAuthModule.this.lambda$signInWithCustomToken$11$ReactNativeFirebaseAuthModule(this.f$1, exc);
            }
        });
    }

    public /* synthetic */ void lambda$signInWithCustomToken$10$ReactNativeFirebaseAuthModule(Promise promise, AuthResult authResult) {
        Log.d(TAG, "signInWithCustomToken:onComplete:success");
        promiseWithAuthResult(authResult, promise);
    }

    public /* synthetic */ void lambda$signInWithCustomToken$11$ReactNativeFirebaseAuthModule(Promise promise, Exception exc) {
        Log.e(TAG, "signInWithCustomToken:onComplete:failure", exc);
        promiseRejectAuthException(promise, exc);
    }

    @ReactMethod
    public void sendPasswordResetEmail(String str, String str2, ReadableMap readableMap, Promise promise) {
        Log.d(TAG, "sendPasswordResetEmail");
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        $$Lambda$ReactNativeFirebaseAuthModule$bEUsCogEv5OO8_w0eJASpp_2ox8 r0 = new OnCompleteListener(promise) {
            private final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$sendPasswordResetEmail$12$ReactNativeFirebaseAuthModule(this.f$1, task);
            }
        };
        if (readableMap == null) {
            instance.sendPasswordResetEmail(str2).addOnCompleteListener((Executor) getExecutor(), r0);
        } else {
            instance.sendPasswordResetEmail(str2, buildActionCodeSettings(readableMap)).addOnCompleteListener((Executor) getExecutor(), r0);
        }
    }

    public /* synthetic */ void lambda$sendPasswordResetEmail$12$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "sendPasswordResetEmail:onComplete:success");
            promiseNoUser(promise, false);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "sendPasswordResetEmail:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void sendSignInLinkToEmail(String str, String str2, ReadableMap readableMap, Promise promise) {
        Log.d(TAG, "sendSignInLinkToEmail");
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        instance.sendSignInLinkToEmail(str2, buildActionCodeSettings(readableMap)).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(promise) {
            private final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$sendSignInLinkToEmail$13$ReactNativeFirebaseAuthModule(this.f$1, task);
            }
        });
    }

    public /* synthetic */ void lambda$sendSignInLinkToEmail$13$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "sendSignInLinkToEmail:onComplete:success");
            promiseNoUser(promise, false);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "sendSignInLinkToEmail:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void delete(String str, Promise promise) {
        FirebaseUser currentUser = FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).getCurrentUser();
        Log.d(TAG, "delete");
        if (currentUser != null) {
            currentUser.delete().addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(promise) {
                private final /* synthetic */ Promise f$1;

                {
                    this.f$1 = r2;
                }

                public final void onComplete(Task task) {
                    ReactNativeFirebaseAuthModule.this.lambda$delete$14$ReactNativeFirebaseAuthModule(this.f$1, task);
                }
            });
            return;
        }
        Log.e(TAG, "delete:failure:noCurrentUser");
        promiseNoUser(promise, true);
    }

    public /* synthetic */ void lambda$delete$14$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "delete:onComplete:success");
            promiseNoUser(promise, false);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "delete:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void reload(String str, Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseUser currentUser = instance.getCurrentUser();
        Log.d(TAG, "reload");
        if (currentUser == null) {
            promiseNoUser(promise, false);
            Log.e(TAG, "reload:failure:noCurrentUser");
            return;
        }
        currentUser.reload().addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(instance, promise) {
            private final /* synthetic */ FirebaseAuth f$1;
            private final /* synthetic */ Promise f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$reload$15$ReactNativeFirebaseAuthModule(this.f$1, this.f$2, task);
            }
        });
    }

    public /* synthetic */ void lambda$reload$15$ReactNativeFirebaseAuthModule(FirebaseAuth firebaseAuth, Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "reload:onComplete:success");
            promiseWithUser(firebaseAuth.getCurrentUser(), promise);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "reload:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void sendEmailVerification(String str, ReadableMap readableMap, Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseUser currentUser = instance.getCurrentUser();
        Log.d(TAG, "sendEmailVerification");
        if (currentUser == null) {
            promiseNoUser(promise, false);
            Log.e(TAG, "sendEmailVerification:failure:noCurrentUser");
            return;
        }
        $$Lambda$ReactNativeFirebaseAuthModule$e3x74IJGDc4y5KCynXjJ71f6a_A r1 = new OnCompleteListener(instance, promise) {
            private final /* synthetic */ FirebaseAuth f$1;
            private final /* synthetic */ Promise f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$sendEmailVerification$16$ReactNativeFirebaseAuthModule(this.f$1, this.f$2, task);
            }
        };
        if (readableMap == null) {
            currentUser.sendEmailVerification().addOnCompleteListener((Executor) getExecutor(), r1);
        } else {
            currentUser.sendEmailVerification(buildActionCodeSettings(readableMap)).addOnCompleteListener((Executor) getExecutor(), r1);
        }
    }

    public /* synthetic */ void lambda$sendEmailVerification$16$ReactNativeFirebaseAuthModule(FirebaseAuth firebaseAuth, Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "sendEmailVerification:onComplete:success");
            promiseWithUser(firebaseAuth.getCurrentUser(), promise);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "sendEmailVerification:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void updateEmail(String str, String str2, Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseUser currentUser = instance.getCurrentUser();
        Log.d(TAG, "updateEmail");
        if (currentUser == null) {
            promiseNoUser(promise, false);
            Log.e(TAG, "updateEmail:failure:noCurrentUser");
            return;
        }
        currentUser.updateEmail(str2).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(instance, promise) {
            private final /* synthetic */ FirebaseAuth f$1;
            private final /* synthetic */ Promise f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$updateEmail$17$ReactNativeFirebaseAuthModule(this.f$1, this.f$2, task);
            }
        });
    }

    public /* synthetic */ void lambda$updateEmail$17$ReactNativeFirebaseAuthModule(FirebaseAuth firebaseAuth, Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "updateEmail:onComplete:success");
            promiseWithUser(firebaseAuth.getCurrentUser(), promise);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "updateEmail:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void updatePassword(String str, String str2, Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseUser currentUser = instance.getCurrentUser();
        Log.d(TAG, "updatePassword");
        if (currentUser == null) {
            promiseNoUser(promise, false);
            Log.e(TAG, "updatePassword:failure:noCurrentUser");
            return;
        }
        currentUser.updatePassword(str2).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(instance, promise) {
            private final /* synthetic */ FirebaseAuth f$1;
            private final /* synthetic */ Promise f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$updatePassword$18$ReactNativeFirebaseAuthModule(this.f$1, this.f$2, task);
            }
        });
    }

    public /* synthetic */ void lambda$updatePassword$18$ReactNativeFirebaseAuthModule(FirebaseAuth firebaseAuth, Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "updatePassword:onComplete:success");
            promiseWithUser(firebaseAuth.getCurrentUser(), promise);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "updatePassword:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    private void updatePhoneNumber(String str, String str2, String str3, String str4, Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseUser currentUser = instance.getCurrentUser();
        if (!str2.equals("phone")) {
            rejectPromiseWithCodeAndMessage(promise, "invalid-credential", "The supplied auth credential does not have a phone provider.");
        }
        PhoneAuthCredential phoneAuthCredential = getPhoneAuthCredential(str3, str4);
        if (phoneAuthCredential == null) {
            rejectPromiseWithCodeAndMessage(promise, "invalid-credential", "The supplied auth credential is malformed, has expired or is not currently supported.");
        } else if (currentUser == null) {
            promiseNoUser(promise, false);
            Log.e(TAG, "updatePhoneNumber:failure:noCurrentUser");
        } else {
            Log.d(TAG, "updatePhoneNumber");
            currentUser.updatePhoneNumber(phoneAuthCredential).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(instance, promise) {
                private final /* synthetic */ FirebaseAuth f$1;
                private final /* synthetic */ Promise f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onComplete(Task task) {
                    ReactNativeFirebaseAuthModule.this.lambda$updatePhoneNumber$19$ReactNativeFirebaseAuthModule(this.f$1, this.f$2, task);
                }
            });
        }
    }

    public /* synthetic */ void lambda$updatePhoneNumber$19$ReactNativeFirebaseAuthModule(FirebaseAuth firebaseAuth, Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "updatePhoneNumber:onComplete:success");
            promiseWithUser(firebaseAuth.getCurrentUser(), promise);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "updatePhoneNumber:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void updateProfile(String str, ReadableMap readableMap, Promise promise) {
        Uri uri;
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseUser currentUser = instance.getCurrentUser();
        Log.d(TAG, "updateProfile");
        if (currentUser == null) {
            promiseNoUser(promise, false);
            Log.e(TAG, "updateProfile:failure:noCurrentUser");
            return;
        }
        UserProfileChangeRequest.Builder builder = new UserProfileChangeRequest.Builder();
        if (readableMap.hasKey("displayName")) {
            builder.setDisplayName(readableMap.getString("displayName"));
        }
        if (readableMap.hasKey("photoURL")) {
            String string = readableMap.getString("photoURL");
            if (string == null) {
                uri = null;
            } else {
                uri = Uri.parse(string);
            }
            builder.setPhotoUri(uri);
        }
        currentUser.updateProfile(builder.build()).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(instance, promise) {
            private final /* synthetic */ FirebaseAuth f$1;
            private final /* synthetic */ Promise f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$updateProfile$20$ReactNativeFirebaseAuthModule(this.f$1, this.f$2, task);
            }
        });
    }

    public /* synthetic */ void lambda$updateProfile$20$ReactNativeFirebaseAuthModule(FirebaseAuth firebaseAuth, Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "updateProfile:onComplete:success");
            promiseWithUser(firebaseAuth.getCurrentUser(), promise);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "updateProfile:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    private void signInWithCredential(String str, String str2, String str3, String str4, Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        AuthCredential credentialForProvider = getCredentialForProvider(str2, str3, str4);
        if (credentialForProvider == null) {
            rejectPromiseWithCodeAndMessage(promise, "invalid-credential", "The supplied auth credential is malformed, has expired or is not currently supported.");
            return;
        }
        Log.d(TAG, "signInWithCredential");
        instance.signInWithCredential(credentialForProvider).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(promise) {
            private final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$signInWithCredential$21$ReactNativeFirebaseAuthModule(this.f$1, task);
            }
        });
    }

    public /* synthetic */ void lambda$signInWithCredential$21$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "signInWithCredential:onComplete:success");
            promiseWithAuthResult((AuthResult) task.getResult(), promise);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "signInWithCredential:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void signInWithPhoneNumber(String str, String str2, boolean z, final Promise promise) {
        Log.d(TAG, "signInWithPhoneNumber");
        final FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        Activity currentActivity = getCurrentActivity();
        if (!str2.equals(this.mLastPhoneNumber)) {
            this.mForceResendingToken = null;
            this.mLastPhoneNumber = str2;
        }
        this.mVerificationId = null;
        AnonymousClass1 r6 = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            private boolean promiseResolved = false;

            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                instance.signInWithCredential(phoneAuthCredential).addOnCompleteListener((Executor) ReactNativeFirebaseAuthModule.this.getExecutor(), new OnCompleteListener(phoneAuthCredential, promise) {
                    private final /* synthetic */ PhoneAuthCredential f$1;
                    private final /* synthetic */ Promise f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onComplete(Task task) {
                        ReactNativeFirebaseAuthModule.AnonymousClass1.this.lambda$onVerificationCompleted$0$ReactNativeFirebaseAuthModule$1(this.f$1, this.f$2, task);
                    }
                });
            }

            public /* synthetic */ void lambda$onVerificationCompleted$0$ReactNativeFirebaseAuthModule$1(PhoneAuthCredential phoneAuthCredential, Promise promise, Task task) {
                if (task.isSuccessful()) {
                    Log.d(ReactNativeFirebaseAuthModule.TAG, "signInWithPhoneNumber:autoVerified:signInWithCredential:onComplete:success");
                    if (!this.promiseResolved) {
                        WritableMap createMap = Arguments.createMap();
                        Parcel obtain = Parcel.obtain();
                        phoneAuthCredential.writeToParcel(obtain, 0);
                        obtain.setDataPosition(16);
                        String readString = obtain.readString();
                        String unused = ReactNativeFirebaseAuthModule.this.mVerificationId = readString;
                        obtain.recycle();
                        createMap.putString("verificationId", readString);
                        promise.resolve(createMap);
                        return;
                    }
                    return;
                }
                Exception exception = task.getException();
                Log.e(ReactNativeFirebaseAuthModule.TAG, "signInWithPhoneNumber:autoVerified:signInWithCredential:onComplete:failure", exception);
                if (!this.promiseResolved) {
                    ReactNativeFirebaseAuthModule.this.promiseRejectAuthException(promise, exception);
                }
            }

            public void onVerificationFailed(FirebaseException firebaseException) {
                Log.d(ReactNativeFirebaseAuthModule.TAG, "signInWithPhoneNumber:verification:failed");
                ReactNativeFirebaseAuthModule.this.promiseRejectAuthException(promise, firebaseException);
            }

            public void onCodeSent(String str, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                String unused = ReactNativeFirebaseAuthModule.this.mVerificationId = str;
                PhoneAuthProvider.ForceResendingToken unused2 = ReactNativeFirebaseAuthModule.this.mForceResendingToken = forceResendingToken;
                WritableMap createMap = Arguments.createMap();
                createMap.putString("verificationId", str);
                promise.resolve(createMap);
                this.promiseResolved = true;
            }

            public void onCodeAutoRetrievalTimeOut(String str) {
                super.onCodeAutoRetrievalTimeOut(str);
            }
        };
        if (currentActivity == null) {
            return;
        }
        if (!z || this.mForceResendingToken == null) {
            PhoneAuthProvider.getInstance(instance).verifyPhoneNumber(str2, 60, TimeUnit.SECONDS, currentActivity, (PhoneAuthProvider.OnVerificationStateChangedCallbacks) r6);
            return;
        }
        PhoneAuthProvider.getInstance(instance).verifyPhoneNumber(str2, 60, TimeUnit.SECONDS, currentActivity, (PhoneAuthProvider.OnVerificationStateChangedCallbacks) r6, this.mForceResendingToken);
    }

    @ReactMethod
    public void confirmationResultConfirm(String str, String str2, Promise promise) {
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).signInWithCredential(PhoneAuthProvider.getCredential(this.mVerificationId, str2)).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(promise) {
            private final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$confirmationResultConfirm$22$ReactNativeFirebaseAuthModule(this.f$1, task);
            }
        });
    }

    public /* synthetic */ void lambda$confirmationResultConfirm$22$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "confirmationResultConfirm:signInWithCredential:onComplete:success");
            Object result = task.getResult();
            result.getClass();
            promiseWithUser(((AuthResult) result).getUser(), promise);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "confirmationResultConfirm:signInWithCredential:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void verifyPhoneNumber(final String str, String str2, final String str3, int i, boolean z) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        Activity currentActivity = getCurrentActivity();
        Log.d(TAG, "verifyPhoneNumber:" + str2);
        if (!str2.equals(this.mLastPhoneNumber)) {
            this.mForceResendingToken = null;
            this.mLastPhoneNumber = str2;
        }
        this.mCredential = null;
        AnonymousClass2 r7 = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                PhoneAuthCredential unused = ReactNativeFirebaseAuthModule.this.mCredential = phoneAuthCredential;
                Log.d(ReactNativeFirebaseAuthModule.TAG, "verifyPhoneNumber:verification:onVerificationCompleted");
                WritableMap createMap = Arguments.createMap();
                Parcel obtain = Parcel.obtain();
                phoneAuthCredential.writeToParcel(obtain, 0);
                obtain.setDataPosition(16);
                String readString = obtain.readString();
                obtain.setDataPosition(obtain.dataPosition() + 8);
                createMap.putString("code", obtain.readString());
                createMap.putString("verificationId", readString);
                obtain.recycle();
                ReactNativeFirebaseAuthModule.this.sendPhoneStateEvent(str, str3, "onVerificationComplete", createMap);
            }

            public void onVerificationFailed(FirebaseException firebaseException) {
                Log.d(ReactNativeFirebaseAuthModule.TAG, "verifyPhoneNumber:verification:onVerificationFailed");
                WritableMap createMap = Arguments.createMap();
                createMap.putMap("error", ReactNativeFirebaseAuthModule.this.getJSError(firebaseException));
                ReactNativeFirebaseAuthModule.this.sendPhoneStateEvent(str, str3, "onVerificationFailed", createMap);
            }

            public void onCodeSent(String str, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                Log.d(ReactNativeFirebaseAuthModule.TAG, "verifyPhoneNumber:verification:onCodeSent");
                PhoneAuthProvider.ForceResendingToken unused = ReactNativeFirebaseAuthModule.this.mForceResendingToken = forceResendingToken;
                WritableMap createMap = Arguments.createMap();
                createMap.putString("verificationId", str);
                createMap.putString("verificationId", str);
                ReactNativeFirebaseAuthModule.this.sendPhoneStateEvent(str, str3, "onCodeSent", createMap);
            }

            public void onCodeAutoRetrievalTimeOut(String str) {
                super.onCodeAutoRetrievalTimeOut(str);
                Log.d(ReactNativeFirebaseAuthModule.TAG, "verifyPhoneNumber:verification:onCodeAutoRetrievalTimeOut");
                WritableMap createMap = Arguments.createMap();
                createMap.putString("verificationId", str);
                ReactNativeFirebaseAuthModule.this.sendPhoneStateEvent(str, str3, "onCodeAutoRetrievalTimeout", createMap);
            }
        };
        if (currentActivity == null) {
            return;
        }
        if (!z || this.mForceResendingToken == null) {
            PhoneAuthProvider.getInstance(instance).verifyPhoneNumber(str2, (long) i, TimeUnit.SECONDS, currentActivity, (PhoneAuthProvider.OnVerificationStateChangedCallbacks) r7);
            return;
        }
        PhoneAuthProvider.getInstance(instance).verifyPhoneNumber(str2, (long) i, TimeUnit.SECONDS, currentActivity, (PhoneAuthProvider.OnVerificationStateChangedCallbacks) r7, this.mForceResendingToken);
    }

    @ReactMethod
    public void confirmPasswordReset(String str, String str2, String str3, Promise promise) {
        Log.d(TAG, "confirmPasswordReset");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).confirmPasswordReset(str2, str3).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(promise) {
            private final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$confirmPasswordReset$23$ReactNativeFirebaseAuthModule(this.f$1, task);
            }
        });
    }

    public /* synthetic */ void lambda$confirmPasswordReset$23$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "confirmPasswordReset:onComplete:success");
            promiseNoUser(promise, false);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "confirmPasswordReset:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void applyActionCode(String str, String str2, Promise promise) {
        Log.d(TAG, "applyActionCode");
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        instance.applyActionCode(str2).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(instance, promise) {
            private final /* synthetic */ FirebaseAuth f$1;
            private final /* synthetic */ Promise f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$applyActionCode$24$ReactNativeFirebaseAuthModule(this.f$1, this.f$2, task);
            }
        });
    }

    public /* synthetic */ void lambda$applyActionCode$24$ReactNativeFirebaseAuthModule(FirebaseAuth firebaseAuth, Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "applyActionCode:onComplete:success");
            promiseWithUser(firebaseAuth.getCurrentUser(), promise);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "applyActionCode:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void checkActionCode(String str, String str2, Promise promise) {
        Log.d(TAG, "checkActionCode");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).checkActionCode(str2).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(promise) {
            private final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$checkActionCode$25$ReactNativeFirebaseAuthModule(this.f$1, task);
            }
        });
    }

    public /* synthetic */ void lambda$checkActionCode$25$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "checkActionCode:onComplete:success");
            Object result = task.getResult();
            result.getClass();
            ActionCodeResult actionCodeResult = (ActionCodeResult) result;
            WritableMap createMap = Arguments.createMap();
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putString("email", actionCodeResult.getData(0));
            createMap2.putString("fromEmail", actionCodeResult.getData(1));
            createMap.putMap("data", createMap2);
            int operation = actionCodeResult.getOperation();
            createMap.putString("operation", operation != 0 ? operation != 1 ? operation != 2 ? operation != 3 ? operation != 4 ? "UNKNOWN" : "EMAIL_SIGNIN" : "ERROR" : "RECOVER_EMAIL" : "VERIFY_EMAIL" : "PASSWORD_RESET");
            promise.resolve(createMap);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "checkActionCode:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    private void linkWithCredential(String str, String str2, String str3, String str4, Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        AuthCredential credentialForProvider = getCredentialForProvider(str2, str3, str4);
        if (credentialForProvider == null) {
            rejectPromiseWithCodeAndMessage(promise, "invalid-credential", "The supplied auth credential is malformed, has expired or is not currently supported.");
            return;
        }
        FirebaseUser currentUser = instance.getCurrentUser();
        Log.d(TAG, "link");
        if (currentUser != null) {
            currentUser.linkWithCredential(credentialForProvider).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(promise) {
                private final /* synthetic */ Promise f$1;

                {
                    this.f$1 = r2;
                }

                public final void onComplete(Task task) {
                    ReactNativeFirebaseAuthModule.this.lambda$linkWithCredential$26$ReactNativeFirebaseAuthModule(this.f$1, task);
                }
            });
        } else {
            promiseNoUser(promise, true);
        }
    }

    public /* synthetic */ void lambda$linkWithCredential$26$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "link:onComplete:success");
            promiseWithAuthResult((AuthResult) task.getResult(), promise);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "link:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void unlink(String str, String str2, Promise promise) {
        FirebaseUser currentUser = FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).getCurrentUser();
        Log.d(TAG, "unlink");
        if (currentUser != null) {
            currentUser.unlink(str2).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(promise) {
                private final /* synthetic */ Promise f$1;

                {
                    this.f$1 = r2;
                }

                public final void onComplete(Task task) {
                    ReactNativeFirebaseAuthModule.this.lambda$unlink$27$ReactNativeFirebaseAuthModule(this.f$1, task);
                }
            });
        } else {
            promiseNoUser(promise, true);
        }
    }

    public /* synthetic */ void lambda$unlink$27$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "unlink:onComplete:success");
            Object result = task.getResult();
            result.getClass();
            promiseWithUser(((AuthResult) result).getUser(), promise);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "unlink:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    private void reauthenticateWithCredential(String str, String str2, String str3, String str4, Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        AuthCredential credentialForProvider = getCredentialForProvider(str2, str3, str4);
        if (credentialForProvider == null) {
            rejectPromiseWithCodeAndMessage(promise, "invalid-credential", "The supplied auth credential is malformed, has expired or is not currently supported.");
            return;
        }
        FirebaseUser currentUser = instance.getCurrentUser();
        Log.d(TAG, "reauthenticate");
        if (currentUser != null) {
            currentUser.reauthenticateAndRetrieveData(credentialForProvider).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(promise) {
                private final /* synthetic */ Promise f$1;

                {
                    this.f$1 = r2;
                }

                public final void onComplete(Task task) {
                    ReactNativeFirebaseAuthModule.this.lambda$reauthenticateWithCredential$28$ReactNativeFirebaseAuthModule(this.f$1, task);
                }
            });
        } else {
            promiseNoUser(promise, true);
        }
    }

    public /* synthetic */ void lambda$reauthenticateWithCredential$28$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "reauthenticate:onComplete:success");
            promiseWithAuthResult((AuthResult) task.getResult(), promise);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "reauthenticate:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.firebase.auth.AuthCredential getCredentialForProvider(java.lang.String r2, java.lang.String r3, java.lang.String r4) {
        /*
            r1 = this;
            int r0 = r2.hashCode()
            switch(r0) {
                case -1830313082: goto L_0x004e;
                case -1536293812: goto L_0x0044;
                case -364826023: goto L_0x003a;
                case 105516695: goto L_0x0030;
                case 106642798: goto L_0x0026;
                case 1216985755: goto L_0x001c;
                case 1985010934: goto L_0x0012;
                case 2120171958: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0058
        L_0x0008:
            java.lang.String r0 = "emailLink"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0058
            r0 = 7
            goto L_0x0059
        L_0x0012:
            java.lang.String r0 = "github.com"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0058
            r0 = 3
            goto L_0x0059
        L_0x001c:
            java.lang.String r0 = "password"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0058
            r0 = 6
            goto L_0x0059
        L_0x0026:
            java.lang.String r0 = "phone"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0058
            r0 = 5
            goto L_0x0059
        L_0x0030:
            java.lang.String r0 = "oauth"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0058
            r0 = 4
            goto L_0x0059
        L_0x003a:
            java.lang.String r0 = "facebook.com"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0058
            r0 = 0
            goto L_0x0059
        L_0x0044:
            java.lang.String r0 = "google.com"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0058
            r0 = 1
            goto L_0x0059
        L_0x004e:
            java.lang.String r0 = "twitter.com"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0058
            r0 = 2
            goto L_0x0059
        L_0x0058:
            r0 = -1
        L_0x0059:
            switch(r0) {
                case 0: goto L_0x0081;
                case 1: goto L_0x007c;
                case 2: goto L_0x0077;
                case 3: goto L_0x0072;
                case 4: goto L_0x006d;
                case 5: goto L_0x0068;
                case 6: goto L_0x0063;
                case 7: goto L_0x005e;
                default: goto L_0x005c;
            }
        L_0x005c:
            r2 = 0
            return r2
        L_0x005e:
            com.google.firebase.auth.AuthCredential r2 = com.google.firebase.auth.EmailAuthProvider.getCredentialWithLink(r3, r4)
            return r2
        L_0x0063:
            com.google.firebase.auth.AuthCredential r2 = com.google.firebase.auth.EmailAuthProvider.getCredential(r3, r4)
            return r2
        L_0x0068:
            com.google.firebase.auth.PhoneAuthCredential r2 = r1.getPhoneAuthCredential(r3, r4)
            return r2
        L_0x006d:
            com.google.firebase.auth.AuthCredential r2 = com.google.firebase.auth.OAuthProvider.getCredential(r2, r3, r4)
            return r2
        L_0x0072:
            com.google.firebase.auth.AuthCredential r2 = com.google.firebase.auth.GithubAuthProvider.getCredential(r3)
            return r2
        L_0x0077:
            com.google.firebase.auth.AuthCredential r2 = com.google.firebase.auth.TwitterAuthProvider.getCredential(r3, r4)
            return r2
        L_0x007c:
            com.google.firebase.auth.AuthCredential r2 = com.google.firebase.auth.GoogleAuthProvider.getCredential(r3, r4)
            return r2
        L_0x0081:
            com.google.firebase.auth.AuthCredential r2 = com.google.firebase.auth.FacebookAuthProvider.getCredential(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.auth.ReactNativeFirebaseAuthModule.getCredentialForProvider(java.lang.String, java.lang.String, java.lang.String):com.google.firebase.auth.AuthCredential");
    }

    private PhoneAuthCredential getPhoneAuthCredential(String str, String str2) {
        PhoneAuthCredential phoneAuthCredential;
        if (str == null && (phoneAuthCredential = this.mCredential) != null) {
            this.mCredential = null;
            return phoneAuthCredential;
        } else if (str != null) {
            return PhoneAuthProvider.getCredential(str, str2);
        } else {
            return null;
        }
    }

    @ReactMethod
    public void getIdToken(String str, Boolean bool, Promise promise) {
        Log.d(TAG, "getIdToken");
        FirebaseUser currentUser = FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).getCurrentUser();
        if (currentUser == null) {
            promiseNoUser(promise, true);
        } else {
            currentUser.getIdToken(bool.booleanValue()).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(promise) {
                private final /* synthetic */ Promise f$1;

                {
                    this.f$1 = r2;
                }

                public final void onComplete(Task task) {
                    ReactNativeFirebaseAuthModule.this.lambda$getIdToken$29$ReactNativeFirebaseAuthModule(this.f$1, task);
                }
            });
        }
    }

    public /* synthetic */ void lambda$getIdToken$29$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "getIdToken:onComplete:success");
            GetTokenResult getTokenResult = (GetTokenResult) task.getResult();
            getTokenResult.getClass();
            promise.resolve(getTokenResult.getToken());
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "getIdToken:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void getIdTokenResult(String str, Boolean bool, Promise promise) {
        Log.d(TAG, "getIdTokenResult");
        FirebaseUser currentUser = FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).getCurrentUser();
        if (currentUser == null) {
            promiseNoUser(promise, true);
        } else {
            currentUser.getIdToken(bool.booleanValue()).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(promise) {
                private final /* synthetic */ Promise f$1;

                {
                    this.f$1 = r2;
                }

                public final void onComplete(Task task) {
                    ReactNativeFirebaseAuthModule.this.lambda$getIdTokenResult$30$ReactNativeFirebaseAuthModule(this.f$1, task);
                }
            });
        }
    }

    public /* synthetic */ void lambda$getIdTokenResult$30$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "getIdTokenResult:onComplete:success");
            GetTokenResult getTokenResult = (GetTokenResult) task.getResult();
            WritableMap createMap = Arguments.createMap();
            getTokenResult.getClass();
            SharedUtils.mapPutValue("authTime", SharedUtils.timestampToUTC(getTokenResult.getAuthTimestamp()), createMap);
            SharedUtils.mapPutValue("expirationTime", SharedUtils.timestampToUTC(getTokenResult.getExpirationTimestamp()), createMap);
            SharedUtils.mapPutValue("issuedAtTime", SharedUtils.timestampToUTC(getTokenResult.getIssuedAtTimestamp()), createMap);
            SharedUtils.mapPutValue("claims", getTokenResult.getClaims(), createMap);
            SharedUtils.mapPutValue("signInProvider", getTokenResult.getSignInProvider(), createMap);
            SharedUtils.mapPutValue("token", getTokenResult.getToken(), createMap);
            promise.resolve(createMap);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "getIdTokenResult:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void fetchSignInMethodsForEmail(String str, String str2, Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        Log.d(TAG, "fetchProvidersForEmail");
        instance.fetchSignInMethodsForEmail(str2).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(promise) {
            private final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$fetchSignInMethodsForEmail$31$ReactNativeFirebaseAuthModule(this.f$1, task);
            }
        });
    }

    public /* synthetic */ void lambda$fetchSignInMethodsForEmail$31$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "fetchProvidersForEmail:onComplete:success");
            Object result = task.getResult();
            result.getClass();
            List<String> signInMethods = ((SignInMethodQueryResult) result).getSignInMethods();
            WritableArray createArray = Arguments.createArray();
            if (signInMethods != null) {
                for (String pushString : signInMethods) {
                    createArray.pushString(pushString);
                }
            }
            promise.resolve(createArray);
            return;
        }
        Exception exception = task.getException();
        Log.d(TAG, "fetchProvidersForEmail:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void setLanguageCode(String str, String str2) {
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).setLanguageCode(str2);
    }

    @ReactMethod
    public void useDeviceLanguage(String str) {
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).useAppLanguage();
    }

    @ReactMethod
    public void verifyPasswordResetCode(String str, String str2, Promise promise) {
        Log.d(TAG, "verifyPasswordResetCode");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).verifyPasswordResetCode(str2).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(promise) {
            private final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$verifyPasswordResetCode$32$ReactNativeFirebaseAuthModule(this.f$1, task);
            }
        });
    }

    public /* synthetic */ void lambda$verifyPasswordResetCode$32$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "verifyPasswordResetCode:onComplete:success");
            promise.resolve(task.getResult());
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "verifyPasswordResetCode:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    private void promiseNoUser(Promise promise, Boolean bool) {
        if (bool.booleanValue()) {
            rejectPromiseWithCodeAndMessage(promise, "no-current-user", "No user currently signed in.");
        } else {
            promise.resolve((Object) null);
        }
    }

    private void promiseWithUser(@Nullable FirebaseUser firebaseUser, Promise promise) {
        if (firebaseUser != null) {
            promise.resolve(firebaseUserToMap(firebaseUser));
        } else {
            promiseNoUser(promise, true);
        }
    }

    private void promiseWithAuthResult(AuthResult authResult, Promise promise) {
        if (authResult == null || authResult.getUser() == null) {
            promiseNoUser(promise, true);
            return;
        }
        WritableMap createMap = Arguments.createMap();
        WritableMap firebaseUserToMap = firebaseUserToMap(authResult.getUser());
        if (authResult.getAdditionalUserInfo() != null) {
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putBoolean("isNewUser", authResult.getAdditionalUserInfo().isNewUser());
            if (authResult.getAdditionalUserInfo().getProfile() != null) {
                SharedUtils.mapPutValue(Scopes.PROFILE, authResult.getAdditionalUserInfo().getProfile(), createMap2);
            }
            if (authResult.getAdditionalUserInfo().getProviderId() != null) {
                createMap2.putString("providerId", authResult.getAdditionalUserInfo().getProviderId());
            }
            if (authResult.getAdditionalUserInfo().getUsername() != null) {
                createMap2.putString("username", authResult.getAdditionalUserInfo().getUsername());
            }
            createMap.putMap("additionalUserInfo", createMap2);
        }
        createMap.putMap("user", firebaseUserToMap);
        promise.resolve(createMap);
    }

    /* access modifiers changed from: private */
    public void promiseRejectAuthException(Promise promise, Exception exc) {
        WritableMap jSError = getJSError(exc);
        rejectPromiseWithCodeAndMessage(promise, jSError.getString("code"), jSError.getString(JsonMarshaller.MESSAGE));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c9, code lost:
        if (r6.equals("CUSTOM_TOKEN_MISMATCH") != false) goto L_0x0100;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x013e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.react.bridge.WritableMap getJSError(java.lang.Exception r11) {
        /*
            r10 = this;
            java.lang.String r0 = "The user's credential is no longer valid. The user must sign in again."
            java.lang.String r1 = "UNKNOWN"
            java.lang.String r2 = "INVALID_EMAIL"
            com.facebook.react.bridge.WritableMap r3 = com.facebook.react.bridge.Arguments.createMap()
            java.lang.String r4 = r11.getMessage()
            java.lang.String r5 = "The email address is badly formatted."
            r6 = r11
            com.google.firebase.auth.FirebaseAuthException r6 = (com.google.firebase.auth.FirebaseAuthException) r6     // Catch:{ Exception -> 0x0024 }
            java.lang.String r7 = r6.getErrorCode()     // Catch:{ Exception -> 0x0024 }
            java.lang.String r8 = "nativeErrorCode"
            r3.putString(r8, r7)     // Catch:{ Exception -> 0x0022 }
            java.lang.String r0 = r6.getMessage()     // Catch:{ Exception -> 0x0022 }
            goto L_0x0131
        L_0x0022:
            goto L_0x0025
        L_0x0024:
            r7 = r1
        L_0x0025:
            java.lang.String r6 = "([A-Z]*_[A-Z]*)"
            java.util.regex.Pattern r6 = java.util.regex.Pattern.compile(r6)
            java.util.regex.Matcher r6 = r6.matcher(r4)
            boolean r8 = r6.find()
            if (r8 == 0) goto L_0x0130
            r7 = 1
            java.lang.String r6 = r6.group(r7)
            java.lang.String r6 = r6.trim()
            r8 = -1
            int r9 = r6.hashCode()
            switch(r9) {
                case -2127468245: goto L_0x00f4;
                case -1971163201: goto L_0x00ea;
                case -1112393964: goto L_0x00e2;
                case -1035666916: goto L_0x00d7;
                case -333672188: goto L_0x00cc;
                case -324930558: goto L_0x00c3;
                case -311841705: goto L_0x00b8;
                case -75433118: goto L_0x00ad;
                case -49749054: goto L_0x00a3;
                case -40686718: goto L_0x0098;
                case 583750925: goto L_0x008d;
                case 748182870: goto L_0x0082;
                case 864281573: goto L_0x0077;
                case 1072360691: goto L_0x006c;
                case 1388786705: goto L_0x0060;
                case 1433767024: goto L_0x0054;
                case 1563975629: goto L_0x0048;
                default: goto L_0x0046;
            }
        L_0x0046:
            goto L_0x00ff
        L_0x0048:
            java.lang.String r7 = "INVALID_USER_TOKEN"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x00ff
            r7 = 13
            goto L_0x0100
        L_0x0054:
            java.lang.String r7 = "USER_DISABLED"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x00ff
            r7 = 10
            goto L_0x0100
        L_0x0060:
            java.lang.String r7 = "INVALID_IDENTIFIER"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x00ff
            r7 = 16
            goto L_0x0100
        L_0x006c:
            java.lang.String r7 = "INVALID_CUSTOM_TOKEN"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x00ff
            r7 = 0
            goto L_0x0100
        L_0x0077:
            java.lang.String r7 = "ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x00ff
            r7 = 7
            goto L_0x0100
        L_0x0082:
            java.lang.String r7 = "REQUIRES_RECENT_LOGIN"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x00ff
            r7 = 6
            goto L_0x0100
        L_0x008d:
            java.lang.String r7 = "WRONG_PASSWORD"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x00ff
            r7 = 4
            goto L_0x0100
        L_0x0098:
            java.lang.String r7 = "WEAK_PASSWORD"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x00ff
            r7 = 14
            goto L_0x0100
        L_0x00a3:
            java.lang.String r7 = "USER_MISMATCH"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x00ff
            r7 = 5
            goto L_0x0100
        L_0x00ad:
            java.lang.String r7 = "USER_NOT_FOUND"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x00ff
            r7 = 12
            goto L_0x0100
        L_0x00b8:
            java.lang.String r7 = "EMAIL_ALREADY_IN_USE"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x00ff
            r7 = 8
            goto L_0x0100
        L_0x00c3:
            java.lang.String r9 = "CUSTOM_TOKEN_MISMATCH"
            boolean r9 = r6.equals(r9)
            if (r9 == 0) goto L_0x00ff
            goto L_0x0100
        L_0x00cc:
            java.lang.String r7 = "OPERATION_NOT_ALLOWED"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x00ff
            r7 = 15
            goto L_0x0100
        L_0x00d7:
            java.lang.String r7 = "CREDENTIAL_ALREADY_IN_USE"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x00ff
            r7 = 9
            goto L_0x0100
        L_0x00e2:
            boolean r7 = r6.equals(r2)
            if (r7 == 0) goto L_0x00ff
            r7 = 3
            goto L_0x0100
        L_0x00ea:
            java.lang.String r7 = "INVALID_CREDENTIAL"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x00ff
            r7 = 2
            goto L_0x0100
        L_0x00f4:
            java.lang.String r7 = "USER_TOKEN_EXPIRED"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x00ff
            r7 = 11
            goto L_0x0100
        L_0x00ff:
            r7 = -1
        L_0x0100:
            switch(r7) {
                case 0: goto L_0x012d;
                case 1: goto L_0x012a;
                case 2: goto L_0x0127;
                case 3: goto L_0x0125;
                case 4: goto L_0x0122;
                case 5: goto L_0x011f;
                case 6: goto L_0x011c;
                case 7: goto L_0x0119;
                case 8: goto L_0x0116;
                case 9: goto L_0x0113;
                case 10: goto L_0x0110;
                case 11: goto L_0x0132;
                case 12: goto L_0x010d;
                case 13: goto L_0x0132;
                case 14: goto L_0x010a;
                case 15: goto L_0x0107;
                case 16: goto L_0x0105;
                default: goto L_0x0103;
            }
        L_0x0103:
            r0 = r4
            goto L_0x0132
        L_0x0105:
            r6 = r2
            goto L_0x0125
        L_0x0107:
            java.lang.String r0 = "This operation is not allowed. You must enable this service in the console."
            goto L_0x0132
        L_0x010a:
            java.lang.String r0 = "The given password is invalid."
            goto L_0x0132
        L_0x010d:
            java.lang.String r0 = "There is no user record corresponding to this identifier. The user may have been deleted."
            goto L_0x0132
        L_0x0110:
            java.lang.String r0 = "The user account has been disabled by an administrator."
            goto L_0x0132
        L_0x0113:
            java.lang.String r0 = "This credential is already associated with a different user account."
            goto L_0x0132
        L_0x0116:
            java.lang.String r0 = "The email address is already in use by another account."
            goto L_0x0132
        L_0x0119:
            java.lang.String r0 = "An account already exists with the same email address but different sign-in credentials. Sign in using a provider associated with this email address."
            goto L_0x0132
        L_0x011c:
            java.lang.String r0 = "This operation is sensitive and requires recent authentication. Log in again before retrying this request."
            goto L_0x0132
        L_0x011f:
            java.lang.String r0 = "The supplied credentials do not correspond to the previously signed in user."
            goto L_0x0132
        L_0x0122:
            java.lang.String r0 = "The password is invalid or the user does not have a password."
            goto L_0x0132
        L_0x0125:
            r0 = r5
            goto L_0x0132
        L_0x0127:
            java.lang.String r0 = "The supplied auth credential is malformed or has expired."
            goto L_0x0132
        L_0x012a:
            java.lang.String r0 = "The custom token corresponds to a different audience."
            goto L_0x0132
        L_0x012d:
            java.lang.String r0 = "The custom token format is incorrect. Please check the documentation."
            goto L_0x0132
        L_0x0130:
            r0 = r4
        L_0x0131:
            r6 = r7
        L_0x0132:
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x013e
            boolean r1 = r11 instanceof com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
            if (r1 == 0) goto L_0x013e
            r0 = r5
            goto L_0x013f
        L_0x013e:
            r2 = r6
        L_0x013f:
            java.lang.String r1 = r2.toLowerCase()
            java.lang.String r2 = "error_"
            java.lang.String r4 = ""
            java.lang.String r1 = r1.replace(r2, r4)
            r2 = 95
            r4 = 45
            java.lang.String r1 = r1.replace(r2, r4)
            java.lang.String r2 = "code"
            r3.putString(r2, r1)
            java.lang.String r1 = "message"
            r3.putString(r1, r0)
            java.lang.String r11 = r11.getMessage()
            java.lang.String r0 = "nativeErrorMessage"
            r3.putString(r0, r11)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.auth.ReactNativeFirebaseAuthModule.getJSError(java.lang.Exception):com.facebook.react.bridge.WritableMap");
    }

    private WritableArray convertProviderData(List<? extends UserInfo> list, FirebaseUser firebaseUser) {
        WritableArray createArray = Arguments.createArray();
        for (UserInfo userInfo : list) {
            if (!FirebaseAuthProvider.PROVIDER_ID.equals(userInfo.getProviderId())) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("providerId", userInfo.getProviderId());
                createMap.putString("uid", userInfo.getUid());
                createMap.putString("displayName", userInfo.getDisplayName());
                Uri photoUrl = userInfo.getPhotoUrl();
                if (photoUrl == null || "".equals(photoUrl.toString())) {
                    createMap.putNull("photoURL");
                } else {
                    createMap.putString("photoURL", photoUrl.toString());
                }
                String phoneNumber = userInfo.getPhoneNumber();
                if ("phone".equals(userInfo.getProviderId()) && (userInfo.getPhoneNumber() == null || "".equals(userInfo.getPhoneNumber()))) {
                    createMap.putString("phoneNumber", firebaseUser.getPhoneNumber());
                } else if (phoneNumber == null || "".equals(phoneNumber)) {
                    createMap.putNull("phoneNumber");
                } else {
                    createMap.putString("phoneNumber", phoneNumber);
                }
                if ("password".equals(userInfo.getProviderId()) && (userInfo.getEmail() == null || "".equals(userInfo.getEmail()))) {
                    createMap.putString("email", userInfo.getUid());
                } else if (userInfo.getEmail() == null || "".equals(userInfo.getEmail())) {
                    createMap.putNull("email");
                } else {
                    createMap.putString("email", userInfo.getEmail());
                }
                createArray.pushMap(createMap);
            }
        }
        return createArray;
    }

    private WritableMap firebaseUserToMap(FirebaseUser firebaseUser) {
        WritableMap createMap = Arguments.createMap();
        String uid = firebaseUser.getUid();
        String email = firebaseUser.getEmail();
        Uri photoUrl = firebaseUser.getPhotoUrl();
        String displayName = firebaseUser.getDisplayName();
        String providerId = firebaseUser.getProviderId();
        boolean isEmailVerified = firebaseUser.isEmailVerified();
        String phoneNumber = firebaseUser.getPhoneNumber();
        createMap.putString("uid", uid);
        createMap.putString("providerId", providerId);
        createMap.putBoolean("emailVerified", isEmailVerified);
        createMap.putBoolean("isAnonymous", firebaseUser.isAnonymous());
        if (email == null || "".equals(email)) {
            createMap.putNull("email");
        } else {
            createMap.putString("email", email);
        }
        if (displayName == null || "".equals(displayName)) {
            createMap.putNull("displayName");
        } else {
            createMap.putString("displayName", displayName);
        }
        if (photoUrl == null || "".equals(photoUrl.toString())) {
            createMap.putNull("photoURL");
        } else {
            createMap.putString("photoURL", photoUrl.toString());
        }
        if (phoneNumber == null || "".equals(phoneNumber)) {
            createMap.putNull("phoneNumber");
        } else {
            createMap.putString("phoneNumber", phoneNumber);
        }
        createMap.putArray("providerData", convertProviderData(firebaseUser.getProviderData(), firebaseUser));
        WritableMap createMap2 = Arguments.createMap();
        FirebaseUserMetadata metadata = firebaseUser.getMetadata();
        if (metadata != null) {
            createMap2.putDouble("creationTime", (double) metadata.getCreationTimestamp());
            createMap2.putDouble("lastSignInTime", (double) metadata.getLastSignInTimestamp());
        }
        createMap.putMap("metadata", createMap2);
        return createMap;
    }

    private ActionCodeSettings buildActionCodeSettings(ReadableMap readableMap) {
        ActionCodeSettings.Builder newBuilder = ActionCodeSettings.newBuilder();
        String string = readableMap.getString(ImagesContract.URL);
        string.getClass();
        ActionCodeSettings.Builder url = newBuilder.setUrl(string);
        if (readableMap.hasKey("handleCodeInApp")) {
            url = url.setHandleCodeInApp(readableMap.getBoolean("handleCodeInApp"));
        }
        if (readableMap.hasKey("dynamicLinkDomain")) {
            url = url.setDynamicLinkDomain(readableMap.getString("dynamicLinkDomain"));
        }
        if (readableMap.hasKey("android")) {
            ReadableMap map = readableMap.getMap("android");
            map.getClass();
            boolean z = map.hasKey("installApp") && map.getBoolean("installApp");
            String string2 = map.hasKey("minimumVersion") ? map.getString("minimumVersion") : null;
            String string3 = map.getString("packageName");
            string3.getClass();
            url = url.setAndroidPackageName(string3, z, string2);
        }
        if (readableMap.hasKey("iOS")) {
            String string4 = readableMap.getMap("iOS").getString("bundleId");
            string4.getClass();
            url = url.setIOSBundleId(string4);
        }
        return url.build();
    }

    /* access modifiers changed from: private */
    public void sendPhoneStateEvent(String str, String str2, String str3, WritableMap writableMap) {
        WritableMap createMap = Arguments.createMap();
        ReactNativeFirebaseEventEmitter sharedInstance = ReactNativeFirebaseEventEmitter.getSharedInstance();
        createMap.putString("appName", str);
        createMap.putString("requestKey", str2);
        createMap.putString("type", str3);
        createMap.putMap("state", writableMap);
        sharedInstance.sendEvent(new ReactNativeFirebaseEvent("phone_auth_state_changed", createMap, str));
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        List<FirebaseApp> apps = FirebaseApp.getApps(getReactApplicationContext());
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        for (FirebaseApp name : apps) {
            String name2 = name.getName();
            FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(name2));
            FirebaseUser currentUser = instance.getCurrentUser();
            hashMap2.put(name2, instance.getLanguageCode());
            if (currentUser != null) {
                hashMap3.put(name2, firebaseUserToMap(currentUser));
            }
        }
        hashMap.put("APP_LANGUAGE", hashMap2);
        hashMap.put("APP_USER", hashMap3);
        return hashMap;
    }
}

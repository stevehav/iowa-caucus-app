package com.auth0.react;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.browser.customtabs.CustomTabsIntent;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class A0Auth0Module extends ReactContextBaseJavaModule implements LifecycleEventListener {
    private static final int CANCEL_EVENT_DELAY = 100;
    private static final String SHA_256 = "SHA-256";
    private static final String US_ASCII = "US-ASCII";
    /* access modifiers changed from: private */
    public Callback callback;
    private final ReactApplicationContext reactContext;

    public String getName() {
        return "A0Auth0";
    }

    @ReactMethod
    public void hide() {
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
    }

    public A0Auth0Module(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
        this.reactContext.addLifecycleEventListener(this);
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("bundleIdentifier", this.reactContext.getApplicationInfo().packageName);
        return hashMap;
    }

    @ReactMethod
    public void showUrl(String str, boolean z, Callback callback2) {
        Activity currentActivity = getCurrentActivity();
        this.callback = callback2;
        if (currentActivity != null) {
            new CustomTabsIntent.Builder().build().launchUrl(currentActivity, Uri.parse(str));
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setData(Uri.parse(str));
        getReactApplicationContext().startActivity(intent);
    }

    @ReactMethod
    public void oauthParameters(Callback callback2) {
        String generateRandomValue = generateRandomValue();
        WritableMap createMap = Arguments.createMap();
        createMap.putString("verifier", generateRandomValue);
        createMap.putString("code_challenge", generateCodeChallenge(generateRandomValue));
        createMap.putString("code_challenge_method", "S256");
        createMap.putString("state", generateRandomValue());
        callback2.invoke(createMap);
    }

    private String getBase64String(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    /* access modifiers changed from: package-private */
    public byte[] getASCIIBytes(String str) {
        try {
            return str.getBytes(US_ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Could not convert string to an ASCII byte array", e);
        }
    }

    /* access modifiers changed from: package-private */
    public byte[] getSHA256(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(SHA_256);
            instance.update(bArr, 0, bArr.length);
            return instance.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("Failed to get SHA-256 signature", e);
        }
    }

    /* access modifiers changed from: package-private */
    public String generateRandomValue() {
        byte[] bArr = new byte[32];
        new SecureRandom().nextBytes(bArr);
        return getBase64String(bArr);
    }

    /* access modifiers changed from: package-private */
    public String generateCodeChallenge(@NonNull String str) {
        return getBase64String(getSHA256(getASCIIBytes(str)));
    }

    public void onHostResume() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Callback access$000 = A0Auth0Module.this.callback;
                if (access$000 != null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString("error", "a0.session.user_cancelled");
                    createMap.putString("error_description", "User cancelled the Auth");
                    access$000.invoke(createMap);
                    Callback unused = A0Auth0Module.this.callback = null;
                }
            }
        }, 100);
    }
}

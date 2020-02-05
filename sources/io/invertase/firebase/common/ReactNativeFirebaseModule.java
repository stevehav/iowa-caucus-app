package io.invertase.firebase.common;

import android.app.Activity;
import android.content.Context;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.WritableMap;
import io.invertase.firebase.interfaces.ContextProvider;
import io.sentry.marshaller.json.JsonMarshaller;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.Nonnull;

public class ReactNativeFirebaseModule extends ReactContextBaseJavaModule implements ContextProvider {
    private static Map<String, ExecutorService> executors = new HashMap();
    private String moduleName;

    public ReactNativeFirebaseModule(ReactApplicationContext reactApplicationContext, String str) {
        super(reactApplicationContext);
        this.moduleName = str;
    }

    public static void rejectPromiseWithExceptionMap(Promise promise, Exception exc) {
        promise.reject((Throwable) exc, SharedUtils.getExceptionMap(exc));
    }

    public static void rejectPromiseWithCodeAndMessage(Promise promise, String str, String str2) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("code", str);
        createMap.putString(JsonMarshaller.MESSAGE, str2);
        promise.reject(str, str2, createMap);
    }

    public static void rejectPromiseWithCodeAndMessage(Promise promise, String str, String str2, String str3) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("code", str);
        createMap.putString(JsonMarshaller.MESSAGE, str2);
        createMap.putString("nativeErrorMessage", str3);
        promise.reject(str, str2, createMap);
    }

    public void initialize() {
        super.initialize();
    }

    public ReactContext getContext() {
        return getReactApplicationContext();
    }

    public ExecutorService getExecutor() {
        ExecutorService executorService = executors.get(getName());
        if (executorService != null) {
            return executorService;
        }
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        executors.put(getName(), newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    public void onCatalystInstanceDestroy() {
        ExecutorService executorService = executors.get(getName());
        if (executorService != null) {
            executorService.shutdownNow();
            executors.remove(getName());
        }
    }

    public Context getApplicationContext() {
        return getReactApplicationContext().getApplicationContext();
    }

    public Activity getActivity() {
        return getCurrentActivity();
    }

    @Nonnull
    public String getName() {
        return "RNFB" + this.moduleName + "Module";
    }

    public Map<String, Object> getConstants() {
        return new HashMap();
    }
}

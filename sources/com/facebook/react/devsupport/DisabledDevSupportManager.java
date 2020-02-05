package com.facebook.react.devsupport;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.DefaultNativeModuleCallExceptionHandler;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.ErrorCustomizer;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import java.io.File;

public class DisabledDevSupportManager implements DevSupportManager {
    private final DefaultNativeModuleCallExceptionHandler mDefaultNativeModuleCallExceptionHandler = new DefaultNativeModuleCallExceptionHandler();

    public void addCustomDevOption(String str, DevOptionHandler devOptionHandler) {
    }

    @Nullable
    public File downloadBundleResourceFromUrlSync(String str, File file) {
        return null;
    }

    public DeveloperSettings getDevSettings() {
        return null;
    }

    public boolean getDevSupportEnabled() {
        return false;
    }

    public String getDownloadedJSBundleFile() {
        return null;
    }

    public String getJSBundleURLForRemoteDebugging() {
        return null;
    }

    @Nullable
    public StackFrame[] getLastErrorStack() {
        return null;
    }

    @Nullable
    public String getLastErrorTitle() {
        return null;
    }

    public String getSourceMapUrl() {
        return null;
    }

    public String getSourceUrl() {
        return null;
    }

    public void handleReloadJS() {
    }

    public boolean hasUpToDateJSBundleInCache() {
        return false;
    }

    public void hideRedboxDialog() {
    }

    public void isPackagerRunning(PackagerStatusCallback packagerStatusCallback) {
    }

    public void onNewReactContextCreated(ReactContext reactContext) {
    }

    public void onReactInstanceDestroyed(ReactContext reactContext) {
    }

    public void registerErrorCustomizer(ErrorCustomizer errorCustomizer) {
    }

    public void reloadJSFromServer(String str) {
    }

    public void reloadSettings() {
    }

    public void setDevSupportEnabled(boolean z) {
    }

    public void setFpsDebugEnabled(boolean z) {
    }

    public void setHotModuleReplacementEnabled(boolean z) {
    }

    public void setReloadOnJSChangeEnabled(boolean z) {
    }

    public void setRemoteJSDebugEnabled(boolean z) {
    }

    public void showDevOptionsDialog() {
    }

    public void showNewJSError(String str, ReadableArray readableArray, int i) {
    }

    public void showNewJavaError(String str, Throwable th) {
    }

    public void startInspector() {
    }

    public void stopInspector() {
    }

    public void toggleElementInspector() {
    }

    public void updateJSError(String str, ReadableArray readableArray, int i) {
    }

    public void handleException(Exception exc) {
        this.mDefaultNativeModuleCallExceptionHandler.handleException(exc);
    }
}

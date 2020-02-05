package com.facebook.react.devsupport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import com.facebook.react.packagerconnection.PackagerConnectionSettings;

@VisibleForTesting
public class DevInternalSettings implements DeveloperSettings, SharedPreferences.OnSharedPreferenceChangeListener {
    private static final String PREFS_ANIMATIONS_DEBUG_KEY = "animations_debug";
    private static final String PREFS_FPS_DEBUG_KEY = "fps_debug";
    private static final String PREFS_HOT_MODULE_REPLACEMENT_KEY = "hot_module_replacement";
    private static final String PREFS_INSPECTOR_DEBUG_KEY = "inspector_debug";
    private static final String PREFS_JS_BUNDLE_DELTAS_CPP_KEY = "js_bundle_deltas_cpp";
    private static final String PREFS_JS_BUNDLE_DELTAS_KEY = "js_bundle_deltas";
    private static final String PREFS_JS_DEV_MODE_DEBUG_KEY = "js_dev_mode_debug";
    private static final String PREFS_JS_MINIFY_DEBUG_KEY = "js_minify_debug";
    private static final String PREFS_RELOAD_ON_JS_CHANGE_KEY = "reload_on_js_change_LEGACY";
    private static final String PREFS_REMOTE_JS_DEBUG_KEY = "remote_js_debug";
    private static final String PREFS_START_SAMPLING_PROFILER_ON_INIT = "start_sampling_profiler_on_init";
    private final Listener mListener;
    private final PackagerConnectionSettings mPackagerConnectionSettings;
    private final SharedPreferences mPreferences;
    private final boolean mSupportsNativeDeltaClients;

    public interface Listener {
        void onInternalSettingsChanged();
    }

    public boolean isNuclideJSDebugEnabled() {
        return false;
    }

    public static DevInternalSettings withoutNativeDeltaClient(Context context, Listener listener) {
        return new DevInternalSettings(context, listener, false);
    }

    public DevInternalSettings(Context context, Listener listener) {
        this(context, listener, true);
    }

    private DevInternalSettings(Context context, Listener listener, boolean z) {
        this.mListener = listener;
        this.mPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.mPreferences.registerOnSharedPreferenceChangeListener(this);
        this.mPackagerConnectionSettings = new PackagerConnectionSettings(context);
        this.mSupportsNativeDeltaClients = z;
    }

    public PackagerConnectionSettings getPackagerConnectionSettings() {
        return this.mPackagerConnectionSettings;
    }

    public boolean isFpsDebugEnabled() {
        return this.mPreferences.getBoolean(PREFS_FPS_DEBUG_KEY, false);
    }

    public void setFpsDebugEnabled(boolean z) {
        this.mPreferences.edit().putBoolean(PREFS_FPS_DEBUG_KEY, z).apply();
    }

    public boolean isAnimationFpsDebugEnabled() {
        return this.mPreferences.getBoolean(PREFS_ANIMATIONS_DEBUG_KEY, false);
    }

    public boolean isJSDevModeEnabled() {
        return this.mPreferences.getBoolean(PREFS_JS_DEV_MODE_DEBUG_KEY, true);
    }

    public void setJSDevModeEnabled(boolean z) {
        this.mPreferences.edit().putBoolean(PREFS_JS_DEV_MODE_DEBUG_KEY, z).apply();
    }

    public boolean isJSMinifyEnabled() {
        return this.mPreferences.getBoolean(PREFS_JS_MINIFY_DEBUG_KEY, false);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (this.mListener == null) {
            return;
        }
        if (PREFS_FPS_DEBUG_KEY.equals(str) || PREFS_RELOAD_ON_JS_CHANGE_KEY.equals(str) || PREFS_JS_DEV_MODE_DEBUG_KEY.equals(str) || PREFS_JS_BUNDLE_DELTAS_KEY.equals(str) || PREFS_JS_BUNDLE_DELTAS_CPP_KEY.equals(str) || PREFS_START_SAMPLING_PROFILER_ON_INIT.equals(str) || PREFS_JS_MINIFY_DEBUG_KEY.equals(str)) {
            this.mListener.onInternalSettingsChanged();
        }
    }

    public boolean isHotModuleReplacementEnabled() {
        return this.mPreferences.getBoolean(PREFS_HOT_MODULE_REPLACEMENT_KEY, true);
    }

    public void setHotModuleReplacementEnabled(boolean z) {
        this.mPreferences.edit().putBoolean(PREFS_HOT_MODULE_REPLACEMENT_KEY, z).apply();
    }

    public boolean isReloadOnJSChangeEnabled() {
        return this.mPreferences.getBoolean(PREFS_RELOAD_ON_JS_CHANGE_KEY, false);
    }

    public void setReloadOnJSChangeEnabled(boolean z) {
        this.mPreferences.edit().putBoolean(PREFS_RELOAD_ON_JS_CHANGE_KEY, z).apply();
    }

    public boolean isElementInspectorEnabled() {
        return this.mPreferences.getBoolean(PREFS_INSPECTOR_DEBUG_KEY, false);
    }

    public void setElementInspectorEnabled(boolean z) {
        this.mPreferences.edit().putBoolean(PREFS_INSPECTOR_DEBUG_KEY, z).apply();
    }

    @SuppressLint({"SharedPreferencesUse"})
    public boolean isBundleDeltasEnabled() {
        return this.mPreferences.getBoolean(PREFS_JS_BUNDLE_DELTAS_KEY, false);
    }

    @SuppressLint({"SharedPreferencesUse"})
    public void setBundleDeltasEnabled(boolean z) {
        this.mPreferences.edit().putBoolean(PREFS_JS_BUNDLE_DELTAS_KEY, z).apply();
    }

    @SuppressLint({"SharedPreferencesUse"})
    public boolean isBundleDeltasCppEnabled() {
        if (!this.mSupportsNativeDeltaClients || !this.mPreferences.getBoolean(PREFS_JS_BUNDLE_DELTAS_CPP_KEY, false)) {
            return false;
        }
        return true;
    }

    @SuppressLint({"SharedPreferencesUse"})
    public void setBundleDeltasCppEnabled(boolean z) {
        this.mPreferences.edit().putBoolean(PREFS_JS_BUNDLE_DELTAS_CPP_KEY, z).apply();
    }

    public boolean isRemoteJSDebugEnabled() {
        return this.mPreferences.getBoolean(PREFS_REMOTE_JS_DEBUG_KEY, false);
    }

    public void setRemoteJSDebugEnabled(boolean z) {
        this.mPreferences.edit().putBoolean(PREFS_REMOTE_JS_DEBUG_KEY, z).apply();
    }

    public boolean isStartSamplingProfilerOnInit() {
        return this.mPreferences.getBoolean(PREFS_START_SAMPLING_PROFILER_ON_INIT, false);
    }
}

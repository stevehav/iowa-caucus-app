package io.invertase.firebase.app;

import io.invertase.firebase.common.ReactNativeFirebaseInitProvider;

public class ReactNativeFirebaseAppInitProvider extends ReactNativeFirebaseInitProvider {
    private static final String EMPTY_APPLICATION_ID_PROVIDER_AUTHORITY = "io.invertase.firebase.reactnativefirebaseappinitprovider";

    public String getEmptyProviderAuthority() {
        return EMPTY_APPLICATION_ID_PROVIDER_AUTHORITY;
    }
}

package com.google.android.gms.signin;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;

public final class SignInOptions implements Api.ApiOptions.Optional {
    public static final SignInOptions DEFAULT = new SignInOptions(false, false, (String) null, false, (String) null, false, (Long) null, (Long) null);
    private final boolean zaaa = false;
    private final String zaab = null;
    private final String zaac = null;
    private final boolean zarv = false;
    private final boolean zarw = false;
    private final Long zarx = null;
    private final Long zary = null;
    private final boolean zay = false;

    public static final class zaa {
    }

    private SignInOptions(boolean z, boolean z2, String str, boolean z3, String str2, boolean z4, Long l, Long l2) {
    }

    public final boolean isOfflineAccessRequested() {
        return this.zarv;
    }

    public final boolean isIdTokenRequested() {
        return this.zay;
    }

    public final String getServerClientId() {
        return this.zaab;
    }

    public final boolean isForceCodeForRefreshToken() {
        return this.zaaa;
    }

    @Nullable
    public final String getHostedDomain() {
        return this.zaac;
    }

    public final boolean waitForAccessTokenRefresh() {
        return this.zarw;
    }

    @Nullable
    public final Long getAuthApiSignInModuleVersion() {
        return this.zarx;
    }

    @Nullable
    public final Long getRealClientLibraryVersion() {
        return this.zary;
    }

    static {
        new zaa();
    }
}

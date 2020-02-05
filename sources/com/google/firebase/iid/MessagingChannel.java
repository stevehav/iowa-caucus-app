package com.google.firebase.iid;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import javax.annotation.Nullable;

@KeepForSdk
public interface MessagingChannel {
    @KeepForSdk
    Task<Void> ackMessage(String str);

    @KeepForSdk
    Task<Void> buildChannel(String str, @Nullable String str2);

    @KeepForSdk
    Task<Void> deleteInstanceId(String str);

    @KeepForSdk
    Task<Void> deleteToken(String str, @Nullable String str2, String str3, String str4);

    @KeepForSdk
    Task<String> getToken(String str, @Nullable String str2, String str3, String str4);

    @KeepForSdk
    boolean isAvailable();

    @KeepForSdk
    boolean isChannelBuilt();

    @KeepForSdk
    boolean needsRefresh();

    @KeepForSdk
    Task<Void> subscribeToTopic(String str, String str2, String str3);

    @KeepForSdk
    Task<Void> unsubscribeFromTopic(String str, String str2, String str3);
}

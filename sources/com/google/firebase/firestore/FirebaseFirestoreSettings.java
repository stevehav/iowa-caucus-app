package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.firebase.annotations.PublicApi;

@PublicApi
/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class FirebaseFirestoreSettings {
    @PublicApi
    public static final long CACHE_SIZE_UNLIMITED = -1;
    private static final long DEFAULT_CACHE_SIZE_BYTES = 104857600;
    private static final String DEFAULT_HOST = "firestore.googleapis.com";
    private static final boolean DEFAULT_TIMESTAMPS_IN_SNAPSHOTS_ENABLED = true;
    private static final long MINIMUM_CACHE_BYTES = 1048576;
    private final long cacheSizeBytes;
    /* access modifiers changed from: private */
    public final String host;
    /* access modifiers changed from: private */
    public final boolean persistenceEnabled;
    /* access modifiers changed from: private */
    public final boolean sslEnabled;
    /* access modifiers changed from: private */
    public final boolean timestampsInSnapshotsEnabled;

    @PublicApi
    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public static final class Builder {
        /* access modifiers changed from: private */
        public long cacheSizeBytes;
        /* access modifiers changed from: private */
        public String host;
        /* access modifiers changed from: private */
        public boolean persistenceEnabled;
        /* access modifiers changed from: private */
        public boolean sslEnabled;
        /* access modifiers changed from: private */
        public boolean timestampsInSnapshotsEnabled;

        @PublicApi
        public Builder() {
            this.host = FirebaseFirestoreSettings.DEFAULT_HOST;
            this.sslEnabled = true;
            this.persistenceEnabled = true;
            this.timestampsInSnapshotsEnabled = true;
            this.cacheSizeBytes = FirebaseFirestoreSettings.DEFAULT_CACHE_SIZE_BYTES;
        }

        @PublicApi
        public Builder(@NonNull FirebaseFirestoreSettings firebaseFirestoreSettings) {
            Preconditions.checkNotNull(firebaseFirestoreSettings, "Provided settings must not be null.");
            this.host = firebaseFirestoreSettings.host;
            this.sslEnabled = firebaseFirestoreSettings.sslEnabled;
            this.persistenceEnabled = firebaseFirestoreSettings.persistenceEnabled;
            this.timestampsInSnapshotsEnabled = firebaseFirestoreSettings.timestampsInSnapshotsEnabled;
        }

        @PublicApi
        @NonNull
        public Builder setHost(@NonNull String str) {
            this.host = (String) Preconditions.checkNotNull(str, "Provided host must not be null.");
            return this;
        }

        @PublicApi
        @NonNull
        public Builder setSslEnabled(boolean z) {
            this.sslEnabled = z;
            return this;
        }

        @PublicApi
        @NonNull
        public Builder setPersistenceEnabled(boolean z) {
            this.persistenceEnabled = z;
            return this;
        }

        @PublicApi
        @NonNull
        @Deprecated
        public Builder setTimestampsInSnapshotsEnabled(boolean z) {
            this.timestampsInSnapshotsEnabled = z;
            return this;
        }

        @PublicApi
        @NonNull
        public Builder setCacheSizeBytes(long j) {
            if (j == -1 || j >= 1048576) {
                this.cacheSizeBytes = j;
                return this;
            }
            throw new IllegalArgumentException("Cache size must be set to at least 1048576 bytes");
        }

        @PublicApi
        @NonNull
        public FirebaseFirestoreSettings build() {
            if (this.sslEnabled || !this.host.equals(FirebaseFirestoreSettings.DEFAULT_HOST)) {
                return new FirebaseFirestoreSettings(this);
            }
            throw new IllegalStateException("You can't set the 'sslEnabled' setting unless you also set a non-default 'host'.");
        }
    }

    private FirebaseFirestoreSettings(Builder builder) {
        this.host = builder.host;
        this.sslEnabled = builder.sslEnabled;
        this.persistenceEnabled = builder.persistenceEnabled;
        this.timestampsInSnapshotsEnabled = builder.timestampsInSnapshotsEnabled;
        this.cacheSizeBytes = builder.cacheSizeBytes;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FirebaseFirestoreSettings firebaseFirestoreSettings = (FirebaseFirestoreSettings) obj;
        if (this.host.equals(firebaseFirestoreSettings.host) && this.sslEnabled == firebaseFirestoreSettings.sslEnabled && this.persistenceEnabled == firebaseFirestoreSettings.persistenceEnabled && this.timestampsInSnapshotsEnabled == firebaseFirestoreSettings.timestampsInSnapshotsEnabled && this.cacheSizeBytes == firebaseFirestoreSettings.cacheSizeBytes) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.host.hashCode() * 31) + (this.sslEnabled ? 1 : 0)) * 31) + (this.persistenceEnabled ? 1 : 0)) * 31) + (this.timestampsInSnapshotsEnabled ? 1 : 0)) * 31) + ((int) this.cacheSizeBytes);
    }

    @NonNull
    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("host", (Object) this.host).add("sslEnabled", this.sslEnabled).add("persistenceEnabled", this.persistenceEnabled).add("timestampsInSnapshotsEnabled", this.timestampsInSnapshotsEnabled).toString();
    }

    @PublicApi
    @NonNull
    public String getHost() {
        return this.host;
    }

    @PublicApi
    public boolean isSslEnabled() {
        return this.sslEnabled;
    }

    @PublicApi
    public boolean isPersistenceEnabled() {
        return this.persistenceEnabled;
    }

    @PublicApi
    public boolean areTimestampsInSnapshotsEnabled() {
        return this.timestampsInSnapshotsEnabled;
    }

    @PublicApi
    public long getCacheSizeBytes() {
        return this.cacheSizeBytes;
    }
}

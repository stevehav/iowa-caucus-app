package com.google.firebase.firestore.model.mutation;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class Precondition {
    public static final Precondition NONE = new Precondition((SnapshotVersion) null, (Boolean) null);
    @Nullable
    private final Boolean exists;
    @Nullable
    private final SnapshotVersion updateTime;

    private Precondition(@Nullable SnapshotVersion snapshotVersion, @Nullable Boolean bool) {
        Assert.hardAssert(snapshotVersion == null || bool == null, "Precondition can specify \"exists\" or \"updateTime\" but not both", new Object[0]);
        this.updateTime = snapshotVersion;
        this.exists = bool;
    }

    public static Precondition exists(boolean z) {
        return new Precondition((SnapshotVersion) null, Boolean.valueOf(z));
    }

    public static Precondition updateTime(SnapshotVersion snapshotVersion) {
        return new Precondition(snapshotVersion, (Boolean) null);
    }

    public boolean isNone() {
        return this.updateTime == null && this.exists == null;
    }

    @Nullable
    public SnapshotVersion getUpdateTime() {
        return this.updateTime;
    }

    @Nullable
    public Boolean getExists() {
        return this.exists;
    }

    public boolean isValidFor(@Nullable MaybeDocument maybeDocument) {
        if (this.updateTime == null) {
            Boolean bool = this.exists;
            if (bool == null) {
                Assert.hardAssert(isNone(), "Precondition should be empty", new Object[0]);
                return true;
            } else if (bool.booleanValue() == (maybeDocument instanceof Document)) {
                return true;
            } else {
                return false;
            }
        } else if (!(maybeDocument instanceof Document) || !maybeDocument.getVersion().equals(this.updateTime)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Precondition precondition = (Precondition) obj;
        SnapshotVersion snapshotVersion = this.updateTime;
        if (snapshotVersion == null ? precondition.updateTime != null : !snapshotVersion.equals(precondition.updateTime)) {
            return false;
        }
        Boolean bool = this.exists;
        if (bool != null) {
            return bool.equals(precondition.exists);
        }
        if (precondition.exists == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        SnapshotVersion snapshotVersion = this.updateTime;
        int i = 0;
        int hashCode = (snapshotVersion != null ? snapshotVersion.hashCode() : 0) * 31;
        Boolean bool = this.exists;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        if (isNone()) {
            return "Precondition{<none>}";
        }
        if (this.updateTime != null) {
            return "Precondition{updateTime=" + this.updateTime + "}";
        } else if (this.exists != null) {
            return "Precondition{exists=" + this.exists + "}";
        } else {
            throw Assert.fail("Invalid Precondition", new Object[0]);
        }
    }
}

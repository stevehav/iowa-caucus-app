package com.google.firebase.firestore.model.mutation;

import androidx.annotation.Nullable;
import com.google.common.base.Preconditions;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.value.FieldValue;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class MutationResult {
    @Nullable
    private final List<FieldValue> transformResults;
    private final SnapshotVersion version;

    public MutationResult(SnapshotVersion snapshotVersion, @Nullable List<FieldValue> list) {
        this.version = (SnapshotVersion) Preconditions.checkNotNull(snapshotVersion);
        this.transformResults = list;
    }

    public SnapshotVersion getVersion() {
        return this.version;
    }

    @Nullable
    public List<FieldValue> getTransformResults() {
        return this.transformResults;
    }
}

package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.common.base.Preconditions;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.firestore.model.mutation.FieldMask;
import java.util.HashSet;
import java.util.List;

@PublicApi
/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class SetOptions {
    private static final SetOptions MERGE_ALL_FIELDS = new SetOptions(true, (FieldMask) null);
    static final SetOptions OVERWRITE = new SetOptions(false, (FieldMask) null);
    @Nullable
    private final FieldMask fieldMask;
    private final boolean merge;

    private SetOptions(boolean z, @Nullable FieldMask fieldMask2) {
        Preconditions.checkArgument(fieldMask2 == null || z, "Cannot specify a fieldMask for non-merge sets()");
        this.merge = z;
        this.fieldMask = fieldMask2;
    }

    /* access modifiers changed from: package-private */
    public boolean isMerge() {
        return this.merge;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public FieldMask getFieldMask() {
        return this.fieldMask;
    }

    @PublicApi
    @NonNull
    public static SetOptions merge() {
        return MERGE_ALL_FIELDS;
    }

    @PublicApi
    @NonNull
    public static SetOptions mergeFields(@NonNull List<String> list) {
        HashSet hashSet = new HashSet();
        for (String fromDotSeparatedPath : list) {
            hashSet.add(FieldPath.fromDotSeparatedPath(fromDotSeparatedPath).getInternalPath());
        }
        return new SetOptions(true, FieldMask.fromSet(hashSet));
    }

    @PublicApi
    @NonNull
    public static SetOptions mergeFields(String... strArr) {
        HashSet hashSet = new HashSet();
        for (String fromDotSeparatedPath : strArr) {
            hashSet.add(FieldPath.fromDotSeparatedPath(fromDotSeparatedPath).getInternalPath());
        }
        return new SetOptions(true, FieldMask.fromSet(hashSet));
    }

    @PublicApi
    @NonNull
    public static SetOptions mergeFieldPaths(@NonNull List<FieldPath> list) {
        HashSet hashSet = new HashSet();
        for (FieldPath internalPath : list) {
            hashSet.add(internalPath.getInternalPath());
        }
        return new SetOptions(true, FieldMask.fromSet(hashSet));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SetOptions setOptions = (SetOptions) obj;
        if (this.merge != setOptions.merge) {
            return false;
        }
        FieldMask fieldMask2 = this.fieldMask;
        if (fieldMask2 != null) {
            return fieldMask2.equals(setOptions.fieldMask);
        }
        if (setOptions.fieldMask == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = (this.merge ? 1 : 0) * true;
        FieldMask fieldMask2 = this.fieldMask;
        return i + (fieldMask2 != null ? fieldMask2.hashCode() : 0);
    }
}

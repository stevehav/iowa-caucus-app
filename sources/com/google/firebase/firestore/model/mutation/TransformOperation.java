package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.value.FieldValue;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public interface TransformOperation {
    FieldValue applyToLocalView(@Nullable FieldValue fieldValue, Timestamp timestamp);

    FieldValue applyToRemoteDocument(@Nullable FieldValue fieldValue, FieldValue fieldValue2);

    @Nullable
    FieldValue computeBaseValue(@Nullable FieldValue fieldValue);
}

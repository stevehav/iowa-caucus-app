package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.UnknownDocument;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class TransformMutation extends Mutation {
    private final List<FieldTransform> fieldTransforms;

    public TransformMutation(DocumentKey documentKey, List<FieldTransform> list) {
        super(documentKey, Precondition.exists(true));
        this.fieldTransforms = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TransformMutation transformMutation = (TransformMutation) obj;
        if (!hasSameKeyAndPrecondition(transformMutation) || !this.fieldTransforms.equals(transformMutation.fieldTransforms)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (keyAndPreconditionHashCode() * 31) + this.fieldTransforms.hashCode();
    }

    public String toString() {
        return "TransformMutation{" + keyAndPreconditionToString() + ", fieldTransforms=" + this.fieldTransforms + "}";
    }

    public List<FieldTransform> getFieldTransforms() {
        return this.fieldTransforms;
    }

    public MaybeDocument applyToRemoteDocument(@Nullable MaybeDocument maybeDocument, MutationResult mutationResult) {
        verifyKeyMatches(maybeDocument);
        Assert.hardAssert(mutationResult.getTransformResults() != null, "Transform results missing for TransformMutation.", new Object[0]);
        if (!getPrecondition().isValidFor(maybeDocument)) {
            return new UnknownDocument(getKey(), mutationResult.getVersion());
        }
        Document requireDocument = requireDocument(maybeDocument);
        return new Document(getKey(), mutationResult.getVersion(), Document.DocumentState.COMMITTED_MUTATIONS, transformObject(requireDocument.getData(), serverTransformResults(requireDocument, mutationResult.getTransformResults())));
    }

    @Nullable
    public MaybeDocument applyToLocalView(@Nullable MaybeDocument maybeDocument, @Nullable MaybeDocument maybeDocument2, Timestamp timestamp) {
        verifyKeyMatches(maybeDocument);
        if (!getPrecondition().isValidFor(maybeDocument)) {
            return maybeDocument;
        }
        Document requireDocument = requireDocument(maybeDocument);
        return new Document(getKey(), requireDocument.getVersion(), Document.DocumentState.LOCAL_MUTATIONS, transformObject(requireDocument.getData(), localTransformResults(timestamp, maybeDocument, maybeDocument2)));
    }

    @Nullable
    public ObjectValue extractBaseValue(@Nullable MaybeDocument maybeDocument) {
        ObjectValue objectValue = null;
        for (FieldTransform next : this.fieldTransforms) {
            FieldValue computeBaseValue = next.getOperation().computeBaseValue(maybeDocument instanceof Document ? ((Document) maybeDocument).getField(next.getFieldPath()) : null);
            if (computeBaseValue != null) {
                if (objectValue == null) {
                    objectValue = ObjectValue.emptyObject().set(next.getFieldPath(), computeBaseValue);
                } else {
                    objectValue = objectValue.set(next.getFieldPath(), computeBaseValue);
                }
            }
        }
        return objectValue;
    }

    private Document requireDocument(@Nullable MaybeDocument maybeDocument) {
        Assert.hardAssert(maybeDocument instanceof Document, "Unknown MaybeDocument type %s", maybeDocument);
        Document document = (Document) maybeDocument;
        Assert.hardAssert(document.getKey().equals(getKey()), "Can only transform a document with the same key", new Object[0]);
        return document;
    }

    private List<FieldValue> serverTransformResults(@Nullable MaybeDocument maybeDocument, List<FieldValue> list) {
        ArrayList arrayList = new ArrayList(this.fieldTransforms.size());
        Assert.hardAssert(this.fieldTransforms.size() == list.size(), "server transform count (%d) should match field transform count (%d)", Integer.valueOf(list.size()), Integer.valueOf(this.fieldTransforms.size()));
        for (int i = 0; i < list.size(); i++) {
            FieldTransform fieldTransform = this.fieldTransforms.get(i);
            TransformOperation operation = fieldTransform.getOperation();
            FieldValue fieldValue = null;
            if (maybeDocument instanceof Document) {
                fieldValue = ((Document) maybeDocument).getField(fieldTransform.getFieldPath());
            }
            arrayList.add(operation.applyToRemoteDocument(fieldValue, list.get(i)));
        }
        return arrayList;
    }

    private List<FieldValue> localTransformResults(Timestamp timestamp, @Nullable MaybeDocument maybeDocument, @Nullable MaybeDocument maybeDocument2) {
        ArrayList arrayList = new ArrayList(this.fieldTransforms.size());
        for (FieldTransform next : this.fieldTransforms) {
            TransformOperation operation = next.getOperation();
            FieldValue fieldValue = null;
            if (maybeDocument instanceof Document) {
                fieldValue = ((Document) maybeDocument).getField(next.getFieldPath());
            }
            if (fieldValue == null && (maybeDocument2 instanceof Document)) {
                fieldValue = ((Document) maybeDocument2).getField(next.getFieldPath());
            }
            arrayList.add(operation.applyToLocalView(fieldValue, timestamp));
        }
        return arrayList;
    }

    private ObjectValue transformObject(ObjectValue objectValue, List<FieldValue> list) {
        Assert.hardAssert(list.size() == this.fieldTransforms.size(), "Transform results length mismatch.", new Object[0]);
        for (int i = 0; i < this.fieldTransforms.size(); i++) {
            objectValue = objectValue.set(this.fieldTransforms.get(i).getFieldPath(), list.get(i));
        }
        return objectValue;
    }
}

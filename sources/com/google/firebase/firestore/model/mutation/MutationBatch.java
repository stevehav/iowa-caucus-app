package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.util.Assert;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class MutationBatch {
    public static final int UNKNOWN = -1;
    private final List<Mutation> baseMutations;
    private final int batchId;
    private final Timestamp localWriteTime;
    private final List<Mutation> mutations;

    public MutationBatch(int i, Timestamp timestamp, List<Mutation> list, List<Mutation> list2) {
        Assert.hardAssert(!list2.isEmpty(), "Cannot create an empty mutation batch", new Object[0]);
        this.batchId = i;
        this.localWriteTime = timestamp;
        this.baseMutations = list;
        this.mutations = list2;
    }

    @Nullable
    public MaybeDocument applyToRemoteDocument(DocumentKey documentKey, @Nullable MaybeDocument maybeDocument, MutationBatchResult mutationBatchResult) {
        if (maybeDocument != null) {
            Assert.hardAssert(maybeDocument.getKey().equals(documentKey), "applyToRemoteDocument: key %s doesn't match maybeDoc key %s", documentKey, maybeDocument.getKey());
        }
        int size = this.mutations.size();
        List<MutationResult> mutationResults = mutationBatchResult.getMutationResults();
        Assert.hardAssert(mutationResults.size() == size, "Mismatch between mutations length (%d) and results length (%d)", Integer.valueOf(size), Integer.valueOf(mutationResults.size()));
        for (int i = 0; i < size; i++) {
            Mutation mutation = this.mutations.get(i);
            if (mutation.getKey().equals(documentKey)) {
                maybeDocument = mutation.applyToRemoteDocument(maybeDocument, mutationResults.get(i));
            }
        }
        return maybeDocument;
    }

    @Nullable
    public MaybeDocument applyToLocalView(DocumentKey documentKey, @Nullable MaybeDocument maybeDocument) {
        if (maybeDocument != null) {
            Assert.hardAssert(maybeDocument.getKey().equals(documentKey), "applyToRemoteDocument: key %s doesn't match maybeDoc key %s", documentKey, maybeDocument.getKey());
        }
        MaybeDocument maybeDocument2 = maybeDocument;
        for (int i = 0; i < this.baseMutations.size(); i++) {
            Mutation mutation = this.baseMutations.get(i);
            if (mutation.getKey().equals(documentKey)) {
                maybeDocument2 = mutation.applyToLocalView(maybeDocument2, maybeDocument2, this.localWriteTime);
            }
        }
        MaybeDocument maybeDocument3 = maybeDocument2;
        for (int i2 = 0; i2 < this.mutations.size(); i2++) {
            Mutation mutation2 = this.mutations.get(i2);
            if (mutation2.getKey().equals(documentKey)) {
                maybeDocument3 = mutation2.applyToLocalView(maybeDocument3, maybeDocument2, this.localWriteTime);
            }
        }
        return maybeDocument3;
    }

    public ImmutableSortedMap<DocumentKey, MaybeDocument> applyToLocalDocumentSet(ImmutableSortedMap<DocumentKey, MaybeDocument> immutableSortedMap) {
        for (DocumentKey next : getKeys()) {
            MaybeDocument applyToLocalView = applyToLocalView(next, immutableSortedMap.get(next));
            if (applyToLocalView != null) {
                immutableSortedMap = immutableSortedMap.insert(applyToLocalView.getKey(), applyToLocalView);
            }
        }
        return immutableSortedMap;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MutationBatch mutationBatch = (MutationBatch) obj;
        if (this.batchId != mutationBatch.batchId || !this.localWriteTime.equals(mutationBatch.localWriteTime) || !this.baseMutations.equals(mutationBatch.baseMutations) || !this.mutations.equals(mutationBatch.mutations)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((this.batchId * 31) + this.localWriteTime.hashCode()) * 31) + this.baseMutations.hashCode()) * 31) + this.mutations.hashCode();
    }

    public String toString() {
        return "MutationBatch(batchId=" + this.batchId + ", localWriteTime=" + this.localWriteTime + ", baseMutations=" + this.baseMutations + ", mutations=" + this.mutations + ')';
    }

    public Set<DocumentKey> getKeys() {
        HashSet hashSet = new HashSet();
        for (Mutation key : this.mutations) {
            hashSet.add(key.getKey());
        }
        return hashSet;
    }

    public int getBatchId() {
        return this.batchId;
    }

    public Timestamp getLocalWriteTime() {
        return this.localWriteTime;
    }

    public List<Mutation> getMutations() {
        return this.mutations;
    }

    public List<Mutation> getBaseMutations() {
        return this.baseMutations;
    }
}

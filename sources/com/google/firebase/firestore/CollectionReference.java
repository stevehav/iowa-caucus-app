package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.common.base.Preconditions;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Util;
import javax.annotation.Nullable;

@PublicApi
/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class CollectionReference extends Query {
    CollectionReference(ResourcePath resourcePath, FirebaseFirestore firebaseFirestore) {
        super(Query.atPath(resourcePath), firebaseFirestore);
        if (resourcePath.length() % 2 != 1) {
            throw new IllegalArgumentException("Invalid collection reference. Collection references must have an odd number of segments, but " + resourcePath.canonicalString() + " has " + resourcePath.length());
        }
    }

    @PublicApi
    @NonNull
    public String getId() {
        return this.query.getPath().getLastSegment();
    }

    @PublicApi
    @Nullable
    public DocumentReference getParent() {
        ResourcePath resourcePath = (ResourcePath) this.query.getPath().popLast();
        if (resourcePath.isEmpty()) {
            return null;
        }
        return new DocumentReference(DocumentKey.fromPath(resourcePath), this.firestore);
    }

    @PublicApi
    @NonNull
    public String getPath() {
        return this.query.getPath().canonicalString();
    }

    @PublicApi
    @NonNull
    public DocumentReference document() {
        return document(Util.autoId());
    }

    @PublicApi
    @NonNull
    public DocumentReference document(@NonNull String str) {
        Preconditions.checkNotNull(str, "Provided document path must not be null.");
        return DocumentReference.forPath((ResourcePath) this.query.getPath().append(ResourcePath.fromString(str)), this.firestore);
    }

    @PublicApi
    @NonNull
    public Task<DocumentReference> add(@NonNull Object obj) {
        Preconditions.checkNotNull(obj, "Provided data must not be null.");
        DocumentReference document = document();
        return document.set(obj).continueWith(Executors.DIRECT_EXECUTOR, CollectionReference$$Lambda$1.lambdaFactory$(document));
    }
}

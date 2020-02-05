package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.core.UserData;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.NoDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.DeleteMutation;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.Precondition;
import com.google.firebase.firestore.remote.Datastore;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Executors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class Transaction {
    private static final Executor defaultExecutor = createDefaultExecutor();
    private boolean committed;
    private final Datastore datastore;
    private final ArrayList<Mutation> mutations = new ArrayList<>();
    private final HashMap<DocumentKey, SnapshotVersion> readVersions = new HashMap<>();

    public Transaction(Datastore datastore2) {
        this.datastore = datastore2;
    }

    private void recordVersion(MaybeDocument maybeDocument) throws FirebaseFirestoreException {
        SnapshotVersion snapshotVersion;
        if (maybeDocument instanceof Document) {
            snapshotVersion = maybeDocument.getVersion();
        } else if (maybeDocument instanceof NoDocument) {
            snapshotVersion = SnapshotVersion.NONE;
        } else {
            throw Assert.fail("Unexpected document type in transaction: " + maybeDocument.getClass().getCanonicalName(), new Object[0]);
        }
        if (!this.readVersions.containsKey(maybeDocument.getKey())) {
            this.readVersions.put(maybeDocument.getKey(), snapshotVersion);
        } else if (!this.readVersions.get(maybeDocument.getKey()).equals(maybeDocument.getVersion())) {
            throw new FirebaseFirestoreException("Document version changed between two reads.", FirebaseFirestoreException.Code.FAILED_PRECONDITION);
        }
    }

    public Task<List<MaybeDocument>> lookup(List<DocumentKey> list) {
        if (this.committed) {
            return Tasks.forException(new FirebaseFirestoreException("Transaction has already completed.", FirebaseFirestoreException.Code.FAILED_PRECONDITION));
        }
        if (this.mutations.size() != 0) {
            return Tasks.forException(new FirebaseFirestoreException("Transactions lookups are invalid after writes.", FirebaseFirestoreException.Code.FAILED_PRECONDITION));
        }
        return this.datastore.lookup(list).continueWithTask(Executors.DIRECT_EXECUTOR, Transaction$$Lambda$1.lambdaFactory$(this));
    }

    static /* synthetic */ Task lambda$lookup$0(Transaction transaction, Task task) throws Exception {
        if (task.isSuccessful()) {
            for (MaybeDocument recordVersion : (List) task.getResult()) {
                transaction.recordVersion(recordVersion);
            }
        }
        return task;
    }

    private void write(List<Mutation> list) {
        if (!this.committed) {
            this.mutations.addAll(list);
            return;
        }
        throw new IllegalStateException("Transaction has already completed.");
    }

    private Precondition precondition(DocumentKey documentKey) {
        SnapshotVersion snapshotVersion = this.readVersions.get(documentKey);
        if (snapshotVersion != null) {
            return Precondition.updateTime(snapshotVersion);
        }
        return Precondition.NONE;
    }

    private Precondition preconditionForUpdate(DocumentKey documentKey) {
        SnapshotVersion snapshotVersion = this.readVersions.get(documentKey);
        if (snapshotVersion != null && snapshotVersion.equals(SnapshotVersion.NONE)) {
            throw new IllegalStateException("Can't update a document that doesn't exist.");
        } else if (snapshotVersion != null) {
            return Precondition.updateTime(snapshotVersion);
        } else {
            return Precondition.exists(true);
        }
    }

    public void set(DocumentKey documentKey, UserData.ParsedSetData parsedSetData) {
        write(parsedSetData.toMutationList(documentKey, precondition(documentKey)));
    }

    public void update(DocumentKey documentKey, UserData.ParsedUpdateData parsedUpdateData) {
        write(parsedUpdateData.toMutationList(documentKey, preconditionForUpdate(documentKey)));
    }

    public void delete(DocumentKey documentKey) {
        write(Collections.singletonList(new DeleteMutation(documentKey, precondition(documentKey))));
        this.readVersions.put(documentKey, SnapshotVersion.NONE);
    }

    public Task<Void> commit() {
        if (this.committed) {
            return Tasks.forException(new FirebaseFirestoreException("Transaction has already completed.", FirebaseFirestoreException.Code.FAILED_PRECONDITION));
        }
        HashSet hashSet = new HashSet(this.readVersions.keySet());
        Iterator<Mutation> it = this.mutations.iterator();
        while (it.hasNext()) {
            hashSet.remove(it.next().getKey());
        }
        if (hashSet.size() > 0) {
            return Tasks.forException(new FirebaseFirestoreException("Every document read in a transaction must also be written.", FirebaseFirestoreException.Code.FAILED_PRECONDITION));
        }
        this.committed = true;
        return this.datastore.commit(this.mutations).continueWithTask(Executors.DIRECT_EXECUTOR, Transaction$$Lambda$2.lambdaFactory$());
    }

    static /* synthetic */ Task lambda$commit$1(Task task) throws Exception {
        if (task.isSuccessful()) {
            return Tasks.forResult(null);
        }
        return Tasks.forException(task.getException());
    }

    private static Executor createDefaultExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, (long) 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static Executor getDefaultExecutor() {
        return defaultExecutor;
    }
}

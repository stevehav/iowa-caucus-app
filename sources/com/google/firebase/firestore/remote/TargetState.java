package com.google.firebase.firestore.remote;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Assert;
import com.google.protobuf.ByteString;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final class TargetState {
    private boolean current = false;
    private final Map<DocumentKey, DocumentViewChange.Type> documentChanges = new HashMap();
    private boolean hasChanges = true;
    private int outstandingResponses = 0;
    private ByteString resumeToken = ByteString.EMPTY;

    TargetState() {
    }

    /* access modifiers changed from: package-private */
    public boolean isCurrent() {
        return this.current;
    }

    /* access modifiers changed from: package-private */
    public boolean isPending() {
        return this.outstandingResponses != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean hasChanges() {
        return this.hasChanges;
    }

    /* access modifiers changed from: package-private */
    public void updateResumeToken(ByteString byteString) {
        if (!byteString.isEmpty()) {
            this.hasChanges = true;
            this.resumeToken = byteString;
        }
    }

    /* access modifiers changed from: package-private */
    public TargetChange toTargetChange() {
        ImmutableSortedSet<DocumentKey> emptyKeySet = DocumentKey.emptyKeySet();
        ImmutableSortedSet<DocumentKey> emptyKeySet2 = DocumentKey.emptyKeySet();
        ImmutableSortedSet<DocumentKey> emptyKeySet3 = DocumentKey.emptyKeySet();
        ImmutableSortedSet<DocumentKey> immutableSortedSet = emptyKeySet;
        ImmutableSortedSet<DocumentKey> immutableSortedSet2 = emptyKeySet2;
        ImmutableSortedSet<DocumentKey> immutableSortedSet3 = emptyKeySet3;
        for (Map.Entry next : this.documentChanges.entrySet()) {
            DocumentKey documentKey = (DocumentKey) next.getKey();
            DocumentViewChange.Type type = (DocumentViewChange.Type) next.getValue();
            int i = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type[type.ordinal()];
            if (i == 1) {
                immutableSortedSet = immutableSortedSet.insert(documentKey);
            } else if (i == 2) {
                immutableSortedSet2 = immutableSortedSet2.insert(documentKey);
            } else if (i == 3) {
                immutableSortedSet3 = immutableSortedSet3.insert(documentKey);
            } else {
                throw Assert.fail("Encountered invalid change type: %s", type);
            }
        }
        return new TargetChange(this.resumeToken, this.current, immutableSortedSet, immutableSortedSet2, immutableSortedSet3);
    }

    /* renamed from: com.google.firebase.firestore.remote.TargetState$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type = new int[DocumentViewChange.Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.google.firebase.firestore.core.DocumentViewChange$Type[] r0 = com.google.firebase.firestore.core.DocumentViewChange.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type = r0
                int[] r0 = $SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.firebase.firestore.core.DocumentViewChange$Type r1 = com.google.firebase.firestore.core.DocumentViewChange.Type.ADDED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.firebase.firestore.core.DocumentViewChange$Type r1 = com.google.firebase.firestore.core.DocumentViewChange.Type.MODIFIED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.firebase.firestore.core.DocumentViewChange$Type r1 = com.google.firebase.firestore.core.DocumentViewChange.Type.REMOVED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.remote.TargetState.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public void clearChanges() {
        this.hasChanges = false;
        this.documentChanges.clear();
    }

    /* access modifiers changed from: package-private */
    public void addDocumentChange(DocumentKey documentKey, DocumentViewChange.Type type) {
        this.hasChanges = true;
        this.documentChanges.put(documentKey, type);
    }

    /* access modifiers changed from: package-private */
    public void removeDocumentChange(DocumentKey documentKey) {
        this.hasChanges = true;
        this.documentChanges.remove(documentKey);
    }

    /* access modifiers changed from: package-private */
    public void recordPendingTargetRequest() {
        this.outstandingResponses++;
    }

    /* access modifiers changed from: package-private */
    public void recordTargetResponse() {
        this.outstandingResponses--;
    }

    /* access modifiers changed from: package-private */
    public void markCurrent() {
        this.hasChanges = true;
        this.current = true;
    }
}

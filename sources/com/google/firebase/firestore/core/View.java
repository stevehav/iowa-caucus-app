package com.google.firebase.firestore.core;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.core.LimboDocumentChange;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.DocumentSet;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.remote.TargetChange;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class View {
    private boolean current;
    private DocumentSet documentSet;
    private ImmutableSortedSet<DocumentKey> limboDocuments;
    private ImmutableSortedSet<DocumentKey> mutatedKeys;
    private final Query query;
    private ViewSnapshot.SyncState syncState = ViewSnapshot.SyncState.NONE;
    private ImmutableSortedSet<DocumentKey> syncedDocuments;

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public static class DocumentChanges {
        final DocumentViewChangeSet changeSet;
        final DocumentSet documentSet;
        final ImmutableSortedSet<DocumentKey> mutatedKeys;
        /* access modifiers changed from: private */
        public final boolean needsRefill;

        /* synthetic */ DocumentChanges(DocumentSet documentSet2, DocumentViewChangeSet documentViewChangeSet, ImmutableSortedSet immutableSortedSet, boolean z, AnonymousClass1 r5) {
            this(documentSet2, documentViewChangeSet, immutableSortedSet, z);
        }

        private DocumentChanges(DocumentSet documentSet2, DocumentViewChangeSet documentViewChangeSet, ImmutableSortedSet<DocumentKey> immutableSortedSet, boolean z) {
            this.documentSet = documentSet2;
            this.changeSet = documentViewChangeSet;
            this.mutatedKeys = immutableSortedSet;
            this.needsRefill = z;
        }

        public boolean needsRefill() {
            return this.needsRefill;
        }
    }

    public View(Query query2, ImmutableSortedSet<DocumentKey> immutableSortedSet) {
        this.query = query2;
        this.documentSet = DocumentSet.emptySet(query2.comparator());
        this.syncedDocuments = immutableSortedSet;
        this.limboDocuments = DocumentKey.emptyKeySet();
        this.mutatedKeys = DocumentKey.emptyKeySet();
    }

    public <D extends MaybeDocument> DocumentChanges computeDocChanges(ImmutableSortedMap<DocumentKey, D> immutableSortedMap) {
        return computeDocChanges(immutableSortedMap, (DocumentChanges) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e5, code lost:
        if (r0.query.comparator().compare(r11, r4) > 0) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0110, code lost:
        if (r4 != null) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0112, code lost:
        r8 = true;
        r10 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x013f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <D extends com.google.firebase.firestore.model.MaybeDocument> com.google.firebase.firestore.core.View.DocumentChanges computeDocChanges(com.google.firebase.database.collection.ImmutableSortedMap<com.google.firebase.firestore.model.DocumentKey, D> r18, @javax.annotation.Nullable com.google.firebase.firestore.core.View.DocumentChanges r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            if (r1 == 0) goto L_0x0009
            com.google.firebase.firestore.core.DocumentViewChangeSet r2 = r1.changeSet
            goto L_0x000e
        L_0x0009:
            com.google.firebase.firestore.core.DocumentViewChangeSet r2 = new com.google.firebase.firestore.core.DocumentViewChangeSet
            r2.<init>()
        L_0x000e:
            r5 = r2
            if (r1 == 0) goto L_0x0014
            com.google.firebase.firestore.model.DocumentSet r2 = r1.documentSet
            goto L_0x0016
        L_0x0014:
            com.google.firebase.firestore.model.DocumentSet r2 = r0.documentSet
        L_0x0016:
            if (r1 == 0) goto L_0x001b
            com.google.firebase.database.collection.ImmutableSortedSet<com.google.firebase.firestore.model.DocumentKey> r3 = r1.mutatedKeys
            goto L_0x001d
        L_0x001b:
            com.google.firebase.database.collection.ImmutableSortedSet<com.google.firebase.firestore.model.DocumentKey> r3 = r0.mutatedKeys
        L_0x001d:
            com.google.firebase.firestore.core.Query r4 = r0.query
            boolean r4 = r4.hasLimit()
            if (r4 == 0) goto L_0x0039
            int r4 = r2.size()
            long r7 = (long) r4
            com.google.firebase.firestore.core.Query r4 = r0.query
            long r9 = r4.getLimit()
            int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r4 != 0) goto L_0x0039
            com.google.firebase.firestore.model.Document r4 = r2.getLastDocument()
            goto L_0x003a
        L_0x0039:
            r4 = 0
        L_0x003a:
            java.util.Iterator r7 = r18.iterator()
            r8 = 0
            r9 = r3
            r10 = 0
            r3 = r2
        L_0x0042:
            boolean r11 = r7.hasNext()
            r12 = 1
            if (r11 == 0) goto L_0x0142
            java.lang.Object r11 = r7.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.Object r13 = r11.getKey()
            com.google.firebase.firestore.model.DocumentKey r13 = (com.google.firebase.firestore.model.DocumentKey) r13
            com.google.firebase.firestore.model.Document r14 = r2.getDocument(r13)
            java.lang.Object r11 = r11.getValue()
            com.google.firebase.firestore.model.MaybeDocument r11 = (com.google.firebase.firestore.model.MaybeDocument) r11
            boolean r15 = r11 instanceof com.google.firebase.firestore.model.Document
            if (r15 == 0) goto L_0x0066
            com.google.firebase.firestore.model.Document r11 = (com.google.firebase.firestore.model.Document) r11
            goto L_0x0067
        L_0x0066:
            r11 = 0
        L_0x0067:
            if (r11 == 0) goto L_0x008a
            com.google.firebase.firestore.model.DocumentKey r15 = r11.getKey()
            boolean r15 = r13.equals(r15)
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r8] = r13
            com.google.firebase.firestore.model.DocumentKey r16 = r11.getKey()
            r6[r12] = r16
            java.lang.String r12 = "Mismatching key in doc change %s != %s"
            com.google.firebase.firestore.util.Assert.hardAssert(r15, r12, r6)
            com.google.firebase.firestore.core.Query r6 = r0.query
            boolean r6 = r6.matches(r11)
            if (r6 != 0) goto L_0x008a
            r11 = 0
        L_0x008a:
            if (r14 == 0) goto L_0x009a
            com.google.firebase.database.collection.ImmutableSortedSet<com.google.firebase.firestore.model.DocumentKey> r6 = r0.mutatedKeys
            com.google.firebase.firestore.model.DocumentKey r12 = r14.getKey()
            boolean r6 = r6.contains(r12)
            if (r6 == 0) goto L_0x009a
            r6 = 1
            goto L_0x009b
        L_0x009a:
            r6 = 0
        L_0x009b:
            if (r11 == 0) goto L_0x00b7
            boolean r12 = r11.hasLocalMutations()
            if (r12 != 0) goto L_0x00b5
            com.google.firebase.database.collection.ImmutableSortedSet<com.google.firebase.firestore.model.DocumentKey> r12 = r0.mutatedKeys
            com.google.firebase.firestore.model.DocumentKey r15 = r11.getKey()
            boolean r12 = r12.contains(r15)
            if (r12 == 0) goto L_0x00b7
            boolean r12 = r11.hasCommittedMutations()
            if (r12 == 0) goto L_0x00b7
        L_0x00b5:
            r12 = 1
            goto L_0x00b8
        L_0x00b7:
            r12 = 0
        L_0x00b8:
            if (r14 == 0) goto L_0x00f4
            if (r11 == 0) goto L_0x00f4
            com.google.firebase.firestore.model.value.ObjectValue r15 = r14.getData()
            com.google.firebase.firestore.model.value.ObjectValue r8 = r11.getData()
            boolean r8 = r15.equals(r8)
            if (r8 != 0) goto L_0x00e8
            boolean r6 = r0.shouldWaitForSyncedDocument(r14, r11)
            if (r6 != 0) goto L_0x0115
            com.google.firebase.firestore.core.DocumentViewChange$Type r6 = com.google.firebase.firestore.core.DocumentViewChange.Type.MODIFIED
            com.google.firebase.firestore.core.DocumentViewChange r6 = com.google.firebase.firestore.core.DocumentViewChange.create(r6, r11)
            r5.addChange(r6)
            if (r4 == 0) goto L_0x0101
            com.google.firebase.firestore.core.Query r6 = r0.query
            java.util.Comparator r6 = r6.comparator()
            int r6 = r6.compare(r11, r4)
            if (r6 <= 0) goto L_0x0101
            goto L_0x0112
        L_0x00e8:
            if (r6 == r12) goto L_0x0115
            com.google.firebase.firestore.core.DocumentViewChange$Type r6 = com.google.firebase.firestore.core.DocumentViewChange.Type.METADATA
            com.google.firebase.firestore.core.DocumentViewChange r6 = com.google.firebase.firestore.core.DocumentViewChange.create(r6, r11)
            r5.addChange(r6)
            goto L_0x0101
        L_0x00f4:
            if (r14 != 0) goto L_0x0103
            if (r11 == 0) goto L_0x0103
            com.google.firebase.firestore.core.DocumentViewChange$Type r6 = com.google.firebase.firestore.core.DocumentViewChange.Type.ADDED
            com.google.firebase.firestore.core.DocumentViewChange r6 = com.google.firebase.firestore.core.DocumentViewChange.create(r6, r11)
            r5.addChange(r6)
        L_0x0101:
            r8 = 1
            goto L_0x0116
        L_0x0103:
            if (r14 == 0) goto L_0x0115
            if (r11 != 0) goto L_0x0115
            com.google.firebase.firestore.core.DocumentViewChange$Type r6 = com.google.firebase.firestore.core.DocumentViewChange.Type.REMOVED
            com.google.firebase.firestore.core.DocumentViewChange r6 = com.google.firebase.firestore.core.DocumentViewChange.create(r6, r14)
            r5.addChange(r6)
            if (r4 == 0) goto L_0x0101
        L_0x0112:
            r8 = 1
            r10 = 1
            goto L_0x0116
        L_0x0115:
            r8 = 0
        L_0x0116:
            if (r8 == 0) goto L_0x013f
            if (r11 == 0) goto L_0x0136
            com.google.firebase.firestore.model.DocumentSet r3 = r3.add(r11)
            boolean r6 = r11.hasLocalMutations()
            if (r6 == 0) goto L_0x012d
            com.google.firebase.firestore.model.DocumentKey r6 = r11.getKey()
            com.google.firebase.database.collection.ImmutableSortedSet r6 = r9.insert(r6)
            goto L_0x013e
        L_0x012d:
            com.google.firebase.firestore.model.DocumentKey r6 = r11.getKey()
            com.google.firebase.database.collection.ImmutableSortedSet r6 = r9.remove(r6)
            goto L_0x013e
        L_0x0136:
            com.google.firebase.firestore.model.DocumentSet r3 = r3.remove(r13)
            com.google.firebase.database.collection.ImmutableSortedSet r6 = r9.remove(r13)
        L_0x013e:
            r9 = r6
        L_0x013f:
            r8 = 0
            goto L_0x0042
        L_0x0142:
            com.google.firebase.firestore.core.Query r2 = r0.query
            boolean r2 = r2.hasLimit()
            if (r2 == 0) goto L_0x017c
            int r2 = r3.size()
            long r6 = (long) r2
            com.google.firebase.firestore.core.Query r2 = r0.query
            long r11 = r2.getLimit()
        L_0x0155:
            long r6 = r6 - r11
            r11 = 0
            int r2 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r2 <= 0) goto L_0x017c
            com.google.firebase.firestore.model.Document r2 = r3.getLastDocument()
            com.google.firebase.firestore.model.DocumentKey r4 = r2.getKey()
            com.google.firebase.firestore.model.DocumentSet r3 = r3.remove(r4)
            com.google.firebase.firestore.model.DocumentKey r4 = r2.getKey()
            com.google.firebase.database.collection.ImmutableSortedSet r9 = r9.remove(r4)
            com.google.firebase.firestore.core.DocumentViewChange$Type r4 = com.google.firebase.firestore.core.DocumentViewChange.Type.REMOVED
            com.google.firebase.firestore.core.DocumentViewChange r2 = com.google.firebase.firestore.core.DocumentViewChange.create(r4, r2)
            r5.addChange(r2)
            r11 = 1
            goto L_0x0155
        L_0x017c:
            r4 = r3
            r6 = r9
            if (r10 == 0) goto L_0x0185
            if (r1 != 0) goto L_0x0183
            goto L_0x0185
        L_0x0183:
            r1 = 0
            goto L_0x0186
        L_0x0185:
            r1 = 1
        L_0x0186:
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "View was refilled using docs that themselves needed refilling."
            com.google.firebase.firestore.util.Assert.hardAssert(r1, r3, r2)
            com.google.firebase.firestore.core.View$DocumentChanges r1 = new com.google.firebase.firestore.core.View$DocumentChanges
            r8 = 0
            r3 = r1
            r7 = r10
            r3.<init>(r4, r5, r6, r7, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.core.View.computeDocChanges(com.google.firebase.database.collection.ImmutableSortedMap, com.google.firebase.firestore.core.View$DocumentChanges):com.google.firebase.firestore.core.View$DocumentChanges");
    }

    private boolean shouldWaitForSyncedDocument(Document document, Document document2) {
        return document.hasLocalMutations() && document2.hasCommittedMutations() && !document2.hasLocalMutations();
    }

    public ViewChange applyChanges(DocumentChanges documentChanges) {
        return applyChanges(documentChanges, (TargetChange) null);
    }

    public ViewChange applyChanges(DocumentChanges documentChanges, TargetChange targetChange) {
        ViewSnapshot viewSnapshot;
        DocumentChanges documentChanges2 = documentChanges;
        Assert.hardAssert(!documentChanges.needsRefill, "Cannot apply changes that need a refill", new Object[0]);
        DocumentSet documentSet2 = this.documentSet;
        this.documentSet = documentChanges2.documentSet;
        this.mutatedKeys = documentChanges2.mutatedKeys;
        List<DocumentViewChange> changes = documentChanges2.changeSet.getChanges();
        Collections.sort(changes, View$$Lambda$1.lambdaFactory$(this));
        applyTargetChange(targetChange);
        List<LimboDocumentChange> updateLimboDocuments = updateLimboDocuments();
        ViewSnapshot.SyncState syncState2 = this.limboDocuments.size() == 0 && this.current ? ViewSnapshot.SyncState.SYNCED : ViewSnapshot.SyncState.LOCAL;
        boolean z = syncState2 != this.syncState;
        this.syncState = syncState2;
        if (changes.size() != 0 || z) {
            viewSnapshot = new ViewSnapshot(this.query, documentChanges2.documentSet, documentSet2, changes, syncState2 == ViewSnapshot.SyncState.LOCAL, documentChanges2.mutatedKeys, z, false);
        } else {
            viewSnapshot = null;
        }
        return new ViewChange(viewSnapshot, updateLimboDocuments);
    }

    static /* synthetic */ int lambda$applyChanges$0(View view, DocumentViewChange documentViewChange, DocumentViewChange documentViewChange2) {
        int compareIntegers = Util.compareIntegers(changeTypeOrder(documentViewChange), changeTypeOrder(documentViewChange2));
        documentViewChange.getType().compareTo(documentViewChange2.getType());
        if (compareIntegers != 0) {
            return compareIntegers;
        }
        return view.query.comparator().compare(documentViewChange.getDocument(), documentViewChange2.getDocument());
    }

    public ViewChange applyOnlineStateChange(OnlineState onlineState) {
        if (!this.current || onlineState != OnlineState.OFFLINE) {
            return new ViewChange((ViewSnapshot) null, Collections.emptyList());
        }
        this.current = false;
        return applyChanges(new DocumentChanges(this.documentSet, new DocumentViewChangeSet(), this.mutatedKeys, false, (AnonymousClass1) null));
    }

    private void applyTargetChange(TargetChange targetChange) {
        if (targetChange != null) {
            Iterator<DocumentKey> it = targetChange.getAddedDocuments().iterator();
            while (it.hasNext()) {
                this.syncedDocuments = this.syncedDocuments.insert(it.next());
            }
            Iterator<DocumentKey> it2 = targetChange.getModifiedDocuments().iterator();
            while (it2.hasNext()) {
                DocumentKey next = it2.next();
                Assert.hardAssert(this.syncedDocuments.contains(next), "Modified document %s not found in view.", next);
            }
            Iterator<DocumentKey> it3 = targetChange.getRemovedDocuments().iterator();
            while (it3.hasNext()) {
                this.syncedDocuments = this.syncedDocuments.remove(it3.next());
            }
            this.current = targetChange.isCurrent();
        }
    }

    private List<LimboDocumentChange> updateLimboDocuments() {
        if (!this.current) {
            return Collections.emptyList();
        }
        ImmutableSortedSet<DocumentKey> immutableSortedSet = this.limboDocuments;
        this.limboDocuments = DocumentKey.emptyKeySet();
        Iterator<Document> it = this.documentSet.iterator();
        while (it.hasNext()) {
            Document next = it.next();
            if (shouldBeLimboDoc(next.getKey())) {
                this.limboDocuments = this.limboDocuments.insert(next.getKey());
            }
        }
        ArrayList arrayList = new ArrayList(immutableSortedSet.size() + this.limboDocuments.size());
        Iterator<DocumentKey> it2 = immutableSortedSet.iterator();
        while (it2.hasNext()) {
            DocumentKey next2 = it2.next();
            if (!this.limboDocuments.contains(next2)) {
                arrayList.add(new LimboDocumentChange(LimboDocumentChange.Type.REMOVED, next2));
            }
        }
        Iterator<DocumentKey> it3 = this.limboDocuments.iterator();
        while (it3.hasNext()) {
            DocumentKey next3 = it3.next();
            if (!immutableSortedSet.contains(next3)) {
                arrayList.add(new LimboDocumentChange(LimboDocumentChange.Type.ADDED, next3));
            }
        }
        return arrayList;
    }

    private boolean shouldBeLimboDoc(DocumentKey documentKey) {
        Document document;
        if (!this.syncedDocuments.contains(documentKey) && (document = this.documentSet.getDocument(documentKey)) != null && !document.hasLocalMutations()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public ImmutableSortedSet<DocumentKey> getLimboDocuments() {
        return this.limboDocuments;
    }

    /* access modifiers changed from: package-private */
    public ImmutableSortedSet<DocumentKey> getSyncedDocuments() {
        return this.syncedDocuments;
    }

    /* renamed from: com.google.firebase.firestore.core.View$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type = new int[DocumentViewChange.Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
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
                com.google.firebase.firestore.core.DocumentViewChange$Type r1 = com.google.firebase.firestore.core.DocumentViewChange.Type.METADATA     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.google.firebase.firestore.core.DocumentViewChange$Type r1 = com.google.firebase.firestore.core.DocumentViewChange.Type.REMOVED     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.core.View.AnonymousClass1.<clinit>():void");
        }
    }

    private static int changeTypeOrder(DocumentViewChange documentViewChange) {
        int i = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type[documentViewChange.getType().ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (!(i == 2 || i == 3)) {
                if (i == 4) {
                    return 0;
                }
                throw new IllegalArgumentException("Unknown change type: " + documentViewChange.getType());
            }
        }
        return i2;
    }
}

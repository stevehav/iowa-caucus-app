package com.google.firebase.firestore.local;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.base.Preconditions;
import com.google.firebase.firestore.local.MemoryIndexManager;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
class SQLiteSchema {
    static final int INDEXING_SUPPORT_VERSION = 9;
    private static final int SEQUENCE_NUMBER_BATCH_SIZE = 100;
    static final int VERSION = 8;
    private final SQLiteDatabase db;

    SQLiteSchema(SQLiteDatabase sQLiteDatabase) {
        this.db = sQLiteDatabase;
    }

    /* access modifiers changed from: package-private */
    public void runMigrations() {
        runMigrations(0, 8);
    }

    /* access modifiers changed from: package-private */
    public void runMigrations(int i) {
        runMigrations(i, 8);
    }

    /* access modifiers changed from: package-private */
    public void runMigrations(int i, int i2) {
        if (i < 1 && i2 >= 1) {
            createV1MutationQueue();
            createV1QueryCache();
            createV1RemoteDocumentCache();
        }
        if (i < 3 && i2 >= 3 && i != 0) {
            dropV1QueryCache();
            createV1QueryCache();
        }
        if (i < 4 && i2 >= 4) {
            ensureTargetGlobal();
            addTargetCount();
        }
        if (i < 5 && i2 >= 5) {
            addSequenceNumber();
        }
        if (i < 6 && i2 >= 6) {
            removeAcknowledgedMutations();
        }
        if (i < 7 && i2 >= 7) {
            ensureSequenceNumbers();
        }
        if (i < 8 && i2 >= 8) {
            createV8CollectionParentsIndex();
        }
        if (i < 9 && i2 >= 9) {
            Preconditions.checkState(Persistence.INDEXING_SUPPORT_ENABLED);
            createLocalDocumentsCollectionIndex();
        }
    }

    private void ifTablesDontExist(String[] strArr, Runnable runnable) {
        String str;
        String str2 = "[" + TextUtils.join(", ", strArr) + "]";
        boolean z = false;
        for (int i = 0; i < strArr.length; i++) {
            String str3 = strArr[i];
            boolean tableExists = tableExists(str3);
            if (i == 0) {
                z = tableExists;
            } else if (tableExists != z) {
                String str4 = "Expected all of " + str2 + " to either exist or not, but ";
                if (z) {
                    str = str4 + strArr[0] + " exists and " + str3 + " does not";
                } else {
                    str = str4 + strArr[0] + " does not exist and " + str3 + " does";
                }
                throw new IllegalStateException(str);
            }
        }
        if (!z) {
            runnable.run();
            return;
        }
        Log.d("SQLiteSchema", "Skipping migration because all of " + str2 + " already exist");
    }

    private void createV1MutationQueue() {
        ifTablesDontExist(new String[]{"mutation_queues", "mutations", "document_mutations"}, SQLiteSchema$$Lambda$1.lambdaFactory$(this));
    }

    static /* synthetic */ void lambda$createV1MutationQueue$0(SQLiteSchema sQLiteSchema) {
        sQLiteSchema.db.execSQL("CREATE TABLE mutation_queues (uid TEXT PRIMARY KEY, last_acknowledged_batch_id INTEGER, last_stream_token BLOB)");
        sQLiteSchema.db.execSQL("CREATE TABLE mutations (uid TEXT, batch_id INTEGER, mutations BLOB, PRIMARY KEY (uid, batch_id))");
        sQLiteSchema.db.execSQL("CREATE TABLE document_mutations (uid TEXT, path TEXT, batch_id INTEGER, PRIMARY KEY (uid, path, batch_id))");
    }

    private void removeAcknowledgedMutations() {
        new SQLitePersistence.Query(this.db, "SELECT uid, last_acknowledged_batch_id FROM mutation_queues").forEach(SQLiteSchema$$Lambda$2.lambdaFactory$(this));
    }

    static /* synthetic */ void lambda$removeAcknowledgedMutations$2(SQLiteSchema sQLiteSchema, Cursor cursor) {
        String string = cursor.getString(0);
        long j = cursor.getLong(1);
        new SQLitePersistence.Query(sQLiteSchema.db, "SELECT batch_id FROM mutations WHERE uid = ? AND batch_id <= ?").binding(string, Long.valueOf(j)).forEach(SQLiteSchema$$Lambda$12.lambdaFactory$(sQLiteSchema, string));
    }

    /* access modifiers changed from: private */
    public void removeMutationBatch(String str, int i) {
        SQLiteStatement compileStatement = this.db.compileStatement("DELETE FROM mutations WHERE uid = ? AND batch_id = ?");
        compileStatement.bindString(1, str);
        compileStatement.bindLong(2, (long) i);
        Assert.hardAssert(compileStatement.executeUpdateDelete() != 0, "Mutatiohn batch (%s, %d) did not exist", str, Integer.valueOf(i));
        this.db.execSQL("DELETE FROM document_mutations WHERE uid = ? AND batch_id = ?", new Object[]{str, Integer.valueOf(i)});
    }

    private void createV1QueryCache() {
        ifTablesDontExist(new String[]{"targets", "target_globals", "target_documents"}, SQLiteSchema$$Lambda$3.lambdaFactory$(this));
    }

    static /* synthetic */ void lambda$createV1QueryCache$3(SQLiteSchema sQLiteSchema) {
        sQLiteSchema.db.execSQL("CREATE TABLE targets (target_id INTEGER PRIMARY KEY, canonical_id TEXT, snapshot_version_seconds INTEGER, snapshot_version_nanos INTEGER, resume_token BLOB, last_listen_sequence_number INTEGER,target_proto BLOB)");
        sQLiteSchema.db.execSQL("CREATE INDEX query_targets ON targets (canonical_id, target_id)");
        sQLiteSchema.db.execSQL("CREATE TABLE target_globals (highest_target_id INTEGER, highest_listen_sequence_number INTEGER, last_remote_snapshot_version_seconds INTEGER, last_remote_snapshot_version_nanos INTEGER)");
        sQLiteSchema.db.execSQL("CREATE TABLE target_documents (target_id INTEGER, path TEXT, PRIMARY KEY (target_id, path))");
        sQLiteSchema.db.execSQL("CREATE INDEX document_targets ON target_documents (path, target_id)");
    }

    private void dropV1QueryCache() {
        if (tableExists("targets")) {
            this.db.execSQL("DROP TABLE targets");
        }
        if (tableExists("target_globals")) {
            this.db.execSQL("DROP TABLE target_globals");
        }
        if (tableExists("target_documents")) {
            this.db.execSQL("DROP TABLE target_documents");
        }
    }

    private void createV1RemoteDocumentCache() {
        ifTablesDontExist(new String[]{"remote_documents"}, SQLiteSchema$$Lambda$4.lambdaFactory$(this));
    }

    private void createLocalDocumentsCollectionIndex() {
        ifTablesDontExist(new String[]{"collection_index"}, SQLiteSchema$$Lambda$5.lambdaFactory$(this));
    }

    private void ensureTargetGlobal() {
        if (!(DatabaseUtils.queryNumEntries(this.db, "target_globals") == 1)) {
            this.db.execSQL("INSERT INTO target_globals (highest_target_id, highest_listen_sequence_number, last_remote_snapshot_version_seconds, last_remote_snapshot_version_nanos) VALUES (?, ?, ?, ?)", new String[]{"0", "0", "0", "0"});
        }
    }

    private void addTargetCount() {
        if (!tableContainsColumn("target_globals", "target_count")) {
            this.db.execSQL("ALTER TABLE target_globals ADD COLUMN target_count INTEGER");
        }
        long queryNumEntries = DatabaseUtils.queryNumEntries(this.db, "targets");
        ContentValues contentValues = new ContentValues();
        contentValues.put("target_count", Long.valueOf(queryNumEntries));
        this.db.update("target_globals", contentValues, (String) null, (String[]) null);
    }

    private void addSequenceNumber() {
        if (!tableContainsColumn("target_documents", "sequence_number")) {
            this.db.execSQL("ALTER TABLE target_documents ADD COLUMN sequence_number INTEGER");
        }
    }

    private void ensureSequenceNumbers() {
        Long l = (Long) new SQLitePersistence.Query(this.db, "SELECT highest_listen_sequence_number FROM target_globals LIMIT 1").firstValue(SQLiteSchema$$Lambda$6.lambdaFactory$());
        Assert.hardAssert(l != null, "Missing highest sequence number", new Object[0]);
        long longValue = l.longValue();
        SQLiteStatement compileStatement = this.db.compileStatement("INSERT INTO target_documents (target_id, path, sequence_number) VALUES (0, ?, ?)");
        SQLitePersistence.Query binding = new SQLitePersistence.Query(this.db, "SELECT RD.path FROM remote_documents AS RD WHERE NOT EXISTS (SELECT TD.path FROM target_documents AS TD WHERE RD.path = TD.path AND TD.target_id = 0) LIMIT ?").binding(100);
        boolean[] zArr = new boolean[1];
        do {
            zArr[0] = false;
            binding.forEach(SQLiteSchema$$Lambda$7.lambdaFactory$(zArr, compileStatement, longValue));
        } while (zArr[0]);
    }

    static /* synthetic */ void lambda$ensureSequenceNumbers$7(boolean[] zArr, SQLiteStatement sQLiteStatement, long j, Cursor cursor) {
        boolean z = true;
        zArr[0] = true;
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindString(1, cursor.getString(0));
        sQLiteStatement.bindLong(2, j);
        if (sQLiteStatement.executeInsert() == -1) {
            z = false;
        }
        Assert.hardAssert(z, "Failed to insert a sentinel row", new Object[0]);
    }

    private void createV8CollectionParentsIndex() {
        ifTablesDontExist(new String[]{"collection_parents"}, SQLiteSchema$$Lambda$8.lambdaFactory$(this));
        Consumer lambdaFactory$ = SQLiteSchema$$Lambda$9.lambdaFactory$(new MemoryIndexManager.MemoryCollectionParentIndex(), this.db.compileStatement("INSERT OR REPLACE INTO collection_parents (collection_id, parent) VALUES (?, ?)"));
        new SQLitePersistence.Query(this.db, "SELECT path FROM remote_documents").forEach(SQLiteSchema$$Lambda$10.lambdaFactory$(lambdaFactory$));
        new SQLitePersistence.Query(this.db, "SELECT path FROM document_mutations").forEach(SQLiteSchema$$Lambda$11.lambdaFactory$(lambdaFactory$));
    }

    static /* synthetic */ void lambda$createV8CollectionParentsIndex$9(MemoryIndexManager.MemoryCollectionParentIndex memoryCollectionParentIndex, SQLiteStatement sQLiteStatement, ResourcePath resourcePath) {
        if (memoryCollectionParentIndex.add(resourcePath)) {
            String lastSegment = resourcePath.getLastSegment();
            sQLiteStatement.clearBindings();
            sQLiteStatement.bindString(1, lastSegment);
            sQLiteStatement.bindString(2, EncodedPath.encode((ResourcePath) resourcePath.popLast()));
            sQLiteStatement.execute();
        }
    }

    private boolean tableContainsColumn(String str, String str2) {
        return getTableColumns(str).indexOf(str2) != -1;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.String[], android.database.Cursor] */
    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public List<String> getTableColumns(String str) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = 0;
        try {
            SQLiteDatabase sQLiteDatabase = this.db;
            cursor = sQLiteDatabase.rawQuery("PRAGMA table_info(" + str + ")", cursor);
            int columnIndex = cursor.getColumnIndex(AppMeasurementSdk.ConditionalUserProperty.NAME);
            while (cursor.moveToNext()) {
                arrayList.add(cursor.getString(columnIndex));
            }
            return arrayList;
        } finally {
            if (cursor != 0) {
                cursor.close();
            }
        }
    }

    private boolean tableExists(String str) {
        return !new SQLitePersistence.Query(this.db, "SELECT 1=1 FROM sqlite_master WHERE tbl_name = ?").binding(str).isEmpty();
    }
}

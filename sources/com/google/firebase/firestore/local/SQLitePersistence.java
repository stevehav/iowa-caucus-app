package com.google.firebase.firestore.local;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.local.LruGarbageCollector;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.FileUtil;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Supplier;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class SQLitePersistence extends Persistence {
    private SQLiteDatabase db;
    private final SQLiteIndexManager indexManager;
    private final OpenHelper opener;
    private final SQLiteQueryCache queryCache;
    /* access modifiers changed from: private */
    public final SQLiteLruReferenceDelegate referenceDelegate;
    private final SQLiteRemoteDocumentCache remoteDocumentCache;
    private final LocalSerializer serializer;
    private boolean started;
    private final SQLiteTransactionListener transactionListener = new SQLiteTransactionListener() {
        public void onRollback() {
        }

        public void onBegin() {
            SQLitePersistence.this.referenceDelegate.onTransactionStarted();
        }

        public void onCommit() {
            SQLitePersistence.this.referenceDelegate.onTransactionCommitted();
        }
    };

    @VisibleForTesting
    public static String databaseName(String str, DatabaseId databaseId) {
        try {
            return "firestore." + URLEncoder.encode(str, "utf-8") + "." + URLEncoder.encode(databaseId.getProjectId(), "utf-8") + "." + URLEncoder.encode(databaseId.getDatabaseId(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public SQLitePersistence(Context context, String str, DatabaseId databaseId, LocalSerializer localSerializer, LruGarbageCollector.Params params) {
        this.opener = new OpenHelper(context, databaseName(str, databaseId));
        this.serializer = localSerializer;
        this.queryCache = new SQLiteQueryCache(this, this.serializer);
        this.indexManager = new SQLiteIndexManager(this);
        this.remoteDocumentCache = new SQLiteRemoteDocumentCache(this, this.serializer);
        this.referenceDelegate = new SQLiteLruReferenceDelegate(this, params);
    }

    public void start() {
        Assert.hardAssert(!this.started, "SQLitePersistence double-started!", new Object[0]);
        this.started = true;
        try {
            this.db = this.opener.getWritableDatabase();
            this.queryCache.start();
            this.referenceDelegate.start(this.queryCache.getHighestListenSequenceNumber());
        } catch (SQLiteDatabaseLockedException e) {
            throw new RuntimeException("Failed to gain exclusive lock to the Firestore client's offline persistence. This generally means you are using Firestore from multiple processes in your app. Keep in mind that multi-process Android apps execute the code in your Application class in all processes, so you may need to avoid initializing Firestore in your Application class. If you are intentionally using Firestore from multiple processes, you can only enable offline persistence (i.e. call setPersistenceEnabled(true)) in one of them.", e);
        }
    }

    public void shutdown() {
        Assert.hardAssert(this.started, "SQLitePersistence shutdown without start!", new Object[0]);
        this.started = false;
        this.db.close();
        this.db = null;
    }

    public boolean isStarted() {
        return this.started;
    }

    public SQLiteLruReferenceDelegate getReferenceDelegate() {
        return this.referenceDelegate;
    }

    /* access modifiers changed from: package-private */
    public MutationQueue getMutationQueue(User user) {
        return new SQLiteMutationQueue(this, this.serializer, user);
    }

    /* access modifiers changed from: package-private */
    public SQLiteQueryCache getQueryCache() {
        return this.queryCache;
    }

    /* access modifiers changed from: package-private */
    public IndexManager getIndexManager() {
        return this.indexManager;
    }

    /* access modifiers changed from: package-private */
    public RemoteDocumentCache getRemoteDocumentCache() {
        return this.remoteDocumentCache;
    }

    /* access modifiers changed from: package-private */
    public void runTransaction(String str, Runnable runnable) {
        Logger.debug(TAG, "Starting transaction: %s", str);
        this.db.beginTransactionWithListener(this.transactionListener);
        try {
            runnable.run();
            this.db.setTransactionSuccessful();
        } finally {
            this.db.endTransaction();
        }
    }

    /* access modifiers changed from: package-private */
    public <T> T runTransaction(String str, Supplier<T> supplier) {
        Logger.debug(TAG, "Starting transaction: %s", str);
        this.db.beginTransactionWithListener(this.transactionListener);
        try {
            T t = supplier.get();
            this.db.setTransactionSuccessful();
            return t;
        } finally {
            this.db.endTransaction();
        }
    }

    public static void clearPersistence(Context context, DatabaseId databaseId, String str) throws FirebaseFirestoreException {
        String path = context.getDatabasePath(databaseName(str, databaseId)).getPath();
        String str2 = path + "-wal";
        File file = new File(path);
        File file2 = new File(path + "-journal");
        File file3 = new File(str2);
        try {
            FileUtil.delete(file);
            FileUtil.delete(file2);
            FileUtil.delete(file3);
        } catch (IOException e) {
            throw new FirebaseFirestoreException("Failed to clear persistence." + e, FirebaseFirestoreException.Code.UNKNOWN);
        }
    }

    /* access modifiers changed from: package-private */
    public long getByteSize() {
        return getPageCount() * getPageSize();
    }

    private long getPageSize() {
        return ((Long) query("PRAGMA page_size").firstValue(SQLitePersistence$$Lambda$1.lambdaFactory$())).longValue();
    }

    private long getPageCount() {
        return ((Long) query("PRAGMA page_count").firstValue(SQLitePersistence$$Lambda$2.lambdaFactory$())).longValue();
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    private static class OpenHelper extends SQLiteOpenHelper {
        private boolean configured;

        OpenHelper(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 8);
        }

        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.configured = true;
            sQLiteDatabase.rawQuery("PRAGMA locking_mode = EXCLUSIVE", new String[0]).close();
        }

        private void ensureConfigured(SQLiteDatabase sQLiteDatabase) {
            if (!this.configured) {
                onConfigure(sQLiteDatabase);
            }
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            ensureConfigured(sQLiteDatabase);
            new SQLiteSchema(sQLiteDatabase).runMigrations(0);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            ensureConfigured(sQLiteDatabase);
            new SQLiteSchema(sQLiteDatabase).runMigrations(i);
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            ensureConfigured(sQLiteDatabase);
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            ensureConfigured(sQLiteDatabase);
        }
    }

    /* access modifiers changed from: package-private */
    public void execute(String str, Object... objArr) {
        this.db.execSQL(str, objArr);
    }

    /* access modifiers changed from: package-private */
    public SQLiteStatement prepare(String str) {
        return this.db.compileStatement(str);
    }

    /* access modifiers changed from: package-private */
    public int execute(SQLiteStatement sQLiteStatement, Object... objArr) {
        sQLiteStatement.clearBindings();
        bind(sQLiteStatement, objArr);
        return sQLiteStatement.executeUpdateDelete();
    }

    /* access modifiers changed from: package-private */
    public Query query(String str) {
        return new Query(this.db, str);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    static class Query {
        private SQLiteDatabase.CursorFactory cursorFactory;
        private final SQLiteDatabase db;
        private final String sql;

        Query(SQLiteDatabase sQLiteDatabase, String str) {
            this.db = sQLiteDatabase;
            this.sql = str;
        }

        /* access modifiers changed from: package-private */
        public Query binding(Object... objArr) {
            this.cursorFactory = SQLitePersistence$Query$$Lambda$1.lambdaFactory$(objArr);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x001a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void forEach(com.google.firebase.firestore.util.Consumer<android.database.Cursor> r3) {
            /*
                r2 = this;
                android.database.Cursor r0 = r2.startQuery()     // Catch:{ all -> 0x0016 }
            L_0x0004:
                boolean r1 = r0.moveToNext()     // Catch:{ all -> 0x0014 }
                if (r1 == 0) goto L_0x000e
                r3.accept(r0)     // Catch:{ all -> 0x0014 }
                goto L_0x0004
            L_0x000e:
                if (r0 == 0) goto L_0x0013
                r0.close()
            L_0x0013:
                return
            L_0x0014:
                r3 = move-exception
                goto L_0x0018
            L_0x0016:
                r3 = move-exception
                r0 = 0
            L_0x0018:
                if (r0 == 0) goto L_0x001d
                r0.close()
            L_0x001d:
                goto L_0x001f
            L_0x001e:
                throw r3
            L_0x001f:
                goto L_0x001e
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.local.SQLitePersistence.Query.forEach(com.google.firebase.firestore.util.Consumer):void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0021  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int first(com.google.firebase.firestore.util.Consumer<android.database.Cursor> r3) {
            /*
                r2 = this;
                android.database.Cursor r0 = r2.startQuery()     // Catch:{ all -> 0x001d }
                boolean r1 = r0.moveToFirst()     // Catch:{ all -> 0x001b }
                if (r1 == 0) goto L_0x0014
                r3.accept(r0)     // Catch:{ all -> 0x001b }
                r3 = 1
                if (r0 == 0) goto L_0x0013
                r0.close()
            L_0x0013:
                return r3
            L_0x0014:
                r3 = 0
                if (r0 == 0) goto L_0x001a
                r0.close()
            L_0x001a:
                return r3
            L_0x001b:
                r3 = move-exception
                goto L_0x001f
            L_0x001d:
                r3 = move-exception
                r0 = 0
            L_0x001f:
                if (r0 == 0) goto L_0x0024
                r0.close()
            L_0x0024:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.local.SQLitePersistence.Query.first(com.google.firebase.firestore.util.Consumer):int");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0021  */
        @javax.annotation.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <T> T firstValue(com.google.common.base.Function<android.database.Cursor, T> r4) {
            /*
                r3 = this;
                r0 = 0
                android.database.Cursor r1 = r3.startQuery()     // Catch:{ all -> 0x001d }
                boolean r2 = r1.moveToFirst()     // Catch:{ all -> 0x001b }
                if (r2 == 0) goto L_0x0015
                java.lang.Object r4 = r4.apply(r1)     // Catch:{ all -> 0x001b }
                if (r1 == 0) goto L_0x0014
                r1.close()
            L_0x0014:
                return r4
            L_0x0015:
                if (r1 == 0) goto L_0x001a
                r1.close()
            L_0x001a:
                return r0
            L_0x001b:
                r4 = move-exception
                goto L_0x001f
            L_0x001d:
                r4 = move-exception
                r1 = r0
            L_0x001f:
                if (r1 == 0) goto L_0x0024
                r1.close()
            L_0x0024:
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.local.SQLitePersistence.Query.firstValue(com.google.common.base.Function):java.lang.Object");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0016  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean isEmpty() {
            /*
                r2 = this;
                android.database.Cursor r0 = r2.startQuery()     // Catch:{ all -> 0x0012 }
                boolean r1 = r0.moveToFirst()     // Catch:{ all -> 0x0010 }
                r1 = r1 ^ 1
                if (r0 == 0) goto L_0x000f
                r0.close()
            L_0x000f:
                return r1
            L_0x0010:
                r1 = move-exception
                goto L_0x0014
            L_0x0012:
                r1 = move-exception
                r0 = 0
            L_0x0014:
                if (r0 == 0) goto L_0x0019
                r0.close()
            L_0x0019:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.local.SQLitePersistence.Query.isEmpty():boolean");
        }

        private Cursor startQuery() {
            SQLiteDatabase.CursorFactory cursorFactory2 = this.cursorFactory;
            if (cursorFactory2 != null) {
                return this.db.rawQueryWithFactory(cursorFactory2, this.sql, (String[]) null, (String) null);
            }
            return this.db.rawQuery(this.sql, (String[]) null);
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    static class LongQuery {
        private static final int LIMIT = 900;
        private final List<Object> argsHead;
        private final Iterator<Object> argsIter;
        private final SQLitePersistence db;
        private final String head;
        private int subqueriesPerformed = 0;
        private final String tail;

        LongQuery(SQLitePersistence sQLitePersistence, String str, List<Object> list, String str2) {
            this.db = sQLitePersistence;
            this.head = str;
            this.argsHead = Collections.emptyList();
            this.tail = str2;
            this.argsIter = list.iterator();
        }

        LongQuery(SQLitePersistence sQLitePersistence, String str, List<Object> list, List<Object> list2, String str2) {
            this.db = sQLitePersistence;
            this.head = str;
            this.argsHead = list;
            this.tail = str2;
            this.argsIter = list2.iterator();
        }

        /* access modifiers changed from: package-private */
        public boolean hasMoreSubqueries() {
            return this.argsIter.hasNext();
        }

        /* access modifiers changed from: package-private */
        public Query performNextSubquery() {
            this.subqueriesPerformed++;
            ArrayList arrayList = new ArrayList(this.argsHead);
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (this.argsIter.hasNext() && i < 900 - this.argsHead.size()) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append("?");
                arrayList.add(this.argsIter.next());
                i++;
            }
            String sb2 = sb.toString();
            return this.db.query(this.head + sb2 + this.tail).binding(arrayList.toArray());
        }

        /* access modifiers changed from: package-private */
        public int getSubqueriesPerformed() {
            return this.subqueriesPerformed;
        }
    }

    /* access modifiers changed from: private */
    public static void bind(SQLiteProgram sQLiteProgram, Object[] objArr) {
        for (int i = 0; i < objArr.length; i++) {
            String str = objArr[i];
            if (str == null) {
                sQLiteProgram.bindNull(i + 1);
            } else if (str instanceof String) {
                sQLiteProgram.bindString(i + 1, str);
            } else if (str instanceof Integer) {
                sQLiteProgram.bindLong(i + 1, (long) ((Integer) str).intValue());
            } else if (str instanceof Long) {
                sQLiteProgram.bindLong(i + 1, ((Long) str).longValue());
            } else if (str instanceof Double) {
                sQLiteProgram.bindDouble(i + 1, ((Double) str).doubleValue());
            } else if (str instanceof byte[]) {
                sQLiteProgram.bindBlob(i + 1, (byte[]) str);
            } else {
                throw Assert.fail("Unknown argument %s of type %s", str, str.getClass());
            }
        }
    }
}

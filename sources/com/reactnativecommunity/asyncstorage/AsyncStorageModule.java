package com.reactnativecommunity.asyncstorage;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.AsyncTask;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.common.ModuleDataCleaner;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executor;

@ReactModule(name = "RNC_AsyncSQLiteDBStorage")
public final class AsyncStorageModule extends ReactContextBaseJavaModule implements ModuleDataCleaner.Cleanable {
    private static final int MAX_SQL_KEYS = 999;
    public static final String NAME = "RNC_AsyncSQLiteDBStorage";
    private final SerialExecutor executor;
    /* access modifiers changed from: private */
    public ReactDatabaseSupplier mReactDatabaseSupplier;
    private boolean mShuttingDown;

    public String getName() {
        return NAME;
    }

    private class SerialExecutor implements Executor {
        private final Executor executor;
        private Runnable mActive;
        private final ArrayDeque<Runnable> mTasks = new ArrayDeque<>();

        SerialExecutor(Executor executor2) {
            this.executor = executor2;
        }

        public synchronized void execute(final Runnable runnable) {
            this.mTasks.offer(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        SerialExecutor.this.scheduleNext();
                    }
                }
            });
            if (this.mActive == null) {
                scheduleNext();
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized void scheduleNext() {
            Runnable poll = this.mTasks.poll();
            this.mActive = poll;
            if (poll != null) {
                this.executor.execute(this.mActive);
            }
        }
    }

    public AsyncStorageModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @VisibleForTesting
    AsyncStorageModule(ReactApplicationContext reactApplicationContext, Executor executor2) {
        super(reactApplicationContext);
        this.mShuttingDown = false;
        this.executor = new SerialExecutor(executor2);
        this.mReactDatabaseSupplier = ReactDatabaseSupplier.getInstance(reactApplicationContext);
    }

    public void initialize() {
        super.initialize();
        this.mShuttingDown = false;
    }

    public void onCatalystInstanceDestroy() {
        this.mShuttingDown = true;
    }

    public void clearSensitiveData() {
        this.mReactDatabaseSupplier.clearAndCloseDatabase();
    }

    @ReactMethod
    public void multiGet(final ReadableArray readableArray, final Callback callback) {
        if (readableArray == null) {
            callback.invoke(AsyncStorageErrorUtil.getInvalidKeyError((String) null), null);
            return;
        }
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* access modifiers changed from: protected */
            public void doInBackgroundGuarded(Void... voidArr) {
                if (!AsyncStorageModule.this.ensureDatabase()) {
                    callback.invoke(AsyncStorageErrorUtil.getDBError((String) null), null);
                    return;
                }
                String[] strArr = {"key", "value"};
                HashSet hashSet = new HashSet();
                WritableArray createArray = Arguments.createArray();
                int i = 0;
                while (i < readableArray.size()) {
                    int min = Math.min(readableArray.size() - i, 999);
                    int i2 = min;
                    int i3 = i;
                    Cursor query = AsyncStorageModule.this.mReactDatabaseSupplier.get().query("catalystLocalStorage", strArr, AsyncLocalStorageUtil.buildKeySelection(min), AsyncLocalStorageUtil.buildKeySelectionArgs(readableArray, i, min), (String) null, (String) null, (String) null);
                    hashSet.clear();
                    try {
                        if (query.getCount() != readableArray.size()) {
                            for (int i4 = i3; i4 < i3 + i2; i4++) {
                                hashSet.add(readableArray.getString(i4));
                            }
                        }
                        if (query.moveToFirst()) {
                            do {
                                WritableArray createArray2 = Arguments.createArray();
                                createArray2.pushString(query.getString(0));
                                createArray2.pushString(query.getString(1));
                                createArray.pushArray(createArray2);
                                hashSet.remove(query.getString(0));
                            } while (query.moveToNext());
                        }
                        query.close();
                        Iterator it = hashSet.iterator();
                        while (it.hasNext()) {
                            WritableArray createArray3 = Arguments.createArray();
                            createArray3.pushString((String) it.next());
                            createArray3.pushNull();
                            createArray.pushArray(createArray3);
                        }
                        hashSet.clear();
                        i = i3 + 999;
                    } catch (Exception e) {
                        FLog.w(ReactConstants.TAG, e.getMessage(), (Throwable) e);
                        callback.invoke(AsyncStorageErrorUtil.getError((String) null, e.getMessage()), null);
                        query.close();
                        return;
                    } catch (Throwable th) {
                        query.close();
                        throw th;
                    }
                }
                callback.invoke(null, createArray);
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    @ReactMethod
    public void multiSet(final ReadableArray readableArray, final Callback callback) {
        if (readableArray.size() == 0) {
            callback.invoke(new Object[0]);
        } else {
            new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
                /* access modifiers changed from: protected */
                public void doInBackgroundGuarded(Void... voidArr) {
                    WritableMap writableMap = null;
                    if (!AsyncStorageModule.this.ensureDatabase()) {
                        callback.invoke(AsyncStorageErrorUtil.getDBError((String) null));
                        return;
                    }
                    SQLiteStatement compileStatement = AsyncStorageModule.this.mReactDatabaseSupplier.get().compileStatement("INSERT OR REPLACE INTO catalystLocalStorage VALUES (?, ?);");
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
                        int i = 0;
                        while (i < readableArray.size()) {
                            if (readableArray.getArray(i).size() != 2) {
                                WritableMap invalidValueError = AsyncStorageErrorUtil.getInvalidValueError((String) null);
                                try {
                                    AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                    return;
                                } catch (Exception e) {
                                    FLog.w(ReactConstants.TAG, e.getMessage(), (Throwable) e);
                                    if (invalidValueError == null) {
                                        AsyncStorageErrorUtil.getError((String) null, e.getMessage());
                                        return;
                                    }
                                    return;
                                }
                            } else if (readableArray.getArray(i).getString(0) == null) {
                                WritableMap invalidKeyError = AsyncStorageErrorUtil.getInvalidKeyError((String) null);
                                try {
                                    AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                    return;
                                } catch (Exception e2) {
                                    FLog.w(ReactConstants.TAG, e2.getMessage(), (Throwable) e2);
                                    if (invalidKeyError == null) {
                                        AsyncStorageErrorUtil.getError((String) null, e2.getMessage());
                                        return;
                                    }
                                    return;
                                }
                            } else if (readableArray.getArray(i).getString(1) == null) {
                                WritableMap invalidValueError2 = AsyncStorageErrorUtil.getInvalidValueError((String) null);
                                try {
                                    AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                    return;
                                } catch (Exception e3) {
                                    FLog.w(ReactConstants.TAG, e3.getMessage(), (Throwable) e3);
                                    if (invalidValueError2 == null) {
                                        AsyncStorageErrorUtil.getError((String) null, e3.getMessage());
                                        return;
                                    }
                                    return;
                                }
                            } else {
                                compileStatement.clearBindings();
                                compileStatement.bindString(1, readableArray.getArray(i).getString(0));
                                compileStatement.bindString(2, readableArray.getArray(i).getString(1));
                                compileStatement.execute();
                                i++;
                            }
                        }
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                        } catch (Exception e4) {
                            FLog.w(ReactConstants.TAG, e4.getMessage(), (Throwable) e4);
                            writableMap = AsyncStorageErrorUtil.getError((String) null, e4.getMessage());
                        }
                    } catch (Exception e5) {
                        FLog.w(ReactConstants.TAG, e5.getMessage(), (Throwable) e5);
                        WritableMap error = AsyncStorageErrorUtil.getError((String) null, e5.getMessage());
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                        } catch (Exception e6) {
                            FLog.w(ReactConstants.TAG, e6.getMessage(), (Throwable) e6);
                            if (error == null) {
                                writableMap = AsyncStorageErrorUtil.getError((String) null, e6.getMessage());
                            }
                        }
                        writableMap = error;
                    } catch (Throwable th) {
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                        } catch (Exception e7) {
                            FLog.w(ReactConstants.TAG, e7.getMessage(), (Throwable) e7);
                            AsyncStorageErrorUtil.getError((String) null, e7.getMessage());
                        }
                        throw th;
                    }
                    if (writableMap != null) {
                        callback.invoke(writableMap);
                        return;
                    }
                    callback.invoke(new Object[0]);
                }
            }.executeOnExecutor(this.executor, new Void[0]);
        }
    }

    @ReactMethod
    public void multiRemove(final ReadableArray readableArray, final Callback callback) {
        if (readableArray.size() == 0) {
            callback.invoke(new Object[0]);
        } else {
            new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
                /* access modifiers changed from: protected */
                public void doInBackgroundGuarded(Void... voidArr) {
                    WritableMap writableMap = null;
                    if (!AsyncStorageModule.this.ensureDatabase()) {
                        callback.invoke(AsyncStorageErrorUtil.getDBError((String) null));
                        return;
                    }
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
                        for (int i = 0; i < readableArray.size(); i += 999) {
                            int min = Math.min(readableArray.size() - i, 999);
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().delete("catalystLocalStorage", AsyncLocalStorageUtil.buildKeySelection(min), AsyncLocalStorageUtil.buildKeySelectionArgs(readableArray, i, min));
                        }
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                        } catch (Exception e) {
                            FLog.w(ReactConstants.TAG, e.getMessage(), (Throwable) e);
                            writableMap = AsyncStorageErrorUtil.getError((String) null, e.getMessage());
                        }
                    } catch (Exception e2) {
                        FLog.w(ReactConstants.TAG, e2.getMessage(), (Throwable) e2);
                        WritableMap error = AsyncStorageErrorUtil.getError((String) null, e2.getMessage());
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                        } catch (Exception e3) {
                            FLog.w(ReactConstants.TAG, e3.getMessage(), (Throwable) e3);
                            if (error == null) {
                                writableMap = AsyncStorageErrorUtil.getError((String) null, e3.getMessage());
                            }
                        }
                        writableMap = error;
                    } catch (Throwable th) {
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                        } catch (Exception e4) {
                            FLog.w(ReactConstants.TAG, e4.getMessage(), (Throwable) e4);
                            AsyncStorageErrorUtil.getError((String) null, e4.getMessage());
                        }
                        throw th;
                    }
                    if (writableMap != null) {
                        callback.invoke(writableMap);
                        return;
                    }
                    callback.invoke(new Object[0]);
                }
            }.executeOnExecutor(this.executor, new Void[0]);
        }
    }

    @ReactMethod
    public void multiMerge(final ReadableArray readableArray, final Callback callback) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* access modifiers changed from: protected */
            public void doInBackgroundGuarded(Void... voidArr) {
                WritableMap writableMap = null;
                if (!AsyncStorageModule.this.ensureDatabase()) {
                    callback.invoke(AsyncStorageErrorUtil.getDBError((String) null));
                    return;
                }
                try {
                    AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
                    int i = 0;
                    while (i < readableArray.size()) {
                        if (readableArray.getArray(i).size() != 2) {
                            WritableMap invalidValueError = AsyncStorageErrorUtil.getInvalidValueError((String) null);
                            try {
                                AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                return;
                            } catch (Exception e) {
                                FLog.w(ReactConstants.TAG, e.getMessage(), (Throwable) e);
                                if (invalidValueError == null) {
                                    AsyncStorageErrorUtil.getError((String) null, e.getMessage());
                                    return;
                                }
                                return;
                            }
                        } else if (readableArray.getArray(i).getString(0) == null) {
                            WritableMap invalidKeyError = AsyncStorageErrorUtil.getInvalidKeyError((String) null);
                            try {
                                AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                return;
                            } catch (Exception e2) {
                                FLog.w(ReactConstants.TAG, e2.getMessage(), (Throwable) e2);
                                if (invalidKeyError == null) {
                                    AsyncStorageErrorUtil.getError((String) null, e2.getMessage());
                                    return;
                                }
                                return;
                            }
                        } else if (readableArray.getArray(i).getString(1) == null) {
                            WritableMap invalidValueError2 = AsyncStorageErrorUtil.getInvalidValueError((String) null);
                            try {
                                AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                return;
                            } catch (Exception e3) {
                                FLog.w(ReactConstants.TAG, e3.getMessage(), (Throwable) e3);
                                if (invalidValueError2 == null) {
                                    AsyncStorageErrorUtil.getError((String) null, e3.getMessage());
                                    return;
                                }
                                return;
                            }
                        } else if (!AsyncLocalStorageUtil.mergeImpl(AsyncStorageModule.this.mReactDatabaseSupplier.get(), readableArray.getArray(i).getString(0), readableArray.getArray(i).getString(1))) {
                            WritableMap dBError = AsyncStorageErrorUtil.getDBError((String) null);
                            try {
                                AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                return;
                            } catch (Exception e4) {
                                FLog.w(ReactConstants.TAG, e4.getMessage(), (Throwable) e4);
                                if (dBError == null) {
                                    AsyncStorageErrorUtil.getError((String) null, e4.getMessage());
                                    return;
                                }
                                return;
                            }
                        } else {
                            i++;
                        }
                    }
                    AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                    } catch (Exception e5) {
                        FLog.w(ReactConstants.TAG, e5.getMessage(), (Throwable) e5);
                        writableMap = AsyncStorageErrorUtil.getError((String) null, e5.getMessage());
                    }
                } catch (Exception e6) {
                    FLog.w(ReactConstants.TAG, e6.getMessage(), (Throwable) e6);
                    WritableMap error = AsyncStorageErrorUtil.getError((String) null, e6.getMessage());
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                    } catch (Exception e7) {
                        FLog.w(ReactConstants.TAG, e7.getMessage(), (Throwable) e7);
                        if (error == null) {
                            writableMap = AsyncStorageErrorUtil.getError((String) null, e7.getMessage());
                        }
                    }
                    writableMap = error;
                } catch (Throwable th) {
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                    } catch (Exception e8) {
                        FLog.w(ReactConstants.TAG, e8.getMessage(), (Throwable) e8);
                        AsyncStorageErrorUtil.getError((String) null, e8.getMessage());
                    }
                    throw th;
                }
                if (writableMap != null) {
                    callback.invoke(writableMap);
                    return;
                }
                callback.invoke(new Object[0]);
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    @ReactMethod
    public void clear(final Callback callback) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* access modifiers changed from: protected */
            public void doInBackgroundGuarded(Void... voidArr) {
                if (!AsyncStorageModule.this.mReactDatabaseSupplier.ensureDatabase()) {
                    callback.invoke(AsyncStorageErrorUtil.getDBError((String) null));
                    return;
                }
                try {
                    AsyncStorageModule.this.mReactDatabaseSupplier.clear();
                    callback.invoke(new Object[0]);
                } catch (Exception e) {
                    FLog.w(ReactConstants.TAG, e.getMessage(), (Throwable) e);
                    callback.invoke(AsyncStorageErrorUtil.getError((String) null, e.getMessage()));
                }
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    @ReactMethod
    public void getAllKeys(final Callback callback) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* access modifiers changed from: protected */
            public void doInBackgroundGuarded(Void... voidArr) {
                if (!AsyncStorageModule.this.ensureDatabase()) {
                    callback.invoke(AsyncStorageErrorUtil.getDBError((String) null), null);
                    return;
                }
                WritableArray createArray = Arguments.createArray();
                Cursor query = AsyncStorageModule.this.mReactDatabaseSupplier.get().query("catalystLocalStorage", new String[]{"key"}, (String) null, (String[]) null, (String) null, (String) null, (String) null);
                try {
                    if (query.moveToFirst()) {
                        do {
                            createArray.pushString(query.getString(0));
                        } while (query.moveToNext());
                    }
                    query.close();
                    callback.invoke(null, createArray);
                } catch (Exception e) {
                    FLog.w(ReactConstants.TAG, e.getMessage(), (Throwable) e);
                    callback.invoke(AsyncStorageErrorUtil.getError((String) null, e.getMessage()), null);
                    query.close();
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    /* access modifiers changed from: private */
    public boolean ensureDatabase() {
        return !this.mShuttingDown && this.mReactDatabaseSupplier.ensureDatabase();
    }
}

package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.os.StrictMode;
import android.util.Log;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public abstract class UnpackingSoSource extends DirectorySoSource {
    private static final String DEPS_FILE_NAME = "dso_deps";
    private static final String LOCK_FILE_NAME = "dso_lock";
    private static final String MANIFEST_FILE_NAME = "dso_manifest";
    private static final byte MANIFEST_VERSION = 1;
    private static final byte STATE_CLEAN = 1;
    private static final byte STATE_DIRTY = 0;
    private static final String STATE_FILE_NAME = "dso_state";
    private static final String TAG = "fb-UnpackingSoSource";
    @Nullable
    private String[] mAbis;
    protected final Context mContext;
    @Nullable
    protected String mCorruptedLib;
    private final Map<String, Object> mLibsBeingLoaded = new HashMap();

    /* access modifiers changed from: protected */
    public abstract Unpacker makeUnpacker() throws IOException;

    protected UnpackingSoSource(Context context, String str) {
        super(getSoStorePath(context, str), 1);
        this.mContext = context;
    }

    protected UnpackingSoSource(Context context, File file) {
        super(file, 1);
        this.mContext = context;
    }

    public static File getSoStorePath(Context context, String str) {
        return new File(context.getApplicationInfo().dataDir + "/" + str);
    }

    public String[] getSoSourceAbis() {
        String[] strArr = this.mAbis;
        return strArr == null ? super.getSoSourceAbis() : strArr;
    }

    public void setSoSourceAbis(String[] strArr) {
        this.mAbis = strArr;
    }

    public static class Dso {
        public final String hash;
        public final String name;

        public Dso(String str, String str2) {
            this.name = str;
            this.hash = str2;
        }
    }

    public static final class DsoManifest {
        public final Dso[] dsos;

        public DsoManifest(Dso[] dsoArr) {
            this.dsos = dsoArr;
        }

        static final DsoManifest read(DataInput dataInput) throws IOException {
            if (dataInput.readByte() == 1) {
                int readInt = dataInput.readInt();
                if (readInt >= 0) {
                    Dso[] dsoArr = new Dso[readInt];
                    for (int i = 0; i < readInt; i++) {
                        dsoArr[i] = new Dso(dataInput.readUTF(), dataInput.readUTF());
                    }
                    return new DsoManifest(dsoArr);
                }
                throw new RuntimeException("illegal number of shared libraries");
            }
            throw new RuntimeException("wrong dso manifest version");
        }

        public final void write(DataOutput dataOutput) throws IOException {
            dataOutput.writeByte(1);
            dataOutput.writeInt(this.dsos.length);
            int i = 0;
            while (true) {
                Dso[] dsoArr = this.dsos;
                if (i < dsoArr.length) {
                    dataOutput.writeUTF(dsoArr[i].name);
                    dataOutput.writeUTF(this.dsos[i].hash);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    protected static final class InputDso implements Closeable {
        public final InputStream content;
        public final Dso dso;

        public InputDso(Dso dso2, InputStream inputStream) {
            this.dso = dso2;
            this.content = inputStream;
        }

        public void close() throws IOException {
            this.content.close();
        }
    }

    protected static abstract class InputDsoIterator implements Closeable {
        public void close() throws IOException {
        }

        public abstract boolean hasNext();

        public abstract InputDso next() throws IOException;

        protected InputDsoIterator() {
        }
    }

    protected static abstract class Unpacker implements Closeable {
        public void close() throws IOException {
        }

        /* access modifiers changed from: protected */
        public abstract DsoManifest getDsoManifest() throws IOException;

        /* access modifiers changed from: protected */
        public abstract InputDsoIterator openDsoIterator() throws IOException;

        protected Unpacker() {
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0022, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        if (r3 != null) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeState(java.io.File r3, byte r4) throws java.io.IOException {
        /*
            java.io.RandomAccessFile r0 = new java.io.RandomAccessFile
            java.lang.String r1 = "rw"
            r0.<init>(r3, r1)
            r1 = 0
            r3 = 0
            r0.seek(r1)     // Catch:{ Throwable -> 0x0024 }
            r0.write(r4)     // Catch:{ Throwable -> 0x0024 }
            long r1 = r0.getFilePointer()     // Catch:{ Throwable -> 0x0024 }
            r0.setLength(r1)     // Catch:{ Throwable -> 0x0024 }
            java.io.FileDescriptor r4 = r0.getFD()     // Catch:{ Throwable -> 0x0024 }
            r4.sync()     // Catch:{ Throwable -> 0x0024 }
            r0.close()
            return
        L_0x0022:
            r4 = move-exception
            goto L_0x0026
        L_0x0024:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0022 }
        L_0x0026:
            if (r3 == 0) goto L_0x002c
            r0.close()     // Catch:{ Throwable -> 0x002f }
            goto L_0x002f
        L_0x002c:
            r0.close()
        L_0x002f:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.writeState(java.io.File, byte):void");
    }

    private void deleteUnmentionedFiles(Dso[] dsoArr) throws IOException {
        String[] list = this.soDirectory.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals(STATE_FILE_NAME) && !str.equals(LOCK_FILE_NAME) && !str.equals(DEPS_FILE_NAME) && !str.equals(MANIFEST_FILE_NAME)) {
                    boolean z = false;
                    int i = 0;
                    while (!z && i < dsoArr.length) {
                        if (dsoArr[i].name.equals(str)) {
                            z = true;
                        }
                        i++;
                    }
                    if (!z) {
                        File file = new File(this.soDirectory, str);
                        Log.v(TAG, "deleting unaccounted-for file " + file);
                        SysUtil.dumbDeleteRecursive(file);
                    }
                }
            }
            return;
        }
        throw new IOException("unable to list directory " + this.soDirectory);
    }

    private void extractDso(InputDso inputDso, byte[] bArr) throws IOException {
        RandomAccessFile randomAccessFile;
        Log.i(TAG, "extracting DSO " + inputDso.dso.name);
        if (this.soDirectory.setWritable(true, true)) {
            File file = new File(this.soDirectory, inputDso.dso.name);
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (IOException e) {
                Log.w(TAG, "error overwriting " + file + " trying to delete and start over", e);
                SysUtil.dumbDeleteRecursive(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
            }
            try {
                int available = inputDso.content.available();
                if (available > 1) {
                    SysUtil.fallocateIfSupported(randomAccessFile.getFD(), (long) available);
                }
                SysUtil.copyBytes(randomAccessFile, inputDso.content, Integer.MAX_VALUE, bArr);
                randomAccessFile.setLength(randomAccessFile.getFilePointer());
                if (file.setExecutable(true, false)) {
                    randomAccessFile.close();
                    return;
                }
                throw new IOException("cannot make file executable: " + file);
            } catch (IOException e2) {
                SysUtil.dumbDeleteRecursive(file);
                throw e2;
            } catch (Throwable th) {
                randomAccessFile.close();
                throw th;
            }
        } else {
            throw new IOException("cannot make directory writable for us: " + this.soDirectory);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048 A[Catch:{ Throwable -> 0x003a, all -> 0x0037, Throwable -> 0x00dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005f A[Catch:{ Throwable -> 0x003a, all -> 0x0037, Throwable -> 0x00dc }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void regenerate(byte r12, com.facebook.soloader.UnpackingSoSource.DsoManifest r13, com.facebook.soloader.UnpackingSoSource.InputDsoIterator r14) throws java.io.IOException {
        /*
            r11 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "regenerating DSO store "
            r0.append(r1)
            java.lang.Class r1 = r11.getClass()
            java.lang.String r1 = r1.getName()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "fb-UnpackingSoSource"
            android.util.Log.v(r1, r0)
            java.io.File r0 = new java.io.File
            java.io.File r2 = r11.soDirectory
            java.lang.String r3 = "dso_manifest"
            r0.<init>(r2, r3)
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile
            java.lang.String r3 = "rw"
            r2.<init>(r0, r3)
            r0 = 1
            r3 = 0
            if (r12 != r0) goto L_0x0044
            com.facebook.soloader.UnpackingSoSource$DsoManifest r12 = com.facebook.soloader.UnpackingSoSource.DsoManifest.read(r2)     // Catch:{ Exception -> 0x003e }
            goto L_0x0045
        L_0x0037:
            r12 = move-exception
            goto L_0x00d3
        L_0x003a:
            r12 = move-exception
            r3 = r12
            goto L_0x00d2
        L_0x003e:
            r12 = move-exception
            java.lang.String r4 = "error reading existing DSO manifest"
            android.util.Log.i(r1, r4, r12)     // Catch:{ Throwable -> 0x003a }
        L_0x0044:
            r12 = r3
        L_0x0045:
            r4 = 0
            if (r12 != 0) goto L_0x004f
            com.facebook.soloader.UnpackingSoSource$DsoManifest r12 = new com.facebook.soloader.UnpackingSoSource$DsoManifest     // Catch:{ Throwable -> 0x003a }
            com.facebook.soloader.UnpackingSoSource$Dso[] r5 = new com.facebook.soloader.UnpackingSoSource.Dso[r4]     // Catch:{ Throwable -> 0x003a }
            r12.<init>(r5)     // Catch:{ Throwable -> 0x003a }
        L_0x004f:
            com.facebook.soloader.UnpackingSoSource$Dso[] r13 = r13.dsos     // Catch:{ Throwable -> 0x003a }
            r11.deleteUnmentionedFiles(r13)     // Catch:{ Throwable -> 0x003a }
            r13 = 32768(0x8000, float:4.5918E-41)
            byte[] r13 = new byte[r13]     // Catch:{ Throwable -> 0x003a }
        L_0x0059:
            boolean r5 = r14.hasNext()     // Catch:{ Throwable -> 0x003a }
            if (r5 == 0) goto L_0x00b2
            com.facebook.soloader.UnpackingSoSource$InputDso r5 = r14.next()     // Catch:{ Throwable -> 0x003a }
            r6 = 1
            r7 = 0
        L_0x0065:
            if (r6 == 0) goto L_0x0095
            com.facebook.soloader.UnpackingSoSource$Dso[] r8 = r12.dsos     // Catch:{ Throwable -> 0x0093, all -> 0x0090 }
            int r8 = r8.length     // Catch:{ Throwable -> 0x0093, all -> 0x0090 }
            if (r7 >= r8) goto L_0x0095
            com.facebook.soloader.UnpackingSoSource$Dso[] r8 = r12.dsos     // Catch:{ Throwable -> 0x0093, all -> 0x0090 }
            r8 = r8[r7]     // Catch:{ Throwable -> 0x0093, all -> 0x0090 }
            java.lang.String r8 = r8.name     // Catch:{ Throwable -> 0x0093, all -> 0x0090 }
            com.facebook.soloader.UnpackingSoSource$Dso r9 = r5.dso     // Catch:{ Throwable -> 0x0093, all -> 0x0090 }
            java.lang.String r9 = r9.name     // Catch:{ Throwable -> 0x0093, all -> 0x0090 }
            boolean r8 = r8.equals(r9)     // Catch:{ Throwable -> 0x0093, all -> 0x0090 }
            if (r8 == 0) goto L_0x008d
            com.facebook.soloader.UnpackingSoSource$Dso[] r8 = r12.dsos     // Catch:{ Throwable -> 0x0093, all -> 0x0090 }
            r8 = r8[r7]     // Catch:{ Throwable -> 0x0093, all -> 0x0090 }
            java.lang.String r8 = r8.hash     // Catch:{ Throwable -> 0x0093, all -> 0x0090 }
            com.facebook.soloader.UnpackingSoSource$Dso r9 = r5.dso     // Catch:{ Throwable -> 0x0093, all -> 0x0090 }
            java.lang.String r9 = r9.hash     // Catch:{ Throwable -> 0x0093, all -> 0x0090 }
            boolean r8 = r8.equals(r9)     // Catch:{ Throwable -> 0x0093, all -> 0x0090 }
            if (r8 == 0) goto L_0x008d
            r6 = 0
        L_0x008d:
            int r7 = r7 + 1
            goto L_0x0065
        L_0x0090:
            r12 = move-exception
            r13 = r3
            goto L_0x00a0
        L_0x0093:
            r12 = move-exception
            goto L_0x009b
        L_0x0095:
            if (r6 == 0) goto L_0x00ac
            r11.extractDso(r5, r13)     // Catch:{ Throwable -> 0x0093, all -> 0x0090 }
            goto L_0x00ac
        L_0x009b:
            throw r12     // Catch:{ all -> 0x009c }
        L_0x009c:
            r13 = move-exception
            r10 = r13
            r13 = r12
            r12 = r10
        L_0x00a0:
            if (r5 == 0) goto L_0x00ab
            if (r13 == 0) goto L_0x00a8
            r5.close()     // Catch:{ Throwable -> 0x00ab }
            goto L_0x00ab
        L_0x00a8:
            r5.close()     // Catch:{ Throwable -> 0x003a }
        L_0x00ab:
            throw r12     // Catch:{ Throwable -> 0x003a }
        L_0x00ac:
            if (r5 == 0) goto L_0x0059
            r5.close()     // Catch:{ Throwable -> 0x003a }
            goto L_0x0059
        L_0x00b2:
            r2.close()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Finished regenerating DSO store "
            r12.append(r13)
            java.lang.Class r13 = r11.getClass()
            java.lang.String r13 = r13.getName()
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            android.util.Log.v(r1, r12)
            return
        L_0x00d2:
            throw r3     // Catch:{ all -> 0x0037 }
        L_0x00d3:
            if (r3 == 0) goto L_0x00d9
            r2.close()     // Catch:{ Throwable -> 0x00dc }
            goto L_0x00dc
        L_0x00d9:
            r2.close()
        L_0x00dc:
            goto L_0x00de
        L_0x00dd:
            throw r12
        L_0x00de:
            goto L_0x00dd
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.regenerate(byte, com.facebook.soloader.UnpackingSoSource$DsoManifest, com.facebook.soloader.UnpackingSoSource$InputDsoIterator):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00db, code lost:
        r13 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00dc, code lost:
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e0, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00e1, code lost:
        r11 = r14;
        r14 = r13;
        r13 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00f0, code lost:
        r13 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00f1, code lost:
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00f5, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00f6, code lost:
        r11 = r14;
        r14 = r13;
        r13 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00fb, code lost:
        if (r14 != null) goto L_0x00fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f0 A[ExcHandler: all (th java.lang.Throwable)] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00fb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean refreshLocked(com.facebook.soloader.FileLocker r13, int r14, byte[] r15) throws java.io.IOException {
        /*
            r12 = this;
            java.lang.String r0 = "fb-UnpackingSoSource"
            java.io.File r6 = new java.io.File
            java.io.File r1 = r12.soDirectory
            java.lang.String r2 = "dso_state"
            r6.<init>(r1, r2)
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile
            java.lang.String r2 = "rw"
            r1.<init>(r6, r2)
            r8 = 1
            r3 = 0
            r4 = 0
            byte r5 = r1.readByte()     // Catch:{ EOFException -> 0x0036, Throwable -> 0x003a }
            if (r5 == r8) goto L_0x0047
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x0036, Throwable -> 0x003a }
            r5.<init>()     // Catch:{ EOFException -> 0x0036, Throwable -> 0x003a }
            java.lang.String r7 = "dso store "
            r5.append(r7)     // Catch:{ EOFException -> 0x0036, Throwable -> 0x003a }
            java.io.File r7 = r12.soDirectory     // Catch:{ EOFException -> 0x0036, Throwable -> 0x003a }
            r5.append(r7)     // Catch:{ EOFException -> 0x0036, Throwable -> 0x003a }
            java.lang.String r7 = " regeneration interrupted: wiping clean"
            r5.append(r7)     // Catch:{ EOFException -> 0x0036, Throwable -> 0x003a }
            java.lang.String r5 = r5.toString()     // Catch:{ EOFException -> 0x0036, Throwable -> 0x003a }
            android.util.Log.v(r0, r5)     // Catch:{ EOFException -> 0x0036, Throwable -> 0x003a }
        L_0x0036:
            r5 = 0
            goto L_0x0047
        L_0x0038:
            r13 = move-exception
            goto L_0x003d
        L_0x003a:
            r13 = move-exception
            r3 = r13
            throw r3     // Catch:{ all -> 0x0038 }
        L_0x003d:
            if (r3 == 0) goto L_0x0043
            r1.close()     // Catch:{ Throwable -> 0x0046 }
            goto L_0x0046
        L_0x0043:
            r1.close()
        L_0x0046:
            throw r13
        L_0x0047:
            r1.close()
            java.io.File r7 = new java.io.File
            java.io.File r1 = r12.soDirectory
            java.lang.String r9 = "dso_deps"
            r7.<init>(r1, r9)
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile
            r1.<init>(r7, r2)
            long r9 = r1.length()     // Catch:{ Throwable -> 0x0107 }
            int r2 = (int) r9     // Catch:{ Throwable -> 0x0107 }
            byte[] r2 = new byte[r2]     // Catch:{ Throwable -> 0x0107 }
            int r9 = r1.read(r2)     // Catch:{ Throwable -> 0x0107 }
            int r10 = r2.length     // Catch:{ Throwable -> 0x0107 }
            if (r9 == r10) goto L_0x006c
            java.lang.String r5 = "short read of so store deps file: marking unclean"
            android.util.Log.v(r0, r5)     // Catch:{ Throwable -> 0x0107 }
            r5 = 0
        L_0x006c:
            boolean r2 = java.util.Arrays.equals(r2, r15)     // Catch:{ Throwable -> 0x0107 }
            if (r2 != 0) goto L_0x0078
            java.lang.String r2 = "deps mismatch on deps store: regenerating"
            android.util.Log.v(r0, r2)     // Catch:{ Throwable -> 0x0107 }
            r5 = 0
        L_0x0078:
            if (r5 == 0) goto L_0x0081
            r2 = r14 & 2
            if (r2 == 0) goto L_0x007f
            goto L_0x0081
        L_0x007f:
            r5 = r3
            goto L_0x00a3
        L_0x0081:
            java.lang.String r2 = "so store dirty: regenerating"
            android.util.Log.v(r0, r2)     // Catch:{ Throwable -> 0x0107 }
            writeState(r6, r4)     // Catch:{ Throwable -> 0x0107 }
            com.facebook.soloader.UnpackingSoSource$Unpacker r0 = r12.makeUnpacker()     // Catch:{ Throwable -> 0x0107 }
            com.facebook.soloader.UnpackingSoSource$DsoManifest r2 = r0.getDsoManifest()     // Catch:{ Throwable -> 0x00f3, all -> 0x00f0 }
            com.facebook.soloader.UnpackingSoSource$InputDsoIterator r9 = r0.openDsoIterator()     // Catch:{ Throwable -> 0x00f3, all -> 0x00f0 }
            r12.regenerate(r5, r2, r9)     // Catch:{ Throwable -> 0x00de, all -> 0x00db }
            if (r9 == 0) goto L_0x009d
            r9.close()     // Catch:{ Throwable -> 0x00f3, all -> 0x00f0 }
        L_0x009d:
            if (r0 == 0) goto L_0x00a2
            r0.close()     // Catch:{ Throwable -> 0x0107 }
        L_0x00a2:
            r5 = r2
        L_0x00a3:
            r1.close()
            if (r5 != 0) goto L_0x00a9
            return r4
        L_0x00a9:
            com.facebook.soloader.UnpackingSoSource$1 r0 = new com.facebook.soloader.UnpackingSoSource$1
            r1 = r0
            r2 = r12
            r3 = r7
            r4 = r15
            r7 = r13
            r1.<init>(r3, r4, r5, r6, r7)
            r13 = r14 & 1
            if (r13 == 0) goto L_0x00d7
            java.lang.Thread r13 = new java.lang.Thread
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "SoSync:"
            r14.append(r15)
            java.io.File r15 = r12.soDirectory
            java.lang.String r15 = r15.getName()
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            r13.<init>(r0, r14)
            r13.start()
            goto L_0x00da
        L_0x00d7:
            r0.run()
        L_0x00da:
            return r8
        L_0x00db:
            r13 = move-exception
            r14 = r3
            goto L_0x00e4
        L_0x00de:
            r13 = move-exception
            throw r13     // Catch:{ all -> 0x00e0 }
        L_0x00e0:
            r14 = move-exception
            r11 = r14
            r14 = r13
            r13 = r11
        L_0x00e4:
            if (r9 == 0) goto L_0x00ef
            if (r14 == 0) goto L_0x00ec
            r9.close()     // Catch:{ Throwable -> 0x00ef, all -> 0x00f0 }
            goto L_0x00ef
        L_0x00ec:
            r9.close()     // Catch:{ Throwable -> 0x00f3, all -> 0x00f0 }
        L_0x00ef:
            throw r13     // Catch:{ Throwable -> 0x00f3, all -> 0x00f0 }
        L_0x00f0:
            r13 = move-exception
            r14 = r3
            goto L_0x00f9
        L_0x00f3:
            r13 = move-exception
            throw r13     // Catch:{ all -> 0x00f5 }
        L_0x00f5:
            r14 = move-exception
            r11 = r14
            r14 = r13
            r13 = r11
        L_0x00f9:
            if (r0 == 0) goto L_0x0104
            if (r14 == 0) goto L_0x0101
            r0.close()     // Catch:{ Throwable -> 0x0104 }
            goto L_0x0104
        L_0x0101:
            r0.close()     // Catch:{ Throwable -> 0x0107 }
        L_0x0104:
            throw r13     // Catch:{ Throwable -> 0x0107 }
        L_0x0105:
            r13 = move-exception
            goto L_0x010a
        L_0x0107:
            r13 = move-exception
            r3 = r13
            throw r3     // Catch:{ all -> 0x0105 }
        L_0x010a:
            if (r3 == 0) goto L_0x0110
            r1.close()     // Catch:{ Throwable -> 0x0113 }
            goto L_0x0113
        L_0x0110:
            r1.close()
        L_0x0113:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.refreshLocked(com.facebook.soloader.FileLocker, int, byte[]):boolean");
    }

    /* access modifiers changed from: protected */
    public byte[] getDepsBlock() throws IOException {
        Throwable th;
        Parcel obtain = Parcel.obtain();
        Unpacker makeUnpacker = makeUnpacker();
        try {
            Dso[] dsoArr = makeUnpacker.getDsoManifest().dsos;
            obtain.writeByte((byte) 1);
            obtain.writeInt(dsoArr.length);
            for (int i = 0; i < dsoArr.length; i++) {
                obtain.writeString(dsoArr[i].name);
                obtain.writeString(dsoArr[i].hash);
            }
            if (makeUnpacker != null) {
                makeUnpacker.close();
            }
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            return marshall;
        } catch (Throwable unused) {
        }
        throw th;
    }

    /* access modifiers changed from: protected */
    public void prepare(int i) throws IOException {
        SysUtil.mkdirOrThrow(this.soDirectory);
        FileLocker lock = FileLocker.lock(new File(this.soDirectory, LOCK_FILE_NAME));
        try {
            Log.v(TAG, "locked dso store " + this.soDirectory);
            if (refreshLocked(lock, i, getDepsBlock())) {
                lock = null;
            } else {
                Log.i(TAG, "dso store is up-to-date: " + this.soDirectory);
            }
            if (lock == null) {
                Log.v(TAG, "not releasing dso store lock for " + this.soDirectory + " (syncer thread started)");
            }
        } finally {
            if (lock != null) {
                Log.v(TAG, "releasing dso store lock for " + this.soDirectory);
                lock.close();
            } else {
                Log.v(TAG, "not releasing dso store lock for " + this.soDirectory + " (syncer thread started)");
            }
        }
    }

    private Object getLibraryLock(String str) {
        Object obj;
        synchronized (this.mLibsBeingLoaded) {
            obj = this.mLibsBeingLoaded.get(str);
            if (obj == null) {
                obj = new Object();
                this.mLibsBeingLoaded.put(str, obj);
            }
        }
        return obj;
    }

    /* access modifiers changed from: protected */
    public synchronized void prepare(String str) throws IOException {
        synchronized (getLibraryLock(str)) {
            this.mCorruptedLib = str;
            prepare(2);
        }
    }

    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        int loadLibraryFrom;
        synchronized (getLibraryLock(str)) {
            loadLibraryFrom = loadLibraryFrom(str, i, this.soDirectory, threadPolicy);
        }
        return loadLibraryFrom;
    }
}

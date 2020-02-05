package io.sentry.buffer;

import io.sentry.event.Event;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiskBuffer implements Buffer {
    public static final String FILE_SUFFIX = ".sentry-event";
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) DiskBuffer.class);
    private final File bufferDir;
    private int maxEvents;

    public DiskBuffer(File file, int i) {
        this.bufferDir = file;
        this.maxEvents = i;
        String str = "Could not create or write to disk buffer dir: " + file.getAbsolutePath();
        try {
            file.mkdirs();
            if (!file.isDirectory() || !file.canWrite()) {
                throw new RuntimeException(str);
            }
            logger.debug(Integer.toString(getNumStoredEvents()) + " stored events found in dir: " + file.getAbsolutePath());
        } catch (Exception e) {
            throw new RuntimeException(str, e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a5, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a6, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00aa, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ab, code lost:
        r5 = r4;
        r4 = r3;
        r3 = r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void add(io.sentry.event.Event r7) {
        /*
            r6 = this;
            int r0 = r6.getNumStoredEvents()
            int r1 = r6.maxEvents
            if (r0 < r1) goto L_0x0031
            org.slf4j.Logger r0 = logger
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Not adding Event because at least "
            r1.append(r2)
            int r2 = r6.maxEvents
            java.lang.String r2 = java.lang.Integer.toString(r2)
            r1.append(r2)
            java.lang.String r2 = " events are already stored: "
            r1.append(r2)
            java.util.UUID r7 = r7.getId()
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.warn(r7)
            return
        L_0x0031:
            java.io.File r0 = new java.io.File
            java.io.File r1 = r6.bufferDir
            java.lang.String r1 = r1.getAbsolutePath()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.util.UUID r3 = r7.getId()
            java.lang.String r3 = r3.toString()
            r2.append(r3)
            java.lang.String r3 = ".sentry-event"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r1, r2)
            boolean r1 = r0.exists()
            if (r1 == 0) goto L_0x0076
            org.slf4j.Logger r7 = logger
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Not adding Event to offline storage because it already exists: "
            r1.append(r2)
            java.lang.String r0 = r0.getAbsolutePath()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r7.trace(r0)
            return
        L_0x0076:
            org.slf4j.Logger r1 = logger
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Adding Event to offline storage: "
            r2.append(r3)
            java.lang.String r3 = r0.getAbsolutePath()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.debug(r2)
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00c6 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x00c6 }
            r0 = 0
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ Throwable -> 0x00ba }
            r2.<init>(r1)     // Catch:{ Throwable -> 0x00ba }
            r2.writeObject(r7)     // Catch:{ Throwable -> 0x00a8, all -> 0x00a5 }
            r2.close()     // Catch:{ Throwable -> 0x00ba }
            r1.close()     // Catch:{ Exception -> 0x00c6 }
            goto L_0x00e1
        L_0x00a5:
            r3 = move-exception
            r4 = r0
            goto L_0x00ae
        L_0x00a8:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x00aa }
        L_0x00aa:
            r4 = move-exception
            r5 = r4
            r4 = r3
            r3 = r5
        L_0x00ae:
            if (r4 == 0) goto L_0x00b4
            r2.close()     // Catch:{ Throwable -> 0x00b7 }
            goto L_0x00b7
        L_0x00b4:
            r2.close()     // Catch:{ Throwable -> 0x00ba }
        L_0x00b7:
            throw r3     // Catch:{ Throwable -> 0x00ba }
        L_0x00b8:
            r2 = move-exception
            goto L_0x00bc
        L_0x00ba:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x00b8 }
        L_0x00bc:
            if (r0 == 0) goto L_0x00c2
            r1.close()     // Catch:{ Throwable -> 0x00c5 }
            goto L_0x00c5
        L_0x00c2:
            r1.close()     // Catch:{ Exception -> 0x00c6 }
        L_0x00c5:
            throw r2     // Catch:{ Exception -> 0x00c6 }
        L_0x00c6:
            r0 = move-exception
            org.slf4j.Logger r1 = logger
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Error writing Event to offline storage: "
            r2.append(r3)
            java.util.UUID r7 = r7.getId()
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            r1.error((java.lang.String) r7, (java.lang.Throwable) r0)
        L_0x00e1:
            org.slf4j.Logger r7 = logger
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = r6.getNumStoredEvents()
            java.lang.String r1 = java.lang.Integer.toString(r1)
            r0.append(r1)
            java.lang.String r1 = " stored events are now in dir: "
            r0.append(r1)
            java.io.File r1 = r6.bufferDir
            java.lang.String r1 = r1.getAbsolutePath()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.debug(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.buffer.DiskBuffer.add(io.sentry.event.Event):void");
    }

    public void discard(Event event) {
        File file = this.bufferDir;
        File file2 = new File(file, event.getId().toString() + FILE_SUFFIX);
        if (file2.exists()) {
            Logger logger2 = logger;
            logger2.debug("Discarding Event from offline storage: " + file2.getAbsolutePath());
            if (!file2.delete()) {
                Logger logger3 = logger;
                logger3.warn("Failed to delete Event: " + file2.getAbsolutePath());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005d, code lost:
        r4 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005e, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0062, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0063, code lost:
        r6 = r5;
        r5 = r4;
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0070, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0071, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0075, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0076, code lost:
        r6 = r4;
        r4 = r3;
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0070 A[ExcHandler: all (th java.lang.Throwable)] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007b A[SYNTHETIC, Splitter:B:41:0x007b] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007f A[SYNTHETIC, Splitter:B:43:0x007f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private io.sentry.event.Event fileToEvent(java.io.File r8) {
        /*
            r7 = this;
            java.lang.String r0 = "Failed to delete Event: "
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00bc, Exception -> 0x0083 }
            java.io.File r3 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00bc, Exception -> 0x0083 }
            java.lang.String r4 = r8.getAbsolutePath()     // Catch:{ FileNotFoundException -> 0x00bc, Exception -> 0x0083 }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x00bc, Exception -> 0x0083 }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x00bc, Exception -> 0x0083 }
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream     // Catch:{ Throwable -> 0x0073, all -> 0x0070 }
            r3.<init>(r2)     // Catch:{ Throwable -> 0x0073, all -> 0x0070 }
            java.lang.Object r4 = r3.readObject()     // Catch:{ Throwable -> 0x0060, all -> 0x005d }
            r3.close()     // Catch:{ Throwable -> 0x0073, all -> 0x0070 }
            r2.close()     // Catch:{ FileNotFoundException -> 0x00bc, Exception -> 0x0083 }
            io.sentry.event.Event r4 = (io.sentry.event.Event) r4     // Catch:{ Exception -> 0x0023 }
            return r4
        L_0x0023:
            r2 = move-exception
            org.slf4j.Logger r3 = logger
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Error casting Object to Event: "
            r4.append(r5)
            java.lang.String r5 = r8.getAbsolutePath()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.error((java.lang.String) r4, (java.lang.Throwable) r2)
            boolean r2 = r8.delete()
            if (r2 != 0) goto L_0x005c
            org.slf4j.Logger r2 = logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r8 = r8.getAbsolutePath()
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            r2.warn(r8)
        L_0x005c:
            return r1
        L_0x005d:
            r4 = move-exception
            r5 = r1
            goto L_0x0066
        L_0x0060:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0062 }
        L_0x0062:
            r5 = move-exception
            r6 = r5
            r5 = r4
            r4 = r6
        L_0x0066:
            if (r5 == 0) goto L_0x006c
            r3.close()     // Catch:{ Throwable -> 0x006f, all -> 0x0070 }
            goto L_0x006f
        L_0x006c:
            r3.close()     // Catch:{ Throwable -> 0x0073, all -> 0x0070 }
        L_0x006f:
            throw r4     // Catch:{ Throwable -> 0x0073, all -> 0x0070 }
        L_0x0070:
            r3 = move-exception
            r4 = r1
            goto L_0x0079
        L_0x0073:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0075 }
        L_0x0075:
            r4 = move-exception
            r6 = r4
            r4 = r3
            r3 = r6
        L_0x0079:
            if (r4 == 0) goto L_0x007f
            r2.close()     // Catch:{ Throwable -> 0x0082 }
            goto L_0x0082
        L_0x007f:
            r2.close()     // Catch:{ FileNotFoundException -> 0x00bc, Exception -> 0x0083 }
        L_0x0082:
            throw r3     // Catch:{ FileNotFoundException -> 0x00bc, Exception -> 0x0083 }
        L_0x0083:
            r2 = move-exception
            org.slf4j.Logger r3 = logger
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Error reading Event file: "
            r4.append(r5)
            java.lang.String r5 = r8.getAbsolutePath()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.error((java.lang.String) r4, (java.lang.Throwable) r2)
            boolean r2 = r8.delete()
            if (r2 != 0) goto L_0x00bc
            org.slf4j.Logger r2 = logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r8 = r8.getAbsolutePath()
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            r2.warn(r8)
        L_0x00bc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.buffer.DiskBuffer.fileToEvent(java.io.File):io.sentry.event.Event");
    }

    /* access modifiers changed from: private */
    public Event getNextEvent(Iterator<File> it) {
        Event fileToEvent;
        while (it.hasNext()) {
            File next = it.next();
            if (next.getAbsolutePath().endsWith(FILE_SUFFIX) && (fileToEvent = fileToEvent(next)) != null) {
                return fileToEvent;
            }
        }
        return null;
    }

    public Iterator<Event> getEvents() {
        final Iterator it = Arrays.asList(this.bufferDir.listFiles()).iterator();
        return new Iterator<Event>() {
            private Event next = DiskBuffer.this.getNextEvent(it);

            public boolean hasNext() {
                return this.next != null;
            }

            public Event next() {
                Event event = this.next;
                this.next = DiskBuffer.this.getNextEvent(it);
                return event;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private int getNumStoredEvents() {
        int i = 0;
        for (File absolutePath : this.bufferDir.listFiles()) {
            if (absolutePath.getAbsolutePath().endsWith(FILE_SUFFIX)) {
                i++;
            }
        }
        return i;
    }
}

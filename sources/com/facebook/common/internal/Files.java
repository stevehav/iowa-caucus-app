package com.facebook.common.internal;

import java.io.IOException;
import java.io.InputStream;

public class Files {
    private Files() {
    }

    static byte[] readFile(InputStream inputStream, long j) throws IOException {
        if (j > 2147483647L) {
            throw new OutOfMemoryError("file is too large to fit in a byte array: " + j + " bytes");
        } else if (j == 0) {
            return ByteStreams.toByteArray(inputStream);
        } else {
            return ByteStreams.toByteArray(inputStream, (int) j);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] toByteArray(java.io.File r4) throws java.io.IOException {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0018 }
            r1.<init>(r4)     // Catch:{ all -> 0x0018 }
            java.nio.channels.FileChannel r4 = r1.getChannel()     // Catch:{ all -> 0x0016 }
            long r2 = r4.size()     // Catch:{ all -> 0x0016 }
            byte[] r4 = readFile(r1, r2)     // Catch:{ all -> 0x0016 }
            r1.close()
            return r4
        L_0x0016:
            r4 = move-exception
            goto L_0x001a
        L_0x0018:
            r4 = move-exception
            r1 = r0
        L_0x001a:
            if (r1 == 0) goto L_0x001f
            r1.close()
        L_0x001f:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.internal.Files.toByteArray(java.io.File):byte[]");
    }
}

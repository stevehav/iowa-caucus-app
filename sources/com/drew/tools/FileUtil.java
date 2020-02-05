package com.drew.tools;

import com.drew.lang.annotations.NotNull;
import java.io.File;
import java.io.IOException;

public class FileUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0013  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void saveBytes(@com.drew.lang.annotations.NotNull java.io.File r2, @com.drew.lang.annotations.NotNull byte[] r3) throws java.io.IOException {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x0010 }
            r1.<init>(r2)     // Catch:{ all -> 0x0010 }
            r1.write(r3)     // Catch:{ all -> 0x000d }
            r1.close()
            return
        L_0x000d:
            r2 = move-exception
            r0 = r1
            goto L_0x0011
        L_0x0010:
            r2 = move-exception
        L_0x0011:
            if (r0 == 0) goto L_0x0016
            r0.close()
        L_0x0016:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.drew.tools.FileUtil.saveBytes(java.io.File, byte[]):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0026  */
    @com.drew.lang.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] readBytes(@com.drew.lang.annotations.NotNull java.io.File r5) throws java.io.IOException {
        /*
            long r0 = r5.length()
            int r1 = (int) r0
            byte[] r0 = new byte[r1]
            r2 = 0
            r3 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ all -> 0x0023 }
            r4.<init>(r5)     // Catch:{ all -> 0x0023 }
        L_0x000e:
            if (r2 == r1) goto L_0x001f
            int r5 = r1 - r2
            int r5 = r4.read(r0, r2, r5)     // Catch:{ all -> 0x001c }
            r3 = -1
            if (r5 != r3) goto L_0x001a
            goto L_0x001f
        L_0x001a:
            int r2 = r2 + r5
            goto L_0x000e
        L_0x001c:
            r5 = move-exception
            r3 = r4
            goto L_0x0024
        L_0x001f:
            r4.close()
            return r0
        L_0x0023:
            r5 = move-exception
        L_0x0024:
            if (r3 == 0) goto L_0x0029
            r3.close()
        L_0x0029:
            goto L_0x002b
        L_0x002a:
            throw r5
        L_0x002b:
            goto L_0x002a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.drew.tools.FileUtil.readBytes(java.io.File):byte[]");
    }

    @NotNull
    public static byte[] readBytes(@NotNull String str) throws IOException {
        return readBytes(new File(str));
    }
}

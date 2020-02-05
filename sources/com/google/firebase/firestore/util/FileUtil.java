package com.google.firebase.firestore.util;

import android.annotation.TargetApi;
import android.os.Build;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class FileUtil {
    public static void delete(File file) throws IOException {
        if (Build.VERSION.SDK_INT >= 26) {
            DefaultFileDeleter.delete(file);
        } else {
            LegacyFileDeleter.delete(file);
        }
    }

    @TargetApi(26)
    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    private static class DefaultFileDeleter {
        private DefaultFileDeleter() {
        }

        public static void delete(File file) throws IOException {
            try {
                Files.deleteIfExists(file.toPath());
            } catch (IOException e) {
                throw new IOException("Failed to delete file " + file + ": " + e);
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    private static class LegacyFileDeleter {
        private LegacyFileDeleter() {
        }

        public static void delete(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("Failed to delete file " + file);
            }
        }
    }
}

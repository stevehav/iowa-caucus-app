package org.reactnative.camera.utils;

import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class RNFileUtils {
    public static File ensureDirExists(File file) throws IOException {
        if (file.isDirectory() || file.mkdirs()) {
            return file;
        }
        throw new IOException("Couldn't create directory '" + file + "'");
    }

    public static String getOutputFilePath(File file, String str) throws IOException {
        ensureDirExists(file);
        String uuid = UUID.randomUUID().toString();
        return file + File.separator + uuid + str;
    }

    public static Uri uriFromFile(File file) {
        return Uri.fromFile(file);
    }
}

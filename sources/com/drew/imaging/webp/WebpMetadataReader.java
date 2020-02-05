package com.drew.imaging.webp;

import com.drew.imaging.riff.RiffProcessingException;
import com.drew.imaging.riff.RiffReader;
import com.drew.lang.StreamReader;
import com.drew.lang.annotations.NotNull;
import com.drew.metadata.Metadata;
import com.drew.metadata.file.FileSystemMetadataReader;
import com.drew.metadata.webp.WebpRiffHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class WebpMetadataReader {
    /* JADX INFO: finally extract failed */
    @NotNull
    public static Metadata readMetadata(@NotNull File file) throws IOException, RiffProcessingException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            Metadata readMetadata = readMetadata((InputStream) fileInputStream);
            fileInputStream.close();
            new FileSystemMetadataReader().read(file, readMetadata);
            return readMetadata;
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
    }

    @NotNull
    public static Metadata readMetadata(@NotNull InputStream inputStream) throws IOException, RiffProcessingException {
        Metadata metadata = new Metadata();
        new RiffReader().processRiff(new StreamReader(inputStream), new WebpRiffHandler(metadata));
        return metadata;
    }
}

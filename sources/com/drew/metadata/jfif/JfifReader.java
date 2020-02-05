package com.drew.metadata.jfif;

import com.drew.imaging.jpeg.JpegSegmentMetadataReader;
import com.drew.imaging.jpeg.JpegSegmentType;
import com.drew.lang.ByteArrayReader;
import com.drew.lang.RandomAccessReader;
import com.drew.lang.annotations.NotNull;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataReader;
import java.io.IOException;
import java.util.Collections;

public class JfifReader implements JpegSegmentMetadataReader, MetadataReader {
    public static final String PREAMBLE = "JFIF";

    @NotNull
    public Iterable<JpegSegmentType> getSegmentTypes() {
        return Collections.singletonList(JpegSegmentType.APP0);
    }

    public void readJpegSegments(@NotNull Iterable<byte[]> iterable, @NotNull Metadata metadata, @NotNull JpegSegmentType jpegSegmentType) {
        for (byte[] next : iterable) {
            if (next.length >= 4 && PREAMBLE.equals(new String(next, 0, 4))) {
                extract(new ByteArrayReader(next), metadata);
            }
        }
    }

    public void extract(@NotNull RandomAccessReader randomAccessReader, @NotNull Metadata metadata) {
        JfifDirectory jfifDirectory = new JfifDirectory();
        metadata.addDirectory(jfifDirectory);
        try {
            jfifDirectory.setInt(5, randomAccessReader.getUInt16(5));
            jfifDirectory.setInt(7, randomAccessReader.getUInt8(7));
            jfifDirectory.setInt(8, randomAccessReader.getUInt16(8));
            jfifDirectory.setInt(10, randomAccessReader.getUInt16(10));
            jfifDirectory.setInt(12, randomAccessReader.getUInt8(12));
            jfifDirectory.setInt(13, randomAccessReader.getUInt8(13));
        } catch (IOException e) {
            jfifDirectory.addError(e.getMessage());
        }
    }
}

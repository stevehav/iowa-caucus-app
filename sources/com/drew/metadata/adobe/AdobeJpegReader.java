package com.drew.metadata.adobe;

import com.drew.imaging.jpeg.JpegSegmentMetadataReader;
import com.drew.imaging.jpeg.JpegSegmentType;
import com.drew.lang.SequentialByteArrayReader;
import com.drew.lang.SequentialReader;
import com.drew.lang.annotations.NotNull;
import com.drew.metadata.Metadata;
import java.io.IOException;
import java.util.Collections;

public class AdobeJpegReader implements JpegSegmentMetadataReader {
    public static final String PREAMBLE = "Adobe";

    @NotNull
    public Iterable<JpegSegmentType> getSegmentTypes() {
        return Collections.singletonList(JpegSegmentType.APPE);
    }

    public void readJpegSegments(@NotNull Iterable<byte[]> iterable, @NotNull Metadata metadata, @NotNull JpegSegmentType jpegSegmentType) {
        for (byte[] next : iterable) {
            if (next.length == 12 && PREAMBLE.equalsIgnoreCase(new String(next, 0, 5))) {
                extract(new SequentialByteArrayReader(next), metadata);
            }
        }
    }

    public void extract(@NotNull SequentialReader sequentialReader, @NotNull Metadata metadata) {
        AdobeJpegDirectory adobeJpegDirectory = new AdobeJpegDirectory();
        metadata.addDirectory(adobeJpegDirectory);
        try {
            sequentialReader.setMotorolaByteOrder(false);
            if (!sequentialReader.getString(5).equals(PREAMBLE)) {
                adobeJpegDirectory.addError("Invalid Adobe JPEG data header.");
                return;
            }
            adobeJpegDirectory.setInt(0, sequentialReader.getUInt16());
            adobeJpegDirectory.setInt(1, sequentialReader.getUInt16());
            adobeJpegDirectory.setInt(2, sequentialReader.getUInt16());
            adobeJpegDirectory.setInt(3, sequentialReader.getInt8());
        } catch (IOException e) {
            adobeJpegDirectory.addError("IO exception processing data: " + e.getMessage());
        }
    }
}

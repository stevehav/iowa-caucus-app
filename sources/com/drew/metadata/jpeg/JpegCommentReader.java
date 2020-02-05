package com.drew.metadata.jpeg;

import com.drew.imaging.jpeg.JpegSegmentMetadataReader;
import com.drew.imaging.jpeg.JpegSegmentType;
import com.drew.lang.annotations.NotNull;
import com.drew.metadata.Metadata;
import com.drew.metadata.StringValue;
import java.nio.charset.Charset;
import java.util.Collections;

public class JpegCommentReader implements JpegSegmentMetadataReader {
    @NotNull
    public Iterable<JpegSegmentType> getSegmentTypes() {
        return Collections.singletonList(JpegSegmentType.COM);
    }

    public void readJpegSegments(@NotNull Iterable<byte[]> iterable, @NotNull Metadata metadata, @NotNull JpegSegmentType jpegSegmentType) {
        for (byte[] stringValue : iterable) {
            JpegCommentDirectory jpegCommentDirectory = new JpegCommentDirectory();
            metadata.addDirectory(jpegCommentDirectory);
            jpegCommentDirectory.setStringValue(0, new StringValue(stringValue, (Charset) null));
        }
    }
}

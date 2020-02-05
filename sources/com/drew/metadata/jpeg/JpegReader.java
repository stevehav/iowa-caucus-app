package com.drew.metadata.jpeg;

import com.drew.imaging.jpeg.JpegSegmentMetadataReader;
import com.drew.imaging.jpeg.JpegSegmentType;
import com.drew.lang.SequentialByteArrayReader;
import com.drew.lang.annotations.NotNull;
import com.drew.metadata.Metadata;
import java.io.IOException;
import java.util.Arrays;

public class JpegReader implements JpegSegmentMetadataReader {
    @NotNull
    public Iterable<JpegSegmentType> getSegmentTypes() {
        return Arrays.asList(new JpegSegmentType[]{JpegSegmentType.SOF0, JpegSegmentType.SOF1, JpegSegmentType.SOF2, JpegSegmentType.SOF3, JpegSegmentType.SOF5, JpegSegmentType.SOF6, JpegSegmentType.SOF7, JpegSegmentType.SOF9, JpegSegmentType.SOF10, JpegSegmentType.SOF11, JpegSegmentType.SOF13, JpegSegmentType.SOF14, JpegSegmentType.SOF15});
    }

    public void readJpegSegments(@NotNull Iterable<byte[]> iterable, @NotNull Metadata metadata, @NotNull JpegSegmentType jpegSegmentType) {
        for (byte[] extract : iterable) {
            extract(extract, metadata, jpegSegmentType);
        }
    }

    public void extract(byte[] bArr, Metadata metadata, JpegSegmentType jpegSegmentType) {
        JpegDirectory jpegDirectory = new JpegDirectory();
        metadata.addDirectory(jpegDirectory);
        jpegDirectory.setInt(-3, jpegSegmentType.byteValue - JpegSegmentType.SOF0.byteValue);
        SequentialByteArrayReader sequentialByteArrayReader = new SequentialByteArrayReader(bArr);
        try {
            jpegDirectory.setInt(0, sequentialByteArrayReader.getUInt8());
            jpegDirectory.setInt(1, sequentialByteArrayReader.getUInt16());
            jpegDirectory.setInt(3, sequentialByteArrayReader.getUInt16());
            short uInt8 = sequentialByteArrayReader.getUInt8();
            jpegDirectory.setInt(5, uInt8);
            for (int i = 0; i < uInt8; i++) {
                jpegDirectory.setObject(i + 6, new JpegComponent(sequentialByteArrayReader.getUInt8(), sequentialByteArrayReader.getUInt8(), sequentialByteArrayReader.getUInt8()));
            }
        } catch (IOException e) {
            jpegDirectory.addError(e.getMessage());
        }
    }
}

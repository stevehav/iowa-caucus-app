package com.drew.metadata.jpeg;

import com.drew.imaging.jpeg.JpegSegmentMetadataReader;
import com.drew.imaging.jpeg.JpegSegmentType;
import com.drew.lang.SequentialByteArrayReader;
import com.drew.lang.SequentialReader;
import com.drew.lang.annotations.NotNull;
import com.drew.metadata.Metadata;
import com.drew.metadata.jpeg.HuffmanTablesDirectory;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.util.Collections;

public class JpegDhtReader implements JpegSegmentMetadataReader {
    @NotNull
    public Iterable<JpegSegmentType> getSegmentTypes() {
        return Collections.singletonList(JpegSegmentType.DHT);
    }

    public void readJpegSegments(@NotNull Iterable<byte[]> iterable, @NotNull Metadata metadata, @NotNull JpegSegmentType jpegSegmentType) {
        for (byte[] sequentialByteArrayReader : iterable) {
            extract(new SequentialByteArrayReader(sequentialByteArrayReader), metadata);
        }
    }

    public void extract(@NotNull SequentialReader sequentialReader, @NotNull Metadata metadata) {
        HuffmanTablesDirectory huffmanTablesDirectory = (HuffmanTablesDirectory) metadata.getFirstDirectoryOfType(HuffmanTablesDirectory.class);
        if (huffmanTablesDirectory == null) {
            huffmanTablesDirectory = new HuffmanTablesDirectory();
            metadata.addDirectory(huffmanTablesDirectory);
        }
        while (sequentialReader.available() > 0) {
            try {
                byte b = sequentialReader.getByte();
                HuffmanTablesDirectory.HuffmanTable.HuffmanTableClass typeOf = HuffmanTablesDirectory.HuffmanTable.HuffmanTableClass.typeOf((b & 240) >> 4);
                byte b2 = b & Ascii.SI;
                byte[] bytes = getBytes(sequentialReader, 16);
                int i = 0;
                for (byte b3 : bytes) {
                    i += b3 & UnsignedBytes.MAX_VALUE;
                }
                huffmanTablesDirectory.getTables().add(new HuffmanTablesDirectory.HuffmanTable(typeOf, b2, bytes, getBytes(sequentialReader, i)));
            } catch (IOException e) {
                huffmanTablesDirectory.addError(e.getMessage());
            }
        }
        huffmanTablesDirectory.setInt(1, huffmanTablesDirectory.getTables().size());
    }

    private byte[] getBytes(@NotNull SequentialReader sequentialReader, int i) throws IOException {
        byte b;
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            byte b2 = sequentialReader.getByte();
            if ((b2 & UnsignedBytes.MAX_VALUE) != 255 || (b = sequentialReader.getByte()) == 0) {
                bArr[i2] = b2;
                i2++;
            } else {
                throw new IOException("Marker " + JpegSegmentType.fromByte(b) + " found inside DHT segment");
            }
        }
        return bArr;
    }
}

package com.drew.metadata.photoshop;

import com.drew.imaging.ImageProcessingException;
import com.drew.imaging.jpeg.JpegSegmentMetadataReader;
import com.drew.imaging.jpeg.JpegSegmentType;
import com.drew.lang.ByteArrayReader;
import com.drew.lang.SequentialByteArrayReader;
import com.drew.lang.SequentialReader;
import com.drew.lang.annotations.NotNull;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifReader;
import com.drew.metadata.icc.IccReader;
import com.drew.metadata.iptc.IptcReader;
import com.drew.metadata.xmp.XmpReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class PhotoshopReader implements JpegSegmentMetadataReader {
    @NotNull
    private static final String JPEG_SEGMENT_PREAMBLE = "Photoshop 3.0";

    @NotNull
    public Iterable<JpegSegmentType> getSegmentTypes() {
        return Collections.singletonList(JpegSegmentType.APPD);
    }

    public void readJpegSegments(@NotNull Iterable<byte[]> iterable, @NotNull Metadata metadata, @NotNull JpegSegmentType jpegSegmentType) {
        for (byte[] next : iterable) {
            if (next.length >= 14 && JPEG_SEGMENT_PREAMBLE.equals(new String(next, 0, 13))) {
                extract(new SequentialByteArrayReader(next, 14), (next.length - 13) - 1, metadata);
            }
        }
    }

    public void extract(@NotNull SequentialReader sequentialReader, int i, @NotNull Metadata metadata) {
        int i2;
        SequentialReader sequentialReader2 = sequentialReader;
        int i3 = i;
        Metadata metadata2 = metadata;
        PhotoshopDirectory photoshopDirectory = new PhotoshopDirectory();
        metadata2.addDirectory(photoshopDirectory);
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            try {
                String string = sequentialReader2.getString(4);
                int uInt16 = sequentialReader.getUInt16();
                short uInt8 = sequentialReader.getUInt8();
                int i6 = i4 + 4 + 2 + 1;
                if (uInt8 < 0 || (i2 = uInt8 + i6) > i3) {
                    throw new ImageProcessingException("Invalid string length");
                }
                StringBuilder sb = new StringBuilder();
                short s = (short) i2;
                while (i6 < s) {
                    sb.append((char) sequentialReader.getUInt8());
                    i6++;
                }
                if (i6 % 2 != 0) {
                    sequentialReader2.skip(1);
                    i6++;
                }
                int int32 = sequentialReader.getInt32();
                byte[] bytes = sequentialReader2.getBytes(int32);
                int i7 = i6 + 4 + int32;
                if (i7 % 2 != 0) {
                    sequentialReader2.skip(1);
                    i7++;
                }
                int i8 = i7;
                if (string.equals("8BIM")) {
                    if (uInt16 == 1028) {
                        new IptcReader().extract(new SequentialByteArrayReader(bytes), metadata, (long) bytes.length, photoshopDirectory);
                    } else if (uInt16 == 1039) {
                        new IccReader().extract(new ByteArrayReader(bytes), metadata2, photoshopDirectory);
                    } else {
                        if (uInt16 != 1058) {
                            if (uInt16 != 1059) {
                                if (uInt16 == 1060) {
                                    new XmpReader().extract(bytes, metadata2, (Directory) photoshopDirectory);
                                } else if (uInt16 < 2000 || uInt16 > 2998) {
                                    photoshopDirectory.setByteArray(uInt16, bytes);
                                } else {
                                    i5++;
                                    byte[] copyOf = Arrays.copyOf(bytes, bytes.length + sb.length() + 1);
                                    for (int length = (copyOf.length - sb.length()) - 1; length < copyOf.length; length++) {
                                        if (length % (((copyOf.length - sb.length()) - 1) + sb.length()) == 0) {
                                            copyOf[length] = (byte) sb.length();
                                        } else {
                                            copyOf[length] = (byte) sb.charAt(length - ((copyOf.length - sb.length()) - 1));
                                        }
                                    }
                                    HashMap<Integer, String> hashMap = PhotoshopDirectory._tagNameMap;
                                    int i9 = i5 + 1999;
                                    Integer valueOf = Integer.valueOf(i9);
                                    hashMap.put(valueOf, "Path Info " + i5);
                                    photoshopDirectory.setByteArray(i9, copyOf);
                                }
                            }
                        }
                        new ExifReader().extract(new ByteArrayReader(bytes), metadata2, 0, photoshopDirectory);
                    }
                    if (uInt16 >= 4000 && uInt16 <= 4999) {
                        PhotoshopDirectory._tagNameMap.put(Integer.valueOf(uInt16), String.format("Plug-in %d Data", new Object[]{Integer.valueOf((uInt16 - 4000) + 1)}));
                    }
                }
                i4 = i8;
            } catch (Exception e) {
                photoshopDirectory.addError(e.getMessage());
                return;
            }
        }
    }
}

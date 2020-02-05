package com.drew.imaging.jpeg;

import com.drew.lang.SequentialReader;
import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import java.io.IOException;
import java.util.HashSet;

public class JpegSegmentReader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final byte MARKER_EOI = -39;
    private static final byte SEGMENT_IDENTIFIER = -1;
    private static final byte SEGMENT_SOS = -38;

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0019  */
    @com.drew.lang.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.drew.imaging.jpeg.JpegSegmentData readSegments(@com.drew.lang.annotations.NotNull java.io.File r2, @com.drew.lang.annotations.Nullable java.lang.Iterable<com.drew.imaging.jpeg.JpegSegmentType> r3) throws com.drew.imaging.jpeg.JpegProcessingException, java.io.IOException {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0015 }
            r1.<init>(r2)     // Catch:{ all -> 0x0015 }
            com.drew.lang.StreamReader r2 = new com.drew.lang.StreamReader     // Catch:{ all -> 0x0013 }
            r2.<init>(r1)     // Catch:{ all -> 0x0013 }
            com.drew.imaging.jpeg.JpegSegmentData r2 = readSegments((com.drew.lang.SequentialReader) r2, (java.lang.Iterable<com.drew.imaging.jpeg.JpegSegmentType>) r3)     // Catch:{ all -> 0x0013 }
            r1.close()
            return r2
        L_0x0013:
            r2 = move-exception
            goto L_0x0017
        L_0x0015:
            r2 = move-exception
            r1 = r0
        L_0x0017:
            if (r1 == 0) goto L_0x001c
            r1.close()
        L_0x001c:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.drew.imaging.jpeg.JpegSegmentReader.readSegments(java.io.File, java.lang.Iterable):com.drew.imaging.jpeg.JpegSegmentData");
    }

    @NotNull
    public static JpegSegmentData readSegments(@NotNull SequentialReader sequentialReader, @Nullable Iterable<JpegSegmentType> iterable) throws JpegProcessingException, IOException {
        int uInt16 = sequentialReader.getUInt16();
        if (uInt16 == 65496) {
            HashSet hashSet = null;
            if (iterable != null) {
                hashSet = new HashSet();
                for (JpegSegmentType jpegSegmentType : iterable) {
                    hashSet.add(Byte.valueOf(jpegSegmentType.byteValue));
                }
            }
            HashSet hashSet2 = hashSet;
            JpegSegmentData jpegSegmentData = new JpegSegmentData();
            while (true) {
                byte int8 = sequentialReader.getInt8();
                byte int82 = sequentialReader.getInt8();
                while (true) {
                    if (int8 == -1 && int82 != -1 && int82 != 0) {
                        break;
                    }
                    byte b = int82;
                    int82 = sequentialReader.getInt8();
                    int8 = b;
                }
                if (int82 == -38 || int82 == -39) {
                    return jpegSegmentData;
                }
                int uInt162 = sequentialReader.getUInt16() - 2;
                if (uInt162 < 0) {
                    throw new JpegProcessingException("JPEG segment size would be less than zero");
                } else if (hashSet2 == null || hashSet2.contains(Byte.valueOf(int82))) {
                    jpegSegmentData.addSegment(int82, sequentialReader.getBytes(uInt162));
                } else if (!sequentialReader.trySkip((long) uInt162)) {
                    return jpegSegmentData;
                }
            }
        } else {
            throw new JpegProcessingException("JPEG data is expected to begin with 0xFFD8 (ÿØ) not 0x" + Integer.toHexString(uInt16));
        }
    }

    private JpegSegmentReader() throws Exception {
        throw new Exception("Not intended for instantiation.");
    }
}

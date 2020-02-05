package com.drew.metadata.iptc;

import com.drew.imaging.jpeg.JpegSegmentMetadataReader;
import com.drew.imaging.jpeg.JpegSegmentType;
import com.drew.lang.SequentialByteArrayReader;
import com.drew.lang.SequentialReader;
import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import java.io.IOException;
import java.util.Collections;

public class IptcReader implements JpegSegmentMetadataReader {
    private static final byte IptcMarkerByte = 28;

    @NotNull
    public Iterable<JpegSegmentType> getSegmentTypes() {
        return Collections.singletonList(JpegSegmentType.APPD);
    }

    public void readJpegSegments(@NotNull Iterable<byte[]> iterable, @NotNull Metadata metadata, @NotNull JpegSegmentType jpegSegmentType) {
        for (byte[] next : iterable) {
            if (next.length != 0 && next[0] == 28) {
                extract(new SequentialByteArrayReader(next), metadata, (long) next.length);
            }
        }
    }

    public void extract(@NotNull SequentialReader sequentialReader, @NotNull Metadata metadata, long j) {
        extract(sequentialReader, metadata, j, (Directory) null);
    }

    public void extract(@NotNull SequentialReader sequentialReader, @NotNull Metadata metadata, long j, @Nullable Directory directory) {
        IptcDirectory iptcDirectory = new IptcDirectory();
        metadata.addDirectory(iptcDirectory);
        if (directory != null) {
            iptcDirectory.setParent(directory);
        }
        int i = 0;
        while (((long) i) < j) {
            try {
                short uInt8 = sequentialReader.getUInt8();
                int i2 = i + 1;
                if (uInt8 != 28) {
                    if (((long) i2) != j) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Invalid IPTC tag marker at offset ");
                        sb.append(i2 - 1);
                        sb.append(". Expected '0x");
                        sb.append(Integer.toHexString(28));
                        sb.append("' but got '0x");
                        sb.append(Integer.toHexString(uInt8));
                        sb.append("'.");
                        iptcDirectory.addError(sb.toString());
                        return;
                    }
                    return;
                } else if (((long) (i2 + 4)) > j) {
                    iptcDirectory.addError("Too few bytes remain for a valid IPTC tag");
                    return;
                } else {
                    try {
                        short uInt82 = sequentialReader.getUInt8();
                        short uInt83 = sequentialReader.getUInt8();
                        int uInt16 = sequentialReader.getUInt16();
                        if (uInt16 > 32767) {
                            uInt16 = ((uInt16 & 32767) << 16) | sequentialReader.getUInt16();
                            i2 += 2;
                        }
                        int i3 = uInt16;
                        i = i2 + 4 + i3;
                        if (((long) i) > j) {
                            iptcDirectory.addError("Data for tag extends beyond end of IPTC segment");
                            return;
                        }
                        try {
                            processTag(sequentialReader, iptcDirectory, uInt82, uInt83, i3);
                        } catch (IOException unused) {
                            iptcDirectory.addError("Error processing IPTC tag");
                            return;
                        }
                    } catch (IOException unused2) {
                        iptcDirectory.addError("IPTC data segment ended mid-way through tag descriptor");
                        return;
                    }
                }
            } catch (IOException unused3) {
                iptcDirectory.addError("Unable to read starting byte of IPTC tag");
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
        if (r6 != 582) goto L_0x0059;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void processTag(@com.drew.lang.annotations.NotNull com.drew.lang.SequentialReader r4, @com.drew.lang.annotations.NotNull com.drew.metadata.Directory r5, int r6, int r7, int r8) throws java.io.IOException {
        /*
            r3 = this;
            int r6 = r6 << 8
            r6 = r6 | r7
            if (r8 != 0) goto L_0x000b
            java.lang.String r4 = ""
            r5.setString(r6, r4)
            return
        L_0x000b:
            r7 = 256(0x100, float:3.59E-43)
            r0 = 346(0x15a, float:4.85E-43)
            r1 = 1
            if (r6 == r7) goto L_0x0049
            r7 = 278(0x116, float:3.9E-43)
            if (r6 == r7) goto L_0x0049
            if (r6 == r0) goto L_0x0036
            r7 = 378(0x17a, float:5.3E-43)
            if (r6 == r7) goto L_0x0049
            r7 = 512(0x200, float:7.175E-43)
            if (r6 == r7) goto L_0x0049
            r7 = 522(0x20a, float:7.31E-43)
            if (r6 == r7) goto L_0x0029
            r7 = 582(0x246, float:8.16E-43)
            if (r6 == r7) goto L_0x0049
            goto L_0x0059
        L_0x0029:
            short r7 = r4.getUInt8()
            r5.setInt(r6, r7)
            int r8 = r8 - r1
            long r5 = (long) r8
            r4.skip(r5)
            return
        L_0x0036:
            byte[] r4 = r4.getBytes(r8)
            java.lang.String r7 = com.drew.metadata.iptc.Iso2022Converter.convertISO2022CharsetToJavaCharset(r4)
            if (r7 != 0) goto L_0x0045
            java.lang.String r7 = new java.lang.String
            r7.<init>(r4)
        L_0x0045:
            r5.setString(r6, r7)
            return
        L_0x0049:
            r7 = 2
            if (r8 < r7) goto L_0x0059
            int r0 = r4.getUInt16()
            int r8 = r8 - r7
            long r7 = (long) r8
            r4.skip(r7)
            r5.setInt(r6, r0)
            return
        L_0x0059:
            java.lang.String r7 = r5.getString(r0)
            r0 = 0
            if (r7 == 0) goto L_0x0065
            java.nio.charset.Charset r2 = java.nio.charset.Charset.forName(r7)     // Catch:{ Throwable -> 0x0065 }
            goto L_0x0066
        L_0x0065:
            r2 = r0
        L_0x0066:
            if (r7 == 0) goto L_0x006d
            com.drew.metadata.StringValue r4 = r4.getStringValue(r8, r2)
            goto L_0x0084
        L_0x006d:
            byte[] r4 = r4.getBytes(r8)
            java.nio.charset.Charset r7 = com.drew.metadata.iptc.Iso2022Converter.guessCharSet(r4)
            if (r7 == 0) goto L_0x007e
            com.drew.metadata.StringValue r8 = new com.drew.metadata.StringValue
            r8.<init>(r4, r7)
            r4 = r8
            goto L_0x0084
        L_0x007e:
            com.drew.metadata.StringValue r7 = new com.drew.metadata.StringValue
            r7.<init>(r4, r0)
            r4 = r7
        L_0x0084:
            boolean r7 = r5.containsTag(r6)
            if (r7 == 0) goto L_0x00a5
            com.drew.metadata.StringValue[] r7 = r5.getStringValueArray(r6)
            if (r7 != 0) goto L_0x0093
            com.drew.metadata.StringValue[] r7 = new com.drew.metadata.StringValue[r1]
            goto L_0x009d
        L_0x0093:
            int r8 = r7.length
            int r8 = r8 + r1
            com.drew.metadata.StringValue[] r8 = new com.drew.metadata.StringValue[r8]
            int r0 = r7.length
            r2 = 0
            java.lang.System.arraycopy(r7, r2, r8, r2, r0)
            r7 = r8
        L_0x009d:
            int r8 = r7.length
            int r8 = r8 - r1
            r7[r8] = r4
            r5.setStringValueArray(r6, r7)
            goto L_0x00a8
        L_0x00a5:
            r5.setStringValue(r6, r4)
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.drew.metadata.iptc.IptcReader.processTag(com.drew.lang.SequentialReader, com.drew.metadata.Directory, int, int, int):void");
    }
}

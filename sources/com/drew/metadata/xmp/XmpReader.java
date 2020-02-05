package com.drew.metadata.xmp;

import com.adobe.xmp.XMPException;
import com.adobe.xmp.XMPIterator;
import com.adobe.xmp.XMPMetaFactory;
import com.adobe.xmp.options.IteratorOptions;
import com.adobe.xmp.properties.XMPPropertyInfo;
import com.drew.imaging.jpeg.JpegSegmentMetadataReader;
import com.drew.imaging.jpeg.JpegSegmentType;
import com.drew.lang.SequentialByteArrayReader;
import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.StringValue;
import java.io.IOException;
import java.util.Collections;

public class XmpReader implements JpegSegmentMetadataReader {
    @NotNull
    private static final String ATTRIBUTE_EXTENDED_XMP = "xmpNote:HasExtendedXMP";
    private static final int EXTENDED_XMP_GUID_LENGTH = 32;
    private static final int EXTENDED_XMP_INT_LENGTH = 4;
    @NotNull
    private static final String SCHEMA_XMP_NOTES = "http://ns.adobe.com/xmp/note/";
    @NotNull
    private static final String XMP_EXTENSION_JPEG_PREAMBLE = "http://ns.adobe.com/xmp/extension/\u0000";
    @NotNull
    private static final String XMP_JPEG_PREAMBLE = "http://ns.adobe.com/xap/1.0/\u0000";

    @NotNull
    public Iterable<JpegSegmentType> getSegmentTypes() {
        return Collections.singletonList(JpegSegmentType.APP1);
    }

    public void readJpegSegments(@NotNull Iterable<byte[]> iterable, @NotNull Metadata metadata, @NotNull JpegSegmentType jpegSegmentType) {
        byte[] bArr = null;
        String str = null;
        for (byte[] next : iterable) {
            if (next.length >= 29 && (XMP_JPEG_PREAMBLE.equalsIgnoreCase(new String(next, 0, 29)) || "XMP".equalsIgnoreCase(new String(next, 0, 3)))) {
                byte[] bArr2 = new byte[(next.length - 29)];
                System.arraycopy(next, 29, bArr2, 0, bArr2.length);
                extract(bArr2, metadata);
                str = getExtendedXMPGUID(metadata);
            } else if (str != null && next.length >= 35 && XMP_EXTENSION_JPEG_PREAMBLE.equalsIgnoreCase(new String(next, 0, 35))) {
                bArr = processExtendedXMPChunk(metadata, next, str, bArr);
            }
        }
        if (bArr != null) {
            extract(bArr, metadata);
        }
    }

    public void extract(@NotNull byte[] bArr, @NotNull Metadata metadata) {
        extract(bArr, metadata, (Directory) null);
    }

    public void extract(@NotNull byte[] bArr, @NotNull Metadata metadata, @Nullable Directory directory) {
        extract(bArr, 0, bArr.length, metadata, directory);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void extract(@com.drew.lang.annotations.NotNull byte[] r2, int r3, int r4, @com.drew.lang.annotations.NotNull com.drew.metadata.Metadata r5, @com.drew.lang.annotations.Nullable com.drew.metadata.Directory r6) {
        /*
            r1 = this;
            com.drew.metadata.xmp.XmpDirectory r0 = new com.drew.metadata.xmp.XmpDirectory
            r0.<init>()
            if (r6 == 0) goto L_0x000a
            r0.setParent(r6)
        L_0x000a:
            if (r3 != 0) goto L_0x0014
            int r6 = r2.length     // Catch:{ XMPException -> 0x0025 }
            if (r4 != r6) goto L_0x0014
            com.adobe.xmp.XMPMeta r2 = com.adobe.xmp.XMPMetaFactory.parseFromBuffer(r2)     // Catch:{ XMPException -> 0x0025 }
            goto L_0x0021
        L_0x0014:
            com.adobe.xmp.impl.ByteBuffer r6 = new com.adobe.xmp.impl.ByteBuffer     // Catch:{ XMPException -> 0x0025 }
            r6.<init>(r2, r3, r4)     // Catch:{ XMPException -> 0x0025 }
            java.io.InputStream r2 = r6.getByteStream()     // Catch:{ XMPException -> 0x0025 }
            com.adobe.xmp.XMPMeta r2 = com.adobe.xmp.XMPMetaFactory.parse(r2)     // Catch:{ XMPException -> 0x0025 }
        L_0x0021:
            r0.setXMPMeta(r2)     // Catch:{ XMPException -> 0x0025 }
            goto L_0x003e
        L_0x0025:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Error processing XMP data: "
            r3.append(r4)
            java.lang.String r2 = r2.getMessage()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r0.addError(r2)
        L_0x003e:
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x0047
            r5.addDirectory(r0)
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.drew.metadata.xmp.XmpReader.extract(byte[], int, int, com.drew.metadata.Metadata, com.drew.metadata.Directory):void");
    }

    public void extract(@NotNull String str, @NotNull Metadata metadata) {
        extract(str, metadata, (Directory) null);
    }

    public void extract(@NotNull StringValue stringValue, @NotNull Metadata metadata) {
        extract(stringValue.getBytes(), metadata, (Directory) null);
    }

    public void extract(@NotNull String str, @NotNull Metadata metadata, @Nullable Directory directory) {
        XmpDirectory xmpDirectory = new XmpDirectory();
        if (directory != null) {
            xmpDirectory.setParent(directory);
        }
        try {
            xmpDirectory.setXMPMeta(XMPMetaFactory.parseFromString(str));
        } catch (XMPException e) {
            xmpDirectory.addError("Error processing XMP data: " + e.getMessage());
        }
        if (!xmpDirectory.isEmpty()) {
            metadata.addDirectory(xmpDirectory);
        }
    }

    @Nullable
    private static String getExtendedXMPGUID(@NotNull Metadata metadata) {
        for (XmpDirectory xMPMeta : metadata.getDirectoriesOfType(XmpDirectory.class)) {
            try {
                XMPIterator it = xMPMeta.getXMPMeta().iterator("http://ns.adobe.com/xmp/note/", (String) null, (IteratorOptions) null);
                if (it != null) {
                    while (it.hasNext()) {
                        XMPPropertyInfo xMPPropertyInfo = (XMPPropertyInfo) it.next();
                        if (ATTRIBUTE_EXTENDED_XMP.equals(xMPPropertyInfo.getPath())) {
                            return xMPPropertyInfo.getValue();
                        }
                    }
                    continue;
                }
            } catch (XMPException unused) {
            }
        }
        return null;
    }

    @Nullable
    private static byte[] processExtendedXMPChunk(@NotNull Metadata metadata, @NotNull byte[] bArr, @NotNull String str, @Nullable byte[] bArr2) {
        int length = bArr.length;
        if (length >= 75) {
            try {
                SequentialByteArrayReader sequentialByteArrayReader = new SequentialByteArrayReader(bArr);
                sequentialByteArrayReader.skip((long) 35);
                if (str.equals(sequentialByteArrayReader.getString(32))) {
                    int uInt32 = (int) sequentialByteArrayReader.getUInt32();
                    int uInt322 = (int) sequentialByteArrayReader.getUInt32();
                    if (bArr2 == null) {
                        bArr2 = new byte[uInt32];
                    }
                    if (bArr2.length == uInt32) {
                        System.arraycopy(bArr, 75, bArr2, uInt322, length - 75);
                    } else {
                        XmpDirectory xmpDirectory = new XmpDirectory();
                        xmpDirectory.addError(String.format("Inconsistent length for the Extended XMP buffer: %d instead of %d", new Object[]{Integer.valueOf(uInt32), Integer.valueOf(bArr2.length)}));
                        metadata.addDirectory(xmpDirectory);
                    }
                }
            } catch (IOException e) {
                XmpDirectory xmpDirectory2 = new XmpDirectory();
                xmpDirectory2.addError(e.getMessage());
                metadata.addDirectory(xmpDirectory2);
            }
        }
        return bArr2;
    }
}

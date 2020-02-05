package com.drew.metadata.gif;

import com.drew.lang.ByteArrayReader;
import com.drew.lang.Charsets;
import com.drew.lang.SequentialReader;
import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.Directory;
import com.drew.metadata.ErrorDirectory;
import com.drew.metadata.Metadata;
import com.drew.metadata.StringValue;
import com.drew.metadata.gif.GifControlDirectory;
import com.drew.metadata.icc.IccReader;
import com.drew.metadata.xmp.XmpReader;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class GifReader {
    private static final String GIF_87A_VERSION_IDENTIFIER = "87a";
    private static final String GIF_89A_VERSION_IDENTIFIER = "89a";

    /* JADX WARNING: Can't wrap try/catch for region: R(2:11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r6.addDirectory(new com.drew.metadata.ErrorDirectory("GIF did not had hasGlobalColorTable bit."));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0063, code lost:
        r6.addDirectory(new com.drew.metadata.ErrorDirectory("IOException processing GIF data"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006b, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0022 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void extract(@com.drew.lang.annotations.NotNull com.drew.lang.SequentialReader r5, @com.drew.lang.annotations.NotNull com.drew.metadata.Metadata r6) {
        /*
            r4 = this;
            java.lang.String r0 = "IOException processing GIF data"
            r1 = 0
            r5.setMotorolaByteOrder(r1)
            com.drew.metadata.gif.GifHeaderDirectory r1 = readGifHeader(r5)     // Catch:{ IOException -> 0x006c }
            r6.addDirectory(r1)     // Catch:{ IOException -> 0x006c }
            boolean r2 = r1.hasErrors()
            if (r2 == 0) goto L_0x0014
            return
        L_0x0014:
            r2 = 0
            r3 = 7
            boolean r3 = r1.getBoolean(r3)     // Catch:{ MetadataException -> 0x0022 }
            if (r3 == 0) goto L_0x002c
            r3 = 4
            java.lang.Integer r2 = r1.getInteger(r3)     // Catch:{ MetadataException -> 0x0022 }
            goto L_0x002c
        L_0x0022:
            com.drew.metadata.ErrorDirectory r1 = new com.drew.metadata.ErrorDirectory     // Catch:{ IOException -> 0x0063 }
            java.lang.String r3 = "GIF did not had hasGlobalColorTable bit."
            r1.<init>(r3)     // Catch:{ IOException -> 0x0063 }
            r6.addDirectory(r1)     // Catch:{ IOException -> 0x0063 }
        L_0x002c:
            if (r2 == 0) goto L_0x0038
            int r1 = r2.intValue()     // Catch:{ IOException -> 0x0063 }
            int r1 = r1 * 3
            long r1 = (long) r1     // Catch:{ IOException -> 0x0063 }
            r5.skip(r1)     // Catch:{ IOException -> 0x0063 }
        L_0x0038:
            byte r1 = r5.getInt8()     // Catch:{ IOException -> 0x0062 }
            r2 = 33
            if (r1 == r2) goto L_0x005e
            r2 = 44
            if (r1 == r2) goto L_0x0053
            r5 = 59
            if (r1 == r5) goto L_0x0052
            com.drew.metadata.ErrorDirectory r5 = new com.drew.metadata.ErrorDirectory     // Catch:{ IOException -> 0x0063 }
            java.lang.String r1 = "Unknown gif block marker found."
            r5.<init>(r1)     // Catch:{ IOException -> 0x0063 }
            r6.addDirectory(r5)     // Catch:{ IOException -> 0x0063 }
        L_0x0052:
            return
        L_0x0053:
            com.drew.metadata.gif.GifImageDirectory r1 = readImageBlock(r5)     // Catch:{ IOException -> 0x0063 }
            r6.addDirectory(r1)     // Catch:{ IOException -> 0x0063 }
            skipBlocks(r5)     // Catch:{ IOException -> 0x0063 }
            goto L_0x0038
        L_0x005e:
            readGifExtensionBlock(r5, r6)     // Catch:{ IOException -> 0x0063 }
            goto L_0x0038
        L_0x0062:
            return
        L_0x0063:
            com.drew.metadata.ErrorDirectory r5 = new com.drew.metadata.ErrorDirectory
            r5.<init>(r0)
            r6.addDirectory(r5)
            return
        L_0x006c:
            com.drew.metadata.ErrorDirectory r5 = new com.drew.metadata.ErrorDirectory
            r5.<init>(r0)
            r6.addDirectory(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.drew.metadata.gif.GifReader.extract(com.drew.lang.SequentialReader, com.drew.metadata.Metadata):void");
    }

    private static GifHeaderDirectory readGifHeader(@NotNull SequentialReader sequentialReader) throws IOException {
        GifHeaderDirectory gifHeaderDirectory = new GifHeaderDirectory();
        if (!sequentialReader.getString(3).equals("GIF")) {
            gifHeaderDirectory.addError("Invalid GIF file signature");
            return gifHeaderDirectory;
        }
        String string = sequentialReader.getString(3);
        if (string.equals(GIF_87A_VERSION_IDENTIFIER) || string.equals(GIF_89A_VERSION_IDENTIFIER)) {
            boolean z = true;
            gifHeaderDirectory.setString(1, string);
            gifHeaderDirectory.setInt(2, sequentialReader.getUInt16());
            gifHeaderDirectory.setInt(3, sequentialReader.getUInt16());
            short uInt8 = sequentialReader.getUInt8();
            int i = 1 << ((uInt8 & 7) + 1);
            int i2 = ((uInt8 & 112) >> 4) + 1;
            boolean z2 = (uInt8 >> 7) != 0;
            gifHeaderDirectory.setInt(4, i);
            if (string.equals(GIF_89A_VERSION_IDENTIFIER)) {
                if ((uInt8 & 8) == 0) {
                    z = false;
                }
                gifHeaderDirectory.setBoolean(5, z);
            }
            gifHeaderDirectory.setInt(6, i2);
            gifHeaderDirectory.setBoolean(7, z2);
            gifHeaderDirectory.setInt(8, sequentialReader.getUInt8());
            short uInt82 = sequentialReader.getUInt8();
            if (uInt82 != 0) {
                double d = (double) uInt82;
                Double.isNaN(d);
                gifHeaderDirectory.setFloat(9, (float) ((d + 15.0d) / 64.0d));
            }
            return gifHeaderDirectory;
        }
        gifHeaderDirectory.addError("Unexpected GIF version");
        return gifHeaderDirectory;
    }

    private static void readGifExtensionBlock(SequentialReader sequentialReader, Metadata metadata) throws IOException {
        byte int8 = sequentialReader.getInt8();
        short uInt8 = sequentialReader.getUInt8();
        long position = sequentialReader.getPosition();
        if (int8 == -7) {
            metadata.addDirectory(readControlBlock(sequentialReader, uInt8));
        } else if (int8 == 1) {
            Directory readPlainTextBlock = readPlainTextBlock(sequentialReader, uInt8);
            if (readPlainTextBlock != null) {
                metadata.addDirectory(readPlainTextBlock);
            }
        } else if (int8 == -2) {
            metadata.addDirectory(readCommentBlock(sequentialReader, uInt8));
        } else if (int8 != -1) {
            metadata.addDirectory(new ErrorDirectory(String.format("Unsupported GIF extension block with type 0x%02X.", new Object[]{Byte.valueOf(int8)})));
        } else {
            readApplicationExtensionBlock(sequentialReader, uInt8, metadata);
        }
        long position2 = (position + ((long) uInt8)) - sequentialReader.getPosition();
        if (position2 > 0) {
            sequentialReader.skip(position2);
        }
    }

    @Nullable
    private static Directory readPlainTextBlock(SequentialReader sequentialReader, int i) throws IOException {
        if (i != 12) {
            return new ErrorDirectory(String.format("Invalid GIF plain text block size. Expected 12, got %d.", new Object[]{Integer.valueOf(i)}));
        }
        sequentialReader.skip(12);
        skipBlocks(sequentialReader);
        return null;
    }

    private static GifCommentDirectory readCommentBlock(SequentialReader sequentialReader, int i) throws IOException {
        return new GifCommentDirectory(new StringValue(gatherBytes(sequentialReader, i), Charsets.ASCII));
    }

    private static void readApplicationExtensionBlock(SequentialReader sequentialReader, int i, Metadata metadata) throws IOException {
        if (i != 11) {
            metadata.addDirectory(new ErrorDirectory(String.format("Invalid GIF application extension block size. Expected 11, got %d.", new Object[]{Integer.valueOf(i)})));
            return;
        }
        String string = sequentialReader.getString(i, Charsets.UTF_8);
        if (string.equals("XMP DataXMP")) {
            byte[] gatherBytes = gatherBytes(sequentialReader);
            new XmpReader().extract(gatherBytes, 0, gatherBytes.length - 257, metadata, (Directory) null);
        } else if (string.equals("ICCRGBG1012")) {
            byte[] gatherBytes2 = gatherBytes(sequentialReader, sequentialReader.getByte() & UnsignedBytes.MAX_VALUE);
            if (gatherBytes2.length != 0) {
                new IccReader().extract(new ByteArrayReader(gatherBytes2), metadata);
            }
        } else if (string.equals("NETSCAPE2.0")) {
            sequentialReader.skip(2);
            int uInt16 = sequentialReader.getUInt16();
            sequentialReader.skip(1);
            GifAnimationDirectory gifAnimationDirectory = new GifAnimationDirectory();
            gifAnimationDirectory.setInt(1, uInt16);
            metadata.addDirectory(gifAnimationDirectory);
        } else {
            skipBlocks(sequentialReader);
        }
    }

    private static GifControlDirectory readControlBlock(SequentialReader sequentialReader, int i) throws IOException {
        GifControlDirectory gifControlDirectory = new GifControlDirectory();
        short uInt8 = sequentialReader.getUInt8();
        gifControlDirectory.setObject(2, GifControlDirectory.DisposalMethod.typeOf((uInt8 >> 2) & 7));
        boolean z = false;
        gifControlDirectory.setBoolean(3, ((uInt8 & 2) >> 1) == 1);
        if ((uInt8 & 1) == 1) {
            z = true;
        }
        gifControlDirectory.setBoolean(4, z);
        gifControlDirectory.setInt(1, sequentialReader.getUInt16());
        gifControlDirectory.setInt(5, sequentialReader.getUInt8());
        sequentialReader.skip(1);
        return gifControlDirectory;
    }

    private static GifImageDirectory readImageBlock(SequentialReader sequentialReader) throws IOException {
        GifImageDirectory gifImageDirectory = new GifImageDirectory();
        boolean z = true;
        gifImageDirectory.setInt(1, sequentialReader.getUInt16());
        gifImageDirectory.setInt(2, sequentialReader.getUInt16());
        gifImageDirectory.setInt(3, sequentialReader.getUInt16());
        gifImageDirectory.setInt(4, sequentialReader.getUInt16());
        byte b = sequentialReader.getByte();
        boolean z2 = (b >> 7) != 0;
        boolean z3 = (b & SignedBytes.MAX_POWER_OF_TWO) != 0;
        gifImageDirectory.setBoolean(5, z2);
        gifImageDirectory.setBoolean(6, z3);
        if (z2) {
            if ((b & 32) == 0) {
                z = false;
            }
            gifImageDirectory.setBoolean(7, z);
            byte b2 = b & 7;
            gifImageDirectory.setInt(8, b2 + 1);
            sequentialReader.skip((long) ((2 << b2) * 3));
        }
        sequentialReader.getByte();
        return gifImageDirectory;
    }

    private static byte[] gatherBytes(SequentialReader sequentialReader) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[257];
        while (true) {
            byte b = sequentialReader.getByte();
            if (b == 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byte b2 = b & UnsignedBytes.MAX_VALUE;
            bArr[0] = b;
            sequentialReader.getBytes(bArr, 1, b2);
            byteArrayOutputStream.write(bArr, 0, b2 + 1);
        }
    }

    private static byte[] gatherBytes(SequentialReader sequentialReader, int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (i > 0) {
            byteArrayOutputStream.write(sequentialReader.getBytes(i), 0, i);
            i = sequentialReader.getByte() & UnsignedBytes.MAX_VALUE;
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static void skipBlocks(SequentialReader sequentialReader) throws IOException {
        while (true) {
            short uInt8 = sequentialReader.getUInt8();
            if (uInt8 != 0) {
                sequentialReader.skip((long) uInt8);
            } else {
                return;
            }
        }
    }
}

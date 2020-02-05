package com.drew.metadata.eps;

import com.drew.imaging.tiff.TiffProcessingException;
import com.drew.imaging.tiff.TiffReader;
import com.drew.lang.ByteArrayReader;
import com.drew.lang.Charsets;
import com.drew.lang.RandomAccessStreamReader;
import com.drew.lang.SequentialByteArrayReader;
import com.drew.lang.SequentialReader;
import com.drew.lang.StreamReader;
import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.icc.IccReader;
import com.drew.metadata.photoshop.PhotoshopReader;
import com.drew.metadata.photoshop.PhotoshopTiffHandler;
import com.drew.metadata.xmp.XmpReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class EpsReader {
    private int _previousTag;

    private static int tryHexToInt(byte b) {
        if (b >= 48 && b <= 57) {
            return b - 48;
        }
        byte b2 = 65;
        if (b < 65 || b > 70) {
            b2 = 97;
            if (b < 97 || b > 102) {
                return -1;
            }
        }
        return (b - b2) + 10;
    }

    public void extract(@NotNull InputStream inputStream, @NotNull Metadata metadata) throws IOException {
        RandomAccessStreamReader randomAccessStreamReader = new RandomAccessStreamReader(inputStream);
        EpsDirectory epsDirectory = new EpsDirectory();
        metadata.addDirectory(epsDirectory);
        int int32 = randomAccessStreamReader.getInt32(0);
        if (int32 == -976170042) {
            randomAccessStreamReader.setMotorolaByteOrder(false);
            int int322 = randomAccessStreamReader.getInt32(4);
            int int323 = randomAccessStreamReader.getInt32(8);
            int int324 = randomAccessStreamReader.getInt32(12);
            int int325 = randomAccessStreamReader.getInt32(16);
            int int326 = randomAccessStreamReader.getInt32(20);
            int int327 = randomAccessStreamReader.getInt32(24);
            if (int327 != 0) {
                epsDirectory.setInt(32, int327);
                epsDirectory.setInt(33, int326);
                try {
                    new TiffReader().processTiff(new ByteArrayReader(randomAccessStreamReader.getBytes(int326, int327)), new PhotoshopTiffHandler(metadata, (Directory) null), 0);
                } catch (TiffProcessingException e) {
                    epsDirectory.addError("Unable to process TIFF data: " + e.getMessage());
                }
            } else if (int325 != 0) {
                epsDirectory.setInt(34, int325);
                epsDirectory.setInt(35, int324);
            }
            extract(epsDirectory, metadata, new SequentialByteArrayReader(randomAccessStreamReader.getBytes(int322, int323)));
        } else if (int32 != 622940243) {
            epsDirectory.addError("File type not supported.");
        } else {
            inputStream.reset();
            extract(epsDirectory, metadata, new StreamReader(inputStream));
        }
    }

    private void extract(@NotNull EpsDirectory epsDirectory, @NotNull Metadata metadata, @NotNull SequentialReader sequentialReader) throws IOException {
        String str;
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.setLength(0);
            while (true) {
                char c = (char) sequentialReader.getByte();
                if (c != 13 && c != 10) {
                    sb.append(c);
                }
            }
            if (sb.length() == 0 || sb.charAt(0) == '%') {
                int indexOf = sb.indexOf(":");
                if (indexOf != -1) {
                    str = sb.substring(0, indexOf).trim();
                    addToDirectory(epsDirectory, str, sb.substring(indexOf + 1).trim());
                } else {
                    str = sb.toString().trim();
                }
                if (str.equals("%BeginPhotoshop")) {
                    extractPhotoshopData(metadata, sequentialReader);
                } else if (str.equals("%%BeginICCProfile")) {
                    extractIccData(metadata, sequentialReader);
                } else if (str.equals("%begin_xml_packet")) {
                    extractXmpData(metadata, sequentialReader);
                }
            } else {
                return;
            }
        }
    }

    private void addToDirectory(@NotNull EpsDirectory epsDirectory, String str, String str2) throws IOException {
        Integer num = EpsDirectory._tagIntegerMap.get(str);
        if (num != null) {
            int intValue = num.intValue();
            if (intValue == 8) {
                extractImageData(epsDirectory, str2);
            } else if (intValue == 36) {
                int i = this._previousTag;
                epsDirectory.setString(i, epsDirectory.getString(this._previousTag) + " " + str2);
            } else if (!EpsDirectory._tagNameMap.containsKey(num) || epsDirectory.containsTag(num.intValue())) {
                this._previousTag = 0;
            } else {
                epsDirectory.setString(num.intValue(), str2);
                this._previousTag = num.intValue();
            }
            this._previousTag = num.intValue();
        }
    }

    private static void extractImageData(@NotNull EpsDirectory epsDirectory, String str) throws IOException {
        epsDirectory.setString(8, str.trim());
        String[] split = str.split(" ");
        int parseInt = Integer.parseInt(split[0]);
        int parseInt2 = Integer.parseInt(split[1]);
        int i = 3;
        int parseInt3 = Integer.parseInt(split[3]);
        if (!epsDirectory.containsTag(28)) {
            epsDirectory.setInt(28, parseInt);
        }
        if (!epsDirectory.containsTag(29)) {
            epsDirectory.setInt(29, parseInt2);
        }
        if (!epsDirectory.containsTag(30)) {
            epsDirectory.setInt(30, parseInt3);
        }
        if (!epsDirectory.containsTag(31)) {
            if (parseInt3 == 1) {
                i = 1;
            } else if (!(parseInt3 == 2 || parseInt3 == 3 || parseInt3 == 4)) {
                i = 0;
            }
            if (i != 0) {
                epsDirectory.setInt(31, i * parseInt * parseInt2);
            }
        }
    }

    private static void extractPhotoshopData(@NotNull Metadata metadata, @NotNull SequentialReader sequentialReader) throws IOException {
        byte[] decodeHexCommentBlock = decodeHexCommentBlock(sequentialReader);
        if (decodeHexCommentBlock != null) {
            new PhotoshopReader().extract(new SequentialByteArrayReader(decodeHexCommentBlock), decodeHexCommentBlock.length, metadata);
        }
    }

    private static void extractIccData(@NotNull Metadata metadata, @NotNull SequentialReader sequentialReader) throws IOException {
        byte[] decodeHexCommentBlock = decodeHexCommentBlock(sequentialReader);
        if (decodeHexCommentBlock != null) {
            new IccReader().extract(new ByteArrayReader(decodeHexCommentBlock), metadata);
        }
    }

    private static void extractXmpData(@NotNull Metadata metadata, @NotNull SequentialReader sequentialReader) throws IOException {
        new XmpReader().extract(new String(readUntil(sequentialReader, "<?xpacket end=\"w\"?>".getBytes()), Charsets.UTF_8), metadata);
    }

    private static byte[] readUntil(@NotNull SequentialReader sequentialReader, @NotNull byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int length = bArr.length;
        int i = 0;
        while (i != length) {
            byte b = sequentialReader.getByte();
            i = b == bArr[i] ? i + 1 : 0;
            byteArrayOutputStream.write(b);
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Nullable
    private static byte[] decodeHexCommentBlock(@NotNull SequentialReader sequentialReader) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean z = false;
        char c = 0;
        byte b = 0;
        int i = 0;
        while (!z) {
            b = sequentialReader.getByte();
            if (c != 0) {
                if (c != 1) {
                    if (c == 2) {
                        int tryHexToInt = tryHexToInt(b);
                        if (tryHexToInt != -1) {
                            i = tryHexToInt * 16;
                            c = 3;
                        } else if (b != 13 && b != 10) {
                            return null;
                        } else {
                            c = 0;
                        }
                    } else if (c == 3) {
                        int tryHexToInt2 = tryHexToInt(b);
                        if (tryHexToInt2 == -1) {
                            return null;
                        }
                        byteArrayOutputStream.write(tryHexToInt2 + i);
                    } else {
                        continue;
                    }
                } else if (b != 32) {
                    z = true;
                }
                c = 2;
            } else if (!(b == 10 || b == 13 || b == 32)) {
                if (b != 37) {
                    return null;
                }
                c = 1;
            }
        }
        while (b != 10) {
            b = sequentialReader.getByte();
        }
        return byteArrayOutputStream.toByteArray();
    }
}

package com.drew.imaging.png;

import com.drew.lang.ByteConvert;
import com.drew.lang.Charsets;
import com.drew.lang.DateUtil;
import com.drew.lang.KeyValuePair;
import com.drew.lang.RandomAccessStreamReader;
import com.drew.lang.SequentialByteArrayReader;
import com.drew.lang.StreamReader;
import com.drew.lang.StreamUtil;
import com.drew.lang.annotations.NotNull;
import com.drew.metadata.Metadata;
import com.drew.metadata.StringValue;
import com.drew.metadata.file.FileSystemMetadataReader;
import com.drew.metadata.icc.IccReader;
import com.drew.metadata.png.PngChromaticitiesDirectory;
import com.drew.metadata.png.PngDirectory;
import com.drew.metadata.xmp.XmpReader;
import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipException;

public class PngMetadataReader {
    private static Set<PngChunkType> _desiredChunkTypes;
    private static Charset _latin1Encoding = Charsets.ISO_8859_1;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add(PngChunkType.IHDR);
        hashSet.add(PngChunkType.PLTE);
        hashSet.add(PngChunkType.tRNS);
        hashSet.add(PngChunkType.cHRM);
        hashSet.add(PngChunkType.sRGB);
        hashSet.add(PngChunkType.gAMA);
        hashSet.add(PngChunkType.iCCP);
        hashSet.add(PngChunkType.bKGD);
        hashSet.add(PngChunkType.tEXt);
        hashSet.add(PngChunkType.zTXt);
        hashSet.add(PngChunkType.iTXt);
        hashSet.add(PngChunkType.tIME);
        hashSet.add(PngChunkType.pHYs);
        hashSet.add(PngChunkType.sBIT);
        _desiredChunkTypes = Collections.unmodifiableSet(hashSet);
    }

    /* JADX INFO: finally extract failed */
    @NotNull
    public static Metadata readMetadata(@NotNull File file) throws PngProcessingException, IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            Metadata readMetadata = readMetadata((InputStream) fileInputStream);
            fileInputStream.close();
            new FileSystemMetadataReader().read(file, readMetadata);
            return readMetadata;
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
    }

    @NotNull
    public static Metadata readMetadata(@NotNull InputStream inputStream) throws PngProcessingException, IOException {
        Iterable<PngChunk> extract = new PngChunkReader().extract(new StreamReader(inputStream), _desiredChunkTypes);
        Metadata metadata = new Metadata();
        for (PngChunk processChunk : extract) {
            try {
                processChunk(metadata, processChunk);
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
        }
        return metadata;
    }

    private static void processChunk(@NotNull Metadata metadata, @NotNull PngChunk pngChunk) throws PngProcessingException, IOException {
        byte[] bArr;
        byte[] bArr2;
        Metadata metadata2 = metadata;
        PngChunkType type = pngChunk.getType();
        byte[] bytes = pngChunk.getBytes();
        if (type.equals(PngChunkType.IHDR)) {
            PngHeader pngHeader = new PngHeader(bytes);
            PngDirectory pngDirectory = new PngDirectory(PngChunkType.IHDR);
            pngDirectory.setInt(1, pngHeader.getImageWidth());
            pngDirectory.setInt(2, pngHeader.getImageHeight());
            pngDirectory.setInt(3, pngHeader.getBitsPerSample());
            pngDirectory.setInt(4, pngHeader.getColorType().getNumericValue());
            pngDirectory.setInt(5, pngHeader.getCompressionType() & UnsignedBytes.MAX_VALUE);
            pngDirectory.setInt(6, pngHeader.getFilterMethod());
            pngDirectory.setInt(7, pngHeader.getInterlaceMethod());
            metadata2.addDirectory(pngDirectory);
        } else if (type.equals(PngChunkType.PLTE)) {
            PngDirectory pngDirectory2 = new PngDirectory(PngChunkType.PLTE);
            pngDirectory2.setInt(8, bytes.length / 3);
            metadata2.addDirectory(pngDirectory2);
        } else if (type.equals(PngChunkType.tRNS)) {
            PngDirectory pngDirectory3 = new PngDirectory(PngChunkType.tRNS);
            pngDirectory3.setInt(9, 1);
            metadata2.addDirectory(pngDirectory3);
        } else if (type.equals(PngChunkType.sRGB)) {
            byte b = bytes[0];
            PngDirectory pngDirectory4 = new PngDirectory(PngChunkType.sRGB);
            pngDirectory4.setInt(10, b);
            metadata2.addDirectory(pngDirectory4);
        } else if (type.equals(PngChunkType.cHRM)) {
            PngChromaticities pngChromaticities = new PngChromaticities(bytes);
            PngChromaticitiesDirectory pngChromaticitiesDirectory = new PngChromaticitiesDirectory();
            pngChromaticitiesDirectory.setInt(1, pngChromaticities.getWhitePointX());
            pngChromaticitiesDirectory.setInt(2, pngChromaticities.getWhitePointY());
            pngChromaticitiesDirectory.setInt(3, pngChromaticities.getRedX());
            pngChromaticitiesDirectory.setInt(4, pngChromaticities.getRedY());
            pngChromaticitiesDirectory.setInt(5, pngChromaticities.getGreenX());
            pngChromaticitiesDirectory.setInt(6, pngChromaticities.getGreenY());
            pngChromaticitiesDirectory.setInt(7, pngChromaticities.getBlueX());
            pngChromaticitiesDirectory.setInt(8, pngChromaticities.getBlueY());
            metadata2.addDirectory(pngChromaticitiesDirectory);
        } else if (type.equals(PngChunkType.gAMA)) {
            int int32BigEndian = ByteConvert.toInt32BigEndian(bytes);
            new SequentialByteArrayReader(bytes).getInt32();
            PngDirectory pngDirectory5 = new PngDirectory(PngChunkType.gAMA);
            double d = (double) int32BigEndian;
            Double.isNaN(d);
            pngDirectory5.setDouble(11, d / 100000.0d);
            metadata2.addDirectory(pngDirectory5);
        } else if (type.equals(PngChunkType.iCCP)) {
            SequentialByteArrayReader sequentialByteArrayReader = new SequentialByteArrayReader(bytes);
            byte[] nullTerminatedBytes = sequentialByteArrayReader.getNullTerminatedBytes(80);
            PngDirectory pngDirectory6 = new PngDirectory(PngChunkType.iCCP);
            pngDirectory6.setStringValue(12, new StringValue(nullTerminatedBytes, _latin1Encoding));
            if (sequentialByteArrayReader.getInt8() == 0) {
                try {
                    InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(sequentialByteArrayReader.getBytes(bytes.length - ((nullTerminatedBytes.length + 1) + 1))));
                    new IccReader().extract(new RandomAccessStreamReader(inflaterInputStream), metadata2, pngDirectory6);
                    inflaterInputStream.close();
                } catch (ZipException e) {
                    pngDirectory6.addError(String.format("Exception decompressing PNG iCCP chunk : %s", new Object[]{e.getMessage()}));
                    metadata2.addDirectory(pngDirectory6);
                }
            } else {
                pngDirectory6.addError("Invalid compression method value");
            }
            metadata2.addDirectory(pngDirectory6);
        } else if (type.equals(PngChunkType.bKGD)) {
            PngDirectory pngDirectory7 = new PngDirectory(PngChunkType.bKGD);
            pngDirectory7.setByteArray(15, bytes);
            metadata2.addDirectory(pngDirectory7);
        } else if (type.equals(PngChunkType.tEXt)) {
            SequentialByteArrayReader sequentialByteArrayReader2 = new SequentialByteArrayReader(bytes);
            StringValue nullTerminatedStringValue = sequentialByteArrayReader2.getNullTerminatedStringValue(80, _latin1Encoding);
            String stringValue = nullTerminatedStringValue.toString();
            StringValue nullTerminatedStringValue2 = sequentialByteArrayReader2.getNullTerminatedStringValue(bytes.length - (nullTerminatedStringValue.getBytes().length + 1), _latin1Encoding);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair(stringValue, nullTerminatedStringValue2));
            PngDirectory pngDirectory8 = new PngDirectory(PngChunkType.tEXt);
            pngDirectory8.setObject(13, arrayList);
            metadata2.addDirectory(pngDirectory8);
        } else if (type.equals(PngChunkType.zTXt)) {
            SequentialByteArrayReader sequentialByteArrayReader3 = new SequentialByteArrayReader(bytes);
            StringValue nullTerminatedStringValue3 = sequentialByteArrayReader3.getNullTerminatedStringValue(80, _latin1Encoding);
            String stringValue2 = nullTerminatedStringValue3.toString();
            byte int8 = sequentialByteArrayReader3.getInt8();
            int length = bytes.length - ((nullTerminatedStringValue3.getBytes().length + 1) + 1);
            if (int8 == 0) {
                try {
                    bArr2 = StreamUtil.readAllBytes(new InflaterInputStream(new ByteArrayInputStream(bytes, bytes.length - length, length)));
                } catch (ZipException e2) {
                    PngDirectory pngDirectory9 = new PngDirectory(PngChunkType.zTXt);
                    pngDirectory9.addError(String.format("Exception decompressing PNG zTXt chunk with keyword \"%s\": %s", new Object[]{stringValue2, e2.getMessage()}));
                    metadata2.addDirectory(pngDirectory9);
                }
            } else {
                PngDirectory pngDirectory10 = new PngDirectory(PngChunkType.zTXt);
                pngDirectory10.addError("Invalid compression method value");
                metadata2.addDirectory(pngDirectory10);
                bArr2 = null;
            }
            if (bArr2 == null) {
                return;
            }
            if (stringValue2.equals("XML:com.adobe.xmp")) {
                new XmpReader().extract(bArr2, metadata2);
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new KeyValuePair(stringValue2, new StringValue(bArr2, _latin1Encoding)));
            PngDirectory pngDirectory11 = new PngDirectory(PngChunkType.zTXt);
            pngDirectory11.setObject(13, arrayList2);
            metadata2.addDirectory(pngDirectory11);
        } else if (type.equals(PngChunkType.iTXt)) {
            SequentialByteArrayReader sequentialByteArrayReader4 = new SequentialByteArrayReader(bytes);
            StringValue nullTerminatedStringValue4 = sequentialByteArrayReader4.getNullTerminatedStringValue(80, _latin1Encoding);
            String stringValue3 = nullTerminatedStringValue4.toString();
            byte int82 = sequentialByteArrayReader4.getInt8();
            byte int83 = sequentialByteArrayReader4.getInt8();
            int length2 = bytes.length - (((((((nullTerminatedStringValue4.getBytes().length + 1) + 1) + 1) + sequentialByteArrayReader4.getNullTerminatedBytes(bytes.length).length) + 1) + sequentialByteArrayReader4.getNullTerminatedBytes(bytes.length).length) + 1);
            if (int82 == 0) {
                bArr = sequentialByteArrayReader4.getNullTerminatedBytes(length2);
            } else {
                if (int82 != 1) {
                    PngDirectory pngDirectory12 = new PngDirectory(PngChunkType.iTXt);
                    pngDirectory12.addError("Invalid compression flag value");
                    metadata2.addDirectory(pngDirectory12);
                } else if (int83 == 0) {
                    try {
                        bArr = StreamUtil.readAllBytes(new InflaterInputStream(new ByteArrayInputStream(bytes, bytes.length - length2, length2)));
                    } catch (ZipException e3) {
                        PngDirectory pngDirectory13 = new PngDirectory(PngChunkType.iTXt);
                        pngDirectory13.addError(String.format("Exception decompressing PNG iTXt chunk with keyword \"%s\": %s", new Object[]{stringValue3, e3.getMessage()}));
                        metadata2.addDirectory(pngDirectory13);
                    }
                } else {
                    PngDirectory pngDirectory14 = new PngDirectory(PngChunkType.iTXt);
                    pngDirectory14.addError("Invalid compression method value");
                    metadata2.addDirectory(pngDirectory14);
                }
                bArr = null;
            }
            if (bArr == null) {
                return;
            }
            if (stringValue3.equals("XML:com.adobe.xmp")) {
                new XmpReader().extract(bArr, metadata2);
                return;
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(new KeyValuePair(stringValue3, new StringValue(bArr, _latin1Encoding)));
            PngDirectory pngDirectory15 = new PngDirectory(PngChunkType.iTXt);
            pngDirectory15.setObject(13, arrayList3);
            metadata2.addDirectory(pngDirectory15);
        } else if (type.equals(PngChunkType.tIME)) {
            SequentialByteArrayReader sequentialByteArrayReader5 = new SequentialByteArrayReader(bytes);
            int uInt16 = sequentialByteArrayReader5.getUInt16();
            short uInt8 = sequentialByteArrayReader5.getUInt8();
            short uInt82 = sequentialByteArrayReader5.getUInt8();
            short uInt83 = sequentialByteArrayReader5.getUInt8();
            short uInt84 = sequentialByteArrayReader5.getUInt8();
            short uInt85 = sequentialByteArrayReader5.getUInt8();
            PngDirectory pngDirectory16 = new PngDirectory(PngChunkType.tIME);
            if (!DateUtil.isValidDate(uInt16, uInt8 - 1, uInt82) || !DateUtil.isValidTime(uInt83, uInt84, uInt85)) {
                pngDirectory16.addError(String.format("PNG tIME data describes an invalid date/time: year=%d month=%d day=%d hour=%d minute=%d second=%d", new Object[]{Integer.valueOf(uInt16), Integer.valueOf(uInt8), Integer.valueOf(uInt82), Integer.valueOf(uInt83), Integer.valueOf(uInt84), Integer.valueOf(uInt85)}));
            } else {
                pngDirectory16.setString(14, String.format("%04d:%02d:%02d %02d:%02d:%02d", new Object[]{Integer.valueOf(uInt16), Integer.valueOf(uInt8), Integer.valueOf(uInt82), Integer.valueOf(uInt83), Integer.valueOf(uInt84), Integer.valueOf(uInt85)}));
            }
            metadata2.addDirectory(pngDirectory16);
        } else if (type.equals(PngChunkType.pHYs)) {
            SequentialByteArrayReader sequentialByteArrayReader6 = new SequentialByteArrayReader(bytes);
            int int32 = sequentialByteArrayReader6.getInt32();
            int int322 = sequentialByteArrayReader6.getInt32();
            byte int84 = sequentialByteArrayReader6.getInt8();
            PngDirectory pngDirectory17 = new PngDirectory(PngChunkType.pHYs);
            pngDirectory17.setInt(16, int32);
            pngDirectory17.setInt(17, int322);
            pngDirectory17.setInt(18, int84);
            metadata2.addDirectory(pngDirectory17);
        } else if (type.equals(PngChunkType.sBIT)) {
            PngDirectory pngDirectory18 = new PngDirectory(PngChunkType.sBIT);
            pngDirectory18.setByteArray(19, bytes);
            metadata2.addDirectory(pngDirectory18);
        }
    }
}

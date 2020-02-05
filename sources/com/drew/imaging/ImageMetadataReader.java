package com.drew.imaging;

import com.drew.imaging.avi.AviMetadataReader;
import com.drew.imaging.bmp.BmpMetadataReader;
import com.drew.imaging.eps.EpsMetadataReader;
import com.drew.imaging.gif.GifMetadataReader;
import com.drew.imaging.ico.IcoMetadataReader;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.mp4.Mp4MetadataReader;
import com.drew.imaging.pcx.PcxMetadataReader;
import com.drew.imaging.png.PngMetadataReader;
import com.drew.imaging.psd.PsdMetadataReader;
import com.drew.imaging.quicktime.QuickTimeMetadataReader;
import com.drew.imaging.raf.RafMetadataReader;
import com.drew.imaging.tiff.TiffMetadataReader;
import com.drew.imaging.wav.WavMetadataReader;
import com.drew.imaging.webp.WebpMetadataReader;
import com.drew.lang.RandomAccessReader;
import com.drew.lang.RandomAccessStreamReader;
import com.drew.lang.StringUtil;
import com.drew.lang.annotations.NotNull;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.file.FileSystemMetadataReader;
import com.drew.metadata.file.FileTypeDirectory;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class ImageMetadataReader {
    @NotNull
    public static Metadata readMetadata(@NotNull InputStream inputStream) throws ImageProcessingException, IOException {
        return readMetadata(inputStream, -1);
    }

    @NotNull
    public static Metadata readMetadata(@NotNull InputStream inputStream, long j) throws ImageProcessingException, IOException {
        BufferedInputStream bufferedInputStream = inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream);
        FileType detectFileType = FileTypeDetector.detectFileType(bufferedInputStream);
        Metadata readMetadata = readMetadata(bufferedInputStream, j, detectFileType);
        readMetadata.addDirectory(new FileTypeDirectory(detectFileType));
        return readMetadata;
    }

    @NotNull
    public static Metadata readMetadata(@NotNull InputStream inputStream, long j, FileType fileType) throws IOException, ImageProcessingException {
        switch (fileType) {
            case Jpeg:
                return JpegMetadataReader.readMetadata(inputStream);
            case Tiff:
            case Arw:
            case Cr2:
            case Nef:
            case Orf:
            case Rw2:
                return TiffMetadataReader.readMetadata((RandomAccessReader) new RandomAccessStreamReader(inputStream, 2048, j));
            case Psd:
                return PsdMetadataReader.readMetadata(inputStream);
            case Png:
                return PngMetadataReader.readMetadata(inputStream);
            case Bmp:
                return BmpMetadataReader.readMetadata(inputStream);
            case Gif:
                return GifMetadataReader.readMetadata(inputStream);
            case Ico:
                return IcoMetadataReader.readMetadata(inputStream);
            case Pcx:
                return PcxMetadataReader.readMetadata(inputStream);
            case WebP:
                return WebpMetadataReader.readMetadata(inputStream);
            case Raf:
                return RafMetadataReader.readMetadata(inputStream);
            case Avi:
                return AviMetadataReader.readMetadata(inputStream);
            case Wav:
                return WavMetadataReader.readMetadata(inputStream);
            case Mov:
                return QuickTimeMetadataReader.readMetadata(inputStream);
            case Mp4:
                return Mp4MetadataReader.readMetadata(inputStream);
            case Eps:
                return EpsMetadataReader.readMetadata(inputStream);
            case Unknown:
                throw new ImageProcessingException("File format could not be determined");
            default:
                return new Metadata();
        }
    }

    /* JADX INFO: finally extract failed */
    @NotNull
    public static Metadata readMetadata(@NotNull File file) throws ImageProcessingException, IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            Metadata readMetadata = readMetadata(fileInputStream, file.length());
            fileInputStream.close();
            new FileSystemMetadataReader().read(file, readMetadata);
            return readMetadata;
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
    }

    private ImageMetadataReader() throws Exception {
        throw new Exception("Not intended for instantiation");
    }

    public static void main(@NotNull String[] strArr) throws MetadataException, IOException {
        String str;
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(strArr));
        boolean remove = arrayList.remove("-markdown");
        boolean remove2 = arrayList.remove("-hex");
        if (arrayList.size() < 1) {
            String implementationVersion = ImageMetadataReader.class.getPackage().getImplementationVersion();
            System.out.println("metadata-extractor version " + implementationVersion);
            System.out.println();
            PrintStream printStream = System.out;
            Object[] objArr = new Object[1];
            if (implementationVersion == null) {
                implementationVersion = "a.b.c";
            }
            objArr[0] = implementationVersion;
            printStream.println(String.format("Usage: java -jar metadata-extractor-%s.jar <filename> [<filename>] [-thumb] [-markdown] [-hex]", objArr));
            System.exit(1);
        }
        for (String str2 : arrayList) {
            long nanoTime = System.nanoTime();
            File file = new File(str2);
            if (!remove && arrayList.size() > 1) {
                System.out.printf("\n***** PROCESSING: %s%n%n", new Object[]{str2});
            }
            Metadata metadata = null;
            try {
                metadata = readMetadata(file);
            } catch (Exception e) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
            long nanoTime2 = System.nanoTime() - nanoTime;
            if (!remove) {
                PrintStream printStream2 = System.out;
                double length = (double) file.length();
                Double.isNaN(length);
                double d = (double) nanoTime2;
                Double.isNaN(d);
                printStream2.printf("Processed %.3f MB file in %.2f ms%n%n", new Object[]{Double.valueOf(length / 1048576.0d), Double.valueOf(d / 1000000.0d)});
            }
            if (remove) {
                String name = file.getName();
                String urlEncode = StringUtil.urlEncode(str2);
                ExifIFD0Directory exifIFD0Directory = (ExifIFD0Directory) metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);
                String str3 = "";
                if (exifIFD0Directory == null) {
                    str = str3;
                } else {
                    str = exifIFD0Directory.getString(271);
                }
                if (exifIFD0Directory != null) {
                    str3 = exifIFD0Directory.getString(272);
                }
                System.out.println();
                System.out.println("---");
                System.out.println();
                System.out.printf("# %s - %s%n", new Object[]{str, str3});
                System.out.println();
                System.out.printf("<a href=\"https://raw.githubusercontent.com/drewnoakes/metadata-extractor-images/master/%s\">%n", new Object[]{urlEncode});
                System.out.printf("<img src=\"https://raw.githubusercontent.com/drewnoakes/metadata-extractor-images/master/%s\" width=\"300\"/><br/>%n", new Object[]{urlEncode});
                System.out.println(name);
                System.out.println("</a>");
                System.out.println();
                System.out.println("Directory | Tag Id | Tag Name | Extracted Value");
                System.out.println(":--------:|-------:|----------|----------------");
            }
            for (Directory next : metadata.getDirectories()) {
                String name2 = next.getName();
                for (Tag next2 : next.getTags()) {
                    String tagName = next2.getTagName();
                    String description = next2.getDescription();
                    if (description != null && description.length() > 1024) {
                        description = description.substring(0, 1024) + "...";
                    }
                    if (remove) {
                        System.out.printf("%s|0x%s|%s|%s%n", new Object[]{name2, Integer.toHexString(next2.getTagType()), tagName, description});
                    } else if (remove2) {
                        System.out.printf("[%s - %s] %s = %s%n", new Object[]{name2, next2.getTagTypeHex(), tagName, description});
                    } else {
                        System.out.printf("[%s] %s = %s%n", new Object[]{name2, tagName, description});
                    }
                }
                for (String str4 : next.getErrors()) {
                    System.err.println("ERROR: " + str4);
                }
            }
        }
    }
}

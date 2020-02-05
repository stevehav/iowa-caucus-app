package com.drew.tools;

import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.imaging.jpeg.JpegSegmentData;
import com.drew.imaging.jpeg.JpegSegmentReader;
import com.drew.imaging.jpeg.JpegSegmentType;
import com.drew.lang.Iterables;
import com.drew.lang.annotations.NotNull;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;

public class ExtractJpegSegmentTool {
    public static void main(String[] strArr) throws IOException, JpegProcessingException {
        if (strArr.length < 1) {
            printUsage();
            System.exit(1);
        }
        String str = strArr[0];
        if (!new File(str).exists()) {
            System.err.println("File does not exist");
            printUsage();
            System.exit(1);
        }
        HashSet hashSet = new HashSet();
        for (int i = 1; i < strArr.length; i++) {
            JpegSegmentType valueOf = JpegSegmentType.valueOf(strArr[i].toUpperCase());
            if (!valueOf.canContainMetadata) {
                System.err.printf("WARNING: Segment type %s cannot contain metadata so it may not be necessary to extract it%n", new Object[]{valueOf});
            }
            hashSet.add(valueOf);
        }
        if (hashSet.size() == 0) {
            hashSet.addAll(JpegSegmentType.canContainMetadataTypes);
        }
        PrintStream printStream = System.out;
        printStream.println("Reading: " + str);
        saveSegmentFiles(str, JpegSegmentReader.readSegments(new File(str), (Iterable<JpegSegmentType>) hashSet));
    }

    public static void saveSegmentFiles(@NotNull String str, @NotNull JpegSegmentData jpegSegmentData) throws IOException {
        for (JpegSegmentType next : jpegSegmentData.getSegmentTypes()) {
            List<E> list = Iterables.toList(jpegSegmentData.getSegments(next));
            if (list.size() != 0) {
                if (list.size() > 1) {
                    for (int i = 0; i < list.size(); i++) {
                        String format = String.format("%s.%s.%d", new Object[]{str, next.toString().toLowerCase(), Integer.valueOf(i)});
                        PrintStream printStream = System.out;
                        printStream.println("Writing: " + format);
                        FileUtil.saveBytes(new File(format), (byte[]) list.get(i));
                    }
                } else {
                    String format2 = String.format("%s.%s", new Object[]{str, next.toString().toLowerCase()});
                    PrintStream printStream2 = System.out;
                    printStream2.println("Writing: " + format2);
                    FileUtil.saveBytes(new File(format2), (byte[]) list.get(0));
                }
            }
        }
    }

    private static void printUsage() {
        System.out.println("USAGE:\n");
        System.out.println("\tjava com.drew.tools.ExtractJpegSegmentTool <filename> [<segment> ...]\n");
        System.out.print("Where <segment> is zero or more of:");
        for (JpegSegmentType jpegSegmentType : (JpegSegmentType[]) JpegSegmentType.class.getEnumConstants()) {
            if (jpegSegmentType.canContainMetadata) {
                System.out.print(" " + jpegSegmentType.toString());
            }
        }
        System.out.println();
    }
}

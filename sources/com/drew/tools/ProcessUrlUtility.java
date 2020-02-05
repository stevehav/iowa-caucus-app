package com.drew.tools;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import java.io.IOException;
import java.net.URL;

public class ProcessUrlUtility {
    public static void main(String[] strArr) throws IOException, JpegProcessingException {
        if (strArr.length == 0) {
            System.err.println("Expects one or more URLs as arguments.");
            System.exit(1);
        }
        for (String url : strArr) {
            processUrl(new URL(url));
        }
        System.out.println("Completed.");
    }

    private static void processUrl(URL url) throws IOException {
        try {
            Metadata readMetadata = ImageMetadataReader.readMetadata(url.openConnection().getInputStream());
            if (readMetadata.hasErrors()) {
                System.err.println(url);
                for (Directory next : readMetadata.getDirectories()) {
                    if (next.hasErrors()) {
                        for (String str : next.getErrors()) {
                            System.err.printf("\t[%s] %s%n", new Object[]{next.getName(), str});
                        }
                    }
                }
            }
            for (Directory next2 : readMetadata.getDirectories()) {
                for (Tag next3 : next2.getTags()) {
                    String tagName = next3.getTagName();
                    String name = next2.getName();
                    String description = next3.getDescription();
                    if (description != null && description.length() > 1024) {
                        description = description.substring(0, 1024) + "...";
                    }
                    System.out.printf("[%s] %s = %s%n", new Object[]{name, tagName, description});
                }
            }
        } catch (ImageProcessingException e) {
            System.err.printf("%s: %s [Error Extracting Metadata]%n\t%s%n", new Object[]{e.getClass().getName(), url, e.getMessage()});
        } catch (Throwable th) {
            System.err.printf("%s: %s [Error Extracting Metadata]%n", new Object[]{th.getClass().getName(), url});
            th.printStackTrace(System.err);
        }
    }
}

package com.drew.metadata.photoshop;

import com.drew.lang.ByteArrayReader;
import com.drew.lang.RandomAccessReader;
import com.drew.lang.SequentialByteArrayReader;
import com.drew.lang.annotations.NotNull;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifTiffHandler;
import com.drew.metadata.icc.IccReader;
import com.drew.metadata.xmp.XmpReader;
import java.io.IOException;
import java.util.Set;

public class PhotoshopTiffHandler extends ExifTiffHandler {
    private static final int TAG_EXIF_GPS = 34853;
    private static final int TAG_EXIF_IFD_POINTER = 34665;
    private static final int TAG_FILE_INFORMATION = 33723;
    private static final int TAG_ICC_PROFILES = 34675;
    private static final int TAG_JPEG_TABLES = 437;
    private static final int TAG_PAGE_MAKER_EXTENSION = 330;
    private static final int TAG_PHOTOSHOP_IMAGE_RESOURCES = 34377;
    private static final int TAG_T_ANNOTATIONS = 50255;
    private static final int TAG_T_IMAGE_SOURCE_DATA = 37724;
    private static final int TAG_XMP = 700;

    public PhotoshopTiffHandler(Metadata metadata, Directory directory) {
        super(metadata, directory);
    }

    public boolean customProcessTag(int i, @NotNull Set<Integer> set, int i2, @NotNull RandomAccessReader randomAccessReader, int i3, int i4) throws IOException {
        if (i3 == 700) {
            new XmpReader().extract(randomAccessReader.getBytes(i, i4), this._metadata);
            return true;
        } else if (i3 == TAG_PHOTOSHOP_IMAGE_RESOURCES) {
            new PhotoshopReader().extract(new SequentialByteArrayReader(randomAccessReader.getBytes(i, i4)), i4, this._metadata);
            return true;
        } else if (i3 != 34675) {
            return super.customProcessTag(i, set, i2, randomAccessReader, i3, i4);
        } else {
            new IccReader().extract(new ByteArrayReader(randomAccessReader.getBytes(i, i4)), this._metadata);
            return true;
        }
    }
}

package com.drew.metadata.mp4.boxes;

import com.drew.lang.SequentialReader;
import com.drew.metadata.mp4.media.Mp4VideoDirectory;
import java.io.IOException;

public class VisualSampleEntry extends SampleEntry {
    String compressorname;
    int depth;
    int frameCount;
    int height;
    long horizresolution;
    int revisionLevel;
    int spatialQuality;
    int temporalQuality;
    String vendor;
    int version;
    long vertresolution;
    int width;

    public VisualSampleEntry(SequentialReader sequentialReader, Box box) throws IOException {
        super(sequentialReader, box);
        this.version = sequentialReader.getInt16();
        this.revisionLevel = sequentialReader.getInt16();
        this.vendor = sequentialReader.getString(4);
        this.temporalQuality = sequentialReader.getInt32();
        this.spatialQuality = sequentialReader.getInt32();
        this.width = sequentialReader.getUInt16();
        this.height = sequentialReader.getUInt16();
        this.horizresolution = sequentialReader.getUInt32();
        this.vertresolution = sequentialReader.getUInt32();
        sequentialReader.skip(4);
        this.frameCount = sequentialReader.getUInt16();
        this.compressorname = sequentialReader.getString(32);
        this.depth = sequentialReader.getUInt16();
        sequentialReader.skip(2);
    }

    public void addMetadata(Mp4VideoDirectory mp4VideoDirectory) {
        Mp4VideoDirectory mp4VideoDirectory2 = mp4VideoDirectory;
        mp4VideoDirectory2.setInt(104, this.width);
        mp4VideoDirectory2.setInt(105, this.height);
        mp4VideoDirectory2.setString(110, this.compressorname.trim());
        mp4VideoDirectory2.setInt(109, this.depth);
        long j = this.horizresolution;
        double d = (double) ((j & -65536) >> 16);
        double d2 = (double) (j & 65535);
        double pow = Math.pow(2.0d, 4.0d);
        Double.isNaN(d2);
        Double.isNaN(d);
        mp4VideoDirectory2.setDouble(106, d + (d2 / pow));
        long j2 = this.vertresolution;
        double d3 = (double) ((-65536 & j2) >> 16);
        double d4 = (double) (j2 & 65535);
        double pow2 = Math.pow(2.0d, 4.0d);
        Double.isNaN(d4);
        Double.isNaN(d3);
        mp4VideoDirectory2.setDouble(107, d3 + (d4 / pow2));
    }
}

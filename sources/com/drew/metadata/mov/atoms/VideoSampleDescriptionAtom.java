package com.drew.metadata.mov.atoms;

import com.drew.lang.SequentialReader;
import com.drew.metadata.mov.QuickTimeDictionary;
import com.drew.metadata.mov.media.QuickTimeVideoDirectory;
import java.io.IOException;

public class VideoSampleDescriptionAtom extends SampleDescriptionAtom<VideoSampleDescription> {
    public VideoSampleDescriptionAtom(SequentialReader sequentialReader, Atom atom) throws IOException {
        super(sequentialReader, atom);
    }

    /* access modifiers changed from: package-private */
    public VideoSampleDescription getSampleDescription(SequentialReader sequentialReader) throws IOException {
        return new VideoSampleDescription(sequentialReader);
    }

    public void addMetadata(QuickTimeVideoDirectory quickTimeVideoDirectory) {
        QuickTimeVideoDirectory quickTimeVideoDirectory2 = quickTimeVideoDirectory;
        VideoSampleDescription videoSampleDescription = (VideoSampleDescription) this.sampleDescriptions.get(0);
        QuickTimeDictionary.setLookup(1, videoSampleDescription.vendor, quickTimeVideoDirectory2);
        QuickTimeDictionary.setLookup(10, videoSampleDescription.dataFormat, quickTimeVideoDirectory2);
        quickTimeVideoDirectory2.setLong(2, videoSampleDescription.temporalQuality);
        quickTimeVideoDirectory2.setLong(3, videoSampleDescription.spatialQuality);
        quickTimeVideoDirectory2.setInt(4, videoSampleDescription.width);
        quickTimeVideoDirectory2.setInt(5, videoSampleDescription.height);
        quickTimeVideoDirectory2.setString(8, videoSampleDescription.compressorName.trim());
        quickTimeVideoDirectory2.setInt(9, videoSampleDescription.depth);
        quickTimeVideoDirectory2.setInt(13, videoSampleDescription.colorTableID);
        double d = (double) ((videoSampleDescription.horizontalResolution & -65536) >> 16);
        double d2 = (double) (videoSampleDescription.horizontalResolution & 65535);
        double pow = Math.pow(2.0d, 4.0d);
        Double.isNaN(d2);
        Double.isNaN(d);
        quickTimeVideoDirectory2.setDouble(6, d + (d2 / pow));
        double d3 = (double) ((videoSampleDescription.verticalResolution & -65536) >> 16);
        double d4 = (double) (videoSampleDescription.verticalResolution & 65535);
        double pow2 = Math.pow(2.0d, 4.0d);
        Double.isNaN(d4);
        Double.isNaN(d3);
        quickTimeVideoDirectory2.setDouble(7, d3 + (d4 / pow2));
    }

    class VideoSampleDescription extends SampleDescription {
        int colorTableID;
        String compressorName;
        long dataSize;
        int depth;
        int frameCount;
        int height;
        long horizontalResolution;
        int revisionLevel;
        long spatialQuality;
        long temporalQuality;
        String vendor;
        int version;
        long verticalResolution;
        int width;

        public VideoSampleDescription(SequentialReader sequentialReader) throws IOException {
            super(sequentialReader);
            this.version = sequentialReader.getUInt16();
            this.revisionLevel = sequentialReader.getUInt16();
            this.vendor = sequentialReader.getString(4);
            this.temporalQuality = sequentialReader.getUInt32();
            this.spatialQuality = sequentialReader.getUInt32();
            this.width = sequentialReader.getUInt16();
            this.height = sequentialReader.getUInt16();
            this.horizontalResolution = sequentialReader.getUInt32();
            this.verticalResolution = sequentialReader.getUInt32();
            this.dataSize = sequentialReader.getUInt32();
            this.frameCount = sequentialReader.getUInt16();
            this.compressorName = sequentialReader.getString(sequentialReader.getUInt8());
            this.depth = sequentialReader.getUInt16();
            this.colorTableID = sequentialReader.getInt16();
        }
    }
}

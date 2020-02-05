package com.drew.metadata.mp4.boxes;

import com.drew.lang.SequentialReader;
import java.io.IOException;

public class SampleEntry extends FullBox {
    int dataReferenceIndex;
    String format;
    long numberOfEntries;
    long sampleDescriptionSize;

    public SampleEntry(SequentialReader sequentialReader, Box box) throws IOException {
        super(sequentialReader, box);
        this.numberOfEntries = sequentialReader.getUInt32();
        this.sampleDescriptionSize = sequentialReader.getUInt32();
        this.format = sequentialReader.getString(4);
        sequentialReader.skip(6);
        this.dataReferenceIndex = sequentialReader.getUInt16();
    }
}

package com.drew.metadata.mov.atoms;

import com.drew.lang.SequentialReader;
import java.io.IOException;

public class SampleDescription {
    String dataFormat;
    int dataReferenceIndex;
    long sampleDescriptionSize;

    public SampleDescription(SequentialReader sequentialReader) throws IOException {
        this.sampleDescriptionSize = sequentialReader.getUInt32();
        this.dataFormat = sequentialReader.getString(4);
        sequentialReader.skip(6);
        this.dataReferenceIndex = sequentialReader.getUInt16();
    }
}

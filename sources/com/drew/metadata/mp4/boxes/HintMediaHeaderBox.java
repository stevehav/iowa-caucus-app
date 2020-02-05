package com.drew.metadata.mp4.boxes;

import com.drew.lang.SequentialReader;
import com.drew.metadata.mp4.media.Mp4HintDirectory;
import java.io.IOException;

public class HintMediaHeaderBox extends FullBox {
    int avgPDUsize;
    long avgbitrate;
    int maxPDUsize;
    long maxbitrate;

    public HintMediaHeaderBox(SequentialReader sequentialReader, Box box) throws IOException {
        super(sequentialReader, box);
        this.maxPDUsize = sequentialReader.getUInt16();
        this.avgPDUsize = sequentialReader.getUInt16();
        this.maxbitrate = sequentialReader.getUInt32();
        this.avgbitrate = sequentialReader.getUInt32();
    }

    public void addMetadata(Mp4HintDirectory mp4HintDirectory) {
        mp4HintDirectory.setInt(101, this.maxPDUsize);
        mp4HintDirectory.setInt(102, this.avgPDUsize);
        mp4HintDirectory.setLong(103, this.maxbitrate);
        mp4HintDirectory.setLong(104, this.avgbitrate);
    }
}

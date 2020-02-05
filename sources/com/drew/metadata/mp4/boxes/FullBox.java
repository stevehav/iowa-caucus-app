package com.drew.metadata.mp4.boxes;

import com.drew.lang.SequentialReader;
import java.io.IOException;

public class FullBox extends Box {
    protected byte[] flags;
    protected int version;

    public FullBox(SequentialReader sequentialReader, Box box) throws IOException {
        super(box);
        this.version = sequentialReader.getUInt8();
        this.flags = sequentialReader.getBytes(3);
    }
}

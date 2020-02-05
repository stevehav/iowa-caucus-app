package com.drew.metadata.mp4.boxes;

import com.drew.lang.SequentialReader;
import java.io.IOException;

public class Box {
    public long size;
    public String type;
    public String usertype;

    public Box(SequentialReader sequentialReader) throws IOException {
        this.size = sequentialReader.getUInt32();
        this.type = sequentialReader.getString(4);
        long j = this.size;
        if (j == 1) {
            this.size = sequentialReader.getInt64();
        } else if (j == 0) {
            this.size = -1;
        }
        if (this.type.equals("uuid")) {
            this.usertype = sequentialReader.getString(16);
        }
    }

    public Box(Box box) {
        this.size = box.size;
        this.type = box.type;
        this.usertype = box.usertype;
    }
}

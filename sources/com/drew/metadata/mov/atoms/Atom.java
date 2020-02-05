package com.drew.metadata.mov.atoms;

import com.drew.lang.SequentialReader;
import java.io.IOException;

public class Atom {
    public long size;
    public String type;

    public Atom(SequentialReader sequentialReader) throws IOException {
        this.size = sequentialReader.getUInt32();
        this.type = sequentialReader.getString(4);
        long j = this.size;
        if (j == 1) {
            this.size = sequentialReader.getInt64();
        } else if (j == 0) {
            this.size = -1;
        }
    }

    public Atom(Atom atom) {
        this.size = atom.size;
        this.type = atom.type;
    }
}

package com.drew.metadata.mov.atoms;

import com.drew.lang.SequentialReader;
import com.drew.metadata.mov.QuickTimeHandlerFactory;
import com.drew.metadata.mov.media.QuickTimeVideoDirectory;
import java.io.IOException;
import java.util.ArrayList;

public class TimeToSampleAtom extends FullAtom {
    ArrayList<Entry> entries = new ArrayList<>();
    long numberOfEntries;
    long sampleCount;
    long sampleDuration;

    public TimeToSampleAtom(SequentialReader sequentialReader, Atom atom) throws IOException {
        super(sequentialReader, atom);
        this.numberOfEntries = sequentialReader.getUInt32();
        for (int i = 0; ((long) i) < this.numberOfEntries; i++) {
            this.entries.add(new Entry(sequentialReader));
        }
        this.sampleCount = sequentialReader.getUInt32();
        this.sampleDuration = sequentialReader.getUInt32();
    }

    class Entry {
        long sampleCount;
        long sampleDuration;

        public Entry(SequentialReader sequentialReader) throws IOException {
            this.sampleCount = sequentialReader.getUInt32();
            this.sampleDuration = sequentialReader.getUInt32();
        }
    }

    public void addMetadata(QuickTimeVideoDirectory quickTimeVideoDirectory) {
        quickTimeVideoDirectory.setFloat(14, ((float) QuickTimeHandlerFactory.HANDLER_PARAM_TIME_SCALE.longValue()) / ((float) this.sampleDuration));
    }
}

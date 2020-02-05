package com.drew.metadata.mov.atoms;

import com.drew.lang.SequentialReader;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.mov.atoms.SampleDescription;
import java.io.IOException;
import java.util.ArrayList;

public abstract class SampleDescriptionAtom<T extends SampleDescription> extends FullAtom {
    long numberOfEntries;
    ArrayList<T> sampleDescriptions = new ArrayList<>((int) this.numberOfEntries);

    /* access modifiers changed from: package-private */
    @Nullable
    public abstract T getSampleDescription(SequentialReader sequentialReader) throws IOException;

    public SampleDescriptionAtom(SequentialReader sequentialReader, Atom atom) throws IOException {
        super(sequentialReader, atom);
        this.numberOfEntries = sequentialReader.getUInt32();
        for (int i = 0; ((long) i) < this.numberOfEntries; i++) {
            this.sampleDescriptions.add(getSampleDescription(sequentialReader));
        }
    }
}

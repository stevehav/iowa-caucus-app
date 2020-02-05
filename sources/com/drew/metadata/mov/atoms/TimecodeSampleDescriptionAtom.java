package com.drew.metadata.mov.atoms;

import com.drew.lang.SequentialReader;
import com.drew.metadata.mov.media.QuickTimeTimecodeDirectory;
import java.io.IOException;

public class TimecodeSampleDescriptionAtom extends SampleDescriptionAtom<TimecodeSampleDescription> {
    public TimecodeSampleDescriptionAtom(SequentialReader sequentialReader, Atom atom) throws IOException {
        super(sequentialReader, atom);
    }

    /* access modifiers changed from: package-private */
    public TimecodeSampleDescription getSampleDescription(SequentialReader sequentialReader) throws IOException {
        return new TimecodeSampleDescription(sequentialReader);
    }

    public void addMetadata(QuickTimeTimecodeDirectory quickTimeTimecodeDirectory) {
        boolean z = false;
        TimecodeSampleDescription timecodeSampleDescription = (TimecodeSampleDescription) this.sampleDescriptions.get(0);
        quickTimeTimecodeDirectory.setBoolean(1, (timecodeSampleDescription.flags & 1) == 1);
        quickTimeTimecodeDirectory.setBoolean(2, (timecodeSampleDescription.flags & 2) == 2);
        quickTimeTimecodeDirectory.setBoolean(3, (timecodeSampleDescription.flags & 4) == 4);
        if ((timecodeSampleDescription.flags & 8) == 8) {
            z = true;
        }
        quickTimeTimecodeDirectory.setBoolean(4, z);
    }

    class TimecodeSampleDescription extends SampleDescription {
        int flags;
        int frameDuration;
        int numberOfFrames;
        int timeScale;

        public TimecodeSampleDescription(SequentialReader sequentialReader) throws IOException {
            super(sequentialReader);
            sequentialReader.skip(4);
            this.flags = sequentialReader.getInt32();
            this.timeScale = sequentialReader.getInt32();
            this.frameDuration = sequentialReader.getInt32();
            this.numberOfFrames = sequentialReader.getInt8();
            sequentialReader.skip(1);
        }
    }
}

package com.drew.metadata.mov.atoms;

import com.drew.lang.SequentialReader;
import com.drew.metadata.mov.QuickTimeDictionary;
import com.drew.metadata.mov.media.QuickTimeSoundDirectory;
import java.io.IOException;

public class SoundSampleDescriptionAtom extends SampleDescriptionAtom<SoundSampleDescription> {
    public SoundSampleDescriptionAtom(SequentialReader sequentialReader, Atom atom) throws IOException {
        super(sequentialReader, atom);
    }

    /* access modifiers changed from: package-private */
    public SoundSampleDescription getSampleDescription(SequentialReader sequentialReader) throws IOException {
        return new SoundSampleDescription(sequentialReader);
    }

    public void addMetadata(QuickTimeSoundDirectory quickTimeSoundDirectory) {
        SoundSampleDescription soundSampleDescription = (SoundSampleDescription) this.sampleDescriptions.get(0);
        quickTimeSoundDirectory.setString(769, QuickTimeDictionary.lookup(769, soundSampleDescription.dataFormat));
        quickTimeSoundDirectory.setInt(770, soundSampleDescription.numberOfChannels);
        quickTimeSoundDirectory.setInt(771, soundSampleDescription.sampleSize);
    }

    class SoundSampleDescription extends SampleDescription {
        int compressionID;
        int numberOfChannels;
        int packetSize;
        int revisionLevel;
        long sampleRate;
        int sampleSize;
        int vendor;
        int version;

        public SoundSampleDescription(SequentialReader sequentialReader) throws IOException {
            super(sequentialReader);
            this.version = sequentialReader.getUInt16();
            this.revisionLevel = sequentialReader.getUInt16();
            this.vendor = sequentialReader.getInt32();
            this.numberOfChannels = sequentialReader.getUInt16();
            this.sampleSize = sequentialReader.getUInt16();
            this.compressionID = sequentialReader.getUInt16();
            this.packetSize = sequentialReader.getUInt16();
            this.sampleRate = sequentialReader.getUInt32();
        }
    }
}

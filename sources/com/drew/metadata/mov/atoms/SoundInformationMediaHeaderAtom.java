package com.drew.metadata.mov.atoms;

import com.drew.lang.SequentialReader;
import com.drew.metadata.mov.media.QuickTimeSoundDirectory;
import java.io.IOException;

public class SoundInformationMediaHeaderAtom extends FullAtom {
    int balance;

    public SoundInformationMediaHeaderAtom(SequentialReader sequentialReader, Atom atom) throws IOException {
        super(sequentialReader, atom);
        this.balance = sequentialReader.getInt16();
        sequentialReader.skip(2);
    }

    public void addMetadata(QuickTimeSoundDirectory quickTimeSoundDirectory) {
        int i = this.balance;
        double d = (double) (-65536 & i);
        double d2 = (double) (i & 65535);
        double pow = Math.pow(2.0d, 4.0d);
        Double.isNaN(d2);
        Double.isNaN(d);
        quickTimeSoundDirectory.setDouble(773, d + (d2 / pow));
    }
}

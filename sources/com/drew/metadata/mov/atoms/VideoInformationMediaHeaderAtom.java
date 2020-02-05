package com.drew.metadata.mov.atoms;

import com.drew.lang.SequentialReader;
import com.drew.metadata.mov.media.QuickTimeVideoDirectory;
import java.io.IOException;

public class VideoInformationMediaHeaderAtom extends FullAtom {
    int graphicsMode;
    int[] opcolor;

    public VideoInformationMediaHeaderAtom(SequentialReader sequentialReader, Atom atom) throws IOException {
        super(sequentialReader, atom);
        this.graphicsMode = sequentialReader.getUInt16();
        this.opcolor = new int[]{sequentialReader.getUInt16(), sequentialReader.getUInt16(), sequentialReader.getUInt16()};
    }

    public void addMetadata(QuickTimeVideoDirectory quickTimeVideoDirectory) {
        quickTimeVideoDirectory.setIntArray(12, this.opcolor);
        quickTimeVideoDirectory.setInt(11, this.graphicsMode);
    }
}

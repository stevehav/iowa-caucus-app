package com.drew.metadata.mov.atoms;

import com.drew.lang.SequentialReader;
import com.drew.metadata.mov.QuickTimeHandlerFactory;
import java.io.IOException;

public class MediaHeaderAtom extends FullAtom {
    long creationTime;
    long duration;
    int language;
    long modificationTime;
    int quality;
    long timescale;

    public MediaHeaderAtom(SequentialReader sequentialReader, Atom atom) throws IOException {
        super(sequentialReader, atom);
        this.creationTime = sequentialReader.getUInt32();
        this.modificationTime = sequentialReader.getUInt32();
        this.timescale = sequentialReader.getUInt32();
        this.duration = sequentialReader.getUInt32();
        this.language = sequentialReader.getUInt16();
        this.quality = sequentialReader.getUInt16();
        QuickTimeHandlerFactory.HANDLER_PARAM_CREATION_TIME = Long.valueOf(this.creationTime);
        QuickTimeHandlerFactory.HANDLER_PARAM_MODIFICATION_TIME = Long.valueOf(this.modificationTime);
        QuickTimeHandlerFactory.HANDLER_PARAM_TIME_SCALE = Long.valueOf(this.timescale);
        QuickTimeHandlerFactory.HANDLER_PARAM_DURATION = Long.valueOf(this.duration);
    }
}

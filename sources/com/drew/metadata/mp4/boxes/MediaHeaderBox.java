package com.drew.metadata.mp4.boxes;

import com.drew.lang.SequentialReader;
import com.drew.metadata.mp4.Mp4HandlerFactory;
import java.io.IOException;

public class MediaHeaderBox extends FullBox {
    long creationTime;
    long duration;
    String language;
    long modificationTime;
    long timescale;

    public MediaHeaderBox(SequentialReader sequentialReader, Box box) throws IOException {
        super(sequentialReader, box);
        if (this.version == 1) {
            this.creationTime = sequentialReader.getInt64();
            this.modificationTime = sequentialReader.getInt64();
            this.timescale = (long) sequentialReader.getInt32();
            this.duration = sequentialReader.getInt64();
        } else {
            this.creationTime = sequentialReader.getUInt32();
            this.modificationTime = sequentialReader.getUInt32();
            this.timescale = sequentialReader.getUInt32();
            this.duration = sequentialReader.getUInt32();
        }
        short int16 = sequentialReader.getInt16();
        this.language = new String(new char[]{(char) (((int16 & 31744) >> 10) + 96), (char) (((int16 & 992) >> 5) + 96), (char) ((int16 & 31) + 96)});
        Mp4HandlerFactory.HANDLER_PARAM_CREATION_TIME = Long.valueOf(this.creationTime);
        Mp4HandlerFactory.HANDLER_PARAM_MODIFICATION_TIME = Long.valueOf(this.modificationTime);
        Mp4HandlerFactory.HANDLER_PARAM_TIME_SCALE = Long.valueOf(this.timescale);
        Mp4HandlerFactory.HANDLER_PARAM_DURATION = Long.valueOf(this.duration);
        Mp4HandlerFactory.HANDLER_PARAM_LANGUAGE = this.language;
    }
}

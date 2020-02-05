package com.drew.metadata.mp4.boxes;

import com.drew.lang.SequentialReader;
import com.drew.metadata.mp4.Mp4Directory;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class MovieHeaderBox extends FullBox {
    protected long creationTime;
    protected long duration;
    protected int[] matrix;
    protected long modificationTime;
    protected long nextTrackID;
    protected int rate;
    protected long timescale;
    protected int volume;

    public MovieHeaderBox(SequentialReader sequentialReader, Box box) throws IOException {
        super(sequentialReader, box);
        if (this.version == 1) {
            this.creationTime = sequentialReader.getInt64();
            this.modificationTime = sequentialReader.getInt64();
            this.timescale = sequentialReader.getUInt32();
            this.duration = sequentialReader.getInt64();
        } else {
            this.creationTime = sequentialReader.getUInt32();
            this.modificationTime = sequentialReader.getUInt32();
            this.timescale = sequentialReader.getUInt32();
            this.duration = sequentialReader.getUInt32();
        }
        this.rate = sequentialReader.getInt32();
        this.volume = sequentialReader.getInt16();
        sequentialReader.skip(2);
        sequentialReader.skip(8);
        this.matrix = new int[]{sequentialReader.getInt32(), sequentialReader.getInt32(), sequentialReader.getInt32(), sequentialReader.getInt32(), sequentialReader.getInt32(), sequentialReader.getInt32(), sequentialReader.getInt32(), sequentialReader.getInt32(), sequentialReader.getInt32()};
        sequentialReader.skip(24);
        this.nextTrackID = sequentialReader.getUInt32();
    }

    public void addMetadata(Mp4Directory mp4Directory) {
        Calendar instance = Calendar.getInstance();
        instance.set(1904, 0, 1, 0, 0, 0);
        long time = instance.getTime().getTime();
        mp4Directory.setDate(256, new Date((this.creationTime * 1000) + time));
        mp4Directory.setDate(257, new Date((this.modificationTime * 1000) + time));
        this.duration /= this.timescale;
        mp4Directory.setLong(259, this.duration);
        mp4Directory.setLong(258, this.timescale);
        mp4Directory.setIntArray(271, this.matrix);
        int i = this.rate;
        double d = (double) ((-65536 & i) >> 16);
        double d2 = (double) (i & 65535);
        double pow = Math.pow(2.0d, 4.0d);
        Double.isNaN(d2);
        Double.isNaN(d);
        mp4Directory.setDouble(260, d + (d2 / pow));
        int i2 = this.volume;
        double d3 = (double) ((65280 & i2) >> 8);
        double d4 = (double) (i2 & 255);
        double pow2 = Math.pow(2.0d, 2.0d);
        Double.isNaN(d4);
        Double.isNaN(d3);
        mp4Directory.setDouble(261, d3 + (d4 / pow2));
        mp4Directory.setLong(270, this.nextTrackID);
    }
}

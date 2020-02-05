package com.drew.metadata.mp4;

import com.drew.imaging.mp4.Mp4Handler;
import com.drew.lang.SequentialByteArrayReader;
import com.drew.lang.SequentialReader;
import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.Metadata;
import com.drew.metadata.mp4.boxes.Box;
import com.drew.metadata.mp4.media.Mp4MediaDirectory;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public abstract class Mp4MediaHandler<T extends Mp4MediaDirectory> extends Mp4Handler<T> {
    /* access modifiers changed from: protected */
    public abstract String getMediaInformation();

    /* access modifiers changed from: protected */
    public abstract void processMediaInformation(@NotNull SequentialReader sequentialReader, @NotNull Box box) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void processSampleDescription(@NotNull SequentialReader sequentialReader, @NotNull Box box) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void processTimeToSample(@NotNull SequentialReader sequentialReader, @NotNull Box box) throws IOException;

    public Mp4MediaHandler(Metadata metadata) {
        super(metadata);
        if (Mp4HandlerFactory.HANDLER_PARAM_CREATION_TIME != null && Mp4HandlerFactory.HANDLER_PARAM_MODIFICATION_TIME != null) {
            Calendar instance = Calendar.getInstance();
            instance.set(1904, 0, 1, 0, 0, 0);
            long time = instance.getTime().getTime();
            String date = new Date((Mp4HandlerFactory.HANDLER_PARAM_CREATION_TIME.longValue() * 1000) + time).toString();
            String date2 = new Date((Mp4HandlerFactory.HANDLER_PARAM_MODIFICATION_TIME.longValue() * 1000) + time).toString();
            String str = Mp4HandlerFactory.HANDLER_PARAM_LANGUAGE;
            ((Mp4MediaDirectory) this.directory).setString(101, date);
            ((Mp4MediaDirectory) this.directory).setString(102, date2);
            ((Mp4MediaDirectory) this.directory).setString(104, str);
        }
    }

    public boolean shouldAcceptBox(@NotNull Box box) {
        return box.type.equals(getMediaInformation()) || box.type.equals("stsd") || box.type.equals("stts");
    }

    public boolean shouldAcceptContainer(@NotNull Box box) {
        return box.type.equals("stbl") || box.type.equals("minf");
    }

    public Mp4Handler processBox(@NotNull Box box, @Nullable byte[] bArr) throws IOException {
        if (bArr != null) {
            SequentialByteArrayReader sequentialByteArrayReader = new SequentialByteArrayReader(bArr);
            if (box.type.equals(getMediaInformation())) {
                processMediaInformation(sequentialByteArrayReader, box);
            } else if (box.type.equals("stsd")) {
                processSampleDescription(sequentialByteArrayReader, box);
            } else if (box.type.equals("stts")) {
                processTimeToSample(sequentialByteArrayReader, box);
            }
        }
        return this;
    }
}

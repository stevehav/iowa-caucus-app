package com.drew.metadata.mp4;

import com.drew.imaging.mp4.Mp4Handler;
import com.drew.lang.SequentialByteArrayReader;
import com.drew.lang.SequentialReader;
import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.Metadata;
import com.drew.metadata.mp4.boxes.Box;
import com.drew.metadata.mp4.boxes.FileTypeBox;
import com.drew.metadata.mp4.boxes.HandlerBox;
import com.drew.metadata.mp4.boxes.MediaHeaderBox;
import com.drew.metadata.mp4.boxes.MovieHeaderBox;
import java.io.IOException;

public class Mp4BoxHandler extends Mp4Handler<Mp4Directory> {
    private Mp4HandlerFactory handlerFactory = new Mp4HandlerFactory(this);

    public Mp4BoxHandler(Metadata metadata) {
        super(metadata);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public Mp4Directory getDirectory() {
        return new Mp4Directory();
    }

    public boolean shouldAcceptBox(@NotNull Box box) {
        return box.type.equals("ftyp") || box.type.equals("mvhd") || box.type.equals("hdlr") || box.type.equals("mdhd");
    }

    public boolean shouldAcceptContainer(@NotNull Box box) {
        return box.type.equals("trak") || box.type.equals("meta") || box.type.equals("moov") || box.type.equals("mdia");
    }

    public Mp4Handler processBox(@NotNull Box box, @Nullable byte[] bArr) throws IOException {
        if (bArr != null) {
            SequentialByteArrayReader sequentialByteArrayReader = new SequentialByteArrayReader(bArr);
            if (box.type.equals("mvhd")) {
                processMovieHeader(sequentialByteArrayReader, box);
            } else if (box.type.equals("ftyp")) {
                processFileType(sequentialByteArrayReader, box);
            } else if (box.type.equals("hdlr")) {
                return this.handlerFactory.getHandler(new HandlerBox(sequentialByteArrayReader, box), this.metadata);
            } else if (box.type.equals("mdhd")) {
                processMediaHeader(sequentialByteArrayReader, box);
            }
        } else if (box.type.equals("cmov")) {
            this.directory.addError("Compressed MP4 movies not supported");
        }
        return this;
    }

    private void processFileType(@NotNull SequentialReader sequentialReader, @NotNull Box box) throws IOException {
        new FileTypeBox(sequentialReader, box).addMetadata(this.directory);
    }

    private void processMovieHeader(@NotNull SequentialReader sequentialReader, @NotNull Box box) throws IOException {
        new MovieHeaderBox(sequentialReader, box).addMetadata(this.directory);
    }

    private void processMediaHeader(@NotNull SequentialReader sequentialReader, @NotNull Box box) throws IOException {
        new MediaHeaderBox(sequentialReader, box);
    }
}

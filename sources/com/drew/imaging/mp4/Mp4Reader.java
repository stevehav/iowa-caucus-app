package com.drew.imaging.mp4;

import com.drew.lang.SequentialReader;
import com.drew.lang.StreamReader;
import com.drew.lang.annotations.NotNull;
import com.drew.metadata.mp4.boxes.Box;
import java.io.IOException;
import java.io.InputStream;

public class Mp4Reader {
    private Mp4Reader() {
    }

    public static void extract(@NotNull InputStream inputStream, @NotNull Mp4Handler mp4Handler) {
        StreamReader streamReader = new StreamReader(inputStream);
        streamReader.setMotorolaByteOrder(true);
        processBoxes(streamReader, -1, mp4Handler);
    }

    private static void processBoxes(StreamReader streamReader, long j, Mp4Handler mp4Handler) {
        while (true) {
            if (j != -1) {
                try {
                    if (streamReader.getPosition() >= j) {
                        return;
                    }
                } catch (IOException e) {
                    mp4Handler.addError(e.getMessage());
                    return;
                }
            }
            Box box = new Box((SequentialReader) streamReader);
            if (mp4Handler.shouldAcceptContainer(box)) {
                processBoxes(streamReader, (box.size + streamReader.getPosition()) - 8, mp4Handler.processContainer(box));
            } else if (mp4Handler.shouldAcceptBox(box)) {
                mp4Handler = mp4Handler.processBox(box, streamReader.getBytes(((int) box.size) - 8));
            } else if (box.usertype != null) {
                streamReader.skip(box.size - 24);
            } else if (box.size > 1) {
                streamReader.skip(box.size - 8);
            } else if (box.size == -1) {
                return;
            }
        }
    }
}

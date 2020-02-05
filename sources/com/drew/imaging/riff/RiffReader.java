package com.drew.imaging.riff;

import com.drew.lang.SequentialReader;
import com.drew.lang.annotations.NotNull;
import java.io.IOException;

public class RiffReader {
    public void processRiff(@NotNull SequentialReader sequentialReader, @NotNull RiffHandler riffHandler) throws RiffProcessingException, IOException {
        sequentialReader.setMotorolaByteOrder(false);
        String string = sequentialReader.getString(4);
        if (string.equals("RIFF")) {
            int int32 = sequentialReader.getInt32() - 4;
            if (riffHandler.shouldAcceptRiffIdentifier(sequentialReader.getString(4))) {
                processChunks(sequentialReader, int32, riffHandler);
                return;
            }
            return;
        }
        throw new RiffProcessingException("Invalid RIFF header: " + string);
    }

    public void processChunks(SequentialReader sequentialReader, int i, RiffHandler riffHandler) throws IOException {
        while (sequentialReader.getPosition() < ((long) i)) {
            String str = new String(sequentialReader.getBytes(4));
            int int32 = sequentialReader.getInt32();
            if (!str.equals("LIST") && !str.equals("RIFF")) {
                if (riffHandler.shouldAcceptChunk(str)) {
                    riffHandler.processChunk(str, sequentialReader.getBytes(int32));
                } else {
                    sequentialReader.skip((long) int32);
                }
                if (int32 % 2 == 1) {
                    sequentialReader.skip(1);
                }
            } else if (riffHandler.shouldAcceptList(new String(sequentialReader.getBytes(4)))) {
                processChunks(sequentialReader, int32 - 4, riffHandler);
            } else {
                sequentialReader.skip((long) (int32 - 4));
            }
        }
    }
}

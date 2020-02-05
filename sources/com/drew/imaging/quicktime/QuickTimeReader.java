package com.drew.imaging.quicktime;

import com.drew.lang.SequentialReader;
import com.drew.lang.StreamReader;
import com.drew.lang.annotations.NotNull;
import com.drew.metadata.mov.atoms.Atom;
import java.io.IOException;
import java.io.InputStream;

public class QuickTimeReader {
    private QuickTimeReader() {
    }

    public static void extract(@NotNull InputStream inputStream, @NotNull QuickTimeHandler quickTimeHandler) {
        StreamReader streamReader = new StreamReader(inputStream);
        streamReader.setMotorolaByteOrder(true);
        processAtoms(streamReader, -1, quickTimeHandler);
    }

    private static void processAtoms(StreamReader streamReader, long j, QuickTimeHandler quickTimeHandler) {
        while (true) {
            if (j != -1) {
                try {
                    if (streamReader.getPosition() >= j) {
                        return;
                    }
                } catch (IOException e) {
                    quickTimeHandler.addError(e.getMessage());
                    return;
                }
            }
            Atom atom = new Atom((SequentialReader) streamReader);
            if (quickTimeHandler.shouldAcceptContainer(atom)) {
                processAtoms(streamReader, (atom.size + streamReader.getPosition()) - 8, quickTimeHandler.processContainer(atom));
            } else if (quickTimeHandler.shouldAcceptAtom(atom)) {
                quickTimeHandler = quickTimeHandler.processAtom(atom, streamReader.getBytes(((int) atom.size) - 8));
            } else if (atom.size > 1) {
                streamReader.skip(atom.size - 8);
            } else if (atom.size == -1) {
                return;
            }
        }
    }
}

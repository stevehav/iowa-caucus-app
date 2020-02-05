package com.drew.metadata.mov;

import com.drew.imaging.quicktime.QuickTimeHandler;
import com.drew.lang.SequentialByteArrayReader;
import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.Metadata;
import com.drew.metadata.mov.atoms.Atom;
import com.drew.metadata.mov.atoms.FileTypeCompatibilityAtom;
import com.drew.metadata.mov.atoms.HandlerReferenceAtom;
import com.drew.metadata.mov.atoms.MediaHeaderAtom;
import com.drew.metadata.mov.atoms.MovieHeaderAtom;
import java.io.IOException;

public class QuickTimeAtomHandler extends QuickTimeHandler<QuickTimeDirectory> {
    private QuickTimeHandlerFactory handlerFactory = new QuickTimeHandlerFactory(this);

    public QuickTimeAtomHandler(Metadata metadata) {
        super(metadata);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public QuickTimeDirectory getDirectory() {
        return new QuickTimeDirectory();
    }

    public boolean shouldAcceptAtom(@NotNull Atom atom) {
        return atom.type.equals("ftyp") || atom.type.equals("mvhd") || atom.type.equals("hdlr") || atom.type.equals("mdhd");
    }

    public boolean shouldAcceptContainer(@NotNull Atom atom) {
        return atom.type.equals("trak") || atom.type.equals("udta") || atom.type.equals("meta") || atom.type.equals("moov") || atom.type.equals("mdia");
    }

    public QuickTimeHandler processAtom(@NotNull Atom atom, @Nullable byte[] bArr) throws IOException {
        if (bArr != null) {
            SequentialByteArrayReader sequentialByteArrayReader = new SequentialByteArrayReader(bArr);
            if (atom.type.equals("mvhd")) {
                new MovieHeaderAtom(sequentialByteArrayReader, atom).addMetadata(this.directory);
            } else if (atom.type.equals("ftyp")) {
                new FileTypeCompatibilityAtom(sequentialByteArrayReader, atom).addMetadata(this.directory);
            } else if (atom.type.equals("hdlr")) {
                return this.handlerFactory.getHandler(new HandlerReferenceAtom(sequentialByteArrayReader, atom).getComponentType(), this.metadata);
            } else if (atom.type.equals("mdhd")) {
                new MediaHeaderAtom(sequentialByteArrayReader, atom);
            }
        } else if (atom.type.equals("cmov")) {
            this.directory.addError("Compressed QuickTime movies not supported");
        }
        return this;
    }
}

package com.drew.metadata.mov.media;

import com.drew.lang.SequentialReader;
import com.drew.lang.annotations.NotNull;
import com.drew.metadata.Metadata;
import com.drew.metadata.mov.QuickTimeMediaHandler;
import com.drew.metadata.mov.atoms.Atom;
import com.drew.metadata.mov.atoms.TextSampleDescriptionAtom;
import java.io.IOException;

public class QuickTimeTextHandler extends QuickTimeMediaHandler<QuickTimeTextDirectory> {
    /* access modifiers changed from: protected */
    public String getMediaInformation() {
        return "gmhd";
    }

    /* access modifiers changed from: protected */
    public void processMediaInformation(@NotNull SequentialReader sequentialReader, @NotNull Atom atom) throws IOException {
    }

    /* access modifiers changed from: protected */
    public void processTimeToSample(@NotNull SequentialReader sequentialReader, @NotNull Atom atom) throws IOException {
    }

    public QuickTimeTextHandler(Metadata metadata) {
        super(metadata);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public QuickTimeTextDirectory getDirectory() {
        return new QuickTimeTextDirectory();
    }

    /* access modifiers changed from: protected */
    public void processSampleDescription(@NotNull SequentialReader sequentialReader, @NotNull Atom atom) throws IOException {
        new TextSampleDescriptionAtom(sequentialReader, atom).addMetadata((QuickTimeTextDirectory) this.directory);
    }
}

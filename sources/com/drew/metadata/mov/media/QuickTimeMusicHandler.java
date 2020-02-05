package com.drew.metadata.mov.media;

import com.drew.lang.SequentialReader;
import com.drew.lang.annotations.NotNull;
import com.drew.metadata.Metadata;
import com.drew.metadata.mov.QuickTimeMediaHandler;
import com.drew.metadata.mov.atoms.Atom;
import com.drew.metadata.mov.atoms.MusicSampleDescriptionAtom;
import java.io.IOException;

public class QuickTimeMusicHandler extends QuickTimeMediaHandler<QuickTimeMusicDirectory> {
    /* access modifiers changed from: protected */
    public String getMediaInformation() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void processMediaInformation(@NotNull SequentialReader sequentialReader, @NotNull Atom atom) throws IOException {
    }

    /* access modifiers changed from: protected */
    public void processTimeToSample(@NotNull SequentialReader sequentialReader, @NotNull Atom atom) throws IOException {
    }

    public QuickTimeMusicHandler(Metadata metadata) {
        super(metadata);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public QuickTimeMusicDirectory getDirectory() {
        return (QuickTimeMusicDirectory) this.directory;
    }

    /* access modifiers changed from: protected */
    public void processSampleDescription(@NotNull SequentialReader sequentialReader, @NotNull Atom atom) throws IOException {
        new MusicSampleDescriptionAtom(sequentialReader, atom).addMetadata((QuickTimeMusicDirectory) this.directory);
    }
}

package com.drew.metadata.mov.media;

import com.drew.lang.SequentialReader;
import com.drew.lang.annotations.NotNull;
import com.drew.metadata.Metadata;
import com.drew.metadata.mov.QuickTimeHandlerFactory;
import com.drew.metadata.mov.QuickTimeMediaHandler;
import com.drew.metadata.mov.atoms.Atom;
import com.drew.metadata.mov.atoms.SoundInformationMediaHeaderAtom;
import com.drew.metadata.mov.atoms.SoundSampleDescriptionAtom;
import java.io.IOException;

public class QuickTimeSoundHandler extends QuickTimeMediaHandler<QuickTimeSoundDirectory> {
    /* access modifiers changed from: protected */
    public String getMediaInformation() {
        return "smhd";
    }

    public QuickTimeSoundHandler(Metadata metadata) {
        super(metadata);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public QuickTimeSoundDirectory getDirectory() {
        return new QuickTimeSoundDirectory();
    }

    public void processSampleDescription(@NotNull SequentialReader sequentialReader, @NotNull Atom atom) throws IOException {
        new SoundSampleDescriptionAtom(sequentialReader, atom).addMetadata((QuickTimeSoundDirectory) this.directory);
    }

    public void processMediaInformation(@NotNull SequentialReader sequentialReader, @NotNull Atom atom) throws IOException {
        new SoundInformationMediaHeaderAtom(sequentialReader, atom).addMetadata((QuickTimeSoundDirectory) this.directory);
    }

    /* access modifiers changed from: protected */
    public void processTimeToSample(@NotNull SequentialReader sequentialReader, @NotNull Atom atom) throws IOException {
        ((QuickTimeSoundDirectory) this.directory).setDouble(772, (double) QuickTimeHandlerFactory.HANDLER_PARAM_TIME_SCALE.longValue());
    }
}

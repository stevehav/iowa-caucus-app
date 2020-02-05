package com.drew.imaging.quicktime;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.Metadata;
import com.drew.metadata.mov.QuickTimeDirectory;
import com.drew.metadata.mov.atoms.Atom;
import java.io.IOException;

public abstract class QuickTimeHandler<T extends QuickTimeDirectory> {
    @NotNull
    protected T directory = getDirectory();
    @NotNull
    protected Metadata metadata;

    /* access modifiers changed from: protected */
    @NotNull
    public abstract T getDirectory();

    /* access modifiers changed from: protected */
    public abstract QuickTimeHandler processAtom(@NotNull Atom atom, @Nullable byte[] bArr) throws IOException;

    /* access modifiers changed from: protected */
    public abstract boolean shouldAcceptAtom(@NotNull Atom atom);

    /* access modifiers changed from: protected */
    public abstract boolean shouldAcceptContainer(@NotNull Atom atom);

    public QuickTimeHandler(@NotNull Metadata metadata2) {
        this.metadata = metadata2;
        metadata2.addDirectory(this.directory);
    }

    /* access modifiers changed from: protected */
    public QuickTimeHandler processContainer(@NotNull Atom atom) throws IOException {
        return processAtom(atom, (byte[]) null);
    }

    public void addError(@NotNull String str) {
        this.directory.addError(str);
    }
}

package com.drew.imaging.mp4;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.Metadata;
import com.drew.metadata.mp4.Mp4Directory;
import com.drew.metadata.mp4.boxes.Box;
import java.io.IOException;

public abstract class Mp4Handler<T extends Mp4Directory> {
    @NotNull
    protected T directory = getDirectory();
    @NotNull
    protected Metadata metadata;

    /* access modifiers changed from: protected */
    @NotNull
    public abstract T getDirectory();

    /* access modifiers changed from: protected */
    public abstract Mp4Handler processBox(@NotNull Box box, @Nullable byte[] bArr) throws IOException;

    /* access modifiers changed from: protected */
    public abstract boolean shouldAcceptBox(@NotNull Box box);

    /* access modifiers changed from: protected */
    public abstract boolean shouldAcceptContainer(@NotNull Box box);

    public Mp4Handler(@NotNull Metadata metadata2) {
        this.metadata = metadata2;
        metadata2.addDirectory(this.directory);
    }

    /* access modifiers changed from: protected */
    public Mp4Handler processContainer(@NotNull Box box) throws IOException {
        return processBox(box, (byte[]) null);
    }

    public void addError(@NotNull String str) {
        this.directory.addError(str);
    }
}

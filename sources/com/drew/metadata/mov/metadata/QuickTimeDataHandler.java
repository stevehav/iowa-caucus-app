package com.drew.metadata.mov.metadata;

import com.drew.imaging.quicktime.QuickTimeHandler;
import com.drew.lang.ByteUtil;
import com.drew.lang.SequentialByteArrayReader;
import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.Metadata;
import com.drew.metadata.mov.QuickTimeAtomTypes;
import com.drew.metadata.mov.QuickTimeMetadataHandler;
import com.drew.metadata.mov.atoms.Atom;
import java.io.IOException;
import java.util.ArrayList;

public class QuickTimeDataHandler extends QuickTimeMetadataHandler {
    private int currentIndex = 0;
    private ArrayList<String> keys = new ArrayList<>();

    public QuickTimeDataHandler(Metadata metadata) {
        super(metadata);
    }

    /* access modifiers changed from: protected */
    public boolean shouldAcceptAtom(@NotNull Atom atom) {
        return atom.type.equals("hdlr") || atom.type.equals(QuickTimeAtomTypes.ATOM_KEYS) || atom.type.equals("data");
    }

    /* access modifiers changed from: protected */
    public boolean shouldAcceptContainer(@NotNull Atom atom) {
        return atom.type.equals("ilst") || ByteUtil.getInt32(atom.type.getBytes(), 0, true) <= this.keys.size();
    }

    /* access modifiers changed from: protected */
    public QuickTimeHandler processAtom(@NotNull Atom atom, @Nullable byte[] bArr) throws IOException {
        if (bArr != null) {
            SequentialByteArrayReader sequentialByteArrayReader = new SequentialByteArrayReader(bArr);
            if (atom.type.equals(QuickTimeAtomTypes.ATOM_KEYS)) {
                processKeys(sequentialByteArrayReader);
            } else if (atom.type.equals("data")) {
                processData(bArr, sequentialByteArrayReader);
            }
        } else {
            int int32 = ByteUtil.getInt32(atom.type.getBytes(), 0, true);
            if (int32 > 0 && int32 < this.keys.size() + 1) {
                this.currentIndex = int32 - 1;
            }
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void processKeys(@NotNull SequentialByteArrayReader sequentialByteArrayReader) throws IOException {
        sequentialByteArrayReader.skip(4);
        int int32 = sequentialByteArrayReader.getInt32();
        for (int i = 0; i < int32; i++) {
            int int322 = sequentialByteArrayReader.getInt32();
            sequentialByteArrayReader.skip(4);
            this.keys.add(new String(sequentialByteArrayReader.getBytes(int322 - 8)));
        }
    }

    /* access modifiers changed from: protected */
    public void processData(@NotNull byte[] bArr, @NotNull SequentialByteArrayReader sequentialByteArrayReader) throws IOException {
        sequentialByteArrayReader.skip(8);
        this.directory.setString(QuickTimeMetadataDirectory._tagIntegerMap.get(this.keys.get(this.currentIndex)).intValue(), new String(sequentialByteArrayReader.getBytes(bArr.length - 8)));
    }
}

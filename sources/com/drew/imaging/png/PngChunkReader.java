package com.drew.imaging.png;

import com.drew.lang.SequentialReader;
import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PngChunkReader {
    private static final byte[] PNG_SIGNATURE_BYTES = {-119, 80, 78, 71, Ascii.CR, 10, Ascii.SUB, 10};

    public Iterable<PngChunk> extract(@NotNull SequentialReader sequentialReader, @Nullable Set<PngChunkType> set) throws PngProcessingException, IOException {
        sequentialReader.setMotorolaByteOrder(true);
        byte[] bArr = PNG_SIGNATURE_BYTES;
        if (Arrays.equals(bArr, sequentialReader.getBytes(bArr.length))) {
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                int int32 = sequentialReader.getInt32();
                if (int32 >= 0) {
                    PngChunkType pngChunkType = new PngChunkType(sequentialReader.getBytes(4));
                    boolean z3 = set == null || set.contains(pngChunkType);
                    byte[] bytes = sequentialReader.getBytes(int32);
                    sequentialReader.skip(4);
                    if (!z3 || !hashSet.contains(pngChunkType) || pngChunkType.areMultipleAllowed()) {
                        if (pngChunkType.equals(PngChunkType.IHDR)) {
                            z2 = true;
                        } else if (!z2) {
                            throw new PngProcessingException(String.format("First chunk should be '%s', but '%s' was observed", new Object[]{PngChunkType.IHDR, pngChunkType}));
                        }
                        if (pngChunkType.equals(PngChunkType.IEND)) {
                            z = true;
                        }
                        if (z3) {
                            arrayList.add(new PngChunk(pngChunkType, bytes));
                        }
                        hashSet.add(pngChunkType);
                    } else {
                        throw new PngProcessingException(String.format("Observed multiple instances of PNG chunk '%s', for which multiples are not allowed", new Object[]{pngChunkType}));
                    }
                } else {
                    throw new PngProcessingException("PNG chunk length exceeds maximum");
                }
            }
            return arrayList;
        }
        throw new PngProcessingException("PNG signature mismatch");
    }
}

package com.drew.metadata.wav;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.TagDescriptor;

public class WavDescriptor extends TagDescriptor<WavDirectory> {
    public WavDescriptor(@NotNull WavDirectory wavDirectory) {
        super(wavDirectory);
    }

    @Nullable
    public String getDescription(int i) {
        return super.getDescription(i);
    }
}

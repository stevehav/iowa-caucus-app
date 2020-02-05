package com.drew.metadata;

import com.drew.lang.CompoundException;
import com.drew.lang.annotations.Nullable;

public class MetadataException extends CompoundException {
    private static final long serialVersionUID = 8612756143363919682L;

    public MetadataException(@Nullable String str) {
        super(str);
    }

    public MetadataException(@Nullable Throwable th) {
        super(th);
    }

    public MetadataException(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }
}

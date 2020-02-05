package com.drew.metadata.mov.metadata;

import com.drew.metadata.mov.QuickTimeDescriptor;
import com.drew.metadata.mov.QuickTimeDirectory;

public class QuickTimeMetadataDescriptor extends QuickTimeDescriptor {
    public QuickTimeMetadataDescriptor(QuickTimeDirectory quickTimeDirectory) {
        super(quickTimeDirectory);
    }

    public String getDescription(int i) {
        return super.getDescription(i);
    }
}

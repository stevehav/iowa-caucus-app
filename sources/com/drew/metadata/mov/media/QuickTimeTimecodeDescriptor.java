package com.drew.metadata.mov.media;

import com.drew.metadata.mov.QuickTimeDescriptor;
import com.drew.metadata.mov.QuickTimeDirectory;

public class QuickTimeTimecodeDescriptor extends QuickTimeDescriptor {
    public QuickTimeTimecodeDescriptor(QuickTimeDirectory quickTimeDirectory) {
        super(quickTimeDirectory);
    }
}

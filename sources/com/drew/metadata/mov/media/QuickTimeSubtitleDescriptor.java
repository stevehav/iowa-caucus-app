package com.drew.metadata.mov.media;

import com.drew.metadata.mov.QuickTimeDescriptor;
import com.drew.metadata.mov.QuickTimeDirectory;

public class QuickTimeSubtitleDescriptor extends QuickTimeDescriptor {
    public QuickTimeSubtitleDescriptor(QuickTimeDirectory quickTimeDirectory) {
        super(quickTimeDirectory);
    }
}

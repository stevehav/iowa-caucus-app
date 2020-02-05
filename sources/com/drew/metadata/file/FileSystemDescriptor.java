package com.drew.metadata.file;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.TagDescriptor;

public class FileSystemDescriptor extends TagDescriptor<FileSystemDirectory> {
    public FileSystemDescriptor(@NotNull FileSystemDirectory fileSystemDirectory) {
        super(fileSystemDirectory);
    }

    @Nullable
    public String getDescription(int i) {
        if (i != 2) {
            return super.getDescription(i);
        }
        return getFileSizeDescription();
    }

    @Nullable
    private String getFileSizeDescription() {
        Long longObject = ((FileSystemDirectory) this._directory).getLongObject(2);
        if (longObject == null) {
            return null;
        }
        return Long.toString(longObject.longValue()) + " bytes";
    }
}

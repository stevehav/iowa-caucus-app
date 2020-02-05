package com.drew.metadata.file;

import com.drew.lang.annotations.NotNull;
import com.drew.metadata.TagDescriptor;

public class FileTypeDescriptor extends TagDescriptor<FileTypeDirectory> {
    public FileTypeDescriptor(@NotNull FileTypeDirectory fileTypeDirectory) {
        super(fileTypeDirectory);
    }
}

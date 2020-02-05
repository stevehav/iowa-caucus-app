package com.drew.metadata.mov.atoms;

import com.drew.lang.SequentialReader;
import java.io.IOException;

public class HandlerReferenceAtom extends FullAtom {
    String componentName;
    String componentSubtype;
    String componentType;

    public String getComponentType() {
        return this.componentSubtype;
    }

    public HandlerReferenceAtom(SequentialReader sequentialReader, Atom atom) throws IOException {
        super(sequentialReader, atom);
        this.componentType = sequentialReader.getString(4);
        this.componentSubtype = sequentialReader.getString(4);
        sequentialReader.skip(4);
        sequentialReader.skip(4);
        sequentialReader.skip(4);
        this.componentName = sequentialReader.getString(sequentialReader.getUInt8());
    }
}

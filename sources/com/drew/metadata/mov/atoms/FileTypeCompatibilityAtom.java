package com.drew.metadata.mov.atoms;

import com.drew.lang.SequentialReader;
import com.drew.metadata.mov.QuickTimeDirectory;
import java.io.IOException;
import java.util.ArrayList;

public class FileTypeCompatibilityAtom extends Atom {
    ArrayList<String> compatibleBrands = new ArrayList<>((int) ((this.size / 16) >> 2));
    String majorBrand;
    long minorVersion;

    public FileTypeCompatibilityAtom(SequentialReader sequentialReader, Atom atom) throws IOException {
        super(atom);
        this.majorBrand = sequentialReader.getString(4);
        this.minorVersion = sequentialReader.getUInt32();
        for (int i = 16; ((long) i) < this.size; i += 4) {
            this.compatibleBrands.add(sequentialReader.getString(4));
        }
    }

    public void addMetadata(QuickTimeDirectory quickTimeDirectory) {
        quickTimeDirectory.setString(4096, this.majorBrand);
        quickTimeDirectory.setLong(4097, this.minorVersion);
        ArrayList<String> arrayList = this.compatibleBrands;
        quickTimeDirectory.setStringArray(4098, (String[]) arrayList.toArray(new String[arrayList.size()]));
    }
}

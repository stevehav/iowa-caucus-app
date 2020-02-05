package com.drew.metadata.mp4.boxes;

import com.drew.lang.SequentialReader;
import com.drew.metadata.mp4.Mp4Directory;
import java.io.IOException;
import java.util.ArrayList;

public class FileTypeBox extends Box {
    ArrayList<String> compatibleBrands = new ArrayList<>();
    String majorBrand;
    long minorVersion;

    public FileTypeBox(SequentialReader sequentialReader, Box box) throws IOException {
        super(box);
        this.majorBrand = sequentialReader.getString(4);
        this.minorVersion = sequentialReader.getUInt32();
        for (int i = 16; ((long) i) < this.size; i += 4) {
            this.compatibleBrands.add(sequentialReader.getString(4));
        }
    }

    public void addMetadata(Mp4Directory mp4Directory) {
        mp4Directory.setString(1, this.majorBrand);
        mp4Directory.setLong(2, this.minorVersion);
        ArrayList<String> arrayList = this.compatibleBrands;
        mp4Directory.setStringArray(3, (String[]) arrayList.toArray(new String[arrayList.size()]));
    }
}

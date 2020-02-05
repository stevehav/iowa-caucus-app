package com.drew.metadata.mov.atoms;

import com.drew.lang.SequentialReader;
import com.drew.metadata.mov.media.QuickTimeTimecodeDirectory;
import java.io.IOException;

public class TimecodeInformationMediaAtom extends FullAtom {
    int[] backgroundColor;
    String fontName;
    int[] textColor;
    int textFace;
    int textFont;
    int textSize;

    public TimecodeInformationMediaAtom(SequentialReader sequentialReader, Atom atom) throws IOException {
        super(sequentialReader, atom);
        this.textFont = sequentialReader.getInt16();
        this.textFace = sequentialReader.getInt16();
        this.textSize = sequentialReader.getInt16();
        sequentialReader.skip(2);
        this.textColor = new int[]{sequentialReader.getUInt16(), sequentialReader.getUInt16(), sequentialReader.getUInt16()};
        this.backgroundColor = new int[]{sequentialReader.getUInt16(), sequentialReader.getUInt16(), sequentialReader.getUInt16()};
        this.fontName = sequentialReader.getString(sequentialReader.getUInt8());
    }

    public void addMetadata(QuickTimeTimecodeDirectory quickTimeTimecodeDirectory) {
        quickTimeTimecodeDirectory.setInt(5, this.textFont);
        int i = this.textFace;
        if (i == 1) {
            quickTimeTimecodeDirectory.setString(6, "Bold");
        } else if (i == 2) {
            quickTimeTimecodeDirectory.setString(6, "Italic");
        } else if (i == 4) {
            quickTimeTimecodeDirectory.setString(6, "Underline");
        } else if (i == 8) {
            quickTimeTimecodeDirectory.setString(6, "Outline");
        } else if (i == 16) {
            quickTimeTimecodeDirectory.setString(6, "Shadow");
        } else if (i == 32) {
            quickTimeTimecodeDirectory.setString(6, "Condense");
        } else if (i == 64) {
            quickTimeTimecodeDirectory.setString(6, "Extend");
        }
        quickTimeTimecodeDirectory.setInt(7, this.textSize);
        quickTimeTimecodeDirectory.setIntArray(8, this.textColor);
        quickTimeTimecodeDirectory.setIntArray(9, this.backgroundColor);
        quickTimeTimecodeDirectory.setString(10, this.fontName);
    }
}

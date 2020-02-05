package com.drew.metadata.mov.atoms;

import com.drew.lang.SequentialReader;
import com.drew.metadata.mov.media.QuickTimeTextDirectory;
import java.io.IOException;

public class TextSampleDescriptionAtom extends SampleDescriptionAtom<TextSampleDescription> {
    public TextSampleDescriptionAtom(SequentialReader sequentialReader, Atom atom) throws IOException {
        super(sequentialReader, atom);
    }

    /* access modifiers changed from: package-private */
    public TextSampleDescription getSampleDescription(SequentialReader sequentialReader) throws IOException {
        return new TextSampleDescription(sequentialReader);
    }

    public void addMetadata(QuickTimeTextDirectory quickTimeTextDirectory) {
        boolean z = false;
        TextSampleDescription textSampleDescription = (TextSampleDescription) this.sampleDescriptions.get(0);
        quickTimeTextDirectory.setBoolean(1, (textSampleDescription.displayFlags & 2) == 2);
        quickTimeTextDirectory.setBoolean(2, (textSampleDescription.displayFlags & 8) == 8);
        quickTimeTextDirectory.setBoolean(3, (textSampleDescription.displayFlags & 32) == 32);
        quickTimeTextDirectory.setBoolean(4, (textSampleDescription.displayFlags & 64) == 64);
        quickTimeTextDirectory.setString(5, (textSampleDescription.displayFlags & 128) == 128 ? "Horizontal" : "Vertical");
        quickTimeTextDirectory.setString(6, (textSampleDescription.displayFlags & 256) == 256 ? "Reverse" : "Normal");
        quickTimeTextDirectory.setBoolean(7, (textSampleDescription.displayFlags & 512) == 512);
        quickTimeTextDirectory.setBoolean(8, (textSampleDescription.displayFlags & 4096) == 4096);
        quickTimeTextDirectory.setBoolean(9, (textSampleDescription.displayFlags & 8192) == 8192);
        if ((textSampleDescription.displayFlags & 16384) == 16384) {
            z = true;
        }
        quickTimeTextDirectory.setBoolean(10, z);
        int i = textSampleDescription.textJustification;
        if (i == -1) {
            quickTimeTextDirectory.setString(11, "Right");
        } else if (i == 0) {
            quickTimeTextDirectory.setString(11, "Left");
        } else if (i == 1) {
            quickTimeTextDirectory.setString(11, "Center");
        }
        quickTimeTextDirectory.setIntArray(12, textSampleDescription.backgroundColor);
        quickTimeTextDirectory.setLong(13, textSampleDescription.defaultTextBox);
        quickTimeTextDirectory.setInt(14, textSampleDescription.fontNumber);
        int i2 = textSampleDescription.fontFace;
        if (i2 == 1) {
            quickTimeTextDirectory.setString(15, "Bold");
        } else if (i2 == 2) {
            quickTimeTextDirectory.setString(15, "Italic");
        } else if (i2 == 4) {
            quickTimeTextDirectory.setString(15, "Underline");
        } else if (i2 == 8) {
            quickTimeTextDirectory.setString(15, "Outline");
        } else if (i2 == 16) {
            quickTimeTextDirectory.setString(15, "Shadow");
        } else if (i2 == 32) {
            quickTimeTextDirectory.setString(15, "Condense");
        } else if (i2 == 64) {
            quickTimeTextDirectory.setString(15, "Extend");
        }
        quickTimeTextDirectory.setIntArray(16, textSampleDescription.foregroundColor);
        quickTimeTextDirectory.setString(17, textSampleDescription.textName);
    }

    class TextSampleDescription extends SampleDescription {
        int[] backgroundColor;
        long defaultTextBox;
        int displayFlags;
        int fontFace;
        int fontNumber;
        int[] foregroundColor;
        int textJustification;
        String textName;

        public TextSampleDescription(SequentialReader sequentialReader) throws IOException {
            super(sequentialReader);
            this.displayFlags = sequentialReader.getInt32();
            this.textJustification = sequentialReader.getInt32();
            this.backgroundColor = new int[]{sequentialReader.getUInt16(), sequentialReader.getUInt16(), sequentialReader.getUInt16()};
            this.defaultTextBox = sequentialReader.getInt64();
            sequentialReader.skip(8);
            this.fontNumber = sequentialReader.getUInt16();
            this.fontFace = sequentialReader.getUInt16();
            sequentialReader.skip(1);
            sequentialReader.skip(2);
            this.foregroundColor = new int[]{sequentialReader.getUInt16(), sequentialReader.getUInt16(), sequentialReader.getUInt16()};
            this.textName = sequentialReader.getString(sequentialReader.getUInt8());
        }
    }
}

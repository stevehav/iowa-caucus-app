package com.drew.metadata.mp4;

import com.drew.lang.annotations.NotNull;
import com.drew.metadata.Directory;
import com.drew.metadata.TagDescriptor;
import java.util.ArrayList;
import java.util.Arrays;

public class Mp4Descriptor<T extends Directory> extends TagDescriptor<Mp4Directory> {
    public Mp4Descriptor(@NotNull Mp4Directory mp4Directory) {
        super(mp4Directory);
    }

    public String getDescription(int i) {
        if (i == 1) {
            return getMajorBrandDescription();
        }
        if (i == 3) {
            return getCompatibleBrandsDescription();
        }
        if (i != 259) {
            return ((Mp4Directory) this._directory).getString(i);
        }
        return getDurationDescription();
    }

    private String getMajorBrandDescription() {
        byte[] byteArray = ((Mp4Directory) this._directory).getByteArray(1);
        if (byteArray == null) {
            return null;
        }
        return Mp4Dictionary.lookup(1, new String(byteArray));
    }

    private String getCompatibleBrandsDescription() {
        String[] stringArray = ((Mp4Directory) this._directory).getStringArray(3);
        if (stringArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : stringArray) {
            String lookup = Mp4Dictionary.lookup(1, str);
            if (lookup != null) {
                str = lookup;
            }
            arrayList.add(str);
        }
        return Arrays.toString(arrayList.toArray());
    }

    private String getDurationDescription() {
        Long longObject = ((Mp4Directory) this._directory).getLongObject(259);
        if (longObject == null) {
            return null;
        }
        double longValue = (double) longObject.longValue();
        double pow = Math.pow(60.0d, 2.0d);
        Double.isNaN(longValue);
        Integer valueOf = Integer.valueOf((int) (longValue / pow));
        double longValue2 = (double) longObject.longValue();
        double pow2 = Math.pow(60.0d, 1.0d);
        Double.isNaN(longValue2);
        double d = longValue2 / pow2;
        double intValue = (double) (valueOf.intValue() * 60);
        Double.isNaN(intValue);
        Integer valueOf2 = Integer.valueOf((int) (d - intValue));
        double longValue3 = (double) longObject.longValue();
        double pow3 = Math.pow(60.0d, 0.0d);
        Double.isNaN(longValue3);
        double d2 = longValue3 / pow3;
        double intValue2 = (double) (valueOf2.intValue() * 60);
        Double.isNaN(intValue2);
        return String.format("%1$02d:%2$02d:%3$02d", new Object[]{valueOf, valueOf2, Integer.valueOf((int) Math.ceil(d2 - intValue2))});
    }
}

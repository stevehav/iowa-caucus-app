package com.drew.metadata.mov;

import com.drew.lang.annotations.NotNull;
import com.drew.metadata.TagDescriptor;
import java.util.ArrayList;
import java.util.Arrays;

public class QuickTimeDescriptor extends TagDescriptor<QuickTimeDirectory> {
    public QuickTimeDescriptor(@NotNull QuickTimeDirectory quickTimeDirectory) {
        super(quickTimeDirectory);
    }

    public String getDescription(int i) {
        if (i == 259) {
            return getDurationDescription();
        }
        if (i == 4096) {
            return getMajorBrandDescription();
        }
        if (i != 4098) {
            return super.getDescription(i);
        }
        return getCompatibleBrandsDescription();
    }

    private String getMajorBrandDescription() {
        byte[] byteArray = ((QuickTimeDirectory) this._directory).getByteArray(4096);
        if (byteArray == null) {
            return null;
        }
        return QuickTimeDictionary.lookup(4096, new String(byteArray));
    }

    private String getCompatibleBrandsDescription() {
        String[] stringArray = ((QuickTimeDirectory) this._directory).getStringArray(4098);
        if (stringArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : stringArray) {
            String lookup = QuickTimeDictionary.lookup(4096, str);
            if (lookup != null) {
                str = lookup;
            }
            arrayList.add(str);
        }
        return Arrays.toString(arrayList.toArray());
    }

    private String getDurationDescription() {
        Long longObject = ((QuickTimeDirectory) this._directory).getLongObject(259);
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

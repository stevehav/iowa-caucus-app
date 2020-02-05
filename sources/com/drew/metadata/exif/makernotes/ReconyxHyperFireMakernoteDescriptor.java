package com.drew.metadata.exif.makernotes;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.StringValue;
import com.drew.metadata.TagDescriptor;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ReconyxHyperFireMakernoteDescriptor extends TagDescriptor<ReconyxHyperFireMakernoteDirectory> {
    public ReconyxHyperFireMakernoteDescriptor(@NotNull ReconyxHyperFireMakernoteDirectory reconyxHyperFireMakernoteDirectory) {
        super(reconyxHyperFireMakernoteDirectory);
    }

    @Nullable
    public String getDescription(int i) {
        switch (i) {
            case 0:
                return String.format("%d", new Object[]{((ReconyxHyperFireMakernoteDirectory) this._directory).getInteger(i)});
            case 2:
                return ((ReconyxHyperFireMakernoteDirectory) this._directory).getString(i);
            case 12:
                return ((ReconyxHyperFireMakernoteDirectory) this._directory).getString(i);
            case 14:
                int[] intArray = ((ReconyxHyperFireMakernoteDirectory) this._directory).getIntArray(i);
                if (intArray == null) {
                    return null;
                }
                return String.format("%d/%d", new Object[]{Integer.valueOf(intArray[0]), Integer.valueOf(intArray[1])});
            case 18:
                return String.format("%d", new Object[]{((ReconyxHyperFireMakernoteDirectory) this._directory).getInteger(i)});
            case 22:
                String string = ((ReconyxHyperFireMakernoteDirectory) this._directory).getString(i);
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
                    return simpleDateFormat.format(simpleDateFormat.parse(string));
                } catch (ParseException unused) {
                    return null;
                }
            case 36:
                return getIndexedDescription(i, "New", "Waxing Crescent", "First Quarter", "Waxing Gibbous", "Full", "Waning Gibbous", "Last Quarter", "Waning Crescent");
            case 38:
            case 40:
                return String.format("%d", new Object[]{((ReconyxHyperFireMakernoteDirectory) this._directory).getInteger(i)});
            case 42:
                StringValue stringValue = ((ReconyxHyperFireMakernoteDirectory) this._directory).getStringValue(i);
                if (stringValue == null) {
                    return null;
                }
                return stringValue.toString();
            case 72:
            case 74:
            case 76:
            case 78:
                return String.format("%d", new Object[]{((ReconyxHyperFireMakernoteDirectory) this._directory).getInteger(i)});
            case 80:
                return getIndexedDescription(i, "Off", "On");
            case 82:
                return String.format("%d", new Object[]{((ReconyxHyperFireMakernoteDirectory) this._directory).getInteger(i)});
            case 84:
                Double doubleObject = ((ReconyxHyperFireMakernoteDirectory) this._directory).getDoubleObject(i);
                DecimalFormat decimalFormat = new DecimalFormat("0.000");
                if (doubleObject == null) {
                    return null;
                }
                return decimalFormat.format(doubleObject);
            case 86:
                return ((ReconyxHyperFireMakernoteDirectory) this._directory).getString(i);
            default:
                return super.getDescription(i);
        }
    }
}

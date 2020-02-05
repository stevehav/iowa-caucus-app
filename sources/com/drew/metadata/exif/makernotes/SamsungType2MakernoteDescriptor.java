package com.drew.metadata.exif.makernotes;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.TagDescriptor;

public class SamsungType2MakernoteDescriptor extends TagDescriptor<SamsungType2MakernoteDirectory> {
    public SamsungType2MakernoteDescriptor(@NotNull SamsungType2MakernoteDirectory samsungType2MakernoteDirectory) {
        super(samsungType2MakernoteDirectory);
    }

    @Nullable
    public String getDescription(int i) {
        if (i == 1) {
            return getMakernoteVersionDescription();
        }
        if (i == 2) {
            return getDeviceTypeDescription();
        }
        if (i == 3) {
            return getSamsungModelIdDescription();
        }
        if (i == 67) {
            return getCameraTemperatureDescription();
        }
        if (i == 256) {
            return getFaceDetectDescription();
        }
        if (i != 288) {
            return super.getDescription(i);
        }
        return getFaceRecognitionDescription();
    }

    @Nullable
    public String getMakernoteVersionDescription() {
        return getVersionBytesDescription(1, 2);
    }

    @Nullable
    public String getDeviceTypeDescription() {
        Integer integer = ((SamsungType2MakernoteDirectory) this._directory).getInteger(2);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 4096) {
            return "Compact Digital Camera";
        }
        if (intValue == 8192) {
            return "High-end NX Camera";
        }
        if (intValue == 12288) {
            return "HXM Video Camera";
        }
        if (intValue == 73728) {
            return "Cell Phone";
        }
        if (intValue == 3145728) {
            return "SMX Video Camera";
        }
        return String.format("Unknown (%d)", new Object[]{integer});
    }

    @Nullable
    public String getSamsungModelIdDescription() {
        Integer integer = ((SamsungType2MakernoteDirectory) this._directory).getInteger(3);
        if (integer == null) {
            return null;
        }
        switch (integer.intValue()) {
            case 16781340:
                return "NX10";
            case 16781862:
                return "HMX-S15BP";
            case 16781875:
                return "HMX-Q10";
            case 16781876:
                return "HMX-H304";
            case 16782092:
                return "NX100";
            case 16782119:
                return "NX11";
            case 24121422:
                return "ES70, ES71 / VLUU ES70, ES71 / SL600";
            case 24121426:
                return "ES73 / VLUU ES73 / SL605";
            case 24122112:
                return "ES28 / VLUU ES28";
            case 24122115:
                return "ES74,ES75,ES78 / VLUU ES75,ES78";
            case 33558598:
                return "PL150 / VLUU PL150 / TL210 / PL151";
            case 33559313:
                return "PL120,PL121 / VLUU PL120,PL121";
            case 33559317:
                return "PL170,PL171 / VLUUPL170,PL171";
            case 33559326:
                return "PL210, PL211 / VLUU PL210, PL211";
            case 40899351:
                return "PL20,PL21 / VLUU PL20,PL21";
            case 44040219:
                return "WP10 / VLUU WP10 / AQ100";
            case 50331648:
                return "Various Models (0x3000000)";
            case 60817432:
                return "Various Models (0x3a00018)";
            case 67112991:
                return "ST1000 / ST1100 / VLUU ST1000 / CL65";
            case 67112994:
                return "ST550 / VLUU ST550 / TL225";
            case 67112997:
                return "Various Models (0x4001025)";
            case 67113022:
                return "VLUU ST5500, ST5500, CL80";
            case 67113025:
                return "VLUU ST5000, ST5000, TL240";
            case 67113027:
                return "ST70 / VLUU ST70 / ST71";
            case 67113738:
                return "Various Models (0x400130a)";
            case 67113742:
                return "ST90,ST91 / VLUU ST90,ST91";
            case 67113747:
                return "VLUU ST95, ST95";
            case 77594645:
                return "VLUU ST60";
            case 77599579:
                return "ST30, ST65 / VLUU ST65 / ST67";
            case 83886080:
                return "Various Models (0x5000000)";
            case 83890232:
                return "Various Models (0x5001038)";
            case 83890234:
                return "WB650 / VLUU WB650 / WB660";
            case 83890236:
                return "WB600 / VLUU WB600 / WB610";
            case 83891006:
                return "WB150 / WB150F / WB152 / WB152F / WB151";
            case 94371855:
                return "WB5000 / HZ25W";
            case 100667446:
                return "EX1";
            case 117445404:
                return "VLUU SH100, SH100";
            case 655519746:
                return "SMX - C20N";
            default:
                return String.format("Unknown (%d)", new Object[]{integer});
        }
    }

    @Nullable
    private String getCameraTemperatureDescription() {
        return getFormattedInt(67, "%d C");
    }

    @Nullable
    public String getFaceDetectDescription() {
        return getIndexedDescription(256, "Off", "On");
    }

    @Nullable
    public String getFaceRecognitionDescription() {
        return getIndexedDescription(288, "Off", "On");
    }
}

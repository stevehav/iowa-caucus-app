package com.drew.metadata.exif.makernotes;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.TagDescriptor;

public class SanyoMakernoteDescriptor extends TagDescriptor<SanyoMakernoteDirectory> {
    public SanyoMakernoteDescriptor(@NotNull SanyoMakernoteDirectory sanyoMakernoteDirectory) {
        super(sanyoMakernoteDirectory);
    }

    @Nullable
    public String getDescription(int i) {
        if (i == 513) {
            return getSanyoQualityDescription();
        }
        if (i == 514) {
            return getMacroDescription();
        }
        if (i == 516) {
            return getDigitalZoomDescription();
        }
        if (i == 539) {
            return getDigitalZoomOnDescription();
        }
        if (i == 531) {
            return getQuickShotDescription();
        }
        if (i == 532) {
            return getSelfTimerDescription();
        }
        if (i == 548) {
            return getSequenceShotIntervalDescription();
        }
        if (i == 549) {
            return getFlashModeDescription();
        }
        switch (i) {
            case SanyoMakernoteDirectory.TAG_SEQUENTIAL_SHOT /*526*/:
                return getSequentialShotDescription();
            case 527:
                return getWideRangeDescription();
            case 528:
                return getColorAdjustmentModeDescription();
            default:
                switch (i) {
                    case 534:
                        return getVoiceMemoDescription();
                    case SanyoMakernoteDirectory.TAG_RECORD_SHUTTER_RELEASE /*535*/:
                        return getRecordShutterDescription();
                    case SanyoMakernoteDirectory.TAG_FLICKER_REDUCE /*536*/:
                        return getFlickerReduceDescription();
                    case 537:
                        return getOptimalZoomOnDescription();
                    default:
                        switch (i) {
                            case SanyoMakernoteDirectory.TAG_LIGHT_SOURCE_SPECIAL /*541*/:
                                return getLightSourceSpecialDescription();
                            case 542:
                                return getResavedDescription();
                            case SanyoMakernoteDirectory.TAG_SCENE_SELECT /*543*/:
                                return getSceneSelectDescription();
                            default:
                                return super.getDescription(i);
                        }
                }
        }
    }

    @Nullable
    public String getSanyoQualityDescription() {
        Integer integer = ((SanyoMakernoteDirectory) this._directory).getInteger(513);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        switch (intValue) {
            case 0:
                return "Normal/Very Low";
            case 1:
                return "Normal/Low";
            case 2:
                return "Normal/Medium Low";
            case 3:
                return "Normal/Medium";
            case 4:
                return "Normal/Medium High";
            case 5:
                return "Normal/High";
            case 6:
                return "Normal/Very High";
            case 7:
                return "Normal/Super High";
            default:
                switch (intValue) {
                    case 256:
                        return "Fine/Very Low";
                    case 257:
                        return "Fine/Low";
                    case 258:
                        return "Fine/Medium Low";
                    case 259:
                        return "Fine/Medium";
                    case 260:
                        return "Fine/Medium High";
                    case 261:
                        return "Fine/High";
                    case 262:
                        return "Fine/Very High";
                    case 263:
                        return "Fine/Super High";
                    default:
                        switch (intValue) {
                            case 512:
                                return "Super Fine/Very Low";
                            case 513:
                                return "Super Fine/Low";
                            case 514:
                                return "Super Fine/Medium Low";
                            case 515:
                                return "Super Fine/Medium";
                            case 516:
                                return "Super Fine/Medium High";
                            case 517:
                                return "Super Fine/High";
                            case 518:
                                return "Super Fine/Very High";
                            case 519:
                                return "Super Fine/Super High";
                            default:
                                return "Unknown (" + integer + ")";
                        }
                }
        }
    }

    @Nullable
    private String getMacroDescription() {
        return getIndexedDescription(514, "Normal", "Macro", "View", "Manual");
    }

    @Nullable
    private String getDigitalZoomDescription() {
        return getDecimalRational(516, 3);
    }

    @Nullable
    private String getSequentialShotDescription() {
        return getIndexedDescription(SanyoMakernoteDirectory.TAG_SEQUENTIAL_SHOT, "None", "Standard", "Best", "Adjust Exposure");
    }

    @Nullable
    private String getWideRangeDescription() {
        return getIndexedDescription(527, "Off", "On");
    }

    @Nullable
    private String getColorAdjustmentModeDescription() {
        return getIndexedDescription(528, "Off", "On");
    }

    @Nullable
    private String getQuickShotDescription() {
        return getIndexedDescription(531, "Off", "On");
    }

    @Nullable
    private String getSelfTimerDescription() {
        return getIndexedDescription(532, "Off", "On");
    }

    @Nullable
    private String getVoiceMemoDescription() {
        return getIndexedDescription(534, "Off", "On");
    }

    @Nullable
    private String getRecordShutterDescription() {
        return getIndexedDescription(SanyoMakernoteDirectory.TAG_RECORD_SHUTTER_RELEASE, "Record while down", "Press start, press stop");
    }

    @Nullable
    private String getFlickerReduceDescription() {
        return getIndexedDescription(SanyoMakernoteDirectory.TAG_FLICKER_REDUCE, "Off", "On");
    }

    @Nullable
    private String getOptimalZoomOnDescription() {
        return getIndexedDescription(537, "Off", "On");
    }

    @Nullable
    private String getDigitalZoomOnDescription() {
        return getIndexedDescription(539, "Off", "On");
    }

    @Nullable
    private String getLightSourceSpecialDescription() {
        return getIndexedDescription(SanyoMakernoteDirectory.TAG_LIGHT_SOURCE_SPECIAL, "Off", "On");
    }

    @Nullable
    private String getResavedDescription() {
        return getIndexedDescription(542, "No", "Yes");
    }

    @Nullable
    private String getSceneSelectDescription() {
        return getIndexedDescription(SanyoMakernoteDirectory.TAG_SCENE_SELECT, "Off", "Sport", "TV", "Night", "User 1", "User 2", "Lamp");
    }

    @Nullable
    private String getSequenceShotIntervalDescription() {
        return getIndexedDescription(SanyoMakernoteDirectory.TAG_SEQUENCE_SHOT_INTERVAL, "5 frames/sec", "10 frames/sec", "15 frames/sec", "20 frames/sec");
    }

    @Nullable
    private String getFlashModeDescription() {
        return getIndexedDescription(549, "Auto", "Force", "Disabled", "Red eye");
    }
}

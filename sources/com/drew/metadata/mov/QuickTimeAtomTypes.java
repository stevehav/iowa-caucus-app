package com.drew.metadata.mov;

import java.util.ArrayList;

public class QuickTimeAtomTypes {
    public static final String ATOM_BASE_MEDIA_INFO = "gmhd";
    public static final String ATOM_DATA = "data";
    public static final String ATOM_FILE_TYPE = "ftyp";
    public static final String ATOM_HANDLER = "hdlr";
    public static final String ATOM_KEYS = "keys";
    public static final String ATOM_MEDIA_HEADER = "mdhd";
    public static final String ATOM_MOVIE_HEADER = "mvhd";
    public static final String ATOM_SAMPLE_DESCRIPTION = "stsd";
    public static final String ATOM_SOUND_MEDIA_INFO = "smhd";
    public static final String ATOM_TIMECODE_MEDIA_INFO = "tcmi";
    public static final String ATOM_TIME_TO_SAMPLE = "stts";
    public static final String ATOM_VIDEO_MEDIA_INFO = "vmhd";
    public static ArrayList<String> _atomList = new ArrayList<>();

    static {
        _atomList.add("ftyp");
        _atomList.add("mvhd");
        _atomList.add("vmhd");
        _atomList.add("smhd");
        _atomList.add("gmhd");
        _atomList.add(ATOM_TIMECODE_MEDIA_INFO);
        _atomList.add("hdlr");
        _atomList.add(ATOM_KEYS);
        _atomList.add("data");
        _atomList.add("stsd");
        _atomList.add("stts");
        _atomList.add("mdhd");
    }
}

package com.drew.metadata.mov;

import java.util.ArrayList;

public class QuickTimeContainerTypes {
    public static final String ATOM_COMPRESSED_MOVIE = "cmov";
    public static final String ATOM_MEDIA = "mdia";
    public static final String ATOM_MEDIA_BASE = "gmhd";
    public static final String ATOM_MEDIA_INFORMATION = "minf";
    public static final String ATOM_MEDIA_SUBTITLE = "sbtl";
    public static final String ATOM_MEDIA_TEXT = "text";
    public static final String ATOM_METADATA = "meta";
    public static final String ATOM_METADATA_LIST = "ilst";
    public static final String ATOM_MOVIE = "moov";
    public static final String ATOM_SAMPLE_TABLE = "stbl";
    public static final String ATOM_TRACK = "trak";
    public static final String ATOM_USER_DATA = "udta";
    public static ArrayList<String> _containerList = new ArrayList<>();

    static {
        _containerList.add("moov");
        _containerList.add("udta");
        _containerList.add("trak");
        _containerList.add("mdia");
        _containerList.add("minf");
        _containerList.add("stbl");
        _containerList.add("meta");
        _containerList.add("ilst");
        _containerList.add("cmov");
        _containerList.add("text");
        _containerList.add("sbtl");
        _containerList.add("gmhd");
    }
}

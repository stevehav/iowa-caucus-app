package com.drew.metadata.mp4;

import java.util.ArrayList;

public class Mp4ContainerTypes {
    public static final String BOX_COMPRESSED_MOVIE = "cmov";
    public static final String BOX_MEDIA = "mdia";
    public static final String BOX_MEDIA_INFORMATION = "minf";
    public static final String BOX_MEDIA_NULL = "nmhd";
    public static final String BOX_MEDIA_SUBTITLE = "sbtl";
    public static final String BOX_MEDIA_TEXT = "text";
    public static final String BOX_METADATA = "meta";
    public static final String BOX_METADATA_LIST = "ilst";
    public static final String BOX_MOVIE = "moov";
    public static final String BOX_SAMPLE_TABLE = "stbl";
    public static final String BOX_TRACK = "trak";
    public static final String BOX_USER_DATA = "udta";
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
        _containerList.add("nmhd");
    }
}

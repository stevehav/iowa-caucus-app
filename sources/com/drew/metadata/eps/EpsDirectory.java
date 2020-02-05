package com.drew.metadata.eps;

import androidx.exifinterface.media.ExifInterface;
import com.drew.lang.annotations.NotNull;
import com.drew.metadata.Directory;
import java.util.HashMap;

public class EpsDirectory extends Directory {
    public static final int TAG_AUTHOR = 2;
    public static final int TAG_BOUNDING_BOX = 3;
    public static final int TAG_COLOR_TYPE = 30;
    public static final int TAG_CONTINUE_LINE = 36;
    public static final int TAG_COPYRIGHT = 4;
    public static final int TAG_CREATION_DATE = 5;
    public static final int TAG_CREATOR = 6;
    public static final int TAG_DOCUMENT_DATA = 16;
    public static final int TAG_DSC_VERSION = 1;
    public static final int TAG_EMULATION = 17;
    public static final int TAG_EXTENSIONS = 18;
    public static final int TAG_FOR = 7;
    public static final int TAG_IMAGE_DATA = 8;
    public static final int TAG_IMAGE_HEIGHT = 29;
    public static final int TAG_IMAGE_WIDTH = 28;
    public static final int TAG_KEYWORDS = 9;
    public static final int TAG_LANGUAGE_LEVEL = 19;
    public static final int TAG_MODIFY_DATE = 10;
    public static final int TAG_OPERATOR_INTERNVENTION = 22;
    public static final int TAG_OPERATOR_MESSAGE = 23;
    public static final int TAG_ORIENTATION = 20;
    public static final int TAG_PAGES = 11;
    public static final int TAG_PAGE_ORDER = 21;
    public static final int TAG_PROOF_MODE = 24;
    public static final int TAG_RAM_SIZE = 31;
    public static final int TAG_REQUIREMENTS = 25;
    public static final int TAG_ROUTING = 12;
    public static final int TAG_SUBJECT = 13;
    public static final int TAG_TIFF_PREVIEW_OFFSET = 33;
    public static final int TAG_TIFF_PREVIEW_SIZE = 32;
    public static final int TAG_TITLE = 14;
    public static final int TAG_VERSION = 15;
    public static final int TAG_VM_LOCATION = 26;
    public static final int TAG_VM_USAGE = 27;
    public static final int TAG_WMF_PREVIEW_OFFSET = 35;
    public static final int TAG_WMF_PREVIEW_SIZE = 34;
    @NotNull
    protected static final HashMap<String, Integer> _tagIntegerMap = new HashMap<>();
    @NotNull
    protected static final HashMap<Integer, String> _tagNameMap = new HashMap<>();

    @NotNull
    public String getName() {
        return "EPS";
    }

    static {
        _tagIntegerMap.put("%!PS-Adobe-", 1);
        _tagIntegerMap.put("%%Author", 2);
        _tagIntegerMap.put("%%BoundingBox", 3);
        _tagIntegerMap.put("%%Copyright", 4);
        _tagIntegerMap.put("%%CreationDate", 5);
        _tagIntegerMap.put("%%Creator", 6);
        _tagIntegerMap.put("%%For", 7);
        _tagIntegerMap.put("%ImageData", 8);
        _tagIntegerMap.put("%%Keywords", 9);
        _tagIntegerMap.put("%%ModDate", 10);
        _tagIntegerMap.put("%%Pages", 11);
        _tagIntegerMap.put("%%Routing", 12);
        _tagIntegerMap.put("%%Subject", 13);
        _tagIntegerMap.put("%%Title", 14);
        _tagIntegerMap.put("%%Version", 15);
        _tagIntegerMap.put("%%DocumentData", 16);
        _tagIntegerMap.put("%%Emulation", 17);
        _tagIntegerMap.put("%%Extensions", 18);
        _tagIntegerMap.put("%%LanguageLevel", 19);
        _tagIntegerMap.put("%%Orientation", 20);
        _tagIntegerMap.put("%%PageOrder", 21);
        _tagIntegerMap.put("%%OperatorIntervention", 22);
        _tagIntegerMap.put("%%OperatorMessage", 23);
        _tagIntegerMap.put("%%ProofMode", 24);
        _tagIntegerMap.put("%%Requirements", 25);
        _tagIntegerMap.put("%%VMlocation", 26);
        _tagIntegerMap.put("%%VMusage", 27);
        _tagIntegerMap.put("Image Width", 28);
        _tagIntegerMap.put("Image Height", 29);
        _tagIntegerMap.put("Color Type", 30);
        _tagIntegerMap.put("Ram Size", 31);
        _tagIntegerMap.put("TIFFPreview", 32);
        _tagIntegerMap.put("TIFFPreviewOffset", 33);
        _tagIntegerMap.put("WMFPreview", 34);
        _tagIntegerMap.put("WMFPreviewOffset", 35);
        _tagIntegerMap.put("%%+", 36);
        _tagNameMap.put(36, "Line Continuation");
        _tagNameMap.put(3, "Bounding Box");
        _tagNameMap.put(4, ExifInterface.TAG_COPYRIGHT);
        _tagNameMap.put(16, "Document Data");
        _tagNameMap.put(17, "Emulation");
        _tagNameMap.put(18, "Extensions");
        _tagNameMap.put(19, "Language Level");
        _tagNameMap.put(20, ExifInterface.TAG_ORIENTATION);
        _tagNameMap.put(21, "Page Order");
        _tagNameMap.put(15, "Version");
        _tagNameMap.put(8, "Image Data");
        _tagNameMap.put(28, "Image Width");
        _tagNameMap.put(29, "Image Height");
        _tagNameMap.put(30, "Color Type");
        _tagNameMap.put(31, "Ram Size");
        _tagNameMap.put(6, "Creator");
        _tagNameMap.put(5, "Creation Date");
        _tagNameMap.put(7, "For");
        _tagNameMap.put(25, "Requirements");
        _tagNameMap.put(12, "Routing");
        _tagNameMap.put(14, "Title");
        _tagNameMap.put(1, "DSC Version");
        _tagNameMap.put(11, "Pages");
        _tagNameMap.put(22, "Operator Intervention");
        _tagNameMap.put(23, "Operator Message");
        _tagNameMap.put(24, "Proof Mode");
        _tagNameMap.put(26, "VM Location");
        _tagNameMap.put(27, "VM Usage");
        _tagNameMap.put(2, "Author");
        _tagNameMap.put(9, "Keywords");
        _tagNameMap.put(10, "Modify Date");
        _tagNameMap.put(13, "Subject");
        _tagNameMap.put(32, "TIFF Preview Size");
        _tagNameMap.put(33, "TIFF Preview Offset");
        _tagNameMap.put(34, "WMF Preview Size");
        _tagNameMap.put(35, "WMF Preview Offset");
    }

    public EpsDirectory() {
        setDescriptor(new EpsDescriptor(this));
    }

    /* access modifiers changed from: protected */
    @NotNull
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}

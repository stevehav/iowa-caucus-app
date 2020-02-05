package com.adobe.xmp.impl;

import com.adobe.xmp.XMPConst;

public class Utils implements XMPConst {
    public static final int UUID_LENGTH = 36;
    public static final int UUID_SEGMENT_COUNT = 4;
    private static boolean[] xmlNameChars;
    private static boolean[] xmlNameStartChars;

    static {
        initCharTables();
    }

    private Utils() {
    }

    static boolean checkUUIDFormat(String str) {
        if (str == null) {
            return false;
        }
        int i = 0;
        boolean z = true;
        int i2 = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '-') {
                i2++;
                z = z && (i == 8 || i == 13 || i == 18 || i == 23);
            }
            i++;
        }
        return z && 4 == i2 && 36 == i;
    }

    public static String escapeXML(String str, boolean z, boolean z2) {
        boolean z3;
        String str2;
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                z3 = false;
                break;
            }
            char charAt = str.charAt(i);
            if (charAt == '<' || charAt == '>' || charAt == '&' || ((z2 && (charAt == 9 || charAt == 10 || charAt == 13)) || (z && charAt == '\"'))) {
                z3 = true;
            } else {
                i++;
            }
        }
        z3 = true;
        if (!z3) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer((str.length() * 4) / 3);
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt2 = str.charAt(i2);
            if (!z2 || !(charAt2 == 9 || charAt2 == 10 || charAt2 == 13)) {
                if (charAt2 == '\"') {
                    str2 = z ? "&quot;" : "\"";
                } else if (charAt2 == '&') {
                    str2 = "&amp;";
                } else if (charAt2 == '<') {
                    str2 = "&lt;";
                } else if (charAt2 == '>') {
                    str2 = "&gt;";
                }
                stringBuffer.append(str2);
            } else {
                stringBuffer.append("&#x");
                stringBuffer.append(Integer.toHexString(charAt2).toUpperCase());
                charAt2 = ';';
            }
            stringBuffer.append(charAt2);
        }
        return stringBuffer.toString();
    }

    private static void initCharTables() {
        xmlNameChars = new boolean[256];
        xmlNameStartChars = new boolean[256];
        char c = 0;
        while (c < xmlNameChars.length) {
            boolean z = true;
            xmlNameStartChars[c] = c == ':' || ('A' <= c && c <= 'Z') || c == '_' || (('a' <= c && c <= 'z') || ((192 <= c && c <= 214) || ((216 <= c && c <= 246) || (248 <= c && c <= 255))));
            boolean[] zArr = xmlNameChars;
            if (!xmlNameStartChars[c] && c != '-' && c != '.' && (('0' > c || c > '9') && c != 183)) {
                z = false;
            }
            zArr[c] = z;
            c = (char) (c + 1);
        }
    }

    static boolean isControlChar(char c) {
        return ((c > 31 && c != 127) || c == 9 || c == 10 || c == 13) ? false : true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:72:0x0137 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean isInternalProperty(java.lang.String r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "http://purl.org/dc/elements/1.1/"
            boolean r0 = r0.equals(r3)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001c
            java.lang.String r3 = "dc:format"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0138
            java.lang.String r3 = "dc:language"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0137
            goto L_0x0138
        L_0x001c:
            java.lang.String r0 = "http://ns.adobe.com/xap/1.0/"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0056
            java.lang.String r3 = "xmp:BaseURL"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0138
            java.lang.String r3 = "xmp:CreatorTool"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0138
            java.lang.String r3 = "xmp:Format"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0138
            java.lang.String r3 = "xmp:Locale"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0138
            java.lang.String r3 = "xmp:MetadataDate"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0138
            java.lang.String r3 = "xmp:ModifyDate"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0137
            goto L_0x0138
        L_0x0056:
            java.lang.String r0 = "http://ns.adobe.com/pdf/1.3/"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0088
            java.lang.String r3 = "pdf:BaseURL"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0138
            java.lang.String r3 = "pdf:Creator"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0138
            java.lang.String r3 = "pdf:ModDate"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0138
            java.lang.String r3 = "pdf:PDFVersion"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0138
            java.lang.String r3 = "pdf:Producer"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0137
            goto L_0x0138
        L_0x0088:
            java.lang.String r0 = "http://ns.adobe.com/tiff/1.0/"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00aa
            java.lang.String r3 = "tiff:ImageDescription"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0137
            java.lang.String r3 = "tiff:Artist"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0137
            java.lang.String r3 = "tiff:Copyright"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0138
            goto L_0x0137
        L_0x00aa:
            java.lang.String r0 = "http://ns.adobe.com/exif/1.0/"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00bc
            java.lang.String r3 = "exif:UserComment"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0138
            goto L_0x0137
        L_0x00bc:
            java.lang.String r0 = "http://ns.adobe.com/exif/1.0/aux/"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00c6
            goto L_0x0138
        L_0x00c6:
            java.lang.String r0 = "http://ns.adobe.com/photoshop/1.0/"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00d7
            java.lang.String r3 = "photoshop:ICCProfile"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0137
            goto L_0x0138
        L_0x00d7:
            java.lang.String r0 = "http://ns.adobe.com/camera-raw-settings/1.0/"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00f8
            java.lang.String r3 = "crs:Version"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0138
            java.lang.String r3 = "crs:RawFileName"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0138
            java.lang.String r3 = "crs:ToneCurveName"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0137
            goto L_0x0138
        L_0x00f8:
            java.lang.String r4 = "http://ns.adobe.com/StockPhoto/1.0/"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0101
            goto L_0x0138
        L_0x0101:
            java.lang.String r4 = "http://ns.adobe.com/xap/1.0/mm/"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x010a
            goto L_0x0138
        L_0x010a:
            java.lang.String r4 = "http://ns.adobe.com/xap/1.0/t/"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0113
            goto L_0x0138
        L_0x0113:
            java.lang.String r4 = "http://ns.adobe.com/xap/1.0/t/pg/"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x011c
            goto L_0x0138
        L_0x011c:
            java.lang.String r4 = "http://ns.adobe.com/xap/1.0/g/"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0125
            goto L_0x0138
        L_0x0125:
            java.lang.String r4 = "http://ns.adobe.com/xap/1.0/g/img/"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x012e
            goto L_0x0138
        L_0x012e:
            java.lang.String r4 = "http://ns.adobe.com/xap/1.0/sType/Font#"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0137
            goto L_0x0138
        L_0x0137:
            r2 = 0
        L_0x0138:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.xmp.impl.Utils.isInternalProperty(java.lang.String, java.lang.String):boolean");
    }

    private static boolean isNameChar(char c) {
        return (c <= 255 && xmlNameChars[c]) || isNameStartChar(c) || (c >= 768 && c <= 879) || (c >= 8255 && c <= 8256);
    }

    private static boolean isNameStartChar(char c) {
        return (c <= 255 && xmlNameStartChars[c]) || (c >= 256 && c <= 767) || ((c >= 880 && c <= 893) || ((c >= 895 && c <= 8191) || ((c >= 8204 && c <= 8205) || ((c >= 8304 && c <= 8591) || ((c >= 11264 && c <= 12271) || ((c >= 12289 && c <= 55295) || ((c >= 63744 && c <= 64975) || ((c >= 65008 && c <= 65533) || (c >= 0 && c <= 65535)))))))));
    }

    public static boolean isXMLName(String str) {
        if (str.length() > 0 && !isNameStartChar(str.charAt(0))) {
            return false;
        }
        for (int i = 1; i < str.length(); i++) {
            if (!isNameChar(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isXMLNameNS(String str) {
        if (str.length() > 0 && (!isNameStartChar(str.charAt(0)) || str.charAt(0) == ':')) {
            return false;
        }
        for (int i = 1; i < str.length(); i++) {
            if (!isNameChar(str.charAt(i)) || str.charAt(i) == ':') {
                return false;
            }
        }
        return true;
    }

    public static String normalizeLangValue(String str) {
        if (XMPConst.X_DEFAULT.equals(str)) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 1;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt != ' ') {
                if (charAt == '-' || charAt == '_') {
                    stringBuffer.append('-');
                    i++;
                } else {
                    stringBuffer.append(i != 2 ? Character.toLowerCase(str.charAt(i2)) : Character.toUpperCase(str.charAt(i2)));
                }
            }
        }
        return stringBuffer.toString();
    }

    static String removeControlChars(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        for (int i = 0; i < stringBuffer.length(); i++) {
            if (isControlChar(stringBuffer.charAt(i))) {
                stringBuffer.setCharAt(i, ' ');
            }
        }
        return stringBuffer.toString();
    }

    static String[] splitNameAndValue(String str) {
        int indexOf = str.indexOf(61);
        String substring = str.substring(str.charAt(1) == '?' ? 2 : 1, indexOf);
        int i = indexOf + 1;
        char charAt = str.charAt(i);
        int i2 = i + 1;
        int length = str.length() - 2;
        StringBuffer stringBuffer = new StringBuffer(length - indexOf);
        while (i2 < length) {
            stringBuffer.append(str.charAt(i2));
            i2++;
            if (str.charAt(i2) == charAt) {
                i2++;
            }
        }
        return new String[]{substring, stringBuffer.toString()};
    }
}

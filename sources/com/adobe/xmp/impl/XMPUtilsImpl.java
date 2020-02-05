package com.adobe.xmp.impl;

import com.adobe.xmp.XMPConst;
import com.adobe.xmp.XMPException;
import com.adobe.xmp.XMPMeta;
import com.adobe.xmp.XMPMetaFactory;
import com.adobe.xmp.impl.xpath.XMPPath;
import com.adobe.xmp.impl.xpath.XMPPathParser;
import com.adobe.xmp.options.PropertyOptions;
import com.adobe.xmp.properties.XMPAliasInfo;
import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import com.drew.metadata.exif.makernotes.SonyType1MakernoteDirectory;
import java.util.Iterator;

public class XMPUtilsImpl implements XMPConst {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String COMMAS = ",，､﹐﹑、،՝";
    private static final String CONTROLS = "  ";
    private static final String QUOTES = "\"«»〝〞〟―‹›";
    private static final String SEMICOLA = ";；﹔؛;";
    private static final String SPACES = " 　〿";
    private static final int UCK_COMMA = 2;
    private static final int UCK_CONTROL = 5;
    private static final int UCK_NORMAL = 0;
    private static final int UCK_QUOTE = 4;
    private static final int UCK_SEMICOLON = 3;
    private static final int UCK_SPACE = 1;

    private XMPUtilsImpl() {
    }

    public static void appendProperties(XMPMeta xMPMeta, XMPMeta xMPMeta2, boolean z, boolean z2, boolean z3) throws XMPException {
        ParameterAsserts.assertImplementation(xMPMeta);
        ParameterAsserts.assertImplementation(xMPMeta2);
        XMPMetaImpl xMPMetaImpl = (XMPMetaImpl) xMPMeta2;
        Iterator iterateChildren = ((XMPMetaImpl) xMPMeta).getRoot().iterateChildren();
        while (iterateChildren.hasNext()) {
            XMPNode xMPNode = (XMPNode) iterateChildren.next();
            XMPNode findSchemaNode = XMPNodeUtils.findSchemaNode(xMPMetaImpl.getRoot(), xMPNode.getName(), false);
            boolean z4 = true;
            if (findSchemaNode == null) {
                findSchemaNode = new XMPNode(xMPNode.getName(), xMPNode.getValue(), new PropertyOptions().setSchemaNode(true));
                xMPMetaImpl.getRoot().addChild(findSchemaNode);
            } else {
                z4 = false;
            }
            Iterator iterateChildren2 = xMPNode.iterateChildren();
            while (iterateChildren2.hasNext()) {
                XMPNode xMPNode2 = (XMPNode) iterateChildren2.next();
                if (z || !Utils.isInternalProperty(xMPNode.getName(), xMPNode2.getName())) {
                    appendSubtree(xMPMetaImpl, xMPNode2, findSchemaNode, z2, z3);
                }
            }
            if (!findSchemaNode.hasChildren() && (z4 || z3)) {
                xMPMetaImpl.getRoot().removeChild(findSchemaNode);
            }
        }
    }

    private static void appendSubtree(XMPMetaImpl xMPMetaImpl, XMPNode xMPNode, XMPNode xMPNode2, boolean z, boolean z2) throws XMPException {
        XMPNode findChildNode = XMPNodeUtils.findChildNode(xMPNode2, xMPNode.getName(), false);
        boolean z3 = z2 && (!xMPNode.getOptions().isSimple() ? !xMPNode.hasChildren() : xMPNode.getValue() == null || xMPNode.getValue().length() == 0);
        if (!z2 || !z3) {
            if (findChildNode != null) {
                if (z) {
                    xMPMetaImpl.setNode(findChildNode, xMPNode.getValue(), xMPNode.getOptions(), true);
                    xMPNode2.removeChild(findChildNode);
                } else {
                    PropertyOptions options = xMPNode.getOptions();
                    if (options == findChildNode.getOptions()) {
                        if (options.isStruct()) {
                            Iterator iterateChildren = xMPNode.iterateChildren();
                            while (iterateChildren.hasNext()) {
                                appendSubtree(xMPMetaImpl, (XMPNode) iterateChildren.next(), findChildNode, z, z2);
                                if (z2 && !findChildNode.hasChildren()) {
                                    xMPNode2.removeChild(findChildNode);
                                }
                            }
                            return;
                        } else if (options.isArrayAltText()) {
                            Iterator iterateChildren2 = xMPNode.iterateChildren();
                            while (iterateChildren2.hasNext()) {
                                XMPNode xMPNode3 = (XMPNode) iterateChildren2.next();
                                if (xMPNode3.hasQualifier() && XMPConst.XML_LANG.equals(xMPNode3.getQualifier(1).getName())) {
                                    int lookupLanguageItem = XMPNodeUtils.lookupLanguageItem(findChildNode, xMPNode3.getQualifier(1).getValue());
                                    if (!z2 || !(xMPNode3.getValue() == null || xMPNode3.getValue().length() == 0)) {
                                        if (lookupLanguageItem == -1) {
                                            if (!XMPConst.X_DEFAULT.equals(xMPNode3.getQualifier(1).getValue()) || !findChildNode.hasChildren()) {
                                                xMPNode3.cloneSubtree(findChildNode);
                                            } else {
                                                XMPNode xMPNode4 = new XMPNode(xMPNode3.getName(), xMPNode3.getValue(), xMPNode3.getOptions());
                                                xMPNode3.cloneSubtree(xMPNode4);
                                                findChildNode.addChild(1, xMPNode4);
                                            }
                                        }
                                    } else if (lookupLanguageItem != -1) {
                                        findChildNode.removeChild(lookupLanguageItem);
                                        if (!findChildNode.hasChildren()) {
                                            xMPNode2.removeChild(findChildNode);
                                        }
                                    }
                                }
                            }
                            return;
                        } else if (options.isArray()) {
                            Iterator iterateChildren3 = xMPNode.iterateChildren();
                            while (iterateChildren3.hasNext()) {
                                XMPNode xMPNode5 = (XMPNode) iterateChildren3.next();
                                Iterator iterateChildren4 = findChildNode.iterateChildren();
                                boolean z4 = false;
                                while (iterateChildren4.hasNext()) {
                                    if (itemValuesMatch(xMPNode5, (XMPNode) iterateChildren4.next())) {
                                        z4 = true;
                                    }
                                }
                                if (!z4) {
                                    XMPNode xMPNode6 = (XMPNode) xMPNode5.clone();
                                    xMPNode2.addChild(xMPNode6);
                                    findChildNode = xMPNode6;
                                }
                            }
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            xMPNode2.addChild((XMPNode) xMPNode.clone());
        } else if (findChildNode != null) {
            xMPNode2.removeChild(findChildNode);
        }
    }

    private static String applyQuotes(String str, char c, char c2, boolean z) {
        if (str == null) {
            str = "";
        }
        int i = 0;
        boolean z2 = false;
        while (i < str.length()) {
            int classifyCharacter = classifyCharacter(str.charAt(i));
            if (i == 0 && classifyCharacter == 4) {
                break;
            }
            if (classifyCharacter != 1) {
                if (classifyCharacter == 3 || classifyCharacter == 5 || (classifyCharacter == 2 && !z)) {
                    break;
                }
                z2 = false;
            } else if (z2) {
                break;
            } else {
                z2 = true;
            }
            i++;
        }
        if (i >= str.length()) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str.length() + 2);
        int i2 = 0;
        while (i2 <= i && classifyCharacter(str.charAt(i)) != 4) {
            i2++;
        }
        stringBuffer.append(c);
        stringBuffer.append(str.substring(0, i2));
        while (i2 < str.length()) {
            stringBuffer.append(str.charAt(i2));
            if (classifyCharacter(str.charAt(i2)) == 4 && isSurroundingQuote(str.charAt(i2), c, c2)) {
                stringBuffer.append(str.charAt(i2));
            }
            i2++;
        }
        stringBuffer.append(c2);
        return stringBuffer.toString();
    }

    public static String catenateArrayItems(XMPMeta xMPMeta, String str, String str2, String str3, String str4, boolean z) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertArrayName(str2);
        ParameterAsserts.assertImplementation(xMPMeta);
        if (str3 == null || str3.length() == 0) {
            str3 = "; ";
        }
        if (str4 == null || str4.length() == 0) {
            str4 = "\"";
        }
        XMPNode findNode = XMPNodeUtils.findNode(((XMPMetaImpl) xMPMeta).getRoot(), XMPPathParser.expandXPath(str, str2), false, (PropertyOptions) null);
        if (findNode == null) {
            return "";
        }
        if (!findNode.getOptions().isArray() || findNode.getOptions().isArrayAlternate()) {
            throw new XMPException("Named property must be non-alternate array", 4);
        }
        checkSeparator(str3);
        char charAt = str4.charAt(0);
        char checkQuotes = checkQuotes(str4, charAt);
        StringBuffer stringBuffer = new StringBuffer();
        Iterator iterateChildren = findNode.iterateChildren();
        while (iterateChildren.hasNext()) {
            XMPNode xMPNode = (XMPNode) iterateChildren.next();
            if (!xMPNode.getOptions().isCompositeProperty()) {
                stringBuffer.append(applyQuotes(xMPNode.getValue(), charAt, checkQuotes, z));
                if (iterateChildren.hasNext()) {
                    stringBuffer.append(str3);
                }
            } else {
                throw new XMPException("Array items must be simple", 4);
            }
        }
        return stringBuffer.toString();
    }

    private static char checkQuotes(String str, char c) throws XMPException {
        char c2;
        if (classifyCharacter(c) == 4) {
            if (str.length() == 1) {
                c2 = c;
            } else {
                c2 = str.charAt(1);
                if (classifyCharacter(c2) != 4) {
                    throw new XMPException("Invalid quoting character", 4);
                }
            }
            if (c2 == getClosingQuote(c)) {
                return c2;
            }
            throw new XMPException("Mismatched quote pair", 4);
        }
        throw new XMPException("Invalid quoting character", 4);
    }

    private static void checkSeparator(String str) throws XMPException {
        boolean z = false;
        for (int i = 0; i < str.length(); i++) {
            int classifyCharacter = classifyCharacter(str.charAt(i));
            if (classifyCharacter == 3) {
                if (!z) {
                    z = true;
                } else {
                    throw new XMPException("Separator can have only one semicolon", 4);
                }
            } else if (classifyCharacter != 1) {
                throw new XMPException("Separator can have only spaces and one semicolon", 4);
            }
        }
        if (!z) {
            throw new XMPException("Separator must have one semicolon", 4);
        }
    }

    private static int classifyCharacter(char c) {
        if (SPACES.indexOf(c) >= 0) {
            return 1;
        }
        if (8192 <= c && c <= 8203) {
            return 1;
        }
        if (COMMAS.indexOf(c) >= 0) {
            return 2;
        }
        if (SEMICOLA.indexOf(c) >= 0) {
            return 3;
        }
        if (QUOTES.indexOf(c) >= 0) {
            return 4;
        }
        if (12296 <= c && c <= 12303) {
            return 4;
        }
        if (8216 > c || c > 8223) {
            return (c < ' ' || CONTROLS.indexOf(c) >= 0) ? 5 : 0;
        }
        return 4;
    }

    private static char getClosingQuote(char c) {
        switch (c) {
            case '\"':
                return '\"';
            case 171:
                return 187;
            case NikonType2MakernoteDirectory.TAG_UNKNOWN_49 /*187*/:
                return 171;
            case 8213:
                return 8213;
            case 8216:
                return 8217;
            case 8218:
                return 8219;
            case 8220:
                return 8221;
            case SonyType1MakernoteDirectory.TAG_AF_POINT_SELECTED /*8222*/:
                return 8223;
            case 8249:
                return 8250;
            case 8250:
                return 8249;
            case 12296:
                return 12297;
            case 12298:
                return 12299;
            case 12300:
                return 12301;
            case 12302:
                return 12303;
            case 12317:
                return 12319;
            default:
                return 0;
        }
    }

    private static boolean isClosingingQuote(char c, char c2, char c3) {
        return c == c3 || (c2 == 12317 && c == 12318) || c == 12319;
    }

    private static boolean isSurroundingQuote(char c, char c2, char c3) {
        return c == c2 || isClosingingQuote(c, c2, c3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean itemValuesMatch(com.adobe.xmp.impl.XMPNode r5, com.adobe.xmp.impl.XMPNode r6) throws com.adobe.xmp.XMPException {
        /*
            com.adobe.xmp.options.PropertyOptions r0 = r5.getOptions()
            com.adobe.xmp.options.PropertyOptions r1 = r6.getOptions()
            boolean r1 = r0.equals(r1)
            r2 = 0
            if (r1 == 0) goto L_0x0010
            return r2
        L_0x0010:
            int r1 = r0.getOptions()
            r3 = 1
            if (r1 != 0) goto L_0x005a
            java.lang.String r0 = r5.getValue()
            java.lang.String r1 = r6.getValue()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0026
            return r2
        L_0x0026:
            com.adobe.xmp.options.PropertyOptions r0 = r5.getOptions()
            boolean r0 = r0.getHasLanguage()
            com.adobe.xmp.options.PropertyOptions r1 = r6.getOptions()
            boolean r1 = r1.getHasLanguage()
            if (r0 == r1) goto L_0x0039
            return r2
        L_0x0039:
            com.adobe.xmp.options.PropertyOptions r0 = r5.getOptions()
            boolean r0 = r0.getHasLanguage()
            if (r0 == 0) goto L_0x00b8
            com.adobe.xmp.impl.XMPNode r5 = r5.getQualifier(r3)
            java.lang.String r5 = r5.getValue()
            com.adobe.xmp.impl.XMPNode r6 = r6.getQualifier(r3)
            java.lang.String r6 = r6.getValue()
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x00b8
            return r2
        L_0x005a:
            boolean r0 = r0.isStruct()
            if (r0 == 0) goto L_0x008c
            int r0 = r5.getChildrenLength()
            int r1 = r6.getChildrenLength()
            if (r0 == r1) goto L_0x006b
            return r2
        L_0x006b:
            java.util.Iterator r5 = r5.iterateChildren()
        L_0x006f:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x00b8
            java.lang.Object r0 = r5.next()
            com.adobe.xmp.impl.XMPNode r0 = (com.adobe.xmp.impl.XMPNode) r0
            java.lang.String r1 = r0.getName()
            com.adobe.xmp.impl.XMPNode r1 = com.adobe.xmp.impl.XMPNodeUtils.findChildNode(r6, r1, r2)
            if (r1 == 0) goto L_0x008b
            boolean r0 = itemValuesMatch(r0, r1)
            if (r0 != 0) goto L_0x006f
        L_0x008b:
            return r2
        L_0x008c:
            java.util.Iterator r5 = r5.iterateChildren()
        L_0x0090:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x00b8
            java.lang.Object r0 = r5.next()
            com.adobe.xmp.impl.XMPNode r0 = (com.adobe.xmp.impl.XMPNode) r0
            java.util.Iterator r1 = r6.iterateChildren()
        L_0x00a0:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x00b4
            java.lang.Object r4 = r1.next()
            com.adobe.xmp.impl.XMPNode r4 = (com.adobe.xmp.impl.XMPNode) r4
            boolean r4 = itemValuesMatch(r0, r4)
            if (r4 == 0) goto L_0x00a0
            r0 = 1
            goto L_0x00b5
        L_0x00b4:
            r0 = 0
        L_0x00b5:
            if (r0 != 0) goto L_0x0090
            return r2
        L_0x00b8:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.xmp.impl.XMPUtilsImpl.itemValuesMatch(com.adobe.xmp.impl.XMPNode, com.adobe.xmp.impl.XMPNode):boolean");
    }

    public static void removeProperties(XMPMeta xMPMeta, String str, String str2, boolean z, boolean z2) throws XMPException {
        ParameterAsserts.assertImplementation(xMPMeta);
        XMPMetaImpl xMPMetaImpl = (XMPMetaImpl) xMPMeta;
        if (str2 == null || str2.length() <= 0) {
            if (str == null || str.length() <= 0) {
                Iterator iterateChildren = xMPMetaImpl.getRoot().iterateChildren();
                while (iterateChildren.hasNext()) {
                    if (removeSchemaChildren((XMPNode) iterateChildren.next(), z)) {
                        iterateChildren.remove();
                    }
                }
                return;
            }
            XMPNode findSchemaNode = XMPNodeUtils.findSchemaNode(xMPMetaImpl.getRoot(), str, false);
            if (findSchemaNode != null && removeSchemaChildren(findSchemaNode, z)) {
                xMPMetaImpl.getRoot().removeChild(findSchemaNode);
            }
            if (z2) {
                XMPAliasInfo[] findAliases = XMPMetaFactory.getSchemaRegistry().findAliases(str);
                for (XMPAliasInfo xMPAliasInfo : findAliases) {
                    XMPNode findNode = XMPNodeUtils.findNode(xMPMetaImpl.getRoot(), XMPPathParser.expandXPath(xMPAliasInfo.getNamespace(), xMPAliasInfo.getPropName()), false, (PropertyOptions) null);
                    if (findNode != null) {
                        findNode.getParent().removeChild(findNode);
                    }
                }
            }
        } else if (str == null || str.length() == 0) {
            throw new XMPException("Property name requires schema namespace", 4);
        } else {
            XMPPath expandXPath = XMPPathParser.expandXPath(str, str2);
            XMPNode findNode2 = XMPNodeUtils.findNode(xMPMetaImpl.getRoot(), expandXPath, false, (PropertyOptions) null);
            if (findNode2 == null) {
                return;
            }
            if (z || !Utils.isInternalProperty(expandXPath.getSegment(0).getName(), expandXPath.getSegment(1).getName())) {
                XMPNode parent = findNode2.getParent();
                parent.removeChild(findNode2);
                if (parent.getOptions().isSchemaNode() && !parent.hasChildren()) {
                    parent.getParent().removeChild(parent);
                }
            }
        }
    }

    private static boolean removeSchemaChildren(XMPNode xMPNode, boolean z) {
        Iterator iterateChildren = xMPNode.iterateChildren();
        while (iterateChildren.hasNext()) {
            XMPNode xMPNode2 = (XMPNode) iterateChildren.next();
            if (z || !Utils.isInternalProperty(xMPNode.getName(), xMPNode2.getName())) {
                iterateChildren.remove();
            }
        }
        return !xMPNode.hasChildren();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0052, code lost:
        r3 = r11.charAt(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void separateArrayItems(com.adobe.xmp.XMPMeta r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, com.adobe.xmp.options.PropertyOptions r12, boolean r13) throws com.adobe.xmp.XMPException {
        /*
            com.adobe.xmp.impl.ParameterAsserts.assertSchemaNS(r9)
            com.adobe.xmp.impl.ParameterAsserts.assertArrayName(r10)
            r0 = 4
            if (r11 == 0) goto L_0x00f8
            com.adobe.xmp.impl.ParameterAsserts.assertImplementation(r8)
            com.adobe.xmp.impl.XMPMetaImpl r8 = (com.adobe.xmp.impl.XMPMetaImpl) r8
            com.adobe.xmp.impl.XMPNode r8 = separateFindCreateArray(r9, r10, r12, r8)
            int r9 = r11.length()
            r10 = 0
            r12 = 0
            r1 = 0
        L_0x0019:
            if (r10 >= r9) goto L_0x00f7
        L_0x001b:
            if (r10 >= r9) goto L_0x002d
            char r1 = r11.charAt(r10)
            int r12 = classifyCharacter(r1)
            if (r12 == 0) goto L_0x002d
            if (r12 != r0) goto L_0x002a
            goto L_0x002d
        L_0x002a:
            int r10 = r10 + 1
            goto L_0x001b
        L_0x002d:
            if (r10 < r9) goto L_0x0031
            goto L_0x00f7
        L_0x0031:
            r2 = 1
            if (r12 == r0) goto L_0x006f
            r3 = r1
            r1 = r12
            r12 = r10
        L_0x0037:
            if (r12 >= r9) goto L_0x0065
            char r3 = r11.charAt(r12)
            int r1 = classifyCharacter(r3)
            if (r1 == 0) goto L_0x0062
            if (r1 == r0) goto L_0x0062
            r4 = 2
            if (r1 != r4) goto L_0x004b
            if (r13 == 0) goto L_0x004b
            goto L_0x0062
        L_0x004b:
            if (r1 == r2) goto L_0x004e
            goto L_0x0065
        L_0x004e:
            int r5 = r12 + 1
            if (r5 >= r9) goto L_0x0065
            char r3 = r11.charAt(r5)
            int r5 = classifyCharacter(r3)
            if (r5 == 0) goto L_0x0062
            if (r5 == r0) goto L_0x0062
            if (r5 != r4) goto L_0x0065
            if (r13 == 0) goto L_0x0065
        L_0x0062:
            int r12 = r12 + 1
            goto L_0x0037
        L_0x0065:
            java.lang.String r10 = r11.substring(r10, r12)
            r4 = r10
            r10 = r12
            r12 = r1
            r1 = r3
            goto L_0x00ce
        L_0x006f:
            char r3 = getClosingQuote(r1)
            int r10 = r10 + 1
            java.lang.String r4 = ""
            r5 = r1
        L_0x0078:
            if (r10 >= r9) goto L_0x00cd
            char r5 = r11.charAt(r10)
            int r12 = classifyCharacter(r5)
            if (r12 != r0) goto L_0x00bc
            boolean r6 = isSurroundingQuote(r5, r1, r3)
            if (r6 != 0) goto L_0x008b
            goto L_0x00bc
        L_0x008b:
            int r6 = r10 + 1
            if (r6 >= r9) goto L_0x0097
            char r7 = r11.charAt(r6)
            classifyCharacter(r7)
            goto L_0x0099
        L_0x0097:
            r7 = 59
        L_0x0099:
            if (r5 != r7) goto L_0x00ad
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r4)
            r10.append(r5)
            java.lang.String r10 = r10.toString()
            r4 = r10
            r10 = r6
            goto L_0x00cb
        L_0x00ad:
            boolean r7 = isClosingingQuote(r5, r1, r3)
            if (r7 != 0) goto L_0x00b9
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            goto L_0x00c1
        L_0x00b9:
            r1 = r5
            r10 = r6
            goto L_0x00ce
        L_0x00bc:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
        L_0x00c1:
            r6.append(r4)
            r6.append(r5)
            java.lang.String r4 = r6.toString()
        L_0x00cb:
            int r10 = r10 + r2
            goto L_0x0078
        L_0x00cd:
            r1 = r5
        L_0x00ce:
            r3 = -1
        L_0x00cf:
            int r5 = r8.getChildrenLength()
            if (r2 > r5) goto L_0x00e7
            com.adobe.xmp.impl.XMPNode r5 = r8.getChild(r2)
            java.lang.String r5 = r5.getValue()
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x00e4
            goto L_0x00e8
        L_0x00e4:
            int r2 = r2 + 1
            goto L_0x00cf
        L_0x00e7:
            r2 = -1
        L_0x00e8:
            if (r2 >= 0) goto L_0x0019
            com.adobe.xmp.impl.XMPNode r2 = new com.adobe.xmp.impl.XMPNode
            r3 = 0
            java.lang.String r5 = "[]"
            r2.<init>(r5, r4, r3)
            r8.addChild(r2)
            goto L_0x0019
        L_0x00f7:
            return
        L_0x00f8:
            com.adobe.xmp.XMPException r8 = new com.adobe.xmp.XMPException
            java.lang.String r9 = "Parameter must not be null"
            r8.<init>(r9, r0)
            goto L_0x0101
        L_0x0100:
            throw r8
        L_0x0101:
            goto L_0x0100
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.xmp.impl.XMPUtilsImpl.separateArrayItems(com.adobe.xmp.XMPMeta, java.lang.String, java.lang.String, java.lang.String, com.adobe.xmp.options.PropertyOptions, boolean):void");
    }

    private static XMPNode separateFindCreateArray(String str, String str2, PropertyOptions propertyOptions, XMPMetaImpl xMPMetaImpl) throws XMPException {
        PropertyOptions verifySetOptions = XMPNodeUtils.verifySetOptions(propertyOptions, (Object) null);
        if (verifySetOptions.isOnlyArrayOptions()) {
            XMPPath expandXPath = XMPPathParser.expandXPath(str, str2);
            XMPNode findNode = XMPNodeUtils.findNode(xMPMetaImpl.getRoot(), expandXPath, false, (PropertyOptions) null);
            if (findNode != null) {
                PropertyOptions options = findNode.getOptions();
                if (!options.isArray() || options.isArrayAlternate()) {
                    throw new XMPException("Named property must be non-alternate array", 102);
                } else if (verifySetOptions.equalArrayTypes(options)) {
                    throw new XMPException("Mismatch of specified and existing array form", 102);
                }
            } else {
                findNode = XMPNodeUtils.findNode(xMPMetaImpl.getRoot(), expandXPath, true, verifySetOptions.setArray(true));
                if (findNode == null) {
                    throw new XMPException("Failed to create named array", 102);
                }
            }
            return findNode;
        }
        throw new XMPException("Options can only provide array form", 103);
    }
}

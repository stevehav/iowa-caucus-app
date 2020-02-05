package com.adobe.xmp.impl;

import com.adobe.xmp.XMPConst;
import com.adobe.xmp.XMPDateTime;
import com.adobe.xmp.XMPException;
import com.adobe.xmp.XMPIterator;
import com.adobe.xmp.XMPMeta;
import com.adobe.xmp.XMPPathFactory;
import com.adobe.xmp.XMPUtils;
import com.adobe.xmp.impl.xpath.XMPPath;
import com.adobe.xmp.impl.xpath.XMPPathParser;
import com.adobe.xmp.options.IteratorOptions;
import com.adobe.xmp.options.ParseOptions;
import com.adobe.xmp.options.PropertyOptions;
import com.adobe.xmp.properties.XMPProperty;
import java.util.Calendar;

public class XMPMetaImpl implements XMPMeta, XMPConst {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int VALUE_BASE64 = 7;
    private static final int VALUE_BOOLEAN = 1;
    private static final int VALUE_CALENDAR = 6;
    private static final int VALUE_DATE = 5;
    private static final int VALUE_DOUBLE = 4;
    private static final int VALUE_INTEGER = 2;
    private static final int VALUE_LONG = 3;
    private static final int VALUE_STRING = 0;
    private String packetHeader;
    private XMPNode tree;

    public XMPMetaImpl() {
        this.packetHeader = null;
        this.tree = new XMPNode((String) null, (String) null, (PropertyOptions) null);
    }

    public XMPMetaImpl(XMPNode xMPNode) {
        this.packetHeader = null;
        this.tree = xMPNode;
    }

    private void doSetArrayItem(XMPNode xMPNode, int i, String str, PropertyOptions propertyOptions, boolean z) throws XMPException {
        XMPNode xMPNode2 = new XMPNode(XMPConst.ARRAY_ITEM_NAME, (PropertyOptions) null);
        PropertyOptions verifySetOptions = XMPNodeUtils.verifySetOptions(propertyOptions, str);
        int childrenLength = z ? xMPNode.getChildrenLength() + 1 : xMPNode.getChildrenLength();
        if (i == -1) {
            i = childrenLength;
        }
        if (1 > i || i > childrenLength) {
            throw new XMPException("Array index out of bounds", 104);
        }
        if (!z) {
            xMPNode.removeChild(i);
        }
        xMPNode.addChild(i, xMPNode2);
        setNode(xMPNode2, str, verifySetOptions, false);
    }

    private Object evaluateNodeValue(int i, XMPNode xMPNode) throws XMPException {
        String value = xMPNode.getValue();
        switch (i) {
            case 1:
                return new Boolean(XMPUtils.convertToBoolean(value));
            case 2:
                return new Integer(XMPUtils.convertToInteger(value));
            case 3:
                return new Long(XMPUtils.convertToLong(value));
            case 4:
                return new Double(XMPUtils.convertToDouble(value));
            case 5:
                return XMPUtils.convertToDate(value);
            case 6:
                return XMPUtils.convertToDate(value).getCalendar();
            case 7:
                return XMPUtils.decodeBase64(value);
            default:
                if (value == null && !xMPNode.getOptions().isCompositeProperty()) {
                    value = "";
                }
                return value;
        }
    }

    public void appendArrayItem(String str, String str2, PropertyOptions propertyOptions, String str3, PropertyOptions propertyOptions2) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertArrayName(str2);
        if (propertyOptions == null) {
            propertyOptions = new PropertyOptions();
        }
        if (propertyOptions.isOnlyArrayOptions()) {
            PropertyOptions verifySetOptions = XMPNodeUtils.verifySetOptions(propertyOptions, (Object) null);
            XMPPath expandXPath = XMPPathParser.expandXPath(str, str2);
            XMPNode findNode = XMPNodeUtils.findNode(this.tree, expandXPath, false, (PropertyOptions) null);
            if (findNode != null) {
                if (!findNode.getOptions().isArray()) {
                    throw new XMPException("The named property is not an array", 102);
                }
            } else if (verifySetOptions.isArray()) {
                findNode = XMPNodeUtils.findNode(this.tree, expandXPath, true, verifySetOptions);
                if (findNode == null) {
                    throw new XMPException("Failure creating array node", 102);
                }
            } else {
                throw new XMPException("Explicit arrayOptions required to create new array", 103);
            }
            doSetArrayItem(findNode, -1, str3, propertyOptions2, true);
            return;
        }
        throw new XMPException("Only array form flags allowed for arrayOptions", 103);
    }

    public void appendArrayItem(String str, String str2, String str3) throws XMPException {
        appendArrayItem(str, str2, (PropertyOptions) null, str3, (PropertyOptions) null);
    }

    public Object clone() {
        return new XMPMetaImpl((XMPNode) this.tree.clone());
    }

    public int countArrayItems(String str, String str2) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertArrayName(str2);
        XMPNode findNode = XMPNodeUtils.findNode(this.tree, XMPPathParser.expandXPath(str, str2), false, (PropertyOptions) null);
        if (findNode == null) {
            return 0;
        }
        if (findNode.getOptions().isArray()) {
            return findNode.getChildrenLength();
        }
        throw new XMPException("The named property is not an array", 102);
    }

    public void deleteArrayItem(String str, String str2, int i) {
        try {
            ParameterAsserts.assertSchemaNS(str);
            ParameterAsserts.assertArrayName(str2);
            deleteProperty(str, XMPPathFactory.composeArrayItemPath(str2, i));
        } catch (XMPException unused) {
        }
    }

    public void deleteProperty(String str, String str2) {
        try {
            ParameterAsserts.assertSchemaNS(str);
            ParameterAsserts.assertPropName(str2);
            XMPNode findNode = XMPNodeUtils.findNode(this.tree, XMPPathParser.expandXPath(str, str2), false, (PropertyOptions) null);
            if (findNode != null) {
                XMPNodeUtils.deleteNode(findNode);
            }
        } catch (XMPException unused) {
        }
    }

    public void deleteQualifier(String str, String str2, String str3, String str4) {
        try {
            ParameterAsserts.assertSchemaNS(str);
            ParameterAsserts.assertPropName(str2);
            deleteProperty(str, str2 + XMPPathFactory.composeQualifierPath(str3, str4));
        } catch (XMPException unused) {
        }
    }

    public void deleteStructField(String str, String str2, String str3, String str4) {
        try {
            ParameterAsserts.assertSchemaNS(str);
            ParameterAsserts.assertStructName(str2);
            deleteProperty(str, str2 + XMPPathFactory.composeStructFieldPath(str3, str4));
        } catch (XMPException unused) {
        }
    }

    public boolean doesArrayItemExist(String str, String str2, int i) {
        try {
            ParameterAsserts.assertSchemaNS(str);
            ParameterAsserts.assertArrayName(str2);
            return doesPropertyExist(str, XMPPathFactory.composeArrayItemPath(str2, i));
        } catch (XMPException unused) {
            return false;
        }
    }

    public boolean doesPropertyExist(String str, String str2) {
        try {
            ParameterAsserts.assertSchemaNS(str);
            ParameterAsserts.assertPropName(str2);
            return XMPNodeUtils.findNode(this.tree, XMPPathParser.expandXPath(str, str2), false, (PropertyOptions) null) != null;
        } catch (XMPException unused) {
            return false;
        }
    }

    public boolean doesQualifierExist(String str, String str2, String str3, String str4) {
        try {
            ParameterAsserts.assertSchemaNS(str);
            ParameterAsserts.assertPropName(str2);
            String composeQualifierPath = XMPPathFactory.composeQualifierPath(str3, str4);
            return doesPropertyExist(str, str2 + composeQualifierPath);
        } catch (XMPException unused) {
            return false;
        }
    }

    public boolean doesStructFieldExist(String str, String str2, String str3, String str4) {
        try {
            ParameterAsserts.assertSchemaNS(str);
            ParameterAsserts.assertStructName(str2);
            String composeStructFieldPath = XMPPathFactory.composeStructFieldPath(str3, str4);
            return doesPropertyExist(str, str2 + composeStructFieldPath);
        } catch (XMPException unused) {
            return false;
        }
    }

    public String dumpObject() {
        return getRoot().dumpNode(true);
    }

    public XMPProperty getArrayItem(String str, String str2, int i) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertArrayName(str2);
        return getProperty(str, XMPPathFactory.composeArrayItemPath(str2, i));
    }

    public XMPProperty getLocalizedText(String str, String str2, String str3, String str4) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertArrayName(str2);
        ParameterAsserts.assertSpecificLang(str4);
        String normalizeLangValue = str3 != null ? Utils.normalizeLangValue(str3) : null;
        String normalizeLangValue2 = Utils.normalizeLangValue(str4);
        XMPNode findNode = XMPNodeUtils.findNode(this.tree, XMPPathParser.expandXPath(str, str2), false, (PropertyOptions) null);
        if (findNode == null) {
            return null;
        }
        Object[] chooseLocalizedText = XMPNodeUtils.chooseLocalizedText(findNode, normalizeLangValue, normalizeLangValue2);
        int intValue = ((Integer) chooseLocalizedText[0]).intValue();
        final XMPNode xMPNode = (XMPNode) chooseLocalizedText[1];
        if (intValue != 0) {
            return new XMPProperty() {
                public String getLanguage() {
                    return xMPNode.getQualifier(1).getValue();
                }

                public PropertyOptions getOptions() {
                    return xMPNode.getOptions();
                }

                public String getValue() {
                    return xMPNode.getValue();
                }

                public String toString() {
                    return xMPNode.getValue().toString();
                }
            };
        }
        return null;
    }

    public String getObjectName() {
        return this.tree.getName() != null ? this.tree.getName() : "";
    }

    public String getPacketHeader() {
        return this.packetHeader;
    }

    public XMPProperty getProperty(String str, String str2) throws XMPException {
        return getProperty(str, str2, 0);
    }

    /* access modifiers changed from: protected */
    public XMPProperty getProperty(String str, String str2, int i) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertPropName(str2);
        final XMPNode findNode = XMPNodeUtils.findNode(this.tree, XMPPathParser.expandXPath(str, str2), false, (PropertyOptions) null);
        if (findNode == null) {
            return null;
        }
        if (i == 0 || !findNode.getOptions().isCompositeProperty()) {
            final Object evaluateNodeValue = evaluateNodeValue(i, findNode);
            return new XMPProperty() {
                public String getLanguage() {
                    return null;
                }

                public PropertyOptions getOptions() {
                    return findNode.getOptions();
                }

                public String getValue() {
                    Object obj = evaluateNodeValue;
                    if (obj != null) {
                        return obj.toString();
                    }
                    return null;
                }

                public String toString() {
                    return evaluateNodeValue.toString();
                }
            };
        }
        throw new XMPException("Property must be simple when a value type is requested", 102);
    }

    public byte[] getPropertyBase64(String str, String str2) throws XMPException {
        return (byte[]) getPropertyObject(str, str2, 7);
    }

    public Boolean getPropertyBoolean(String str, String str2) throws XMPException {
        return (Boolean) getPropertyObject(str, str2, 1);
    }

    public Calendar getPropertyCalendar(String str, String str2) throws XMPException {
        return (Calendar) getPropertyObject(str, str2, 6);
    }

    public XMPDateTime getPropertyDate(String str, String str2) throws XMPException {
        return (XMPDateTime) getPropertyObject(str, str2, 5);
    }

    public Double getPropertyDouble(String str, String str2) throws XMPException {
        return (Double) getPropertyObject(str, str2, 4);
    }

    public Integer getPropertyInteger(String str, String str2) throws XMPException {
        return (Integer) getPropertyObject(str, str2, 2);
    }

    public Long getPropertyLong(String str, String str2) throws XMPException {
        return (Long) getPropertyObject(str, str2, 3);
    }

    /* access modifiers changed from: protected */
    public Object getPropertyObject(String str, String str2, int i) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertPropName(str2);
        XMPNode findNode = XMPNodeUtils.findNode(this.tree, XMPPathParser.expandXPath(str, str2), false, (PropertyOptions) null);
        if (findNode == null) {
            return null;
        }
        if (i == 0 || !findNode.getOptions().isCompositeProperty()) {
            return evaluateNodeValue(i, findNode);
        }
        throw new XMPException("Property must be simple when a value type is requested", 102);
    }

    public String getPropertyString(String str, String str2) throws XMPException {
        return (String) getPropertyObject(str, str2, 0);
    }

    public XMPProperty getQualifier(String str, String str2, String str3, String str4) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertPropName(str2);
        return getProperty(str, str2 + XMPPathFactory.composeQualifierPath(str3, str4));
    }

    public XMPNode getRoot() {
        return this.tree;
    }

    public XMPProperty getStructField(String str, String str2, String str3, String str4) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertStructName(str2);
        return getProperty(str, str2 + XMPPathFactory.composeStructFieldPath(str3, str4));
    }

    public void insertArrayItem(String str, String str2, int i, String str3) throws XMPException {
        insertArrayItem(str, str2, i, str3, (PropertyOptions) null);
    }

    public void insertArrayItem(String str, String str2, int i, String str3, PropertyOptions propertyOptions) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertArrayName(str2);
        XMPNode findNode = XMPNodeUtils.findNode(this.tree, XMPPathParser.expandXPath(str, str2), false, (PropertyOptions) null);
        if (findNode != null) {
            doSetArrayItem(findNode, i, str3, propertyOptions, true);
            return;
        }
        throw new XMPException("Specified array does not exist", 102);
    }

    public XMPIterator iterator() throws XMPException {
        return iterator((String) null, (String) null, (IteratorOptions) null);
    }

    public XMPIterator iterator(IteratorOptions iteratorOptions) throws XMPException {
        return iterator((String) null, (String) null, iteratorOptions);
    }

    public XMPIterator iterator(String str, String str2, IteratorOptions iteratorOptions) throws XMPException {
        return new XMPIteratorImpl(this, str, str2, iteratorOptions);
    }

    public void normalize(ParseOptions parseOptions) throws XMPException {
        if (parseOptions == null) {
            parseOptions = new ParseOptions();
        }
        XMPNormalizer.process(this, parseOptions);
    }

    public void setArrayItem(String str, String str2, int i, String str3) throws XMPException {
        setArrayItem(str, str2, i, str3, (PropertyOptions) null);
    }

    public void setArrayItem(String str, String str2, int i, String str3, PropertyOptions propertyOptions) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertArrayName(str2);
        XMPNode findNode = XMPNodeUtils.findNode(this.tree, XMPPathParser.expandXPath(str, str2), false, (PropertyOptions) null);
        if (findNode != null) {
            doSetArrayItem(findNode, i, str3, propertyOptions, false);
            return;
        }
        throw new XMPException("Specified array does not exist", 102);
    }

    public void setLocalizedText(String str, String str2, String str3, String str4, String str5) throws XMPException {
        setLocalizedText(str, str2, str3, str4, str5, (PropertyOptions) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0099, code lost:
        if (r2 == null) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009f, code lost:
        if (r8.getChildrenLength() <= 1) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a1, code lost:
        r8.removeChild(r2);
        r8.addChild(1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a7, code lost:
        r10 = com.adobe.xmp.impl.XMPNodeUtils.chooseLocalizedText(r8, r10, r11);
        r0 = ((java.lang.Integer) r10[0]).intValue();
        r10 = (com.adobe.xmp.impl.XMPNode) r10[1];
        r3 = com.adobe.xmp.XMPConst.X_DEFAULT.equals(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00bb, code lost:
        if (r0 == 0) goto L_0x0154;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00bd, code lost:
        if (r0 == 1) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c0, code lost:
        if (r0 == 2) goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c3, code lost:
        if (r0 == 3) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c6, code lost:
        if (r0 == 4) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c9, code lost:
        if (r0 != 5) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00cb, code lost:
        com.adobe.xmp.impl.XMPNodeUtils.appendLangItem(r8, r11, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ce, code lost:
        if (r3 == false) goto L_0x015d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00db, code lost:
        throw new com.adobe.xmp.XMPException("Unexpected result from ChooseLocalizedText", 9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00dc, code lost:
        if (r2 == null) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e2, code lost:
        if (r8.getChildrenLength() != 1) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e4, code lost:
        r2.setValue(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e7, code lost:
        com.adobe.xmp.impl.XMPNodeUtils.appendLangItem(r8, r11, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ec, code lost:
        com.adobe.xmp.impl.XMPNodeUtils.appendLangItem(r8, r11, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ef, code lost:
        if (r3 == false) goto L_0x015d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f3, code lost:
        if (r9 == false) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f5, code lost:
        if (r2 == r10) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f7, code lost:
        if (r2 == null) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0105, code lost:
        if (r2.getValue().equals(r10.getValue()) == false) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0107, code lost:
        r2.setValue(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x010a, code lost:
        r10.setValue(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x010e, code lost:
        if (r3 != false) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0110, code lost:
        if (r9 == false) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0112, code lost:
        if (r2 == r10) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0114, code lost:
        if (r2 == null) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0122, code lost:
        if (r2.getValue().equals(r10.getValue()) == false) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0125, code lost:
        r10 = r8.iterateChildren();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x012d, code lost:
        if (r10.hasNext() == false) goto L_0x014e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x012f, code lost:
        r11 = (com.adobe.xmp.impl.XMPNode) r10.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0135, code lost:
        if (r11 == r2) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0137, code lost:
        r0 = r11.getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x013b, code lost:
        if (r2 == null) goto L_0x0142;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x013d, code lost:
        r3 = r2.getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0142, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0147, code lost:
        if (r0.equals(r3) != false) goto L_0x014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x014a, code lost:
        r11.setValue(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x014e, code lost:
        if (r2 == null) goto L_0x015d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0150, code lost:
        r2.setValue(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0154, code lost:
        com.adobe.xmp.impl.XMPNodeUtils.appendLangItem(r8, com.adobe.xmp.XMPConst.X_DEFAULT, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0157, code lost:
        if (r3 != false) goto L_0x015c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0159, code lost:
        com.adobe.xmp.impl.XMPNodeUtils.appendLangItem(r8, r11, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x015c, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x015d, code lost:
        if (r9 != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0163, code lost:
        if (r8.getChildrenLength() != 1) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0165, code lost:
        com.adobe.xmp.impl.XMPNodeUtils.appendLangItem(r8, com.adobe.xmp.XMPConst.X_DEFAULT, r12);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setLocalizedText(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, com.adobe.xmp.options.PropertyOptions r13) throws com.adobe.xmp.XMPException {
        /*
            r7 = this;
            com.adobe.xmp.impl.ParameterAsserts.assertSchemaNS(r8)
            com.adobe.xmp.impl.ParameterAsserts.assertArrayName(r9)
            com.adobe.xmp.impl.ParameterAsserts.assertSpecificLang(r11)
            r13 = 0
            if (r10 == 0) goto L_0x0011
            java.lang.String r10 = com.adobe.xmp.impl.Utils.normalizeLangValue(r10)
            goto L_0x0012
        L_0x0011:
            r10 = r13
        L_0x0012:
            java.lang.String r11 = com.adobe.xmp.impl.Utils.normalizeLangValue(r11)
            com.adobe.xmp.impl.xpath.XMPPath r8 = com.adobe.xmp.impl.xpath.XMPPathParser.expandXPath(r8, r9)
            com.adobe.xmp.impl.XMPNode r9 = r7.tree
            com.adobe.xmp.options.PropertyOptions r0 = new com.adobe.xmp.options.PropertyOptions
            r1 = 7680(0x1e00, float:1.0762E-41)
            r0.<init>(r1)
            r1 = 1
            com.adobe.xmp.impl.XMPNode r8 = com.adobe.xmp.impl.XMPNodeUtils.findNode(r9, r8, r1, r0)
            r9 = 102(0x66, float:1.43E-43)
            if (r8 == 0) goto L_0x0169
            com.adobe.xmp.options.PropertyOptions r0 = r8.getOptions()
            boolean r0 = r0.isArrayAltText()
            if (r0 != 0) goto L_0x0056
            boolean r0 = r8.hasChildren()
            if (r0 != 0) goto L_0x004e
            com.adobe.xmp.options.PropertyOptions r0 = r8.getOptions()
            boolean r0 = r0.isArrayAlternate()
            if (r0 == 0) goto L_0x004e
            com.adobe.xmp.options.PropertyOptions r0 = r8.getOptions()
            r0.setArrayAltText(r1)
            goto L_0x0056
        L_0x004e:
            com.adobe.xmp.XMPException r8 = new com.adobe.xmp.XMPException
            java.lang.String r10 = "Specified property is no alt-text array"
            r8.<init>(r10, r9)
            throw r8
        L_0x0056:
            java.util.Iterator r0 = r8.iterateChildren()
        L_0x005a:
            boolean r2 = r0.hasNext()
            r3 = 0
            java.lang.String r4 = "x-default"
            if (r2 == 0) goto L_0x0097
            java.lang.Object r2 = r0.next()
            com.adobe.xmp.impl.XMPNode r2 = (com.adobe.xmp.impl.XMPNode) r2
            boolean r5 = r2.hasQualifier()
            if (r5 == 0) goto L_0x008f
            com.adobe.xmp.impl.XMPNode r5 = r2.getQualifier(r1)
            java.lang.String r5 = r5.getName()
            java.lang.String r6 = "xml:lang"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x008f
            com.adobe.xmp.impl.XMPNode r5 = r2.getQualifier(r1)
            java.lang.String r5 = r5.getValue()
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x005a
            r9 = 1
            goto L_0x0099
        L_0x008f:
            com.adobe.xmp.XMPException r8 = new com.adobe.xmp.XMPException
            java.lang.String r10 = "Language qualifier must be first"
            r8.<init>(r10, r9)
            throw r8
        L_0x0097:
            r2 = r13
            r9 = 0
        L_0x0099:
            if (r2 == 0) goto L_0x00a7
            int r0 = r8.getChildrenLength()
            if (r0 <= r1) goto L_0x00a7
            r8.removeChild((com.adobe.xmp.impl.XMPNode) r2)
            r8.addChild(r1, r2)
        L_0x00a7:
            java.lang.Object[] r10 = com.adobe.xmp.impl.XMPNodeUtils.chooseLocalizedText(r8, r10, r11)
            r0 = r10[r3]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r10 = r10[r1]
            com.adobe.xmp.impl.XMPNode r10 = (com.adobe.xmp.impl.XMPNode) r10
            boolean r3 = r4.equals(r11)
            if (r0 == 0) goto L_0x0154
            if (r0 == r1) goto L_0x010e
            r13 = 2
            if (r0 == r13) goto L_0x00f3
            r10 = 3
            if (r0 == r10) goto L_0x00ec
            r10 = 4
            if (r0 == r10) goto L_0x00dc
            r10 = 5
            if (r0 != r10) goto L_0x00d2
            com.adobe.xmp.impl.XMPNodeUtils.appendLangItem(r8, r11, r12)
            if (r3 == 0) goto L_0x015d
            goto L_0x015c
        L_0x00d2:
            com.adobe.xmp.XMPException r8 = new com.adobe.xmp.XMPException
            r9 = 9
            java.lang.String r10 = "Unexpected result from ChooseLocalizedText"
            r8.<init>(r10, r9)
            throw r8
        L_0x00dc:
            if (r2 == 0) goto L_0x00e7
            int r10 = r8.getChildrenLength()
            if (r10 != r1) goto L_0x00e7
            r2.setValue(r12)
        L_0x00e7:
            com.adobe.xmp.impl.XMPNodeUtils.appendLangItem(r8, r11, r12)
            goto L_0x015d
        L_0x00ec:
            com.adobe.xmp.impl.XMPNodeUtils.appendLangItem(r8, r11, r12)
            if (r3 == 0) goto L_0x015d
            goto L_0x015c
        L_0x00f3:
            if (r9 == 0) goto L_0x010a
            if (r2 == r10) goto L_0x010a
            if (r2 == 0) goto L_0x010a
            java.lang.String r11 = r2.getValue()
            java.lang.String r13 = r10.getValue()
            boolean r11 = r11.equals(r13)
            if (r11 == 0) goto L_0x010a
        L_0x0107:
            r2.setValue(r12)
        L_0x010a:
            r10.setValue(r12)
            goto L_0x015d
        L_0x010e:
            if (r3 != 0) goto L_0x0125
            if (r9 == 0) goto L_0x010a
            if (r2 == r10) goto L_0x010a
            if (r2 == 0) goto L_0x010a
            java.lang.String r11 = r2.getValue()
            java.lang.String r13 = r10.getValue()
            boolean r11 = r11.equals(r13)
            if (r11 == 0) goto L_0x010a
            goto L_0x0107
        L_0x0125:
            java.util.Iterator r10 = r8.iterateChildren()
        L_0x0129:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x014e
            java.lang.Object r11 = r10.next()
            com.adobe.xmp.impl.XMPNode r11 = (com.adobe.xmp.impl.XMPNode) r11
            if (r11 == r2) goto L_0x0129
            java.lang.String r0 = r11.getValue()
            if (r2 == 0) goto L_0x0142
            java.lang.String r3 = r2.getValue()
            goto L_0x0143
        L_0x0142:
            r3 = r13
        L_0x0143:
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x014a
            goto L_0x0129
        L_0x014a:
            r11.setValue(r12)
            goto L_0x0129
        L_0x014e:
            if (r2 == 0) goto L_0x015d
            r2.setValue(r12)
            goto L_0x015d
        L_0x0154:
            com.adobe.xmp.impl.XMPNodeUtils.appendLangItem(r8, r4, r12)
            if (r3 != 0) goto L_0x015c
            com.adobe.xmp.impl.XMPNodeUtils.appendLangItem(r8, r11, r12)
        L_0x015c:
            r9 = 1
        L_0x015d:
            if (r9 != 0) goto L_0x0168
            int r9 = r8.getChildrenLength()
            if (r9 != r1) goto L_0x0168
            com.adobe.xmp.impl.XMPNodeUtils.appendLangItem(r8, r4, r12)
        L_0x0168:
            return
        L_0x0169:
            com.adobe.xmp.XMPException r8 = new com.adobe.xmp.XMPException
            java.lang.String r10 = "Failed to find or create array node"
            r8.<init>(r10, r9)
            goto L_0x0172
        L_0x0171:
            throw r8
        L_0x0172:
            goto L_0x0171
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.xmp.impl.XMPMetaImpl.setLocalizedText(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.adobe.xmp.options.PropertyOptions):void");
    }

    /* access modifiers changed from: package-private */
    public void setNode(XMPNode xMPNode, Object obj, PropertyOptions propertyOptions, boolean z) throws XMPException {
        if (z) {
            xMPNode.clear();
        }
        xMPNode.getOptions().mergeWith(propertyOptions);
        if (!xMPNode.getOptions().isCompositeProperty()) {
            XMPNodeUtils.setNodeValue(xMPNode, obj);
        } else if (obj == null || obj.toString().length() <= 0) {
            xMPNode.removeChildren();
        } else {
            throw new XMPException("Composite nodes can't have values", 102);
        }
    }

    public void setObjectName(String str) {
        this.tree.setName(str);
    }

    public void setPacketHeader(String str) {
        this.packetHeader = str;
    }

    public void setProperty(String str, String str2, Object obj) throws XMPException {
        setProperty(str, str2, obj, (PropertyOptions) null);
    }

    public void setProperty(String str, String str2, Object obj, PropertyOptions propertyOptions) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertPropName(str2);
        PropertyOptions verifySetOptions = XMPNodeUtils.verifySetOptions(propertyOptions, obj);
        XMPNode findNode = XMPNodeUtils.findNode(this.tree, XMPPathParser.expandXPath(str, str2), true, verifySetOptions);
        if (findNode != null) {
            setNode(findNode, obj, verifySetOptions, false);
            return;
        }
        throw new XMPException("Specified property does not exist", 102);
    }

    public void setPropertyBase64(String str, String str2, byte[] bArr) throws XMPException {
        setProperty(str, str2, bArr, (PropertyOptions) null);
    }

    public void setPropertyBase64(String str, String str2, byte[] bArr, PropertyOptions propertyOptions) throws XMPException {
        setProperty(str, str2, bArr, propertyOptions);
    }

    public void setPropertyBoolean(String str, String str2, boolean z) throws XMPException {
        setProperty(str, str2, z ? XMPConst.TRUESTR : XMPConst.FALSESTR, (PropertyOptions) null);
    }

    public void setPropertyBoolean(String str, String str2, boolean z, PropertyOptions propertyOptions) throws XMPException {
        setProperty(str, str2, z ? XMPConst.TRUESTR : XMPConst.FALSESTR, propertyOptions);
    }

    public void setPropertyCalendar(String str, String str2, Calendar calendar) throws XMPException {
        setProperty(str, str2, calendar, (PropertyOptions) null);
    }

    public void setPropertyCalendar(String str, String str2, Calendar calendar, PropertyOptions propertyOptions) throws XMPException {
        setProperty(str, str2, calendar, propertyOptions);
    }

    public void setPropertyDate(String str, String str2, XMPDateTime xMPDateTime) throws XMPException {
        setProperty(str, str2, xMPDateTime, (PropertyOptions) null);
    }

    public void setPropertyDate(String str, String str2, XMPDateTime xMPDateTime, PropertyOptions propertyOptions) throws XMPException {
        setProperty(str, str2, xMPDateTime, propertyOptions);
    }

    public void setPropertyDouble(String str, String str2, double d) throws XMPException {
        setProperty(str, str2, new Double(d), (PropertyOptions) null);
    }

    public void setPropertyDouble(String str, String str2, double d, PropertyOptions propertyOptions) throws XMPException {
        setProperty(str, str2, new Double(d), propertyOptions);
    }

    public void setPropertyInteger(String str, String str2, int i) throws XMPException {
        setProperty(str, str2, new Integer(i), (PropertyOptions) null);
    }

    public void setPropertyInteger(String str, String str2, int i, PropertyOptions propertyOptions) throws XMPException {
        setProperty(str, str2, new Integer(i), propertyOptions);
    }

    public void setPropertyLong(String str, String str2, long j) throws XMPException {
        setProperty(str, str2, new Long(j), (PropertyOptions) null);
    }

    public void setPropertyLong(String str, String str2, long j, PropertyOptions propertyOptions) throws XMPException {
        setProperty(str, str2, new Long(j), propertyOptions);
    }

    public void setQualifier(String str, String str2, String str3, String str4, String str5) throws XMPException {
        setQualifier(str, str2, str3, str4, str5, (PropertyOptions) null);
    }

    public void setQualifier(String str, String str2, String str3, String str4, String str5, PropertyOptions propertyOptions) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertPropName(str2);
        if (doesPropertyExist(str, str2)) {
            setProperty(str, str2 + XMPPathFactory.composeQualifierPath(str3, str4), str5, propertyOptions);
            return;
        }
        throw new XMPException("Specified property does not exist!", 102);
    }

    public void setStructField(String str, String str2, String str3, String str4, String str5) throws XMPException {
        setStructField(str, str2, str3, str4, str5, (PropertyOptions) null);
    }

    public void setStructField(String str, String str2, String str3, String str4, String str5, PropertyOptions propertyOptions) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertStructName(str2);
        setProperty(str, str2 + XMPPathFactory.composeStructFieldPath(str3, str4), str5, propertyOptions);
    }

    public void sort() {
        this.tree.sort();
    }
}

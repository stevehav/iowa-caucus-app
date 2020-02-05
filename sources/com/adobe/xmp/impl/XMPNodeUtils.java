package com.adobe.xmp.impl;

import com.adobe.xmp.XMPConst;
import com.adobe.xmp.XMPDateTime;
import com.adobe.xmp.XMPDateTimeFactory;
import com.adobe.xmp.XMPException;
import com.adobe.xmp.XMPMetaFactory;
import com.adobe.xmp.XMPUtils;
import com.adobe.xmp.impl.xpath.XMPPath;
import com.adobe.xmp.impl.xpath.XMPPathSegment;
import com.adobe.xmp.options.PropertyOptions;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class XMPNodeUtils implements XMPConst {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int CLT_FIRST_ITEM = 5;
    static final int CLT_MULTIPLE_GENERIC = 3;
    static final int CLT_NO_VALUES = 0;
    static final int CLT_SINGLE_GENERIC = 2;
    static final int CLT_SPECIFIC_MATCH = 1;
    static final int CLT_XDEFAULT = 4;

    private XMPNodeUtils() {
    }

    static void appendLangItem(XMPNode xMPNode, String str, String str2) throws XMPException {
        XMPNode xMPNode2 = new XMPNode(XMPConst.ARRAY_ITEM_NAME, str2, (PropertyOptions) null);
        XMPNode xMPNode3 = new XMPNode(XMPConst.XML_LANG, str, (PropertyOptions) null);
        xMPNode2.addQualifier(xMPNode3);
        if (!XMPConst.X_DEFAULT.equals(xMPNode3.getValue())) {
            xMPNode.addChild(xMPNode2);
        } else {
            xMPNode.addChild(1, xMPNode2);
        }
    }

    static Object[] chooseLocalizedText(XMPNode xMPNode, String str, String str2) throws XMPException {
        if (!xMPNode.getOptions().isArrayAltText()) {
            throw new XMPException("Localized text array is not alt-text", 102);
        } else if (!xMPNode.hasChildren()) {
            return new Object[]{new Integer(0), null};
        } else {
            Iterator iterateChildren = xMPNode.iterateChildren();
            XMPNode xMPNode2 = null;
            XMPNode xMPNode3 = null;
            int i = 0;
            while (iterateChildren.hasNext()) {
                XMPNode xMPNode4 = (XMPNode) iterateChildren.next();
                if (xMPNode4.getOptions().isCompositeProperty()) {
                    throw new XMPException("Alt-text array item is not simple", 102);
                } else if (!xMPNode4.hasQualifier() || !XMPConst.XML_LANG.equals(xMPNode4.getQualifier(1).getName())) {
                    throw new XMPException("Alt-text array item has no language qualifier", 102);
                } else {
                    String value = xMPNode4.getQualifier(1).getValue();
                    if (str2.equals(value)) {
                        return new Object[]{new Integer(1), xMPNode4};
                    } else if (str != null && value.startsWith(str)) {
                        if (xMPNode2 == null) {
                            xMPNode2 = xMPNode4;
                        }
                        i++;
                    } else if (XMPConst.X_DEFAULT.equals(value)) {
                        xMPNode3 = xMPNode4;
                    }
                }
            }
            if (i == 1) {
                return new Object[]{new Integer(2), xMPNode2};
            } else if (i > 1) {
                return new Object[]{new Integer(3), xMPNode2};
            } else if (xMPNode3 != null) {
                return new Object[]{new Integer(4), xMPNode3};
            } else {
                return new Object[]{new Integer(5), xMPNode.getChild(1)};
            }
        }
    }

    static void deleteNode(XMPNode xMPNode) {
        XMPNode parent = xMPNode.getParent();
        if (xMPNode.getOptions().isQualifier()) {
            parent.removeQualifier(xMPNode);
        } else {
            parent.removeChild(xMPNode);
        }
        if (!parent.hasChildren() && parent.getOptions().isSchemaNode()) {
            parent.getParent().removeChild(parent);
        }
    }

    static void detectAltText(XMPNode xMPNode) {
        if (xMPNode.getOptions().isArrayAlternate() && xMPNode.hasChildren()) {
            boolean z = false;
            Iterator iterateChildren = xMPNode.iterateChildren();
            while (true) {
                if (iterateChildren.hasNext()) {
                    if (((XMPNode) iterateChildren.next()).getOptions().getHasLanguage()) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (z) {
                xMPNode.getOptions().setArrayAltText(true);
                normalizeLangArray(xMPNode);
            }
        }
    }

    static XMPNode findChildNode(XMPNode xMPNode, String str, boolean z) throws XMPException {
        if (!xMPNode.getOptions().isSchemaNode() && !xMPNode.getOptions().isStruct()) {
            if (!xMPNode.isImplicit()) {
                throw new XMPException("Named children only allowed for schemas and structs", 102);
            } else if (xMPNode.getOptions().isArray()) {
                throw new XMPException("Named children not allowed for arrays", 102);
            } else if (z) {
                xMPNode.getOptions().setStruct(true);
            }
        }
        XMPNode findChildByName = xMPNode.findChildByName(str);
        if (findChildByName != null || !z) {
            return findChildByName;
        }
        XMPNode xMPNode2 = new XMPNode(str, new PropertyOptions());
        xMPNode2.setImplicit(true);
        xMPNode.addChild(xMPNode2);
        return xMPNode2;
    }

    private static int findIndexedItem(XMPNode xMPNode, String str, boolean z) throws XMPException {
        try {
            int parseInt = Integer.parseInt(str.substring(1, str.length() - 1));
            if (parseInt >= 1) {
                if (z && parseInt == xMPNode.getChildrenLength() + 1) {
                    XMPNode xMPNode2 = new XMPNode(XMPConst.ARRAY_ITEM_NAME, (PropertyOptions) null);
                    xMPNode2.setImplicit(true);
                    xMPNode.addChild(xMPNode2);
                }
                return parseInt;
            }
            throw new XMPException("Array index must be larger than zero", 102);
        } catch (NumberFormatException unused) {
            throw new XMPException("Array index not digits.", 102);
        }
    }

    static XMPNode findNode(XMPNode xMPNode, XMPPath xMPPath, boolean z, PropertyOptions propertyOptions) throws XMPException {
        XMPNode xMPNode2;
        if (xMPPath == null || xMPPath.size() == 0) {
            throw new XMPException("Empty XMPPath", 102);
        }
        XMPNode findSchemaNode = findSchemaNode(xMPNode, xMPPath.getSegment(0).getName(), z);
        if (findSchemaNode == null) {
            return null;
        }
        if (findSchemaNode.isImplicit()) {
            findSchemaNode.setImplicit(false);
            xMPNode2 = findSchemaNode;
        } else {
            xMPNode2 = null;
        }
        XMPNode xMPNode3 = xMPNode2;
        XMPNode xMPNode4 = findSchemaNode;
        int i = 1;
        while (i < xMPPath.size()) {
            try {
                xMPNode4 = followXPathStep(xMPNode4, xMPPath.getSegment(i), z);
                if (xMPNode4 == null) {
                    if (z) {
                        deleteNode(xMPNode3);
                    }
                    return null;
                }
                if (xMPNode4.isImplicit()) {
                    xMPNode4.setImplicit(false);
                    if (i == 1 && xMPPath.getSegment(i).isAlias() && xMPPath.getSegment(i).getAliasForm() != 0) {
                        xMPNode4.getOptions().setOption(xMPPath.getSegment(i).getAliasForm(), true);
                    } else if (i < xMPPath.size() - 1 && xMPPath.getSegment(i).getKind() == 1 && !xMPNode4.getOptions().isCompositeProperty()) {
                        xMPNode4.getOptions().setStruct(true);
                    }
                    if (xMPNode3 == null) {
                        xMPNode3 = xMPNode4;
                    }
                }
                i++;
            } catch (XMPException e) {
                if (xMPNode3 != null) {
                    deleteNode(xMPNode3);
                }
                throw e;
            }
        }
        if (xMPNode3 != null) {
            xMPNode4.getOptions().mergeWith(propertyOptions);
            xMPNode4.setOptions(xMPNode4.getOptions());
        }
        return xMPNode4;
    }

    private static XMPNode findQualifierNode(XMPNode xMPNode, String str, boolean z) throws XMPException {
        XMPNode findQualifierByName = xMPNode.findQualifierByName(str);
        if (findQualifierByName != null || !z) {
            return findQualifierByName;
        }
        XMPNode xMPNode2 = new XMPNode(str, (PropertyOptions) null);
        xMPNode2.setImplicit(true);
        xMPNode.addQualifier(xMPNode2);
        return xMPNode2;
    }

    static XMPNode findSchemaNode(XMPNode xMPNode, String str, String str2, boolean z) throws XMPException {
        XMPNode findChildByName = xMPNode.findChildByName(str);
        if (findChildByName == null && z) {
            findChildByName = new XMPNode(str, new PropertyOptions().setSchemaNode(true));
            findChildByName.setImplicit(true);
            String namespacePrefix = XMPMetaFactory.getSchemaRegistry().getNamespacePrefix(str);
            if (namespacePrefix == null) {
                if (str2 == null || str2.length() == 0) {
                    throw new XMPException("Unregistered schema namespace URI", 101);
                }
                namespacePrefix = XMPMetaFactory.getSchemaRegistry().registerNamespace(str, str2);
            }
            findChildByName.setValue(namespacePrefix);
            xMPNode.addChild(findChildByName);
        }
        return findChildByName;
    }

    static XMPNode findSchemaNode(XMPNode xMPNode, String str, boolean z) throws XMPException {
        return findSchemaNode(xMPNode, str, (String) null, z);
    }

    private static XMPNode followXPathStep(XMPNode xMPNode, XMPPathSegment xMPPathSegment, boolean z) throws XMPException {
        int i;
        int kind = xMPPathSegment.getKind();
        if (kind == 1) {
            return findChildNode(xMPNode, xMPPathSegment.getName(), z);
        }
        if (kind == 2) {
            return findQualifierNode(xMPNode, xMPPathSegment.getName().substring(1), z);
        }
        if (xMPNode.getOptions().isArray()) {
            if (kind == 3) {
                i = findIndexedItem(xMPNode, xMPPathSegment.getName(), z);
            } else if (kind == 4) {
                i = xMPNode.getChildrenLength();
            } else if (kind == 6) {
                String[] splitNameAndValue = Utils.splitNameAndValue(xMPPathSegment.getName());
                i = lookupFieldSelector(xMPNode, splitNameAndValue[0], splitNameAndValue[1]);
            } else if (kind == 5) {
                String[] splitNameAndValue2 = Utils.splitNameAndValue(xMPPathSegment.getName());
                i = lookupQualSelector(xMPNode, splitNameAndValue2[0], splitNameAndValue2[1], xMPPathSegment.getAliasForm());
            } else {
                throw new XMPException("Unknown array indexing step in FollowXPathStep", 9);
            }
            if (1 > i || i > xMPNode.getChildrenLength()) {
                return null;
            }
            return xMPNode.getChild(i);
        }
        throw new XMPException("Indexing applied to non-array", 102);
    }

    private static int lookupFieldSelector(XMPNode xMPNode, String str, String str2) throws XMPException {
        int i = 1;
        int i2 = -1;
        while (i <= xMPNode.getChildrenLength() && i2 < 0) {
            XMPNode child = xMPNode.getChild(i);
            if (child.getOptions().isStruct()) {
                int i3 = 1;
                while (true) {
                    if (i3 > child.getChildrenLength()) {
                        break;
                    }
                    XMPNode child2 = child.getChild(i3);
                    if (str.equals(child2.getName()) && str2.equals(child2.getValue())) {
                        i2 = i;
                        break;
                    }
                    i3++;
                }
                i++;
            } else {
                throw new XMPException("Field selector must be used on array of struct", 102);
            }
        }
        return i2;
    }

    static int lookupLanguageItem(XMPNode xMPNode, String str) throws XMPException {
        if (xMPNode.getOptions().isArray()) {
            for (int i = 1; i <= xMPNode.getChildrenLength(); i++) {
                XMPNode child = xMPNode.getChild(i);
                if (child.hasQualifier() && XMPConst.XML_LANG.equals(child.getQualifier(1).getName()) && str.equals(child.getQualifier(1).getValue())) {
                    return i;
                }
            }
            return -1;
        }
        throw new XMPException("Language item must be used on array", 102);
    }

    private static int lookupQualSelector(XMPNode xMPNode, String str, String str2, int i) throws XMPException {
        if (XMPConst.XML_LANG.equals(str)) {
            int lookupLanguageItem = lookupLanguageItem(xMPNode, Utils.normalizeLangValue(str2));
            if (lookupLanguageItem >= 0 || (i & 4096) <= 0) {
                return lookupLanguageItem;
            }
            XMPNode xMPNode2 = new XMPNode(XMPConst.ARRAY_ITEM_NAME, (PropertyOptions) null);
            xMPNode2.addQualifier(new XMPNode(XMPConst.XML_LANG, XMPConst.X_DEFAULT, (PropertyOptions) null));
            xMPNode.addChild(1, xMPNode2);
            return 1;
        }
        for (int i2 = 1; i2 < xMPNode.getChildrenLength(); i2++) {
            Iterator iterateQualifier = xMPNode.getChild(i2).iterateQualifier();
            while (iterateQualifier.hasNext()) {
                XMPNode xMPNode3 = (XMPNode) iterateQualifier.next();
                if (str.equals(xMPNode3.getName()) && str2.equals(xMPNode3.getValue())) {
                    return i2;
                }
            }
        }
        return -1;
    }

    static void normalizeLangArray(XMPNode xMPNode) {
        if (xMPNode.getOptions().isArrayAltText()) {
            int i = 2;
            while (i <= xMPNode.getChildrenLength()) {
                XMPNode child = xMPNode.getChild(i);
                if (!child.hasQualifier() || !XMPConst.X_DEFAULT.equals(child.getQualifier(1).getValue())) {
                    i++;
                } else {
                    try {
                        xMPNode.removeChild(i);
                        xMPNode.addChild(1, child);
                    } catch (XMPException unused) {
                    }
                    if (i == 2) {
                        xMPNode.getChild(2).setValue(child.getValue());
                        return;
                    }
                    return;
                }
            }
        }
    }

    static String serializeNodeValue(Object obj) {
        String str;
        XMPDateTime createFromCalendar;
        if (obj == null) {
            str = null;
        } else if (obj instanceof Boolean) {
            str = XMPUtils.convertFromBoolean(((Boolean) obj).booleanValue());
        } else if (obj instanceof Integer) {
            str = XMPUtils.convertFromInteger(((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            str = XMPUtils.convertFromLong(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            str = XMPUtils.convertFromDouble(((Double) obj).doubleValue());
        } else {
            if (obj instanceof XMPDateTime) {
                createFromCalendar = (XMPDateTime) obj;
            } else if (obj instanceof GregorianCalendar) {
                createFromCalendar = XMPDateTimeFactory.createFromCalendar((GregorianCalendar) obj);
            } else {
                str = obj instanceof byte[] ? XMPUtils.encodeBase64((byte[]) obj) : obj.toString();
            }
            str = XMPUtils.convertFromDate(createFromCalendar);
        }
        if (str != null) {
            return Utils.removeControlChars(str);
        }
        return null;
    }

    static void setNodeValue(XMPNode xMPNode, Object obj) {
        String serializeNodeValue = serializeNodeValue(obj);
        if (xMPNode.getOptions().isQualifier() && XMPConst.XML_LANG.equals(xMPNode.getName())) {
            serializeNodeValue = Utils.normalizeLangValue(serializeNodeValue);
        }
        xMPNode.setValue(serializeNodeValue);
    }

    static PropertyOptions verifySetOptions(PropertyOptions propertyOptions, Object obj) throws XMPException {
        if (propertyOptions == null) {
            propertyOptions = new PropertyOptions();
        }
        if (propertyOptions.isArrayAltText()) {
            propertyOptions.setArrayAlternate(true);
        }
        if (propertyOptions.isArrayAlternate()) {
            propertyOptions.setArrayOrdered(true);
        }
        if (propertyOptions.isArrayOrdered()) {
            propertyOptions.setArray(true);
        }
        if (!propertyOptions.isCompositeProperty() || obj == null || obj.toString().length() <= 0) {
            propertyOptions.assertConsistency(propertyOptions.getOptions());
            return propertyOptions;
        }
        throw new XMPException("Structs and arrays can't have values", 103);
    }
}

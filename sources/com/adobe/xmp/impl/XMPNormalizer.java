package com.adobe.xmp.impl;

import com.adobe.xmp.XMPConst;
import com.adobe.xmp.XMPDateTime;
import com.adobe.xmp.XMPError;
import com.adobe.xmp.XMPException;
import com.adobe.xmp.XMPMeta;
import com.adobe.xmp.XMPMetaFactory;
import com.adobe.xmp.XMPUtils;
import com.adobe.xmp.impl.xpath.XMPPathParser;
import com.adobe.xmp.options.ParseOptions;
import com.adobe.xmp.options.PropertyOptions;
import com.adobe.xmp.properties.XMPAliasInfo;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class XMPNormalizer {
    private static Map dcArrayForms;

    static {
        initDCArrays();
    }

    private XMPNormalizer() {
    }

    private static void compareAliasedSubtrees(XMPNode xMPNode, XMPNode xMPNode2, boolean z) throws XMPException {
        if (!xMPNode.getValue().equals(xMPNode2.getValue()) || xMPNode.getChildrenLength() != xMPNode2.getChildrenLength()) {
            throw new XMPException("Mismatch between alias and base nodes", XMPError.BADXMP);
        } else if (z || (xMPNode.getName().equals(xMPNode2.getName()) && xMPNode.getOptions().equals(xMPNode2.getOptions()) && xMPNode.getQualifierLength() == xMPNode2.getQualifierLength())) {
            Iterator iterateChildren = xMPNode.iterateChildren();
            Iterator iterateChildren2 = xMPNode2.iterateChildren();
            while (iterateChildren.hasNext() && iterateChildren2.hasNext()) {
                compareAliasedSubtrees((XMPNode) iterateChildren.next(), (XMPNode) iterateChildren2.next(), false);
            }
            Iterator iterateQualifier = xMPNode.iterateQualifier();
            Iterator iterateQualifier2 = xMPNode2.iterateQualifier();
            while (iterateQualifier.hasNext() && iterateQualifier2.hasNext()) {
                compareAliasedSubtrees((XMPNode) iterateQualifier.next(), (XMPNode) iterateQualifier2.next(), false);
            }
        } else {
            throw new XMPException("Mismatch between alias and base nodes", XMPError.BADXMP);
        }
    }

    private static void deleteEmptySchemas(XMPNode xMPNode) {
        Iterator iterateChildren = xMPNode.iterateChildren();
        while (iterateChildren.hasNext()) {
            if (!((XMPNode) iterateChildren.next()).hasChildren()) {
                iterateChildren.remove();
            }
        }
    }

    private static void fixGPSTimeStamp(XMPNode xMPNode) throws XMPException {
        XMPNode findChildNode = XMPNodeUtils.findChildNode(xMPNode, "exif:GPSTimeStamp", false);
        if (findChildNode != null) {
            try {
                XMPDateTime convertToDate = XMPUtils.convertToDate(findChildNode.getValue());
                if (convertToDate.getYear() != 0 || convertToDate.getMonth() != 0) {
                    return;
                }
                if (convertToDate.getDay() == 0) {
                    XMPNode findChildNode2 = XMPNodeUtils.findChildNode(xMPNode, "exif:DateTimeOriginal", false);
                    if (findChildNode2 == null) {
                        findChildNode2 = XMPNodeUtils.findChildNode(xMPNode, "exif:DateTimeDigitized", false);
                    }
                    XMPDateTime convertToDate2 = XMPUtils.convertToDate(findChildNode2.getValue());
                    Calendar calendar = convertToDate.getCalendar();
                    calendar.set(1, convertToDate2.getYear());
                    calendar.set(2, convertToDate2.getMonth());
                    calendar.set(5, convertToDate2.getDay());
                    findChildNode.setValue(XMPUtils.convertFromDate(new XMPDateTimeImpl(calendar)));
                }
            } catch (XMPException unused) {
            }
        }
    }

    private static void initDCArrays() {
        dcArrayForms = new HashMap();
        PropertyOptions propertyOptions = new PropertyOptions();
        propertyOptions.setArray(true);
        dcArrayForms.put("dc:contributor", propertyOptions);
        dcArrayForms.put("dc:language", propertyOptions);
        dcArrayForms.put("dc:publisher", propertyOptions);
        dcArrayForms.put("dc:relation", propertyOptions);
        dcArrayForms.put("dc:subject", propertyOptions);
        dcArrayForms.put("dc:type", propertyOptions);
        PropertyOptions propertyOptions2 = new PropertyOptions();
        propertyOptions2.setArray(true);
        propertyOptions2.setArrayOrdered(true);
        dcArrayForms.put("dc:creator", propertyOptions2);
        dcArrayForms.put("dc:date", propertyOptions2);
        PropertyOptions propertyOptions3 = new PropertyOptions();
        propertyOptions3.setArray(true);
        propertyOptions3.setArrayOrdered(true);
        propertyOptions3.setArrayAlternate(true);
        propertyOptions3.setArrayAltText(true);
        dcArrayForms.put("dc:description", propertyOptions3);
        dcArrayForms.put("dc:rights", propertyOptions3);
        dcArrayForms.put("dc:title", propertyOptions3);
    }

    private static void migrateAudioCopyright(XMPMeta xMPMeta, XMPNode xMPNode) {
        String str;
        try {
            XMPNode findSchemaNode = XMPNodeUtils.findSchemaNode(((XMPMetaImpl) xMPMeta).getRoot(), "http://purl.org/dc/elements/1.1/", true);
            String value = xMPNode.getValue();
            XMPNode findChildNode = XMPNodeUtils.findChildNode(findSchemaNode, "dc:rights", false);
            if (findChildNode != null) {
                if (findChildNode.hasChildren()) {
                    int lookupLanguageItem = XMPNodeUtils.lookupLanguageItem(findChildNode, XMPConst.X_DEFAULT);
                    if (lookupLanguageItem < 0) {
                        xMPMeta.setLocalizedText("http://purl.org/dc/elements/1.1/", "rights", "", XMPConst.X_DEFAULT, findChildNode.getChild(1).getValue(), (PropertyOptions) null);
                        lookupLanguageItem = XMPNodeUtils.lookupLanguageItem(findChildNode, XMPConst.X_DEFAULT);
                    }
                    XMPNode child = findChildNode.getChild(lookupLanguageItem);
                    String value2 = child.getValue();
                    int indexOf = value2.indexOf("\n\n");
                    if (indexOf < 0) {
                        if (!value.equals(value2)) {
                            str = value2 + "\n\n" + value;
                        }
                        xMPNode.getParent().removeChild(xMPNode);
                    }
                    int i = indexOf + 2;
                    if (!value2.substring(i).equals(value)) {
                        str = value2.substring(0, i) + value;
                    }
                    xMPNode.getParent().removeChild(xMPNode);
                    child.setValue(str);
                    xMPNode.getParent().removeChild(xMPNode);
                }
            }
            xMPMeta.setLocalizedText("http://purl.org/dc/elements/1.1/", "rights", "", XMPConst.X_DEFAULT, "\n\n" + value, (PropertyOptions) null);
            xMPNode.getParent().removeChild(xMPNode);
        } catch (XMPException unused) {
        }
    }

    private static void moveExplicitAliases(XMPNode xMPNode, ParseOptions parseOptions) throws XMPException {
        if (xMPNode.getHasAliases()) {
            xMPNode.setHasAliases(false);
            boolean strictAliasing = parseOptions.getStrictAliasing();
            for (XMPNode xMPNode2 : xMPNode.getUnmodifiableChildren()) {
                if (xMPNode2.getHasAliases()) {
                    Iterator iterateChildren = xMPNode2.iterateChildren();
                    while (iterateChildren.hasNext()) {
                        XMPNode xMPNode3 = (XMPNode) iterateChildren.next();
                        if (xMPNode3.isAlias()) {
                            xMPNode3.setAlias(false);
                            XMPAliasInfo findAlias = XMPMetaFactory.getSchemaRegistry().findAlias(xMPNode3.getName());
                            if (findAlias != null) {
                                XMPNode xMPNode4 = null;
                                XMPNode findSchemaNode = XMPNodeUtils.findSchemaNode(xMPNode, findAlias.getNamespace(), (String) null, true);
                                findSchemaNode.setImplicit(false);
                                XMPNode findChildNode = XMPNodeUtils.findChildNode(findSchemaNode, findAlias.getPrefix() + findAlias.getPropName(), false);
                                if (findChildNode == null) {
                                    if (findAlias.getAliasForm().isSimple()) {
                                        xMPNode3.setName(findAlias.getPrefix() + findAlias.getPropName());
                                        findSchemaNode.addChild(xMPNode3);
                                    } else {
                                        XMPNode xMPNode5 = new XMPNode(findAlias.getPrefix() + findAlias.getPropName(), findAlias.getAliasForm().toPropertyOptions());
                                        findSchemaNode.addChild(xMPNode5);
                                        transplantArrayItemAlias(iterateChildren, xMPNode3, xMPNode5);
                                    }
                                } else if (!findAlias.getAliasForm().isSimple()) {
                                    if (findAlias.getAliasForm().isArrayAltText()) {
                                        int lookupLanguageItem = XMPNodeUtils.lookupLanguageItem(findChildNode, XMPConst.X_DEFAULT);
                                        if (lookupLanguageItem != -1) {
                                            xMPNode4 = findChildNode.getChild(lookupLanguageItem);
                                        }
                                    } else if (findChildNode.hasChildren()) {
                                        xMPNode4 = findChildNode.getChild(1);
                                    }
                                    if (xMPNode4 == null) {
                                        transplantArrayItemAlias(iterateChildren, xMPNode3, findChildNode);
                                    } else if (strictAliasing) {
                                        compareAliasedSubtrees(xMPNode3, xMPNode4, true);
                                    }
                                } else if (strictAliasing) {
                                    compareAliasedSubtrees(xMPNode3, findChildNode, true);
                                }
                                iterateChildren.remove();
                            }
                        }
                    }
                    xMPNode2.setHasAliases(false);
                }
            }
        }
    }

    private static void normalizeDCArrays(XMPNode xMPNode) throws XMPException {
        for (int i = 1; i <= xMPNode.getChildrenLength(); i++) {
            XMPNode child = xMPNode.getChild(i);
            PropertyOptions propertyOptions = (PropertyOptions) dcArrayForms.get(child.getName());
            if (propertyOptions != null) {
                if (child.getOptions().isSimple()) {
                    XMPNode xMPNode2 = new XMPNode(child.getName(), propertyOptions);
                    child.setName(XMPConst.ARRAY_ITEM_NAME);
                    xMPNode2.addChild(child);
                    xMPNode.replaceChild(i, xMPNode2);
                    if (propertyOptions.isArrayAltText() && !child.getOptions().getHasLanguage()) {
                        child.addQualifier(new XMPNode(XMPConst.XML_LANG, XMPConst.X_DEFAULT, (PropertyOptions) null));
                    }
                } else {
                    child.getOptions().setOption(7680, false);
                    child.getOptions().mergeWith(propertyOptions);
                    if (propertyOptions.isArrayAltText()) {
                        repairAltText(child);
                    }
                }
            }
        }
    }

    static XMPMeta process(XMPMetaImpl xMPMetaImpl, ParseOptions parseOptions) throws XMPException {
        XMPNode root = xMPMetaImpl.getRoot();
        touchUpDataModel(xMPMetaImpl);
        moveExplicitAliases(root, parseOptions);
        tweakOldXMP(root);
        deleteEmptySchemas(root);
        return xMPMetaImpl;
    }

    private static void repairAltText(XMPNode xMPNode) throws XMPException {
        if (xMPNode != null && xMPNode.getOptions().isArray()) {
            xMPNode.getOptions().setArrayOrdered(true).setArrayAlternate(true).setArrayAltText(true);
            Iterator iterateChildren = xMPNode.iterateChildren();
            while (iterateChildren.hasNext()) {
                XMPNode xMPNode2 = (XMPNode) iterateChildren.next();
                if (!xMPNode2.getOptions().isCompositeProperty()) {
                    if (!xMPNode2.getOptions().getHasLanguage()) {
                        String value = xMPNode2.getValue();
                        if (!(value == null || value.length() == 0)) {
                            xMPNode2.addQualifier(new XMPNode(XMPConst.XML_LANG, "x-repair", (PropertyOptions) null));
                        }
                    }
                }
                iterateChildren.remove();
            }
        }
    }

    private static void touchUpDataModel(XMPMetaImpl xMPMetaImpl) throws XMPException {
        XMPNode findChildNode;
        XMPNodeUtils.findSchemaNode(xMPMetaImpl.getRoot(), "http://purl.org/dc/elements/1.1/", true);
        Iterator iterateChildren = xMPMetaImpl.getRoot().iterateChildren();
        while (iterateChildren.hasNext()) {
            XMPNode xMPNode = (XMPNode) iterateChildren.next();
            if ("http://purl.org/dc/elements/1.1/".equals(xMPNode.getName())) {
                normalizeDCArrays(xMPNode);
            } else {
                if ("http://ns.adobe.com/exif/1.0/".equals(xMPNode.getName())) {
                    fixGPSTimeStamp(xMPNode);
                    findChildNode = XMPNodeUtils.findChildNode(xMPNode, "exif:UserComment", false);
                    if (findChildNode == null) {
                    }
                } else if (XMPConst.NS_DM.equals(xMPNode.getName())) {
                    XMPNode findChildNode2 = XMPNodeUtils.findChildNode(xMPNode, "xmpDM:copyright", false);
                    if (findChildNode2 != null) {
                        migrateAudioCopyright(xMPMetaImpl, findChildNode2);
                    }
                } else if (XMPConst.NS_XMP_RIGHTS.equals(xMPNode.getName())) {
                    findChildNode = XMPNodeUtils.findChildNode(xMPNode, "xmpRights:UsageTerms", false);
                    if (findChildNode == null) {
                    }
                }
                repairAltText(findChildNode);
            }
        }
    }

    private static void transplantArrayItemAlias(Iterator it, XMPNode xMPNode, XMPNode xMPNode2) throws XMPException {
        if (xMPNode2.getOptions().isArrayAltText()) {
            if (!xMPNode.getOptions().getHasLanguage()) {
                xMPNode.addQualifier(new XMPNode(XMPConst.XML_LANG, XMPConst.X_DEFAULT, (PropertyOptions) null));
            } else {
                throw new XMPException("Alias to x-default already has a language qualifier", XMPError.BADXMP);
            }
        }
        it.remove();
        xMPNode.setName(XMPConst.ARRAY_ITEM_NAME);
        xMPNode2.addChild(xMPNode);
    }

    private static void tweakOldXMP(XMPNode xMPNode) throws XMPException {
        if (xMPNode.getName() != null && xMPNode.getName().length() >= 36) {
            String lowerCase = xMPNode.getName().toLowerCase();
            if (lowerCase.startsWith("uuid:")) {
                lowerCase = lowerCase.substring(5);
            }
            if (Utils.checkUUIDFormat(lowerCase)) {
                XMPNode findNode = XMPNodeUtils.findNode(xMPNode, XMPPathParser.expandXPath(XMPConst.NS_XMP_MM, "InstanceID"), true, (PropertyOptions) null);
                if (findNode != null) {
                    findNode.setOptions((PropertyOptions) null);
                    findNode.setValue("uuid:" + lowerCase);
                    findNode.removeChildren();
                    findNode.removeQualifiers();
                    xMPNode.setName((String) null);
                    return;
                }
                throw new XMPException("Failure creating xmpMM:InstanceID", 9);
            }
        }
    }
}

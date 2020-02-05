package com.adobe.xmp.impl;

import com.adobe.xmp.XMPConst;
import com.adobe.xmp.XMPError;
import com.adobe.xmp.XMPException;
import com.adobe.xmp.XMPMeta;
import com.adobe.xmp.XMPMetaFactory;
import com.adobe.xmp.XMPSchemaRegistry;
import com.adobe.xmp.options.SerializeOptions;
import com.drew.metadata.photoshop.PhotoshopDirectory;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class XMPSerializerRDF {
    private static final int DEFAULT_PAD = 2048;
    private static final String PACKET_HEADER = "<?xpacket begin=\"﻿\" id=\"W5M0MpCehiHzreSzNTczkc9d\"?>";
    private static final String PACKET_TRAILER = "<?xpacket end=\"";
    private static final String PACKET_TRAILER2 = "\"?>";
    static final Set RDF_ATTR_QUALIFIER = new HashSet(Arrays.asList(new String[]{XMPConst.XML_LANG, "rdf:resource", "rdf:ID", "rdf:bagID", "rdf:nodeID"}));
    private static final String RDF_EMPTY_STRUCT = "<rdf:Description/>";
    private static final String RDF_RDF_END = "</rdf:RDF>";
    private static final String RDF_RDF_START = "<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">";
    private static final String RDF_SCHEMA_END = "</rdf:Description>";
    private static final String RDF_SCHEMA_START = "<rdf:Description rdf:about=";
    private static final String RDF_STRUCT_END = "</rdf:Description>";
    private static final String RDF_STRUCT_START = "<rdf:Description";
    private static final String RDF_XMPMETA_END = "</x:xmpmeta>";
    private static final String RDF_XMPMETA_START = "<x:xmpmeta xmlns:x=\"adobe:ns:meta/\" x:xmptk=\"";
    private SerializeOptions options;
    private CountOutputStream outputStream;
    private int padding;
    private int unicodeSize = 1;
    private OutputStreamWriter writer;
    private XMPMetaImpl xmp;

    private void addPadding(int i) throws XMPException, IOException {
        if (this.options.getExactPacketLength()) {
            int bytesWritten = this.outputStream.getBytesWritten() + (i * this.unicodeSize);
            int i2 = this.padding;
            if (bytesWritten <= i2) {
                this.padding = i2 - bytesWritten;
            } else {
                throw new XMPException("Can't fit into specified packet size", 107);
            }
        }
        this.padding /= this.unicodeSize;
        int length = this.options.getNewline().length();
        int i3 = this.padding;
        if (i3 >= length) {
            int i4 = i3 - length;
            while (true) {
                this.padding = i4;
                int i5 = this.padding;
                int i6 = length + 100;
                if (i5 >= i6) {
                    writeChars(100, ' ');
                    writeNewline();
                    i4 = this.padding - i6;
                } else {
                    writeChars(i5, ' ');
                    writeNewline();
                    return;
                }
            }
        } else {
            writeChars(i3, ' ');
        }
    }

    private void appendNodeValue(String str, boolean z) throws IOException {
        if (str == null) {
            str = "";
        }
        write(Utils.escapeXML(str, z, true));
    }

    private boolean canBeRDFAttrProp(XMPNode xMPNode) {
        return !xMPNode.hasQualifier() && !xMPNode.getOptions().isURI() && !xMPNode.getOptions().isCompositeProperty() && !XMPConst.ARRAY_ITEM_NAME.equals(xMPNode.getName());
    }

    private void declareNamespace(String str, String str2, Set set, int i) throws IOException {
        if (str2 == null) {
            QName qName = new QName(str);
            if (qName.hasPrefix()) {
                str = qName.getPrefix();
                XMPSchemaRegistry schemaRegistry = XMPMetaFactory.getSchemaRegistry();
                str2 = schemaRegistry.getNamespaceURI(str + ":");
                declareNamespace(str, str2, set, i);
            } else {
                return;
            }
        }
        if (!set.contains(str)) {
            writeNewline();
            writeIndent(i);
            write("xmlns:");
            write(str);
            write("=\"");
            write(str2);
            write(34);
            set.add(str);
        }
    }

    private void declareUsedNamespaces(XMPNode xMPNode, Set set, int i) throws IOException {
        if (xMPNode.getOptions().isSchemaNode()) {
            declareNamespace(xMPNode.getValue().substring(0, xMPNode.getValue().length() - 1), xMPNode.getName(), set, i);
        } else if (xMPNode.getOptions().isStruct()) {
            Iterator iterateChildren = xMPNode.iterateChildren();
            while (iterateChildren.hasNext()) {
                declareNamespace(((XMPNode) iterateChildren.next()).getName(), (String) null, set, i);
            }
        }
        Iterator iterateChildren2 = xMPNode.iterateChildren();
        while (iterateChildren2.hasNext()) {
            declareUsedNamespaces((XMPNode) iterateChildren2.next(), set, i);
        }
        Iterator iterateQualifier = xMPNode.iterateQualifier();
        while (iterateQualifier.hasNext()) {
            XMPNode xMPNode2 = (XMPNode) iterateQualifier.next();
            declareNamespace(xMPNode2.getName(), (String) null, set, i);
            declareUsedNamespaces(xMPNode2, set, i);
        }
    }

    private void emitRDFArrayTag(XMPNode xMPNode, boolean z, int i) throws IOException {
        if (z || xMPNode.hasChildren()) {
            writeIndent(i);
            write(z ? "<rdf:" : "</rdf:");
            write(xMPNode.getOptions().isArrayAlternate() ? "Alt" : xMPNode.getOptions().isArrayOrdered() ? "Seq" : "Bag");
            write((!z || xMPNode.hasChildren()) ? ">" : "/>");
            writeNewline();
        }
    }

    private void endOuterRDFDescription(int i) throws IOException {
        writeIndent(i + 1);
        write("</rdf:Description>");
        writeNewline();
    }

    private String serializeAsRDF() throws IOException, XMPException {
        int i = 0;
        if (!this.options.getOmitPacketWrapper()) {
            writeIndent(0);
            write(PACKET_HEADER);
            writeNewline();
        }
        if (!this.options.getOmitXmpMetaElement()) {
            writeIndent(0);
            write(RDF_XMPMETA_START);
            if (!this.options.getOmitVersionAttribute()) {
                write(XMPMetaFactory.getVersionInfo().getMessage());
            }
            write("\">");
            writeNewline();
            i = 1;
        }
        writeIndent(i);
        write(RDF_RDF_START);
        writeNewline();
        if (this.options.getUseCanonicalFormat()) {
            serializeCanonicalRDFSchemas(i);
        } else {
            serializeCompactRDFSchemas(i);
        }
        writeIndent(i);
        write(RDF_RDF_END);
        writeNewline();
        if (!this.options.getOmitXmpMetaElement()) {
            writeIndent(i - 1);
            write(RDF_XMPMETA_END);
            writeNewline();
        }
        String str = "";
        if (this.options.getOmitPacketWrapper()) {
            return str;
        }
        for (int baseIndent = this.options.getBaseIndent(); baseIndent > 0; baseIndent--) {
            str = str + this.options.getIndent();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str + PACKET_TRAILER);
        sb.append(this.options.getReadOnlyPacket() ? 'r' : 'w');
        return sb.toString() + PACKET_TRAILER2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c3, code lost:
        if (r2 != false) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01c0, code lost:
        if (r2 != false) goto L_0x00c5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void serializeCanonicalRDFProperty(com.adobe.xmp.impl.XMPNode r17, boolean r18, boolean r19, int r20) throws java.io.IOException, com.adobe.xmp.XMPException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r20
            java.lang.String r4 = r17.getName()
            if (r19 == 0) goto L_0x0011
            java.lang.String r4 = "rdf:value"
            goto L_0x001b
        L_0x0011:
            java.lang.String r5 = "[]"
            boolean r5 = r5.equals(r4)
            if (r5 == 0) goto L_0x001b
            java.lang.String r4 = "rdf:li"
        L_0x001b:
            r0.writeIndent(r3)
            r5 = 60
            r0.write((int) r5)
            r0.write((java.lang.String) r4)
            java.util.Iterator r5 = r17.iterateQualifier()
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x002d:
            boolean r9 = r5.hasNext()
            r10 = 34
            java.lang.String r11 = "=\""
            r12 = 32
            r13 = 1
            if (r9 == 0) goto L_0x0072
            java.lang.Object r9 = r5.next()
            com.adobe.xmp.impl.XMPNode r9 = (com.adobe.xmp.impl.XMPNode) r9
            java.util.Set r14 = RDF_ATTR_QUALIFIER
            java.lang.String r15 = r9.getName()
            boolean r14 = r14.contains(r15)
            if (r14 != 0) goto L_0x004e
            r7 = 1
            goto L_0x002d
        L_0x004e:
            java.lang.String r8 = r9.getName()
            java.lang.String r14 = "rdf:resource"
            boolean r8 = r14.equals(r8)
            if (r19 != 0) goto L_0x002d
            r0.write((int) r12)
            java.lang.String r12 = r9.getName()
            r0.write((java.lang.String) r12)
            r0.write((java.lang.String) r11)
            java.lang.String r9 = r9.getValue()
            r0.appendNodeValue(r9, r13)
            r0.write((int) r10)
            goto L_0x002d
        L_0x0072:
            java.lang.String r5 = "</rdf:Description>"
            java.lang.String r9 = "<rdf:Description"
            java.lang.String r14 = " rdf:parseType=\"Resource\">"
            r15 = 202(0xca, float:2.83E-43)
            r10 = 62
            java.lang.String r12 = ">"
            if (r7 == 0) goto L_0x00db
            if (r19 != 0) goto L_0x00db
            if (r8 != 0) goto L_0x00d3
            if (r2 == 0) goto L_0x0098
            r0.write((java.lang.String) r12)
            r16.writeNewline()
            int r3 = r3 + 1
            r0.writeIndent(r3)
            r0.write((java.lang.String) r9)
            r0.write((java.lang.String) r12)
            goto L_0x009b
        L_0x0098:
            r0.write((java.lang.String) r14)
        L_0x009b:
            r16.writeNewline()
            int r7 = r3 + 1
            r0.serializeCanonicalRDFProperty(r1, r2, r13, r7)
            java.util.Iterator r1 = r17.iterateQualifier()
        L_0x00a7:
            boolean r8 = r1.hasNext()
            if (r8 == 0) goto L_0x00c3
            java.lang.Object r8 = r1.next()
            com.adobe.xmp.impl.XMPNode r8 = (com.adobe.xmp.impl.XMPNode) r8
            java.util.Set r9 = RDF_ATTR_QUALIFIER
            java.lang.String r11 = r8.getName()
            boolean r9 = r9.contains(r11)
            if (r9 != 0) goto L_0x00a7
            r0.serializeCanonicalRDFProperty(r8, r2, r6, r7)
            goto L_0x00a7
        L_0x00c3:
            if (r2 == 0) goto L_0x0167
        L_0x00c5:
            r0.writeIndent(r3)
            r0.write((java.lang.String) r5)
            r16.writeNewline()
            int r1 = r3 + -1
            r3 = r1
            goto L_0x0167
        L_0x00d3:
            com.adobe.xmp.XMPException r1 = new com.adobe.xmp.XMPException
            java.lang.String r2 = "Can't mix rdf:resource and general qualifiers"
            r1.<init>(r2, r15)
            throw r1
        L_0x00db:
            com.adobe.xmp.options.PropertyOptions r7 = r17.getOptions()
            boolean r7 = r7.isCompositeProperty()
            java.lang.String r15 = "/>"
            if (r7 != 0) goto L_0x012c
            com.adobe.xmp.options.PropertyOptions r2 = r17.getOptions()
            boolean r2 = r2.isURI()
            if (r2 == 0) goto L_0x0109
            java.lang.String r2 = " rdf:resource=\""
            r0.write((java.lang.String) r2)
            java.lang.String r1 = r17.getValue()
            r0.appendNodeValue(r1, r13)
            java.lang.String r1 = "\"/>"
            r0.write((java.lang.String) r1)
        L_0x0102:
            r16.writeNewline()
            r6 = 1
            r13 = 0
            goto L_0x0208
        L_0x0109:
            java.lang.String r2 = r17.getValue()
            if (r2 == 0) goto L_0x0128
            java.lang.String r2 = r17.getValue()
            java.lang.String r5 = ""
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x011c
            goto L_0x0128
        L_0x011c:
            r0.write((int) r10)
            java.lang.String r1 = r17.getValue()
            r0.appendNodeValue(r1, r6)
            goto L_0x0208
        L_0x0128:
            r0.write((java.lang.String) r15)
            goto L_0x0102
        L_0x012c:
            com.adobe.xmp.options.PropertyOptions r7 = r17.getOptions()
            boolean r7 = r7.isArray()
            if (r7 == 0) goto L_0x016a
            r0.write((int) r10)
            r16.writeNewline()
            int r5 = r3 + 1
            r0.emitRDFArrayTag(r1, r13, r5)
            com.adobe.xmp.options.PropertyOptions r7 = r17.getOptions()
            boolean r7 = r7.isArrayAltText()
            if (r7 == 0) goto L_0x014e
            com.adobe.xmp.impl.XMPNodeUtils.normalizeLangArray(r17)
        L_0x014e:
            java.util.Iterator r7 = r17.iterateChildren()
        L_0x0152:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0164
            java.lang.Object r8 = r7.next()
            com.adobe.xmp.impl.XMPNode r8 = (com.adobe.xmp.impl.XMPNode) r8
            int r9 = r3 + 2
            r0.serializeCanonicalRDFProperty(r8, r2, r6, r9)
            goto L_0x0152
        L_0x0164:
            r0.emitRDFArrayTag(r1, r6, r5)
        L_0x0167:
            r6 = 1
            goto L_0x0208
        L_0x016a:
            if (r8 != 0) goto L_0x01c4
            boolean r7 = r17.hasChildren()
            if (r7 != 0) goto L_0x0190
            if (r2 == 0) goto L_0x0186
            r0.write((java.lang.String) r12)
            r16.writeNewline()
            int r1 = r3 + 1
            r0.writeIndent(r1)
            java.lang.String r1 = "<rdf:Description/>"
            r0.write((java.lang.String) r1)
            r6 = 1
            goto L_0x018b
        L_0x0186:
            java.lang.String r1 = " rdf:parseType=\"Resource\"/>"
            r0.write((java.lang.String) r1)
        L_0x018b:
            r16.writeNewline()
            r13 = r6
            goto L_0x0167
        L_0x0190:
            if (r2 == 0) goto L_0x01a4
            r0.write((java.lang.String) r12)
            r16.writeNewline()
            int r3 = r3 + 1
            r0.writeIndent(r3)
            r0.write((java.lang.String) r9)
            r0.write((java.lang.String) r12)
            goto L_0x01a7
        L_0x01a4:
            r0.write((java.lang.String) r14)
        L_0x01a7:
            r16.writeNewline()
            java.util.Iterator r1 = r17.iterateChildren()
        L_0x01ae:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x01c0
            java.lang.Object r7 = r1.next()
            com.adobe.xmp.impl.XMPNode r7 = (com.adobe.xmp.impl.XMPNode) r7
            int r8 = r3 + 1
            r0.serializeCanonicalRDFProperty(r7, r2, r6, r8)
            goto L_0x01ae
        L_0x01c0:
            if (r2 == 0) goto L_0x0167
            goto L_0x00c5
        L_0x01c4:
            java.util.Iterator r1 = r17.iterateChildren()
        L_0x01c8:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0128
            java.lang.Object r2 = r1.next()
            com.adobe.xmp.impl.XMPNode r2 = (com.adobe.xmp.impl.XMPNode) r2
            boolean r5 = r0.canBeRDFAttrProp(r2)
            if (r5 == 0) goto L_0x01fe
            r16.writeNewline()
            int r5 = r3 + 1
            r0.writeIndent(r5)
            r5 = 32
            r0.write((int) r5)
            java.lang.String r7 = r2.getName()
            r0.write((java.lang.String) r7)
            r0.write((java.lang.String) r11)
            java.lang.String r2 = r2.getValue()
            r0.appendNodeValue(r2, r13)
            r2 = 34
            r0.write((int) r2)
            goto L_0x01c8
        L_0x01fe:
            com.adobe.xmp.XMPException r1 = new com.adobe.xmp.XMPException
            java.lang.String r2 = "Can't mix rdf:resource and complex fields"
            r3 = 202(0xca, float:2.83E-43)
            r1.<init>(r2, r3)
            throw r1
        L_0x0208:
            if (r13 == 0) goto L_0x021d
            if (r6 == 0) goto L_0x020f
            r0.writeIndent(r3)
        L_0x020f:
            java.lang.String r1 = "</"
            r0.write((java.lang.String) r1)
            r0.write((java.lang.String) r4)
            r0.write((int) r10)
            r16.writeNewline()
        L_0x021d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.xmp.impl.XMPSerializerRDF.serializeCanonicalRDFProperty(com.adobe.xmp.impl.XMPNode, boolean, boolean, int):void");
    }

    private void serializeCanonicalRDFSchema(XMPNode xMPNode, int i) throws IOException, XMPException {
        Iterator iterateChildren = xMPNode.iterateChildren();
        while (iterateChildren.hasNext()) {
            serializeCanonicalRDFProperty((XMPNode) iterateChildren.next(), this.options.getUseCanonicalFormat(), false, i + 2);
        }
    }

    private void serializeCanonicalRDFSchemas(int i) throws IOException, XMPException {
        if (this.xmp.getRoot().getChildrenLength() > 0) {
            startOuterRDFDescription(this.xmp.getRoot(), i);
            Iterator iterateChildren = this.xmp.getRoot().iterateChildren();
            while (iterateChildren.hasNext()) {
                serializeCanonicalRDFSchema((XMPNode) iterateChildren.next(), i);
            }
            endOuterRDFDescription(i);
            return;
        }
        writeIndent(i + 1);
        write(RDF_SCHEMA_START);
        writeTreeName();
        write("/>");
        writeNewline();
    }

    private void serializeCompactRDFArrayProp(XMPNode xMPNode, int i) throws IOException, XMPException {
        write(62);
        writeNewline();
        int i2 = i + 1;
        emitRDFArrayTag(xMPNode, true, i2);
        if (xMPNode.getOptions().isArrayAltText()) {
            XMPNodeUtils.normalizeLangArray(xMPNode);
        }
        serializeCompactRDFElementProps(xMPNode, i + 2);
        emitRDFArrayTag(xMPNode, false, i2);
    }

    private boolean serializeCompactRDFAttrProps(XMPNode xMPNode, int i) throws IOException {
        Iterator iterateChildren = xMPNode.iterateChildren();
        boolean z = true;
        while (iterateChildren.hasNext()) {
            XMPNode xMPNode2 = (XMPNode) iterateChildren.next();
            if (canBeRDFAttrProp(xMPNode2)) {
                writeNewline();
                writeIndent(i);
                write(xMPNode2.getName());
                write("=\"");
                appendNodeValue(xMPNode2.getValue(), true);
                write(34);
            } else {
                z = false;
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0004 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void serializeCompactRDFElementProps(com.adobe.xmp.impl.XMPNode r11, int r12) throws java.io.IOException, com.adobe.xmp.XMPException {
        /*
            r10 = this;
            java.util.Iterator r11 = r11.iterateChildren()
        L_0x0004:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x00cc
            java.lang.Object r0 = r11.next()
            com.adobe.xmp.impl.XMPNode r0 = (com.adobe.xmp.impl.XMPNode) r0
            boolean r1 = r10.canBeRDFAttrProp(r0)
            if (r1 == 0) goto L_0x0017
            goto L_0x0004
        L_0x0017:
            java.lang.String r1 = r0.getName()
            java.lang.String r2 = "[]"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x0025
            java.lang.String r1 = "rdf:li"
        L_0x0025:
            r10.writeIndent(r12)
            r2 = 60
            r10.write((int) r2)
            r10.write((java.lang.String) r1)
            java.util.Iterator r2 = r0.iterateQualifier()
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x0037:
            boolean r6 = r2.hasNext()
            r7 = 1
            if (r6 == 0) goto L_0x007a
            java.lang.Object r6 = r2.next()
            com.adobe.xmp.impl.XMPNode r6 = (com.adobe.xmp.impl.XMPNode) r6
            java.util.Set r8 = RDF_ATTR_QUALIFIER
            java.lang.String r9 = r6.getName()
            boolean r8 = r8.contains(r9)
            if (r8 != 0) goto L_0x0052
            r4 = 1
            goto L_0x0037
        L_0x0052:
            java.lang.String r5 = r6.getName()
            java.lang.String r8 = "rdf:resource"
            boolean r5 = r8.equals(r5)
            r8 = 32
            r10.write((int) r8)
            java.lang.String r8 = r6.getName()
            r10.write((java.lang.String) r8)
            java.lang.String r8 = "=\""
            r10.write((java.lang.String) r8)
            java.lang.String r6 = r6.getValue()
            r10.appendNodeValue(r6, r7)
            r6 = 34
            r10.write((int) r6)
            goto L_0x0037
        L_0x007a:
            if (r4 == 0) goto L_0x0080
            r10.serializeCompactRDFGeneralQualifier(r12, r0)
            goto L_0x00ad
        L_0x0080:
            com.adobe.xmp.options.PropertyOptions r2 = r0.getOptions()
            boolean r2 = r2.isCompositeProperty()
            if (r2 != 0) goto L_0x00a0
            java.lang.Object[] r0 = r10.serializeCompactRDFSimpleProp(r0)
            r2 = r0[r3]
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r0 = r0[r7]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r7 = r0.booleanValue()
            r0 = r2
            goto L_0x00b3
        L_0x00a0:
            com.adobe.xmp.options.PropertyOptions r2 = r0.getOptions()
            boolean r2 = r2.isArray()
            if (r2 == 0) goto L_0x00af
            r10.serializeCompactRDFArrayProp(r0, r12)
        L_0x00ad:
            r0 = 1
            goto L_0x00b3
        L_0x00af:
            boolean r0 = r10.serializeCompactRDFStructProp(r0, r12, r5)
        L_0x00b3:
            if (r0 == 0) goto L_0x0004
            if (r7 == 0) goto L_0x00ba
            r10.writeIndent(r12)
        L_0x00ba:
            java.lang.String r0 = "</"
            r10.write((java.lang.String) r0)
            r10.write((java.lang.String) r1)
            r0 = 62
            r10.write((int) r0)
            r10.writeNewline()
            goto L_0x0004
        L_0x00cc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.xmp.impl.XMPSerializerRDF.serializeCompactRDFElementProps(com.adobe.xmp.impl.XMPNode, int):void");
    }

    private void serializeCompactRDFGeneralQualifier(int i, XMPNode xMPNode) throws IOException, XMPException {
        write(" rdf:parseType=\"Resource\">");
        writeNewline();
        int i2 = i + 1;
        serializeCanonicalRDFProperty(xMPNode, false, true, i2);
        Iterator iterateQualifier = xMPNode.iterateQualifier();
        while (iterateQualifier.hasNext()) {
            serializeCanonicalRDFProperty((XMPNode) iterateQualifier.next(), false, false, i2);
        }
    }

    private void serializeCompactRDFSchemas(int i) throws IOException, XMPException {
        String str;
        int i2 = i + 1;
        writeIndent(i2);
        write(RDF_SCHEMA_START);
        writeTreeName();
        HashSet hashSet = new HashSet();
        hashSet.add("xml");
        hashSet.add("rdf");
        Iterator iterateChildren = this.xmp.getRoot().iterateChildren();
        while (iterateChildren.hasNext()) {
            declareUsedNamespaces((XMPNode) iterateChildren.next(), hashSet, i + 3);
        }
        Iterator iterateChildren2 = this.xmp.getRoot().iterateChildren();
        boolean z = true;
        while (iterateChildren2.hasNext()) {
            z &= serializeCompactRDFAttrProps((XMPNode) iterateChildren2.next(), i + 2);
        }
        if (!z) {
            write(62);
            writeNewline();
            Iterator iterateChildren3 = this.xmp.getRoot().iterateChildren();
            while (iterateChildren3.hasNext()) {
                serializeCompactRDFElementProps((XMPNode) iterateChildren3.next(), i + 2);
            }
            writeIndent(i2);
            str = "</rdf:Description>";
        } else {
            str = "/>";
        }
        write(str);
        writeNewline();
    }

    private Object[] serializeCompactRDFSimpleProp(XMPNode xMPNode) throws IOException {
        String str;
        Boolean bool = Boolean.TRUE;
        Boolean bool2 = Boolean.TRUE;
        if (xMPNode.getOptions().isURI()) {
            write(" rdf:resource=\"");
            appendNodeValue(xMPNode.getValue(), true);
            str = "\"/>";
        } else if (xMPNode.getValue() == null || xMPNode.getValue().length() == 0) {
            str = "/>";
        } else {
            write(62);
            appendNodeValue(xMPNode.getValue(), false);
            bool2 = Boolean.FALSE;
            return new Object[]{bool, bool2};
        }
        write(str);
        writeNewline();
        bool = Boolean.FALSE;
        return new Object[]{bool, bool2};
    }

    private boolean serializeCompactRDFStructProp(XMPNode xMPNode, int i, boolean z) throws XMPException, IOException {
        String str;
        Iterator iterateChildren = xMPNode.iterateChildren();
        boolean z2 = false;
        boolean z3 = false;
        while (iterateChildren.hasNext()) {
            if (canBeRDFAttrProp((XMPNode) iterateChildren.next())) {
                z2 = true;
            } else {
                z3 = true;
            }
            if (z2 && z3) {
                break;
            }
        }
        if (!z || !z3) {
            if (!xMPNode.hasChildren()) {
                str = " rdf:parseType=\"Resource\"/>";
            } else if (!z3) {
                serializeCompactRDFAttrProps(xMPNode, i + 1);
                str = "/>";
            } else {
                if (!z2) {
                    write(" rdf:parseType=\"Resource\">");
                    writeNewline();
                    serializeCompactRDFElementProps(xMPNode, i + 1);
                } else {
                    write(62);
                    writeNewline();
                    int i2 = i + 1;
                    writeIndent(i2);
                    write(RDF_STRUCT_START);
                    serializeCompactRDFAttrProps(xMPNode, i + 2);
                    write(">");
                    writeNewline();
                    serializeCompactRDFElementProps(xMPNode, i2);
                    writeIndent(i2);
                    write("</rdf:Description>");
                    writeNewline();
                }
                return true;
            }
            write(str);
            writeNewline();
            return false;
        }
        throw new XMPException("Can't mix rdf:resource qualifier and element fields", XMPError.BADRDF);
    }

    private void startOuterRDFDescription(XMPNode xMPNode, int i) throws IOException {
        writeIndent(i + 1);
        write(RDF_SCHEMA_START);
        writeTreeName();
        HashSet hashSet = new HashSet();
        hashSet.add("xml");
        hashSet.add("rdf");
        declareUsedNamespaces(xMPNode, hashSet, i + 3);
        write(62);
        writeNewline();
    }

    private void write(int i) throws IOException {
        this.writer.write(i);
    }

    private void write(String str) throws IOException {
        this.writer.write(str);
    }

    private void writeChars(int i, char c) throws IOException {
        while (i > 0) {
            this.writer.write(c);
            i--;
        }
    }

    private void writeIndent(int i) throws IOException {
        for (int baseIndent = this.options.getBaseIndent() + i; baseIndent > 0; baseIndent--) {
            this.writer.write(this.options.getIndent());
        }
    }

    private void writeNewline() throws IOException {
        this.writer.write(this.options.getNewline());
    }

    private void writeTreeName() throws IOException {
        write(34);
        String name = this.xmp.getRoot().getName();
        if (name != null) {
            appendNodeValue(name, true);
        }
        write(34);
    }

    /* access modifiers changed from: protected */
    public void checkOptionsConsistence() throws XMPException {
        if (this.options.getEncodeUTF16BE() || this.options.getEncodeUTF16LE()) {
            this.unicodeSize = 2;
        }
        if (!this.options.getExactPacketLength()) {
            if (this.options.getReadOnlyPacket()) {
                if (this.options.getOmitPacketWrapper() || this.options.getIncludeThumbnailPad()) {
                    throw new XMPException("Inconsistent options for read-only packet", 103);
                }
            } else if (!this.options.getOmitPacketWrapper()) {
                if (this.padding == 0) {
                    this.padding = this.unicodeSize * 2048;
                }
                if (this.options.getIncludeThumbnailPad() && !this.xmp.doesPropertyExist("http://ns.adobe.com/xap/1.0/", "Thumbnails")) {
                    this.padding += this.unicodeSize * PhotoshopDirectory.TAG_PRINT_FLAGS_INFO;
                    return;
                }
                return;
            } else if (this.options.getIncludeThumbnailPad()) {
                throw new XMPException("Inconsistent options for non-packet serialize", 103);
            }
            this.padding = 0;
        } else if (this.options.getOmitPacketWrapper() || this.options.getIncludeThumbnailPad()) {
            throw new XMPException("Inconsistent options for exact size serialize", 103);
        } else if ((this.options.getPadding() & (this.unicodeSize - 1)) != 0) {
            throw new XMPException("Exact size must be a multiple of the Unicode element", 103);
        }
    }

    public void serialize(XMPMeta xMPMeta, OutputStream outputStream2, SerializeOptions serializeOptions) throws XMPException {
        try {
            this.outputStream = new CountOutputStream(outputStream2);
            this.writer = new OutputStreamWriter(this.outputStream, serializeOptions.getEncoding());
            this.xmp = (XMPMetaImpl) xMPMeta;
            this.options = serializeOptions;
            this.padding = serializeOptions.getPadding();
            this.writer = new OutputStreamWriter(this.outputStream, serializeOptions.getEncoding());
            checkOptionsConsistence();
            String serializeAsRDF = serializeAsRDF();
            this.writer.flush();
            addPadding(serializeAsRDF.length());
            write(serializeAsRDF);
            this.writer.flush();
            this.outputStream.close();
        } catch (IOException unused) {
            throw new XMPException("Error writing to the OutputStream", 0);
        }
    }
}

package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;

public class JsonGeneratorDelegate extends JsonGenerator {
    protected JsonGenerator delegate;
    protected boolean delegateCopyMethods;

    public JsonGeneratorDelegate(JsonGenerator jsonGenerator) {
        this(jsonGenerator, true);
    }

    public JsonGeneratorDelegate(JsonGenerator jsonGenerator, boolean z) {
        this.delegate = jsonGenerator;
        this.delegateCopyMethods = z;
    }

    public Object getCurrentValue() {
        return this.delegate.getCurrentValue();
    }

    public void setCurrentValue(Object obj) {
        this.delegate.setCurrentValue(obj);
    }

    public JsonGenerator getDelegate() {
        return this.delegate;
    }

    public ObjectCodec getCodec() {
        return this.delegate.getCodec();
    }

    public JsonGenerator setCodec(ObjectCodec objectCodec) {
        this.delegate.setCodec(objectCodec);
        return this;
    }

    public void setSchema(FormatSchema formatSchema) {
        this.delegate.setSchema(formatSchema);
    }

    public FormatSchema getSchema() {
        return this.delegate.getSchema();
    }

    public Version version() {
        return this.delegate.version();
    }

    public Object getOutputTarget() {
        return this.delegate.getOutputTarget();
    }

    public int getOutputBuffered() {
        return this.delegate.getOutputBuffered();
    }

    public boolean canUseSchema(FormatSchema formatSchema) {
        return this.delegate.canUseSchema(formatSchema);
    }

    public boolean canWriteTypeId() {
        return this.delegate.canWriteTypeId();
    }

    public boolean canWriteObjectId() {
        return this.delegate.canWriteObjectId();
    }

    public boolean canWriteBinaryNatively() {
        return this.delegate.canWriteBinaryNatively();
    }

    public boolean canOmitFields() {
        return this.delegate.canOmitFields();
    }

    public JsonGenerator enable(JsonGenerator.Feature feature) {
        this.delegate.enable(feature);
        return this;
    }

    public JsonGenerator disable(JsonGenerator.Feature feature) {
        this.delegate.disable(feature);
        return this;
    }

    public boolean isEnabled(JsonGenerator.Feature feature) {
        return this.delegate.isEnabled(feature);
    }

    public int getFeatureMask() {
        return this.delegate.getFeatureMask();
    }

    @Deprecated
    public JsonGenerator setFeatureMask(int i) {
        this.delegate.setFeatureMask(i);
        return this;
    }

    public JsonGenerator overrideStdFeatures(int i, int i2) {
        this.delegate.overrideStdFeatures(i, i2);
        return this;
    }

    public JsonGenerator overrideFormatFeatures(int i, int i2) {
        this.delegate.overrideFormatFeatures(i, i2);
        return this;
    }

    public JsonGenerator setPrettyPrinter(PrettyPrinter prettyPrinter) {
        this.delegate.setPrettyPrinter(prettyPrinter);
        return this;
    }

    public PrettyPrinter getPrettyPrinter() {
        return this.delegate.getPrettyPrinter();
    }

    public JsonGenerator useDefaultPrettyPrinter() {
        this.delegate.useDefaultPrettyPrinter();
        return this;
    }

    public JsonGenerator setHighestNonEscapedChar(int i) {
        this.delegate.setHighestNonEscapedChar(i);
        return this;
    }

    public int getHighestEscapedChar() {
        return this.delegate.getHighestEscapedChar();
    }

    public CharacterEscapes getCharacterEscapes() {
        return this.delegate.getCharacterEscapes();
    }

    public JsonGenerator setCharacterEscapes(CharacterEscapes characterEscapes) {
        this.delegate.setCharacterEscapes(characterEscapes);
        return this;
    }

    public JsonGenerator setRootValueSeparator(SerializableString serializableString) {
        this.delegate.setRootValueSeparator(serializableString);
        return this;
    }

    public void writeStartArray() throws IOException {
        this.delegate.writeStartArray();
    }

    public void writeStartArray(int i) throws IOException {
        this.delegate.writeStartArray(i);
    }

    public void writeEndArray() throws IOException {
        this.delegate.writeEndArray();
    }

    public void writeStartObject() throws IOException {
        this.delegate.writeStartObject();
    }

    public void writeStartObject(Object obj) throws IOException {
        this.delegate.writeStartObject(obj);
    }

    public void writeEndObject() throws IOException {
        this.delegate.writeEndObject();
    }

    public void writeFieldName(String str) throws IOException {
        this.delegate.writeFieldName(str);
    }

    public void writeFieldName(SerializableString serializableString) throws IOException {
        this.delegate.writeFieldName(serializableString);
    }

    public void writeFieldId(long j) throws IOException {
        this.delegate.writeFieldId(j);
    }

    public void writeArray(int[] iArr, int i, int i2) throws IOException {
        this.delegate.writeArray(iArr, i, i2);
    }

    public void writeArray(long[] jArr, int i, int i2) throws IOException {
        this.delegate.writeArray(jArr, i, i2);
    }

    public void writeArray(double[] dArr, int i, int i2) throws IOException {
        this.delegate.writeArray(dArr, i, i2);
    }

    public void writeString(String str) throws IOException {
        this.delegate.writeString(str);
    }

    public void writeString(Reader reader, int i) throws IOException {
        this.delegate.writeString(reader, i);
    }

    public void writeString(char[] cArr, int i, int i2) throws IOException {
        this.delegate.writeString(cArr, i, i2);
    }

    public void writeString(SerializableString serializableString) throws IOException {
        this.delegate.writeString(serializableString);
    }

    public void writeRawUTF8String(byte[] bArr, int i, int i2) throws IOException {
        this.delegate.writeRawUTF8String(bArr, i, i2);
    }

    public void writeUTF8String(byte[] bArr, int i, int i2) throws IOException {
        this.delegate.writeUTF8String(bArr, i, i2);
    }

    public void writeRaw(String str) throws IOException {
        this.delegate.writeRaw(str);
    }

    public void writeRaw(String str, int i, int i2) throws IOException {
        this.delegate.writeRaw(str, i, i2);
    }

    public void writeRaw(SerializableString serializableString) throws IOException {
        this.delegate.writeRaw(serializableString);
    }

    public void writeRaw(char[] cArr, int i, int i2) throws IOException {
        this.delegate.writeRaw(cArr, i, i2);
    }

    public void writeRaw(char c) throws IOException {
        this.delegate.writeRaw(c);
    }

    public void writeRawValue(String str) throws IOException {
        this.delegate.writeRawValue(str);
    }

    public void writeRawValue(String str, int i, int i2) throws IOException {
        this.delegate.writeRawValue(str, i, i2);
    }

    public void writeRawValue(char[] cArr, int i, int i2) throws IOException {
        this.delegate.writeRawValue(cArr, i, i2);
    }

    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException {
        this.delegate.writeBinary(base64Variant, bArr, i, i2);
    }

    public int writeBinary(Base64Variant base64Variant, InputStream inputStream, int i) throws IOException {
        return this.delegate.writeBinary(base64Variant, inputStream, i);
    }

    public void writeNumber(short s) throws IOException {
        this.delegate.writeNumber(s);
    }

    public void writeNumber(int i) throws IOException {
        this.delegate.writeNumber(i);
    }

    public void writeNumber(long j) throws IOException {
        this.delegate.writeNumber(j);
    }

    public void writeNumber(BigInteger bigInteger) throws IOException {
        this.delegate.writeNumber(bigInteger);
    }

    public void writeNumber(double d) throws IOException {
        this.delegate.writeNumber(d);
    }

    public void writeNumber(float f) throws IOException {
        this.delegate.writeNumber(f);
    }

    public void writeNumber(BigDecimal bigDecimal) throws IOException {
        this.delegate.writeNumber(bigDecimal);
    }

    public void writeNumber(String str) throws IOException, UnsupportedOperationException {
        this.delegate.writeNumber(str);
    }

    public void writeBoolean(boolean z) throws IOException {
        this.delegate.writeBoolean(z);
    }

    public void writeNull() throws IOException {
        this.delegate.writeNull();
    }

    public void writeOmittedField(String str) throws IOException {
        this.delegate.writeOmittedField(str);
    }

    public void writeObjectId(Object obj) throws IOException {
        this.delegate.writeObjectId(obj);
    }

    public void writeObjectRef(Object obj) throws IOException {
        this.delegate.writeObjectRef(obj);
    }

    public void writeTypeId(Object obj) throws IOException {
        this.delegate.writeTypeId(obj);
    }

    public void writeEmbeddedObject(Object obj) throws IOException {
        this.delegate.writeEmbeddedObject(obj);
    }

    public void writeObject(Object obj) throws IOException {
        if (this.delegateCopyMethods) {
            this.delegate.writeObject(obj);
        } else if (obj == null) {
            writeNull();
        } else {
            ObjectCodec codec = getCodec();
            if (codec != null) {
                codec.writeValue(this, obj);
            } else {
                _writeSimpleObject(obj);
            }
        }
    }

    public void writeTree(TreeNode treeNode) throws IOException {
        if (this.delegateCopyMethods) {
            this.delegate.writeTree(treeNode);
        } else if (treeNode == null) {
            writeNull();
        } else {
            ObjectCodec codec = getCodec();
            if (codec != null) {
                codec.writeTree(this, treeNode);
                return;
            }
            throw new IllegalStateException("No ObjectCodec defined");
        }
    }

    public void copyCurrentEvent(JsonParser jsonParser) throws IOException {
        if (this.delegateCopyMethods) {
            this.delegate.copyCurrentEvent(jsonParser);
        } else {
            super.copyCurrentEvent(jsonParser);
        }
    }

    public void copyCurrentStructure(JsonParser jsonParser) throws IOException {
        if (this.delegateCopyMethods) {
            this.delegate.copyCurrentStructure(jsonParser);
        } else {
            super.copyCurrentStructure(jsonParser);
        }
    }

    public JsonStreamContext getOutputContext() {
        return this.delegate.getOutputContext();
    }

    public void flush() throws IOException {
        this.delegate.flush();
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public boolean isClosed() {
        return this.delegate.isClosed();
    }
}

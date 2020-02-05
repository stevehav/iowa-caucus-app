package io.sentry.marshaller.json;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.Version;
import io.sentry.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SentryJsonGenerator extends JsonGenerator {
    private static final String ELIDED = "...";
    private static final int MAX_LENGTH_LIST = 10;
    private static final int MAX_LENGTH_STRING = 400;
    private static final int MAX_NESTING = 3;
    private static final int MAX_SIZE_MAP = 50;
    private static final String RECURSION_LIMIT_HIT = "<recursion limit hit>";
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) Util.class);
    private JsonGenerator generator;
    private int maxLengthList = 10;
    private int maxLengthString = 400;
    private int maxNesting = 3;
    private int maxSizeMap = 50;

    public SentryJsonGenerator(JsonGenerator jsonGenerator) {
        this.generator = jsonGenerator;
    }

    public void writeObject(Object obj) throws IOException {
        writeObject(obj, 0);
    }

    private void writeObject(Object obj, int i) throws IOException {
        if (i >= this.maxNesting) {
            this.generator.writeString(RECURSION_LIMIT_HIT);
        } else if (obj == null) {
            this.generator.writeNull();
        } else if (obj.getClass().isArray()) {
            this.generator.writeStartArray();
            writeArray(obj, i);
            this.generator.writeEndArray();
        } else {
            int i2 = 0;
            if (obj instanceof Map) {
                this.generator.writeStartObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    if (i2 >= this.maxSizeMap) {
                        break;
                    }
                    if (entry.getKey() == null) {
                        this.generator.writeFieldName("null");
                    } else {
                        this.generator.writeFieldName(Util.trimString(entry.getKey().toString(), this.maxLengthString));
                    }
                    writeObject(entry.getValue(), i + 1);
                    i2++;
                }
                this.generator.writeEndObject();
            } else if (obj instanceof Collection) {
                this.generator.writeStartArray();
                Iterator it = ((Collection) obj).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (i2 >= this.maxLengthList) {
                        writeElided();
                        break;
                    } else {
                        writeObject(next, i + 1);
                        i2++;
                    }
                }
                this.generator.writeEndArray();
            } else if (obj instanceof String) {
                this.generator.writeString(Util.trimString((String) obj, this.maxLengthString));
            } else {
                try {
                    this.generator.writeObject(obj);
                } catch (IllegalStateException unused) {
                    logger.debug("Couldn't marshal '{}' of type '{}', had to be converted into a String", obj, (Object) obj.getClass());
                    try {
                        this.generator.writeString(Util.trimString(obj.toString(), this.maxLengthString));
                    } catch (Exception unused2) {
                        this.generator.writeString("<exception calling toString on object>");
                    }
                }
            }
        }
    }

    private void writeArray(Object obj, int i) throws IOException {
        int i2 = 0;
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            while (i2 < bArr.length && i2 < this.maxLengthList) {
                this.generator.writeNumber((int) bArr[i2]);
                i2++;
            }
            if (bArr.length > this.maxLengthList) {
                writeElided();
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            while (i2 < sArr.length && i2 < this.maxLengthList) {
                this.generator.writeNumber((int) sArr[i2]);
                i2++;
            }
            if (sArr.length > this.maxLengthList) {
                writeElided();
            }
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            while (i2 < iArr.length && i2 < this.maxLengthList) {
                this.generator.writeNumber(iArr[i2]);
                i2++;
            }
            if (iArr.length > this.maxLengthList) {
                writeElided();
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            while (i2 < jArr.length && i2 < this.maxLengthList) {
                this.generator.writeNumber(jArr[i2]);
                i2++;
            }
            if (jArr.length > this.maxLengthList) {
                writeElided();
            }
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            while (i2 < fArr.length && i2 < this.maxLengthList) {
                this.generator.writeNumber(fArr[i2]);
                i2++;
            }
            if (fArr.length > this.maxLengthList) {
                writeElided();
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            while (i2 < dArr.length && i2 < this.maxLengthList) {
                this.generator.writeNumber(dArr[i2]);
                i2++;
            }
            if (dArr.length > this.maxLengthList) {
                writeElided();
            }
        } else if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            while (i2 < cArr.length && i2 < this.maxLengthList) {
                this.generator.writeString(String.valueOf(cArr[i2]));
                i2++;
            }
            if (cArr.length > this.maxLengthList) {
                writeElided();
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            while (i2 < zArr.length && i2 < this.maxLengthList) {
                this.generator.writeBoolean(zArr[i2]);
                i2++;
            }
            if (zArr.length > this.maxLengthList) {
                writeElided();
            }
        } else {
            Object[] objArr = (Object[]) obj;
            while (i2 < objArr.length && i2 < this.maxLengthList) {
                writeObject(objArr[i2], i + 1);
                i2++;
            }
            if (objArr.length > this.maxLengthList) {
                writeElided();
            }
        }
    }

    private void writeElided() throws IOException {
        this.generator.writeString(ELIDED);
    }

    public void setMaxLengthList(int i) {
        this.maxLengthList = i;
    }

    public void setMaxLengthString(int i) {
        this.maxLengthString = i;
    }

    public void setMaxSizeMap(int i) {
        this.maxSizeMap = i;
    }

    public void setMaxNesting(int i) {
        this.maxNesting = i;
    }

    public JsonGenerator setCodec(ObjectCodec objectCodec) {
        return this.generator.setCodec(objectCodec);
    }

    public ObjectCodec getCodec() {
        return this.generator.getCodec();
    }

    public Version version() {
        return this.generator.version();
    }

    public JsonGenerator enable(JsonGenerator.Feature feature) {
        return this.generator.enable(feature);
    }

    public JsonGenerator disable(JsonGenerator.Feature feature) {
        return this.generator.disable(feature);
    }

    public boolean isEnabled(JsonGenerator.Feature feature) {
        return this.generator.isEnabled(feature);
    }

    public int getFeatureMask() {
        return this.generator.getFeatureMask();
    }

    public JsonGenerator setFeatureMask(int i) {
        return this.generator.setFeatureMask(i);
    }

    public JsonGenerator useDefaultPrettyPrinter() {
        return this.generator.useDefaultPrettyPrinter();
    }

    public void writeStartArray() throws IOException {
        this.generator.writeStartArray();
    }

    public void writeEndArray() throws IOException {
        this.generator.writeEndArray();
    }

    public void writeStartObject() throws IOException {
        this.generator.writeStartObject();
    }

    public void writeEndObject() throws IOException {
        this.generator.writeEndObject();
    }

    public void writeFieldName(String str) throws IOException {
        this.generator.writeFieldName(str);
    }

    public void writeFieldName(SerializableString serializableString) throws IOException {
        this.generator.writeFieldName(serializableString);
    }

    public void writeString(String str) throws IOException {
        this.generator.writeString(str);
    }

    public void writeString(char[] cArr, int i, int i2) throws IOException {
        this.generator.writeString(cArr, i, i2);
    }

    public void writeString(SerializableString serializableString) throws IOException {
        this.generator.writeString(serializableString);
    }

    public void writeRawUTF8String(byte[] bArr, int i, int i2) throws IOException {
        this.generator.writeRawUTF8String(bArr, i, i2);
    }

    public void writeUTF8String(byte[] bArr, int i, int i2) throws IOException {
        this.generator.writeUTF8String(bArr, i, i2);
    }

    public void writeRaw(String str) throws IOException {
        this.generator.writeRaw(str);
    }

    public void writeRaw(String str, int i, int i2) throws IOException {
        this.generator.writeRaw(str, i, i2);
    }

    public void writeRaw(char[] cArr, int i, int i2) throws IOException {
        this.generator.writeRaw(cArr, i, i2);
    }

    public void writeRaw(char c) throws IOException {
        this.generator.writeRaw(c);
    }

    public void writeRawValue(String str) throws IOException {
        this.generator.writeRawValue(str);
    }

    public void writeRawValue(String str, int i, int i2) throws IOException {
        this.generator.writeRawValue(str, i, i2);
    }

    public void writeRawValue(char[] cArr, int i, int i2) throws IOException {
        this.generator.writeRawValue(cArr, i, i2);
    }

    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException {
        this.generator.writeBinary(base64Variant, bArr, i, i2);
    }

    public int writeBinary(Base64Variant base64Variant, InputStream inputStream, int i) throws IOException {
        return this.generator.writeBinary(base64Variant, inputStream, i);
    }

    public void writeNumber(int i) throws IOException {
        this.generator.writeNumber(i);
    }

    public void writeNumber(long j) throws IOException {
        this.generator.writeNumber(j);
    }

    public void writeNumber(BigInteger bigInteger) throws IOException {
        this.generator.writeNumber(bigInteger);
    }

    public void writeNumber(double d) throws IOException {
        this.generator.writeNumber(d);
    }

    public void writeNumber(float f) throws IOException {
        this.generator.writeNumber(f);
    }

    public void writeNumber(BigDecimal bigDecimal) throws IOException {
        this.generator.writeNumber(bigDecimal);
    }

    public void writeNumber(String str) throws IOException {
        this.generator.writeNumber(str);
    }

    public void writeBoolean(boolean z) throws IOException {
        this.generator.writeBoolean(z);
    }

    public void writeNull() throws IOException {
        this.generator.writeNull();
    }

    public void writeTree(TreeNode treeNode) throws IOException {
        this.generator.writeTree(treeNode);
    }

    public JsonStreamContext getOutputContext() {
        return this.generator.getOutputContext();
    }

    public void flush() throws IOException {
        this.generator.flush();
    }

    public boolean isClosed() {
        return this.generator.isClosed();
    }

    public void close() throws IOException {
        this.generator.close();
    }
}

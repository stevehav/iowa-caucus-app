package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class MapValue extends GeneratedMessageLite<MapValue, Builder> implements MapValueOrBuilder {
    /* access modifiers changed from: private */
    public static final MapValue DEFAULT_INSTANCE = new MapValue();
    public static final int FIELDS_FIELD_NUMBER = 1;
    private static volatile Parser<MapValue> PARSER;
    private MapFieldLite<String, Value> fields_ = MapFieldLite.emptyMapField();

    private MapValue() {
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    private static final class FieldsDefaultEntryHolder {
        static final MapEntryLite<String, Value> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.getDefaultInstance());

        private FieldsDefaultEntryHolder() {
        }
    }

    private MapFieldLite<String, Value> internalGetFields() {
        return this.fields_;
    }

    private MapFieldLite<String, Value> internalGetMutableFields() {
        if (!this.fields_.isMutable()) {
            this.fields_ = this.fields_.mutableCopy();
        }
        return this.fields_;
    }

    public int getFieldsCount() {
        return internalGetFields().size();
    }

    public boolean containsFields(String str) {
        if (str != null) {
            return internalGetFields().containsKey(str);
        }
        throw new NullPointerException();
    }

    @Deprecated
    public Map<String, Value> getFields() {
        return getFieldsMap();
    }

    public Map<String, Value> getFieldsMap() {
        return Collections.unmodifiableMap(internalGetFields());
    }

    public Value getFieldsOrDefault(String str, Value value) {
        if (str != null) {
            MapFieldLite<String, Value> internalGetFields = internalGetFields();
            return internalGetFields.containsKey(str) ? internalGetFields.get(str) : value;
        }
        throw new NullPointerException();
    }

    public Value getFieldsOrThrow(String str) {
        if (str != null) {
            MapFieldLite<String, Value> internalGetFields = internalGetFields();
            if (internalGetFields.containsKey(str)) {
                return internalGetFields.get(str);
            }
            throw new IllegalArgumentException();
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public Map<String, Value> getMutableFieldsMap() {
        return internalGetMutableFields();
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (Map.Entry next : internalGetFields().entrySet()) {
            FieldsDefaultEntryHolder.defaultEntry.serializeTo(codedOutputStream, 1, (String) next.getKey(), (Value) next.getValue());
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (Map.Entry next : internalGetFields().entrySet()) {
            i2 += FieldsDefaultEntryHolder.defaultEntry.computeMessageSize(1, (String) next.getKey(), (Value) next.getValue());
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static MapValue parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (MapValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MapValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MapValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MapValue parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (MapValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MapValue parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MapValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MapValue parseFrom(InputStream inputStream) throws IOException {
        return (MapValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MapValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MapValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MapValue parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (MapValue) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MapValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MapValue) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MapValue parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (MapValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MapValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MapValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(MapValue mapValue) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(mapValue);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public static final class Builder extends GeneratedMessageLite.Builder<MapValue, Builder> implements MapValueOrBuilder {
        private Builder() {
            super(MapValue.DEFAULT_INSTANCE);
        }

        public int getFieldsCount() {
            return ((MapValue) this.instance).getFieldsMap().size();
        }

        public boolean containsFields(String str) {
            if (str != null) {
                return ((MapValue) this.instance).getFieldsMap().containsKey(str);
            }
            throw new NullPointerException();
        }

        public Builder clearFields() {
            copyOnWrite();
            ((MapValue) this.instance).getMutableFieldsMap().clear();
            return this;
        }

        public Builder removeFields(String str) {
            if (str != null) {
                copyOnWrite();
                ((MapValue) this.instance).getMutableFieldsMap().remove(str);
                return this;
            }
            throw new NullPointerException();
        }

        @Deprecated
        public Map<String, Value> getFields() {
            return getFieldsMap();
        }

        public Map<String, Value> getFieldsMap() {
            return Collections.unmodifiableMap(((MapValue) this.instance).getFieldsMap());
        }

        public Value getFieldsOrDefault(String str, Value value) {
            if (str != null) {
                Map<String, Value> fieldsMap = ((MapValue) this.instance).getFieldsMap();
                return fieldsMap.containsKey(str) ? fieldsMap.get(str) : value;
            }
            throw new NullPointerException();
        }

        public Value getFieldsOrThrow(String str) {
            if (str != null) {
                Map<String, Value> fieldsMap = ((MapValue) this.instance).getFieldsMap();
                if (fieldsMap.containsKey(str)) {
                    return fieldsMap.get(str);
                }
                throw new IllegalArgumentException();
            }
            throw new NullPointerException();
        }

        public Builder putFields(String str, Value value) {
            if (str == null) {
                throw new NullPointerException();
            } else if (value != null) {
                copyOnWrite();
                ((MapValue) this.instance).getMutableFieldsMap().put(str, value);
                return this;
            } else {
                throw new NullPointerException();
            }
        }

        public Builder putAllFields(Map<String, Value> map) {
            copyOnWrite();
            ((MapValue) this.instance).getMutableFieldsMap().putAll(map);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new MapValue();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                this.fields_.makeImmutable();
                return null;
            case NEW_BUILDER:
                return new Builder();
            case VISIT:
                this.fields_ = ((GeneratedMessageLite.Visitor) obj).visitMap(this.fields_, ((MapValue) obj2).internalGetFields());
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case MERGE_FROM_STREAM:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                if (!this.fields_.isMutable()) {
                                    this.fields_ = this.fields_.mutableCopy();
                                }
                                FieldsDefaultEntryHolder.defaultEntry.parseInto(this.fields_, codedInputStream, extensionRegistryLite);
                            } else if (!codedInputStream.skipField(readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw new RuntimeException(e.setUnfinishedMessage(this));
                    } catch (IOException e2) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                    }
                }
                break;
            case GET_DEFAULT_INSTANCE:
                break;
            case GET_PARSER:
                if (PARSER == null) {
                    synchronized (MapValue.class) {
                        if (PARSER == null) {
                            PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        }
                    }
                }
                return PARSER;
            default:
                throw new UnsupportedOperationException();
        }
        return DEFAULT_INSTANCE;
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    public static MapValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<MapValue> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

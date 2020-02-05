package com.google.firebase.firestore;

import androidx.annotation.RestrictTo;
import com.google.common.base.Preconditions;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.core.UserData;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.mutation.ArrayTransformOperation;
import com.google.firebase.firestore.model.mutation.FieldMask;
import com.google.firebase.firestore.model.mutation.NumericIncrementTransformOperation;
import com.google.firebase.firestore.model.mutation.ServerTimestampOperation;
import com.google.firebase.firestore.model.value.ArrayValue;
import com.google.firebase.firestore.model.value.BlobValue;
import com.google.firebase.firestore.model.value.BooleanValue;
import com.google.firebase.firestore.model.value.DoubleValue;
import com.google.firebase.firestore.model.value.GeoPointValue;
import com.google.firebase.firestore.model.value.IntegerValue;
import com.google.firebase.firestore.model.value.NullValue;
import com.google.firebase.firestore.model.value.NumberValue;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.model.value.ReferenceValue;
import com.google.firebase.firestore.model.value.StringValue;
import com.google.firebase.firestore.model.value.TimestampValue;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.CustomClassMapper;
import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class UserDataConverter {
    private final DatabaseId databaseId;

    public UserDataConverter(DatabaseId databaseId2) {
        this.databaseId = databaseId2;
    }

    public UserData.ParsedSetData parseSetData(Object obj) {
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.Set);
        return parseAccumulator.toSetData(convertAndParseDocumentData(obj, parseAccumulator.rootContext()));
    }

    public UserData.ParsedSetData parseMergeData(Object obj, @Nullable FieldMask fieldMask) {
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.MergeSet);
        ObjectValue convertAndParseDocumentData = convertAndParseDocumentData(obj, parseAccumulator.rootContext());
        if (fieldMask == null) {
            return parseAccumulator.toMergeData(convertAndParseDocumentData);
        }
        for (FieldPath next : fieldMask.getMask()) {
            if (!parseAccumulator.contains(next)) {
                throw new IllegalArgumentException("Field '" + next.toString() + "' is specified in your field mask but not in your input data.");
            }
        }
        return parseAccumulator.toMergeData(convertAndParseDocumentData, fieldMask);
    }

    public UserData.ParsedUpdateData parseUpdateData(Map<String, Object> map) {
        Preconditions.checkNotNull(map, "Provided update data must not be null.");
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.Update);
        UserData.ParseContext rootContext = parseAccumulator.rootContext();
        ObjectValue emptyObject = ObjectValue.emptyObject();
        for (Map.Entry next : map.entrySet()) {
            FieldPath internalPath = FieldPath.fromDotSeparatedPath((String) next.getKey()).getInternalPath();
            Object value = next.getValue();
            if (value instanceof FieldValue.DeleteFieldValue) {
                rootContext.addToFieldMask(internalPath);
            } else {
                com.google.firebase.firestore.model.value.FieldValue convertAndParseFieldData = convertAndParseFieldData(value, rootContext.childContext(internalPath));
                if (convertAndParseFieldData != null) {
                    rootContext.addToFieldMask(internalPath);
                    emptyObject = emptyObject.set(internalPath, convertAndParseFieldData);
                }
            }
        }
        return parseAccumulator.toUpdateData(emptyObject);
    }

    public UserData.ParsedUpdateData parseUpdateData(List<Object> list) {
        FieldPath fieldPath;
        Assert.hardAssert(list.size() % 2 == 0, "Expected fieldAndValues to contain an even number of elements", new Object[0]);
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.Update);
        UserData.ParseContext rootContext = parseAccumulator.rootContext();
        ObjectValue emptyObject = ObjectValue.emptyObject();
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            Object next2 = it.next();
            boolean z = next instanceof String;
            Assert.hardAssert(z || (next instanceof FieldPath), "Expected argument to be String or FieldPath.", new Object[0]);
            if (z) {
                fieldPath = FieldPath.fromDotSeparatedPath((String) next).getInternalPath();
            } else {
                fieldPath = ((FieldPath) next).getInternalPath();
            }
            if (next2 instanceof FieldValue.DeleteFieldValue) {
                rootContext.addToFieldMask(fieldPath);
            } else {
                com.google.firebase.firestore.model.value.FieldValue convertAndParseFieldData = convertAndParseFieldData(next2, rootContext.childContext(fieldPath));
                if (convertAndParseFieldData != null) {
                    rootContext.addToFieldMask(fieldPath);
                    emptyObject = emptyObject.set(fieldPath, convertAndParseFieldData);
                }
            }
        }
        return parseAccumulator.toUpdateData(emptyObject);
    }

    public com.google.firebase.firestore.model.value.FieldValue parseQueryValue(Object obj) {
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.Argument);
        com.google.firebase.firestore.model.value.FieldValue convertAndParseFieldData = convertAndParseFieldData(obj, parseAccumulator.rootContext());
        Assert.hardAssert(convertAndParseFieldData != null, "Parsed data should not be null.", new Object[0]);
        Assert.hardAssert(parseAccumulator.getFieldTransforms().isEmpty(), "Field transforms should have been disallowed.", new Object[0]);
        return convertAndParseFieldData;
    }

    private com.google.firebase.firestore.model.value.FieldValue convertAndParseFieldData(Object obj, UserData.ParseContext parseContext) {
        return parseData(CustomClassMapper.convertToPlainJavaTypes(obj), parseContext);
    }

    private ObjectValue convertAndParseDocumentData(Object obj, UserData.ParseContext parseContext) {
        if (!obj.getClass().isArray()) {
            com.google.firebase.firestore.model.value.FieldValue parseData = parseData(CustomClassMapper.convertToPlainJavaTypes(obj), parseContext);
            if (parseData instanceof ObjectValue) {
                return (ObjectValue) parseData;
            }
            throw new IllegalArgumentException("Invalid data. Data must be a Map<String, Object> or a suitable POJO object, but it was " + "of type: " + Util.typeName(obj));
        }
        throw new IllegalArgumentException("Invalid data. Data must be a Map<String, Object> or a suitable POJO object, but it was " + "an array");
    }

    @Nullable
    private com.google.firebase.firestore.model.value.FieldValue parseData(Object obj, UserData.ParseContext parseContext) {
        if (obj instanceof Map) {
            return parseMap((Map) obj, parseContext);
        }
        if (obj instanceof FieldValue) {
            parseSentinelFieldValue((FieldValue) obj, parseContext);
            return null;
        }
        if (parseContext.getPath() != null) {
            parseContext.addToFieldMask(parseContext.getPath());
        }
        if (!(obj instanceof List)) {
            return parseScalarValue(obj, parseContext);
        }
        if (!parseContext.isArrayElement()) {
            return parseList((List) obj, parseContext);
        }
        throw parseContext.createError("Nested arrays are not supported");
    }

    private <K, V> ObjectValue parseMap(Map<K, V> map, UserData.ParseContext parseContext) {
        HashMap hashMap = new HashMap();
        if (map.isEmpty()) {
            if (parseContext.getPath() != null && !parseContext.getPath().isEmpty()) {
                parseContext.addToFieldMask(parseContext.getPath());
            }
            return ObjectValue.emptyObject();
        }
        for (Map.Entry next : map.entrySet()) {
            if (next.getKey() instanceof String) {
                String str = (String) next.getKey();
                com.google.firebase.firestore.model.value.FieldValue parseData = parseData(next.getValue(), parseContext.childContext(str));
                if (parseData != null) {
                    hashMap.put(str, parseData);
                }
            } else {
                throw parseContext.createError(String.format("Non-String Map key (%s) is not allowed", new Object[]{next.getValue()}));
            }
        }
        return ObjectValue.fromMap(hashMap);
    }

    private <T> ArrayValue parseList(List<T> list, UserData.ParseContext parseContext) {
        ArrayList arrayList = new ArrayList(list.size());
        int i = 0;
        for (T parseData : list) {
            Object parseData2 = parseData(parseData, parseContext.childContext(i));
            if (parseData2 == null) {
                parseData2 = NullValue.nullValue();
            }
            arrayList.add(parseData2);
            i++;
        }
        return ArrayValue.fromList(arrayList);
    }

    private void parseSentinelFieldValue(FieldValue fieldValue, UserData.ParseContext parseContext) {
        boolean z = true;
        if (!parseContext.isWrite()) {
            throw parseContext.createError(String.format("%s() can only be used with set() and update()", new Object[]{fieldValue.getMethodName()}));
        } else if (parseContext.getPath() == null) {
            throw parseContext.createError(String.format("%s() is not currently supported inside arrays", new Object[]{fieldValue.getMethodName()}));
        } else if (fieldValue instanceof FieldValue.DeleteFieldValue) {
            if (parseContext.getDataSource() == UserData.Source.MergeSet) {
                parseContext.addToFieldMask(parseContext.getPath());
            } else if (parseContext.getDataSource() == UserData.Source.Update) {
                if (parseContext.getPath().length() <= 0) {
                    z = false;
                }
                Assert.hardAssert(z, "FieldValue.delete() at the top level should have already been handled.", new Object[0]);
                throw parseContext.createError("FieldValue.delete() can only appear at the top level of your update data");
            } else {
                throw parseContext.createError("FieldValue.delete() can only be used with update() and set() with SetOptions.merge()");
            }
        } else if (fieldValue instanceof FieldValue.ServerTimestampFieldValue) {
            parseContext.addToFieldTransforms(parseContext.getPath(), ServerTimestampOperation.getInstance());
        } else if (fieldValue instanceof FieldValue.ArrayUnionFieldValue) {
            parseContext.addToFieldTransforms(parseContext.getPath(), new ArrayTransformOperation.Union(parseArrayTransformElements(((FieldValue.ArrayUnionFieldValue) fieldValue).getElements())));
        } else if (fieldValue instanceof FieldValue.ArrayRemoveFieldValue) {
            parseContext.addToFieldTransforms(parseContext.getPath(), new ArrayTransformOperation.Remove(parseArrayTransformElements(((FieldValue.ArrayRemoveFieldValue) fieldValue).getElements())));
        } else if (fieldValue instanceof FieldValue.NumericIncrementFieldValue) {
            parseContext.addToFieldTransforms(parseContext.getPath(), new NumericIncrementTransformOperation((NumberValue) parseQueryValue(((FieldValue.NumericIncrementFieldValue) fieldValue).getOperand())));
        } else {
            throw Assert.fail("Unknown FieldValue type: %s", Util.typeName(fieldValue));
        }
    }

    @Nullable
    private com.google.firebase.firestore.model.value.FieldValue parseScalarValue(Object obj, UserData.ParseContext parseContext) {
        if (obj == null) {
            return NullValue.nullValue();
        }
        if (obj instanceof Integer) {
            return IntegerValue.valueOf(Long.valueOf(((Integer) obj).longValue()));
        }
        if (obj instanceof Long) {
            return IntegerValue.valueOf((Long) obj);
        }
        if (obj instanceof Float) {
            return DoubleValue.valueOf(Double.valueOf(((Float) obj).doubleValue()));
        }
        if (obj instanceof Double) {
            return DoubleValue.valueOf((Double) obj);
        }
        if (obj instanceof Boolean) {
            return BooleanValue.valueOf((Boolean) obj);
        }
        if (obj instanceof String) {
            return StringValue.valueOf((String) obj);
        }
        if (obj instanceof Date) {
            return TimestampValue.valueOf(new Timestamp((Date) obj));
        }
        if (obj instanceof Timestamp) {
            Timestamp timestamp = (Timestamp) obj;
            return TimestampValue.valueOf(new Timestamp(timestamp.getSeconds(), (timestamp.getNanoseconds() / 1000) * 1000));
        } else if (obj instanceof GeoPoint) {
            return GeoPointValue.valueOf((GeoPoint) obj);
        } else {
            if (obj instanceof Blob) {
                return BlobValue.valueOf((Blob) obj);
            }
            if (obj instanceof DocumentReference) {
                DocumentReference documentReference = (DocumentReference) obj;
                if (documentReference.getFirestore() != null) {
                    DatabaseId databaseId2 = documentReference.getFirestore().getDatabaseId();
                    if (!databaseId2.equals(this.databaseId)) {
                        throw parseContext.createError(String.format("Document reference is for database %s/%s but should be for database %s/%s", new Object[]{databaseId2.getProjectId(), databaseId2.getDatabaseId(), this.databaseId.getProjectId(), this.databaseId.getDatabaseId()}));
                    }
                }
                return ReferenceValue.valueOf(this.databaseId, documentReference.getKey());
            } else if (obj.getClass().isArray()) {
                throw parseContext.createError("Arrays are not supported; use a List instead");
            } else {
                throw parseContext.createError("Unsupported type: " + Util.typeName(obj));
            }
        }
    }

    private List<com.google.firebase.firestore.model.value.FieldValue> parseArrayTransformElements(List<Object> list) {
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.Argument);
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(convertAndParseFieldData(list.get(i), parseAccumulator.rootContext().childContext(i)));
        }
        return arrayList;
    }
}

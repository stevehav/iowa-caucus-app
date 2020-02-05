package com.facebook.react.bridge;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaOnlyArray implements ReadableArray, WritableArray {
    private final List mBackingList;

    public static JavaOnlyArray from(List list) {
        return new JavaOnlyArray(list);
    }

    public static JavaOnlyArray of(Object... objArr) {
        return new JavaOnlyArray(objArr);
    }

    public static JavaOnlyArray deepClone(ReadableArray readableArray) {
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            switch (readableArray.getType(i)) {
                case Null:
                    javaOnlyArray.pushNull();
                    break;
                case Boolean:
                    javaOnlyArray.pushBoolean(readableArray.getBoolean(i));
                    break;
                case Number:
                    javaOnlyArray.pushDouble(readableArray.getDouble(i));
                    break;
                case String:
                    javaOnlyArray.pushString(readableArray.getString(i));
                    break;
                case Map:
                    javaOnlyArray.pushMap(JavaOnlyMap.deepClone(readableArray.getMap(i)));
                    break;
                case Array:
                    javaOnlyArray.pushArray(deepClone(readableArray.getArray(i)));
                    break;
            }
        }
        return javaOnlyArray;
    }

    private JavaOnlyArray(Object... objArr) {
        this.mBackingList = Arrays.asList(objArr);
    }

    private JavaOnlyArray(List list) {
        this.mBackingList = new ArrayList(list);
    }

    public JavaOnlyArray() {
        this.mBackingList = new ArrayList();
    }

    public int size() {
        return this.mBackingList.size();
    }

    public boolean isNull(int i) {
        return this.mBackingList.get(i) == null;
    }

    public double getDouble(int i) {
        return ((Number) this.mBackingList.get(i)).doubleValue();
    }

    public int getInt(int i) {
        return ((Number) this.mBackingList.get(i)).intValue();
    }

    @Nullable
    public String getString(int i) {
        return (String) this.mBackingList.get(i);
    }

    public ReadableArray getArray(int i) {
        return (ReadableArray) this.mBackingList.get(i);
    }

    public boolean getBoolean(int i) {
        return ((Boolean) this.mBackingList.get(i)).booleanValue();
    }

    public ReadableMap getMap(int i) {
        return (ReadableMap) this.mBackingList.get(i);
    }

    @NonNull
    public Dynamic getDynamic(int i) {
        return DynamicFromArray.create(this, i);
    }

    @NonNull
    public ReadableType getType(int i) {
        Object obj = this.mBackingList.get(i);
        if (obj == null) {
            return ReadableType.Null;
        }
        if (obj instanceof Boolean) {
            return ReadableType.Boolean;
        }
        if ((obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer)) {
            return ReadableType.Number;
        }
        if (obj instanceof String) {
            return ReadableType.String;
        }
        if (obj instanceof ReadableArray) {
            return ReadableType.Array;
        }
        if (obj instanceof ReadableMap) {
            return ReadableType.Map;
        }
        return null;
    }

    public void pushBoolean(boolean z) {
        this.mBackingList.add(Boolean.valueOf(z));
    }

    public void pushDouble(double d) {
        this.mBackingList.add(Double.valueOf(d));
    }

    public void pushInt(int i) {
        this.mBackingList.add(new Double((double) i));
    }

    public void pushString(@Nullable String str) {
        this.mBackingList.add(str);
    }

    public void pushArray(@Nullable ReadableArray readableArray) {
        this.mBackingList.add(readableArray);
    }

    public void pushMap(@Nullable ReadableMap readableMap) {
        this.mBackingList.add(readableMap);
    }

    public void pushNull() {
        this.mBackingList.add((Object) null);
    }

    @NonNull
    public ArrayList<Object> toArrayList() {
        return new ArrayList<>(this.mBackingList);
    }

    public String toString() {
        return this.mBackingList.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        JavaOnlyArray javaOnlyArray = (JavaOnlyArray) obj;
        List list = this.mBackingList;
        return list == null ? javaOnlyArray.mBackingList == null : list.equals(javaOnlyArray.mBackingList);
    }

    public int hashCode() {
        List list = this.mBackingList;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }
}

package com.drew.metadata;

import com.drew.lang.Rational;
import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.lang.annotations.SuppressWarnings;
import com.google.common.primitives.UnsignedBytes;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public abstract class Directory {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String _floatFormatPattern = "0.###";
    @NotNull
    protected final Collection<Tag> _definedTagList = new ArrayList();
    protected TagDescriptor _descriptor;
    @NotNull
    private final Collection<String> _errorList = new ArrayList(4);
    @Nullable
    private Directory _parent;
    @NotNull
    protected final Map<Integer, Object> _tagMap = new HashMap();

    @NotNull
    public abstract String getName();

    /* access modifiers changed from: protected */
    @NotNull
    public abstract HashMap<Integer, String> getTagNameMap();

    protected Directory() {
    }

    public boolean isEmpty() {
        return this._errorList.isEmpty() && this._definedTagList.isEmpty();
    }

    public boolean containsTag(int i) {
        return this._tagMap.containsKey(Integer.valueOf(i));
    }

    @NotNull
    public Collection<Tag> getTags() {
        return Collections.unmodifiableCollection(this._definedTagList);
    }

    public int getTagCount() {
        return this._definedTagList.size();
    }

    public void setDescriptor(@NotNull TagDescriptor tagDescriptor) {
        if (tagDescriptor != null) {
            this._descriptor = tagDescriptor;
            return;
        }
        throw new NullPointerException("cannot set a null descriptor");
    }

    public void addError(@NotNull String str) {
        this._errorList.add(str);
    }

    public boolean hasErrors() {
        return this._errorList.size() > 0;
    }

    @NotNull
    public Iterable<String> getErrors() {
        return Collections.unmodifiableCollection(this._errorList);
    }

    public int getErrorCount() {
        return this._errorList.size();
    }

    @Nullable
    public Directory getParent() {
        return this._parent;
    }

    public void setParent(@NotNull Directory directory) {
        this._parent = directory;
    }

    public void setInt(int i, int i2) {
        setObject(i, Integer.valueOf(i2));
    }

    public void setIntArray(int i, @NotNull int[] iArr) {
        setObjectArray(i, iArr);
    }

    public void setFloat(int i, float f) {
        setObject(i, Float.valueOf(f));
    }

    public void setFloatArray(int i, @NotNull float[] fArr) {
        setObjectArray(i, fArr);
    }

    public void setDouble(int i, double d) {
        setObject(i, Double.valueOf(d));
    }

    public void setDoubleArray(int i, @NotNull double[] dArr) {
        setObjectArray(i, dArr);
    }

    public void setStringValue(int i, @NotNull StringValue stringValue) {
        if (stringValue != null) {
            setObject(i, stringValue);
            return;
        }
        throw new NullPointerException("cannot set a null StringValue");
    }

    public void setString(int i, @NotNull String str) {
        if (str != null) {
            setObject(i, str);
            return;
        }
        throw new NullPointerException("cannot set a null String");
    }

    public void setStringArray(int i, @NotNull String[] strArr) {
        setObjectArray(i, strArr);
    }

    public void setStringValueArray(int i, @NotNull StringValue[] stringValueArr) {
        setObjectArray(i, stringValueArr);
    }

    public void setBoolean(int i, boolean z) {
        setObject(i, Boolean.valueOf(z));
    }

    public void setLong(int i, long j) {
        setObject(i, Long.valueOf(j));
    }

    public void setDate(int i, @NotNull Date date) {
        setObject(i, date);
    }

    public void setRational(int i, @NotNull Rational rational) {
        setObject(i, rational);
    }

    public void setRationalArray(int i, @NotNull Rational[] rationalArr) {
        setObjectArray(i, rationalArr);
    }

    public void setByteArray(int i, @NotNull byte[] bArr) {
        setObjectArray(i, bArr);
    }

    public void setObject(int i, @NotNull Object obj) {
        if (obj != null) {
            if (!this._tagMap.containsKey(Integer.valueOf(i))) {
                this._definedTagList.add(new Tag(i, this));
            }
            this._tagMap.put(Integer.valueOf(i), obj);
            return;
        }
        throw new NullPointerException("cannot set a null object");
    }

    public void setObjectArray(int i, @NotNull Object obj) {
        setObject(i, obj);
    }

    public int getInt(int i) throws MetadataException {
        Integer integer = getInteger(i);
        if (integer != null) {
            return integer.intValue();
        }
        Object object = getObject(i);
        if (object == null) {
            throw new MetadataException("Tag '" + getTagName(i) + "' has not been set -- check using containsTag() first");
        }
        throw new MetadataException("Tag '" + i + "' cannot be converted to int.  It is of type '" + object.getClass() + "'.");
    }

    @Nullable
    public Integer getInteger(int i) {
        Object object = getObject(i);
        if (object == null) {
            return null;
        }
        if (object instanceof Number) {
            return Integer.valueOf(((Number) object).intValue());
        }
        if ((object instanceof String) || (object instanceof StringValue)) {
            try {
                return Integer.valueOf(Integer.parseInt(object.toString()));
            } catch (NumberFormatException unused) {
                long j = 0;
                for (byte b : object.toString().getBytes()) {
                    j = (j << 8) + ((long) (b & UnsignedBytes.MAX_VALUE));
                }
                return Integer.valueOf((int) j);
            }
        } else {
            if (object instanceof Rational[]) {
                Rational[] rationalArr = (Rational[]) object;
                if (rationalArr.length == 1) {
                    return Integer.valueOf(rationalArr[0].intValue());
                }
            } else if (object instanceof byte[]) {
                byte[] bArr = (byte[]) object;
                if (bArr.length == 1) {
                    return Integer.valueOf(bArr[0]);
                }
            } else if (object instanceof int[]) {
                int[] iArr = (int[]) object;
                if (iArr.length == 1) {
                    return Integer.valueOf(iArr[0]);
                }
            } else if (object instanceof short[]) {
                short[] sArr = (short[]) object;
                if (sArr.length == 1) {
                    return Integer.valueOf(sArr[0]);
                }
            }
            return null;
        }
    }

    @Nullable
    public String[] getStringArray(int i) {
        Object object = getObject(i);
        String[] strArr = null;
        if (object == null) {
            return null;
        }
        if (object instanceof String[]) {
            return (String[]) object;
        }
        int i2 = 0;
        if (object instanceof String) {
            return new String[]{(String) object};
        } else if (object instanceof StringValue) {
            return new String[]{object.toString()};
        } else if (object instanceof StringValue[]) {
            StringValue[] stringValueArr = (StringValue[]) object;
            String[] strArr2 = new String[stringValueArr.length];
            while (i2 < strArr2.length) {
                strArr2[i2] = stringValueArr[i2].toString();
                i2++;
            }
            return strArr2;
        } else if (object instanceof int[]) {
            int[] iArr = (int[]) object;
            String[] strArr3 = new String[iArr.length];
            while (i2 < strArr3.length) {
                strArr3[i2] = Integer.toString(iArr[i2]);
                i2++;
            }
            return strArr3;
        } else if (object instanceof byte[]) {
            byte[] bArr = (byte[]) object;
            String[] strArr4 = new String[bArr.length];
            while (i2 < strArr4.length) {
                strArr4[i2] = Byte.toString(bArr[i2]);
                i2++;
            }
            return strArr4;
        } else {
            if (object instanceof Rational[]) {
                Rational[] rationalArr = (Rational[]) object;
                strArr = new String[rationalArr.length];
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    strArr[i3] = rationalArr[i3].toSimpleString(false);
                }
            }
            return strArr;
        }
    }

    @Nullable
    public StringValue[] getStringValueArray(int i) {
        Object object = getObject(i);
        if (object == null) {
            return null;
        }
        if (object instanceof StringValue[]) {
            return (StringValue[]) object;
        }
        if (!(object instanceof StringValue)) {
            return null;
        }
        return new StringValue[]{(StringValue) object};
    }

    @Nullable
    public int[] getIntArray(int i) {
        Object object = getObject(i);
        if (object == null) {
            return null;
        }
        if (object instanceof int[]) {
            return (int[]) object;
        }
        int i2 = 0;
        if (object instanceof Rational[]) {
            Rational[] rationalArr = (Rational[]) object;
            int[] iArr = new int[rationalArr.length];
            while (i2 < iArr.length) {
                iArr[i2] = rationalArr[i2].intValue();
                i2++;
            }
            return iArr;
        } else if (object instanceof short[]) {
            short[] sArr = (short[]) object;
            int[] iArr2 = new int[sArr.length];
            while (i2 < sArr.length) {
                iArr2[i2] = sArr[i2];
                i2++;
            }
            return iArr2;
        } else if (object instanceof byte[]) {
            byte[] bArr = (byte[]) object;
            int[] iArr3 = new int[bArr.length];
            while (i2 < bArr.length) {
                iArr3[i2] = bArr[i2];
                i2++;
            }
            return iArr3;
        } else if (object instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) object;
            int[] iArr4 = new int[charSequence.length()];
            while (i2 < charSequence.length()) {
                iArr4[i2] = charSequence.charAt(i2);
                i2++;
            }
            return iArr4;
        } else if (!(object instanceof Integer)) {
            return null;
        } else {
            return new int[]{((Integer) object).intValue()};
        }
    }

    @Nullable
    public byte[] getByteArray(int i) {
        Object object = getObject(i);
        if (object == null) {
            return null;
        }
        if (object instanceof StringValue) {
            return ((StringValue) object).getBytes();
        }
        int i2 = 0;
        if (object instanceof Rational[]) {
            Rational[] rationalArr = (Rational[]) object;
            byte[] bArr = new byte[rationalArr.length];
            while (i2 < bArr.length) {
                bArr[i2] = rationalArr[i2].byteValue();
                i2++;
            }
            return bArr;
        } else if (object instanceof byte[]) {
            return (byte[]) object;
        } else {
            if (object instanceof int[]) {
                int[] iArr = (int[]) object;
                byte[] bArr2 = new byte[iArr.length];
                while (i2 < iArr.length) {
                    bArr2[i2] = (byte) iArr[i2];
                    i2++;
                }
                return bArr2;
            } else if (object instanceof short[]) {
                short[] sArr = (short[]) object;
                byte[] bArr3 = new byte[sArr.length];
                while (i2 < sArr.length) {
                    bArr3[i2] = (byte) sArr[i2];
                    i2++;
                }
                return bArr3;
            } else if (object instanceof CharSequence) {
                CharSequence charSequence = (CharSequence) object;
                byte[] bArr4 = new byte[charSequence.length()];
                while (i2 < charSequence.length()) {
                    bArr4[i2] = (byte) charSequence.charAt(i2);
                    i2++;
                }
                return bArr4;
            } else if (!(object instanceof Integer)) {
                return null;
            } else {
                return new byte[]{((Integer) object).byteValue()};
            }
        }
    }

    public double getDouble(int i) throws MetadataException {
        Double doubleObject = getDoubleObject(i);
        if (doubleObject != null) {
            return doubleObject.doubleValue();
        }
        Object object = getObject(i);
        if (object == null) {
            throw new MetadataException("Tag '" + getTagName(i) + "' has not been set -- check using containsTag() first");
        }
        throw new MetadataException("Tag '" + i + "' cannot be converted to a double.  It is of type '" + object.getClass() + "'.");
    }

    @Nullable
    public Double getDoubleObject(int i) {
        Object object = getObject(i);
        if (object == null) {
            return null;
        }
        if ((object instanceof String) || (object instanceof StringValue)) {
            try {
                return Double.valueOf(Double.parseDouble(object.toString()));
            } catch (NumberFormatException unused) {
                return null;
            }
        } else if (object instanceof Number) {
            return Double.valueOf(((Number) object).doubleValue());
        } else {
            return null;
        }
    }

    public float getFloat(int i) throws MetadataException {
        Float floatObject = getFloatObject(i);
        if (floatObject != null) {
            return floatObject.floatValue();
        }
        Object object = getObject(i);
        if (object == null) {
            throw new MetadataException("Tag '" + getTagName(i) + "' has not been set -- check using containsTag() first");
        }
        throw new MetadataException("Tag '" + i + "' cannot be converted to a float.  It is of type '" + object.getClass() + "'.");
    }

    @Nullable
    public Float getFloatObject(int i) {
        Object object = getObject(i);
        if (object == null) {
            return null;
        }
        if ((object instanceof String) || (object instanceof StringValue)) {
            try {
                return Float.valueOf(Float.parseFloat(object.toString()));
            } catch (NumberFormatException unused) {
                return null;
            }
        } else if (object instanceof Number) {
            return Float.valueOf(((Number) object).floatValue());
        } else {
            return null;
        }
    }

    public long getLong(int i) throws MetadataException {
        Long longObject = getLongObject(i);
        if (longObject != null) {
            return longObject.longValue();
        }
        Object object = getObject(i);
        if (object == null) {
            throw new MetadataException("Tag '" + getTagName(i) + "' has not been set -- check using containsTag() first");
        }
        throw new MetadataException("Tag '" + i + "' cannot be converted to a long.  It is of type '" + object.getClass() + "'.");
    }

    @Nullable
    public Long getLongObject(int i) {
        Object object = getObject(i);
        if (object == null) {
            return null;
        }
        if (object instanceof Number) {
            return Long.valueOf(((Number) object).longValue());
        }
        if ((object instanceof String) || (object instanceof StringValue)) {
            try {
                return Long.valueOf(Long.parseLong(object.toString()));
            } catch (NumberFormatException unused) {
                return null;
            }
        } else {
            if (object instanceof Rational[]) {
                Rational[] rationalArr = (Rational[]) object;
                if (rationalArr.length == 1) {
                    return Long.valueOf(rationalArr[0].longValue());
                }
            } else if (object instanceof byte[]) {
                byte[] bArr = (byte[]) object;
                if (bArr.length == 1) {
                    return Long.valueOf((long) bArr[0]);
                }
            } else if (object instanceof int[]) {
                int[] iArr = (int[]) object;
                if (iArr.length == 1) {
                    return Long.valueOf((long) iArr[0]);
                }
            } else if (object instanceof short[]) {
                short[] sArr = (short[]) object;
                if (sArr.length == 1) {
                    return Long.valueOf((long) sArr[0]);
                }
            }
            return null;
        }
    }

    public boolean getBoolean(int i) throws MetadataException {
        Boolean booleanObject = getBooleanObject(i);
        if (booleanObject != null) {
            return booleanObject.booleanValue();
        }
        Object object = getObject(i);
        if (object == null) {
            throw new MetadataException("Tag '" + getTagName(i) + "' has not been set -- check using containsTag() first");
        }
        throw new MetadataException("Tag '" + i + "' cannot be converted to a boolean.  It is of type '" + object.getClass() + "'.");
    }

    @Nullable
    @SuppressWarnings(justification = "keep API interface consistent", value = "NP_BOOLEAN_RETURN_NULL")
    public Boolean getBooleanObject(int i) {
        Object object = getObject(i);
        if (object == null) {
            return null;
        }
        if (object instanceof Boolean) {
            return (Boolean) object;
        }
        if ((object instanceof String) || (object instanceof StringValue)) {
            try {
                return Boolean.valueOf(Boolean.getBoolean(object.toString()));
            } catch (NumberFormatException unused) {
                return null;
            }
        } else if (!(object instanceof Number)) {
            return null;
        } else {
            return Boolean.valueOf(((Number) object).doubleValue() != 0.0d);
        }
    }

    @Nullable
    public Date getDate(int i) {
        return getDate(i, (String) null, (TimeZone) null);
    }

    @Nullable
    public Date getDate(int i, @Nullable TimeZone timeZone) {
        return getDate(i, (String) null, timeZone);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d4 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d5  */
    @com.drew.lang.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Date getDate(int r8, @com.drew.lang.annotations.Nullable java.lang.String r9, @com.drew.lang.annotations.Nullable java.util.TimeZone r10) {
        /*
            r7 = this;
            java.lang.Object r8 = r7.getObject(r8)
            boolean r0 = r8 instanceof java.util.Date
            if (r0 == 0) goto L_0x000b
            java.util.Date r8 = (java.util.Date) r8
            return r8
        L_0x000b:
            boolean r0 = r8 instanceof java.lang.String
            r1 = 0
            if (r0 != 0) goto L_0x0018
            boolean r0 = r8 instanceof com.drew.metadata.StringValue
            if (r0 == 0) goto L_0x0015
            goto L_0x0018
        L_0x0015:
            r8 = r1
            goto L_0x00d2
        L_0x0018:
            r0 = 12
            java.lang.String[] r0 = new java.lang.String[r0]
            r2 = 0
            java.lang.String r3 = "yyyy:MM:dd HH:mm:ss"
            r0[r2] = r3
            r3 = 1
            java.lang.String r4 = "yyyy:MM:dd HH:mm"
            r0[r3] = r4
            r4 = 2
            java.lang.String r5 = "yyyy-MM-dd HH:mm:ss"
            r0[r4] = r5
            r5 = 3
            java.lang.String r6 = "yyyy-MM-dd HH:mm"
            r0[r5] = r6
            r5 = 4
            java.lang.String r6 = "yyyy.MM.dd HH:mm:ss"
            r0[r5] = r6
            r5 = 5
            java.lang.String r6 = "yyyy.MM.dd HH:mm"
            r0[r5] = r6
            r5 = 6
            java.lang.String r6 = "yyyy-MM-dd'T'HH:mm:ss"
            r0[r5] = r6
            r5 = 7
            java.lang.String r6 = "yyyy-MM-dd'T'HH:mm"
            r0[r5] = r6
            r5 = 8
            java.lang.String r6 = "yyyy-MM-dd"
            r0[r5] = r6
            r5 = 9
            java.lang.String r6 = "yyyy-MM"
            r0[r5] = r6
            r5 = 10
            java.lang.String r6 = "yyyyMMdd"
            r0[r5] = r6
            r5 = 11
            java.lang.String r6 = "yyyy"
            r0[r5] = r6
            java.lang.String r8 = r8.toString()
            java.lang.String r5 = "(\\d\\d:\\d\\d:\\d\\d)(\\.\\d+)"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.util.regex.Matcher r5 = r5.matcher(r8)
            boolean r6 = r5.find()
            if (r6 == 0) goto L_0x007e
            java.lang.String r8 = r5.group(r4)
            java.lang.String r9 = r8.substring(r3)
            java.lang.String r8 = "$1"
            java.lang.String r8 = r5.replaceAll(r8)
        L_0x007e:
            java.lang.String r3 = "(Z|[+-]\\d\\d:\\d\\d)$"
            java.util.regex.Pattern r3 = java.util.regex.Pattern.compile(r3)
            java.util.regex.Matcher r3 = r3.matcher(r8)
            boolean r4 = r3.find()
            java.lang.String r5 = "GMT"
            if (r4 == 0) goto L_0x00b3
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r5)
            java.lang.String r10 = r3.group()
            java.lang.String r4 = ""
            java.lang.String r6 = "Z"
            java.lang.String r10 = r10.replaceAll(r6, r4)
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            java.util.TimeZone r10 = java.util.TimeZone.getTimeZone(r8)
            java.lang.String r8 = r3.replaceAll(r4)
        L_0x00b3:
            int r3 = r0.length
        L_0x00b4:
            if (r2 >= r3) goto L_0x0015
            r4 = r0[r2]
            java.text.SimpleDateFormat r6 = new java.text.SimpleDateFormat     // Catch:{ ParseException -> 0x00cf }
            r6.<init>(r4)     // Catch:{ ParseException -> 0x00cf }
            if (r10 == 0) goto L_0x00c3
            r6.setTimeZone(r10)     // Catch:{ ParseException -> 0x00cf }
            goto L_0x00ca
        L_0x00c3:
            java.util.TimeZone r4 = java.util.TimeZone.getTimeZone(r5)     // Catch:{ ParseException -> 0x00cf }
            r6.setTimeZone(r4)     // Catch:{ ParseException -> 0x00cf }
        L_0x00ca:
            java.util.Date r8 = r6.parse(r8)     // Catch:{ ParseException -> 0x00cf }
            goto L_0x00d2
        L_0x00cf:
            int r2 = r2 + 1
            goto L_0x00b4
        L_0x00d2:
            if (r8 != 0) goto L_0x00d5
            return r1
        L_0x00d5:
            if (r9 != 0) goto L_0x00d8
            return r8
        L_0x00d8:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x010b }
            r10.<init>()     // Catch:{ NumberFormatException -> 0x010b }
            java.lang.String r0 = "."
            r10.append(r0)     // Catch:{ NumberFormatException -> 0x010b }
            r10.append(r9)     // Catch:{ NumberFormatException -> 0x010b }
            java.lang.String r9 = r10.toString()     // Catch:{ NumberFormatException -> 0x010b }
            double r9 = java.lang.Double.parseDouble(r9)     // Catch:{ NumberFormatException -> 0x010b }
            r0 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r9 = r9 * r0
            int r9 = (int) r9     // Catch:{ NumberFormatException -> 0x010b }
            if (r9 < 0) goto L_0x010b
            r10 = 1000(0x3e8, float:1.401E-42)
            if (r9 >= r10) goto L_0x010b
            java.util.Calendar r10 = java.util.Calendar.getInstance()     // Catch:{ NumberFormatException -> 0x010b }
            r10.setTime(r8)     // Catch:{ NumberFormatException -> 0x010b }
            r0 = 14
            r10.set(r0, r9)     // Catch:{ NumberFormatException -> 0x010b }
            java.util.Date r8 = r10.getTime()     // Catch:{ NumberFormatException -> 0x010b }
        L_0x010b:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.drew.metadata.Directory.getDate(int, java.lang.String, java.util.TimeZone):java.util.Date");
    }

    @Nullable
    public Rational getRational(int i) {
        Object object = getObject(i);
        if (object == null) {
            return null;
        }
        if (object instanceof Rational) {
            return (Rational) object;
        }
        if (object instanceof Integer) {
            return new Rational((long) ((Integer) object).intValue(), 1);
        }
        if (object instanceof Long) {
            return new Rational(((Long) object).longValue(), 1);
        }
        return null;
    }

    @Nullable
    public Rational[] getRationalArray(int i) {
        Object object = getObject(i);
        if (object != null && (object instanceof Rational[])) {
            return (Rational[]) object;
        }
        return null;
    }

    @Nullable
    public String getString(int i) {
        Object object = getObject(i);
        if (object == null) {
            return null;
        }
        if (object instanceof Rational) {
            return ((Rational) object).toSimpleString(true);
        }
        if (object.getClass().isArray()) {
            int length = Array.getLength(object);
            Class<?> componentType = object.getClass().getComponentType();
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            if (Object.class.isAssignableFrom(componentType)) {
                while (i2 < length) {
                    if (i2 != 0) {
                        sb.append(' ');
                    }
                    sb.append(Array.get(object, i2).toString());
                    i2++;
                }
            } else if (componentType.getName().equals("int")) {
                while (i2 < length) {
                    if (i2 != 0) {
                        sb.append(' ');
                    }
                    sb.append(Array.getInt(object, i2));
                    i2++;
                }
            } else if (componentType.getName().equals("short")) {
                while (i2 < length) {
                    if (i2 != 0) {
                        sb.append(' ');
                    }
                    sb.append(Array.getShort(object, i2));
                    i2++;
                }
            } else if (componentType.getName().equals("long")) {
                while (i2 < length) {
                    if (i2 != 0) {
                        sb.append(' ');
                    }
                    sb.append(Array.getLong(object, i2));
                    i2++;
                }
            } else if (componentType.getName().equals("float")) {
                DecimalFormat decimalFormat = new DecimalFormat(_floatFormatPattern);
                while (i2 < length) {
                    if (i2 != 0) {
                        sb.append(' ');
                    }
                    String format = decimalFormat.format((double) Array.getFloat(object, i2));
                    if (format.equals("-0")) {
                        format = "0";
                    }
                    sb.append(format);
                    i2++;
                }
            } else if (componentType.getName().equals("double")) {
                DecimalFormat decimalFormat2 = new DecimalFormat(_floatFormatPattern);
                while (i2 < length) {
                    if (i2 != 0) {
                        sb.append(' ');
                    }
                    String format2 = decimalFormat2.format(Array.getDouble(object, i2));
                    if (format2.equals("-0")) {
                        format2 = "0";
                    }
                    sb.append(format2);
                    i2++;
                }
            } else if (componentType.getName().equals("byte")) {
                while (i2 < length) {
                    if (i2 != 0) {
                        sb.append(' ');
                    }
                    sb.append(Array.getByte(object, i2) & UnsignedBytes.MAX_VALUE);
                    i2++;
                }
            } else {
                addError("Unexpected array component type: " + componentType.getName());
            }
            return sb.toString();
        } else if (object instanceof Double) {
            return new DecimalFormat(_floatFormatPattern).format(((Double) object).doubleValue());
        } else {
            if (object instanceof Float) {
                return new DecimalFormat(_floatFormatPattern).format((double) ((Float) object).floatValue());
            }
            return object.toString();
        }
    }

    @Nullable
    public String getString(int i, String str) {
        byte[] byteArray = getByteArray(i);
        if (byteArray == null) {
            return null;
        }
        try {
            return new String(byteArray, str);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    @Nullable
    public StringValue getStringValue(int i) {
        Object object = getObject(i);
        if (object instanceof StringValue) {
            return (StringValue) object;
        }
        return null;
    }

    @Nullable
    public Object getObject(int i) {
        return this._tagMap.get(Integer.valueOf(i));
    }

    @NotNull
    public String getTagName(int i) {
        HashMap<Integer, String> tagNameMap = getTagNameMap();
        if (tagNameMap.containsKey(Integer.valueOf(i))) {
            return tagNameMap.get(Integer.valueOf(i));
        }
        String hexString = Integer.toHexString(i);
        while (hexString.length() < 4) {
            hexString = "0" + hexString;
        }
        return "Unknown tag (0x" + hexString + ")";
    }

    public boolean hasTagName(int i) {
        return getTagNameMap().containsKey(Integer.valueOf(i));
    }

    @Nullable
    public String getDescription(int i) {
        return this._descriptor.getDescription(i);
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = getName();
        objArr[1] = Integer.valueOf(this._tagMap.size());
        objArr[2] = this._tagMap.size() == 1 ? "tag" : "tags";
        return String.format("%s Directory (%d %s)", objArr);
    }
}

package com.google.android.gms.internal.firebase_auth;

import java.lang.reflect.Type;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public enum zzhr {
    DOUBLE(0, zzht.SCALAR, zzii.DOUBLE),
    FLOAT(1, zzht.SCALAR, zzii.FLOAT),
    INT64(2, zzht.SCALAR, zzii.LONG),
    UINT64(3, zzht.SCALAR, zzii.LONG),
    INT32(4, zzht.SCALAR, zzii.INT),
    FIXED64(5, zzht.SCALAR, zzii.LONG),
    FIXED32(6, zzht.SCALAR, zzii.INT),
    BOOL(7, zzht.SCALAR, zzii.BOOLEAN),
    STRING(8, zzht.SCALAR, zzii.STRING),
    MESSAGE(9, zzht.SCALAR, zzii.MESSAGE),
    BYTES(10, zzht.SCALAR, zzii.BYTE_STRING),
    UINT32(11, zzht.SCALAR, zzii.INT),
    ENUM(12, zzht.SCALAR, zzii.ENUM),
    SFIXED32(13, zzht.SCALAR, zzii.INT),
    SFIXED64(14, zzht.SCALAR, zzii.LONG),
    SINT32(15, zzht.SCALAR, zzii.INT),
    SINT64(16, zzht.SCALAR, zzii.LONG),
    GROUP(17, zzht.SCALAR, zzii.MESSAGE),
    DOUBLE_LIST(18, zzht.VECTOR, zzii.DOUBLE),
    FLOAT_LIST(19, zzht.VECTOR, zzii.FLOAT),
    INT64_LIST(20, zzht.VECTOR, zzii.LONG),
    UINT64_LIST(21, zzht.VECTOR, zzii.LONG),
    INT32_LIST(22, zzht.VECTOR, zzii.INT),
    FIXED64_LIST(23, zzht.VECTOR, zzii.LONG),
    FIXED32_LIST(24, zzht.VECTOR, zzii.INT),
    BOOL_LIST(25, zzht.VECTOR, zzii.BOOLEAN),
    STRING_LIST(26, zzht.VECTOR, zzii.STRING),
    MESSAGE_LIST(27, zzht.VECTOR, zzii.MESSAGE),
    BYTES_LIST(28, zzht.VECTOR, zzii.BYTE_STRING),
    UINT32_LIST(29, zzht.VECTOR, zzii.INT),
    ENUM_LIST(30, zzht.VECTOR, zzii.ENUM),
    SFIXED32_LIST(31, zzht.VECTOR, zzii.INT),
    SFIXED64_LIST(32, zzht.VECTOR, zzii.LONG),
    SINT32_LIST(33, zzht.VECTOR, zzii.INT),
    SINT64_LIST(34, zzht.VECTOR, zzii.LONG),
    DOUBLE_LIST_PACKED(35, zzht.PACKED_VECTOR, zzii.DOUBLE),
    FLOAT_LIST_PACKED(36, zzht.PACKED_VECTOR, zzii.FLOAT),
    INT64_LIST_PACKED(37, zzht.PACKED_VECTOR, zzii.LONG),
    UINT64_LIST_PACKED(38, zzht.PACKED_VECTOR, zzii.LONG),
    INT32_LIST_PACKED(39, zzht.PACKED_VECTOR, zzii.INT),
    FIXED64_LIST_PACKED(40, zzht.PACKED_VECTOR, zzii.LONG),
    FIXED32_LIST_PACKED(41, zzht.PACKED_VECTOR, zzii.INT),
    BOOL_LIST_PACKED(42, zzht.PACKED_VECTOR, zzii.BOOLEAN),
    UINT32_LIST_PACKED(43, zzht.PACKED_VECTOR, zzii.INT),
    ENUM_LIST_PACKED(44, zzht.PACKED_VECTOR, zzii.ENUM),
    SFIXED32_LIST_PACKED(45, zzht.PACKED_VECTOR, zzii.INT),
    SFIXED64_LIST_PACKED(46, zzht.PACKED_VECTOR, zzii.LONG),
    SINT32_LIST_PACKED(47, zzht.PACKED_VECTOR, zzii.INT),
    SINT64_LIST_PACKED(48, zzht.PACKED_VECTOR, zzii.LONG),
    GROUP_LIST(49, zzht.VECTOR, zzii.MESSAGE),
    MAP(50, zzht.MAP, zzii.VOID);
    
    private static final zzhr[] zzbe = null;
    private static final Type[] zzbf = null;
    private final zzii zzaz;
    private final int zzba;
    private final zzht zzbb;
    private final Class<?> zzbc;
    private final boolean zzbd;

    private zzhr(int i, zzht zzht, zzii zzii) {
        int i2;
        this.zzba = i;
        this.zzbb = zzht;
        this.zzaz = zzii;
        int i3 = zzhu.zza[zzht.ordinal()];
        if (i3 == 1) {
            this.zzbc = zzii.zza();
        } else if (i3 != 2) {
            this.zzbc = null;
        } else {
            this.zzbc = zzii.zza();
        }
        boolean z = false;
        if (!(zzht != zzht.SCALAR || (i2 = zzhu.zzb[zzii.ordinal()]) == 1 || i2 == 2 || i2 == 3)) {
            z = true;
        }
        this.zzbd = z;
    }

    public final int zza() {
        return this.zzba;
    }

    static {
        int i;
        zzbf = new Type[0];
        zzhr[] values = values();
        zzbe = new zzhr[values.length];
        for (zzhr zzhr : values) {
            zzbe[zzhr.zzba] = zzhr;
        }
    }
}

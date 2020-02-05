package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzjl {
    private zzfe zzade;
    private int zzadf;
    private final ByteBuffer zzsw;

    private zzjl(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    public static int zzbd(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    private zzjl(ByteBuffer byteBuffer) {
        this.zzsw = byteBuffer;
        this.zzsw.order(ByteOrder.LITTLE_ENDIAN);
    }

    public static zzjl zzk(byte[] bArr) {
        return zzl(bArr, 0, bArr.length);
    }

    public static zzjl zzl(byte[] bArr, int i, int i2) {
        return new zzjl(bArr, 0, i2);
    }

    public final void zza(int i, float f) throws IOException {
        zzd(i, 5);
        int floatToIntBits = Float.floatToIntBits(f);
        if (this.zzsw.remaining() >= 4) {
            this.zzsw.putInt(floatToIntBits);
            return;
        }
        throw new zzjm(this.zzsw.position(), this.zzsw.limit());
    }

    public final void zzi(int i, long j) throws IOException {
        zzd(i, 0);
        zzq(j);
    }

    public final void zze(int i, int i2) throws IOException {
        zzd(i, 0);
        if (i2 >= 0) {
            zzbv(i2);
        } else {
            zzq((long) i2);
        }
    }

    public final void zzb(int i, boolean z) throws IOException {
        zzd(i, 0);
        byte b = z ? (byte) 1 : 0;
        if (this.zzsw.hasRemaining()) {
            this.zzsw.put(b);
            return;
        }
        throw new zzjm(this.zzsw.position(), this.zzsw.limit());
    }

    public final void zza(int i, String str) throws IOException {
        zzd(i, 2);
        try {
            int zzbd = zzbd(str.length());
            if (zzbd == zzbd(str.length() * 3)) {
                int position = this.zzsw.position();
                if (this.zzsw.remaining() >= zzbd) {
                    this.zzsw.position(position + zzbd);
                    zzd((CharSequence) str, this.zzsw);
                    int position2 = this.zzsw.position();
                    this.zzsw.position(position);
                    zzbv((position2 - position) - zzbd);
                    this.zzsw.position(position2);
                    return;
                }
                throw new zzjm(position + zzbd, this.zzsw.limit());
            }
            zzbv(zza(str));
            zzd((CharSequence) str, this.zzsw);
        } catch (BufferOverflowException e) {
            zzjm zzjm = new zzjm(this.zzsw.position(), this.zzsw.limit());
            zzjm.initCause(e);
            throw zzjm;
        }
    }

    public final void zza(int i, zzjt zzjt) throws IOException {
        zzd(i, 2);
        if (zzjt.zzadp < 0) {
            zzjt.zzeq();
        }
        zzbv(zzjt.zzadp);
        zzjt.zza(this);
    }

    public final void zze(int i, zzhf zzhf) throws IOException {
        if (this.zzade == null) {
            this.zzade = zzfe.zza(this.zzsw);
            this.zzadf = this.zzsw.position();
        } else if (this.zzadf != this.zzsw.position()) {
            this.zzade.write(this.zzsw.array(), this.zzadf, this.zzsw.position() - this.zzadf);
            this.zzadf = this.zzsw.position();
        }
        zzfe zzfe = this.zzade;
        zzfe.zza(2, zzhf);
        zzfe.flush();
        this.zzadf = this.zzsw.position();
    }

    private static int zza(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) >= 65536) {
                                i2++;
                            } else {
                                StringBuilder sb = new StringBuilder(39);
                                sb.append("Unpaired surrogate at index ");
                                sb.append(i2);
                                throw new IllegalArgumentException(sb.toString());
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("UTF-8 length does not fit in int: ");
        sb2.append(((long) i3) + 4294967296L);
        throw new IllegalArgumentException(sb2.toString());
    }

    private static void zzd(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int i2;
        char charAt;
        if (!byteBuffer.isReadOnly()) {
            int i3 = 0;
            if (byteBuffer.hasArray()) {
                try {
                    byte[] array = byteBuffer.array();
                    int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                    int remaining = byteBuffer.remaining();
                    int length = charSequence.length();
                    int i4 = remaining + arrayOffset;
                    while (i3 < length) {
                        int i5 = i3 + arrayOffset;
                        if (i5 >= i4 || (charAt = charSequence.charAt(i3)) >= 128) {
                            break;
                        }
                        array[i5] = (byte) charAt;
                        i3++;
                    }
                    if (i3 == length) {
                        i = arrayOffset + length;
                    } else {
                        i = arrayOffset + i3;
                        while (i3 < length) {
                            char charAt2 = charSequence.charAt(i3);
                            if (charAt2 < 128 && i < i4) {
                                i2 = i + 1;
                                array[i] = (byte) charAt2;
                            } else if (charAt2 < 2048 && i <= i4 - 2) {
                                int i6 = i + 1;
                                array[i] = (byte) ((charAt2 >>> 6) | 960);
                                i = i6 + 1;
                                array[i6] = (byte) ((charAt2 & '?') | 128);
                                i3++;
                            } else if ((charAt2 < 55296 || 57343 < charAt2) && i <= i4 - 3) {
                                int i7 = i + 1;
                                array[i] = (byte) ((charAt2 >>> 12) | 480);
                                int i8 = i7 + 1;
                                array[i7] = (byte) (((charAt2 >>> 6) & 63) | 128);
                                i2 = i8 + 1;
                                array[i8] = (byte) ((charAt2 & '?') | 128);
                            } else if (i <= i4 - 4) {
                                int i9 = i3 + 1;
                                if (i9 != charSequence.length()) {
                                    char charAt3 = charSequence.charAt(i9);
                                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                                        int i10 = i + 1;
                                        array[i] = (byte) ((codePoint >>> 18) | 240);
                                        int i11 = i10 + 1;
                                        array[i10] = (byte) (((codePoint >>> 12) & 63) | 128);
                                        int i12 = i11 + 1;
                                        array[i11] = (byte) (((codePoint >>> 6) & 63) | 128);
                                        i = i12 + 1;
                                        array[i12] = (byte) ((codePoint & 63) | 128);
                                        i3 = i9;
                                        i3++;
                                    } else {
                                        i3 = i9;
                                    }
                                }
                                StringBuilder sb = new StringBuilder(39);
                                sb.append("Unpaired surrogate at index ");
                                sb.append(i3 - 1);
                                throw new IllegalArgumentException(sb.toString());
                            } else {
                                StringBuilder sb2 = new StringBuilder(37);
                                sb2.append("Failed writing ");
                                sb2.append(charAt2);
                                sb2.append(" at index ");
                                sb2.append(i);
                                throw new ArrayIndexOutOfBoundsException(sb2.toString());
                            }
                            i = i2;
                            i3++;
                        }
                    }
                    byteBuffer.position(i - byteBuffer.arrayOffset());
                } catch (ArrayIndexOutOfBoundsException e) {
                    BufferOverflowException bufferOverflowException = new BufferOverflowException();
                    bufferOverflowException.initCause(e);
                    throw bufferOverflowException;
                }
            } else {
                int length2 = charSequence.length();
                while (i3 < length2) {
                    char charAt4 = charSequence.charAt(i3);
                    if (charAt4 < 128) {
                        byteBuffer.put((byte) charAt4);
                    } else if (charAt4 < 2048) {
                        byteBuffer.put((byte) ((charAt4 >>> 6) | 960));
                        byteBuffer.put((byte) ((charAt4 & '?') | 128));
                    } else if (charAt4 < 55296 || 57343 < charAt4) {
                        byteBuffer.put((byte) ((charAt4 >>> 12) | 480));
                        byteBuffer.put((byte) (((charAt4 >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((charAt4 & '?') | 128));
                    } else {
                        int i13 = i3 + 1;
                        if (i13 != charSequence.length()) {
                            char charAt5 = charSequence.charAt(i13);
                            if (Character.isSurrogatePair(charAt4, charAt5)) {
                                int codePoint2 = Character.toCodePoint(charAt4, charAt5);
                                byteBuffer.put((byte) ((codePoint2 >>> 18) | 240));
                                byteBuffer.put((byte) (((codePoint2 >>> 12) & 63) | 128));
                                byteBuffer.put((byte) (((codePoint2 >>> 6) & 63) | 128));
                                byteBuffer.put((byte) ((codePoint2 & 63) | 128));
                                i3 = i13;
                            } else {
                                i3 = i13;
                            }
                        }
                        StringBuilder sb3 = new StringBuilder(39);
                        sb3.append("Unpaired surrogate at index ");
                        sb3.append(i3 - 1);
                        throw new IllegalArgumentException(sb3.toString());
                    }
                    i3++;
                }
            }
        } else {
            throw new ReadOnlyBufferException();
        }
    }

    public static int zzd(int i, long j) {
        return zzav(i) + ((-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (j & Long.MIN_VALUE) == 0 ? 9 : 10);
    }

    public static int zzi(int i, int i2) {
        return zzav(i) + zzaw(i2);
    }

    public static int zzb(int i, String str) {
        return zzav(i) + zzn(str);
    }

    public static int zzb(int i, zzjt zzjt) {
        int zzav = zzav(i);
        int zzeq = zzjt.zzeq();
        return zzav + zzbd(zzeq) + zzeq;
    }

    public static int zzaw(int i) {
        if (i >= 0) {
            return zzbd(i);
        }
        return 10;
    }

    public static int zzn(String str) {
        int zza = zza(str);
        return zzbd(zza) + zza;
    }

    public final void zzea() {
        if (this.zzsw.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", new Object[]{Integer.valueOf(this.zzsw.remaining())}));
        }
    }

    private final void zzbu(int i) throws IOException {
        byte b = (byte) i;
        if (this.zzsw.hasRemaining()) {
            this.zzsw.put(b);
            return;
        }
        throw new zzjm(this.zzsw.position(), this.zzsw.limit());
    }

    public final void zzl(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.zzsw.remaining() >= length) {
            this.zzsw.put(bArr, 0, length);
            return;
        }
        throw new zzjm(this.zzsw.position(), this.zzsw.limit());
    }

    private final void zzd(int i, int i2) throws IOException {
        zzbv((i << 3) | i2);
    }

    public static int zzav(int i) {
        return zzbd(i << 3);
    }

    public final void zzbv(int i) throws IOException {
        while ((i & -128) != 0) {
            zzbu((i & 127) | 128);
            i >>>= 7;
        }
        zzbu(i);
    }

    private final void zzq(long j) throws IOException {
        while ((-128 & j) != 0) {
            zzbu((((int) j) & 127) | 128);
            j >>>= 7;
        }
        zzbu((int) j);
    }
}

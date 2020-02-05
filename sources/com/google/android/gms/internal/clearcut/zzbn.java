package com.google.android.gms.internal.clearcut;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzbn extends zzba {
    private static final Logger logger = Logger.getLogger(zzbn.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzfy = zzfd.zzed();
    zzbp zzfz;

    static class zza extends zzbn {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zza(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i + i2;
                if ((i | i2 | (bArr.length - i3)) >= 0) {
                    this.buffer = bArr;
                    this.offset = i;
                    this.position = i;
                    this.limit = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
            }
            throw new NullPointerException("buffer");
        }

        public void flush() {
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)}), e);
            }
        }

        public final void zza(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        public final void zza(int i, long j) throws IOException {
            zzb(i, 0);
            zzb(j);
        }

        public final void zza(int i, zzbb zzbb) throws IOException {
            zzb(i, 2);
            zza(zzbb);
        }

        public final void zza(int i, zzdo zzdo) throws IOException {
            zzb(i, 2);
            zzb(zzdo);
        }

        /* access modifiers changed from: package-private */
        public final void zza(int i, zzdo zzdo, zzef zzef) throws IOException {
            zzb(i, 2);
            zzas zzas = (zzas) zzdo;
            int zzs = zzas.zzs();
            if (zzs == -1) {
                zzs = zzef.zzm(zzas);
                zzas.zzf(zzs);
            }
            zzo(zzs);
            zzef.zza(zzdo, this.zzfz);
        }

        public final void zza(int i, String str) throws IOException {
            zzb(i, 2);
            zzg(str);
        }

        public final void zza(zzbb zzbb) throws IOException {
            zzo(zzbb.size());
            zzbb.zza((zzba) this);
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzdo zzdo, zzef zzef) throws IOException {
            zzas zzas = (zzas) zzdo;
            int zzs = zzas.zzs();
            if (zzs == -1) {
                zzs = zzef.zzm(zzas);
                zzas.zzf(zzs);
            }
            zzo(zzs);
            zzef.zza(zzdo, this.zzfz);
        }

        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final int zzag() {
            return this.limit - this.position;
        }

        public final int zzai() {
            return this.position - this.offset;
        }

        public final void zzb(int i, int i2) throws IOException {
            zzo((i << 3) | i2);
        }

        public final void zzb(int i, zzbb zzbb) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzbb);
            zzb(1, 4);
        }

        public final void zzb(int i, zzdo zzdo) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzdo);
            zzb(1, 4);
        }

        public final void zzb(int i, boolean z) throws IOException {
            zzb(i, 0);
            zza(z ? (byte) 1 : 0);
        }

        public final void zzb(long j) throws IOException {
            if (!zzbn.zzfy || zzag() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i = this.position;
                    this.position = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    zzfd.zza(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzfd.zza(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final void zzb(zzdo zzdo) throws IOException {
            zzo(zzdo.zzas());
            zzdo.zzb(this);
        }

        public final void zzc(int i, int i2) throws IOException {
            zzb(i, 0);
            zzn(i2);
        }

        public final void zzc(int i, long j) throws IOException {
            zzb(i, 1);
            zzd(j);
        }

        public final void zzd(int i, int i2) throws IOException {
            zzb(i, 0);
            zzo(i2);
        }

        public final void zzd(long j) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) j);
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr2[i2] = (byte) ((int) (j >> 8));
                byte[] bArr3 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr3[i3] = (byte) ((int) (j >> 16));
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr4[i4] = (byte) ((int) (j >> 24));
                byte[] bArr5 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr5[i5] = (byte) ((int) (j >> 32));
                byte[] bArr6 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                bArr6[i6] = (byte) ((int) (j >> 40));
                byte[] bArr7 = this.buffer;
                int i7 = this.position;
                this.position = i7 + 1;
                bArr7[i7] = (byte) ((int) (j >> 48));
                byte[] bArr8 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                bArr8[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        public final void zzd(byte[] bArr, int i, int i2) throws IOException {
            zzo(i2);
            write(bArr, 0, i2);
        }

        public final void zzf(int i, int i2) throws IOException {
            zzb(i, 5);
            zzq(i2);
        }

        public final void zzg(String str) throws IOException {
            int i = this.position;
            try {
                int zzt = zzt(str.length() * 3);
                int zzt2 = zzt(str.length());
                if (zzt2 == zzt) {
                    this.position = i + zzt2;
                    int zza = zzff.zza(str, this.buffer, this.position, zzag());
                    this.position = i;
                    zzo((zza - i) - zzt2);
                    this.position = zza;
                    return;
                }
                zzo(zzff.zza(str));
                this.position = zzff.zza(str, this.buffer, this.position, zzag());
            } catch (zzfi e) {
                this.position = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc((Throwable) e2);
            }
        }

        public final void zzn(int i) throws IOException {
            if (i >= 0) {
                zzo(i);
            } else {
                zzb((long) i);
            }
        }

        public final void zzo(int i) throws IOException {
            if (!zzbn.zzfy || zzag() < 10) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
                }
            } else {
                while ((i & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i4 = this.position;
                    this.position = i4 + 1;
                    zzfd.zza(bArr3, (long) i4, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                zzfd.zza(bArr4, (long) i5, (byte) i);
            }
        }

        public final void zzq(int i) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr4[i5] = i >> Ascii.CAN;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }
    }

    static final class zzb extends zza {
        private final ByteBuffer zzga;
        private int zzgb;

        zzb(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.zzga = byteBuffer;
            this.zzgb = byteBuffer.position();
        }

        public final void flush() {
            this.zzga.position(this.zzgb + zzai());
        }
    }

    public static class zzc extends IOException {
        zzc() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        zzc(java.lang.String r3) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r0 = r3.length()
                java.lang.String r1 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                if (r0 == 0) goto L_0x0011
                java.lang.String r3 = r1.concat(r3)
                goto L_0x0016
            L_0x0011:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r1)
            L_0x0016:
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzbn.zzc.<init>(java.lang.String):void");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        zzc(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r0 = r3.length()
                java.lang.String r1 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                if (r0 == 0) goto L_0x0011
                java.lang.String r3 = r1.concat(r3)
                goto L_0x0016
            L_0x0011:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r1)
            L_0x0016:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzbn.zzc.<init>(java.lang.String, java.lang.Throwable):void");
        }

        zzc(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    static final class zzd extends zzbn {
        private final int zzgb;
        private final ByteBuffer zzgc;
        private final ByteBuffer zzgd;

        zzd(ByteBuffer byteBuffer) {
            super();
            this.zzgc = byteBuffer;
            this.zzgd = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.zzgb = byteBuffer.position();
        }

        private final void zzi(String str) throws IOException {
            try {
                zzff.zza(str, this.zzgd);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc((Throwable) e);
            }
        }

        public final void flush() {
            this.zzgc.position(this.zzgd.position());
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                this.zzgd.put(bArr, i, i2);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc((Throwable) e);
            } catch (BufferOverflowException e2) {
                throw new zzc((Throwable) e2);
            }
        }

        public final void zza(byte b) throws IOException {
            try {
                this.zzgd.put(b);
            } catch (BufferOverflowException e) {
                throw new zzc((Throwable) e);
            }
        }

        public final void zza(int i, long j) throws IOException {
            zzb(i, 0);
            zzb(j);
        }

        public final void zza(int i, zzbb zzbb) throws IOException {
            zzb(i, 2);
            zza(zzbb);
        }

        public final void zza(int i, zzdo zzdo) throws IOException {
            zzb(i, 2);
            zzb(zzdo);
        }

        /* access modifiers changed from: package-private */
        public final void zza(int i, zzdo zzdo, zzef zzef) throws IOException {
            zzb(i, 2);
            zza(zzdo, zzef);
        }

        public final void zza(int i, String str) throws IOException {
            zzb(i, 2);
            zzg(str);
        }

        public final void zza(zzbb zzbb) throws IOException {
            zzo(zzbb.size());
            zzbb.zza((zzba) this);
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzdo zzdo, zzef zzef) throws IOException {
            zzas zzas = (zzas) zzdo;
            int zzs = zzas.zzs();
            if (zzs == -1) {
                zzs = zzef.zzm(zzas);
                zzas.zzf(zzs);
            }
            zzo(zzs);
            zzef.zza(zzdo, this.zzfz);
        }

        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final int zzag() {
            return this.zzgd.remaining();
        }

        public final void zzb(int i, int i2) throws IOException {
            zzo((i << 3) | i2);
        }

        public final void zzb(int i, zzbb zzbb) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzbb);
            zzb(1, 4);
        }

        public final void zzb(int i, zzdo zzdo) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzdo);
            zzb(1, 4);
        }

        public final void zzb(int i, boolean z) throws IOException {
            zzb(i, 0);
            zza(z ? (byte) 1 : 0);
        }

        public final void zzb(long j) throws IOException {
            while ((-128 & j) != 0) {
                this.zzgd.put((byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            try {
                this.zzgd.put((byte) ((int) j));
            } catch (BufferOverflowException e) {
                throw new zzc((Throwable) e);
            }
        }

        public final void zzb(zzdo zzdo) throws IOException {
            zzo(zzdo.zzas());
            zzdo.zzb(this);
        }

        public final void zzc(int i, int i2) throws IOException {
            zzb(i, 0);
            zzn(i2);
        }

        public final void zzc(int i, long j) throws IOException {
            zzb(i, 1);
            zzd(j);
        }

        public final void zzd(int i, int i2) throws IOException {
            zzb(i, 0);
            zzo(i2);
        }

        public final void zzd(long j) throws IOException {
            try {
                this.zzgd.putLong(j);
            } catch (BufferOverflowException e) {
                throw new zzc((Throwable) e);
            }
        }

        public final void zzd(byte[] bArr, int i, int i2) throws IOException {
            zzo(i2);
            write(bArr, 0, i2);
        }

        public final void zzf(int i, int i2) throws IOException {
            zzb(i, 5);
            zzq(i2);
        }

        public final void zzg(String str) throws IOException {
            int position = this.zzgd.position();
            try {
                int zzt = zzt(str.length() * 3);
                int zzt2 = zzt(str.length());
                if (zzt2 == zzt) {
                    int position2 = this.zzgd.position() + zzt2;
                    this.zzgd.position(position2);
                    zzi(str);
                    int position3 = this.zzgd.position();
                    this.zzgd.position(position);
                    zzo(position3 - position2);
                    this.zzgd.position(position3);
                    return;
                }
                zzo(zzff.zza(str));
                zzi(str);
            } catch (zzfi e) {
                this.zzgd.position(position);
                zza(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzc((Throwable) e2);
            }
        }

        public final void zzn(int i) throws IOException {
            if (i >= 0) {
                zzo(i);
            } else {
                zzb((long) i);
            }
        }

        public final void zzo(int i) throws IOException {
            while ((i & -128) != 0) {
                this.zzgd.put((byte) ((i & 127) | 128));
                i >>>= 7;
            }
            try {
                this.zzgd.put((byte) i);
            } catch (BufferOverflowException e) {
                throw new zzc((Throwable) e);
            }
        }

        public final void zzq(int i) throws IOException {
            try {
                this.zzgd.putInt(i);
            } catch (BufferOverflowException e) {
                throw new zzc((Throwable) e);
            }
        }
    }

    static final class zze extends zzbn {
        private final ByteBuffer zzgc;
        private final ByteBuffer zzgd;
        private final long zzge;
        private final long zzgf;
        private final long zzgg;
        private final long zzgh = (this.zzgg - 10);
        private long zzgi = this.zzgf;

        zze(ByteBuffer byteBuffer) {
            super();
            this.zzgc = byteBuffer;
            this.zzgd = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.zzge = zzfd.zzb(byteBuffer);
            this.zzgf = this.zzge + ((long) byteBuffer.position());
            this.zzgg = this.zzge + ((long) byteBuffer.limit());
        }

        private final void zzk(long j) {
            this.zzgd.position((int) (j - this.zzge));
        }

        public final void flush() {
            this.zzgc.position((int) (this.zzgi - this.zzge));
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            if (bArr != null && i >= 0 && i2 >= 0 && bArr.length - i2 >= i) {
                long j = (long) i2;
                long j2 = this.zzgi;
                if (this.zzgg - j >= j2) {
                    zzfd.zza(bArr, (long) i, j2, j);
                    this.zzgi += j;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.zzgi), Long.valueOf(this.zzgg), Integer.valueOf(i2)}));
        }

        public final void zza(byte b) throws IOException {
            long j = this.zzgi;
            if (j < this.zzgg) {
                this.zzgi = 1 + j;
                zzfd.zza(j, b);
                return;
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(j), Long.valueOf(this.zzgg), 1}));
        }

        public final void zza(int i, long j) throws IOException {
            zzb(i, 0);
            zzb(j);
        }

        public final void zza(int i, zzbb zzbb) throws IOException {
            zzb(i, 2);
            zza(zzbb);
        }

        public final void zza(int i, zzdo zzdo) throws IOException {
            zzb(i, 2);
            zzb(zzdo);
        }

        /* access modifiers changed from: package-private */
        public final void zza(int i, zzdo zzdo, zzef zzef) throws IOException {
            zzb(i, 2);
            zza(zzdo, zzef);
        }

        public final void zza(int i, String str) throws IOException {
            zzb(i, 2);
            zzg(str);
        }

        public final void zza(zzbb zzbb) throws IOException {
            zzo(zzbb.size());
            zzbb.zza((zzba) this);
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzdo zzdo, zzef zzef) throws IOException {
            zzas zzas = (zzas) zzdo;
            int zzs = zzas.zzs();
            if (zzs == -1) {
                zzs = zzef.zzm(zzas);
                zzas.zzf(zzs);
            }
            zzo(zzs);
            zzef.zza(zzdo, this.zzfz);
        }

        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final int zzag() {
            return (int) (this.zzgg - this.zzgi);
        }

        public final void zzb(int i, int i2) throws IOException {
            zzo((i << 3) | i2);
        }

        public final void zzb(int i, zzbb zzbb) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzbb);
            zzb(1, 4);
        }

        public final void zzb(int i, zzdo zzdo) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzdo);
            zzb(1, 4);
        }

        public final void zzb(int i, boolean z) throws IOException {
            zzb(i, 0);
            zza(z ? (byte) 1 : 0);
        }

        public final void zzb(long j) throws IOException {
            long j2;
            if (this.zzgi <= this.zzgh) {
                while ((j & -128) != 0) {
                    long j3 = this.zzgi;
                    this.zzgi = j3 + 1;
                    zzfd.zza(j3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                j2 = this.zzgi;
            } else {
                while (true) {
                    j2 = this.zzgi;
                    if (j2 >= this.zzgg) {
                        throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(j2), Long.valueOf(this.zzgg), 1}));
                    } else if ((j & -128) == 0) {
                        break;
                    } else {
                        this.zzgi = j2 + 1;
                        zzfd.zza(j2, (byte) ((((int) j) & 127) | 128));
                        j >>>= 7;
                    }
                }
            }
            this.zzgi = 1 + j2;
            zzfd.zza(j2, (byte) ((int) j));
        }

        public final void zzb(zzdo zzdo) throws IOException {
            zzo(zzdo.zzas());
            zzdo.zzb(this);
        }

        public final void zzc(int i, int i2) throws IOException {
            zzb(i, 0);
            zzn(i2);
        }

        public final void zzc(int i, long j) throws IOException {
            zzb(i, 1);
            zzd(j);
        }

        public final void zzd(int i, int i2) throws IOException {
            zzb(i, 0);
            zzo(i2);
        }

        public final void zzd(long j) throws IOException {
            this.zzgd.putLong((int) (this.zzgi - this.zzge), j);
            this.zzgi += 8;
        }

        public final void zzd(byte[] bArr, int i, int i2) throws IOException {
            zzo(i2);
            write(bArr, 0, i2);
        }

        public final void zzf(int i, int i2) throws IOException {
            zzb(i, 5);
            zzq(i2);
        }

        public final void zzg(String str) throws IOException {
            long j = this.zzgi;
            try {
                int zzt = zzt(str.length() * 3);
                int zzt2 = zzt(str.length());
                if (zzt2 == zzt) {
                    int i = ((int) (this.zzgi - this.zzge)) + zzt2;
                    this.zzgd.position(i);
                    zzff.zza(str, this.zzgd);
                    int position = this.zzgd.position() - i;
                    zzo(position);
                    this.zzgi += (long) position;
                    return;
                }
                int zza = zzff.zza(str);
                zzo(zza);
                zzk(this.zzgi);
                zzff.zza(str, this.zzgd);
                this.zzgi += (long) zza;
            } catch (zzfi e) {
                this.zzgi = j;
                zzk(this.zzgi);
                zza(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzc((Throwable) e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzc((Throwable) e3);
            }
        }

        public final void zzn(int i) throws IOException {
            if (i >= 0) {
                zzo(i);
            } else {
                zzb((long) i);
            }
        }

        public final void zzo(int i) throws IOException {
            long j;
            if (this.zzgi <= this.zzgh) {
                while ((i & -128) != 0) {
                    long j2 = this.zzgi;
                    this.zzgi = j2 + 1;
                    zzfd.zza(j2, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                j = this.zzgi;
            } else {
                while (true) {
                    j = this.zzgi;
                    if (j >= this.zzgg) {
                        throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(j), Long.valueOf(this.zzgg), 1}));
                    } else if ((i & -128) == 0) {
                        break;
                    } else {
                        this.zzgi = j + 1;
                        zzfd.zza(j, (byte) ((i & 127) | 128));
                        i >>>= 7;
                    }
                }
            }
            this.zzgi = 1 + j;
            zzfd.zza(j, (byte) i);
        }

        public final void zzq(int i) throws IOException {
            this.zzgd.putInt((int) (this.zzgi - this.zzge), i);
            this.zzgi += 4;
        }
    }

    private zzbn() {
    }

    public static int zza(int i, zzcv zzcv) {
        int zzr = zzr(i);
        int zzas = zzcv.zzas();
        return zzr + zzt(zzas) + zzas;
    }

    public static int zza(zzcv zzcv) {
        int zzas = zzcv.zzas();
        return zzt(zzas) + zzas;
    }

    public static zzbn zza(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new zzb(byteBuffer);
        }
        if (byteBuffer.isDirect() && !byteBuffer.isReadOnly()) {
            return zzfd.zzee() ? new zze(byteBuffer) : new zzd(byteBuffer);
        }
        throw new IllegalArgumentException("ByteBuffer is read-only");
    }

    public static int zzb(double d) {
        return 8;
    }

    public static int zzb(float f) {
        return 4;
    }

    public static int zzb(int i, double d) {
        return zzr(i) + 8;
    }

    public static int zzb(int i, float f) {
        return zzr(i) + 4;
    }

    public static int zzb(int i, zzcv zzcv) {
        return (zzr(1) << 1) + zzh(2, i) + zza(3, zzcv);
    }

    static int zzb(int i, zzdo zzdo, zzef zzef) {
        return zzr(i) + zzb(zzdo, zzef);
    }

    public static int zzb(int i, String str) {
        return zzr(i) + zzh(str);
    }

    public static int zzb(zzbb zzbb) {
        int size = zzbb.size();
        return zzt(size) + size;
    }

    static int zzb(zzdo zzdo, zzef zzef) {
        zzas zzas = (zzas) zzdo;
        int zzs = zzas.zzs();
        if (zzs == -1) {
            zzs = zzef.zzm(zzas);
            zzas.zzf(zzs);
        }
        return zzt(zzs) + zzs;
    }

    public static int zzb(boolean z) {
        return 1;
    }

    public static int zzc(int i, zzbb zzbb) {
        int zzr = zzr(i);
        int size = zzbb.size();
        return zzr + zzt(size) + size;
    }

    public static int zzc(int i, zzdo zzdo) {
        return zzr(i) + zzc(zzdo);
    }

    @Deprecated
    static int zzc(int i, zzdo zzdo, zzef zzef) {
        int zzr = zzr(i) << 1;
        zzas zzas = (zzas) zzdo;
        int zzs = zzas.zzs();
        if (zzs == -1) {
            zzs = zzef.zzm(zzas);
            zzas.zzf(zzs);
        }
        return zzr + zzs;
    }

    public static int zzc(int i, boolean z) {
        return zzr(i) + 1;
    }

    public static int zzc(zzdo zzdo) {
        int zzas = zzdo.zzas();
        return zzt(zzas) + zzas;
    }

    public static zzbn zzc(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public static int zzd(int i, long j) {
        return zzr(i) + zzf(j);
    }

    public static int zzd(int i, zzbb zzbb) {
        return (zzr(1) << 1) + zzh(2, i) + zzc(3, zzbb);
    }

    public static int zzd(int i, zzdo zzdo) {
        return (zzr(1) << 1) + zzh(2, i) + zzc(3, zzdo);
    }

    @Deprecated
    public static int zzd(zzdo zzdo) {
        return zzdo.zzas();
    }

    public static int zzd(byte[] bArr) {
        int length = bArr.length;
        return zzt(length) + length;
    }

    public static int zze(int i, long j) {
        return zzr(i) + zzf(j);
    }

    public static int zze(long j) {
        return zzf(j);
    }

    public static int zzf(int i, long j) {
        return zzr(i) + zzf(zzj(j));
    }

    public static int zzf(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static int zzg(int i, int i2) {
        return zzr(i) + zzs(i2);
    }

    public static int zzg(int i, long j) {
        return zzr(i) + 8;
    }

    public static int zzg(long j) {
        return zzf(zzj(j));
    }

    public static int zzh(int i, int i2) {
        return zzr(i) + zzt(i2);
    }

    public static int zzh(int i, long j) {
        return zzr(i) + 8;
    }

    public static int zzh(long j) {
        return 8;
    }

    public static int zzh(String str) {
        int i;
        try {
            i = zzff.zza(str);
        } catch (zzfi unused) {
            i = str.getBytes(zzci.UTF_8).length;
        }
        return zzt(i) + i;
    }

    public static int zzi(int i, int i2) {
        return zzr(i) + zzt(zzy(i2));
    }

    public static int zzi(long j) {
        return 8;
    }

    public static int zzj(int i, int i2) {
        return zzr(i) + 4;
    }

    private static long zzj(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzk(int i, int i2) {
        return zzr(i) + 4;
    }

    public static int zzl(int i, int i2) {
        return zzr(i) + zzs(i2);
    }

    public static int zzr(int i) {
        return zzt(i << 3);
    }

    public static int zzs(int i) {
        if (i >= 0) {
            return zzt(i);
        }
        return 10;
    }

    public static int zzt(int i) {
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

    public static int zzu(int i) {
        return zzt(zzy(i));
    }

    public static int zzv(int i) {
        return 4;
    }

    public static int zzw(int i) {
        return 4;
    }

    public static int zzx(int i) {
        return zzs(i);
    }

    private static int zzy(int i) {
        return (i >> 31) ^ (i << 1);
    }

    @Deprecated
    public static int zzz(int i) {
        return zzt(i);
    }

    public abstract void flush() throws IOException;

    public abstract void write(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zza(byte b) throws IOException;

    public final void zza(double d) throws IOException {
        zzd(Double.doubleToRawLongBits(d));
    }

    public final void zza(float f) throws IOException {
        zzq(Float.floatToRawIntBits(f));
    }

    public final void zza(int i, double d) throws IOException {
        zzc(i, Double.doubleToRawLongBits(d));
    }

    public final void zza(int i, float f) throws IOException {
        zzf(i, Float.floatToRawIntBits(f));
    }

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzbb zzbb) throws IOException;

    public abstract void zza(int i, zzdo zzdo) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(int i, zzdo zzdo, zzef zzef) throws IOException;

    public abstract void zza(int i, String str) throws IOException;

    public abstract void zza(zzbb zzbb) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(zzdo zzdo, zzef zzef) throws IOException;

    /* access modifiers changed from: package-private */
    public final void zza(String str, zzfi zzfi) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzfi);
        byte[] bytes = str.getBytes(zzci.UTF_8);
        try {
            zzo(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzc((Throwable) e);
        } catch (zzc e2) {
            throw e2;
        }
    }

    public final void zza(boolean z) throws IOException {
        zza(z ? (byte) 1 : 0);
    }

    public abstract int zzag();

    public abstract void zzb(int i, int i2) throws IOException;

    public final void zzb(int i, long j) throws IOException {
        zza(i, zzj(j));
    }

    public abstract void zzb(int i, zzbb zzbb) throws IOException;

    public abstract void zzb(int i, zzdo zzdo) throws IOException;

    public abstract void zzb(int i, boolean z) throws IOException;

    public abstract void zzb(long j) throws IOException;

    public abstract void zzb(zzdo zzdo) throws IOException;

    public abstract void zzc(int i, int i2) throws IOException;

    public abstract void zzc(int i, long j) throws IOException;

    public final void zzc(long j) throws IOException {
        zzb(zzj(j));
    }

    public abstract void zzd(int i, int i2) throws IOException;

    public abstract void zzd(long j) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzd(byte[] bArr, int i, int i2) throws IOException;

    public final void zze(int i, int i2) throws IOException {
        zzd(i, zzy(i2));
    }

    public abstract void zzf(int i, int i2) throws IOException;

    public abstract void zzg(String str) throws IOException;

    public abstract void zzn(int i) throws IOException;

    public abstract void zzo(int i) throws IOException;

    public final void zzp(int i) throws IOException {
        zzo(zzy(i));
    }

    public abstract void zzq(int i) throws IOException;
}

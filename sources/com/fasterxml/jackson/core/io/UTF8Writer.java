package com.fasterxml.jackson.core.io;

import com.drew.metadata.exif.makernotes.CanonMakernoteDirectory;
import com.facebook.imageutils.JfifUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public final class UTF8Writer extends Writer {
    static final int SURR1_FIRST = 55296;
    static final int SURR1_LAST = 56319;
    static final int SURR2_FIRST = 56320;
    static final int SURR2_LAST = 57343;
    private final IOContext _context;
    private OutputStream _out;
    private byte[] _outBuffer;
    private final int _outBufferEnd = (this._outBuffer.length - 4);
    private int _outPtr = 0;
    private int _surrogate;

    public UTF8Writer(IOContext iOContext, OutputStream outputStream) {
        this._context = iOContext;
        this._out = outputStream;
        this._outBuffer = iOContext.allocWriteEncodingBuffer();
    }

    public Writer append(char c) throws IOException {
        write((int) c);
        return this;
    }

    public void close() throws IOException {
        OutputStream outputStream = this._out;
        if (outputStream != null) {
            int i = this._outPtr;
            if (i > 0) {
                outputStream.write(this._outBuffer, 0, i);
                this._outPtr = 0;
            }
            OutputStream outputStream2 = this._out;
            this._out = null;
            byte[] bArr = this._outBuffer;
            if (bArr != null) {
                this._outBuffer = null;
                this._context.releaseWriteEncodingBuffer(bArr);
            }
            outputStream2.close();
            int i2 = this._surrogate;
            this._surrogate = 0;
            if (i2 > 0) {
                illegalSurrogate(i2);
            }
        }
    }

    public void flush() throws IOException {
        OutputStream outputStream = this._out;
        if (outputStream != null) {
            int i = this._outPtr;
            if (i > 0) {
                outputStream.write(this._outBuffer, 0, i);
                this._outPtr = 0;
            }
            this._out.flush();
        }
    }

    public void write(char[] cArr) throws IOException {
        write(cArr, 0, cArr.length);
    }

    public void write(char[] cArr, int i, int i2) throws IOException {
        if (i2 >= 2) {
            if (this._surrogate > 0) {
                i2--;
                write(convertSurrogate(cArr[i]));
                i++;
            }
            int i3 = this._outPtr;
            byte[] bArr = this._outBuffer;
            int i4 = this._outBufferEnd;
            int i5 = i2 + r9;
            while (r9 < i5) {
                if (i3 >= i4) {
                    this._out.write(bArr, 0, i3);
                    i3 = 0;
                }
                int i6 = r9 + 1;
                char c = cArr[r9];
                if (c < 128) {
                    int i7 = i3 + 1;
                    bArr[i3] = (byte) c;
                    int i8 = i5 - i6;
                    int i9 = i4 - i7;
                    if (i8 > i9) {
                        i8 = i9;
                    }
                    int i10 = i8 + i6;
                    while (true) {
                        r9 = i6;
                        i3 = i7;
                        if (r9 >= i10) {
                            continue;
                            break;
                        }
                        i6 = r9 + 1;
                        c = cArr[r9];
                        if (c >= 128) {
                            break;
                        }
                        i7 = i3 + 1;
                        bArr[i3] = (byte) c;
                    }
                }
                if (c < 2048) {
                    int i11 = i3 + 1;
                    bArr[i3] = (byte) ((c >> 6) | JfifUtil.MARKER_SOFn);
                    i3 = i11 + 1;
                    bArr[i11] = (byte) ((c & '?') | 128);
                    r9 = i6;
                } else if (c < 55296 || c > 57343) {
                    int i12 = i3 + 1;
                    bArr[i3] = (byte) ((c >> 12) | CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY);
                    int i13 = i12 + 1;
                    bArr[i12] = (byte) (((c >> 6) & 63) | 128);
                    bArr[i13] = (byte) ((c & '?') | 128);
                    r9 = i6;
                    i3 = i13 + 1;
                } else {
                    if (c > 56319) {
                        this._outPtr = i3;
                        illegalSurrogate(c);
                    }
                    this._surrogate = c;
                    if (i6 >= i5) {
                        break;
                    }
                    r9 = i6 + 1;
                    int convertSurrogate = convertSurrogate(cArr[i6]);
                    if (convertSurrogate > 1114111) {
                        this._outPtr = i3;
                        illegalSurrogate(convertSurrogate);
                    }
                    int i14 = i3 + 1;
                    bArr[i3] = (byte) ((convertSurrogate >> 18) | 240);
                    int i15 = i14 + 1;
                    bArr[i14] = (byte) (((convertSurrogate >> 12) & 63) | 128);
                    int i16 = i15 + 1;
                    bArr[i15] = (byte) (((convertSurrogate >> 6) & 63) | 128);
                    i3 = i16 + 1;
                    bArr[i16] = (byte) ((convertSurrogate & 63) | 128);
                }
            }
            this._outPtr = i3;
        } else if (i2 == 1) {
            write((int) cArr[i]);
        }
    }

    public void write(int i) throws IOException {
        int i2;
        if (this._surrogate > 0) {
            i = convertSurrogate(i);
        } else if (i >= 55296 && i <= 57343) {
            if (i > 56319) {
                illegalSurrogate(i);
            }
            this._surrogate = i;
            return;
        }
        int i3 = this._outPtr;
        if (i3 >= this._outBufferEnd) {
            this._out.write(this._outBuffer, 0, i3);
            this._outPtr = 0;
        }
        if (i < 128) {
            byte[] bArr = this._outBuffer;
            int i4 = this._outPtr;
            this._outPtr = i4 + 1;
            bArr[i4] = (byte) i;
            return;
        }
        int i5 = this._outPtr;
        if (i < 2048) {
            byte[] bArr2 = this._outBuffer;
            int i6 = i5 + 1;
            bArr2[i5] = (byte) ((i >> 6) | JfifUtil.MARKER_SOFn);
            i2 = i6 + 1;
            bArr2[i6] = (byte) ((i & 63) | 128);
        } else if (i <= 65535) {
            byte[] bArr3 = this._outBuffer;
            int i7 = i5 + 1;
            bArr3[i5] = (byte) ((i >> 12) | CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY);
            int i8 = i7 + 1;
            bArr3[i7] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i8] = (byte) ((i & 63) | 128);
            i2 = i8 + 1;
        } else {
            if (i > 1114111) {
                illegalSurrogate(i);
            }
            byte[] bArr4 = this._outBuffer;
            int i9 = i5 + 1;
            bArr4[i5] = (byte) ((i >> 18) | 240);
            int i10 = i9 + 1;
            bArr4[i9] = (byte) (((i >> 12) & 63) | 128);
            int i11 = i10 + 1;
            bArr4[i10] = (byte) (((i >> 6) & 63) | 128);
            i2 = i11 + 1;
            bArr4[i11] = (byte) ((i & 63) | 128);
        }
        this._outPtr = i2;
    }

    public void write(String str) throws IOException {
        write(str, 0, str.length());
    }

    public void write(String str, int i, int i2) throws IOException {
        if (i2 >= 2) {
            if (this._surrogate > 0) {
                i2--;
                write(convertSurrogate(str.charAt(i)));
                i++;
            }
            int i3 = this._outPtr;
            byte[] bArr = this._outBuffer;
            int i4 = this._outBufferEnd;
            int i5 = i2 + r9;
            while (r9 < i5) {
                if (i3 >= i4) {
                    this._out.write(bArr, 0, i3);
                    i3 = 0;
                }
                int i6 = r9 + 1;
                char charAt = str.charAt(r9);
                if (charAt < 128) {
                    int i7 = i3 + 1;
                    bArr[i3] = (byte) charAt;
                    int i8 = i5 - i6;
                    int i9 = i4 - i7;
                    if (i8 > i9) {
                        i8 = i9;
                    }
                    int i10 = i8 + i6;
                    while (true) {
                        r9 = i6;
                        i3 = i7;
                        if (r9 >= i10) {
                            continue;
                            break;
                        }
                        i6 = r9 + 1;
                        charAt = str.charAt(r9);
                        if (charAt >= 128) {
                            break;
                        }
                        i7 = i3 + 1;
                        bArr[i3] = (byte) charAt;
                    }
                }
                if (charAt < 2048) {
                    int i11 = i3 + 1;
                    bArr[i3] = (byte) ((charAt >> 6) | JfifUtil.MARKER_SOFn);
                    i3 = i11 + 1;
                    bArr[i11] = (byte) ((charAt & '?') | 128);
                    r9 = i6;
                } else if (charAt < 55296 || charAt > 57343) {
                    int i12 = i3 + 1;
                    bArr[i3] = (byte) ((charAt >> 12) | CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY);
                    int i13 = i12 + 1;
                    bArr[i12] = (byte) (((charAt >> 6) & 63) | 128);
                    bArr[i13] = (byte) ((charAt & '?') | 128);
                    r9 = i6;
                    i3 = i13 + 1;
                } else {
                    if (charAt > 56319) {
                        this._outPtr = i3;
                        illegalSurrogate(charAt);
                    }
                    this._surrogate = charAt;
                    if (i6 >= i5) {
                        break;
                    }
                    r9 = i6 + 1;
                    int convertSurrogate = convertSurrogate(str.charAt(i6));
                    if (convertSurrogate > 1114111) {
                        this._outPtr = i3;
                        illegalSurrogate(convertSurrogate);
                    }
                    int i14 = i3 + 1;
                    bArr[i3] = (byte) ((convertSurrogate >> 18) | 240);
                    int i15 = i14 + 1;
                    bArr[i14] = (byte) (((convertSurrogate >> 12) & 63) | 128);
                    int i16 = i15 + 1;
                    bArr[i15] = (byte) (((convertSurrogate >> 6) & 63) | 128);
                    i3 = i16 + 1;
                    bArr[i16] = (byte) ((convertSurrogate & 63) | 128);
                }
            }
            this._outPtr = i3;
        } else if (i2 == 1) {
            write((int) str.charAt(i));
        }
    }

    /* access modifiers changed from: protected */
    public int convertSurrogate(int i) throws IOException {
        int i2 = this._surrogate;
        this._surrogate = 0;
        if (i >= 56320 && i <= 57343) {
            return ((i2 - 55296) << 10) + 65536 + (i - 56320);
        }
        throw new IOException("Broken surrogate pair: first char 0x" + Integer.toHexString(i2) + ", second 0x" + Integer.toHexString(i) + "; illegal combination");
    }

    protected static void illegalSurrogate(int i) throws IOException {
        throw new IOException(illegalSurrogateDesc(i));
    }

    protected static String illegalSurrogateDesc(int i) {
        if (i > 1114111) {
            return "Illegal character point (0x" + Integer.toHexString(i) + ") to output; max is 0x10FFFF as per RFC 4627";
        } else if (i < 55296) {
            return "Illegal character point (0x" + Integer.toHexString(i) + ") to output";
        } else if (i <= 56319) {
            return "Unmatched first part of surrogate pair (0x" + Integer.toHexString(i) + ")";
        } else {
            return "Unmatched second part of surrogate pair (0x" + Integer.toHexString(i) + ")";
        }
    }
}

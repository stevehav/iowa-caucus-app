package com.drew.metadata.iptc;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;

public final class Iso2022Converter {
    private static final int DOT = 14844066;
    private static final byte ESC = 27;
    private static final String ISO_8859_1 = "ISO-8859-1";
    private static final byte LATIN_CAPITAL_A = 65;
    private static final byte LATIN_CAPITAL_G = 71;
    private static final byte PERCENT_SIGN = 37;
    private static final String UTF_8 = "UTF-8";

    @Nullable
    public static String convertISO2022CharsetToJavaCharset(@NotNull byte[] bArr) {
        if (bArr.length > 2 && bArr[0] == 27 && bArr[1] == 37 && bArr[2] == 71) {
            return UTF_8;
        }
        if (bArr.length > 3 && bArr[0] == 27 && ((bArr[3] & UnsignedBytes.MAX_VALUE) | ((bArr[2] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[1] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) == DOT && bArr[4] == 65) {
            return ISO_8859_1;
        }
        return null;
    }

    @Nullable
    static Charset guessCharSet(@NotNull byte[] bArr) {
        int i = 0;
        String[] strArr = {UTF_8, System.getProperty("file.encoding"), ISO_8859_1};
        int length = strArr.length;
        while (i < length) {
            Charset forName = Charset.forName(strArr[i]);
            try {
                forName.newDecoder().decode(ByteBuffer.wrap(bArr));
                return forName;
            } catch (CharacterCodingException unused) {
                i++;
            }
        }
        return null;
    }

    private Iso2022Converter() {
    }
}

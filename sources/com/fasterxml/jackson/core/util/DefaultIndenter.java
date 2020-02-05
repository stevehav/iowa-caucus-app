package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import java.io.IOException;

public class DefaultIndenter extends DefaultPrettyPrinter.NopIndenter {
    private static final int INDENT_LEVELS = 16;
    public static final DefaultIndenter SYSTEM_LINEFEED_INSTANCE = new DefaultIndenter("  ", SYS_LF);
    public static final String SYS_LF;
    private static final long serialVersionUID = 1;
    private final int charsPerLevel;
    private final String eol;
    private final char[] indents;

    public boolean isInline() {
        return false;
    }

    static {
        String str;
        try {
            str = System.getProperty("line.separator");
        } catch (Throwable unused) {
            str = ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE;
        }
        SYS_LF = str;
    }

    public DefaultIndenter() {
        this("  ", SYS_LF);
    }

    public DefaultIndenter(String str, String str2) {
        this.charsPerLevel = str.length();
        this.indents = new char[(str.length() * 16)];
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            str.getChars(0, str.length(), this.indents, i);
            i += str.length();
        }
        this.eol = str2;
    }

    public DefaultIndenter withLinefeed(String str) {
        if (str.equals(this.eol)) {
            return this;
        }
        return new DefaultIndenter(getIndent(), str);
    }

    public DefaultIndenter withIndent(String str) {
        if (str.equals(getIndent())) {
            return this;
        }
        return new DefaultIndenter(str, this.eol);
    }

    public void writeIndentation(JsonGenerator jsonGenerator, int i) throws IOException {
        jsonGenerator.writeRaw(this.eol);
        if (i > 0) {
            int i2 = i * this.charsPerLevel;
            while (true) {
                char[] cArr = this.indents;
                if (i2 > cArr.length) {
                    jsonGenerator.writeRaw(cArr, 0, cArr.length);
                    i2 -= this.indents.length;
                } else {
                    jsonGenerator.writeRaw(cArr, 0, i2);
                    return;
                }
            }
        }
    }

    public String getEol() {
        return this.eol;
    }

    public String getIndent() {
        return new String(this.indents, 0, this.charsPerLevel);
    }
}

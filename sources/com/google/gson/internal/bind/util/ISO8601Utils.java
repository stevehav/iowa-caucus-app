package com.google.gson.internal.bind.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class ISO8601Utils {
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);
    private static final String UTC_ID = "UTC";

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z) {
        return format(date, z, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(19 + (z ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        padInt(sb, gregorianCalendar.get(1), 4);
        char c = '-';
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), 2);
        if (z) {
            sb.append('.');
            padInt(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i = offset / 60000;
            int abs = Math.abs(i / 60);
            int abs2 = Math.abs(i % 60);
            if (offset >= 0) {
                c = '+';
            }
            sb.append(c);
            padInt(sb, abs, 2);
            sb.append(':');
            padInt(sb, abs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cc A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01b3 A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bb }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Date parse(java.lang.String r18, java.text.ParsePosition r19) throws java.text.ParseException {
        /*
            r1 = r18
            r2 = r19
            java.lang.String r3 = "'"
            int r0 = r19.getIndex()     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            int r4 = r0 + 4
            int r0 = parseInt(r1, r0, r4)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r5 = 45
            boolean r6 = checkOffset(r1, r4, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            if (r6 == 0) goto L_0x001a
            int r4 = r4 + 1
        L_0x001a:
            int r6 = r4 + 2
            int r4 = parseInt(r1, r4, r6)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            boolean r7 = checkOffset(r1, r6, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            if (r7 == 0) goto L_0x0028
            int r6 = r6 + 1
        L_0x0028:
            int r7 = r6 + 2
            int r6 = parseInt(r1, r6, r7)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r8 = 84
            boolean r8 = checkOffset(r1, r7, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r9 = 1
            if (r8 != 0) goto L_0x004b
            int r10 = r18.length()     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            if (r10 > r7) goto L_0x004b
            java.util.GregorianCalendar r5 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            int r4 = r4 - r9
            r5.<init>(r0, r4, r6)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r2.setIndex(r7)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            java.util.Date r0 = r5.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            return r0
        L_0x004b:
            r10 = 43
            r11 = 90
            r13 = 2
            if (r8 == 0) goto L_0x00c1
            int r7 = r7 + 1
            int r8 = r7 + 2
            int r7 = parseInt(r1, r7, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r14 = 58
            boolean r15 = checkOffset(r1, r8, r14)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            if (r15 == 0) goto L_0x0064
            int r8 = r8 + 1
        L_0x0064:
            int r15 = r8 + 2
            int r8 = parseInt(r1, r8, r15)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            boolean r14 = checkOffset(r1, r15, r14)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            if (r14 == 0) goto L_0x0072
            int r15 = r15 + 1
        L_0x0072:
            int r14 = r18.length()     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            if (r14 <= r15) goto L_0x00bf
            char r14 = r1.charAt(r15)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            if (r14 == r11) goto L_0x00bf
            if (r14 == r10) goto L_0x00bf
            if (r14 == r5) goto L_0x00bf
            int r14 = r15 + 2
            int r15 = parseInt(r1, r15, r14)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r12 = 59
            if (r15 <= r12) goto L_0x0093
            r12 = 63
            if (r15 >= r12) goto L_0x0093
            r12 = 59
            goto L_0x0094
        L_0x0093:
            r12 = r15
        L_0x0094:
            r15 = 46
            boolean r15 = checkOffset(r1, r14, r15)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            if (r15 == 0) goto L_0x00bc
            int r14 = r14 + 1
            int r15 = r14 + 1
            int r15 = indexOfNonDigit(r1, r15)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            int r5 = r14 + 3
            int r5 = java.lang.Math.min(r15, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            int r17 = parseInt(r1, r14, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            int r5 = r5 - r14
            if (r5 == r9) goto L_0x00b7
            if (r5 == r13) goto L_0x00b4
            goto L_0x00b9
        L_0x00b4:
            int r17 = r17 * 10
            goto L_0x00b9
        L_0x00b7:
            int r17 = r17 * 100
        L_0x00b9:
            r5 = r17
            goto L_0x00c6
        L_0x00bc:
            r15 = r14
            r5 = 0
            goto L_0x00c6
        L_0x00bf:
            r5 = 0
            goto L_0x00c5
        L_0x00c1:
            r15 = r7
            r5 = 0
            r7 = 0
            r8 = 0
        L_0x00c5:
            r12 = 0
        L_0x00c6:
            int r14 = r18.length()     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            if (r14 <= r15) goto L_0x01b3
            char r14 = r1.charAt(r15)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r13 = 5
            if (r14 != r11) goto L_0x00d8
            java.util.TimeZone r10 = TIMEZONE_UTC     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            int r15 = r15 + r9
            goto L_0x0181
        L_0x00d8:
            if (r14 == r10) goto L_0x00f9
            r10 = 45
            if (r14 != r10) goto L_0x00df
            goto L_0x00f9
        L_0x00df:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r4.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            java.lang.String r5 = "Invalid time zone indicator '"
            r4.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r4.append(r14)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r4.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            java.lang.String r4 = r4.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r0.<init>(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
        L_0x00f9:
            java.lang.String r10 = r1.substring(r15)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            int r11 = r10.length()     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            if (r11 < r13) goto L_0x0104
            goto L_0x0115
        L_0x0104:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r11.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r11.append(r10)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            java.lang.String r10 = "00"
            r11.append(r10)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            java.lang.String r10 = r11.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
        L_0x0115:
            int r11 = r10.length()     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            int r15 = r15 + r11
            java.lang.String r11 = "+0000"
            boolean r11 = r11.equals(r10)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            if (r11 != 0) goto L_0x017e
            java.lang.String r11 = "+00:00"
            boolean r11 = r11.equals(r10)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            if (r11 == 0) goto L_0x012b
            goto L_0x017e
        L_0x012b:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r11.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            java.lang.String r14 = "GMT"
            r11.append(r14)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r11.append(r10)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            java.lang.String r10 = r11.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            java.util.TimeZone r11 = java.util.TimeZone.getTimeZone(r10)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            java.lang.String r14 = r11.getID()     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            boolean r16 = r14.equals(r10)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            if (r16 != 0) goto L_0x017c
            java.lang.String r13 = ":"
            java.lang.String r9 = ""
            java.lang.String r9 = r14.replace(r13, r9)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            boolean r9 = r9.equals(r10)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            if (r9 == 0) goto L_0x0159
            goto L_0x017c
        L_0x0159:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r4.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            java.lang.String r5 = "Mismatching time zone indicator: "
            r4.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r4.append(r10)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            java.lang.String r5 = " given, resolves to "
            r4.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            java.lang.String r5 = r11.getID()     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r4.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            java.lang.String r4 = r4.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r0.<init>(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
        L_0x017c:
            r10 = r11
            goto L_0x0181
        L_0x017e:
            java.util.TimeZone r9 = TIMEZONE_UTC     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r10 = r9
        L_0x0181:
            java.util.GregorianCalendar r9 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r9.<init>(r10)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r10 = 0
            r9.setLenient(r10)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r10 = 1
            r9.set(r10, r0)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            int r4 = r4 - r10
            r0 = 2
            r9.set(r0, r4)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r0 = 5
            r9.set(r0, r6)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r0 = 11
            r9.set(r0, r7)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r0 = 12
            r9.set(r0, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r0 = 13
            r9.set(r0, r12)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r0 = 14
            r9.set(r0, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            r2.setIndex(r15)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            java.util.Date r0 = r9.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            return r0
        L_0x01b3:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            java.lang.String r4 = "No time zone indicator"
            r0.<init>(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01bf, NumberFormatException -> 0x01bd, IllegalArgumentException -> 0x01bb }
        L_0x01bb:
            r0 = move-exception
            goto L_0x01c0
        L_0x01bd:
            r0 = move-exception
            goto L_0x01c0
        L_0x01bf:
            r0 = move-exception
        L_0x01c0:
            if (r1 != 0) goto L_0x01c4
            r1 = 0
            goto L_0x01d8
        L_0x01c4:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r5 = 34
            r4.append(r5)
            r4.append(r1)
            r4.append(r3)
            java.lang.String r1 = r4.toString()
        L_0x01d8:
            java.lang.String r3 = r0.getMessage()
            if (r3 == 0) goto L_0x01e4
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x0202
        L_0x01e4:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "("
            r3.append(r4)
            java.lang.Class r4 = r0.getClass()
            java.lang.String r4 = r4.getName()
            r3.append(r4)
            java.lang.String r4 = ")"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
        L_0x0202:
            java.text.ParseException r4 = new java.text.ParseException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Failed to parse date ["
            r5.append(r6)
            r5.append(r1)
            java.lang.String r1 = "]: "
            r5.append(r1)
            r5.append(r3)
            java.lang.String r1 = r5.toString()
            int r2 = r19.getIndex()
            r4.<init>(r1, r2)
            r4.initCause(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.util.ISO8601Utils.parse(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static boolean checkOffset(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    private static int parseInt(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit >= 0) {
                i3 = -digit;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
        } else {
            i4 = i;
            i3 = 0;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 >= 0) {
                i3 = (i3 * 10) - digit2;
                i4 = i5;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
        }
        return -i3;
    }

    private static void padInt(StringBuilder sb, int i, int i2) {
        String num = Integer.toString(i);
        for (int length = i2 - num.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(num);
    }

    private static int indexOfNonDigit(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }
}

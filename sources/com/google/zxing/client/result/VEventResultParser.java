package com.google.zxing.client.result;

import java.util.List;

public final class VEventResultParser extends ResultParser {
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.client.result.CalendarParsedResult parse(com.google.zxing.Result r18) {
        /*
            r17 = this;
            java.lang.String r0 = getMassagedText(r18)
            java.lang.String r1 = "BEGIN:VEVENT"
            int r1 = r0.indexOf(r1)
            r2 = 0
            if (r1 >= 0) goto L_0x000e
            return r2
        L_0x000e:
            r1 = 1
            java.lang.String r3 = "SUMMARY"
            java.lang.String r5 = matchSingleVCardPrefixedField(r3, r0, r1)
            java.lang.String r3 = "DTSTART"
            java.lang.String r6 = matchSingleVCardPrefixedField(r3, r0, r1)
            if (r6 != 0) goto L_0x001e
            return r2
        L_0x001e:
            java.lang.String r3 = "DTEND"
            java.lang.String r7 = matchSingleVCardPrefixedField(r3, r0, r1)
            java.lang.String r3 = "DURATION"
            java.lang.String r8 = matchSingleVCardPrefixedField(r3, r0, r1)
            java.lang.String r3 = "LOCATION"
            java.lang.String r9 = matchSingleVCardPrefixedField(r3, r0, r1)
            java.lang.String r3 = "ORGANIZER"
            java.lang.String r3 = matchSingleVCardPrefixedField(r3, r0, r1)
            java.lang.String r10 = stripMailto(r3)
            java.lang.String r3 = "ATTENDEE"
            java.lang.String[] r11 = matchVCardPrefixedField(r3, r0, r1)
            r3 = 0
            if (r11 == 0) goto L_0x0052
            r4 = 0
        L_0x0044:
            int r12 = r11.length
            if (r4 >= r12) goto L_0x0052
            r12 = r11[r4]
            java.lang.String r12 = stripMailto(r12)
            r11[r4] = r12
            int r4 = r4 + 1
            goto L_0x0044
        L_0x0052:
            java.lang.String r4 = "DESCRIPTION"
            java.lang.String r12 = matchSingleVCardPrefixedField(r4, r0, r1)
            java.lang.String r4 = "GEO"
            java.lang.String r0 = matchSingleVCardPrefixedField(r4, r0, r1)
            r13 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            if (r0 != 0) goto L_0x0064
            r15 = r13
            goto L_0x007f
        L_0x0064:
            r4 = 59
            int r4 = r0.indexOf(r4)
            if (r4 >= 0) goto L_0x006d
            return r2
        L_0x006d:
            java.lang.String r3 = r0.substring(r3, r4)     // Catch:{ NumberFormatException -> 0x0086 }
            double r13 = java.lang.Double.parseDouble(r3)     // Catch:{ NumberFormatException -> 0x0086 }
            int r4 = r4 + r1
            java.lang.String r0 = r0.substring(r4)     // Catch:{ NumberFormatException -> 0x0086 }
            double r0 = java.lang.Double.parseDouble(r0)     // Catch:{ NumberFormatException -> 0x0086 }
            r15 = r0
        L_0x007f:
            com.google.zxing.client.result.CalendarParsedResult r0 = new com.google.zxing.client.result.CalendarParsedResult     // Catch:{  }
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r15)     // Catch:{  }
            return r0
        L_0x0086:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.result.VEventResultParser.parse(com.google.zxing.Result):com.google.zxing.client.result.CalendarParsedResult");
    }

    private static String matchSingleVCardPrefixedField(CharSequence charSequence, String str, boolean z) {
        List<String> matchSingleVCardPrefixedField = VCardResultParser.matchSingleVCardPrefixedField(charSequence, str, z, false);
        if (matchSingleVCardPrefixedField == null || matchSingleVCardPrefixedField.isEmpty()) {
            return null;
        }
        return matchSingleVCardPrefixedField.get(0);
    }

    private static String[] matchVCardPrefixedField(CharSequence charSequence, String str, boolean z) {
        List<List<String>> matchVCardPrefixedField = VCardResultParser.matchVCardPrefixedField(charSequence, str, z, false);
        if (matchVCardPrefixedField == null || matchVCardPrefixedField.isEmpty()) {
            return null;
        }
        int size = matchVCardPrefixedField.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = (String) matchVCardPrefixedField.get(i).get(0);
        }
        return strArr;
    }

    private static String stripMailto(String str) {
        if (str != null) {
            return (str.startsWith("mailto:") || str.startsWith("MAILTO:")) ? str.substring(7) : str;
        }
        return str;
    }
}

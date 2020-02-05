package io.invertase.firebase.firestore;

import com.google.firebase.firestore.FirebaseFirestoreException;

public class UniversalFirebaseFirestoreException extends Exception {
    private final String code;
    private final String message;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0066, code lost:
        if (r2.equals("ALREADY_EXISTS") != false) goto L_0x0102;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    UniversalFirebaseFirestoreException(com.google.firebase.firestore.FirebaseFirestoreException r7, java.lang.Throwable r8) {
        /*
            r6 = this;
            if (r7 == 0) goto L_0x0007
            java.lang.String r7 = r7.getMessage()
            goto L_0x0009
        L_0x0007:
            java.lang.String r7 = ""
        L_0x0009:
            r6.<init>(r7, r8)
            java.lang.String r7 = "unknown"
            java.lang.String r0 = "failed-precondition"
            if (r8 == 0) goto L_0x015c
            java.lang.String r1 = r8.getMessage()
            if (r1 == 0) goto L_0x015c
            java.lang.String r1 = r8.getMessage()
            java.lang.String r2 = ":"
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L_0x015c
            java.lang.String r8 = r8.getMessage()
            java.lang.String r1 = "([A-Z_]{3,25}):\\s(.*)"
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1)
            java.util.regex.Matcher r8 = r1.matcher(r8)
            boolean r1 = r8.find()
            if (r1 == 0) goto L_0x015c
            r1 = 1
            java.lang.String r2 = r8.group(r1)
            java.lang.String r2 = r2.trim()
            r3 = 2
            java.lang.String r8 = r8.group(r3)
            java.lang.String r8 = r8.trim()
            r4 = -1
            int r5 = r2.hashCode()
            switch(r5) {
                case -1842427240: goto L_0x00f7;
                case -1711692763: goto L_0x00ed;
                case -1416305653: goto L_0x00e2;
                case -1031784143: goto L_0x00d8;
                case -1025686472: goto L_0x00cd;
                case -849706474: goto L_0x00c2;
                case -476794961: goto L_0x00b8;
                case -376214182: goto L_0x00ae;
                case 433141802: goto L_0x00a3;
                case 695165606: goto L_0x0098;
                case 979228314: goto L_0x008d;
                case 1023286998: goto L_0x0081;
                case 1353037501: goto L_0x0076;
                case 1487498288: goto L_0x006a;
                case 1661336131: goto L_0x0060;
                case 1854913705: goto L_0x0054;
                default: goto L_0x0052;
            }
        L_0x0052:
            goto L_0x0101
        L_0x0054:
            java.lang.String r1 = "UNIMPLEMENTED"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0101
            r1 = 14
            goto L_0x0102
        L_0x0060:
            java.lang.String r3 = "ALREADY_EXISTS"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0101
            goto L_0x0102
        L_0x006a:
            java.lang.String r1 = "UNAVAILABLE"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0101
            r1 = 13
            goto L_0x0102
        L_0x0076:
            java.lang.String r1 = "INTERNAL"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0101
            r1 = 6
            goto L_0x0102
        L_0x0081:
            java.lang.String r1 = "NOT_FOUND"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0101
            r1 = 8
            goto L_0x0102
        L_0x008d:
            java.lang.String r1 = "FAILED_PRECONDITION"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0101
            r1 = 5
            goto L_0x0102
        L_0x0098:
            java.lang.String r1 = "OUT_OF_RANGE"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0101
            r1 = 9
            goto L_0x0102
        L_0x00a3:
            java.lang.String r1 = "UNKNOWN"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0101
            r1 = 15
            goto L_0x0102
        L_0x00ae:
            java.lang.String r1 = "DEADLINE_EXCEEDED"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0101
            r1 = 4
            goto L_0x0102
        L_0x00b8:
            java.lang.String r1 = "ABORTED"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0101
            r1 = 0
            goto L_0x0102
        L_0x00c2:
            java.lang.String r1 = "UNAUTHENTICATED"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0101
            r1 = 12
            goto L_0x0102
        L_0x00cd:
            java.lang.String r1 = "RESOURCE_EXHAUSTED"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0101
            r1 = 11
            goto L_0x0102
        L_0x00d8:
            java.lang.String r1 = "CANCELLED"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0101
            r1 = 2
            goto L_0x0102
        L_0x00e2:
            java.lang.String r1 = "PERMISSION_DENIED"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0101
            r1 = 10
            goto L_0x0102
        L_0x00ed:
            java.lang.String r1 = "INVALID_ARGUMENT"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0101
            r1 = 7
            goto L_0x0102
        L_0x00f7:
            java.lang.String r1 = "DATA_LOSS"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0101
            r1 = 3
            goto L_0x0102
        L_0x0101:
            r1 = -1
        L_0x0102:
            switch(r1) {
                case 0: goto L_0x0157;
                case 1: goto L_0x0152;
                case 2: goto L_0x014d;
                case 3: goto L_0x0148;
                case 4: goto L_0x0143;
                case 5: goto L_0x0136;
                case 6: goto L_0x0131;
                case 7: goto L_0x012c;
                case 8: goto L_0x0127;
                case 9: goto L_0x0122;
                case 10: goto L_0x011d;
                case 11: goto L_0x0118;
                case 12: goto L_0x0113;
                case 13: goto L_0x010e;
                case 14: goto L_0x0109;
                case 15: goto L_0x0106;
                default: goto L_0x0105;
            }
        L_0x0105:
            goto L_0x015c
        L_0x0106:
            java.lang.String r8 = "Unknown error or an error from a different error domain."
            goto L_0x015e
        L_0x0109:
            java.lang.String r7 = "unimplemented"
            java.lang.String r8 = "Operation is not implemented or not supported/enabled."
            goto L_0x015e
        L_0x010e:
            java.lang.String r7 = "unavailable"
            java.lang.String r8 = "The service is currently unavailable. This is a most likely a transient condition and may be corrected by retrying with a backoff."
            goto L_0x015e
        L_0x0113:
            java.lang.String r7 = "unauthenticated"
            java.lang.String r8 = "The request does not have valid authentication credentials for the operation."
            goto L_0x015e
        L_0x0118:
            java.lang.String r7 = "resource-exhausted"
            java.lang.String r8 = "Some resource has been exhausted, perhaps a per-user quota, or perhaps the entire file system is out of space."
            goto L_0x015e
        L_0x011d:
            java.lang.String r7 = "permission-denied"
            java.lang.String r8 = "The caller does not have permission to execute the specified operation."
            goto L_0x015e
        L_0x0122:
            java.lang.String r7 = "out-of-range"
            java.lang.String r8 = "Operation was attempted past the valid range."
            goto L_0x015e
        L_0x0127:
            java.lang.String r7 = "not-found"
            java.lang.String r8 = "Some requested document was not found."
            goto L_0x015e
        L_0x012c:
            java.lang.String r7 = "invalid-argument"
            java.lang.String r8 = "Client specified an invalid argument. Note that this differs from failed-precondition. invalid-argument indicates arguments that are problematic regardless of the state of the system (e.g., an invalid field name)."
            goto L_0x015e
        L_0x0131:
            java.lang.String r7 = "internal"
            java.lang.String r8 = "Internal errors. Means some invariants expected by underlying system has been broken. If you see one of these errors, something is very broken."
            goto L_0x015e
        L_0x0136:
            java.lang.String r7 = "query requires an index"
            boolean r7 = r8.contains(r7)
            if (r7 == 0) goto L_0x013f
            goto L_0x0141
        L_0x013f:
            java.lang.String r8 = "Operation was rejected because the system is not in a state required for the operation's execution. Ensure your query has been indexed via the Firebase console."
        L_0x0141:
            r7 = r0
            goto L_0x015e
        L_0x0143:
            java.lang.String r7 = "deadline-exceeded"
            java.lang.String r8 = "Deadline expired before operation could complete. For operations that change the state of the system, this error may be returned even if the operation has completed successfully. For example, a successful response from a server could have been delayed long enough for the deadline to expire."
            goto L_0x015e
        L_0x0148:
            java.lang.String r7 = "data-loss"
            java.lang.String r8 = "Unrecoverable data loss or corruption."
            goto L_0x015e
        L_0x014d:
            java.lang.String r7 = "cancelled"
            java.lang.String r8 = "The operation was cancelled (typically by the caller)."
            goto L_0x015e
        L_0x0152:
            java.lang.String r7 = "already-exists"
            java.lang.String r8 = "Some document that we attempted to create already exists."
            goto L_0x015e
        L_0x0157:
            java.lang.String r7 = "aborted"
            java.lang.String r8 = "The operation was aborted, typically due to a concurrency issue like transaction aborts, etc."
            goto L_0x015e
        L_0x015c:
            java.lang.String r8 = "An unknown error occurred"
        L_0x015e:
            r6.code = r7
            r6.message = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.firestore.UniversalFirebaseFirestoreException.<init>(com.google.firebase.firestore.FirebaseFirestoreException, java.lang.Throwable):void");
    }

    /* renamed from: io.invertase.firebase.firestore.UniversalFirebaseFirestoreException$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code = new int[FirebaseFirestoreException.Code.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.google.firebase.firestore.FirebaseFirestoreException$Code[] r0 = com.google.firebase.firestore.FirebaseFirestoreException.Code.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code = r0
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.ABORTED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.ALREADY_EXISTS     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.CANCELLED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.DATA_LOSS     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.DEADLINE_EXCEEDED     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x004b }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.FAILED_PRECONDITION     // Catch:{ NoSuchFieldError -> 0x004b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x0056 }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.INTERNAL     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.INVALID_ARGUMENT     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x006e }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.NOT_FOUND     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x007a }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.OUT_OF_RANGE     // Catch:{ NoSuchFieldError -> 0x007a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007a }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007a }
            L_0x007a:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x0086 }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.PERMISSION_DENIED     // Catch:{ NoSuchFieldError -> 0x0086 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0086 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0086 }
            L_0x0086:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x0092 }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.RESOURCE_EXHAUSTED     // Catch:{ NoSuchFieldError -> 0x0092 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0092 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0092 }
            L_0x0092:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x009e }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.UNAUTHENTICATED     // Catch:{ NoSuchFieldError -> 0x009e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009e }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009e }
            L_0x009e:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x00aa }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.UNAVAILABLE     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x00b6 }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.UNIMPLEMENTED     // Catch:{ NoSuchFieldError -> 0x00b6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b6 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b6 }
            L_0x00b6:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x00c2 }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x00c2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c2 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c2 }
            L_0x00c2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.firestore.UniversalFirebaseFirestoreException.AnonymousClass1.<clinit>():void");
        }
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}

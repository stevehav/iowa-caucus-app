package com.facebook.react.modules.systeminfo;

import android.content.Context;
import android.os.Build;
import com.facebook.react.R;
import java.util.Locale;

public class AndroidInfoHelpers {
    public static final String DEVICE_LOCALHOST = "localhost";
    public static final String EMULATOR_LOCALHOST = "10.0.2.2";
    public static final String GENYMOTION_LOCALHOST = "10.0.3.2";
    public static final String METRO_HOST_PROP_NAME = "metro.host";
    private static final String TAG = "AndroidInfoHelpers";
    private static String metroHostPropValue;

    private static boolean isRunningOnGenymotion() {
        return Build.FINGERPRINT.contains("vbox");
    }

    private static boolean isRunningOnStockEmulator() {
        return Build.FINGERPRINT.contains("generic");
    }

    public static String getServerHost(Integer num) {
        return getServerIpAddress(num.intValue());
    }

    public static String getServerHost(Context context) {
        return getServerIpAddress(getDevServerPort(context).intValue());
    }

    public static String getAdbReverseTcpCommand(Integer num) {
        return "adb reverse tcp:" + num + " tcp:" + num;
    }

    public static String getAdbReverseTcpCommand(Context context) {
        return getAdbReverseTcpCommand(getDevServerPort(context));
    }

    public static String getInspectorProxyHost(Context context) {
        return getServerIpAddress(getInspectorProxyPort(context).intValue());
    }

    public static String getFriendlyDeviceName() {
        if (isRunningOnGenymotion()) {
            return Build.MODEL;
        }
        return Build.MODEL + " - " + Build.VERSION.RELEASE + " - API " + Build.VERSION.SDK_INT;
    }

    private static Integer getDevServerPort(Context context) {
        return Integer.valueOf(context.getResources().getInteger(R.integer.react_native_dev_server_port));
    }

    private static Integer getInspectorProxyPort(Context context) {
        return Integer.valueOf(context.getResources().getInteger(R.integer.react_native_dev_server_port));
    }

    private static String getServerIpAddress(int i) {
        String metroHostPropValue2 = getMetroHostPropValue();
        if (metroHostPropValue2.equals("")) {
            if (isRunningOnGenymotion()) {
                metroHostPropValue2 = GENYMOTION_LOCALHOST;
            } else {
                metroHostPropValue2 = isRunningOnStockEmulator() ? EMULATOR_LOCALHOST : DEVICE_LOCALHOST;
            }
        }
        return String.format(Locale.US, "%s:%d", new Object[]{metroHostPropValue2, Integer.valueOf(i)});
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0072 A[SYNTHETIC, Splitter:B:40:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0077 A[SYNTHETIC, Splitter:B:44:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0081 A[SYNTHETIC, Splitter:B:51:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0086 A[SYNTHETIC, Splitter:B:55:0x0086] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized java.lang.String getMetroHostPropValue() {
        /*
            java.lang.Class<com.facebook.react.modules.systeminfo.AndroidInfoHelpers> r0 = com.facebook.react.modules.systeminfo.AndroidInfoHelpers.class
            monitor-enter(r0)
            java.lang.String r1 = metroHostPropValue     // Catch:{ all -> 0x008a }
            if (r1 == 0) goto L_0x000b
            java.lang.String r1 = metroHostPropValue     // Catch:{ all -> 0x008a }
            monitor-exit(r0)
            return r1
        L_0x000b:
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            r4 = 0
            java.lang.String r5 = "/system/bin/getprop"
            r3[r4] = r5     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            r4 = 1
            java.lang.String r5 = "metro.host"
            r3[r4] = r5     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            java.lang.Process r2 = r2.exec(r3)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x005b, all -> 0x0056 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x005b, all -> 0x0056 }
            java.io.InputStream r5 = r2.getInputStream()     // Catch:{ Exception -> 0x005b, all -> 0x0056 }
            java.lang.String r6 = "UTF-8"
            java.nio.charset.Charset r6 = java.nio.charset.Charset.forName(r6)     // Catch:{ Exception -> 0x005b, all -> 0x0056 }
            r4.<init>(r5, r6)     // Catch:{ Exception -> 0x005b, all -> 0x0056 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x005b, all -> 0x0056 }
            java.lang.String r1 = ""
        L_0x0037:
            java.lang.String r4 = r3.readLine()     // Catch:{ Exception -> 0x0050, all -> 0x004a }
            if (r4 == 0) goto L_0x003f
            r1 = r4
            goto L_0x0037
        L_0x003f:
            metroHostPropValue = r1     // Catch:{ Exception -> 0x0050, all -> 0x004a }
            r3.close()     // Catch:{ Exception -> 0x0044 }
        L_0x0044:
            if (r2 == 0) goto L_0x007a
            r2.destroy()     // Catch:{ all -> 0x008a }
            goto L_0x007a
        L_0x004a:
            r1 = move-exception
            r7 = r2
            r2 = r1
            r1 = r3
            r3 = r7
            goto L_0x007f
        L_0x0050:
            r1 = move-exception
            r7 = r2
            r2 = r1
            r1 = r3
            r3 = r7
            goto L_0x0065
        L_0x0056:
            r3 = move-exception
            r7 = r3
            r3 = r2
            r2 = r7
            goto L_0x007f
        L_0x005b:
            r3 = move-exception
            r7 = r3
            r3 = r2
            r2 = r7
            goto L_0x0065
        L_0x0060:
            r2 = move-exception
            r3 = r1
            goto L_0x007f
        L_0x0063:
            r2 = move-exception
            r3 = r1
        L_0x0065:
            java.lang.String r4 = TAG     // Catch:{ all -> 0x007e }
            java.lang.String r5 = "Failed to query for metro.host prop:"
            com.facebook.common.logging.FLog.w((java.lang.String) r4, (java.lang.String) r5, (java.lang.Throwable) r2)     // Catch:{ all -> 0x007e }
            java.lang.String r2 = ""
            metroHostPropValue = r2     // Catch:{ all -> 0x007e }
            if (r1 == 0) goto L_0x0075
            r1.close()     // Catch:{ Exception -> 0x0075 }
        L_0x0075:
            if (r3 == 0) goto L_0x007a
            r3.destroy()     // Catch:{ all -> 0x008a }
        L_0x007a:
            java.lang.String r1 = metroHostPropValue     // Catch:{ all -> 0x008a }
            monitor-exit(r0)
            return r1
        L_0x007e:
            r2 = move-exception
        L_0x007f:
            if (r1 == 0) goto L_0x0084
            r1.close()     // Catch:{ Exception -> 0x0084 }
        L_0x0084:
            if (r3 == 0) goto L_0x0089
            r3.destroy()     // Catch:{ all -> 0x008a }
        L_0x0089:
            throw r2     // Catch:{ all -> 0x008a }
        L_0x008a:
            r1 = move-exception
            monitor-exit(r0)
            goto L_0x008e
        L_0x008d:
            throw r1
        L_0x008e:
            goto L_0x008d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.systeminfo.AndroidInfoHelpers.getMetroHostPropValue():java.lang.String");
    }
}

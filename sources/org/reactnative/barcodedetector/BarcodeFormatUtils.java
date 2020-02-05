package org.reactnative.barcodedetector;

import android.util.SparseArray;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BarcodeFormatUtils {
    public static final SparseArray<String> FORMATS;
    public static final Map<String, Integer> REVERSE_FORMATS;
    private static final int UNKNOWN_FORMAT_INT = -1;
    private static final String UNKNOWN_FORMAT_STRING = "UNKNOWN_FORMAT";

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        sparseArray.put(1, "CODE_128");
        sparseArray.put(2, "CODE_39");
        sparseArray.put(4, "CODE_93");
        sparseArray.put(8, "CODABAR");
        sparseArray.put(16, "DATA_MATRIX");
        sparseArray.put(32, "EAN_13");
        sparseArray.put(64, "EAN_8");
        sparseArray.put(128, "ITF");
        sparseArray.put(256, "QR_CODE");
        sparseArray.put(512, "UPC_A");
        sparseArray.put(1024, "UPC_E");
        sparseArray.put(2048, "PDF417");
        sparseArray.put(4096, "AZTEC");
        sparseArray.put(0, "ALL");
        sparseArray.put(11, "CALENDAR_EVENT");
        sparseArray.put(1, "CONTACT_INFO");
        sparseArray.put(12, "DRIVER_LICENSE");
        sparseArray.put(2, "EMAIL");
        sparseArray.put(10, "GEO");
        sparseArray.put(3, "ISBN");
        sparseArray.put(4, "PHONE");
        sparseArray.put(5, "PRODUCT");
        sparseArray.put(6, "SMS");
        sparseArray.put(7, "TEXT");
        sparseArray.put(512, "UPC_A");
        sparseArray.put(8, "URL");
        sparseArray.put(9, "WIFI");
        sparseArray.put(-1, "None");
        FORMATS = sparseArray;
        HashMap hashMap = new HashMap();
        for (int i = 0; i < sparseArray.size(); i++) {
            hashMap.put(sparseArray.valueAt(i), Integer.valueOf(sparseArray.keyAt(i)));
        }
        REVERSE_FORMATS = Collections.unmodifiableMap(hashMap);
    }

    public static String get(int i) {
        return FORMATS.get(i, UNKNOWN_FORMAT_STRING);
    }

    public static int get(String str) {
        if (REVERSE_FORMATS.containsKey(str)) {
            return REVERSE_FORMATS.get(str).intValue();
        }
        return -1;
    }
}

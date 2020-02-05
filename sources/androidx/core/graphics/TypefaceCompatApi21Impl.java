package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class TypefaceCompatApi21Impl extends TypefaceCompatBaseImpl {
    private static final String ADD_FONT_WEIGHT_STYLE_METHOD = "addFontWeightStyle";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String TAG = "TypefaceCompatApi21Impl";
    private static Method sAddFontWeightStyle = null;
    private static Method sCreateFromFamiliesWithDefault = null;
    private static Class<?> sFontFamily = null;
    private static Constructor<?> sFontFamilyCtor = null;
    private static boolean sHasInitBeenCalled = false;

    TypefaceCompatApi21Impl() {
    }

    private static void init() {
        Method method;
        Class<?> cls;
        Method method2;
        if (!sHasInitBeenCalled) {
            sHasInitBeenCalled = true;
            Constructor<?> constructor = null;
            try {
                cls = Class.forName(FONT_FAMILY_CLASS);
                Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
                method = cls.getMethod(ADD_FONT_WEIGHT_STYLE_METHOD, new Class[]{String.class, Integer.TYPE, Boolean.TYPE});
                method2 = Typeface.class.getMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, new Class[]{Array.newInstance(cls, 1).getClass()});
                constructor = constructor2;
            } catch (ClassNotFoundException | NoSuchMethodException e) {
                Log.e(TAG, e.getClass().getName(), e);
                method2 = null;
                cls = null;
                method = null;
            }
            sFontFamilyCtor = constructor;
            sFontFamily = cls;
            sAddFontWeightStyle = method;
            sCreateFromFamiliesWithDefault = method2;
        }
    }

    private File getFile(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static Object newFamily() {
        init();
        try {
            return sFontFamilyCtor.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static Typeface createFromFamiliesWithDefault(Object obj) {
        init();
        try {
            Object newInstance = Array.newInstance(sFontFamily, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) sCreateFromFamiliesWithDefault.invoke((Object) null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean addFontWeightStyle(Object obj, String str, int i, boolean z) {
        init();
        try {
            return ((Boolean) sAddFontWeightStyle.invoke(obj, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004d, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004e, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0052, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0053, code lost:
        r3 = r8;
        r8 = r5;
        r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0060, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0061, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0065, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0066, code lost:
        r3 = r7;
        r7 = r5;
        r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x006b, code lost:
        if (r7 != null) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0060 A[ExcHandler: all (th java.lang.Throwable)] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Typeface createFromFontInfo(android.content.Context r5, android.os.CancellationSignal r6, @androidx.annotation.NonNull androidx.core.provider.FontsContractCompat.FontInfo[] r7, int r8) {
        /*
            r4 = this;
            int r0 = r7.length
            r1 = 0
            r2 = 1
            if (r0 >= r2) goto L_0x0006
            return r1
        L_0x0006:
            androidx.core.provider.FontsContractCompat$FontInfo r7 = r4.findBestInfo(r7, r8)
            android.content.ContentResolver r8 = r5.getContentResolver()
            android.net.Uri r7 = r7.getUri()     // Catch:{ IOException -> 0x0075 }
            java.lang.String r0 = "r"
            android.os.ParcelFileDescriptor r6 = r8.openFileDescriptor(r7, r0, r6)     // Catch:{ IOException -> 0x0075 }
            if (r6 != 0) goto L_0x0020
            if (r6 == 0) goto L_0x001f
            r6.close()     // Catch:{ IOException -> 0x0075 }
        L_0x001f:
            return r1
        L_0x0020:
            java.io.File r7 = r4.getFile(r6)     // Catch:{ Throwable -> 0x0063, all -> 0x0060 }
            if (r7 == 0) goto L_0x0037
            boolean r8 = r7.canRead()     // Catch:{ Throwable -> 0x0063, all -> 0x0060 }
            if (r8 != 0) goto L_0x002d
            goto L_0x0037
        L_0x002d:
            android.graphics.Typeface r5 = android.graphics.Typeface.createFromFile(r7)     // Catch:{ Throwable -> 0x0063, all -> 0x0060 }
            if (r6 == 0) goto L_0x0036
            r6.close()     // Catch:{ IOException -> 0x0075 }
        L_0x0036:
            return r5
        L_0x0037:
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x0063, all -> 0x0060 }
            java.io.FileDescriptor r8 = r6.getFileDescriptor()     // Catch:{ Throwable -> 0x0063, all -> 0x0060 }
            r7.<init>(r8)     // Catch:{ Throwable -> 0x0063, all -> 0x0060 }
            android.graphics.Typeface r5 = super.createFromInputStream(r5, r7)     // Catch:{ Throwable -> 0x0050, all -> 0x004d }
            r7.close()     // Catch:{ Throwable -> 0x0063, all -> 0x0060 }
            if (r6 == 0) goto L_0x004c
            r6.close()     // Catch:{ IOException -> 0x0075 }
        L_0x004c:
            return r5
        L_0x004d:
            r5 = move-exception
            r8 = r1
            goto L_0x0056
        L_0x0050:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0052 }
        L_0x0052:
            r8 = move-exception
            r3 = r8
            r8 = r5
            r5 = r3
        L_0x0056:
            if (r8 == 0) goto L_0x005c
            r7.close()     // Catch:{ Throwable -> 0x005f, all -> 0x0060 }
            goto L_0x005f
        L_0x005c:
            r7.close()     // Catch:{ Throwable -> 0x0063, all -> 0x0060 }
        L_0x005f:
            throw r5     // Catch:{ Throwable -> 0x0063, all -> 0x0060 }
        L_0x0060:
            r5 = move-exception
            r7 = r1
            goto L_0x0069
        L_0x0063:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0065 }
        L_0x0065:
            r7 = move-exception
            r3 = r7
            r7 = r5
            r5 = r3
        L_0x0069:
            if (r6 == 0) goto L_0x0074
            if (r7 == 0) goto L_0x0071
            r6.close()     // Catch:{ Throwable -> 0x0074 }
            goto L_0x0074
        L_0x0071:
            r6.close()     // Catch:{ IOException -> 0x0075 }
        L_0x0074:
            throw r5     // Catch:{ IOException -> 0x0075 }
        L_0x0075:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatApi21Impl.createFromFontInfo(android.content.Context, android.os.CancellationSignal, androidx.core.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        Object newFamily = newFamily();
        FontResourcesParserCompat.FontFileResourceEntry[] entries = fontFamilyFilesResourceEntry.getEntries();
        int length = entries.length;
        int i2 = 0;
        while (i2 < length) {
            FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry = entries[i2];
            File tempFile = TypefaceCompatUtil.getTempFile(context);
            if (tempFile == null) {
                return null;
            }
            try {
                if (!TypefaceCompatUtil.copyToFile(tempFile, resources, fontFileResourceEntry.getResourceId())) {
                    tempFile.delete();
                    return null;
                } else if (!addFontWeightStyle(newFamily, tempFile.getPath(), fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic())) {
                    return null;
                } else {
                    tempFile.delete();
                    i2++;
                }
            } catch (RuntimeException unused) {
                return null;
            } finally {
                tempFile.delete();
            }
        }
        return createFromFamiliesWithDefault(newFamily);
    }
}

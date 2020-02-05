package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.content.ContextCompat;
import com.google.android.gms.internal.firebase_messaging.zzn;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;

final class zzz {
    zzz() {
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final zzy zzb(Context context, String str) throws zzaa {
        zzy zzd = zzd(context, str);
        if (zzd != null) {
            return zzd;
        }
        return zzc(context, str);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final zzy zzc(Context context, String str) {
        zzy zzy = new zzy(zza.zzc(), System.currentTimeMillis());
        zzy zza = zza(context, str, zzy, true);
        if (zza == null || zza.equals(zzy)) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Generated new key");
            }
            zza(context, str, zzy);
            return zzy;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Loaded key after generating new one, using loaded one");
        }
        return zza;
    }

    static void zza(Context context) {
        for (File file : zzb(context).listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
    }

    @Nullable
    private final zzy zzd(Context context, String str) throws zzaa {
        try {
            zzy zze = zze(context, str);
            if (zze != null) {
                zza(context, str, zze);
                return zze;
            }
            e = null;
            try {
                zzy zza = zza(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
                if (zza != null) {
                    zza(context, str, zza, false);
                    return zza;
                }
            } catch (zzaa e) {
                e = e;
            }
            if (e == null) {
                return null;
            }
            throw e;
        } catch (zzaa e2) {
            e = e2;
        }
    }

    private static KeyPair zzc(String str, String str2) throws zzaa {
        try {
            byte[] decode = Base64.decode(str, 8);
            byte[] decode2 = Base64.decode(str2, 8);
            try {
                KeyFactory instance = KeyFactory.getInstance("RSA");
                return new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 19);
                sb.append("Invalid key stored ");
                sb.append(valueOf);
                Log.w("FirebaseInstanceId", sb.toString());
                throw new zzaa((Exception) e);
            }
        } catch (IllegalArgumentException e2) {
            throw new zzaa((Exception) e2);
        }
    }

    @Nullable
    private final zzy zze(Context context, String str) throws zzaa {
        File zzf = zzf(context, str);
        if (!zzf.exists()) {
            return null;
        }
        try {
            return zza(zzf);
        } catch (zzaa | IOException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 40);
                sb.append("Failed to read key from file, retrying: ");
                sb.append(valueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            try {
                return zza(zzf);
            } catch (IOException e2) {
                String valueOf2 = String.valueOf(e2);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 45);
                sb2.append("IID file exists, but failed to read from it: ");
                sb2.append(valueOf2);
                Log.w("FirebaseInstanceId", sb2.toString());
                throw new zzaa((Exception) e2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a2, code lost:
        r12 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a3, code lost:
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a7, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a8, code lost:
        r8 = r13;
        r13 = r12;
        r12 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b1, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b2, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b6, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00b7, code lost:
        r8 = r12;
        r12 = r10;
        r10 = r8;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x0060=Splitter:B:19:0x0060, B:52:0x00ba=Splitter:B:52:0x00ba, B:31:0x009e=Splitter:B:31:0x009e} */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.firebase.iid.zzy zza(android.content.Context r10, java.lang.String r11, com.google.firebase.iid.zzy r12, boolean r13) {
        /*
            r9 = this;
            r0 = 3
            java.lang.String r1 = "FirebaseInstanceId"
            boolean r2 = android.util.Log.isLoggable(r1, r0)
            if (r2 == 0) goto L_0x000e
            java.lang.String r2 = "Writing key to properties file"
            android.util.Log.d(r1, r2)
        L_0x000e:
            java.util.Properties r2 = new java.util.Properties
            r2.<init>()
            java.lang.String r3 = r12.zzv()
            java.lang.String r4 = "pub"
            r2.setProperty(r4, r3)
            java.lang.String r3 = r12.zzw()
            java.lang.String r4 = "pri"
            r2.setProperty(r4, r3)
            long r3 = r12.zzbx
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "cre"
            r2.setProperty(r4, r3)
            java.io.File r10 = zzf(r10, r11)
            r11 = 0
            r10.createNewFile()     // Catch:{ IOException -> 0x00be }
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x00be }
            java.lang.String r4 = "rw"
            r3.<init>(r10, r4)     // Catch:{ IOException -> 0x00be }
            java.nio.channels.FileChannel r10 = r3.getChannel()     // Catch:{ Throwable -> 0x00b4, all -> 0x00b1 }
            r10.lock()     // Catch:{ Throwable -> 0x00a5, all -> 0x00a2 }
            r4 = 0
            if (r13 == 0) goto L_0x008f
            long r6 = r10.size()     // Catch:{ Throwable -> 0x00a5, all -> 0x00a2 }
            int r13 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r13 <= 0) goto L_0x008f
            r10.position(r4)     // Catch:{ IOException -> 0x0066, zzaa -> 0x0064 }
            com.google.firebase.iid.zzy r12 = zza((java.nio.channels.FileChannel) r10)     // Catch:{ IOException -> 0x0066, zzaa -> 0x0064 }
            if (r10 == 0) goto L_0x0060
            zza((java.lang.Throwable) r11, (java.nio.channels.FileChannel) r10)     // Catch:{ Throwable -> 0x00b4, all -> 0x00b1 }
        L_0x0060:
            zza((java.lang.Throwable) r11, (java.io.RandomAccessFile) r3)     // Catch:{ IOException -> 0x00be }
            return r12
        L_0x0064:
            r13 = move-exception
            goto L_0x0067
        L_0x0066:
            r13 = move-exception
        L_0x0067:
            boolean r0 = android.util.Log.isLoggable(r1, r0)     // Catch:{ Throwable -> 0x00a5, all -> 0x00a2 }
            if (r0 == 0) goto L_0x008f
            java.lang.String r13 = java.lang.String.valueOf(r13)     // Catch:{ Throwable -> 0x00a5, all -> 0x00a2 }
            java.lang.String r0 = java.lang.String.valueOf(r13)     // Catch:{ Throwable -> 0x00a5, all -> 0x00a2 }
            int r0 = r0.length()     // Catch:{ Throwable -> 0x00a5, all -> 0x00a2 }
            int r0 = r0 + 64
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00a5, all -> 0x00a2 }
            r6.<init>(r0)     // Catch:{ Throwable -> 0x00a5, all -> 0x00a2 }
            java.lang.String r0 = "Tried reading key pair before writing new one, but failed with: "
            r6.append(r0)     // Catch:{ Throwable -> 0x00a5, all -> 0x00a2 }
            r6.append(r13)     // Catch:{ Throwable -> 0x00a5, all -> 0x00a2 }
            java.lang.String r13 = r6.toString()     // Catch:{ Throwable -> 0x00a5, all -> 0x00a2 }
            android.util.Log.d(r1, r13)     // Catch:{ Throwable -> 0x00a5, all -> 0x00a2 }
        L_0x008f:
            r10.position(r4)     // Catch:{ Throwable -> 0x00a5, all -> 0x00a2 }
            java.io.OutputStream r13 = java.nio.channels.Channels.newOutputStream(r10)     // Catch:{ Throwable -> 0x00a5, all -> 0x00a2 }
            r2.store(r13, r11)     // Catch:{ Throwable -> 0x00a5, all -> 0x00a2 }
            if (r10 == 0) goto L_0x009e
            zza((java.lang.Throwable) r11, (java.nio.channels.FileChannel) r10)     // Catch:{ Throwable -> 0x00b4, all -> 0x00b1 }
        L_0x009e:
            zza((java.lang.Throwable) r11, (java.io.RandomAccessFile) r3)     // Catch:{ IOException -> 0x00be }
            return r12
        L_0x00a2:
            r12 = move-exception
            r13 = r11
            goto L_0x00ab
        L_0x00a5:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x00a7 }
        L_0x00a7:
            r13 = move-exception
            r8 = r13
            r13 = r12
            r12 = r8
        L_0x00ab:
            if (r10 == 0) goto L_0x00b0
            zza((java.lang.Throwable) r13, (java.nio.channels.FileChannel) r10)     // Catch:{ Throwable -> 0x00b4, all -> 0x00b1 }
        L_0x00b0:
            throw r12     // Catch:{ Throwable -> 0x00b4, all -> 0x00b1 }
        L_0x00b1:
            r10 = move-exception
            r12 = r11
            goto L_0x00ba
        L_0x00b4:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x00b6 }
        L_0x00b6:
            r12 = move-exception
            r8 = r12
            r12 = r10
            r10 = r8
        L_0x00ba:
            zza((java.lang.Throwable) r12, (java.io.RandomAccessFile) r3)     // Catch:{ IOException -> 0x00be }
            throw r10     // Catch:{ IOException -> 0x00be }
        L_0x00be:
            r10 = move-exception
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.String r12 = java.lang.String.valueOf(r10)
            int r12 = r12.length()
            int r12 = r12 + 21
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r12)
            java.lang.String r12 = "Failed to write key: "
            r13.append(r12)
            r13.append(r10)
            java.lang.String r10 = r13.toString()
            android.util.Log.w(r1, r10)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzz.zza(android.content.Context, java.lang.String, com.google.firebase.iid.zzy, boolean):com.google.firebase.iid.zzy");
    }

    private static File zzb(Context context) {
        File noBackupFilesDir = ContextCompat.getNoBackupFilesDir(context);
        if (noBackupFilesDir != null && noBackupFilesDir.isDirectory()) {
            return noBackupFilesDir;
        }
        Log.w("FirebaseInstanceId", "noBackupFilesDir doesn't exist, using regular files directory instead");
        return context.getFilesDir();
    }

    private static File zzf(Context context, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "com.google.InstanceId.properties";
        } else {
            try {
                String encodeToString = Base64.encodeToString(str.getBytes("UTF-8"), 11);
                StringBuilder sb = new StringBuilder(String.valueOf(encodeToString).length() + 33);
                sb.append("com.google.InstanceId_");
                sb.append(encodeToString);
                sb.append(".properties");
                str2 = sb.toString();
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return new File(zzb(context), str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0029, code lost:
        r8 = r2;
        r2 = r1;
        r1 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0032, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0036, code lost:
        zza(r10, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0039, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.firebase.iid.zzy zza(java.io.File r10) throws com.google.firebase.iid.zzaa, java.io.IOException {
        /*
            r9 = this;
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r10)
            r10 = 0
            java.nio.channels.FileChannel r7 = r0.getChannel()     // Catch:{ Throwable -> 0x0034 }
            r2 = 0
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r6 = 1
            r1 = r7
            r1.lock(r2, r4, r6)     // Catch:{ Throwable -> 0x0026, all -> 0x0023 }
            com.google.firebase.iid.zzy r1 = zza((java.nio.channels.FileChannel) r7)     // Catch:{ Throwable -> 0x0026, all -> 0x0023 }
            if (r7 == 0) goto L_0x001f
            zza((java.lang.Throwable) r10, (java.nio.channels.FileChannel) r7)     // Catch:{ Throwable -> 0x0034 }
        L_0x001f:
            zza((java.lang.Throwable) r10, (java.io.FileInputStream) r0)
            return r1
        L_0x0023:
            r1 = move-exception
            r2 = r10
            goto L_0x002c
        L_0x0026:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0028 }
        L_0x0028:
            r2 = move-exception
            r8 = r2
            r2 = r1
            r1 = r8
        L_0x002c:
            if (r7 == 0) goto L_0x0031
            zza((java.lang.Throwable) r2, (java.nio.channels.FileChannel) r7)     // Catch:{ Throwable -> 0x0034 }
        L_0x0031:
            throw r1     // Catch:{ Throwable -> 0x0034 }
        L_0x0032:
            r1 = move-exception
            goto L_0x0036
        L_0x0034:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x0032 }
        L_0x0036:
            zza((java.lang.Throwable) r10, (java.io.FileInputStream) r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzz.zza(java.io.File):com.google.firebase.iid.zzy");
    }

    private static zzy zza(FileChannel fileChannel) throws zzaa, IOException {
        Properties properties = new Properties();
        properties.load(Channels.newInputStream(fileChannel));
        String property = properties.getProperty("pub");
        String property2 = properties.getProperty("pri");
        if (property == null || property2 == null) {
            throw new zzaa("Invalid properties file");
        }
        try {
            return new zzy(zzc(property, property2), Long.parseLong(properties.getProperty("cre")));
        } catch (NumberFormatException e) {
            throw new zzaa((Exception) e);
        }
    }

    @Nullable
    private static zzy zza(SharedPreferences sharedPreferences, String str) throws zzaa {
        String string = sharedPreferences.getString(zzav.zzd(str, "|P|"), (String) null);
        String string2 = sharedPreferences.getString(zzav.zzd(str, "|K|"), (String) null);
        if (string == null || string2 == null) {
            return null;
        }
        return new zzy(zzc(string, string2), zzb(sharedPreferences, str));
    }

    private final void zza(Context context, String str, zzy zzy) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        try {
            if (zzy.equals(zza(sharedPreferences, str))) {
                return;
            }
        } catch (zzaa unused) {
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Writing key to shared preferences");
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(zzav.zzd(str, "|P|"), zzy.zzv());
        edit.putString(zzav.zzd(str, "|K|"), zzy.zzw());
        edit.putString(zzav.zzd(str, "cre"), String.valueOf(zzy.zzbx));
        edit.commit();
    }

    private static long zzb(SharedPreferences sharedPreferences, String str) {
        String string = sharedPreferences.getString(zzav.zzd(str, "cre"), (String) null);
        if (string == null) {
            return 0;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    private static /* synthetic */ void zza(Throwable th, FileChannel fileChannel) {
        if (th != null) {
            try {
                fileChannel.close();
            } catch (Throwable th2) {
                zzn.zza(th, th2);
            }
        } else {
            fileChannel.close();
        }
    }

    private static /* synthetic */ void zza(Throwable th, RandomAccessFile randomAccessFile) {
        if (th != null) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                zzn.zza(th, th2);
            }
        } else {
            randomAccessFile.close();
        }
    }

    private static /* synthetic */ void zza(Throwable th, FileInputStream fileInputStream) {
        if (th != null) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                zzn.zza(th, th2);
            }
        } else {
            fileInputStream.close();
        }
    }
}

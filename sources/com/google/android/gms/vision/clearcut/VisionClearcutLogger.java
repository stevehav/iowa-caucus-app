package com.google.android.gms.vision.clearcut;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.internal.vision.zzct;
import com.google.android.gms.internal.vision.zzdu;
import com.google.android.gms.internal.vision.zzjt;
import com.google.android.gms.vision.L;

@Keep
public class VisionClearcutLogger {
    private final ClearcutLogger zzbw;
    private boolean zzbx = true;

    public VisionClearcutLogger(Context context) {
        this.zzbw = new ClearcutLogger(context, "VISION", (String) null);
    }

    public final void zzb(int i, zzdu zzdu) {
        byte[] bArr = new byte[zzdu.zzeq()];
        zzjt.zza(zzdu, bArr, 0, bArr.length);
        if (i < 0 || i > 3) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Illegal event code: ");
            sb.append(i);
            String sb2 = sb.toString();
            Object[] objArr = new Object[0];
            if (L.isLoggable(4)) {
                Log.i("Vision", String.format(sb2, objArr));
                return;
            }
            return;
        }
        try {
            if (this.zzbx) {
                this.zzbw.newEvent(bArr).setEventCode(i).log();
                return;
            }
            zzdu zzdu2 = new zzdu();
            try {
                zzjt.zza(zzdu2, bArr);
                L.zzc("Would have logged:\n%s", zzdu2.toString());
            } catch (Exception e) {
                L.zza(e, "Parsing error", new Object[0]);
            }
        } catch (Exception e2) {
            zzct.zza(e2);
            L.zza(e2, "Failed to log", new Object[0]);
        }
    }
}

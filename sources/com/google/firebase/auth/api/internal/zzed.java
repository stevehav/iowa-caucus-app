package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zza;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public abstract class zzed extends zza implements zzee {
    public zzed() {
        super("com.google.firebase.auth.api.internal.IFirebaseAuthService");
    }

    /* JADX WARNING: type inference failed for: r5v16, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
        /*
            r3 = this;
            r7 = 0
            java.lang.String r0 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            switch(r4) {
                case 1: goto L_0x086e;
                case 2: goto L_0x084f;
                case 3: goto L_0x082c;
                case 4: goto L_0x0805;
                case 5: goto L_0x07e1;
                case 6: goto L_0x07bd;
                case 7: goto L_0x0799;
                case 8: goto L_0x0775;
                case 9: goto L_0x0755;
                case 10: goto L_0x0735;
                case 11: goto L_0x070d;
                case 12: goto L_0x06e5;
                case 13: goto L_0x06c5;
                case 14: goto L_0x06a1;
                case 15: goto L_0x0681;
                case 16: goto L_0x0664;
                case 17: goto L_0x0644;
                case 18: goto L_0x0624;
                case 19: goto L_0x0604;
                case 20: goto L_0x05e4;
                case 21: goto L_0x05c0;
                case 22: goto L_0x059c;
                case 23: goto L_0x0578;
                case 24: goto L_0x0550;
                case 25: goto L_0x0528;
                case 26: goto L_0x0500;
                case 27: goto L_0x04e0;
                case 28: goto L_0x04b8;
                case 29: goto L_0x0494;
                default: goto L_0x0006;
            }
        L_0x0006:
            switch(r4) {
                case 101: goto L_0x0470;
                case 102: goto L_0x044c;
                case 103: goto L_0x0428;
                case 104: goto L_0x0404;
                case 105: goto L_0x03e0;
                case 106: goto L_0x03bc;
                case 107: goto L_0x0398;
                case 108: goto L_0x0374;
                case 109: goto L_0x0350;
                default: goto L_0x0009;
            }
        L_0x0009:
            switch(r4) {
                case 111: goto L_0x032c;
                case 112: goto L_0x0308;
                case 113: goto L_0x02e4;
                case 114: goto L_0x02c0;
                case 115: goto L_0x029c;
                case 116: goto L_0x0278;
                case 117: goto L_0x0254;
                default: goto L_0x000c;
            }
        L_0x000c:
            switch(r4) {
                case 119: goto L_0x0230;
                case 120: goto L_0x020c;
                case 121: goto L_0x01e8;
                case 122: goto L_0x01c4;
                case 123: goto L_0x01a0;
                case 124: goto L_0x017c;
                default: goto L_0x000f;
            }
        L_0x000f:
            switch(r4) {
                case 126: goto L_0x0158;
                case 127: goto L_0x0134;
                case 128: goto L_0x0110;
                case 129: goto L_0x00ec;
                case 130: goto L_0x00c8;
                case 131: goto L_0x00a4;
                case 132: goto L_0x0080;
                case 133: goto L_0x005c;
                case 134: goto L_0x0038;
                case 135: goto L_0x0014;
                default: goto L_0x0012;
            }
        L_0x0012:
            r4 = 0
            return r4
        L_0x0014:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzdz> r4 = com.google.android.gms.internal.firebase_auth.zzdz.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzdz r4 = (com.google.android.gms.internal.firebase_auth.zzdz) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0023
            goto L_0x0033
        L_0x0023:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x002e
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x0033
        L_0x002e:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x0033:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzdz) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x0038:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzcf> r4 = com.google.android.gms.internal.firebase_auth.zzcf.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzcf r4 = (com.google.android.gms.internal.firebase_auth.zzcf) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0047
            goto L_0x0057
        L_0x0047:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x0052
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x0057
        L_0x0052:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x0057:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzcf) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x005c:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzdp> r4 = com.google.android.gms.internal.firebase_auth.zzdp.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzdp r4 = (com.google.android.gms.internal.firebase_auth.zzdp) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x006b
            goto L_0x007b
        L_0x006b:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x0076
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x007b
        L_0x0076:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x007b:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzdp) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x0080:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzcd> r4 = com.google.android.gms.internal.firebase_auth.zzcd.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzcd r4 = (com.google.android.gms.internal.firebase_auth.zzcd) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x008f
            goto L_0x009f
        L_0x008f:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x009a
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x009f
        L_0x009a:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x009f:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzcd) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x00a4:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzdr> r4 = com.google.android.gms.internal.firebase_auth.zzdr.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzdr r4 = (com.google.android.gms.internal.firebase_auth.zzdr) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x00b3
            goto L_0x00c3
        L_0x00b3:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x00be
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x00c3
        L_0x00be:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x00c3:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzdr) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x00c8:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzdn> r4 = com.google.android.gms.internal.firebase_auth.zzdn.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzdn r4 = (com.google.android.gms.internal.firebase_auth.zzdn) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x00d7
            goto L_0x00e7
        L_0x00d7:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x00e2
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x00e7
        L_0x00e2:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x00e7:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzdn) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x00ec:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzdj> r4 = com.google.android.gms.internal.firebase_auth.zzdj.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzdj r4 = (com.google.android.gms.internal.firebase_auth.zzdj) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x00fb
            goto L_0x010b
        L_0x00fb:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x0106
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x010b
        L_0x0106:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x010b:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzdj) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x0110:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzcv> r4 = com.google.android.gms.internal.firebase_auth.zzcv.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzcv r4 = (com.google.android.gms.internal.firebase_auth.zzcv) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x011f
            goto L_0x012f
        L_0x011f:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x012a
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x012f
        L_0x012a:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x012f:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzcv) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x0134:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzcz> r4 = com.google.android.gms.internal.firebase_auth.zzcz.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzcz r4 = (com.google.android.gms.internal.firebase_auth.zzcz) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0143
            goto L_0x0153
        L_0x0143:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x014e
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x0153
        L_0x014e:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x0153:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzcz) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x0158:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzct> r4 = com.google.android.gms.internal.firebase_auth.zzct.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzct r4 = (com.google.android.gms.internal.firebase_auth.zzct) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0167
            goto L_0x0177
        L_0x0167:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x0172
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x0177
        L_0x0172:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x0177:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzct) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x017c:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzcp> r4 = com.google.android.gms.internal.firebase_auth.zzcp.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzcp r4 = (com.google.android.gms.internal.firebase_auth.zzcp) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x018b
            goto L_0x019b
        L_0x018b:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x0196
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x019b
        L_0x0196:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x019b:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzcp) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x01a0:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzdl> r4 = com.google.android.gms.internal.firebase_auth.zzdl.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzdl r4 = (com.google.android.gms.internal.firebase_auth.zzdl) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x01af
            goto L_0x01bf
        L_0x01af:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x01ba
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x01bf
        L_0x01ba:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x01bf:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzdl) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x01c4:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzcx> r4 = com.google.android.gms.internal.firebase_auth.zzcx.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzcx r4 = (com.google.android.gms.internal.firebase_auth.zzcx) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x01d3
            goto L_0x01e3
        L_0x01d3:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x01de
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x01e3
        L_0x01de:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x01e3:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzcx) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x01e8:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzbx> r4 = com.google.android.gms.internal.firebase_auth.zzbx.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzbx r4 = (com.google.android.gms.internal.firebase_auth.zzbx) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x01f7
            goto L_0x0207
        L_0x01f7:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x0202
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x0207
        L_0x0202:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x0207:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzbx) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x020c:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzbp> r4 = com.google.android.gms.internal.firebase_auth.zzbp.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzbp r4 = (com.google.android.gms.internal.firebase_auth.zzbp) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x021b
            goto L_0x022b
        L_0x021b:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x0226
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x022b
        L_0x0226:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x022b:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzbp) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x0230:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzbv> r4 = com.google.android.gms.internal.firebase_auth.zzbv.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzbv r4 = (com.google.android.gms.internal.firebase_auth.zzbv) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x023f
            goto L_0x024f
        L_0x023f:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x024a
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x024f
        L_0x024a:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x024f:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzbv) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x0254:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzcb> r4 = com.google.android.gms.internal.firebase_auth.zzcb.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzcb r4 = (com.google.android.gms.internal.firebase_auth.zzcb) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0263
            goto L_0x0273
        L_0x0263:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x026e
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x0273
        L_0x026e:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x0273:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzcb) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x0278:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzdb> r4 = com.google.android.gms.internal.firebase_auth.zzdb.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzdb r4 = (com.google.android.gms.internal.firebase_auth.zzdb) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0287
            goto L_0x0297
        L_0x0287:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x0292
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x0297
        L_0x0292:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x0297:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzdb) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x029c:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzcr> r4 = com.google.android.gms.internal.firebase_auth.zzcr.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzcr r4 = (com.google.android.gms.internal.firebase_auth.zzcr) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x02ab
            goto L_0x02bb
        L_0x02ab:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x02b6
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x02bb
        L_0x02b6:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x02bb:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzcr) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x02c0:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzdv> r4 = com.google.android.gms.internal.firebase_auth.zzdv.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzdv r4 = (com.google.android.gms.internal.firebase_auth.zzdv) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x02cf
            goto L_0x02df
        L_0x02cf:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x02da
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x02df
        L_0x02da:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x02df:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzdv) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x02e4:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzdt> r4 = com.google.android.gms.internal.firebase_auth.zzdt.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzdt r4 = (com.google.android.gms.internal.firebase_auth.zzdt) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x02f3
            goto L_0x0303
        L_0x02f3:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x02fe
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x0303
        L_0x02fe:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x0303:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzdt) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x0308:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzcn> r4 = com.google.android.gms.internal.firebase_auth.zzcn.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzcn r4 = (com.google.android.gms.internal.firebase_auth.zzcn) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0317
            goto L_0x0327
        L_0x0317:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x0322
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x0327
        L_0x0322:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x0327:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzcn) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x032c:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzcl> r4 = com.google.android.gms.internal.firebase_auth.zzcl.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzcl r4 = (com.google.android.gms.internal.firebase_auth.zzcl) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x033b
            goto L_0x034b
        L_0x033b:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x0346
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x034b
        L_0x0346:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x034b:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzcl) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x0350:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzcj> r4 = com.google.android.gms.internal.firebase_auth.zzcj.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzcj r4 = (com.google.android.gms.internal.firebase_auth.zzcj) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x035f
            goto L_0x036f
        L_0x035f:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x036a
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x036f
        L_0x036a:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x036f:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzcj) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x0374:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzdh> r4 = com.google.android.gms.internal.firebase_auth.zzdh.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzdh r4 = (com.google.android.gms.internal.firebase_auth.zzdh) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0383
            goto L_0x0393
        L_0x0383:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x038e
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x0393
        L_0x038e:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x0393:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzdh) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x0398:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzbz> r4 = com.google.android.gms.internal.firebase_auth.zzbz.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzbz r4 = (com.google.android.gms.internal.firebase_auth.zzbz) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x03a7
            goto L_0x03b7
        L_0x03a7:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x03b2
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x03b7
        L_0x03b2:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x03b7:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzbz) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x03bc:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzbt> r4 = com.google.android.gms.internal.firebase_auth.zzbt.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzbt r4 = (com.google.android.gms.internal.firebase_auth.zzbt) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x03cb
            goto L_0x03db
        L_0x03cb:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x03d6
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x03db
        L_0x03d6:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x03db:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzbt) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x03e0:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzbr> r4 = com.google.android.gms.internal.firebase_auth.zzbr.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzbr r4 = (com.google.android.gms.internal.firebase_auth.zzbr) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x03ef
            goto L_0x03ff
        L_0x03ef:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x03fa
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x03ff
        L_0x03fa:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x03ff:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzbr) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x0404:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzdx> r4 = com.google.android.gms.internal.firebase_auth.zzdx.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzdx r4 = (com.google.android.gms.internal.firebase_auth.zzdx) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0413
            goto L_0x0423
        L_0x0413:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x041e
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x0423
        L_0x041e:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x0423:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzdx) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x0428:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzdd> r4 = com.google.android.gms.internal.firebase_auth.zzdd.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzdd r4 = (com.google.android.gms.internal.firebase_auth.zzdd) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0437
            goto L_0x0447
        L_0x0437:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x0442
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x0447
        L_0x0442:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x0447:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzdd) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x044c:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzdf> r4 = com.google.android.gms.internal.firebase_auth.zzdf.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzdf r4 = (com.google.android.gms.internal.firebase_auth.zzdf) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x045b
            goto L_0x046b
        L_0x045b:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x0466
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x046b
        L_0x0466:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x046b:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzdf) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x0470:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzch> r4 = com.google.android.gms.internal.firebase_auth.zzch.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzch r4 = (com.google.android.gms.internal.firebase_auth.zzch) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x047f
            goto L_0x048f
        L_0x047f:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x048a
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x048f
        L_0x048a:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x048f:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzch) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x0494:
            android.os.Parcelable$Creator<com.google.firebase.auth.EmailAuthCredential> r4 = com.google.firebase.auth.EmailAuthCredential.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.firebase.auth.EmailAuthCredential r4 = (com.google.firebase.auth.EmailAuthCredential) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x04a3
            goto L_0x04b3
        L_0x04a3:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x04ae
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x04b3
        L_0x04ae:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x04b3:
            r3.zza((com.google.firebase.auth.EmailAuthCredential) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x04b8:
            java.lang.String r4 = r5.readString()
            android.os.Parcelable$Creator<com.google.firebase.auth.ActionCodeSettings> r1 = com.google.firebase.auth.ActionCodeSettings.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r1)
            com.google.firebase.auth.ActionCodeSettings r1 = (com.google.firebase.auth.ActionCodeSettings) r1
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x04cb
            goto L_0x04db
        L_0x04cb:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x04d6
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x04db
        L_0x04d6:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x04db:
            r3.zzc((java.lang.String) r4, (com.google.firebase.auth.ActionCodeSettings) r1, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x04e0:
            java.lang.String r4 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x04eb
            goto L_0x04fb
        L_0x04eb:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x04f6
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x04fb
        L_0x04f6:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x04fb:
            r3.zzk(r4, r7)
            goto L_0x088c
        L_0x0500:
            java.lang.String r4 = r5.readString()
            android.os.Parcelable$Creator<com.google.firebase.auth.ActionCodeSettings> r1 = com.google.firebase.auth.ActionCodeSettings.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r1)
            com.google.firebase.auth.ActionCodeSettings r1 = (com.google.firebase.auth.ActionCodeSettings) r1
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0513
            goto L_0x0523
        L_0x0513:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x051e
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x0523
        L_0x051e:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x0523:
            r3.zzb((java.lang.String) r4, (com.google.firebase.auth.ActionCodeSettings) r1, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x0528:
            java.lang.String r4 = r5.readString()
            android.os.Parcelable$Creator<com.google.firebase.auth.ActionCodeSettings> r1 = com.google.firebase.auth.ActionCodeSettings.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r1)
            com.google.firebase.auth.ActionCodeSettings r1 = (com.google.firebase.auth.ActionCodeSettings) r1
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x053b
            goto L_0x054b
        L_0x053b:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x0546
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x054b
        L_0x0546:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x054b:
            r3.zza((java.lang.String) r4, (com.google.firebase.auth.ActionCodeSettings) r1, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x0550:
            java.lang.String r4 = r5.readString()
            android.os.Parcelable$Creator<com.google.firebase.auth.PhoneAuthCredential> r1 = com.google.firebase.auth.PhoneAuthCredential.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r1)
            com.google.firebase.auth.PhoneAuthCredential r1 = (com.google.firebase.auth.PhoneAuthCredential) r1
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0563
            goto L_0x0573
        L_0x0563:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x056e
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x0573
        L_0x056e:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x0573:
            r3.zza((java.lang.String) r4, (com.google.firebase.auth.PhoneAuthCredential) r1, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x0578:
            android.os.Parcelable$Creator<com.google.firebase.auth.PhoneAuthCredential> r4 = com.google.firebase.auth.PhoneAuthCredential.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.firebase.auth.PhoneAuthCredential r4 = (com.google.firebase.auth.PhoneAuthCredential) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0587
            goto L_0x0597
        L_0x0587:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x0592
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x0597
        L_0x0592:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x0597:
            r3.zza((com.google.firebase.auth.PhoneAuthCredential) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x059c:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzfk> r4 = com.google.android.gms.internal.firebase_auth.zzfk.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzfk r4 = (com.google.android.gms.internal.firebase_auth.zzfk) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x05ab
            goto L_0x05bb
        L_0x05ab:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x05b6
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x05bb
        L_0x05b6:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x05bb:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzfk) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x05c0:
            java.lang.String r4 = r5.readString()
            java.lang.String r1 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x05cf
            goto L_0x05df
        L_0x05cf:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x05da
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x05df
        L_0x05da:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x05df:
            r3.zzf(r4, r1, r7)
            goto L_0x088c
        L_0x05e4:
            java.lang.String r4 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x05ef
            goto L_0x05ff
        L_0x05ef:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x05fa
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x05ff
        L_0x05fa:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x05ff:
            r3.zzj(r4, r7)
            goto L_0x088c
        L_0x0604:
            java.lang.String r4 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x060f
            goto L_0x061f
        L_0x060f:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x061a
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x061f
        L_0x061a:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x061f:
            r3.zzi(r4, r7)
            goto L_0x088c
        L_0x0624:
            java.lang.String r4 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x062f
            goto L_0x063f
        L_0x062f:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x063a
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x063f
        L_0x063a:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x063f:
            r3.zzh(r4, r7)
            goto L_0x088c
        L_0x0644:
            java.lang.String r4 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x064f
            goto L_0x065f
        L_0x064f:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x065a
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x065f
        L_0x065a:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x065f:
            r3.zzg(r4, r7)
            goto L_0x088c
        L_0x0664:
            android.os.IBinder r4 = r5.readStrongBinder()
            if (r4 != 0) goto L_0x066b
            goto L_0x067c
        L_0x066b:
            android.os.IInterface r5 = r4.queryLocalInterface(r0)
            boolean r7 = r5 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r7 == 0) goto L_0x0677
            r7 = r5
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x067c
        L_0x0677:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r4)
        L_0x067c:
            r3.zza(r7)
            goto L_0x088c
        L_0x0681:
            java.lang.String r4 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x068c
            goto L_0x069c
        L_0x068c:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x0697
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x069c
        L_0x0697:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x069c:
            r3.zzf(r4, r7)
            goto L_0x088c
        L_0x06a1:
            java.lang.String r4 = r5.readString()
            java.lang.String r1 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x06b0
            goto L_0x06c0
        L_0x06b0:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x06bb
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x06c0
        L_0x06bb:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x06c0:
            r3.zze(r4, r1, r7)
            goto L_0x088c
        L_0x06c5:
            java.lang.String r4 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x06d0
            goto L_0x06e0
        L_0x06d0:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x06db
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x06e0
        L_0x06db:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x06e0:
            r3.zze(r4, r7)
            goto L_0x088c
        L_0x06e5:
            java.lang.String r4 = r5.readString()
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzfr> r1 = com.google.android.gms.internal.firebase_auth.zzfr.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r1)
            com.google.android.gms.internal.firebase_auth.zzfr r1 = (com.google.android.gms.internal.firebase_auth.zzfr) r1
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x06f8
            goto L_0x0708
        L_0x06f8:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x0703
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x0708
        L_0x0703:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x0708:
            r3.zza((java.lang.String) r4, (com.google.android.gms.internal.firebase_auth.zzfr) r1, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x070d:
            java.lang.String r4 = r5.readString()
            java.lang.String r1 = r5.readString()
            java.lang.String r2 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0720
            goto L_0x0730
        L_0x0720:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x072b
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x0730
        L_0x072b:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x0730:
            r3.zza(r4, r1, r2, r7)
            goto L_0x088c
        L_0x0735:
            java.lang.String r4 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0740
            goto L_0x0750
        L_0x0740:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x074b
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x0750
        L_0x074b:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x0750:
            r3.zzd(r4, r7)
            goto L_0x088c
        L_0x0755:
            java.lang.String r4 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0760
            goto L_0x0770
        L_0x0760:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x076b
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x0770
        L_0x076b:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x0770:
            r3.zzc(r4, r7)
            goto L_0x088c
        L_0x0775:
            java.lang.String r4 = r5.readString()
            java.lang.String r1 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0784
            goto L_0x0794
        L_0x0784:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x078f
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x0794
        L_0x078f:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x0794:
            r3.zzd(r4, r1, r7)
            goto L_0x088c
        L_0x0799:
            java.lang.String r4 = r5.readString()
            java.lang.String r1 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x07a8
            goto L_0x07b8
        L_0x07a8:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x07b3
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x07b8
        L_0x07b3:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x07b8:
            r3.zzc((java.lang.String) r4, (java.lang.String) r1, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x07bd:
            java.lang.String r4 = r5.readString()
            java.lang.String r1 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x07cc
            goto L_0x07dc
        L_0x07cc:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x07d7
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x07dc
        L_0x07d7:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x07dc:
            r3.zzb((java.lang.String) r4, (java.lang.String) r1, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x07e1:
            java.lang.String r4 = r5.readString()
            java.lang.String r1 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x07f0
            goto L_0x0800
        L_0x07f0:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x07fb
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x0800
        L_0x07fb:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x0800:
            r3.zza((java.lang.String) r4, (java.lang.String) r1, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x0805:
            java.lang.String r4 = r5.readString()
            android.os.Parcelable$Creator<com.google.firebase.auth.UserProfileChangeRequest> r1 = com.google.firebase.auth.UserProfileChangeRequest.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r1)
            com.google.firebase.auth.UserProfileChangeRequest r1 = (com.google.firebase.auth.UserProfileChangeRequest) r1
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0818
            goto L_0x0828
        L_0x0818:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x0823
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x0828
        L_0x0823:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x0828:
            r3.zza((java.lang.String) r4, (com.google.firebase.auth.UserProfileChangeRequest) r1, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x082c:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzfr> r4 = com.google.android.gms.internal.firebase_auth.zzfr.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzd.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzfr r4 = (com.google.android.gms.internal.firebase_auth.zzfr) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x083b
            goto L_0x084b
        L_0x083b:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x0846
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x084b
        L_0x0846:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x084b:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzfr) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
            goto L_0x088c
        L_0x084f:
            java.lang.String r4 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x085a
            goto L_0x086a
        L_0x085a:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x0865
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x086a
        L_0x0865:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x086a:
            r3.zzb(r4, r7)
            goto L_0x088c
        L_0x086e:
            java.lang.String r4 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0879
            goto L_0x0889
        L_0x0879:
            android.os.IInterface r7 = r5.queryLocalInterface(r0)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdz
            if (r0 == 0) goto L_0x0884
            com.google.firebase.auth.api.internal.zzdz r7 = (com.google.firebase.auth.api.internal.zzdz) r7
            goto L_0x0889
        L_0x0884:
            com.google.firebase.auth.api.internal.zzeb r7 = new com.google.firebase.auth.api.internal.zzeb
            r7.<init>(r5)
        L_0x0889:
            r3.zza((java.lang.String) r4, (com.google.firebase.auth.api.internal.zzdz) r7)
        L_0x088c:
            r6.writeNoException()
            r4 = 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.api.internal.zzed.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}

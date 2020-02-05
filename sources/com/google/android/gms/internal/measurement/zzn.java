package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.0.1 */
public abstract class zzn extends zza implements zzk {
    public zzn() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static zzk asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        if (queryLocalInterface instanceof zzk) {
            return (zzk) queryLocalInterface;
        }
        return new zzm(iBinder);
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v9, types: [com.google.android.gms.internal.measurement.zzp] */
    /* JADX WARNING: type inference failed for: r3v14, types: [com.google.android.gms.internal.measurement.zzp] */
    /* JADX WARNING: type inference failed for: r3v20, types: [com.google.android.gms.internal.measurement.zzp] */
    /* JADX WARNING: type inference failed for: r3v26, types: [com.google.android.gms.internal.measurement.zzp] */
    /* JADX WARNING: type inference failed for: r3v30, types: [com.google.android.gms.internal.measurement.zzp] */
    /* JADX WARNING: type inference failed for: r3v34, types: [com.google.android.gms.internal.measurement.zzv] */
    /* JADX WARNING: type inference failed for: r3v38, types: [com.google.android.gms.internal.measurement.zzp] */
    /* JADX WARNING: type inference failed for: r3v42, types: [com.google.android.gms.internal.measurement.zzp] */
    /* JADX WARNING: type inference failed for: r3v46, types: [com.google.android.gms.internal.measurement.zzp] */
    /* JADX WARNING: type inference failed for: r3v50, types: [com.google.android.gms.internal.measurement.zzp] */
    /* JADX WARNING: type inference failed for: r3v55, types: [com.google.android.gms.internal.measurement.zzp] */
    /* JADX WARNING: type inference failed for: r3v60, types: [com.google.android.gms.internal.measurement.zzp] */
    /* JADX WARNING: type inference failed for: r3v67, types: [com.google.android.gms.internal.measurement.zzq] */
    /* JADX WARNING: type inference failed for: r3v71, types: [com.google.android.gms.internal.measurement.zzq] */
    /* JADX WARNING: type inference failed for: r3v75, types: [com.google.android.gms.internal.measurement.zzq] */
    /* JADX WARNING: type inference failed for: r3v79, types: [com.google.android.gms.internal.measurement.zzp] */
    /* JADX WARNING: type inference failed for: r3v84, types: [com.google.android.gms.internal.measurement.zzp] */
    /* JADX WARNING: type inference failed for: r3v88 */
    /* JADX WARNING: type inference failed for: r3v89 */
    /* JADX WARNING: type inference failed for: r3v90 */
    /* JADX WARNING: type inference failed for: r3v91 */
    /* JADX WARNING: type inference failed for: r3v92 */
    /* JADX WARNING: type inference failed for: r3v93 */
    /* JADX WARNING: type inference failed for: r3v94 */
    /* JADX WARNING: type inference failed for: r3v95 */
    /* JADX WARNING: type inference failed for: r3v96 */
    /* JADX WARNING: type inference failed for: r3v97 */
    /* JADX WARNING: type inference failed for: r3v98 */
    /* JADX WARNING: type inference failed for: r3v99 */
    /* JADX WARNING: type inference failed for: r3v100 */
    /* JADX WARNING: type inference failed for: r3v101 */
    /* JADX WARNING: type inference failed for: r3v102 */
    /* JADX WARNING: type inference failed for: r3v103 */
    /* JADX WARNING: type inference failed for: r3v104 */
    /* JADX WARNING: type inference failed for: r3v105 */
    /* JADX WARNING: type inference failed for: r3v106 */
    /* JADX WARNING: type inference failed for: r3v107 */
    /* JADX WARNING: type inference failed for: r3v108 */
    /* JADX WARNING: type inference failed for: r3v109 */
    /* JADX WARNING: type inference failed for: r3v110 */
    /* JADX WARNING: type inference failed for: r3v111 */
    /* JADX WARNING: type inference failed for: r3v112 */
    /* JADX WARNING: type inference failed for: r3v113 */
    /* JADX WARNING: type inference failed for: r3v114 */
    /* JADX WARNING: type inference failed for: r3v115 */
    /* JADX WARNING: type inference failed for: r3v116 */
    /* JADX WARNING: type inference failed for: r3v117 */
    /* JADX WARNING: type inference failed for: r3v118 */
    /* JADX WARNING: type inference failed for: r3v119 */
    /* JADX WARNING: type inference failed for: r3v120 */
    /* JADX WARNING: type inference failed for: r3v121 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r11, android.os.Parcel r12, android.os.Parcel r13, int r14) throws android.os.RemoteException {
        /*
            r10 = this;
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IEventHandlerProxy"
            java.lang.String r2 = "com.google.android.gms.measurement.api.internal.IBundleReceiver"
            r3 = 0
            switch(r11) {
                case 1: goto L_0x03d7;
                case 2: goto L_0x03b6;
                case 3: goto L_0x0380;
                case 4: goto L_0x0362;
                case 5: goto L_0x0339;
                case 6: goto L_0x0318;
                case 7: goto L_0x030b;
                case 8: goto L_0x02fa;
                case 9: goto L_0x02e5;
                case 10: goto L_0x02c0;
                case 11: goto L_0x02b3;
                case 12: goto L_0x02aa;
                case 13: goto L_0x02a1;
                case 14: goto L_0x0298;
                case 15: goto L_0x027e;
                case 16: goto L_0x0261;
                case 17: goto L_0x0244;
                case 18: goto L_0x0225;
                case 19: goto L_0x0208;
                case 20: goto L_0x01eb;
                case 21: goto L_0x01ce;
                case 22: goto L_0x01b1;
                case 23: goto L_0x01a4;
                case 24: goto L_0x0197;
                case 25: goto L_0x0186;
                case 26: goto L_0x0175;
                case 27: goto L_0x015c;
                case 28: goto L_0x014b;
                case 29: goto L_0x013a;
                case 30: goto L_0x0129;
                case 31: goto L_0x0100;
                case 32: goto L_0x00d7;
                case 33: goto L_0x00b1;
                case 34: goto L_0x0094;
                case 35: goto L_0x0077;
                case 36: goto L_0x005a;
                case 37: goto L_0x0051;
                case 38: goto L_0x0030;
                case 39: goto L_0x0027;
                case 40: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            r0 = 0
            return r0
        L_0x000a:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x0011
            goto L_0x0022
        L_0x0011:
            android.os.IInterface r1 = r0.queryLocalInterface(r2)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzp
            if (r2 == 0) goto L_0x001d
            r3 = r1
            com.google.android.gms.internal.measurement.zzp r3 = (com.google.android.gms.internal.measurement.zzp) r3
            goto L_0x0022
        L_0x001d:
            com.google.android.gms.internal.measurement.zzr r3 = new com.google.android.gms.internal.measurement.zzr
            r3.<init>(r0)
        L_0x0022:
            r10.isDataCollectionEnabled(r3)
            goto L_0x03ee
        L_0x0027:
            boolean r0 = com.google.android.gms.internal.measurement.zzd.zza(r12)
            r10.setDataCollectionEnabled(r0)
            goto L_0x03ee
        L_0x0030:
            android.os.IBinder r1 = r12.readStrongBinder()
            if (r1 != 0) goto L_0x0037
            goto L_0x0048
        L_0x0037:
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzp
            if (r3 == 0) goto L_0x0043
            r3 = r2
            com.google.android.gms.internal.measurement.zzp r3 = (com.google.android.gms.internal.measurement.zzp) r3
            goto L_0x0048
        L_0x0043:
            com.google.android.gms.internal.measurement.zzr r3 = new com.google.android.gms.internal.measurement.zzr
            r3.<init>(r1)
        L_0x0048:
            int r0 = r12.readInt()
            r10.getTestFlag(r3, r0)
            goto L_0x03ee
        L_0x0051:
            java.util.HashMap r0 = com.google.android.gms.internal.measurement.zzd.zzb(r12)
            r10.initForTests(r0)
            goto L_0x03ee
        L_0x005a:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x0061
            goto L_0x0072
        L_0x0061:
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzq
            if (r2 == 0) goto L_0x006d
            r3 = r1
            com.google.android.gms.internal.measurement.zzq r3 = (com.google.android.gms.internal.measurement.zzq) r3
            goto L_0x0072
        L_0x006d:
            com.google.android.gms.internal.measurement.zzs r3 = new com.google.android.gms.internal.measurement.zzs
            r3.<init>(r0)
        L_0x0072:
            r10.unregisterOnMeasurementEventListener(r3)
            goto L_0x03ee
        L_0x0077:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x007e
            goto L_0x008f
        L_0x007e:
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzq
            if (r2 == 0) goto L_0x008a
            r3 = r1
            com.google.android.gms.internal.measurement.zzq r3 = (com.google.android.gms.internal.measurement.zzq) r3
            goto L_0x008f
        L_0x008a:
            com.google.android.gms.internal.measurement.zzs r3 = new com.google.android.gms.internal.measurement.zzs
            r3.<init>(r0)
        L_0x008f:
            r10.registerOnMeasurementEventListener(r3)
            goto L_0x03ee
        L_0x0094:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x009b
            goto L_0x00ac
        L_0x009b:
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzq
            if (r2 == 0) goto L_0x00a7
            r3 = r1
            com.google.android.gms.internal.measurement.zzq r3 = (com.google.android.gms.internal.measurement.zzq) r3
            goto L_0x00ac
        L_0x00a7:
            com.google.android.gms.internal.measurement.zzs r3 = new com.google.android.gms.internal.measurement.zzs
            r3.<init>(r0)
        L_0x00ac:
            r10.setEventInterceptor(r3)
            goto L_0x03ee
        L_0x00b1:
            int r1 = r12.readInt()
            java.lang.String r2 = r12.readString()
            android.os.IBinder r3 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            android.os.IBinder r4 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r4)
            android.os.IBinder r0 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            r0 = r10
            r0.logHealthData(r1, r2, r3, r4, r5)
            goto L_0x03ee
        L_0x00d7:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.measurement.zzd.zza((android.os.Parcel) r12, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            android.os.IBinder r4 = r12.readStrongBinder()
            if (r4 != 0) goto L_0x00e6
            goto L_0x00f7
        L_0x00e6:
            android.os.IInterface r2 = r4.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzp
            if (r3 == 0) goto L_0x00f2
            r3 = r2
            com.google.android.gms.internal.measurement.zzp r3 = (com.google.android.gms.internal.measurement.zzp) r3
            goto L_0x00f7
        L_0x00f2:
            com.google.android.gms.internal.measurement.zzr r3 = new com.google.android.gms.internal.measurement.zzr
            r3.<init>(r4)
        L_0x00f7:
            long r4 = r12.readLong()
            r10.performAction(r1, r3, r4)
            goto L_0x03ee
        L_0x0100:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            android.os.IBinder r4 = r12.readStrongBinder()
            if (r4 != 0) goto L_0x010f
            goto L_0x0120
        L_0x010f:
            android.os.IInterface r2 = r4.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzp
            if (r3 == 0) goto L_0x011b
            r3 = r2
            com.google.android.gms.internal.measurement.zzp r3 = (com.google.android.gms.internal.measurement.zzp) r3
            goto L_0x0120
        L_0x011b:
            com.google.android.gms.internal.measurement.zzr r3 = new com.google.android.gms.internal.measurement.zzr
            r3.<init>(r4)
        L_0x0120:
            long r4 = r12.readLong()
            r10.onActivitySaveInstanceState(r1, r3, r4)
            goto L_0x03ee
        L_0x0129:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r12.readLong()
            r10.onActivityResumed(r1, r2)
            goto L_0x03ee
        L_0x013a:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r12.readLong()
            r10.onActivityPaused(r1, r2)
            goto L_0x03ee
        L_0x014b:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r12.readLong()
            r10.onActivityDestroyed(r1, r2)
            goto L_0x03ee
        L_0x015c:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.zzd.zza((android.os.Parcel) r12, r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            long r3 = r12.readLong()
            r10.onActivityCreated(r1, r2, r3)
            goto L_0x03ee
        L_0x0175:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r12.readLong()
            r10.onActivityStopped(r1, r2)
            goto L_0x03ee
        L_0x0186:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r12.readLong()
            r10.onActivityStarted(r1, r2)
            goto L_0x03ee
        L_0x0197:
            java.lang.String r1 = r12.readString()
            long r2 = r12.readLong()
            r10.endAdUnitExposure(r1, r2)
            goto L_0x03ee
        L_0x01a4:
            java.lang.String r1 = r12.readString()
            long r2 = r12.readLong()
            r10.beginAdUnitExposure(r1, r2)
            goto L_0x03ee
        L_0x01b1:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x01b8
            goto L_0x01c9
        L_0x01b8:
            android.os.IInterface r1 = r0.queryLocalInterface(r2)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzp
            if (r2 == 0) goto L_0x01c4
            r3 = r1
            com.google.android.gms.internal.measurement.zzp r3 = (com.google.android.gms.internal.measurement.zzp) r3
            goto L_0x01c9
        L_0x01c4:
            com.google.android.gms.internal.measurement.zzr r3 = new com.google.android.gms.internal.measurement.zzr
            r3.<init>(r0)
        L_0x01c9:
            r10.generateEventId(r3)
            goto L_0x03ee
        L_0x01ce:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x01d5
            goto L_0x01e6
        L_0x01d5:
            android.os.IInterface r1 = r0.queryLocalInterface(r2)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzp
            if (r2 == 0) goto L_0x01e1
            r3 = r1
            com.google.android.gms.internal.measurement.zzp r3 = (com.google.android.gms.internal.measurement.zzp) r3
            goto L_0x01e6
        L_0x01e1:
            com.google.android.gms.internal.measurement.zzr r3 = new com.google.android.gms.internal.measurement.zzr
            r3.<init>(r0)
        L_0x01e6:
            r10.getGmpAppId(r3)
            goto L_0x03ee
        L_0x01eb:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x01f2
            goto L_0x0203
        L_0x01f2:
            android.os.IInterface r1 = r0.queryLocalInterface(r2)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzp
            if (r2 == 0) goto L_0x01fe
            r3 = r1
            com.google.android.gms.internal.measurement.zzp r3 = (com.google.android.gms.internal.measurement.zzp) r3
            goto L_0x0203
        L_0x01fe:
            com.google.android.gms.internal.measurement.zzr r3 = new com.google.android.gms.internal.measurement.zzr
            r3.<init>(r0)
        L_0x0203:
            r10.getAppInstanceId(r3)
            goto L_0x03ee
        L_0x0208:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x020f
            goto L_0x0220
        L_0x020f:
            android.os.IInterface r1 = r0.queryLocalInterface(r2)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzp
            if (r2 == 0) goto L_0x021b
            r3 = r1
            com.google.android.gms.internal.measurement.zzp r3 = (com.google.android.gms.internal.measurement.zzp) r3
            goto L_0x0220
        L_0x021b:
            com.google.android.gms.internal.measurement.zzr r3 = new com.google.android.gms.internal.measurement.zzr
            r3.<init>(r0)
        L_0x0220:
            r10.getCachedAppInstanceId(r3)
            goto L_0x03ee
        L_0x0225:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x022c
            goto L_0x023f
        L_0x022c:
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IStringProvider"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzv
            if (r2 == 0) goto L_0x023a
            r3 = r1
            com.google.android.gms.internal.measurement.zzv r3 = (com.google.android.gms.internal.measurement.zzv) r3
            goto L_0x023f
        L_0x023a:
            com.google.android.gms.internal.measurement.zzu r3 = new com.google.android.gms.internal.measurement.zzu
            r3.<init>(r0)
        L_0x023f:
            r10.setInstanceIdProvider(r3)
            goto L_0x03ee
        L_0x0244:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x024b
            goto L_0x025c
        L_0x024b:
            android.os.IInterface r1 = r0.queryLocalInterface(r2)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzp
            if (r2 == 0) goto L_0x0257
            r3 = r1
            com.google.android.gms.internal.measurement.zzp r3 = (com.google.android.gms.internal.measurement.zzp) r3
            goto L_0x025c
        L_0x0257:
            com.google.android.gms.internal.measurement.zzr r3 = new com.google.android.gms.internal.measurement.zzr
            r3.<init>(r0)
        L_0x025c:
            r10.getCurrentScreenClass(r3)
            goto L_0x03ee
        L_0x0261:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x0268
            goto L_0x0279
        L_0x0268:
            android.os.IInterface r1 = r0.queryLocalInterface(r2)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzp
            if (r2 == 0) goto L_0x0274
            r3 = r1
            com.google.android.gms.internal.measurement.zzp r3 = (com.google.android.gms.internal.measurement.zzp) r3
            goto L_0x0279
        L_0x0274:
            com.google.android.gms.internal.measurement.zzr r3 = new com.google.android.gms.internal.measurement.zzr
            r3.<init>(r0)
        L_0x0279:
            r10.getCurrentScreenName(r3)
            goto L_0x03ee
        L_0x027e:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            java.lang.String r2 = r12.readString()
            java.lang.String r3 = r12.readString()
            long r4 = r12.readLong()
            r0 = r10
            r0.setCurrentScreen(r1, r2, r3, r4)
            goto L_0x03ee
        L_0x0298:
            long r0 = r12.readLong()
            r10.setSessionTimeoutDuration(r0)
            goto L_0x03ee
        L_0x02a1:
            long r0 = r12.readLong()
            r10.setMinimumSessionDuration(r0)
            goto L_0x03ee
        L_0x02aa:
            long r0 = r12.readLong()
            r10.resetAnalyticsData(r0)
            goto L_0x03ee
        L_0x02b3:
            boolean r1 = com.google.android.gms.internal.measurement.zzd.zza(r12)
            long r2 = r12.readLong()
            r10.setMeasurementEnabled(r1, r2)
            goto L_0x03ee
        L_0x02c0:
            java.lang.String r1 = r12.readString()
            java.lang.String r4 = r12.readString()
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x02cf
            goto L_0x02e0
        L_0x02cf:
            android.os.IInterface r2 = r0.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzp
            if (r3 == 0) goto L_0x02db
            r3 = r2
            com.google.android.gms.internal.measurement.zzp r3 = (com.google.android.gms.internal.measurement.zzp) r3
            goto L_0x02e0
        L_0x02db:
            com.google.android.gms.internal.measurement.zzr r3 = new com.google.android.gms.internal.measurement.zzr
            r3.<init>(r0)
        L_0x02e0:
            r10.getConditionalUserProperties(r1, r4, r3)
            goto L_0x03ee
        L_0x02e5:
            java.lang.String r1 = r12.readString()
            java.lang.String r2 = r12.readString()
            android.os.Parcelable$Creator r3 = android.os.Bundle.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.measurement.zzd.zza((android.os.Parcel) r12, r3)
            android.os.Bundle r0 = (android.os.Bundle) r0
            r10.clearConditionalUserProperty(r1, r2, r0)
            goto L_0x03ee
        L_0x02fa:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.measurement.zzd.zza((android.os.Parcel) r12, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            long r2 = r12.readLong()
            r10.setConditionalUserProperty(r1, r2)
            goto L_0x03ee
        L_0x030b:
            java.lang.String r1 = r12.readString()
            long r2 = r12.readLong()
            r10.setUserId(r1, r2)
            goto L_0x03ee
        L_0x0318:
            java.lang.String r1 = r12.readString()
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x0323
            goto L_0x0334
        L_0x0323:
            android.os.IInterface r2 = r0.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzp
            if (r3 == 0) goto L_0x032f
            r3 = r2
            com.google.android.gms.internal.measurement.zzp r3 = (com.google.android.gms.internal.measurement.zzp) r3
            goto L_0x0334
        L_0x032f:
            com.google.android.gms.internal.measurement.zzr r3 = new com.google.android.gms.internal.measurement.zzr
            r3.<init>(r0)
        L_0x0334:
            r10.getMaxUserProperties(r1, r3)
            goto L_0x03ee
        L_0x0339:
            java.lang.String r1 = r12.readString()
            java.lang.String r4 = r12.readString()
            boolean r5 = com.google.android.gms.internal.measurement.zzd.zza(r12)
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x034c
            goto L_0x035d
        L_0x034c:
            android.os.IInterface r2 = r0.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzp
            if (r3 == 0) goto L_0x0358
            r3 = r2
            com.google.android.gms.internal.measurement.zzp r3 = (com.google.android.gms.internal.measurement.zzp) r3
            goto L_0x035d
        L_0x0358:
            com.google.android.gms.internal.measurement.zzr r3 = new com.google.android.gms.internal.measurement.zzr
            r3.<init>(r0)
        L_0x035d:
            r10.getUserProperties(r1, r4, r5, r3)
            goto L_0x03ee
        L_0x0362:
            java.lang.String r1 = r12.readString()
            java.lang.String r2 = r12.readString()
            android.os.IBinder r3 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            boolean r4 = com.google.android.gms.internal.measurement.zzd.zza(r12)
            long r5 = r12.readLong()
            r0 = r10
            r0.setUserProperty(r1, r2, r3, r4, r5)
            goto L_0x03ee
        L_0x0380:
            java.lang.String r1 = r12.readString()
            java.lang.String r4 = r12.readString()
            android.os.Parcelable$Creator r5 = android.os.Bundle.CREATOR
            android.os.Parcelable r5 = com.google.android.gms.internal.measurement.zzd.zza((android.os.Parcel) r12, r5)
            android.os.Bundle r5 = (android.os.Bundle) r5
            android.os.IBinder r6 = r12.readStrongBinder()
            if (r6 != 0) goto L_0x0398
            r6 = r3
            goto L_0x03a9
        L_0x0398:
            android.os.IInterface r2 = r6.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzp
            if (r3 == 0) goto L_0x03a3
            com.google.android.gms.internal.measurement.zzp r2 = (com.google.android.gms.internal.measurement.zzp) r2
            goto L_0x03a8
        L_0x03a3:
            com.google.android.gms.internal.measurement.zzr r2 = new com.google.android.gms.internal.measurement.zzr
            r2.<init>(r6)
        L_0x03a8:
            r6 = r2
        L_0x03a9:
            long r8 = r12.readLong()
            r0 = r10
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r8
            r0.logEventAndBundle(r1, r2, r3, r4, r5)
            goto L_0x03ee
        L_0x03b6:
            java.lang.String r1 = r12.readString()
            java.lang.String r2 = r12.readString()
            android.os.Parcelable$Creator r3 = android.os.Bundle.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.measurement.zzd.zza((android.os.Parcel) r12, r3)
            android.os.Bundle r3 = (android.os.Bundle) r3
            boolean r4 = com.google.android.gms.internal.measurement.zzd.zza(r12)
            boolean r5 = com.google.android.gms.internal.measurement.zzd.zza(r12)
            long r6 = r12.readLong()
            r0 = r10
            r0.logEvent(r1, r2, r3, r4, r5, r6)
            goto L_0x03ee
        L_0x03d7:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            android.os.Parcelable$Creator<com.google.android.gms.internal.measurement.zzx> r2 = com.google.android.gms.internal.measurement.zzx.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.zzd.zza((android.os.Parcel) r12, r2)
            com.google.android.gms.internal.measurement.zzx r2 = (com.google.android.gms.internal.measurement.zzx) r2
            long r3 = r12.readLong()
            r10.initialize(r1, r2, r3)
        L_0x03ee:
            r13.writeNoException()
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzn.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}

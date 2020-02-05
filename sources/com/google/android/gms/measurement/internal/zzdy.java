package com.google.android.gms.measurement.internal;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public final class zzdy<V> {
    private static final Object zzf = new Object();
    private final String zza;
    private final zzdz<V> zzb;
    private final V zzc;
    private final V zzd;
    private final Object zze;
    @GuardedBy("overrideLock")
    private volatile V zzg;
    @GuardedBy("cachingLock")
    private volatile V zzh;

    private zzdy(@NonNull String str, @NonNull V v, @NonNull V v2, @Nullable zzdz<V> zzdz) {
        this.zze = new Object();
        this.zzg = null;
        this.zzh = null;
        this.zza = str;
        this.zzc = v;
        this.zzd = v2;
        this.zzb = zzdz;
    }

    public final String zza() {
        return this.zza;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final V zza(@androidx.annotation.Nullable V r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.zze
            monitor-enter(r0)
            V r1 = r5.zzg     // Catch:{ all -> 0x0096 }
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            if (r6 == 0) goto L_0x0009
            return r6
        L_0x0009:
            com.google.android.gms.measurement.internal.zzr r6 = com.google.android.gms.measurement.internal.zzak.zza
            if (r6 != 0) goto L_0x0010
            V r6 = r5.zzc
            return r6
        L_0x0010:
            com.google.android.gms.measurement.internal.zzr r6 = com.google.android.gms.measurement.internal.zzak.zza
            java.lang.Object r6 = zzf
            monitor-enter(r6)
            boolean r0 = com.google.android.gms.measurement.internal.zzr.zza()     // Catch:{ all -> 0x0093 }
            if (r0 == 0) goto L_0x0026
            V r0 = r5.zzh     // Catch:{ all -> 0x0093 }
            if (r0 != 0) goto L_0x0022
            V r0 = r5.zzc     // Catch:{ all -> 0x0093 }
            goto L_0x0024
        L_0x0022:
            V r0 = r5.zzh     // Catch:{ all -> 0x0093 }
        L_0x0024:
            monitor-exit(r6)     // Catch:{ all -> 0x0093 }
            return r0
        L_0x0026:
            boolean r0 = com.google.android.gms.measurement.internal.zzr.zza()     // Catch:{ all -> 0x0093 }
            if (r0 != 0) goto L_0x008b
            com.google.android.gms.measurement.internal.zzr r0 = com.google.android.gms.measurement.internal.zzak.zza     // Catch:{ all -> 0x0093 }
            java.util.List r0 = com.google.android.gms.measurement.internal.zzak.zzcl     // Catch:{ SecurityException -> 0x006a }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ SecurityException -> 0x006a }
        L_0x0036:
            boolean r1 = r0.hasNext()     // Catch:{ SecurityException -> 0x006a }
            if (r1 == 0) goto L_0x006e
            java.lang.Object r1 = r0.next()     // Catch:{ SecurityException -> 0x006a }
            com.google.android.gms.measurement.internal.zzdy r1 = (com.google.android.gms.measurement.internal.zzdy) r1     // Catch:{ SecurityException -> 0x006a }
            java.lang.Object r2 = zzf     // Catch:{ SecurityException -> 0x006a }
            monitor-enter(r2)     // Catch:{ SecurityException -> 0x006a }
            boolean r3 = com.google.android.gms.measurement.internal.zzr.zza()     // Catch:{ all -> 0x0067 }
            if (r3 != 0) goto L_0x005f
            r3 = 0
            com.google.android.gms.measurement.internal.zzdz<V> r4 = r1.zzb     // Catch:{ IllegalStateException -> 0x005b }
            if (r4 == 0) goto L_0x0057
            com.google.android.gms.measurement.internal.zzdz<V> r4 = r1.zzb     // Catch:{ IllegalStateException -> 0x005b }
            java.lang.Object r4 = r4.zza()     // Catch:{ IllegalStateException -> 0x005b }
            goto L_0x0058
        L_0x0057:
            r4 = r3
        L_0x0058:
            r1.zzh = r4     // Catch:{ IllegalStateException -> 0x005b }
            goto L_0x005d
        L_0x005b:
            r1.zzh = r3     // Catch:{ all -> 0x0067 }
        L_0x005d:
            monitor-exit(r2)     // Catch:{ all -> 0x0067 }
            goto L_0x0036
        L_0x005f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0067 }
            java.lang.String r1 = "Refreshing flag cache must be done on a worker thread."
            r0.<init>(r1)     // Catch:{ all -> 0x0067 }
            throw r0     // Catch:{ all -> 0x0067 }
        L_0x0067:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0067 }
            throw r0     // Catch:{ SecurityException -> 0x006a }
        L_0x006a:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzak.zza((java.lang.Exception) r0)     // Catch:{ all -> 0x0093 }
        L_0x006e:
            monitor-exit(r6)     // Catch:{ all -> 0x0093 }
            com.google.android.gms.measurement.internal.zzdz<V> r6 = r5.zzb
            if (r6 != 0) goto L_0x0078
            com.google.android.gms.measurement.internal.zzr r6 = com.google.android.gms.measurement.internal.zzak.zza
            V r6 = r5.zzc
            return r6
        L_0x0078:
            java.lang.Object r6 = r6.zza()     // Catch:{ SecurityException -> 0x0082, IllegalStateException -> 0x007d }
            return r6
        L_0x007d:
            com.google.android.gms.measurement.internal.zzr r6 = com.google.android.gms.measurement.internal.zzak.zza
            V r6 = r5.zzc
            return r6
        L_0x0082:
            r6 = move-exception
            com.google.android.gms.measurement.internal.zzak.zza((java.lang.Exception) r6)
            com.google.android.gms.measurement.internal.zzr r6 = com.google.android.gms.measurement.internal.zzak.zza
            V r6 = r5.zzc
            return r6
        L_0x008b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0093 }
            java.lang.String r1 = "Tried to refresh flag cache on main thread or on package side."
            r0.<init>(r1)     // Catch:{ all -> 0x0093 }
            throw r0     // Catch:{ all -> 0x0093 }
        L_0x0093:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0093 }
            throw r0
        L_0x0096:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            goto L_0x009a
        L_0x0099:
            throw r6
        L_0x009a:
            goto L_0x0099
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzdy.zza(java.lang.Object):java.lang.Object");
    }
}

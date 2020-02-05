package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.List;
import java.util.Map;

interface zzhv {
    int getTag();

    double readDouble() throws IOException;

    float readFloat() throws IOException;

    String readString() throws IOException;

    void readStringList(List<String> list) throws IOException;

    <T> T zza(zzhw<T> zzhw, zzfk zzfk) throws IOException;

    <T> T zza(Class<T> cls, zzfk zzfk) throws IOException;

    void zza(List<Double> list) throws IOException;

    <T> void zza(List<T> list, zzhw<T> zzhw, zzfk zzfk) throws IOException;

    <K, V> void zza(Map<K, V> map, zzgy<K, V> zzgy, zzfk zzfk) throws IOException;

    @Deprecated
    <T> T zzb(Class<T> cls, zzfk zzfk) throws IOException;

    void zzb(List<Float> list) throws IOException;

    @Deprecated
    <T> void zzb(List<T> list, zzhw<T> zzhw, zzfk zzfk) throws IOException;

    @Deprecated
    <T> T zzc(zzhw<T> zzhw, zzfk zzfk) throws IOException;

    void zzc(List<Long> list) throws IOException;

    int zzcn() throws IOException;

    boolean zzco() throws IOException;

    long zzcp() throws IOException;

    long zzcq() throws IOException;

    int zzcr() throws IOException;

    long zzcs() throws IOException;

    int zzct() throws IOException;

    boolean zzcu() throws IOException;

    String zzcv() throws IOException;

    zzeo zzcw() throws IOException;

    int zzcx() throws IOException;

    int zzcy() throws IOException;

    int zzcz() throws IOException;

    void zzd(List<Long> list) throws IOException;

    long zzda() throws IOException;

    int zzdb() throws IOException;

    long zzdc() throws IOException;

    void zze(List<Integer> list) throws IOException;

    void zzf(List<Long> list) throws IOException;

    void zzg(List<Integer> list) throws IOException;

    void zzh(List<Boolean> list) throws IOException;

    void zzi(List<String> list) throws IOException;

    void zzj(List<zzeo> list) throws IOException;

    void zzk(List<Integer> list) throws IOException;

    void zzl(List<Integer> list) throws IOException;

    void zzm(List<Integer> list) throws IOException;

    void zzn(List<Long> list) throws IOException;

    void zzo(List<Integer> list) throws IOException;

    void zzp(List<Long> list) throws IOException;
}

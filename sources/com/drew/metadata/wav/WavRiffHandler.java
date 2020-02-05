package com.drew.metadata.wav;

import com.drew.imaging.riff.RiffHandler;
import com.drew.lang.annotations.NotNull;
import com.drew.metadata.Metadata;

public class WavRiffHandler implements RiffHandler {
    @NotNull
    private String _currentList = "";
    @NotNull
    private final WavDirectory _directory = new WavDirectory();

    public WavRiffHandler(@NotNull Metadata metadata) {
        metadata.addDirectory(this._directory);
    }

    public boolean shouldAcceptRiffIdentifier(@NotNull String str) {
        return str.equals(WavDirectory.FORMAT);
    }

    public boolean shouldAcceptChunk(@NotNull String str) {
        return str.equals(WavDirectory.CHUNK_FORMAT) || (this._currentList.equals(WavDirectory.LIST_INFO) && WavDirectory._tagIntegerMap.containsKey(str)) || str.equals("data");
    }

    public boolean shouldAcceptList(@NotNull String str) {
        if (str.equals(WavDirectory.LIST_INFO)) {
            this._currentList = WavDirectory.LIST_INFO;
            return true;
        }
        this._currentList = "";
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:17|18|19|20|21|22|23|24|25|34) */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x00f9 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processChunk(@com.drew.lang.annotations.NotNull java.lang.String r11, @com.drew.lang.annotations.NotNull byte[] r12) {
        /*
            r10 = this;
            java.lang.String r0 = "fmt "
            boolean r0 = r11.equals(r0)     // Catch:{ IOException -> 0x0126 }
            r1 = 3
            r2 = 2
            r3 = 4
            r4 = 0
            r5 = 1
            if (r0 == 0) goto L_0x0089
            com.drew.lang.ByteArrayReader r11 = new com.drew.lang.ByteArrayReader     // Catch:{ IOException -> 0x0126 }
            r11.<init>(r12)     // Catch:{ IOException -> 0x0126 }
            r11.setMotorolaByteOrder(r4)     // Catch:{ IOException -> 0x0126 }
            short r12 = r11.getInt16(r4)     // Catch:{ IOException -> 0x0126 }
            short r0 = r11.getInt16(r2)     // Catch:{ IOException -> 0x0126 }
            int r4 = r11.getInt32(r3)     // Catch:{ IOException -> 0x0126 }
            r6 = 8
            int r6 = r11.getInt32(r6)     // Catch:{ IOException -> 0x0126 }
            r7 = 12
            short r7 = r11.getInt16(r7)     // Catch:{ IOException -> 0x0126 }
            if (r12 == r5) goto L_0x0055
            java.util.HashMap<java.lang.Integer, java.lang.String> r11 = com.drew.metadata.wav.WavDirectory._audioEncodingMap     // Catch:{ IOException -> 0x0126 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r12)     // Catch:{ IOException -> 0x0126 }
            boolean r11 = r11.containsKey(r8)     // Catch:{ IOException -> 0x0126 }
            if (r11 == 0) goto L_0x004d
            com.drew.metadata.wav.WavDirectory r11 = r10._directory     // Catch:{ IOException -> 0x0126 }
            java.util.HashMap<java.lang.Integer, java.lang.String> r8 = com.drew.metadata.wav.WavDirectory._audioEncodingMap     // Catch:{ IOException -> 0x0126 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ IOException -> 0x0126 }
            java.lang.Object r12 = r8.get(r12)     // Catch:{ IOException -> 0x0126 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ IOException -> 0x0126 }
            r11.setString(r5, r12)     // Catch:{ IOException -> 0x0126 }
            goto L_0x0072
        L_0x004d:
            com.drew.metadata.wav.WavDirectory r11 = r10._directory     // Catch:{ IOException -> 0x0126 }
            java.lang.String r12 = "Unknown"
            r11.setString(r5, r12)     // Catch:{ IOException -> 0x0126 }
            goto L_0x0072
        L_0x0055:
            r8 = 14
            short r11 = r11.getInt16(r8)     // Catch:{ IOException -> 0x0126 }
            com.drew.metadata.wav.WavDirectory r8 = r10._directory     // Catch:{ IOException -> 0x0126 }
            r9 = 6
            r8.setInt(r9, r11)     // Catch:{ IOException -> 0x0126 }
            com.drew.metadata.wav.WavDirectory r11 = r10._directory     // Catch:{ IOException -> 0x0126 }
            java.util.HashMap<java.lang.Integer, java.lang.String> r8 = com.drew.metadata.wav.WavDirectory._audioEncodingMap     // Catch:{ IOException -> 0x0126 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ IOException -> 0x0126 }
            java.lang.Object r12 = r8.get(r12)     // Catch:{ IOException -> 0x0126 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ IOException -> 0x0126 }
            r11.setString(r5, r12)     // Catch:{ IOException -> 0x0126 }
        L_0x0072:
            com.drew.metadata.wav.WavDirectory r11 = r10._directory     // Catch:{ IOException -> 0x0126 }
            r11.setInt(r2, r0)     // Catch:{ IOException -> 0x0126 }
            com.drew.metadata.wav.WavDirectory r11 = r10._directory     // Catch:{ IOException -> 0x0126 }
            r11.setInt(r1, r4)     // Catch:{ IOException -> 0x0126 }
            com.drew.metadata.wav.WavDirectory r11 = r10._directory     // Catch:{ IOException -> 0x0126 }
            r11.setInt(r3, r6)     // Catch:{ IOException -> 0x0126 }
            com.drew.metadata.wav.WavDirectory r11 = r10._directory     // Catch:{ IOException -> 0x0126 }
            r12 = 5
            r11.setInt(r12, r7)     // Catch:{ IOException -> 0x0126 }
            goto L_0x0130
        L_0x0089:
            java.lang.String r0 = "data"
            boolean r0 = r11.equals(r0)     // Catch:{ IOException -> 0x0126 }
            if (r0 == 0) goto L_0x0101
            com.drew.metadata.wav.WavDirectory r11 = r10._directory     // Catch:{ MetadataException -> 0x00f9 }
            boolean r11 = r11.containsTag(r3)     // Catch:{ MetadataException -> 0x00f9 }
            if (r11 == 0) goto L_0x0130
            int r11 = r12.length     // Catch:{ MetadataException -> 0x00f9 }
            double r11 = (double) r11     // Catch:{ MetadataException -> 0x00f9 }
            com.drew.metadata.wav.WavDirectory r0 = r10._directory     // Catch:{ MetadataException -> 0x00f9 }
            double r6 = r0.getDouble(r3)     // Catch:{ MetadataException -> 0x00f9 }
            java.lang.Double.isNaN(r11)
            double r11 = r11 / r6
            int r0 = (int) r11
            r6 = 4611686018427387904(0x4000000000000000, double:2.0)
            r8 = 4633641066610819072(0x404e000000000000, double:60.0)
            double r6 = java.lang.Math.pow(r8, r6)     // Catch:{ MetadataException -> 0x00f9 }
            int r3 = (int) r6     // Catch:{ MetadataException -> 0x00f9 }
            int r3 = r0 / r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ MetadataException -> 0x00f9 }
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r6 = java.lang.Math.pow(r8, r6)     // Catch:{ MetadataException -> 0x00f9 }
            int r6 = (int) r6     // Catch:{ MetadataException -> 0x00f9 }
            int r0 = r0 / r6
            int r6 = r3.intValue()     // Catch:{ MetadataException -> 0x00f9 }
            int r6 = r6 * 60
            int r0 = r0 - r6
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ MetadataException -> 0x00f9 }
            r6 = 0
            double r6 = java.lang.Math.pow(r8, r6)     // Catch:{ MetadataException -> 0x00f9 }
            double r11 = r11 / r6
            int r6 = r0.intValue()     // Catch:{ MetadataException -> 0x00f9 }
            int r6 = r6 * 60
            double r6 = (double) r6
            java.lang.Double.isNaN(r6)
            double r11 = r11 - r6
            long r11 = java.lang.Math.round(r11)     // Catch:{ MetadataException -> 0x00f9 }
            int r12 = (int) r11     // Catch:{ MetadataException -> 0x00f9 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r12)     // Catch:{ MetadataException -> 0x00f9 }
            java.lang.String r12 = "%1$02d:%2$02d:%3$02d"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ MetadataException -> 0x00f9 }
            r1[r4] = r3     // Catch:{ MetadataException -> 0x00f9 }
            r1[r5] = r0     // Catch:{ MetadataException -> 0x00f9 }
            r1[r2] = r11     // Catch:{ MetadataException -> 0x00f9 }
            java.lang.String r11 = java.lang.String.format(r12, r1)     // Catch:{ MetadataException -> 0x00f9 }
            com.drew.metadata.wav.WavDirectory r12 = r10._directory     // Catch:{ MetadataException -> 0x00f9 }
            r0 = 16
            r12.setString(r0, r11)     // Catch:{ MetadataException -> 0x00f9 }
            goto L_0x0130
        L_0x00f9:
            com.drew.metadata.wav.WavDirectory r11 = r10._directory     // Catch:{ IOException -> 0x0126 }
            java.lang.String r12 = "Error calculating duration: bytes per second not found"
            r11.addError(r12)     // Catch:{ IOException -> 0x0126 }
            goto L_0x0130
        L_0x0101:
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = com.drew.metadata.wav.WavDirectory._tagIntegerMap     // Catch:{ IOException -> 0x0126 }
            boolean r0 = r0.containsKey(r11)     // Catch:{ IOException -> 0x0126 }
            if (r0 == 0) goto L_0x0130
            com.drew.metadata.wav.WavDirectory r0 = r10._directory     // Catch:{ IOException -> 0x0126 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = com.drew.metadata.wav.WavDirectory._tagIntegerMap     // Catch:{ IOException -> 0x0126 }
            java.lang.Object r11 = r1.get(r11)     // Catch:{ IOException -> 0x0126 }
            java.lang.Integer r11 = (java.lang.Integer) r11     // Catch:{ IOException -> 0x0126 }
            int r11 = r11.intValue()     // Catch:{ IOException -> 0x0126 }
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x0126 }
            r1.<init>(r12)     // Catch:{ IOException -> 0x0126 }
            int r12 = r12.length     // Catch:{ IOException -> 0x0126 }
            int r12 = r12 - r5
            java.lang.String r12 = r1.substring(r4, r12)     // Catch:{ IOException -> 0x0126 }
            r0.setString(r11, r12)     // Catch:{ IOException -> 0x0126 }
            goto L_0x0130
        L_0x0126:
            r11 = move-exception
            com.drew.metadata.wav.WavDirectory r12 = r10._directory
            java.lang.String r11 = r11.getMessage()
            r12.addError(r11)
        L_0x0130:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.drew.metadata.wav.WavRiffHandler.processChunk(java.lang.String, byte[]):void");
    }
}

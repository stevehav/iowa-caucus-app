package com.drew.metadata.avi;

import com.drew.imaging.riff.RiffHandler;
import com.drew.lang.ByteArrayReader;
import com.drew.lang.annotations.NotNull;
import com.drew.metadata.Metadata;
import java.io.IOException;

public class AviRiffHandler implements RiffHandler {
    @NotNull
    private final AviDirectory _directory = new AviDirectory();

    public AviRiffHandler(@NotNull Metadata metadata) {
        metadata.addDirectory(this._directory);
    }

    public boolean shouldAcceptRiffIdentifier(@NotNull String str) {
        return str.equals(AviDirectory.FORMAT);
    }

    public boolean shouldAcceptChunk(@NotNull String str) {
        return str.equals(AviDirectory.CHUNK_STREAM_HEADER) || str.equals(AviDirectory.CHUNK_MAIN_HEADER);
    }

    public boolean shouldAcceptList(@NotNull String str) {
        return str.equals(AviDirectory.LIST_HEADER) || str.equals(AviDirectory.LIST_STREAM_HEADER) || str.equals(AviDirectory.FORMAT);
    }

    public void processChunk(@NotNull String str, @NotNull byte[] bArr) {
        try {
            if (str.equals(AviDirectory.CHUNK_STREAM_HEADER)) {
                ByteArrayReader byteArrayReader = new ByteArrayReader(bArr);
                byteArrayReader.setMotorolaByteOrder(false);
                String str2 = new String(byteArrayReader.getBytes(0, 4));
                String str3 = new String(byteArrayReader.getBytes(4, 4));
                float float32 = byteArrayReader.getFloat32(20);
                float float322 = byteArrayReader.getFloat32(24);
                int int32 = byteArrayReader.getInt32(32);
                if (str2.equals("vids")) {
                    if (!this._directory.containsTag(1)) {
                        float f = float322 / float32;
                        this._directory.setDouble(1, (double) f);
                        double d = (double) (((float) int32) / f);
                        int i = (int) d;
                        Integer valueOf = Integer.valueOf(i / ((int) Math.pow(60.0d, 2.0d)));
                        Integer valueOf2 = Integer.valueOf((i / ((int) Math.pow(60.0d, 1.0d))) - (valueOf.intValue() * 60));
                        double pow = Math.pow(60.0d, 0.0d);
                        Double.isNaN(d);
                        double d2 = d / pow;
                        double intValue = (double) (valueOf2.intValue() * 60);
                        Double.isNaN(intValue);
                        this._directory.setString(3, String.format("%1$02d:%2$02d:%3$02d", new Object[]{valueOf, valueOf2, Integer.valueOf((int) Math.round(d2 - intValue))}));
                        this._directory.setString(4, str3);
                    }
                } else if (str2.equals("auds") && !this._directory.containsTag(2)) {
                    this._directory.setDouble(2, (double) (float322 / float32));
                }
            } else if (str.equals(AviDirectory.CHUNK_MAIN_HEADER)) {
                ByteArrayReader byteArrayReader2 = new ByteArrayReader(bArr);
                byteArrayReader2.setMotorolaByteOrder(false);
                int int322 = byteArrayReader2.getInt32(24);
                int int323 = byteArrayReader2.getInt32(32);
                int int324 = byteArrayReader2.getInt32(36);
                this._directory.setInt(6, int323);
                this._directory.setInt(7, int324);
                this._directory.setInt(8, int322);
            }
        } catch (IOException e) {
            this._directory.addError(e.getMessage());
        }
    }
}

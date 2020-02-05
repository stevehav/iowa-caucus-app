package com.facebook.react.devsupport;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

public class MultipartStreamReader {
    private static final String CRLF = "\r\n";
    private final String mBoundary;
    private long mLastProgressEvent;
    private final BufferedSource mSource;

    public interface ChunkListener {
        void onChunkComplete(Map<String, String> map, Buffer buffer, boolean z) throws IOException;

        void onChunkProgress(Map<String, String> map, long j, long j2) throws IOException;
    }

    public MultipartStreamReader(BufferedSource bufferedSource, String str) {
        this.mSource = bufferedSource;
        this.mBoundary = str;
    }

    private Map<String, String> parseHeaders(Buffer buffer) {
        HashMap hashMap = new HashMap();
        for (String str : buffer.readUtf8().split(CRLF)) {
            int indexOf = str.indexOf(":");
            if (indexOf != -1) {
                hashMap.put(str.substring(0, indexOf).trim(), str.substring(indexOf + 1).trim());
            }
        }
        return hashMap;
    }

    private void emitChunk(Buffer buffer, boolean z, ChunkListener chunkListener) throws IOException {
        ByteString encodeUtf8 = ByteString.encodeUtf8("\r\n\r\n");
        long indexOf = buffer.indexOf(encodeUtf8);
        if (indexOf == -1) {
            chunkListener.onChunkComplete((Map<String, String>) null, buffer, z);
            return;
        }
        Buffer buffer2 = new Buffer();
        Buffer buffer3 = new Buffer();
        buffer.read(buffer2, indexOf);
        buffer.skip((long) encodeUtf8.size());
        buffer.readAll(buffer3);
        chunkListener.onChunkComplete(parseHeaders(buffer2), buffer3, z);
    }

    private void emitProgress(Map<String, String> map, long j, boolean z, ChunkListener chunkListener) throws IOException {
        if (map != null && chunkListener != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastProgressEvent > 16 || z) {
                this.mLastProgressEvent = currentTimeMillis;
                chunkListener.onChunkProgress(map, j, map.get(HttpHeaders.CONTENT_LENGTH) != null ? Long.parseLong(map.get(HttpHeaders.CONTENT_LENGTH)) : 0);
            }
        }
    }

    public boolean readAllParts(ChunkListener chunkListener) throws IOException {
        boolean z;
        ByteString encodeUtf8 = ByteString.encodeUtf8("\r\n--" + this.mBoundary + CRLF);
        ByteString encodeUtf82 = ByteString.encodeUtf8("\r\n--" + this.mBoundary + "--" + CRLF);
        ByteString encodeUtf83 = ByteString.encodeUtf8("\r\n\r\n");
        Buffer buffer = new Buffer();
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        Map<String, String> map = null;
        while (true) {
            long max = Math.max(j - ((long) encodeUtf82.size()), j2);
            long indexOf = buffer.indexOf(encodeUtf8, max);
            if (indexOf == -1) {
                indexOf = buffer.indexOf(encodeUtf82, max);
                z = true;
            } else {
                z = false;
            }
            if (indexOf == -1) {
                long size = buffer.size();
                if (map == null) {
                    long indexOf2 = buffer.indexOf(encodeUtf83, max);
                    if (indexOf2 >= 0) {
                        this.mSource.read(buffer, indexOf2);
                        Buffer buffer2 = new Buffer();
                        buffer.copyTo(buffer2, max, indexOf2 - max);
                        j3 = buffer2.size() + ((long) encodeUtf83.size());
                        map = parseHeaders(buffer2);
                    }
                } else {
                    emitProgress(map, buffer.size() - j3, false, chunkListener);
                }
                if (this.mSource.read(buffer, (long) 4096) <= 0) {
                    return false;
                }
                j = size;
            } else {
                long j4 = indexOf - j2;
                if (j2 > 0) {
                    Buffer buffer3 = new Buffer();
                    buffer.skip(j2);
                    buffer.read(buffer3, j4);
                    emitProgress(map, buffer3.size() - j3, true, chunkListener);
                    emitChunk(buffer3, z, chunkListener);
                    j3 = 0;
                    map = null;
                } else {
                    ChunkListener chunkListener2 = chunkListener;
                    buffer.skip(indexOf);
                }
                if (z) {
                    return true;
                }
                j2 = (long) encodeUtf8.size();
                j = j2;
            }
        }
    }
}

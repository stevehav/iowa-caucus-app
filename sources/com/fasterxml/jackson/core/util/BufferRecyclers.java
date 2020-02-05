package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.io.JsonStringEncoder;
import java.lang.ref.SoftReference;

public class BufferRecyclers {
    public static final String SYSTEM_PROPERTY_TRACK_REUSABLE_BUFFERS = "com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers";
    private static final ThreadLocalBufferManager _bufferRecyclerTracker;
    protected static final ThreadLocal<SoftReference<JsonStringEncoder>> _encoderRef = new ThreadLocal<>();
    protected static final ThreadLocal<SoftReference<BufferRecycler>> _recyclerRef = new ThreadLocal<>();

    static {
        ThreadLocalBufferManager threadLocalBufferManager;
        if ("true".equals(System.getProperty(SYSTEM_PROPERTY_TRACK_REUSABLE_BUFFERS))) {
            threadLocalBufferManager = ThreadLocalBufferManager.instance();
        } else {
            threadLocalBufferManager = null;
        }
        _bufferRecyclerTracker = threadLocalBufferManager;
    }

    public static BufferRecycler getBufferRecycler() {
        BufferRecycler bufferRecycler;
        SoftReference<BufferRecycler> softReference;
        SoftReference softReference2 = _recyclerRef.get();
        if (softReference2 == null) {
            bufferRecycler = null;
        } else {
            bufferRecycler = (BufferRecycler) softReference2.get();
        }
        if (bufferRecycler == null) {
            bufferRecycler = new BufferRecycler();
            ThreadLocalBufferManager threadLocalBufferManager = _bufferRecyclerTracker;
            if (threadLocalBufferManager != null) {
                softReference = threadLocalBufferManager.wrapAndTrack(bufferRecycler);
            } else {
                softReference = new SoftReference<>(bufferRecycler);
            }
            _recyclerRef.set(softReference);
        }
        return bufferRecycler;
    }

    public static int releaseBuffers() {
        ThreadLocalBufferManager threadLocalBufferManager = _bufferRecyclerTracker;
        if (threadLocalBufferManager != null) {
            return threadLocalBufferManager.releaseBuffers();
        }
        return -1;
    }

    public static JsonStringEncoder getJsonStringEncoder() {
        JsonStringEncoder jsonStringEncoder;
        SoftReference softReference = _encoderRef.get();
        if (softReference == null) {
            jsonStringEncoder = null;
        } else {
            jsonStringEncoder = (JsonStringEncoder) softReference.get();
        }
        if (jsonStringEncoder != null) {
            return jsonStringEncoder;
        }
        JsonStringEncoder jsonStringEncoder2 = new JsonStringEncoder();
        _encoderRef.set(new SoftReference(jsonStringEncoder2));
        return jsonStringEncoder2;
    }

    public static byte[] encodeAsUTF8(String str) {
        return getJsonStringEncoder().encodeAsUTF8(str);
    }

    public static char[] quoteAsJsonText(String str) {
        return getJsonStringEncoder().quoteAsString(str);
    }

    public static void quoteAsJsonText(CharSequence charSequence, StringBuilder sb) {
        getJsonStringEncoder().quoteAsString(charSequence, sb);
    }

    public static byte[] quoteAsJsonUTF8(String str) {
        return getJsonStringEncoder().quoteAsUTF8(str);
    }
}

package io.grpc.okhttp;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.Header;
import io.grpc.okhttp.internal.framed.Settings;
import io.sentry.marshaller.json.JsonMarshaller;
import java.util.EnumMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.ByteString;

class OkHttpFrameLogger {
    private static final int BUFFER_LENGTH_THRESHOLD = 64;
    private final Level level;
    private final Logger logger;

    enum Direction {
        INBOUND,
        OUTBOUND
    }

    OkHttpFrameLogger(Level level2, Class<?> cls) {
        this(level2, Logger.getLogger(cls.getName()));
    }

    @VisibleForTesting
    OkHttpFrameLogger(Level level2, Logger logger2) {
        this.level = (Level) Preconditions.checkNotNull(level2, "level");
        this.logger = (Logger) Preconditions.checkNotNull(logger2, JsonMarshaller.LOGGER);
    }

    private static String toString(Settings settings) {
        EnumMap enumMap = new EnumMap(SettingParams.class);
        for (SettingParams settingParams : SettingParams.values()) {
            if (settings.isSet(settingParams.getBit())) {
                enumMap.put(settingParams, Integer.valueOf(settings.get(settingParams.getBit())));
            }
        }
        return enumMap.toString();
    }

    private static String toString(Buffer buffer) {
        if (buffer.size() <= 64) {
            return buffer.snapshot().hex();
        }
        int min = (int) Math.min(buffer.size(), 64);
        return buffer.snapshot(min).hex() + "...";
    }

    private boolean isEnabled() {
        return this.logger.isLoggable(this.level);
    }

    /* access modifiers changed from: package-private */
    public void logData(Direction direction, int i, Buffer buffer, int i2, boolean z) {
        if (isEnabled()) {
            Logger logger2 = this.logger;
            Level level2 = this.level;
            logger2.log(level2, direction + " DATA: streamId=" + i + " endStream=" + z + " length=" + i2 + " bytes=" + toString(buffer));
        }
    }

    /* access modifiers changed from: package-private */
    public void logHeaders(Direction direction, int i, List<Header> list, boolean z) {
        if (isEnabled()) {
            Logger logger2 = this.logger;
            Level level2 = this.level;
            logger2.log(level2, direction + " HEADERS: streamId=" + i + " headers=" + list + " endStream=" + z);
        }
    }

    public void logPriority(Direction direction, int i, int i2, int i3, boolean z) {
        if (isEnabled()) {
            Logger logger2 = this.logger;
            Level level2 = this.level;
            logger2.log(level2, direction + " PRIORITY: streamId=" + i + " streamDependency=" + i2 + " weight=" + i3 + " exclusive=" + z);
        }
    }

    /* access modifiers changed from: package-private */
    public void logRstStream(Direction direction, int i, ErrorCode errorCode) {
        if (isEnabled()) {
            Logger logger2 = this.logger;
            Level level2 = this.level;
            logger2.log(level2, direction + " RST_STREAM: streamId=" + i + " errorCode=" + errorCode);
        }
    }

    /* access modifiers changed from: package-private */
    public void logSettingsAck(Direction direction) {
        if (isEnabled()) {
            Logger logger2 = this.logger;
            Level level2 = this.level;
            logger2.log(level2, direction + " SETTINGS: ack=true");
        }
    }

    /* access modifiers changed from: package-private */
    public void logSettings(Direction direction, Settings settings) {
        if (isEnabled()) {
            Logger logger2 = this.logger;
            Level level2 = this.level;
            logger2.log(level2, direction + " SETTINGS: ack=false settings=" + toString(settings));
        }
    }

    /* access modifiers changed from: package-private */
    public void logPing(Direction direction, long j) {
        if (isEnabled()) {
            Logger logger2 = this.logger;
            Level level2 = this.level;
            logger2.log(level2, direction + " PING: ack=false bytes=" + j);
        }
    }

    /* access modifiers changed from: package-private */
    public void logPingAck(Direction direction, long j) {
        if (isEnabled()) {
            Logger logger2 = this.logger;
            Level level2 = this.level;
            logger2.log(level2, direction + " PING: ack=true bytes=" + j);
        }
    }

    /* access modifiers changed from: package-private */
    public void logPushPromise(Direction direction, int i, int i2, List<Header> list) {
        if (isEnabled()) {
            Logger logger2 = this.logger;
            Level level2 = this.level;
            logger2.log(level2, direction + " PUSH_PROMISE: streamId=" + i + " promisedStreamId=" + i2 + " headers=" + list);
        }
    }

    /* access modifiers changed from: package-private */
    public void logGoAway(Direction direction, int i, ErrorCode errorCode, ByteString byteString) {
        if (isEnabled()) {
            Logger logger2 = this.logger;
            Level level2 = this.level;
            logger2.log(level2, direction + " GO_AWAY: lastStreamId=" + i + " errorCode=" + errorCode + " length=" + byteString.size() + " bytes=" + toString(new Buffer().write(byteString)));
        }
    }

    /* access modifiers changed from: package-private */
    public void logWindowsUpdate(Direction direction, int i, long j) {
        if (isEnabled()) {
            Logger logger2 = this.logger;
            Level level2 = this.level;
            logger2.log(level2, direction + " WINDOW_UPDATE: streamId=" + i + " windowSizeIncrement=" + j);
        }
    }

    private enum SettingParams {
        HEADER_TABLE_SIZE(1),
        ENABLE_PUSH(2),
        MAX_CONCURRENT_STREAMS(4),
        MAX_FRAME_SIZE(5),
        MAX_HEADER_LIST_SIZE(6),
        INITIAL_WINDOW_SIZE(7);
        
        private final int bit;

        private SettingParams(int i) {
            this.bit = i;
        }

        public int getBit() {
            return this.bit;
        }
    }
}

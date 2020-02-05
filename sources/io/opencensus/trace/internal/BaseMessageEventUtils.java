package io.opencensus.trace.internal;

import androidx.core.app.NotificationCompat;
import io.opencensus.internal.Utils;
import io.opencensus.trace.BaseMessageEvent;
import io.opencensus.trace.MessageEvent;
import io.opencensus.trace.NetworkEvent;

public final class BaseMessageEventUtils {
    public static MessageEvent asMessageEvent(BaseMessageEvent baseMessageEvent) {
        MessageEvent.Type type;
        Utils.checkNotNull(baseMessageEvent, NotificationCompat.CATEGORY_EVENT);
        if (baseMessageEvent instanceof MessageEvent) {
            return (MessageEvent) baseMessageEvent;
        }
        NetworkEvent networkEvent = (NetworkEvent) baseMessageEvent;
        if (networkEvent.getType() == NetworkEvent.Type.RECV) {
            type = MessageEvent.Type.RECEIVED;
        } else {
            type = MessageEvent.Type.SENT;
        }
        return MessageEvent.builder(type, networkEvent.getMessageId()).setUncompressedMessageSize(networkEvent.getUncompressedMessageSize()).setCompressedMessageSize(networkEvent.getCompressedMessageSize()).build();
    }

    public static NetworkEvent asNetworkEvent(BaseMessageEvent baseMessageEvent) {
        NetworkEvent.Type type;
        Utils.checkNotNull(baseMessageEvent, NotificationCompat.CATEGORY_EVENT);
        if (baseMessageEvent instanceof NetworkEvent) {
            return (NetworkEvent) baseMessageEvent;
        }
        MessageEvent messageEvent = (MessageEvent) baseMessageEvent;
        if (messageEvent.getType() == MessageEvent.Type.RECEIVED) {
            type = NetworkEvent.Type.RECV;
        } else {
            type = NetworkEvent.Type.SENT;
        }
        return NetworkEvent.builder(type, messageEvent.getMessageId()).setUncompressedMessageSize(messageEvent.getUncompressedMessageSize()).setCompressedMessageSize(messageEvent.getCompressedMessageSize()).build();
    }

    private BaseMessageEventUtils() {
    }
}

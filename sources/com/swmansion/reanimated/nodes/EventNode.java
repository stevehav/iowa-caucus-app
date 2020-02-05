package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.swmansion.reanimated.NodesManager;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public class EventNode extends Node implements RCTEventEmitter {
    private final List<EventMap> mMapping;

    private static class EventMap {
        /* access modifiers changed from: private */
        public final int nodeID;
        private final String[] path;

        public EventMap(ReadableArray readableArray) {
            int size = readableArray.size() - 1;
            this.path = new String[size];
            for (int i = 0; i < size; i++) {
                this.path[i] = readableArray.getString(i);
            }
            this.nodeID = readableArray.getInt(size);
        }

        public Double lookupValue(ReadableMap readableMap) {
            int i = 0;
            while (readableMap != null) {
                String[] strArr = this.path;
                if (i >= strArr.length - 1) {
                    break;
                }
                String str = strArr[i];
                readableMap = readableMap.hasKey(str) ? readableMap.getMap(str) : null;
                i++;
            }
            if (readableMap == null) {
                return null;
            }
            String[] strArr2 = this.path;
            String str2 = strArr2[strArr2.length - 1];
            if (readableMap.hasKey(str2)) {
                return Double.valueOf(readableMap.getDouble(str2));
            }
            return null;
        }
    }

    private static List<EventMap> processMapping(ReadableArray readableArray) {
        int size = readableArray.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new EventMap(readableArray.getArray(i)));
        }
        return arrayList;
    }

    public EventNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mMapping = processMapping(readableMap.getArray("argMapping"));
    }

    public void receiveEvent(int i, String str, @Nullable WritableMap writableMap) {
        if (writableMap != null) {
            for (int i2 = 0; i2 < this.mMapping.size(); i2++) {
                EventMap eventMap = this.mMapping.get(i2);
                Double lookupValue = eventMap.lookupValue(writableMap);
                if (lookupValue != null) {
                    ((ValueNode) this.mNodesManager.findNodeById(eventMap.nodeID, ValueNode.class)).setValue(lookupValue);
                }
            }
            return;
        }
        throw new IllegalArgumentException("Animated events must have event data.");
    }

    public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
        throw new RuntimeException("receiveTouches is not support by animated events");
    }

    /* access modifiers changed from: protected */
    public Double evaluate() {
        return ZERO;
    }
}

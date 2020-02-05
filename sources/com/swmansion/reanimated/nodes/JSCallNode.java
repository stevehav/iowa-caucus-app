package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.swmansion.reanimated.NodesManager;
import com.swmansion.reanimated.Utils;

public class JSCallNode extends Node {
    private final int[] mInputIDs;

    public JSCallNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mInputIDs = Utils.processIntArray(readableMap.getArray("input"));
    }

    /* access modifiers changed from: protected */
    public Double evaluate() {
        WritableArray createArray = Arguments.createArray();
        for (int findNodeById : this.mInputIDs) {
            Node findNodeById2 = this.mNodesManager.findNodeById(findNodeById, Node.class);
            if (findNodeById2.value() == null) {
                createArray.pushNull();
            } else {
                Object value = findNodeById2.value();
                if (value instanceof String) {
                    createArray.pushString((String) value);
                } else {
                    createArray.pushDouble(findNodeById2.doubleValue().doubleValue());
                }
            }
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("id", this.mNodeID);
        createMap.putArray("args", createArray);
        this.mNodesManager.sendEvent("onReanimatedCall", createMap);
        return ZERO;
    }
}

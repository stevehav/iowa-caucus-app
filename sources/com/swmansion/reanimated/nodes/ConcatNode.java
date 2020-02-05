package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import com.swmansion.reanimated.NodesManager;
import com.swmansion.reanimated.Utils;

public class ConcatNode extends Node {
    private final int[] mInputIDs;

    public ConcatNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mInputIDs = Utils.processIntArray(readableMap.getArray("input"));
    }

    /* access modifiers changed from: protected */
    public String evaluate() {
        StringBuilder sb = new StringBuilder();
        for (int findNodeById : this.mInputIDs) {
            sb.append(this.mNodesManager.findNodeById(findNodeById, Node.class).value());
        }
        return sb.toString();
    }
}

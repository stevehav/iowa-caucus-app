package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import com.swmansion.reanimated.NodesManager;

public class SetNode extends Node {
    private int mValueNodeID;
    private int mWhatNodeID;

    public SetNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mWhatNodeID = readableMap.getInt("what");
        this.mValueNodeID = readableMap.getInt("value");
    }

    /* access modifiers changed from: protected */
    public Object evaluate() {
        Object nodeValue = this.mNodesManager.getNodeValue(this.mValueNodeID);
        ((ValueNode) this.mNodesManager.findNodeById(this.mWhatNodeID, ValueNode.class)).setValue(nodeValue);
        return nodeValue;
    }
}

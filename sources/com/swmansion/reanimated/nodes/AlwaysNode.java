package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import com.swmansion.reanimated.NodesManager;

public class AlwaysNode extends Node implements FinalNode {
    private int mNodeToBeEvaluated;

    public AlwaysNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mNodeToBeEvaluated = readableMap.getInt("what");
    }

    public void update() {
        value();
    }

    /* access modifiers changed from: protected */
    public Double evaluate() {
        this.mNodesManager.findNodeById(this.mNodeToBeEvaluated, Node.class).value();
        return ZERO;
    }
}

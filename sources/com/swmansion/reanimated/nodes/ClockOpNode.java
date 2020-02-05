package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import com.swmansion.reanimated.NodesManager;

public abstract class ClockOpNode extends Node {
    private int clockID;

    /* access modifiers changed from: protected */
    public abstract Double eval(ClockNode clockNode);

    public static class ClockStartNode extends ClockOpNode {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ Object evaluate() {
            return ClockOpNode.super.evaluate();
        }

        public ClockStartNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
            super(i, readableMap, nodesManager);
        }

        /* access modifiers changed from: protected */
        public Double eval(ClockNode clockNode) {
            clockNode.start();
            return ZERO;
        }
    }

    public static class ClockStopNode extends ClockOpNode {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ Object evaluate() {
            return ClockOpNode.super.evaluate();
        }

        public ClockStopNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
            super(i, readableMap, nodesManager);
        }

        /* access modifiers changed from: protected */
        public Double eval(ClockNode clockNode) {
            clockNode.stop();
            return ZERO;
        }
    }

    public static class ClockTestNode extends ClockOpNode {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ Object evaluate() {
            return ClockOpNode.super.evaluate();
        }

        public ClockTestNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
            super(i, readableMap, nodesManager);
        }

        /* access modifiers changed from: protected */
        public Double eval(ClockNode clockNode) {
            return Double.valueOf(clockNode.isRunning ? 1.0d : 0.0d);
        }
    }

    public ClockOpNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.clockID = readableMap.getInt("clock");
    }

    /* access modifiers changed from: protected */
    public Double evaluate() {
        return eval((ClockNode) this.mNodesManager.findNodeById(this.clockID, ClockNode.class));
    }
}

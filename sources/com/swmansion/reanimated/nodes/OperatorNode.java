package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.swmansion.reanimated.NodesManager;
import com.swmansion.reanimated.Utils;

public class OperatorNode extends Node {
    private static final Operator ACOS = new SingleOperator() {
        public double eval(Double d) {
            return Math.acos(d.doubleValue());
        }
    };
    private static final Operator ADD = new ReduceOperator() {
        public double reduce(Double d, Double d2) {
            return d.doubleValue() + d2.doubleValue();
        }
    };
    private static final Operator AND = new Operator() {
        public double evaluate(Node[] nodeArr) {
            boolean access$200 = OperatorNode.truthy(nodeArr[0].value());
            for (int i = 1; i < nodeArr.length && access$200; i++) {
                access$200 = access$200 && OperatorNode.truthy(nodeArr[i].value());
            }
            return access$200 ? 1.0d : 0.0d;
        }
    };
    private static final Operator ASIN = new SingleOperator() {
        public double eval(Double d) {
            return Math.asin(d.doubleValue());
        }
    };
    private static final Operator ATAN = new SingleOperator() {
        public double eval(Double d) {
            return Math.atan(d.doubleValue());
        }
    };
    private static final Operator COS = new SingleOperator() {
        public double eval(Double d) {
            return Math.cos(d.doubleValue());
        }
    };
    private static final Operator DEFINED = new Operator() {
        public double evaluate(Node[] nodeArr) {
            Object value = nodeArr[0].value();
            return (value == null || ((value instanceof Double) && ((Double) value).isNaN())) ? 0.0d : 1.0d;
        }
    };
    private static final Operator DIVIDE = new ReduceOperator() {
        public double reduce(Double d, Double d2) {
            return d.doubleValue() / d2.doubleValue();
        }
    };
    private static final Operator EQ = new CompOperator() {
        public boolean eval(Double d, Double d2) {
            return d.equals(d2);
        }
    };
    private static final Operator EXP = new SingleOperator() {
        public double eval(Double d) {
            return Math.exp(d.doubleValue());
        }
    };
    private static final Operator GREATER_OR_EQ = new CompOperator() {
        public boolean eval(Double d, Double d2) {
            return d.doubleValue() >= d2.doubleValue();
        }
    };
    private static final Operator GREATER_THAN = new CompOperator() {
        public boolean eval(Double d, Double d2) {
            return d.doubleValue() > d2.doubleValue();
        }
    };
    private static final Operator LESS_OR_EQ = new CompOperator() {
        public boolean eval(Double d, Double d2) {
            return d.doubleValue() <= d2.doubleValue();
        }
    };
    private static final Operator LESS_THAN = new CompOperator() {
        public boolean eval(Double d, Double d2) {
            return d.doubleValue() < d2.doubleValue();
        }
    };
    private static final Operator LOG = new SingleOperator() {
        public double eval(Double d) {
            return Math.log(d.doubleValue());
        }
    };
    private static final Operator MODULO = new ReduceOperator() {
        public double reduce(Double d, Double d2) {
            return ((d.doubleValue() % d2.doubleValue()) + d2.doubleValue()) % d2.doubleValue();
        }
    };
    private static final Operator MULTIPLY = new ReduceOperator() {
        public double reduce(Double d, Double d2) {
            return d.doubleValue() * d2.doubleValue();
        }
    };
    private static final Operator NEQ = new CompOperator() {
        public boolean eval(Double d, Double d2) {
            return !d.equals(d2);
        }
    };
    private static final Operator NOT = new Operator() {
        public double evaluate(Node[] nodeArr) {
            return OperatorNode.truthy(nodeArr[0].value()) ? 0.0d : 1.0d;
        }
    };
    private static final Operator OR = new Operator() {
        public double evaluate(Node[] nodeArr) {
            boolean access$200 = OperatorNode.truthy(nodeArr[0].value());
            for (int i = 1; i < nodeArr.length && !access$200; i++) {
                access$200 = access$200 || OperatorNode.truthy(nodeArr[i].value());
            }
            return access$200 ? 1.0d : 0.0d;
        }
    };
    private static final Operator POW = new ReduceOperator() {
        public double reduce(Double d, Double d2) {
            return Math.pow(d.doubleValue(), d2.doubleValue());
        }
    };
    private static final Operator ROUND = new SingleOperator() {
        public double eval(Double d) {
            return (double) Math.round(d.doubleValue());
        }
    };
    private static final Operator SIN = new SingleOperator() {
        public double eval(Double d) {
            return Math.sin(d.doubleValue());
        }
    };
    private static final Operator SQRT = new SingleOperator() {
        public double eval(Double d) {
            return Math.sqrt(d.doubleValue());
        }
    };
    private static final Operator SUB = new ReduceOperator() {
        public double reduce(Double d, Double d2) {
            return d.doubleValue() - d2.doubleValue();
        }
    };
    private static final Operator TAN = new SingleOperator() {
        public double eval(Double d) {
            return Math.tan(d.doubleValue());
        }
    };
    private final int[] mInputIDs;
    private final Node[] mInputNodes = new Node[this.mInputIDs.length];
    private final Operator mOperator;

    private interface Operator {
        double evaluate(Node[] nodeArr);
    }

    /* access modifiers changed from: private */
    public static boolean truthy(Object obj) {
        return obj != null && !obj.equals(Double.valueOf(0.0d));
    }

    private static abstract class ReduceOperator implements Operator {
        public abstract double reduce(Double d, Double d2);

        private ReduceOperator() {
        }

        public double evaluate(Node[] nodeArr) {
            double doubleValue = nodeArr[0].doubleValue().doubleValue();
            for (int i = 1; i < nodeArr.length; i++) {
                doubleValue = reduce(Double.valueOf(doubleValue), nodeArr[i].doubleValue());
            }
            return doubleValue;
        }
    }

    private static abstract class SingleOperator implements Operator {
        public abstract double eval(Double d);

        private SingleOperator() {
        }

        public double evaluate(Node[] nodeArr) {
            return eval((Double) nodeArr[0].value());
        }
    }

    private static abstract class CompOperator implements Operator {
        public abstract boolean eval(Double d, Double d2);

        private CompOperator() {
        }

        public double evaluate(Node[] nodeArr) {
            return eval((Double) nodeArr[0].value(), (Double) nodeArr[1].value()) ? 1.0d : 0.0d;
        }
    }

    public OperatorNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mInputIDs = Utils.processIntArray(readableMap.getArray("input"));
        String string = readableMap.getString("op");
        if ("add".equals(string)) {
            this.mOperator = ADD;
        } else if ("sub".equals(string)) {
            this.mOperator = SUB;
        } else if ("multiply".equals(string)) {
            this.mOperator = MULTIPLY;
        } else if ("divide".equals(string)) {
            this.mOperator = DIVIDE;
        } else if ("pow".equals(string)) {
            this.mOperator = POW;
        } else if ("modulo".equals(string)) {
            this.mOperator = MODULO;
        } else if ("sqrt".equals(string)) {
            this.mOperator = SQRT;
        } else if ("log".equals(string)) {
            this.mOperator = LOG;
        } else if ("sin".equals(string)) {
            this.mOperator = SIN;
        } else if ("cos".equals(string)) {
            this.mOperator = COS;
        } else if ("tan".equals(string)) {
            this.mOperator = TAN;
        } else if ("acos".equals(string)) {
            this.mOperator = ACOS;
        } else if ("asin".equals(string)) {
            this.mOperator = ASIN;
        } else if ("atan".equals(string)) {
            this.mOperator = ATAN;
        } else if ("exp".equals(string)) {
            this.mOperator = EXP;
        } else if ("round".equals(string)) {
            this.mOperator = ROUND;
        } else if ("and".equals(string)) {
            this.mOperator = AND;
        } else if ("or".equals(string)) {
            this.mOperator = OR;
        } else if ("not".equals(string)) {
            this.mOperator = NOT;
        } else if ("defined".equals(string)) {
            this.mOperator = DEFINED;
        } else if ("lessThan".equals(string)) {
            this.mOperator = LESS_THAN;
        } else if ("eq".equals(string)) {
            this.mOperator = EQ;
        } else if ("greaterThan".equals(string)) {
            this.mOperator = GREATER_THAN;
        } else if ("lessOrEq".equals(string)) {
            this.mOperator = LESS_OR_EQ;
        } else if ("greaterOrEq".equals(string)) {
            this.mOperator = GREATER_OR_EQ;
        } else if ("neq".equals(string)) {
            this.mOperator = NEQ;
        } else {
            throw new JSApplicationIllegalArgumentException("Unrecognized operator " + string);
        }
    }

    /* access modifiers changed from: protected */
    public Object evaluate() {
        for (int i = 0; i < this.mInputIDs.length; i++) {
            this.mInputNodes[i] = this.mNodesManager.findNodeById(this.mInputIDs[i], Node.class);
        }
        return Double.valueOf(this.mOperator.evaluate(this.mInputNodes));
    }
}

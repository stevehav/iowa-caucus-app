package io.opencensus.trace.propagation;

public abstract class PropagationComponent {
    private static final PropagationComponent NOOP_PROPAGATION_COMPONENT = new NoopPropagationComponent();

    public abstract TextFormat getB3Format();

    public abstract BinaryFormat getBinaryFormat();

    public abstract TextFormat getTraceContextFormat();

    public static PropagationComponent getNoopPropagationComponent() {
        return NOOP_PROPAGATION_COMPONENT;
    }

    private static final class NoopPropagationComponent extends PropagationComponent {
        private NoopPropagationComponent() {
        }

        public BinaryFormat getBinaryFormat() {
            return BinaryFormat.getNoopBinaryFormat();
        }

        public TextFormat getB3Format() {
            return TextFormat.getNoopTextFormat();
        }

        public TextFormat getTraceContextFormat() {
            return TextFormat.getNoopTextFormat();
        }
    }
}

package io.grpc;

@Internal
public final class InternalDecompressorRegistry {
    private InternalDecompressorRegistry() {
    }

    @Internal
    public static byte[] getRawAdvertisedMessageEncodings(DecompressorRegistry decompressorRegistry) {
        return decompressorRegistry.getRawAdvertisedMessageEncodings();
    }
}

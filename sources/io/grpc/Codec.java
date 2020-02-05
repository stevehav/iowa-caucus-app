package io.grpc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
public interface Codec extends Compressor, Decompressor {

    public static final class Gzip implements Codec {
        public String getMessageEncoding() {
            return "gzip";
        }

        public OutputStream compress(OutputStream outputStream) throws IOException {
            return new GZIPOutputStream(outputStream);
        }

        public InputStream decompress(InputStream inputStream) throws IOException {
            return new GZIPInputStream(inputStream);
        }
    }

    public static final class Identity implements Codec {
        public static final Codec NONE = new Identity();

        public OutputStream compress(OutputStream outputStream) {
            return outputStream;
        }

        public InputStream decompress(InputStream inputStream) {
            return inputStream;
        }

        public String getMessageEncoding() {
            return InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY;
        }

        private Identity() {
        }
    }
}

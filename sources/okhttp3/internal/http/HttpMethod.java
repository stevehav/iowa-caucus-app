package okhttp3.internal.http;

import io.grpc.internal.GrpcUtil;

public final class HttpMethod {
    public static boolean invalidatesCache(String str) {
        return str.equals(GrpcUtil.HTTP_METHOD) || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    public static boolean requiresRequestBody(String str) {
        return str.equals(GrpcUtil.HTTP_METHOD) || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    public static boolean permitsRequestBody(String str) {
        return !str.equals("GET") && !str.equals("HEAD");
    }

    public static boolean redirectsWithBody(String str) {
        return str.equals("PROPFIND");
    }

    public static boolean redirectsToGet(String str) {
        return !str.equals("PROPFIND");
    }

    private HttpMethod() {
    }
}

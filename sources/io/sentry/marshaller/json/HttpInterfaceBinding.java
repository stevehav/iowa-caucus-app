package io.sentry.marshaller.json;

import com.fasterxml.jackson.core.JsonGenerator;
import io.sentry.event.interfaces.HttpInterface;
import io.sentry.util.Util;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public class HttpInterfaceBinding implements InterfaceBinding<HttpInterface> {
    private static final String BODY = "body";
    private static final String COOKIES = "cookies";
    private static final String DATA = "data";
    private static final String ENVIRONMENT = "env";
    private static final String ENV_AUTH_TYPE = "AUTH_TYPE";
    private static final String ENV_LOCAL_ADDR = "LOCAL_ADDR";
    private static final String ENV_LOCAL_NAME = "LOCAL_NAME";
    private static final String ENV_LOCAL_PORT = "LOCAL_PORT";
    private static final String ENV_REMOTE_ADDR = "REMOTE_ADDR";
    private static final String ENV_REMOTE_USER = "REMOTE_USER";
    private static final String ENV_REQUEST_ASYNC = "REQUEST_ASYNC";
    private static final String ENV_REQUEST_SECURE = "REQUEST_SECURE";
    private static final String ENV_SERVER_NAME = "SERVER_NAME";
    private static final String ENV_SERVER_PORT = "SERVER_PORT";
    private static final String ENV_SERVER_PROTOCOL = "SERVER_PROTOCOL";
    private static final String HEADERS = "headers";
    public static final int MAX_BODY_LENGTH = 2048;
    private static final String METHOD = "method";
    private static final String QUERY_STRING = "query_string";
    private static final String URL = "url";

    public void writeInterface(JsonGenerator jsonGenerator, HttpInterface httpInterface) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("url", httpInterface.getRequestUrl());
        jsonGenerator.writeStringField("method", httpInterface.getMethod());
        jsonGenerator.writeFieldName("data");
        writeData(jsonGenerator, httpInterface.getParameters(), httpInterface.getBody());
        jsonGenerator.writeStringField(QUERY_STRING, httpInterface.getQueryString());
        jsonGenerator.writeFieldName(COOKIES);
        writeCookies(jsonGenerator, httpInterface.getCookies());
        jsonGenerator.writeFieldName(HEADERS);
        writeHeaders(jsonGenerator, httpInterface.getHeaders());
        jsonGenerator.writeFieldName(ENVIRONMENT);
        writeEnvironment(jsonGenerator, httpInterface);
        jsonGenerator.writeEndObject();
    }

    private void writeEnvironment(JsonGenerator jsonGenerator, HttpInterface httpInterface) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField(ENV_REMOTE_ADDR, httpInterface.getRemoteAddr());
        jsonGenerator.writeStringField(ENV_SERVER_NAME, httpInterface.getServerName());
        jsonGenerator.writeNumberField(ENV_SERVER_PORT, httpInterface.getServerPort());
        jsonGenerator.writeStringField(ENV_LOCAL_ADDR, httpInterface.getLocalAddr());
        jsonGenerator.writeStringField(ENV_LOCAL_NAME, httpInterface.getLocalName());
        jsonGenerator.writeNumberField(ENV_LOCAL_PORT, httpInterface.getLocalPort());
        jsonGenerator.writeStringField(ENV_SERVER_PROTOCOL, httpInterface.getProtocol());
        jsonGenerator.writeBooleanField(ENV_REQUEST_SECURE, httpInterface.isSecure());
        jsonGenerator.writeBooleanField(ENV_REQUEST_ASYNC, httpInterface.isAsyncStarted());
        jsonGenerator.writeStringField(ENV_AUTH_TYPE, httpInterface.getAuthType());
        jsonGenerator.writeStringField(ENV_REMOTE_USER, httpInterface.getRemoteUser());
        jsonGenerator.writeEndObject();
    }

    private void writeHeaders(JsonGenerator jsonGenerator, Map<String, Collection<String>> map) throws IOException {
        jsonGenerator.writeStartArray();
        for (Map.Entry next : map.entrySet()) {
            for (String writeString : (Collection) next.getValue()) {
                jsonGenerator.writeStartArray();
                jsonGenerator.writeString((String) next.getKey());
                jsonGenerator.writeString(writeString);
                jsonGenerator.writeEndArray();
            }
        }
        jsonGenerator.writeEndArray();
    }

    private void writeCookies(JsonGenerator jsonGenerator, Map<String, String> map) throws IOException {
        if (map.isEmpty()) {
            jsonGenerator.writeNull();
            return;
        }
        jsonGenerator.writeStartObject();
        for (Map.Entry next : map.entrySet()) {
            jsonGenerator.writeStringField((String) next.getKey(), (String) next.getValue());
        }
        jsonGenerator.writeEndObject();
    }

    private void writeData(JsonGenerator jsonGenerator, Map<String, Collection<String>> map, String str) throws IOException {
        if (map == null && str == null) {
            jsonGenerator.writeNull();
        } else if ((map == null || map.isEmpty()) && str != null) {
            jsonGenerator.writeString(Util.trimString(str, 2048));
        } else {
            jsonGenerator.writeStartObject();
            if (str != null) {
                jsonGenerator.writeStringField(BODY, Util.trimString(str, 2048));
            }
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    jsonGenerator.writeArrayFieldStart((String) next.getKey());
                    for (String writeString : (Collection) next.getValue()) {
                        jsonGenerator.writeString(writeString);
                    }
                    jsonGenerator.writeEndArray();
                }
            }
            jsonGenerator.writeEndObject();
        }
    }
}

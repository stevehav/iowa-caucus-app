package io.sentry.marshaller.json;

import com.fasterxml.jackson.core.JsonGenerator;
import io.sentry.event.interfaces.DebugMetaInterface;
import java.io.IOException;
import java.util.Iterator;

public class DebugMetaInterfaceBinding implements InterfaceBinding<DebugMetaInterface> {
    private static final String IMAGES = "images";
    private static final String TYPE = "type";
    private static final String UUID = "uuid";

    public void writeInterface(JsonGenerator jsonGenerator, DebugMetaInterface debugMetaInterface) throws IOException {
        jsonGenerator.writeStartObject();
        writeDebugImages(jsonGenerator, debugMetaInterface);
        jsonGenerator.writeEndObject();
    }

    private void writeDebugImages(JsonGenerator jsonGenerator, DebugMetaInterface debugMetaInterface) throws IOException {
        jsonGenerator.writeArrayFieldStart(IMAGES);
        Iterator<DebugMetaInterface.DebugImage> it = debugMetaInterface.getDebugImages().iterator();
        while (it.hasNext()) {
            DebugMetaInterface.DebugImage next = it.next();
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField(UUID, next.getUuid());
            jsonGenerator.writeStringField("type", next.getType());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
    }
}

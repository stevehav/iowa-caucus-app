package io.sentry.marshaller.json;

import com.fasterxml.jackson.core.JsonGenerator;
import io.sentry.event.interfaces.UserInterface;
import java.io.IOException;
import java.util.Map;

public class UserInterfaceBinding implements InterfaceBinding<UserInterface> {
    private static final String DATA = "data";
    private static final String EMAIL = "email";
    private static final String ID = "id";
    private static final String IP_ADDRESS = "ip_address";
    private static final String USERNAME = "username";

    public void writeInterface(JsonGenerator jsonGenerator, UserInterface userInterface) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField(ID, userInterface.getId());
        jsonGenerator.writeStringField(USERNAME, userInterface.getUsername());
        jsonGenerator.writeStringField("email", userInterface.getEmail());
        jsonGenerator.writeStringField(IP_ADDRESS, userInterface.getIpAddress());
        if (userInterface.getData() != null && !userInterface.getData().isEmpty()) {
            jsonGenerator.writeObjectFieldStart("data");
            for (Map.Entry next : userInterface.getData().entrySet()) {
                String str = (String) next.getKey();
                Object value = next.getValue();
                if (value == null) {
                    jsonGenerator.writeNullField(str);
                } else {
                    jsonGenerator.writeObjectField(str, value);
                }
            }
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndObject();
    }
}

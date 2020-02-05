package io.sentry.event.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MessageInterface implements SentryInterface {
    public static final String MESSAGE_INTERFACE = "sentry.interfaces.Message";
    private final String formatted;
    private final String message;
    private final List<String> parameters;

    public String getInterfaceName() {
        return MESSAGE_INTERFACE;
    }

    public MessageInterface(String str) {
        this(str, (List<String>) Collections.emptyList());
    }

    public MessageInterface(String str, String... strArr) {
        this(str, (List<String>) Arrays.asList(strArr));
    }

    public MessageInterface(String str, List<String> list) {
        this(str, list, (String) null);
    }

    public MessageInterface(String str, List<String> list, String str2) {
        this.message = str;
        this.parameters = Collections.unmodifiableList(new ArrayList(list));
        this.formatted = str2;
    }

    public String getMessage() {
        return this.message;
    }

    public List<String> getParameters() {
        return this.parameters;
    }

    public String getFormatted() {
        return this.formatted;
    }

    public String toString() {
        return "MessageInterface{message='" + this.message + '\'' + ", parameters=" + this.parameters + ", formatted=" + this.formatted + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MessageInterface messageInterface = (MessageInterface) obj;
        if (!Objects.equals(this.message, messageInterface.message) || !Objects.equals(this.parameters, messageInterface.parameters) || !Objects.equals(this.formatted, messageInterface.formatted)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.message, this.parameters, this.formatted});
    }
}

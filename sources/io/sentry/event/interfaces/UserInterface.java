package io.sentry.event.interfaces;

import java.util.Map;
import java.util.Objects;

public class UserInterface implements SentryInterface {
    public static final String USER_INTERFACE = "sentry.interfaces.User";
    private final Map<String, Object> data;
    private final String email;
    private final String id;
    private final String ipAddress;
    private final String username;

    public String getInterfaceName() {
        return USER_INTERFACE;
    }

    public UserInterface(String str, String str2, String str3, String str4, Map<String, Object> map) {
        this.id = str;
        this.username = str2;
        this.ipAddress = str3;
        this.email = str4;
        this.data = map;
    }

    public UserInterface(String str, String str2, String str3, String str4) {
        this(str, str2, str3, str4, (Map<String, Object>) null);
    }

    public String getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public String getEmail() {
        return this.email;
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserInterface userInterface = (UserInterface) obj;
        if (!Objects.equals(this.id, userInterface.id) || !Objects.equals(this.username, userInterface.username) || !Objects.equals(this.ipAddress, userInterface.ipAddress) || !Objects.equals(this.email, userInterface.email) || !Objects.equals(this.data, userInterface.data)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.username, this.ipAddress, this.email, this.data});
    }

    public String toString() {
        return "UserInterface{id='" + this.id + '\'' + ", username='" + this.username + '\'' + ", ipAddress='" + this.ipAddress + '\'' + ", email='" + this.email + '\'' + ", data=" + this.data + '}';
    }
}

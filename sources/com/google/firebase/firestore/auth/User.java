package com.google.firebase.firestore.auth;

import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class User {
    public static final User UNAUTHENTICATED = new User((String) null);
    @Nullable
    private final String uid;

    public User(@Nullable String str) {
        this.uid = str;
    }

    @Nullable
    public String getUid() {
        return this.uid;
    }

    public boolean isAuthenticated() {
        return this.uid != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        String str = this.uid;
        if (str != null) {
            return str.equals(user.uid);
        }
        if (user.uid == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.uid;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "User(uid:" + this.uid + ")";
    }
}

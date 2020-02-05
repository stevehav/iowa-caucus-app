package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@17.1.0 */
abstract class AbstractComponentContainer implements ComponentContainer {
    AbstractComponentContainer() {
    }

    public <T> T get(Class<T> cls) {
        Provider<T> provider = getProvider(cls);
        if (provider == null) {
            return null;
        }
        return provider.get();
    }

    public <T> Set<T> setOf(Class<T> cls) {
        return setOfProvider(cls).get();
    }
}

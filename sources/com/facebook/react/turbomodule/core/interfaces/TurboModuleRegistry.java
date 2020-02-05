package com.facebook.react.turbomodule.core.interfaces;

import androidx.annotation.Nullable;
import java.util.Collection;

public interface TurboModuleRegistry {
    @Nullable
    TurboModule getModule(String str);

    Collection<TurboModule> getModules();

    boolean hasModule(String str);
}

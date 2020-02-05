package com.drew.metadata;

import com.drew.lang.annotations.NotNull;
import java.util.HashMap;

public final class ErrorDirectory extends Directory {
    @NotNull
    public String getName() {
        return "Error";
    }

    @NotNull
    public String getTagName(int i) {
        return "";
    }

    public boolean hasTagName(int i) {
        return false;
    }

    public ErrorDirectory() {
    }

    public ErrorDirectory(String str) {
        super.addError(str);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public HashMap<Integer, String> getTagNameMap() {
        return new HashMap<>();
    }

    public void setObject(int i, @NotNull Object obj) {
        throw new UnsupportedOperationException(String.format("Cannot add value to %s.", new Object[]{ErrorDirectory.class.getName()}));
    }
}

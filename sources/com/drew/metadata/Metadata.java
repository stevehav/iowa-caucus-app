package com.drew.metadata;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class Metadata {
    @NotNull
    private final List<Directory> _directories = new ArrayList();

    @NotNull
    public Iterable<Directory> getDirectories() {
        return this._directories;
    }

    @NotNull
    public <T extends Directory> Collection<T> getDirectoriesOfType(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        for (Directory next : this._directories) {
            if (cls.isAssignableFrom(next.getClass())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public int getDirectoryCount() {
        return this._directories.size();
    }

    public <T extends Directory> void addDirectory(@NotNull T t) {
        this._directories.add(t);
    }

    @Nullable
    public <T extends Directory> T getFirstDirectoryOfType(@NotNull Class<T> cls) {
        Iterator<Directory> it = this._directories.iterator();
        while (it.hasNext()) {
            T t = (Directory) it.next();
            if (cls.isAssignableFrom(t.getClass())) {
                return t;
            }
        }
        return null;
    }

    public boolean containsDirectoryOfType(Class<? extends Directory> cls) {
        for (Directory directory : this._directories) {
            if (cls.isAssignableFrom(directory.getClass())) {
                return true;
            }
        }
        return false;
    }

    public boolean hasErrors() {
        for (Directory hasErrors : getDirectories()) {
            if (hasErrors.hasErrors()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        int directoryCount = getDirectoryCount();
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(directoryCount);
        objArr[1] = directoryCount == 1 ? "directory" : "directories";
        return String.format("Metadata (%d %s)", objArr);
    }
}

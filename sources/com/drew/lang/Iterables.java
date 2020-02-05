package com.drew.lang;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Iterables {
    public static <E> List<E> toList(Iterable<E> iterable) {
        ArrayList arrayList = new ArrayList();
        for (E add : iterable) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static <E> Set<E> toSet(Iterable<E> iterable) {
        HashSet hashSet = new HashSet();
        for (E add : iterable) {
            hashSet.add(add);
        }
        return hashSet;
    }
}

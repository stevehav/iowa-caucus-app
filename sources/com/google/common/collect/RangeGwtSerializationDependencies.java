package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.lang.Comparable;

@GwtCompatible(emulated = true)
abstract class RangeGwtSerializationDependencies<C extends Comparable> implements Serializable {
    RangeGwtSerializationDependencies() {
    }
}

package com.swmansion.gesturehandler;

import android.view.View;
import java.util.ArrayList;
import java.util.WeakHashMap;

public class GestureHandlerRegistryImpl implements GestureHandlerRegistry {
    private WeakHashMap<View, ArrayList<GestureHandler>> mHandlers = new WeakHashMap<>();

    public <T extends GestureHandler> T registerHandlerForView(View view, T t) {
        ArrayList arrayList = this.mHandlers.get(view);
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList(1);
            arrayList2.add(t);
            this.mHandlers.put(view, arrayList2);
        } else {
            arrayList.add(t);
        }
        return t;
    }

    public ArrayList<GestureHandler> getHandlersForView(View view) {
        return this.mHandlers.get(view);
    }
}

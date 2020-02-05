package com.swmansion.gesturehandler.react;

import android.util.SparseArray;
import android.view.View;
import androidx.annotation.Nullable;
import com.swmansion.gesturehandler.GestureHandler;
import com.swmansion.gesturehandler.GestureHandlerRegistry;
import java.util.ArrayList;

public class RNGestureHandlerRegistry implements GestureHandlerRegistry {
    private final SparseArray<Integer> mAttachedTo = new SparseArray<>();
    private final SparseArray<GestureHandler> mHandlers = new SparseArray<>();
    private final SparseArray<ArrayList<GestureHandler>> mHandlersForView = new SparseArray<>();

    public synchronized void registerHandler(GestureHandler gestureHandler) {
        this.mHandlers.put(gestureHandler.getTag(), gestureHandler);
    }

    @Nullable
    public synchronized GestureHandler getHandler(int i) {
        return this.mHandlers.get(i);
    }

    public synchronized boolean attachHandlerToView(int i, int i2) {
        GestureHandler gestureHandler = this.mHandlers.get(i);
        if (gestureHandler == null) {
            return false;
        }
        detachHandler(gestureHandler);
        registerHandlerForViewWithTag(i2, gestureHandler);
        return true;
    }

    private synchronized void registerHandlerForViewWithTag(int i, GestureHandler gestureHandler) {
        if (this.mAttachedTo.get(gestureHandler.getTag()) == null) {
            this.mAttachedTo.put(gestureHandler.getTag(), Integer.valueOf(i));
            ArrayList arrayList = this.mHandlersForView.get(i);
            if (arrayList == null) {
                ArrayList arrayList2 = new ArrayList(1);
                arrayList2.add(gestureHandler);
                this.mHandlersForView.put(i, arrayList2);
            } else {
                arrayList.add(gestureHandler);
            }
        } else {
            throw new IllegalStateException("Handler " + gestureHandler + " already attached");
        }
    }

    private synchronized void detachHandler(GestureHandler gestureHandler) {
        Integer num = this.mAttachedTo.get(gestureHandler.getTag());
        if (num != null) {
            this.mAttachedTo.remove(gestureHandler.getTag());
            ArrayList arrayList = this.mHandlersForView.get(num.intValue());
            if (arrayList != null) {
                arrayList.remove(gestureHandler);
                if (arrayList.size() == 0) {
                    this.mHandlersForView.remove(num.intValue());
                }
            }
        }
        if (gestureHandler.getView() != null) {
            gestureHandler.cancel();
        }
    }

    public synchronized void dropHandler(int i) {
        GestureHandler gestureHandler = this.mHandlers.get(i);
        if (gestureHandler != null) {
            detachHandler(gestureHandler);
            this.mHandlers.remove(i);
        }
    }

    public synchronized void dropAllHandlers() {
        this.mHandlers.clear();
        this.mAttachedTo.clear();
        this.mHandlersForView.clear();
    }

    public synchronized ArrayList<GestureHandler> getHandlersForViewWithTag(int i) {
        return this.mHandlersForView.get(i);
    }

    public synchronized ArrayList<GestureHandler> getHandlersForView(View view) {
        return getHandlersForViewWithTag(view.getId());
    }
}

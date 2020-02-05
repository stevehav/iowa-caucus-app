package com.facebook.react.uimanager;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class ReactClippingViewGroupHelper {
    public static final String PROP_REMOVE_CLIPPED_SUBVIEWS = "removeClippedSubviews";
    private static final Rect sHelperRect = new Rect();

    public static void calculateClippingRect(View view, Rect rect) {
        ViewParent parent = view.getParent();
        if (parent == null) {
            rect.setEmpty();
            return;
        }
        if (parent instanceof ReactClippingViewGroup) {
            ReactClippingViewGroup reactClippingViewGroup = (ReactClippingViewGroup) parent;
            if (reactClippingViewGroup.getRemoveClippedSubviews()) {
                reactClippingViewGroup.getClippingRect(sHelperRect);
                if (!sHelperRect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                    rect.setEmpty();
                    return;
                }
                sHelperRect.offset(-view.getLeft(), -view.getTop());
                sHelperRect.offset(view.getScrollX(), view.getScrollY());
                rect.set(sHelperRect);
                return;
            }
        }
        view.getDrawingRect(rect);
    }
}

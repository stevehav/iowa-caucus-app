package com.facebook.react.views.scroll;

import androidx.annotation.Nullable;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import java.util.Map;

public class ReactScrollViewCommandHelper {
    public static final int COMMAND_FLASH_SCROLL_INDICATORS = 3;
    public static final int COMMAND_SCROLL_TO = 1;
    public static final int COMMAND_SCROLL_TO_END = 2;

    public interface ScrollCommandHandler<T> {
        void flashScrollIndicators(T t);

        void scrollTo(T t, ScrollToCommandData scrollToCommandData);

        void scrollToEnd(T t, ScrollToEndCommandData scrollToEndCommandData);
    }

    public static class ScrollToCommandData {
        public final boolean mAnimated;
        public final int mDestX;
        public final int mDestY;

        ScrollToCommandData(int i, int i2, boolean z) {
            this.mDestX = i;
            this.mDestY = i2;
            this.mAnimated = z;
        }
    }

    public static class ScrollToEndCommandData {
        public final boolean mAnimated;

        ScrollToEndCommandData(boolean z) {
            this.mAnimated = z;
        }
    }

    public static Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("scrollTo", 1, "scrollToEnd", 2, "flashScrollIndicators", 3);
    }

    public static <T> void receiveCommand(ScrollCommandHandler<T> scrollCommandHandler, T t, int i, @Nullable ReadableArray readableArray) {
        Assertions.assertNotNull(scrollCommandHandler);
        Assertions.assertNotNull(t);
        Assertions.assertNotNull(readableArray);
        if (i == 1) {
            scrollTo(scrollCommandHandler, t, readableArray);
        } else if (i == 2) {
            scrollToEnd(scrollCommandHandler, t, readableArray);
        } else if (i == 3) {
            scrollCommandHandler.flashScrollIndicators(t);
        } else {
            throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", new Object[]{Integer.valueOf(i), scrollCommandHandler.getClass().getSimpleName()}));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> void receiveCommand(com.facebook.react.views.scroll.ReactScrollViewCommandHelper.ScrollCommandHandler<T> r5, T r6, java.lang.String r7, @androidx.annotation.Nullable com.facebook.react.bridge.ReadableArray r8) {
        /*
            com.facebook.infer.annotation.Assertions.assertNotNull(r5)
            com.facebook.infer.annotation.Assertions.assertNotNull(r6)
            com.facebook.infer.annotation.Assertions.assertNotNull(r8)
            int r0 = r7.hashCode()
            r1 = -402165208(0xffffffffe8077228, float:-2.5585011E24)
            r2 = 0
            r3 = 2
            r4 = 1
            if (r0 == r1) goto L_0x0034
            r1 = 28425985(0x1b1bf01, float:6.529361E-38)
            if (r0 == r1) goto L_0x002a
            r1 = 2055114131(0x7a7e8d93, float:3.3042872E35)
            if (r0 == r1) goto L_0x0020
            goto L_0x003e
        L_0x0020:
            java.lang.String r0 = "scrollToEnd"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x003e
            r0 = 1
            goto L_0x003f
        L_0x002a:
            java.lang.String r0 = "flashScrollIndicators"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x003e
            r0 = 2
            goto L_0x003f
        L_0x0034:
            java.lang.String r0 = "scrollTo"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x003e
            r0 = 0
            goto L_0x003f
        L_0x003e:
            r0 = -1
        L_0x003f:
            if (r0 == 0) goto L_0x0067
            if (r0 == r4) goto L_0x0063
            if (r0 != r3) goto L_0x0049
            r5.flashScrollIndicators(r6)
            return
        L_0x0049:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.Object[] r8 = new java.lang.Object[r3]
            r8[r2] = r7
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r8[r4] = r5
            java.lang.String r5 = "Unsupported command %s received by %s."
            java.lang.String r5 = java.lang.String.format(r5, r8)
            r6.<init>(r5)
            throw r6
        L_0x0063:
            scrollToEnd(r5, r6, r8)
            return
        L_0x0067:
            scrollTo(r5, r6, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.scroll.ReactScrollViewCommandHelper.receiveCommand(com.facebook.react.views.scroll.ReactScrollViewCommandHelper$ScrollCommandHandler, java.lang.Object, java.lang.String, com.facebook.react.bridge.ReadableArray):void");
    }

    private static <T> void scrollTo(ScrollCommandHandler<T> scrollCommandHandler, T t, @Nullable ReadableArray readableArray) {
        scrollCommandHandler.scrollTo(t, new ScrollToCommandData(Math.round(PixelUtil.toPixelFromDIP(readableArray.getDouble(0))), Math.round(PixelUtil.toPixelFromDIP(readableArray.getDouble(1))), readableArray.getBoolean(2)));
    }

    private static <T> void scrollToEnd(ScrollCommandHandler<T> scrollCommandHandler, T t, @Nullable ReadableArray readableArray) {
        scrollCommandHandler.scrollToEnd(t, new ScrollToEndCommandData(readableArray.getBoolean(0)));
    }
}

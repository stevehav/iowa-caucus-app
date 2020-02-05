package com.facebook.react.views.scroll;

public enum ScrollEventType {
    BEGIN_DRAG,
    END_DRAG,
    SCROLL,
    MOMENTUM_BEGIN,
    MOMENTUM_END;

    /* renamed from: com.facebook.react.views.scroll.ScrollEventType$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$views$scroll$ScrollEventType = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.facebook.react.views.scroll.ScrollEventType[] r0 = com.facebook.react.views.scroll.ScrollEventType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$views$scroll$ScrollEventType = r0
                int[] r0 = $SwitchMap$com$facebook$react$views$scroll$ScrollEventType     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.facebook.react.views.scroll.ScrollEventType r1 = com.facebook.react.views.scroll.ScrollEventType.BEGIN_DRAG     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$facebook$react$views$scroll$ScrollEventType     // Catch:{ NoSuchFieldError -> 0x001f }
                com.facebook.react.views.scroll.ScrollEventType r1 = com.facebook.react.views.scroll.ScrollEventType.END_DRAG     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$facebook$react$views$scroll$ScrollEventType     // Catch:{ NoSuchFieldError -> 0x002a }
                com.facebook.react.views.scroll.ScrollEventType r1 = com.facebook.react.views.scroll.ScrollEventType.SCROLL     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$com$facebook$react$views$scroll$ScrollEventType     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.facebook.react.views.scroll.ScrollEventType r1 = com.facebook.react.views.scroll.ScrollEventType.MOMENTUM_BEGIN     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = $SwitchMap$com$facebook$react$views$scroll$ScrollEventType     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.facebook.react.views.scroll.ScrollEventType r1 = com.facebook.react.views.scroll.ScrollEventType.MOMENTUM_END     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.scroll.ScrollEventType.AnonymousClass1.<clinit>():void");
        }
    }

    public static String getJSEventName(ScrollEventType scrollEventType) {
        int i = AnonymousClass1.$SwitchMap$com$facebook$react$views$scroll$ScrollEventType[scrollEventType.ordinal()];
        if (i == 1) {
            return "topScrollBeginDrag";
        }
        if (i == 2) {
            return "topScrollEndDrag";
        }
        if (i == 3) {
            return "topScroll";
        }
        if (i == 4) {
            return "topMomentumScrollBegin";
        }
        if (i == 5) {
            return "topMomentumScrollEnd";
        }
        throw new IllegalArgumentException("Unsupported ScrollEventType: " + scrollEventType);
    }
}

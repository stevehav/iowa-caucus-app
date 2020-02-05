package com.google.firebase.firestore.core;

import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class View$$Lambda$1 implements Comparator {
    private final View arg$1;

    private View$$Lambda$1(View view) {
        this.arg$1 = view;
    }

    public static Comparator lambdaFactory$(View view) {
        return new View$$Lambda$1(view);
    }

    public int compare(Object obj, Object obj2) {
        return View.lambda$applyChanges$0(this.arg$1, (DocumentViewChange) obj, (DocumentViewChange) obj2);
    }
}

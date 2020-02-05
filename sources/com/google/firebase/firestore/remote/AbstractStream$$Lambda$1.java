package com.google.firebase.firestore.remote;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class AbstractStream$$Lambda$1 implements Runnable {
    private final AbstractStream arg$1;

    private AbstractStream$$Lambda$1(AbstractStream abstractStream) {
        this.arg$1 = abstractStream;
    }

    public static Runnable lambdaFactory$(AbstractStream abstractStream) {
        return new AbstractStream$$Lambda$1(abstractStream);
    }

    public void run() {
        AbstractStream.lambda$performBackoff$0(this.arg$1);
    }
}

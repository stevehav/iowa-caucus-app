package com.google.firebase.firestore.core;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class ListenSequence {
    public static final long INVALID = -1;
    private long previousSequenceNumber;

    public ListenSequence(long j) {
        this.previousSequenceNumber = j;
    }

    public long next() {
        long j = this.previousSequenceNumber + 1;
        this.previousSequenceNumber = j;
        return j;
    }
}

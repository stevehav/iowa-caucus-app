package com.google.firebase.firestore.core;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final class QueryView {
    private final Query query;
    private final int targetId;
    private final View view;

    QueryView(Query query2, int i, View view2) {
        this.query = query2;
        this.targetId = i;
        this.view = view2;
    }

    public Query getQuery() {
        return this.query;
    }

    public int getTargetId() {
        return this.targetId;
    }

    public View getView() {
        return this.view;
    }
}

package com.google.firebase.firestore.proto;

import com.google.firebase.firestore.proto.MaybeDocument;
import com.google.firestore.v1.Document;
import com.google.protobuf.MessageLiteOrBuilder;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public interface MaybeDocumentOrBuilder extends MessageLiteOrBuilder {
    Document getDocument();

    MaybeDocument.DocumentTypeCase getDocumentTypeCase();

    boolean getHasCommittedMutations();

    NoDocument getNoDocument();

    UnknownDocument getUnknownDocument();
}

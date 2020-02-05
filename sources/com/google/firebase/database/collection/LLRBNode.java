package com.google.firebase.database.collection;

import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
public interface LLRBNode<K, V> {

    /* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
    public enum Color {
        RED,
        BLACK
    }

    /* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
    public interface ShortCircuitingNodeVisitor<K, V> {
        boolean shouldContinue(K k, V v);
    }

    LLRBNode<K, V> copy(K k, V v, Color color, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2);

    K getKey();

    LLRBNode<K, V> getLeft();

    LLRBNode<K, V> getMax();

    LLRBNode<K, V> getMin();

    LLRBNode<K, V> getRight();

    V getValue();

    void inOrderTraversal(NodeVisitor<K, V> nodeVisitor);

    LLRBNode<K, V> insert(K k, V v, Comparator<K> comparator);

    boolean isEmpty();

    boolean isRed();

    LLRBNode<K, V> remove(K k, Comparator<K> comparator);

    boolean shortCircuitingInOrderTraversal(ShortCircuitingNodeVisitor<K, V> shortCircuitingNodeVisitor);

    boolean shortCircuitingReverseOrderTraversal(ShortCircuitingNodeVisitor<K, V> shortCircuitingNodeVisitor);

    int size();

    /* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
    public static abstract class NodeVisitor<K, V> implements ShortCircuitingNodeVisitor<K, V> {
        public abstract void visitEntry(K k, V v);

        public boolean shouldContinue(K k, V v) {
            visitEntry(k, v);
            return true;
        }
    }
}

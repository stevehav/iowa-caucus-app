package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import java.util.Map;
import javax.annotation.Nullable;

public class ThreadHandoffProducer<T> implements Producer<T> {
    public static final String PRODUCER_NAME = "BackgroundThreadHandoffProducer";
    /* access modifiers changed from: private */
    public final Producer<T> mInputProducer;
    /* access modifiers changed from: private */
    public final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

    public ThreadHandoffProducer(Producer<T> producer, ThreadHandoffProducerQueue threadHandoffProducerQueue) {
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
        this.mThreadHandoffProducerQueue = threadHandoffProducerQueue;
    }

    public void produceResults(Consumer<T> consumer, ProducerContext producerContext) {
        final ProducerListener listener = producerContext.getListener();
        final String id = producerContext.getId();
        final Consumer<T> consumer2 = consumer;
        final ProducerContext producerContext2 = producerContext;
        final AnonymousClass1 r0 = new StatefulProducerRunnable<T>(consumer, listener, PRODUCER_NAME, id) {
            /* access modifiers changed from: protected */
            public void disposeResult(T t) {
            }

            /* access modifiers changed from: protected */
            @Nullable
            public T getResult() throws Exception {
                return null;
            }

            /* access modifiers changed from: protected */
            public void onSuccess(T t) {
                listener.onProducerFinishWithSuccess(id, ThreadHandoffProducer.PRODUCER_NAME, (Map<String, String>) null);
                ThreadHandoffProducer.this.mInputProducer.produceResults(consumer2, producerContext2);
            }
        };
        producerContext.addCallbacks(new BaseProducerContextCallbacks() {
            public void onCancellationRequested() {
                r0.cancel();
                ThreadHandoffProducer.this.mThreadHandoffProducerQueue.remove(r0);
            }
        });
        this.mThreadHandoffProducerQueue.addToQueueOrExecute(r0);
    }
}

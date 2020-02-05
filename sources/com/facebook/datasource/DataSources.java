package com.facebook.datasource;

import com.facebook.common.internal.Supplier;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class DataSources {
    private DataSources() {
    }

    public static <T> DataSource<T> immediateFailedDataSource(Throwable th) {
        SimpleDataSource create = SimpleDataSource.create();
        create.setFailure(th);
        return create;
    }

    public static <T> DataSource<T> immediateDataSource(T t) {
        SimpleDataSource create = SimpleDataSource.create();
        create.setResult(t);
        return create;
    }

    public static <T> Supplier<DataSource<T>> getFailedDataSourceSupplier(final Throwable th) {
        return new Supplier<DataSource<T>>() {
            public DataSource<T> get() {
                return DataSources.immediateFailedDataSource(th);
            }
        };
    }

    @Nullable
    public static <T> T waitForFinalResult(DataSource<T> dataSource) throws Throwable {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final ValueHolder valueHolder = new ValueHolder();
        final ValueHolder valueHolder2 = new ValueHolder();
        dataSource.subscribe(new DataSubscriber<T>() {
            public void onProgressUpdate(DataSource<T> dataSource) {
            }

            public void onNewResult(DataSource<T> dataSource) {
                if (dataSource.isFinished()) {
                    try {
                        valueHolder.value = dataSource.getResult();
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }

            public void onFailure(DataSource<T> dataSource) {
                try {
                    valueHolder2.value = dataSource.getFailureCause();
                } finally {
                    countDownLatch.countDown();
                }
            }

            public void onCancellation(DataSource<T> dataSource) {
                countDownLatch.countDown();
            }
        }, new Executor() {
            public void execute(Runnable runnable) {
                runnable.run();
            }
        });
        countDownLatch.await();
        if (valueHolder2.value == null) {
            return valueHolder.value;
        }
        throw ((Throwable) valueHolder2.value);
    }

    private static class ValueHolder<T> {
        @Nullable
        public T value;

        private ValueHolder() {
            this.value = null;
        }
    }
}

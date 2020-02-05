package com.facebook.datasource;

import com.facebook.common.internal.Preconditions;

public class SimpleDataSource<T> extends AbstractDataSource<T> {
    private SimpleDataSource() {
    }

    public static <T> SimpleDataSource<T> create() {
        return new SimpleDataSource<>();
    }

    public boolean setResult(T t, boolean z) {
        return super.setResult(Preconditions.checkNotNull(t), z);
    }

    public boolean setResult(T t) {
        return super.setResult(Preconditions.checkNotNull(t), true);
    }

    public boolean setFailure(Throwable th) {
        return super.setFailure((Throwable) Preconditions.checkNotNull(th));
    }

    public boolean setProgress(float f) {
        return super.setProgress(f);
    }
}

package com.facebook.yoga;

import com.facebook.jni.DestructorThread;

public class YogaNodeJNIPhantomRefs extends YogaNodeJNIBase {
    public YogaNodeJNIPhantomRefs() {
        registerPhantomRef(this, this.mNativePointer);
    }

    public YogaNodeJNIPhantomRefs(YogaConfig yogaConfig) {
        super(yogaConfig);
        registerPhantomRef(this, this.mNativePointer);
    }

    public YogaNodeJNIPhantomRefs cloneWithoutChildren() {
        YogaNodeJNIPhantomRefs yogaNodeJNIPhantomRefs = (YogaNodeJNIPhantomRefs) super.cloneWithoutChildren();
        registerPhantomRef(yogaNodeJNIPhantomRefs, yogaNodeJNIPhantomRefs.mNativePointer);
        return yogaNodeJNIPhantomRefs;
    }

    private static final void registerPhantomRef(YogaNode yogaNode, final long j) {
        new DestructorThread.Destructor(yogaNode) {
            private long mNativePointer = j;

            /* access modifiers changed from: protected */
            public void destruct() {
                long j = this.mNativePointer;
                if (j != 0) {
                    YogaNative.jni_YGNodeFree(j);
                    this.mNativePointer = 0;
                }
            }
        };
    }
}

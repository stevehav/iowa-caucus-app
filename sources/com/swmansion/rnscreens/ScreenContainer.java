package com.swmansion.rnscreens;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.react.modules.core.ChoreographerCompat;
import com.facebook.react.modules.core.ReactChoreographer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ScreenContainer extends ViewGroup {
    private final Set<Screen> mActiveScreens = new HashSet();
    @Nullable
    private FragmentTransaction mCurrentTransaction;
    private ChoreographerCompat.FrameCallback mFrameCallback = new ChoreographerCompat.FrameCallback() {
        public void doFrame(long j) {
            ScreenContainer.this.updateIfNeeded();
        }
    };
    private boolean mIsAttached;
    private boolean mNeedUpdate;
    private final ArrayList<Screen> mScreens = new ArrayList<>();

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public ScreenContainer(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void markUpdated() {
        if (!this.mNeedUpdate) {
            this.mNeedUpdate = true;
            ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mFrameCallback);
        }
    }

    /* access modifiers changed from: protected */
    public void notifyChildUpdate() {
        markUpdated();
    }

    /* access modifiers changed from: protected */
    public void addScreen(Screen screen, int i) {
        this.mScreens.add(i, screen);
        screen.setContainer(this);
        markUpdated();
    }

    /* access modifiers changed from: protected */
    public void removeScreenAt(int i) {
        this.mScreens.get(i).setContainer((ScreenContainer) null);
        this.mScreens.remove(i);
        markUpdated();
    }

    /* access modifiers changed from: protected */
    public int getScreenCount() {
        return this.mScreens.size();
    }

    /* access modifiers changed from: protected */
    public Screen getScreenAt(int i) {
        return this.mScreens.get(i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0012  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.fragment.app.FragmentActivity findRootFragmentActivity() {
        /*
            r3 = this;
            r0 = r3
        L_0x0001:
            boolean r1 = r0 instanceof com.facebook.react.ReactRootView
            if (r1 != 0) goto L_0x0010
            android.view.ViewParent r2 = r0.getParent()
            if (r2 == 0) goto L_0x0010
            android.view.ViewParent r0 = r0.getParent()
            goto L_0x0001
        L_0x0010:
            if (r1 == 0) goto L_0x0034
            com.facebook.react.ReactRootView r0 = (com.facebook.react.ReactRootView) r0
            android.content.Context r0 = r0.getContext()
        L_0x0018:
            boolean r1 = r0 instanceof androidx.fragment.app.FragmentActivity
            if (r1 != 0) goto L_0x0027
            boolean r2 = r0 instanceof android.content.ContextWrapper
            if (r2 == 0) goto L_0x0027
            android.content.ContextWrapper r0 = (android.content.ContextWrapper) r0
            android.content.Context r0 = r0.getBaseContext()
            goto L_0x0018
        L_0x0027:
            if (r1 == 0) goto L_0x002c
            androidx.fragment.app.FragmentActivity r0 = (androidx.fragment.app.FragmentActivity) r0
            return r0
        L_0x002c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "In order to use RNScreens components your app's activity need to extend ReactFragmentActivity or ReactCompatActivity"
            r0.<init>(r1)
            throw r0
        L_0x0034:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "ScreenContainer is not attached under ReactRootView"
            r0.<init>(r1)
            goto L_0x003d
        L_0x003c:
            throw r0
        L_0x003d:
            goto L_0x003c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenContainer.findRootFragmentActivity():androidx.fragment.app.FragmentActivity");
    }

    private FragmentTransaction getOrCreateTransaction() {
        if (this.mCurrentTransaction == null) {
            this.mCurrentTransaction = findRootFragmentActivity().getSupportFragmentManager().beginTransaction();
            this.mCurrentTransaction.setReorderingAllowed(true);
        }
        return this.mCurrentTransaction;
    }

    private void tryCommitTransaction() {
        FragmentTransaction fragmentTransaction = this.mCurrentTransaction;
        if (fragmentTransaction != null) {
            fragmentTransaction.commitAllowingStateLoss();
            this.mCurrentTransaction = null;
        }
    }

    private void attachScreen(Screen screen) {
        getOrCreateTransaction().add(getId(), screen.getFragment());
        this.mActiveScreens.add(screen);
    }

    private void moveToFront(Screen screen) {
        FragmentTransaction orCreateTransaction = getOrCreateTransaction();
        Fragment fragment = screen.getFragment();
        orCreateTransaction.remove(fragment);
        orCreateTransaction.add(getId(), fragment);
    }

    private void detachScreen(Screen screen) {
        getOrCreateTransaction().remove(screen.getFragment());
        this.mActiveScreens.remove(screen);
    }

    /* access modifiers changed from: protected */
    public boolean isScreenActive(Screen screen, List<Screen> list) {
        return screen.isActive();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsAttached = true;
        updateIfNeeded();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mIsAttached = false;
    }

    /* access modifiers changed from: private */
    public void updateIfNeeded() {
        if (this.mNeedUpdate && this.mIsAttached) {
            this.mNeedUpdate = false;
            HashSet hashSet = new HashSet(this.mActiveScreens);
            int size = this.mScreens.size();
            for (int i = 0; i < size; i++) {
                Screen screen = this.mScreens.get(i);
                if (!isScreenActive(screen, this.mScreens) && this.mActiveScreens.contains(screen)) {
                    detachScreen(screen);
                }
                hashSet.remove(screen);
            }
            if (!hashSet.isEmpty()) {
                Object[] array = hashSet.toArray();
                for (Object obj : array) {
                    detachScreen((Screen) obj);
                }
            }
            int size2 = this.mScreens.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size2; i3++) {
                if (isScreenActive(this.mScreens.get(i3), this.mScreens)) {
                    i2++;
                }
            }
            boolean z = i2 > 1;
            int size3 = this.mScreens.size();
            boolean z2 = false;
            for (int i4 = 0; i4 < size3; i4++) {
                Screen screen2 = this.mScreens.get(i4);
                boolean isScreenActive = isScreenActive(screen2, this.mScreens);
                if (isScreenActive && !this.mActiveScreens.contains(screen2)) {
                    attachScreen(screen2);
                    z2 = true;
                } else if (isScreenActive && z2) {
                    moveToFront(screen2);
                }
                screen2.setTransitioning(z);
            }
            tryCommitTransaction();
        }
    }
}

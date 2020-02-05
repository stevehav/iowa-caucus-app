package com.swmansion.rnscreens;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;

public class Screen extends ViewGroup implements ReactPointerEventsView {
    private boolean mActive;
    @Nullable
    private ScreenContainer mContainer;
    private final Fragment mFragment = new ScreenFragment(this);
    private boolean mTransitioning;

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public void setLayerType(int i, @Nullable Paint paint) {
    }

    public void setNeedsOffscreenAlphaCompositing(boolean z) {
    }

    public static class ScreenFragment extends Fragment {
        private Screen mScreenView;

        public ScreenFragment() {
            throw new IllegalStateException("Screen fragments should never be restored");
        }

        @SuppressLint({"ValidFragment"})
        public ScreenFragment(Screen screen) {
            this.mScreenView = screen;
        }

        public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
            return this.mScreenView;
        }
    }

    public Screen(Context context) {
        super(context);
    }

    public void setTransitioning(boolean z) {
        if (this.mTransitioning != z) {
            this.mTransitioning = z;
            super.setLayerType(z ? 2 : 0, (Paint) null);
        }
    }

    public boolean hasOverlappingRendering() {
        return this.mTransitioning;
    }

    public PointerEvents getPointerEvents() {
        return this.mTransitioning ? PointerEvents.NONE : PointerEvents.AUTO;
    }

    /* access modifiers changed from: protected */
    public void setContainer(@Nullable ScreenContainer screenContainer) {
        this.mContainer = screenContainer;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public ScreenContainer getContainer() {
        return this.mContainer;
    }

    /* access modifiers changed from: protected */
    public Fragment getFragment() {
        return this.mFragment;
    }

    public void setActive(boolean z) {
        if (z != this.mActive) {
            this.mActive = z;
            ScreenContainer screenContainer = this.mContainer;
            if (screenContainer != null) {
                screenContainer.notifyChildUpdate();
            }
        }
    }

    public boolean isActive() {
        return this.mActive;
    }
}

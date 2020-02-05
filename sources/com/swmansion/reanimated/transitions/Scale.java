package com.swmansion.reanimated.transitions;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;

public class Scale extends Visibility {
    static final String PROPNAME_SCALE_X = "scale:scaleX";
    static final String PROPNAME_SCALE_Y = "scale:scaleY";

    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        transitionValues.values.put(PROPNAME_SCALE_X, Float.valueOf(transitionValues.view.getScaleX()));
        transitionValues.values.put(PROPNAME_SCALE_Y, Float.valueOf(transitionValues.view.getScaleY()));
    }

    public Scale setDisappearedScale(float f) {
        if (f >= 0.0f) {
            return this;
        }
        throw new IllegalArgumentException("disappearedScale cannot be negative!");
    }

    private Animator createAnimation(final View view, float f, float f2, TransitionValues transitionValues) {
        final float scaleX = view.getScaleX();
        final float scaleY = view.getScaleY();
        float f3 = scaleX * f;
        float f4 = scaleX * f2;
        float f5 = f * scaleY;
        float f6 = f2 * scaleY;
        if (transitionValues != null) {
            Float f7 = (Float) transitionValues.values.get(PROPNAME_SCALE_X);
            Float f8 = (Float) transitionValues.values.get(PROPNAME_SCALE_Y);
            if (!(f7 == null || f7.floatValue() == scaleX)) {
                f3 = f7.floatValue();
            }
            if (!(f8 == null || f8.floatValue() == scaleY)) {
                f5 = f8.floatValue();
            }
        }
        view.setScaleX(f3);
        view.setScaleY(f5);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view, View.SCALE_X, new float[]{f3, f4}), ObjectAnimator.ofFloat(view, View.SCALE_Y, new float[]{f5, f6})});
        addListener(new TransitionListenerAdapter() {
            public void onTransitionEnd(Transition transition) {
                view.setScaleX(scaleX);
                view.setScaleY(scaleY);
                transition.removeListener(this);
            }
        });
        return animatorSet;
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createAnimation(view, 0.0f, 1.0f, transitionValues);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createAnimation(view, 1.0f, 0.0f, transitionValues);
    }
}

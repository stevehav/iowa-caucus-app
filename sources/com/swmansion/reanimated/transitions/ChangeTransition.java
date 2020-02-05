package com.swmansion.reanimated.transitions;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.transition.ChangeBounds;
import androidx.transition.ChangeTransform;
import androidx.transition.Transition;
import androidx.transition.TransitionPropagation;
import androidx.transition.TransitionValues;

final class ChangeTransition extends Transition {
    private final ChangeBounds mChangeBounds = new ChangeBounds();
    private final ChangeTransform mChangeTransform = new ChangeTransform();

    public void captureStartValues(TransitionValues transitionValues) {
        this.mChangeTransform.captureStartValues(transitionValues);
        this.mChangeBounds.captureStartValues(transitionValues);
    }

    public void captureEndValues(TransitionValues transitionValues) {
        this.mChangeTransform.captureEndValues(transitionValues);
        this.mChangeBounds.captureEndValues(transitionValues);
    }

    public Transition setDuration(long j) {
        this.mChangeTransform.setDuration(j);
        this.mChangeBounds.setDuration(j);
        return super.setDuration(j);
    }

    public Transition setStartDelay(long j) {
        this.mChangeTransform.setStartDelay(j);
        this.mChangeBounds.setStartDelay(j);
        return super.setStartDelay(j);
    }

    public Transition setInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        this.mChangeTransform.setInterpolator(timeInterpolator);
        this.mChangeBounds.setInterpolator(timeInterpolator);
        return super.setInterpolator(timeInterpolator);
    }

    public void setPropagation(@Nullable TransitionPropagation transitionPropagation) {
        this.mChangeTransform.setPropagation(transitionPropagation);
        this.mChangeBounds.setPropagation(transitionPropagation);
        super.setPropagation(transitionPropagation);
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        Animator createAnimator = this.mChangeTransform.createAnimator(viewGroup, transitionValues, transitionValues2);
        Animator createAnimator2 = this.mChangeBounds.createAnimator(viewGroup, transitionValues, transitionValues2);
        if (createAnimator == null) {
            return createAnimator2;
        }
        if (createAnimator2 == null) {
            return createAnimator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{createAnimator, createAnimator2});
        return animatorSet;
    }
}

package com.swmansion.reanimated.transitions;

import android.view.ViewGroup;
import androidx.transition.SidePropagation;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;

public class SaneSidePropagation extends SidePropagation {
    public long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        long startDelay = super.getStartDelay(viewGroup, transition, transitionValues, transitionValues2);
        if (startDelay != 0) {
            return (transitionValues2 == null || getViewVisibility(transitionValues) == 0) ? -startDelay : startDelay;
        }
        return startDelay;
    }
}

package com.google.firebase.firestore.core;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class ActivityScope {
    private static final String FRAGMENT_TAG = "FirestoreOnStopObserverFragment";
    private static final String SUPPORT_FRAGMENT_TAG = "FirestoreOnStopObserverSupportFragment";

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    private static class CallbackList {
        private final List<Runnable> callbacks;

        private CallbackList() {
            this.callbacks = new ArrayList();
        }

        /* access modifiers changed from: package-private */
        public void run() {
            for (Runnable next : this.callbacks) {
                if (next != null) {
                    next.run();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized void add(Runnable runnable) {
            this.callbacks.add(runnable);
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public static class StopListenerSupportFragment extends Fragment {
        CallbackList callbacks = new CallbackList();

        public void onStop() {
            CallbackList callbackList;
            super.onStop();
            synchronized (this.callbacks) {
                callbackList = this.callbacks;
                this.callbacks = new CallbackList();
            }
            callbackList.run();
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public static class StopListenerFragment extends android.app.Fragment {
        CallbackList callbacks = new CallbackList();

        public void onStop() {
            CallbackList callbackList;
            super.onStop();
            synchronized (this.callbacks) {
                callbackList = this.callbacks;
                this.callbacks = new CallbackList();
            }
            callbackList.run();
        }
    }

    @Nullable
    private static <T> T castFragment(Class<T> cls, @Nullable Object obj, String str) {
        if (obj == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            throw new IllegalStateException("Fragment with tag '" + str + "' is a " + obj.getClass().getName() + " but should be a " + cls.getName());
        }
    }

    private static void onActivityStopCallOnce(Activity activity, Runnable runnable) {
        Assert.hardAssert(!(activity instanceof FragmentActivity), "onActivityStopCallOnce must be called with a *non*-FragmentActivity Activity.", new Object[0]);
        activity.runOnUiThread(ActivityScope$$Lambda$1.lambdaFactory$(activity, runnable));
    }

    static /* synthetic */ void lambda$onActivityStopCallOnce$0(Activity activity, Runnable runnable) {
        StopListenerFragment stopListenerFragment = (StopListenerFragment) castFragment(StopListenerFragment.class, activity.getFragmentManager().findFragmentByTag(FRAGMENT_TAG), FRAGMENT_TAG);
        if (stopListenerFragment == null || stopListenerFragment.isRemoving()) {
            stopListenerFragment = new StopListenerFragment();
            activity.getFragmentManager().beginTransaction().add(stopListenerFragment, FRAGMENT_TAG).commitAllowingStateLoss();
            activity.getFragmentManager().executePendingTransactions();
        }
        stopListenerFragment.callbacks.add(runnable);
    }

    private static void onFragmentActivityStopCallOnce(FragmentActivity fragmentActivity, Runnable runnable) {
        fragmentActivity.runOnUiThread(ActivityScope$$Lambda$2.lambdaFactory$(fragmentActivity, runnable));
    }

    static /* synthetic */ void lambda$onFragmentActivityStopCallOnce$1(FragmentActivity fragmentActivity, Runnable runnable) {
        StopListenerSupportFragment stopListenerSupportFragment = (StopListenerSupportFragment) castFragment(StopListenerSupportFragment.class, fragmentActivity.getSupportFragmentManager().findFragmentByTag(SUPPORT_FRAGMENT_TAG), SUPPORT_FRAGMENT_TAG);
        if (stopListenerSupportFragment == null || stopListenerSupportFragment.isRemoving()) {
            stopListenerSupportFragment = new StopListenerSupportFragment();
            fragmentActivity.getSupportFragmentManager().beginTransaction().add((Fragment) stopListenerSupportFragment, SUPPORT_FRAGMENT_TAG).commitAllowingStateLoss();
            fragmentActivity.getSupportFragmentManager().executePendingTransactions();
        }
        stopListenerSupportFragment.callbacks.add(runnable);
    }

    public static ListenerRegistration bind(@Nullable Activity activity, ListenerRegistration listenerRegistration) {
        if (activity != null) {
            if (activity instanceof FragmentActivity) {
                listenerRegistration.getClass();
                onFragmentActivityStopCallOnce((FragmentActivity) activity, ActivityScope$$Lambda$3.lambdaFactory$(listenerRegistration));
            } else {
                listenerRegistration.getClass();
                onActivityStopCallOnce(activity, ActivityScope$$Lambda$4.lambdaFactory$(listenerRegistration));
            }
        }
        return listenerRegistration;
    }
}

package com.swmansion.reanimated;

import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.GuardedFrameCallback;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.UIImplementation;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.UIManagerReanimatedHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.swmansion.reanimated.nodes.AlwaysNode;
import com.swmansion.reanimated.nodes.BezierNode;
import com.swmansion.reanimated.nodes.BlockNode;
import com.swmansion.reanimated.nodes.CallFuncNode;
import com.swmansion.reanimated.nodes.ClockNode;
import com.swmansion.reanimated.nodes.ClockOpNode;
import com.swmansion.reanimated.nodes.ConcatNode;
import com.swmansion.reanimated.nodes.CondNode;
import com.swmansion.reanimated.nodes.DebugNode;
import com.swmansion.reanimated.nodes.EventNode;
import com.swmansion.reanimated.nodes.FunctionNode;
import com.swmansion.reanimated.nodes.JSCallNode;
import com.swmansion.reanimated.nodes.Node;
import com.swmansion.reanimated.nodes.NoopNode;
import com.swmansion.reanimated.nodes.OperatorNode;
import com.swmansion.reanimated.nodes.ParamNode;
import com.swmansion.reanimated.nodes.PropsNode;
import com.swmansion.reanimated.nodes.SetNode;
import com.swmansion.reanimated.nodes.StyleNode;
import com.swmansion.reanimated.nodes.TransformNode;
import com.swmansion.reanimated.nodes.ValueNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class NodesManager implements EventDispatcherListener {
    private static final Double ZERO = Double.valueOf(0.0d);
    public double currentFrameTimeMs;
    private final SparseArray<Node> mAnimatedNodes = new SparseArray<>();
    private final AtomicBoolean mCallbackPosted = new AtomicBoolean();
    private final GuardedFrameCallback mChoreographerCallback;
    private final ReactContext mContext;
    private final UIManagerModule.CustomEventNamesResolver mCustomEventNamesResolver;
    private final DeviceEventManagerModule.RCTDeviceEventEmitter mEventEmitter;
    private final Map<String, EventNode> mEventMapping = new HashMap();
    private ConcurrentLinkedQueue<Event> mEventQueue = new ConcurrentLinkedQueue<>();
    private List<OnAnimationFrame> mFrameCallbacks = new ArrayList();
    private final NoopNode mNoopNode;
    private Queue<NativeUpdateOperation> mOperationsInBatch = new LinkedList();
    private final ReactChoreographer mReactChoreographer;
    /* access modifiers changed from: private */
    public final UIImplementation mUIImplementation;
    /* access modifiers changed from: private */
    public final UIManagerModule mUIManager;
    private boolean mWantRunUpdates;
    public Set<String> nativeProps = Collections.emptySet();
    public Set<String> uiProps = Collections.emptySet();
    public final UpdateContext updateContext;

    public interface OnAnimationFrame {
        void onAnimationFrame();
    }

    private final class NativeUpdateOperation {
        public WritableMap mNativeProps;
        public int mViewTag;

        public NativeUpdateOperation(int i, WritableMap writableMap) {
            this.mViewTag = i;
            this.mNativeProps = writableMap;
        }
    }

    public NodesManager(ReactContext reactContext) {
        this.mContext = reactContext;
        this.mUIManager = (UIManagerModule) reactContext.getNativeModule(UIManagerModule.class);
        this.updateContext = new UpdateContext();
        this.mUIImplementation = this.mUIManager.getUIImplementation();
        this.mCustomEventNamesResolver = this.mUIManager.getDirectEventNamesResolver();
        this.mUIManager.getEventDispatcher().addListener(this);
        this.mEventEmitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
        this.mReactChoreographer = ReactChoreographer.getInstance();
        this.mChoreographerCallback = new GuardedFrameCallback(reactContext) {
            /* access modifiers changed from: protected */
            public void doFrameGuarded(long j) {
                NodesManager.this.onAnimationFrame(j);
            }
        };
        this.mNoopNode = new NoopNode(this);
    }

    public void onHostPause() {
        if (this.mCallbackPosted.get()) {
            stopUpdatingOnAnimationFrame();
            this.mCallbackPosted.set(true);
        }
    }

    public void onHostResume() {
        if (this.mCallbackPosted.getAndSet(false)) {
            startUpdatingOnAnimationFrame();
        }
    }

    private void startUpdatingOnAnimationFrame() {
        if (!this.mCallbackPosted.getAndSet(true)) {
            this.mReactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mChoreographerCallback);
        }
    }

    private void stopUpdatingOnAnimationFrame() {
        if (this.mCallbackPosted.getAndSet(false)) {
            this.mReactChoreographer.removeFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mChoreographerCallback);
        }
    }

    /* access modifiers changed from: private */
    public void onAnimationFrame(long j) {
        double d = (double) j;
        Double.isNaN(d);
        this.currentFrameTimeMs = d / 1000000.0d;
        while (!this.mEventQueue.isEmpty()) {
            handleEvent(this.mEventQueue.poll());
        }
        if (!this.mFrameCallbacks.isEmpty()) {
            List<OnAnimationFrame> list = this.mFrameCallbacks;
            this.mFrameCallbacks = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                list.get(i).onAnimationFrame();
            }
        }
        if (this.mWantRunUpdates) {
            Node.runUpdates(this.updateContext);
        }
        if (!this.mOperationsInBatch.isEmpty()) {
            final Queue<NativeUpdateOperation> queue = this.mOperationsInBatch;
            this.mOperationsInBatch = new LinkedList();
            ReactContext reactContext = this.mContext;
            reactContext.runOnNativeModulesQueueThread(new GuardedRunnable(reactContext) {
                public void runGuarded() {
                    boolean isOperationQueueEmpty = UIManagerReanimatedHelper.isOperationQueueEmpty(NodesManager.this.mUIImplementation);
                    while (!queue.isEmpty()) {
                        NativeUpdateOperation nativeUpdateOperation = (NativeUpdateOperation) queue.remove();
                        ReactShadowNode resolveShadowNode = NodesManager.this.mUIImplementation.resolveShadowNode(nativeUpdateOperation.mViewTag);
                        if (resolveShadowNode != null) {
                            NodesManager.this.mUIManager.updateView(nativeUpdateOperation.mViewTag, resolveShadowNode.getViewClass(), nativeUpdateOperation.mNativeProps);
                        }
                    }
                    if (isOperationQueueEmpty) {
                        NodesManager.this.mUIImplementation.dispatchViewUpdates(-1);
                    }
                }
            });
        }
        this.mCallbackPosted.set(false);
        this.mWantRunUpdates = false;
        if (!this.mFrameCallbacks.isEmpty() || !this.mEventQueue.isEmpty()) {
            startUpdatingOnAnimationFrame();
        }
    }

    public Object getNodeValue(int i) {
        Node node = this.mAnimatedNodes.get(i);
        if (node != null) {
            return node.value();
        }
        return ZERO;
    }

    public <T extends Node> T findNodeById(int i, Class<T> cls) {
        T t = (Node) this.mAnimatedNodes.get(i);
        if (t == null) {
            if (cls == Node.class || cls == ValueNode.class) {
                return this.mNoopNode;
            }
            throw new IllegalArgumentException("Requested node with id " + i + " of type " + cls + " cannot be found");
        } else if (cls.isInstance(t)) {
            return t;
        } else {
            throw new IllegalArgumentException("Node with id " + i + " is of incompatible type " + t.getClass() + ", requested type was " + cls);
        }
    }

    public void createNode(int i, ReadableMap readableMap) {
        Object obj;
        if (this.mAnimatedNodes.get(i) == null) {
            String string = readableMap.getString("type");
            if ("props".equals(string)) {
                obj = new PropsNode(i, readableMap, this, this.mUIImplementation);
            } else if ("style".equals(string)) {
                obj = new StyleNode(i, readableMap, this);
            } else if (ViewProps.TRANSFORM.equals(string)) {
                obj = new TransformNode(i, readableMap, this);
            } else if ("value".equals(string)) {
                obj = new ValueNode(i, readableMap, this);
            } else if ("block".equals(string)) {
                obj = new BlockNode(i, readableMap, this);
            } else if ("cond".equals(string)) {
                obj = new CondNode(i, readableMap, this);
            } else if ("op".equals(string)) {
                obj = new OperatorNode(i, readableMap, this);
            } else if ("set".equals(string)) {
                obj = new SetNode(i, readableMap, this);
            } else if ("debug".equals(string)) {
                obj = new DebugNode(i, readableMap, this);
            } else if ("clock".equals(string)) {
                obj = new ClockNode(i, readableMap, this);
            } else if ("clockStart".equals(string)) {
                obj = new ClockOpNode.ClockStartNode(i, readableMap, this);
            } else if ("clockStop".equals(string)) {
                obj = new ClockOpNode.ClockStopNode(i, readableMap, this);
            } else if ("clockTest".equals(string)) {
                obj = new ClockOpNode.ClockTestNode(i, readableMap, this);
            } else if (NotificationCompat.CATEGORY_CALL.equals(string)) {
                obj = new JSCallNode(i, readableMap, this);
            } else if ("bezier".equals(string)) {
                obj = new BezierNode(i, readableMap, this);
            } else if (NotificationCompat.CATEGORY_EVENT.equals(string)) {
                obj = new EventNode(i, readableMap, this);
            } else if (ReactScrollViewHelper.OVER_SCROLL_ALWAYS.equals(string)) {
                obj = new AlwaysNode(i, readableMap, this);
            } else if ("concat".equals(string)) {
                obj = new ConcatNode(i, readableMap, this);
            } else if ("param".equals(string)) {
                obj = new ParamNode(i, readableMap, this);
            } else if ("func".equals(string)) {
                obj = new FunctionNode(i, readableMap, this);
            } else if ("callfunc".equals(string)) {
                obj = new CallFuncNode(i, readableMap, this);
            } else {
                throw new JSApplicationIllegalArgumentException("Unsupported node type: " + string);
            }
            this.mAnimatedNodes.put(i, obj);
            return;
        }
        throw new JSApplicationIllegalArgumentException("Animated node with ID " + i + " already exists");
    }

    public void dropNode(int i) {
        this.mAnimatedNodes.remove(i);
    }

    public void connectNodes(int i, int i2) {
        Node node = this.mAnimatedNodes.get(i);
        if (node != null) {
            Node node2 = this.mAnimatedNodes.get(i2);
            if (node2 != null) {
                node.addChild(node2);
                return;
            }
            throw new JSApplicationIllegalArgumentException("Animated node with ID " + i2 + " does not exists");
        }
        throw new JSApplicationIllegalArgumentException("Animated node with ID " + i + " does not exists");
    }

    public void disconnectNodes(int i, int i2) {
        Node node = this.mAnimatedNodes.get(i);
        if (node != null) {
            Node node2 = this.mAnimatedNodes.get(i2);
            if (node2 != null) {
                node.removeChild(node2);
                return;
            }
            throw new JSApplicationIllegalArgumentException("Animated node with ID " + i2 + " does not exists");
        }
        throw new JSApplicationIllegalArgumentException("Animated node with ID " + i + " does not exists");
    }

    public void connectNodeToView(int i, int i2) {
        Node node = this.mAnimatedNodes.get(i);
        if (node == null) {
            throw new JSApplicationIllegalArgumentException("Animated node with ID " + i + " does not exists");
        } else if (node instanceof PropsNode) {
            ((PropsNode) node).connectToView(i2);
        } else {
            throw new JSApplicationIllegalArgumentException("Animated node connected to view should beof type " + PropsNode.class.getName());
        }
    }

    public void disconnectNodeFromView(int i, int i2) {
        Node node = this.mAnimatedNodes.get(i);
        if (node == null) {
            throw new JSApplicationIllegalArgumentException("Animated node with ID " + i + " does not exists");
        } else if (node instanceof PropsNode) {
            ((PropsNode) node).disconnectFromView(i2);
        } else {
            throw new JSApplicationIllegalArgumentException("Animated node connected to view should beof type " + PropsNode.class.getName());
        }
    }

    public void enqueueUpdateViewOnNativeThread(int i, WritableMap writableMap) {
        this.mOperationsInBatch.add(new NativeUpdateOperation(i, writableMap));
    }

    public void attachEvent(int i, String str, int i2) {
        String str2 = i + str;
        EventNode eventNode = (EventNode) this.mAnimatedNodes.get(i2);
        if (eventNode == null) {
            throw new JSApplicationIllegalArgumentException("Event node " + i2 + " does not exists");
        } else if (!this.mEventMapping.containsKey(str2)) {
            this.mEventMapping.put(str2, eventNode);
        } else {
            throw new JSApplicationIllegalArgumentException("Event handler already set for the given view and event type");
        }
    }

    public void detachEvent(int i, String str, int i2) {
        this.mEventMapping.remove(i + str);
    }

    public void configureProps(Set<String> set, Set<String> set2) {
        this.nativeProps = set;
        this.uiProps = set2;
    }

    public void getValue(int i, Callback callback) {
        callback.invoke(this.mAnimatedNodes.get(i).value());
    }

    public void postRunUpdatesAfterAnimation() {
        this.mWantRunUpdates = true;
        startUpdatingOnAnimationFrame();
    }

    public void postOnAnimation(OnAnimationFrame onAnimationFrame) {
        this.mFrameCallbacks.add(onAnimationFrame);
        startUpdatingOnAnimationFrame();
    }

    public void onEventDispatch(Event event) {
        if (UiThreadUtil.isOnUiThread()) {
            handleEvent(event);
            return;
        }
        this.mEventQueue.offer(event);
        startUpdatingOnAnimationFrame();
    }

    private void handleEvent(Event event) {
        if (!this.mEventMapping.isEmpty()) {
            String resolveCustomEventName = this.mCustomEventNamesResolver.resolveCustomEventName(event.getEventName());
            int viewTag = event.getViewTag();
            EventNode eventNode = this.mEventMapping.get(viewTag + resolveCustomEventName);
            if (eventNode != null) {
                event.dispatch(eventNode);
            }
        }
    }

    public void sendEvent(String str, WritableMap writableMap) {
        this.mEventEmitter.emit(str, writableMap);
    }
}

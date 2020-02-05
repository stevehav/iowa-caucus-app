package com.horcrux.svg;

import android.graphics.Matrix;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.MatrixMathHelper;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.TransformHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import java.lang.reflect.Array;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

class RenderableViewManager extends ViewGroupManager<VirtualView> {
    private static final float CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER = 5.0f;
    private static final double EPSILON = 1.0E-5d;
    private static final int PERSPECTIVE_ARRAY_INVERTED_CAMERA_DISTANCE_INDEX = 2;
    private static final SparseArray<RenderableView> mTagToRenderableView = new SparseArray<>();
    private static final SparseArray<Runnable> mTagToRunnable = new SparseArray<>();
    private static final MatrixDecompositionContext sMatrixDecompositionContext = new MatrixDecompositionContext();
    private static final double[] sTransformDecompositionArray = new double[16];
    private final String mClassName;
    private final SVGClass svgClass;

    private enum SVGClass {
        RNSVGGroup,
        RNSVGPath,
        RNSVGText,
        RNSVGTSpan,
        RNSVGTextPath,
        RNSVGImage,
        RNSVGCircle,
        RNSVGEllipse,
        RNSVGLine,
        RNSVGRect,
        RNSVGClipPath,
        RNSVGDefs,
        RNSVGUse,
        RNSVGSymbol,
        RNSVGLinearGradient,
        RNSVGRadialGradient,
        RNSVGPattern,
        RNSVGMask,
        RNSVGMarker
    }

    class RenderableShadowNode extends LayoutShadowNode {
        @ReactPropGroup(names = {"alignSelf", "alignItems", "collapsable", "flex", "flexBasis", "flexDirection", "flexGrow", "flexShrink", "flexWrap", "justifyContent", "overflow", "alignContent", "display", "position", "right", "top", "bottom", "left", "start", "end", "width", "height", "minWidth", "maxWidth", "minHeight", "maxHeight", "margin", "marginVertical", "marginHorizontal", "marginLeft", "marginRight", "marginTop", "marginBottom", "marginStart", "marginEnd", "padding", "paddingVertical", "paddingHorizontal", "paddingLeft", "paddingRight", "paddingTop", "paddingBottom", "paddingStart", "paddingEnd", "borderWidth", "borderStartWidth", "borderEndWidth", "borderTopWidth", "borderBottomWidth", "borderLeftWidth", "borderRightWidth"})
        public void ignoreLayoutProps(int i, Dynamic dynamic) {
        }

        RenderableShadowNode() {
        }
    }

    public LayoutShadowNode createShadowNodeInstance() {
        return new RenderableShadowNode();
    }

    public Class<RenderableShadowNode> getShadowNodeClass() {
        return RenderableShadowNode.class;
    }

    static class MatrixDecompositionContext extends MatrixMathHelper.MatrixDecompositionContext {
        final double[] perspective = new double[4];
        final double[] rotationDegrees = new double[3];
        final double[] scale = new double[3];
        final double[] skew = new double[3];
        final double[] translation = new double[3];

        MatrixDecompositionContext() {
        }
    }

    private static boolean isZero(double d) {
        return !Double.isNaN(d) && Math.abs(d) < 1.0E-5d;
    }

    private static void decomposeMatrix() {
        double[] dArr = sMatrixDecompositionContext.perspective;
        double[] dArr2 = sMatrixDecompositionContext.scale;
        double[] dArr3 = sMatrixDecompositionContext.skew;
        double[] dArr4 = sMatrixDecompositionContext.translation;
        double[] dArr5 = sMatrixDecompositionContext.rotationDegrees;
        if (!isZero(sTransformDecompositionArray[15])) {
            double[][] dArr6 = (double[][]) Array.newInstance(double.class, new int[]{4, 4});
            double[] dArr7 = new double[16];
            for (int i = 0; i < 4; i++) {
                for (int i2 = 0; i2 < 4; i2++) {
                    double[] dArr8 = sTransformDecompositionArray;
                    int i3 = (i * 4) + i2;
                    double d = dArr8[i3] / dArr8[15];
                    dArr6[i][i2] = d;
                    if (i2 == 3) {
                        d = 0.0d;
                    }
                    dArr7[i3] = d;
                }
            }
            dArr7[15] = 1.0d;
            if (!isZero(MatrixMathHelper.determinant(dArr7))) {
                if (!isZero(dArr6[0][3]) || !isZero(dArr6[1][3]) || !isZero(dArr6[2][3])) {
                    MatrixMathHelper.multiplyVectorByMatrix(new double[]{dArr6[0][3], dArr6[1][3], dArr6[2][3], dArr6[3][3]}, MatrixMathHelper.transpose(MatrixMathHelper.inverse(dArr7)), dArr);
                } else {
                    dArr[2] = 0.0d;
                    dArr[1] = 0.0d;
                    dArr[0] = 0.0d;
                    dArr[3] = 1.0d;
                }
                System.arraycopy(dArr6[3], 0, dArr4, 0, 3);
                double[][] dArr9 = (double[][]) Array.newInstance(double.class, new int[]{3, 3});
                for (int i4 = 0; i4 < 3; i4++) {
                    dArr9[i4][0] = dArr6[i4][0];
                    dArr9[i4][1] = dArr6[i4][1];
                    dArr9[i4][2] = dArr6[i4][2];
                }
                dArr2[0] = MatrixMathHelper.v3Length(dArr9[0]);
                dArr9[0] = MatrixMathHelper.v3Normalize(dArr9[0], dArr2[0]);
                dArr3[0] = MatrixMathHelper.v3Dot(dArr9[0], dArr9[1]);
                dArr9[1] = MatrixMathHelper.v3Combine(dArr9[1], dArr9[0], 1.0d, -dArr3[0]);
                dArr3[0] = MatrixMathHelper.v3Dot(dArr9[0], dArr9[1]);
                dArr9[1] = MatrixMathHelper.v3Combine(dArr9[1], dArr9[0], 1.0d, -dArr3[0]);
                dArr2[1] = MatrixMathHelper.v3Length(dArr9[1]);
                dArr9[1] = MatrixMathHelper.v3Normalize(dArr9[1], dArr2[1]);
                dArr3[0] = dArr3[0] / dArr2[1];
                dArr3[1] = MatrixMathHelper.v3Dot(dArr9[0], dArr9[2]);
                dArr9[2] = MatrixMathHelper.v3Combine(dArr9[2], dArr9[0], 1.0d, -dArr3[1]);
                dArr3[2] = MatrixMathHelper.v3Dot(dArr9[1], dArr9[2]);
                dArr9[2] = MatrixMathHelper.v3Combine(dArr9[2], dArr9[1], 1.0d, -dArr3[2]);
                dArr2[2] = MatrixMathHelper.v3Length(dArr9[2]);
                dArr9[2] = MatrixMathHelper.v3Normalize(dArr9[2], dArr2[2]);
                dArr3[1] = dArr3[1] / dArr2[2];
                dArr3[2] = dArr3[2] / dArr2[2];
                if (MatrixMathHelper.v3Dot(dArr9[0], MatrixMathHelper.v3Cross(dArr9[1], dArr9[2])) < 0.0d) {
                    for (int i5 = 0; i5 < 3; i5++) {
                        dArr2[i5] = dArr2[i5] * -1.0d;
                        double[] dArr10 = dArr9[i5];
                        dArr10[0] = dArr10[0] * -1.0d;
                        double[] dArr11 = dArr9[i5];
                        dArr11[1] = dArr11[1] * -1.0d;
                        double[] dArr12 = dArr9[i5];
                        dArr12[2] = dArr12[2] * -1.0d;
                    }
                }
                dArr5[0] = MatrixMathHelper.roundTo3Places((-Math.atan2(dArr9[2][1], dArr9[2][2])) * 57.29577951308232d);
                dArr5[1] = MatrixMathHelper.roundTo3Places((-Math.atan2(-dArr9[2][0], Math.sqrt((dArr9[2][1] * dArr9[2][1]) + (dArr9[2][2] * dArr9[2][2])))) * 57.29577951308232d);
                dArr5[2] = MatrixMathHelper.roundTo3Places((-Math.atan2(dArr9[1][0], dArr9[0][0])) * 57.29577951308232d);
            }
        }
    }

    private static void setTransformProperty(View view, ReadableArray readableArray) {
        TransformHelper.processTransform(readableArray, sTransformDecompositionArray);
        decomposeMatrix();
        view.setTranslationX(PixelUtil.toPixelFromDIP((float) sMatrixDecompositionContext.translation[0]));
        view.setTranslationY(PixelUtil.toPixelFromDIP((float) sMatrixDecompositionContext.translation[1]));
        view.setRotation((float) sMatrixDecompositionContext.rotationDegrees[2]);
        view.setRotationX((float) sMatrixDecompositionContext.rotationDegrees[0]);
        view.setRotationY((float) sMatrixDecompositionContext.rotationDegrees[1]);
        view.setScaleX((float) sMatrixDecompositionContext.scale[0]);
        view.setScaleY((float) sMatrixDecompositionContext.scale[1]);
        double[] dArr = sMatrixDecompositionContext.perspective;
        if (dArr.length > 2) {
            float f = (float) dArr[2];
            if (f == 0.0f) {
                f = 7.8125E-4f;
            }
            float f2 = -1.0f / f;
            float f3 = DisplayMetricsHolder.getScreenDisplayMetrics().density;
            view.setCameraDistance(f3 * f3 * f2 * CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        }
    }

    private static void resetTransformProperty(View view) {
        view.setTranslationX(PixelUtil.toPixelFromDIP(0.0f));
        view.setTranslationY(PixelUtil.toPixelFromDIP(0.0f));
        view.setRotation(0.0f);
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setCameraDistance(0.0f);
    }

    static class GroupViewManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(@Nonnull ThemedReactContext themedReactContext, @Nonnull View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        @Nonnull
        public /* bridge */ /* synthetic */ View createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(@Nonnull View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        public /* bridge */ /* synthetic */ void onDropViewInstance(@Nonnull View view) {
            RenderableViewManager.super.onDropViewInstance((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        GroupViewManager() {
            super(SVGClass.RNSVGGroup);
        }

        GroupViewManager(SVGClass sVGClass) {
            super(sVGClass);
        }

        @ReactProp(name = "font")
        public void setFont(GroupView groupView, @Nullable ReadableMap readableMap) {
            groupView.setFont(readableMap);
        }

        @ReactProp(name = "fontSize")
        public void setFontSize(GroupView groupView, Dynamic dynamic) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            int i = AnonymousClass2.$SwitchMap$com$facebook$react$bridge$ReadableType[dynamic.getType().ordinal()];
            if (i == 1) {
                javaOnlyMap.putDouble(ViewProps.FONT_SIZE, dynamic.asDouble());
            } else if (i == 2) {
                javaOnlyMap.putString(ViewProps.FONT_SIZE, dynamic.asString());
            } else {
                return;
            }
            groupView.setFont(javaOnlyMap);
        }

        @ReactProp(name = "fontWeight")
        public void setFontWeight(GroupView groupView, Dynamic dynamic) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            int i = AnonymousClass2.$SwitchMap$com$facebook$react$bridge$ReadableType[dynamic.getType().ordinal()];
            if (i == 1) {
                javaOnlyMap.putDouble(ViewProps.FONT_WEIGHT, dynamic.asDouble());
            } else if (i == 2) {
                javaOnlyMap.putString(ViewProps.FONT_WEIGHT, dynamic.asString());
            } else {
                return;
            }
            groupView.setFont(javaOnlyMap);
        }
    }

    static class PathViewManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(@Nonnull ThemedReactContext themedReactContext, @Nonnull View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        @Nonnull
        public /* bridge */ /* synthetic */ View createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(@Nonnull View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        public /* bridge */ /* synthetic */ void onDropViewInstance(@Nonnull View view) {
            RenderableViewManager.super.onDropViewInstance((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        PathViewManager() {
            super(SVGClass.RNSVGPath);
        }

        @ReactProp(name = "d")
        public void setD(PathView pathView, String str) {
            pathView.setD(str);
        }
    }

    static class TextViewManager extends GroupViewManager {
        TextViewManager() {
            super(SVGClass.RNSVGText);
        }

        TextViewManager(SVGClass sVGClass) {
            super(sVGClass);
        }

        @ReactProp(name = "inlineSize")
        public void setInlineSize(TextView textView, Dynamic dynamic) {
            textView.setInlineSize(dynamic);
        }

        @ReactProp(name = "textLength")
        public void setTextLength(TextView textView, Dynamic dynamic) {
            textView.setTextLength(dynamic);
        }

        @ReactProp(name = "lengthAdjust")
        public void setLengthAdjust(TextView textView, @Nullable String str) {
            textView.setLengthAdjust(str);
        }

        @ReactProp(name = "alignmentBaseline")
        public void setMethod(TextView textView, @Nullable String str) {
            textView.setMethod(str);
        }

        @ReactProp(name = "baselineShift")
        public void setBaselineShift(TextView textView, Dynamic dynamic) {
            textView.setBaselineShift(dynamic);
        }

        @ReactProp(name = "verticalAlign")
        public void setVerticalAlign(TextView textView, @Nullable String str) {
            textView.setVerticalAlign(str);
        }

        @ReactProp(name = "rotate")
        public void setRotate(TextView textView, Dynamic dynamic) {
            textView.setRotate(dynamic);
        }

        @ReactProp(name = "dx")
        public void setDeltaX(TextView textView, Dynamic dynamic) {
            textView.setDeltaX(dynamic);
        }

        @ReactProp(name = "dy")
        public void setDeltaY(TextView textView, Dynamic dynamic) {
            textView.setDeltaY(dynamic);
        }

        @ReactProp(name = "x")
        public void setX(TextView textView, Dynamic dynamic) {
            textView.setPositionX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(TextView textView, Dynamic dynamic) {
            textView.setPositionY(dynamic);
        }

        @ReactProp(name = "font")
        public void setFont(TextView textView, @Nullable ReadableMap readableMap) {
            textView.setFont(readableMap);
        }
    }

    static class TSpanViewManager extends TextViewManager {
        TSpanViewManager() {
            super(SVGClass.RNSVGTSpan);
        }

        @ReactProp(name = "content")
        public void setContent(TSpanView tSpanView, @Nullable String str) {
            tSpanView.setContent(str);
        }
    }

    static class TextPathViewManager extends TextViewManager {
        TextPathViewManager() {
            super(SVGClass.RNSVGTextPath);
        }

        @ReactProp(name = "href")
        public void setHref(TextPathView textPathView, String str) {
            textPathView.setHref(str);
        }

        @ReactProp(name = "startOffset")
        public void setStartOffset(TextPathView textPathView, Dynamic dynamic) {
            textPathView.setStartOffset(dynamic);
        }

        @ReactProp(name = "method")
        public void setMethod(TextPathView textPathView, @Nullable String str) {
            textPathView.setMethod(str);
        }

        @ReactProp(name = "spacing")
        public void setSpacing(TextPathView textPathView, @Nullable String str) {
            textPathView.setSpacing(str);
        }

        @ReactProp(name = "side")
        public void setSide(TextPathView textPathView, @Nullable String str) {
            textPathView.setSide(str);
        }

        @ReactProp(name = "midLine")
        public void setSharp(TextPathView textPathView, @Nullable String str) {
            textPathView.setSharp(str);
        }
    }

    static class ImageViewManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(@Nonnull ThemedReactContext themedReactContext, @Nonnull View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        @Nonnull
        public /* bridge */ /* synthetic */ View createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(@Nonnull View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        public /* bridge */ /* synthetic */ void onDropViewInstance(@Nonnull View view) {
            RenderableViewManager.super.onDropViewInstance((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        ImageViewManager() {
            super(SVGClass.RNSVGImage);
        }

        @ReactProp(name = "x")
        public void setX(ImageView imageView, Dynamic dynamic) {
            imageView.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(ImageView imageView, Dynamic dynamic) {
            imageView.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(ImageView imageView, Dynamic dynamic) {
            imageView.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(ImageView imageView, Dynamic dynamic) {
            imageView.setHeight(dynamic);
        }

        @ReactProp(name = "src")
        public void setSrc(ImageView imageView, @Nullable ReadableMap readableMap) {
            imageView.setSrc(readableMap);
        }

        @ReactProp(name = "align")
        public void setAlign(ImageView imageView, String str) {
            imageView.setAlign(str);
        }

        @ReactProp(name = "meetOrSlice")
        public void setMeetOrSlice(ImageView imageView, int i) {
            imageView.setMeetOrSlice(i);
        }
    }

    static class CircleViewManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(@Nonnull ThemedReactContext themedReactContext, @Nonnull View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        @Nonnull
        public /* bridge */ /* synthetic */ View createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(@Nonnull View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        public /* bridge */ /* synthetic */ void onDropViewInstance(@Nonnull View view) {
            RenderableViewManager.super.onDropViewInstance((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        CircleViewManager() {
            super(SVGClass.RNSVGCircle);
        }

        @ReactProp(name = "cx")
        public void setCx(CircleView circleView, Dynamic dynamic) {
            circleView.setCx(dynamic);
        }

        @ReactProp(name = "cy")
        public void setCy(CircleView circleView, Dynamic dynamic) {
            circleView.setCy(dynamic);
        }

        @ReactProp(name = "r")
        public void setR(CircleView circleView, Dynamic dynamic) {
            circleView.setR(dynamic);
        }
    }

    static class EllipseViewManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(@Nonnull ThemedReactContext themedReactContext, @Nonnull View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        @Nonnull
        public /* bridge */ /* synthetic */ View createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(@Nonnull View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        public /* bridge */ /* synthetic */ void onDropViewInstance(@Nonnull View view) {
            RenderableViewManager.super.onDropViewInstance((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        EllipseViewManager() {
            super(SVGClass.RNSVGEllipse);
        }

        @ReactProp(name = "cx")
        public void setCx(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.setCx(dynamic);
        }

        @ReactProp(name = "cy")
        public void setCy(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.setCy(dynamic);
        }

        @ReactProp(name = "rx")
        public void setRx(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.setRx(dynamic);
        }

        @ReactProp(name = "ry")
        public void setRy(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.setRy(dynamic);
        }
    }

    static class LineViewManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(@Nonnull ThemedReactContext themedReactContext, @Nonnull View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        @Nonnull
        public /* bridge */ /* synthetic */ View createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(@Nonnull View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        public /* bridge */ /* synthetic */ void onDropViewInstance(@Nonnull View view) {
            RenderableViewManager.super.onDropViewInstance((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        LineViewManager() {
            super(SVGClass.RNSVGLine);
        }

        @ReactProp(name = "x1")
        public void setX1(LineView lineView, Dynamic dynamic) {
            lineView.setX1(dynamic);
        }

        @ReactProp(name = "y1")
        public void setY1(LineView lineView, Dynamic dynamic) {
            lineView.setY1(dynamic);
        }

        @ReactProp(name = "x2")
        public void setX2(LineView lineView, Dynamic dynamic) {
            lineView.setX2(dynamic);
        }

        @ReactProp(name = "y2")
        public void setY2(LineView lineView, Dynamic dynamic) {
            lineView.setY2(dynamic);
        }
    }

    static class RectViewManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(@Nonnull ThemedReactContext themedReactContext, @Nonnull View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        @Nonnull
        public /* bridge */ /* synthetic */ View createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(@Nonnull View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        public /* bridge */ /* synthetic */ void onDropViewInstance(@Nonnull View view) {
            RenderableViewManager.super.onDropViewInstance((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        RectViewManager() {
            super(SVGClass.RNSVGRect);
        }

        @ReactProp(name = "x")
        public void setX(RectView rectView, Dynamic dynamic) {
            rectView.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(RectView rectView, Dynamic dynamic) {
            rectView.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(RectView rectView, Dynamic dynamic) {
            rectView.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(RectView rectView, Dynamic dynamic) {
            rectView.setHeight(dynamic);
        }

        @ReactProp(name = "rx")
        public void setRx(RectView rectView, Dynamic dynamic) {
            rectView.setRx(dynamic);
        }

        @ReactProp(name = "ry")
        public void setRy(RectView rectView, Dynamic dynamic) {
            rectView.setRy(dynamic);
        }
    }

    static class ClipPathViewManager extends GroupViewManager {
        ClipPathViewManager() {
            super(SVGClass.RNSVGClipPath);
        }
    }

    static class DefsViewManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(@Nonnull ThemedReactContext themedReactContext, @Nonnull View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        @Nonnull
        public /* bridge */ /* synthetic */ View createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(@Nonnull View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        public /* bridge */ /* synthetic */ void onDropViewInstance(@Nonnull View view) {
            RenderableViewManager.super.onDropViewInstance((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        DefsViewManager() {
            super(SVGClass.RNSVGDefs);
        }
    }

    static class UseViewManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(@Nonnull ThemedReactContext themedReactContext, @Nonnull View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        @Nonnull
        public /* bridge */ /* synthetic */ View createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(@Nonnull View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        public /* bridge */ /* synthetic */ void onDropViewInstance(@Nonnull View view) {
            RenderableViewManager.super.onDropViewInstance((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        UseViewManager() {
            super(SVGClass.RNSVGUse);
        }

        @ReactProp(name = "href")
        public void setHref(UseView useView, String str) {
            useView.setHref(str);
        }

        @ReactProp(name = "x")
        public void setX(UseView useView, Dynamic dynamic) {
            useView.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(UseView useView, Dynamic dynamic) {
            useView.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(UseView useView, Dynamic dynamic) {
            useView.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(UseView useView, Dynamic dynamic) {
            useView.setHeight(dynamic);
        }
    }

    static class SymbolManager extends GroupViewManager {
        SymbolManager() {
            super(SVGClass.RNSVGSymbol);
        }

        @ReactProp(name = "minX")
        public void setMinX(SymbolView symbolView, float f) {
            symbolView.setMinX(f);
        }

        @ReactProp(name = "minY")
        public void setMinY(SymbolView symbolView, float f) {
            symbolView.setMinY(f);
        }

        @ReactProp(name = "vbWidth")
        public void setVbWidth(SymbolView symbolView, float f) {
            symbolView.setVbWidth(f);
        }

        @ReactProp(name = "vbHeight")
        public void setVbHeight(SymbolView symbolView, float f) {
            symbolView.setVbHeight(f);
        }

        @ReactProp(name = "align")
        public void setAlign(SymbolView symbolView, String str) {
            symbolView.setAlign(str);
        }

        @ReactProp(name = "meetOrSlice")
        public void setMeetOrSlice(SymbolView symbolView, int i) {
            symbolView.setMeetOrSlice(i);
        }
    }

    static class PatternManager extends GroupViewManager {
        PatternManager() {
            super(SVGClass.RNSVGPattern);
        }

        @ReactProp(name = "x")
        public void setX(PatternView patternView, Dynamic dynamic) {
            patternView.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(PatternView patternView, Dynamic dynamic) {
            patternView.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(PatternView patternView, Dynamic dynamic) {
            patternView.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(PatternView patternView, Dynamic dynamic) {
            patternView.setHeight(dynamic);
        }

        @ReactProp(name = "patternUnits")
        public void setPatternUnits(PatternView patternView, int i) {
            patternView.setPatternUnits(i);
        }

        @ReactProp(name = "patternContentUnits")
        public void setPatternContentUnits(PatternView patternView, int i) {
            patternView.setPatternContentUnits(i);
        }

        @ReactProp(name = "patternTransform")
        public void setPatternTransform(PatternView patternView, @Nullable ReadableArray readableArray) {
            patternView.setPatternTransform(readableArray);
        }

        @ReactProp(name = "minX")
        public void setMinX(PatternView patternView, float f) {
            patternView.setMinX(f);
        }

        @ReactProp(name = "minY")
        public void setMinY(PatternView patternView, float f) {
            patternView.setMinY(f);
        }

        @ReactProp(name = "vbWidth")
        public void setVbWidth(PatternView patternView, float f) {
            patternView.setVbWidth(f);
        }

        @ReactProp(name = "vbHeight")
        public void setVbHeight(PatternView patternView, float f) {
            patternView.setVbHeight(f);
        }

        @ReactProp(name = "align")
        public void setAlign(PatternView patternView, String str) {
            patternView.setAlign(str);
        }

        @ReactProp(name = "meetOrSlice")
        public void setMeetOrSlice(PatternView patternView, int i) {
            patternView.setMeetOrSlice(i);
        }
    }

    static class MaskManager extends GroupViewManager {
        MaskManager() {
            super(SVGClass.RNSVGMask);
        }

        @ReactProp(name = "x")
        public void setX(MaskView maskView, Dynamic dynamic) {
            maskView.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(MaskView maskView, Dynamic dynamic) {
            maskView.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(MaskView maskView, Dynamic dynamic) {
            maskView.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(MaskView maskView, Dynamic dynamic) {
            maskView.setHeight(dynamic);
        }

        @ReactProp(name = "maskUnits")
        public void setMaskUnits(MaskView maskView, int i) {
            maskView.setMaskUnits(i);
        }

        @ReactProp(name = "maskContentUnits")
        public void setMaskContentUnits(MaskView maskView, int i) {
            maskView.setMaskContentUnits(i);
        }

        @ReactProp(name = "maskTransform")
        public void setMaskTransform(MaskView maskView, @Nullable ReadableArray readableArray) {
            maskView.setMaskTransform(readableArray);
        }
    }

    static class MarkerManager extends GroupViewManager {
        MarkerManager() {
            super(SVGClass.RNSVGMarker);
        }

        @ReactProp(name = "refX")
        public void setRefX(MarkerView markerView, Dynamic dynamic) {
            markerView.setRefX(dynamic);
        }

        @ReactProp(name = "refY")
        public void setRefY(MarkerView markerView, Dynamic dynamic) {
            markerView.setRefY(dynamic);
        }

        @ReactProp(name = "markerWidth")
        public void setMarkerWidth(MarkerView markerView, Dynamic dynamic) {
            markerView.setMarkerWidth(dynamic);
        }

        @ReactProp(name = "markerHeight")
        public void setMarkerHeight(MarkerView markerView, Dynamic dynamic) {
            markerView.setMarkerHeight(dynamic);
        }

        @ReactProp(name = "markerUnits")
        public void setMarkerUnits(MarkerView markerView, String str) {
            markerView.setMarkerUnits(str);
        }

        @ReactProp(name = "orient")
        public void setOrient(MarkerView markerView, String str) {
            markerView.setOrient(str);
        }

        @ReactProp(name = "minX")
        public void setMinX(MarkerView markerView, float f) {
            markerView.setMinX(f);
        }

        @ReactProp(name = "minY")
        public void setMinY(MarkerView markerView, float f) {
            markerView.setMinY(f);
        }

        @ReactProp(name = "vbWidth")
        public void setVbWidth(MarkerView markerView, float f) {
            markerView.setVbWidth(f);
        }

        @ReactProp(name = "vbHeight")
        public void setVbHeight(MarkerView markerView, float f) {
            markerView.setVbHeight(f);
        }

        @ReactProp(name = "align")
        public void setAlign(MarkerView markerView, String str) {
            markerView.setAlign(str);
        }

        @ReactProp(name = "meetOrSlice")
        public void setMeetOrSlice(MarkerView markerView, int i) {
            markerView.setMeetOrSlice(i);
        }
    }

    static class LinearGradientManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(@Nonnull ThemedReactContext themedReactContext, @Nonnull View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        @Nonnull
        public /* bridge */ /* synthetic */ View createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(@Nonnull View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        public /* bridge */ /* synthetic */ void onDropViewInstance(@Nonnull View view) {
            RenderableViewManager.super.onDropViewInstance((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        LinearGradientManager() {
            super(SVGClass.RNSVGLinearGradient);
        }

        @ReactProp(name = "x1")
        public void setX1(LinearGradientView linearGradientView, Dynamic dynamic) {
            linearGradientView.setX1(dynamic);
        }

        @ReactProp(name = "y1")
        public void setY1(LinearGradientView linearGradientView, Dynamic dynamic) {
            linearGradientView.setY1(dynamic);
        }

        @ReactProp(name = "x2")
        public void setX2(LinearGradientView linearGradientView, Dynamic dynamic) {
            linearGradientView.setX2(dynamic);
        }

        @ReactProp(name = "y2")
        public void setY2(LinearGradientView linearGradientView, Dynamic dynamic) {
            linearGradientView.setY2(dynamic);
        }

        @ReactProp(name = "gradient")
        public void setGradient(LinearGradientView linearGradientView, ReadableArray readableArray) {
            linearGradientView.setGradient(readableArray);
        }

        @ReactProp(name = "gradientUnits")
        public void setGradientUnits(LinearGradientView linearGradientView, int i) {
            linearGradientView.setGradientUnits(i);
        }

        @ReactProp(name = "gradientTransform")
        public void setGradientTransform(LinearGradientView linearGradientView, @Nullable ReadableArray readableArray) {
            linearGradientView.setGradientTransform(readableArray);
        }
    }

    static class RadialGradientManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(@Nonnull ThemedReactContext themedReactContext, @Nonnull View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        @Nonnull
        public /* bridge */ /* synthetic */ View createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(@Nonnull View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        public /* bridge */ /* synthetic */ void onDropViewInstance(@Nonnull View view) {
            RenderableViewManager.super.onDropViewInstance((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        RadialGradientManager() {
            super(SVGClass.RNSVGRadialGradient);
        }

        @ReactProp(name = "fx")
        public void setFx(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.setFx(dynamic);
        }

        @ReactProp(name = "fy")
        public void setFy(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.setFy(dynamic);
        }

        @ReactProp(name = "rx")
        public void setRx(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.setRx(dynamic);
        }

        @ReactProp(name = "ry")
        public void setRy(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.setRy(dynamic);
        }

        @ReactProp(name = "cx")
        public void setCx(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.setCx(dynamic);
        }

        @ReactProp(name = "cy")
        public void setCy(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.setCy(dynamic);
        }

        @ReactProp(name = "gradient")
        public void setGradient(RadialGradientView radialGradientView, ReadableArray readableArray) {
            radialGradientView.setGradient(readableArray);
        }

        @ReactProp(name = "gradientUnits")
        public void setGradientUnits(RadialGradientView radialGradientView, int i) {
            radialGradientView.setGradientUnits(i);
        }

        @ReactProp(name = "gradientTransform")
        public void setGradientTransform(RadialGradientView radialGradientView, @Nullable ReadableArray readableArray) {
            radialGradientView.setGradientTransform(readableArray);
        }
    }

    private RenderableViewManager(SVGClass sVGClass) {
        this.svgClass = sVGClass;
        this.mClassName = sVGClass.toString();
    }

    @Nonnull
    public String getName() {
        return this.mClassName;
    }

    @ReactProp(name = "mask")
    public void setMask(VirtualView virtualView, String str) {
        virtualView.setMask(str);
    }

    @ReactProp(name = "markerStart")
    public void setMarkerStart(VirtualView virtualView, String str) {
        virtualView.setMarkerStart(str);
    }

    @ReactProp(name = "markerMid")
    public void setMarkerMid(VirtualView virtualView, String str) {
        virtualView.setMarkerMid(str);
    }

    @ReactProp(name = "markerEnd")
    public void setMarkerEnd(VirtualView virtualView, String str) {
        virtualView.setMarkerEnd(str);
    }

    @ReactProp(name = "clipPath")
    public void setClipPath(VirtualView virtualView, String str) {
        virtualView.setClipPath(str);
    }

    @ReactProp(name = "clipRule")
    public void setClipRule(VirtualView virtualView, int i) {
        virtualView.setClipRule(i);
    }

    @ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(@Nonnull VirtualView virtualView, float f) {
        virtualView.setOpacity(f);
    }

    @ReactProp(name = "fill")
    public void setFill(RenderableView renderableView, @Nullable Dynamic dynamic) {
        renderableView.setFill(dynamic);
    }

    @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
    public void setFillOpacity(RenderableView renderableView, float f) {
        renderableView.setFillOpacity(f);
    }

    @ReactProp(defaultInt = 1, name = "fillRule")
    public void setFillRule(RenderableView renderableView, int i) {
        renderableView.setFillRule(i);
    }

    @ReactProp(name = "stroke")
    public void setStroke(RenderableView renderableView, @Nullable Dynamic dynamic) {
        renderableView.setStroke(dynamic);
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
    public void setStrokeOpacity(RenderableView renderableView, float f) {
        renderableView.setStrokeOpacity(f);
    }

    @ReactProp(name = "strokeDasharray")
    public void setStrokeDasharray(RenderableView renderableView, @Nullable ReadableArray readableArray) {
        renderableView.setStrokeDasharray(readableArray);
    }

    @ReactProp(name = "strokeDashoffset")
    public void setStrokeDashoffset(RenderableView renderableView, float f) {
        renderableView.setStrokeDashoffset(f);
    }

    @ReactProp(name = "strokeWidth")
    public void setStrokeWidth(RenderableView renderableView, Dynamic dynamic) {
        renderableView.setStrokeWidth(dynamic);
    }

    @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
    public void setStrokeMiterlimit(RenderableView renderableView, float f) {
        renderableView.setStrokeMiterlimit(f);
    }

    @ReactProp(defaultInt = 1, name = "strokeLinecap")
    public void setStrokeLinecap(RenderableView renderableView, int i) {
        renderableView.setStrokeLinecap(i);
    }

    @ReactProp(defaultInt = 1, name = "strokeLinejoin")
    public void setStrokeLinejoin(RenderableView renderableView, int i) {
        renderableView.setStrokeLinejoin(i);
    }

    @ReactProp(name = "vectorEffect")
    public void setVectorEffect(RenderableView renderableView, int i) {
        renderableView.setVectorEffect(i);
    }

    @ReactProp(name = "matrix")
    public void setMatrix(VirtualView virtualView, Dynamic dynamic) {
        virtualView.setMatrix(dynamic);
    }

    @ReactProp(name = "transform")
    public void setTransform(VirtualView virtualView, Dynamic dynamic) {
        if (dynamic.getType() == ReadableType.Array) {
            ReadableArray asArray = dynamic.asArray();
            if (asArray == null) {
                resetTransformProperty(virtualView);
            } else {
                setTransformProperty(virtualView, asArray);
            }
            Matrix matrix = virtualView.getMatrix();
            virtualView.mTransform = matrix;
            virtualView.mTransformInvertible = matrix.invert(virtualView.mInvTransform);
        }
    }

    @ReactProp(name = "propList")
    public void setPropList(RenderableView renderableView, @Nullable ReadableArray readableArray) {
        renderableView.setPropList(readableArray);
    }

    @ReactProp(name = "responsible")
    public void setResponsible(VirtualView virtualView, boolean z) {
        virtualView.setResponsible(z);
    }

    @ReactProp(name = "onLayout")
    public void setOnLayout(VirtualView virtualView, boolean z) {
        virtualView.setOnLayout(z);
    }

    @ReactProp(name = "name")
    public void setName(VirtualView virtualView, String str) {
        virtualView.setName(str);
    }

    /* access modifiers changed from: private */
    public void invalidateSvgView(VirtualView virtualView) {
        SvgView svgView = virtualView.getSvgView();
        if (svgView != null) {
            svgView.invalidate();
        }
        if (virtualView instanceof TextView) {
            ((TextView) virtualView).getTextContainer().clearChildCache();
        }
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(@Nonnull ThemedReactContext themedReactContext, @Nonnull VirtualView virtualView) {
        super.addEventEmitters(themedReactContext, virtualView);
        virtualView.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() {
            public void onChildViewAdded(View view, View view2) {
                if (view instanceof VirtualView) {
                    RenderableViewManager.this.invalidateSvgView((VirtualView) view);
                }
            }

            public void onChildViewRemoved(View view, View view2) {
                if (view instanceof VirtualView) {
                    RenderableViewManager.this.invalidateSvgView((VirtualView) view);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(@Nonnull VirtualView virtualView) {
        super.onAfterUpdateTransaction(virtualView);
        invalidateSvgView(virtualView);
    }

    /* renamed from: com.horcrux.svg.RenderableViewManager$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType = new int[ReadableType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(42:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|(2:39|40)|41|43|44|(3:45|46|48)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(43:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|43|44|(3:45|46|48)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(45:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|43|44|45|46|48) */
        /* JADX WARNING: Can't wrap try/catch for region: R(46:0|1|2|3|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|43|44|45|46|48) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0035 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00b6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00c2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00ce */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00da */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00f9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002a */
        static {
            /*
                com.horcrux.svg.RenderableViewManager$SVGClass[] r0 = com.horcrux.svg.RenderableViewManager.SVGClass.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$horcrux$svg$RenderableViewManager$SVGClass = r0
                r0 = 1
                int[] r1 = $SwitchMap$com$horcrux$svg$RenderableViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.horcrux.svg.RenderableViewManager$SVGClass r2 = com.horcrux.svg.RenderableViewManager.SVGClass.RNSVGGroup     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = $SwitchMap$com$horcrux$svg$RenderableViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x001f }
                com.horcrux.svg.RenderableViewManager$SVGClass r3 = com.horcrux.svg.RenderableViewManager.SVGClass.RNSVGPath     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r2 = $SwitchMap$com$horcrux$svg$RenderableViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x002a }
                com.horcrux.svg.RenderableViewManager$SVGClass r3 = com.horcrux.svg.RenderableViewManager.SVGClass.RNSVGCircle     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r2 = $SwitchMap$com$horcrux$svg$RenderableViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.horcrux.svg.RenderableViewManager$SVGClass r3 = com.horcrux.svg.RenderableViewManager.SVGClass.RNSVGEllipse     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4 = 4
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r2 = $SwitchMap$com$horcrux$svg$RenderableViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.horcrux.svg.RenderableViewManager$SVGClass r3 = com.horcrux.svg.RenderableViewManager.SVGClass.RNSVGLine     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r4 = 5
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r2 = $SwitchMap$com$horcrux$svg$RenderableViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x004b }
                com.horcrux.svg.RenderableViewManager$SVGClass r3 = com.horcrux.svg.RenderableViewManager.SVGClass.RNSVGRect     // Catch:{ NoSuchFieldError -> 0x004b }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r4 = 6
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r2 = $SwitchMap$com$horcrux$svg$RenderableViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x0056 }
                com.horcrux.svg.RenderableViewManager$SVGClass r3 = com.horcrux.svg.RenderableViewManager.SVGClass.RNSVGText     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r4 = 7
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                int[] r2 = $SwitchMap$com$horcrux$svg$RenderableViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.horcrux.svg.RenderableViewManager$SVGClass r3 = com.horcrux.svg.RenderableViewManager.SVGClass.RNSVGTSpan     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r4 = 8
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r2 = $SwitchMap$com$horcrux$svg$RenderableViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x006e }
                com.horcrux.svg.RenderableViewManager$SVGClass r3 = com.horcrux.svg.RenderableViewManager.SVGClass.RNSVGTextPath     // Catch:{ NoSuchFieldError -> 0x006e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r4 = 9
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r2 = $SwitchMap$com$horcrux$svg$RenderableViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x007a }
                com.horcrux.svg.RenderableViewManager$SVGClass r3 = com.horcrux.svg.RenderableViewManager.SVGClass.RNSVGImage     // Catch:{ NoSuchFieldError -> 0x007a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x007a }
                r4 = 10
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x007a }
            L_0x007a:
                int[] r2 = $SwitchMap$com$horcrux$svg$RenderableViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x0086 }
                com.horcrux.svg.RenderableViewManager$SVGClass r3 = com.horcrux.svg.RenderableViewManager.SVGClass.RNSVGClipPath     // Catch:{ NoSuchFieldError -> 0x0086 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0086 }
                r4 = 11
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0086 }
            L_0x0086:
                int[] r2 = $SwitchMap$com$horcrux$svg$RenderableViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x0092 }
                com.horcrux.svg.RenderableViewManager$SVGClass r3 = com.horcrux.svg.RenderableViewManager.SVGClass.RNSVGDefs     // Catch:{ NoSuchFieldError -> 0x0092 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0092 }
                r4 = 12
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0092 }
            L_0x0092:
                int[] r2 = $SwitchMap$com$horcrux$svg$RenderableViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x009e }
                com.horcrux.svg.RenderableViewManager$SVGClass r3 = com.horcrux.svg.RenderableViewManager.SVGClass.RNSVGUse     // Catch:{ NoSuchFieldError -> 0x009e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x009e }
                r4 = 13
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x009e }
            L_0x009e:
                int[] r2 = $SwitchMap$com$horcrux$svg$RenderableViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x00aa }
                com.horcrux.svg.RenderableViewManager$SVGClass r3 = com.horcrux.svg.RenderableViewManager.SVGClass.RNSVGSymbol     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r4 = 14
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                int[] r2 = $SwitchMap$com$horcrux$svg$RenderableViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x00b6 }
                com.horcrux.svg.RenderableViewManager$SVGClass r3 = com.horcrux.svg.RenderableViewManager.SVGClass.RNSVGLinearGradient     // Catch:{ NoSuchFieldError -> 0x00b6 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b6 }
                r4 = 15
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00b6 }
            L_0x00b6:
                int[] r2 = $SwitchMap$com$horcrux$svg$RenderableViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x00c2 }
                com.horcrux.svg.RenderableViewManager$SVGClass r3 = com.horcrux.svg.RenderableViewManager.SVGClass.RNSVGRadialGradient     // Catch:{ NoSuchFieldError -> 0x00c2 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c2 }
                r4 = 16
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00c2 }
            L_0x00c2:
                int[] r2 = $SwitchMap$com$horcrux$svg$RenderableViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x00ce }
                com.horcrux.svg.RenderableViewManager$SVGClass r3 = com.horcrux.svg.RenderableViewManager.SVGClass.RNSVGPattern     // Catch:{ NoSuchFieldError -> 0x00ce }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ce }
                r4 = 17
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00ce }
            L_0x00ce:
                int[] r2 = $SwitchMap$com$horcrux$svg$RenderableViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x00da }
                com.horcrux.svg.RenderableViewManager$SVGClass r3 = com.horcrux.svg.RenderableViewManager.SVGClass.RNSVGMask     // Catch:{ NoSuchFieldError -> 0x00da }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00da }
                r4 = 18
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00da }
            L_0x00da:
                int[] r2 = $SwitchMap$com$horcrux$svg$RenderableViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x00e6 }
                com.horcrux.svg.RenderableViewManager$SVGClass r3 = com.horcrux.svg.RenderableViewManager.SVGClass.RNSVGMarker     // Catch:{ NoSuchFieldError -> 0x00e6 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e6 }
                r4 = 19
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00e6 }
            L_0x00e6:
                com.facebook.react.bridge.ReadableType[] r2 = com.facebook.react.bridge.ReadableType.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$com$facebook$react$bridge$ReadableType = r2
                int[] r2 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x00f9 }
                com.facebook.react.bridge.ReadableType r3 = com.facebook.react.bridge.ReadableType.Number     // Catch:{ NoSuchFieldError -> 0x00f9 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f9 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x00f9 }
            L_0x00f9:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0103 }
                com.facebook.react.bridge.ReadableType r2 = com.facebook.react.bridge.ReadableType.String     // Catch:{ NoSuchFieldError -> 0x0103 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0103 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0103 }
            L_0x0103:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.RenderableViewManager.AnonymousClass2.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    @Nonnull
    public VirtualView createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
        switch (this.svgClass) {
            case RNSVGGroup:
                return new GroupView(themedReactContext);
            case RNSVGPath:
                return new PathView(themedReactContext);
            case RNSVGCircle:
                return new CircleView(themedReactContext);
            case RNSVGEllipse:
                return new EllipseView(themedReactContext);
            case RNSVGLine:
                return new LineView(themedReactContext);
            case RNSVGRect:
                return new RectView(themedReactContext);
            case RNSVGText:
                return new TextView(themedReactContext);
            case RNSVGTSpan:
                return new TSpanView(themedReactContext);
            case RNSVGTextPath:
                return new TextPathView(themedReactContext);
            case RNSVGImage:
                return new ImageView(themedReactContext);
            case RNSVGClipPath:
                return new ClipPathView(themedReactContext);
            case RNSVGDefs:
                return new DefsView(themedReactContext);
            case RNSVGUse:
                return new UseView(themedReactContext);
            case RNSVGSymbol:
                return new SymbolView(themedReactContext);
            case RNSVGLinearGradient:
                return new LinearGradientView(themedReactContext);
            case RNSVGRadialGradient:
                return new RadialGradientView(themedReactContext);
            case RNSVGPattern:
                return new PatternView(themedReactContext);
            case RNSVGMask:
                return new MaskView(themedReactContext);
            case RNSVGMarker:
                return new MarkerView(themedReactContext);
            default:
                throw new IllegalStateException("Unexpected type " + this.svgClass.toString());
        }
    }

    static void setRenderableView(int i, RenderableView renderableView) {
        mTagToRenderableView.put(i, renderableView);
        Runnable runnable = mTagToRunnable.get(i);
        if (runnable != null) {
            runnable.run();
            mTagToRunnable.delete(i);
        }
    }

    static void runWhenViewIsAvailable(int i, Runnable runnable) {
        mTagToRunnable.put(i, runnable);
    }

    @Nullable
    static RenderableView getRenderableViewByTag(int i) {
        return mTagToRenderableView.get(i);
    }

    public void onDropViewInstance(@Nonnull VirtualView virtualView) {
        super.onDropViewInstance(virtualView);
        mTagToRenderableView.remove(virtualView.getId());
    }
}

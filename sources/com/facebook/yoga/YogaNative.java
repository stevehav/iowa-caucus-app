package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
public class YogaNative {
    static native void jni_YGConfigFree(long j);

    static native long jni_YGConfigNew();

    static native void jni_YGConfigSetExperimentalFeatureEnabled(long j, int i, boolean z);

    static native void jni_YGConfigSetLogger(long j, Object obj);

    static native void jni_YGConfigSetPointScaleFactor(long j, float f);

    static native void jni_YGConfigSetPrintTreeFlag(long j, boolean z);

    static native void jni_YGConfigSetShouldDiffLayoutWithoutLegacyStretchBehaviour(long j, boolean z);

    static native void jni_YGConfigSetUseLegacyStretchBehaviour(long j, boolean z);

    static native void jni_YGConfigSetUseWebDefaults(long j, boolean z);

    static native void jni_YGNodeCalculateLayout(long j, float f, float f2, long[] jArr, YogaNodeJNIBase[] yogaNodeJNIBaseArr);

    static native void jni_YGNodeClearChildren(long j);

    static native long jni_YGNodeClone(long j);

    static native void jni_YGNodeCopyStyle(long j, long j2);

    static native void jni_YGNodeFree(long j);

    static native void jni_YGNodeInsertChild(long j, long j2, int i);

    static native boolean jni_YGNodeIsDirty(long j);

    static native boolean jni_YGNodeIsReferenceBaseline(long j);

    static native void jni_YGNodeMarkDirty(long j);

    static native void jni_YGNodeMarkDirtyAndPropogateToDescendants(long j);

    static native long jni_YGNodeNew();

    static native long jni_YGNodeNewWithConfig(long j);

    static native void jni_YGNodePrint(long j);

    static native void jni_YGNodeRemoveChild(long j, long j2);

    static native void jni_YGNodeReset(long j);

    static native void jni_YGNodeSetHasBaselineFunc(long j, boolean z);

    static native void jni_YGNodeSetHasMeasureFunc(long j, boolean z);

    static native void jni_YGNodeSetIsReferenceBaseline(long j, boolean z);

    static native void jni_YGNodeSetStyleInputs(long j, float[] fArr, int i);

    static native int jni_YGNodeStyleGetAlignContent(long j);

    static native int jni_YGNodeStyleGetAlignItems(long j);

    static native int jni_YGNodeStyleGetAlignSelf(long j);

    static native float jni_YGNodeStyleGetAspectRatio(long j);

    static native float jni_YGNodeStyleGetBorder(long j, int i);

    static native int jni_YGNodeStyleGetDirection(long j);

    static native int jni_YGNodeStyleGetDisplay(long j);

    static native float jni_YGNodeStyleGetFlex(long j);

    static native long jni_YGNodeStyleGetFlexBasis(long j);

    static native int jni_YGNodeStyleGetFlexDirection(long j);

    static native float jni_YGNodeStyleGetFlexGrow(long j);

    static native float jni_YGNodeStyleGetFlexShrink(long j);

    static native int jni_YGNodeStyleGetFlexWrap(long j);

    static native long jni_YGNodeStyleGetHeight(long j);

    static native int jni_YGNodeStyleGetJustifyContent(long j);

    static native long jni_YGNodeStyleGetMargin(long j, int i);

    static native long jni_YGNodeStyleGetMaxHeight(long j);

    static native long jni_YGNodeStyleGetMaxWidth(long j);

    static native long jni_YGNodeStyleGetMinHeight(long j);

    static native long jni_YGNodeStyleGetMinWidth(long j);

    static native int jni_YGNodeStyleGetOverflow(long j);

    static native long jni_YGNodeStyleGetPadding(long j, int i);

    static native long jni_YGNodeStyleGetPosition(long j, int i);

    static native int jni_YGNodeStyleGetPositionType(long j);

    static native long jni_YGNodeStyleGetWidth(long j);

    static native void jni_YGNodeStyleSetAlignContent(long j, int i);

    static native void jni_YGNodeStyleSetAlignItems(long j, int i);

    static native void jni_YGNodeStyleSetAlignSelf(long j, int i);

    static native void jni_YGNodeStyleSetAspectRatio(long j, float f);

    static native void jni_YGNodeStyleSetBorder(long j, int i, float f);

    static native void jni_YGNodeStyleSetDirection(long j, int i);

    static native void jni_YGNodeStyleSetDisplay(long j, int i);

    static native void jni_YGNodeStyleSetFlex(long j, float f);

    static native void jni_YGNodeStyleSetFlexBasis(long j, float f);

    static native void jni_YGNodeStyleSetFlexBasisAuto(long j);

    static native void jni_YGNodeStyleSetFlexBasisPercent(long j, float f);

    static native void jni_YGNodeStyleSetFlexDirection(long j, int i);

    static native void jni_YGNodeStyleSetFlexGrow(long j, float f);

    static native void jni_YGNodeStyleSetFlexShrink(long j, float f);

    static native void jni_YGNodeStyleSetFlexWrap(long j, int i);

    static native void jni_YGNodeStyleSetHeight(long j, float f);

    static native void jni_YGNodeStyleSetHeightAuto(long j);

    static native void jni_YGNodeStyleSetHeightPercent(long j, float f);

    static native void jni_YGNodeStyleSetJustifyContent(long j, int i);

    static native void jni_YGNodeStyleSetMargin(long j, int i, float f);

    static native void jni_YGNodeStyleSetMarginAuto(long j, int i);

    static native void jni_YGNodeStyleSetMarginPercent(long j, int i, float f);

    static native void jni_YGNodeStyleSetMaxHeight(long j, float f);

    static native void jni_YGNodeStyleSetMaxHeightPercent(long j, float f);

    static native void jni_YGNodeStyleSetMaxWidth(long j, float f);

    static native void jni_YGNodeStyleSetMaxWidthPercent(long j, float f);

    static native void jni_YGNodeStyleSetMinHeight(long j, float f);

    static native void jni_YGNodeStyleSetMinHeightPercent(long j, float f);

    static native void jni_YGNodeStyleSetMinWidth(long j, float f);

    static native void jni_YGNodeStyleSetMinWidthPercent(long j, float f);

    static native void jni_YGNodeStyleSetOverflow(long j, int i);

    static native void jni_YGNodeStyleSetPadding(long j, int i, float f);

    static native void jni_YGNodeStyleSetPaddingPercent(long j, int i, float f);

    static native void jni_YGNodeStyleSetPosition(long j, int i, float f);

    static native void jni_YGNodeStyleSetPositionPercent(long j, int i, float f);

    static native void jni_YGNodeStyleSetPositionType(long j, int i);

    static native void jni_YGNodeStyleSetWidth(long j, float f);

    static native void jni_YGNodeStyleSetWidthAuto(long j);

    static native void jni_YGNodeStyleSetWidthPercent(long j, float f);

    static {
        SoLoader.loadLibrary("yoga");
    }
}

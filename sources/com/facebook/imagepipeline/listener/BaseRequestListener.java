package com.facebook.imagepipeline.listener;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;

public class BaseRequestListener implements RequestListener {
    public void onProducerEvent(String str, String str2, String str3) {
    }

    public void onProducerFinishWithCancellation(String str, String str2, @Nullable Map<String, String> map) {
    }

    public void onProducerFinishWithFailure(String str, String str2, Throwable th, @Nullable Map<String, String> map) {
    }

    public void onProducerFinishWithSuccess(String str, String str2, @Nullable Map<String, String> map) {
    }

    public void onProducerStart(String str, String str2) {
    }

    public void onRequestCancellation(String str) {
    }

    public void onRequestFailure(ImageRequest imageRequest, String str, Throwable th, boolean z) {
    }

    public void onRequestStart(ImageRequest imageRequest, Object obj, String str, boolean z) {
    }

    public void onRequestSuccess(ImageRequest imageRequest, String str, boolean z) {
    }

    public void onUltimateProducerReached(String str, String str2, boolean z) {
    }

    public boolean requiresExtraMap(String str) {
        return false;
    }
}

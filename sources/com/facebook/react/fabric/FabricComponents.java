package com.facebook.react.fabric;

import com.facebook.react.views.image.ReactImageManager;
import com.facebook.react.views.modal.ReactModalHostManager;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.facebook.react.views.scroll.ReactScrollViewManager;
import com.facebook.react.views.slider.ReactSliderManager;
import com.facebook.react.views.text.ReactRawTextManager;
import com.facebook.react.views.text.ReactTextViewManager;
import java.util.HashMap;
import java.util.Map;

public class FabricComponents {
    private static final Map<String, String> sComponentNames = new HashMap();

    static {
        sComponentNames.put("View", "RCTView");
        sComponentNames.put("Image", ReactImageManager.REACT_CLASS);
        sComponentNames.put("ScrollView", ReactScrollViewManager.REACT_CLASS);
        sComponentNames.put("Slider", ReactSliderManager.REACT_CLASS);
        sComponentNames.put("ModalHostView", ReactModalHostManager.REACT_CLASS);
        sComponentNames.put("Paragraph", ReactTextViewManager.REACT_CLASS);
        sComponentNames.put("Text", "RCText");
        sComponentNames.put("RawText", ReactRawTextManager.REACT_CLASS);
        sComponentNames.put("ActivityIndicatorView", ReactProgressBarViewManager.REACT_CLASS);
        sComponentNames.put("ShimmeringView", "RKShimmeringView");
        sComponentNames.put("TemplateView", "RCTTemplateView");
        sComponentNames.put("AxialGradientView", "RCTAxialGradientView");
    }

    static String getFabricComponentName(String str) {
        String str2 = sComponentNames.get(str);
        return str2 != null ? str2 : str;
    }
}

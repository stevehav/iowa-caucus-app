package com.facebook.react.shell;

import com.facebook.imagepipeline.core.ImagePipelineConfig;

public class MainPackageConfig {
    private ImagePipelineConfig mFrescoConfig;

    private MainPackageConfig(Builder builder) {
        this.mFrescoConfig = builder.mFrescoConfig;
    }

    public ImagePipelineConfig getFrescoConfig() {
        return this.mFrescoConfig;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public ImagePipelineConfig mFrescoConfig;

        public Builder setFrescoConfig(ImagePipelineConfig imagePipelineConfig) {
            this.mFrescoConfig = imagePipelineConfig;
            return this;
        }

        public MainPackageConfig build() {
            return new MainPackageConfig(this);
        }
    }
}

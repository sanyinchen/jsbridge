package com.sanyinchen.jsbridge.business.jsmodule;

import com.facebook.jni.annotations.DoNotStrip;
import com.sanyinchen.jsbridge.module.js.JavaScriptModule;
import com.sanyinchen.jsbridge.module.jsi.JSIModule;

@DoNotStrip
public class HelloJavaScriptModule implements JSIModule {

    @Override
    public void initialize() {

    }

    @Override
    public void onCatalystInstanceDestroy() {

    }
}

package com.sanyinchen.jsbridge.module;


import androidx.annotation.NonNull;

import com.sanyinchen.jsbridge.JsBridgeContext;
import com.sanyinchen.jsbridge.module.bridge.NativeModelPackage;
import com.sanyinchen.jsbridge.module.bridge.NativeModule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BusinessPackages implements NativeModelPackage {

    private LogModule.LogUpdate runnable;

    public BusinessPackages(LogModule.LogUpdate runnable) {
        this.runnable = runnable;
    }


    @NonNull
    @Override
    public List<NativeModule> createNativeModules(@NonNull JsBridgeContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        modules.add(new LogModule(runnable));
        return Collections.emptyList();
    }
}

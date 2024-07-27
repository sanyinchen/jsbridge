package com.sanyinchen.jsbridge.business.nativemodule;


import androidx.annotation.NonNull;

import com.sanyinchen.jsbridge.JsBridgeContext;
import com.sanyinchen.jsbridge.module.bridge.NativeModelPackage;
import com.sanyinchen.jsbridge.module.bridge.NativeModule;
import com.sanyinchen.jsbridge.module.impl.cxx.CxxModuleWrapper;

import java.util.ArrayList;
import java.util.List;

public class NativeBusinessPackages implements NativeModelPackage {

    private LogModule.LogUpdate runnable;

    public NativeBusinessPackages(LogModule.LogUpdate runnable) {
        this.runnable = runnable;
    }


    @NonNull
    @Override
    public List<NativeModule> createNativeModules(@NonNull JsBridgeContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        modules.add(new LogModule(runnable));
        modules.add(CxxModuleWrapper.makeDso("cxxmodule", "createHelloCxxModule"));
        return modules;
    }
}

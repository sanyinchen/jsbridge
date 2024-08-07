/**
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.sanyinchen.jsbridge.executor.base;

import com.facebook.jni.HybridData;
import com.facebook.jni.annotations.DoNotStrip;

@DoNotStrip
public abstract class JavaScriptExecutor {
    private final HybridData mHybridData;

    protected JavaScriptExecutor(HybridData hybridData) {
        mHybridData = hybridData;
    }

    /**
     * Close this executor and cleanup any resources that it was using. No further calls are
     * expected after this.
     * TODO mhorowitz: This may no longer be used; check and delete if possible.
     */
    public void close() {
        mHybridData.resetNative();
    }

    /**
     * Returns the name of the executor, identifying the underlying runtime.
     */
    abstract public String getName();
}

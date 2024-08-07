/**
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.sanyinchen.jsbridge.module.js;


import com.facebook.jni.annotations.DoNotStrip;

/**
 * Interface denoting that a class is the interface to a module with the same name in JS. Calling
 * functions on this interface will result in corresponding methods in JS being called.
 *
 * When extending JavaScriptModule and registering it with a CatalystInstance, all public methods
 * are assumed to be implemented on a JS module with the same name as this class. Calling methods
 * on the object returned from {@link ReactContext#getJSModule} or
 * {@link CatalystInstance#getJSModule} will result in the methods with those names exported by
 * that module being called in JS.
 *
 * NB: JavaScriptModule does not allow method name overloading because JS does not allow method name
 * overloading.
 */
@DoNotStrip
public interface JavaScriptModule {
}

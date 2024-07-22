/**
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.sanyinchen.jsbridge.modules.jsi;

import java.util.List;

/**
 * Interface used to initialize JSI Modules into the JSI Bridge.
 */
public interface JSIModule {

  /**
   * @return a {@link List < JSIModuleSpec >} that contain the list of JSI Modules.
   */
  List<JSIModuleSpec> getJSIModules(ReactApplicationContext reactApplicationContext, JavaScriptContextHolder jsContext);

}

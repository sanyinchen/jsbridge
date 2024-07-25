// Copyright (c) Facebook, Inc. and its affiliates.

// This source code is licensed under the MIT license found in the
// LICENSE file in the root directory of this source tree.

#pragma once

#include <fbjni/fbjni.h>
#include <folly/dynamic.h>
#include <folly/json.h>

#include "ReadableNativeArray.h"

namespace facebook {
namespace react {

struct WritableNativeMap;

struct WritableArray : jni::JavaClass<WritableArray> {
  static auto constexpr kJavaDescriptor = "Lcom/sanyinchen/jsbridge/data/WritableArray;";
};

struct WritableNativeArray
    : public jni::HybridClass<WritableNativeArray, ReadableNativeArray> {
  static constexpr const char* kJavaDescriptor = "Lcom/sanyinchen/jsbridge/data/WritableNativeArray;";

  WritableNativeArray();
  static jni::local_ref<jhybriddata> initHybrid(jni::alias_ref<jclass>);

  void pushNull();
  void pushBoolean(jboolean value);
  void pushDouble(jdouble value);
  void pushInt(jint value);
  void pushString(jstring value);
  void pushNativeArray(WritableNativeArray* otherArray);
  void pushNativeMap(WritableNativeMap* map);

  static void registerNatives();
};

}
}

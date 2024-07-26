// Copyright (c) Facebook, Inc. and its affiliates.

// This source code is licensed under the MIT license found in the
// LICENSE file in the root directory of this source tree.

#include <string>

#include <glog/logging.h>
#include "include/OnLoad.h"
#include <fbjni/fbjni.h>
#include <fb/glog_init.h>
#include <fbjni/detail/Log.h>
#include "include/JsBridgeInstanceImpl.h"
#include <fbjni/NativeRunnable.h>

using namespace facebook::jni;

namespace facebook {
    namespace react {

        namespace {

            struct JavaJSExecutor : public JavaClass<JavaJSExecutor> {
                static constexpr auto kJavaDescriptor = "Lcom/sanyinchen/jsbridge/executor/java/JavaJSExecutor;";
            };

            class ProxyJavaScriptExecutorHolder : public HybridClass<ProxyJavaScriptExecutorHolder,
                    JavaScriptExecutorHolder> {
            public:
                static constexpr auto kJavaDescriptor = "Lcom/sanyinchen/jsbridge/executor/ProxyJavaScriptExecutor;";

                static local_ref<jhybriddata> initHybrid(
                        alias_ref<jclass>, alias_ref<JavaJSExecutor::javaobject> executorInstance) {
                    return makeCxxInstance(
                            std::make_shared<ProxyExecutorOneTimeFactory>(
                                    make_global(executorInstance)));
                }

                static void registerNatives() {
                    registerHybrid({
                                           makeNativeMethod("initHybrid", ProxyJavaScriptExecutorHolder::initHybrid),
                                   });
                }

            private:
                friend HybridBase;
                using HybridBase::HybridBase;
            };

        }

        extern "C" JNIEXPORT jint JNI_OnLoad(JavaVM *vm, void *reserved) {
            return initialize(vm, [] {
                gloginit::initialize();
                FLAGS_minloglevel = 0;

                HybridDataOnLoad();
                JNativeRunnable::OnLoad();
                ThreadScope::OnLoad();

                NativeArray::registerNatives();
                ReadableNativeArray::registerNatives();
                WritableNativeArray::registerNatives();
                NativeMap::registerNatives();
                ReadableNativeMap::registerNatives();
                WritableNativeMap::registerNatives();
                ReadableNativeMapKeySetIterator::registerNatives();

                ProxyJavaScriptExecutorHolder::registerNatives();
                CxxModuleWrapperBase::registerNatives();
                CxxModuleWrapper::registerNatives();
                JCxxCallbackImpl::registerNatives();

                JsBridgeInstanceImpl::registerNatives();
            });
        }

    }
}

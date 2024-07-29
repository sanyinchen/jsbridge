### 基于RNV0.6x版本的JS-Bridge通讯框架
#### 目录： 
+ js-bridge：JS Bridge
+ js-bridge-lib: Native Bridge
#### Test：
```
// test
// async invoke NativeModule:TestSum
NativeModules.TestSum.sum(1, 2)
    .then(result => {
        NAConsole.log("TestSum.sum(1, 2) test:" + result);
    })
    .catch(error => {
        NAConsole.log("Error" + error);
    });

// Js HelloJavaScriptModule define
global.HelloJavaScriptModule = {
    showMessage: (message) => {
        NativeModules.NativeLog.log('HelloJavaScriptModule:showMessage:' + message);
    }
};
Bridge.registerCallableModule('HelloJavaScriptModule', global.HelloJavaScriptModule)

// NALog NativeModule test
NAConsole.log("Js bridge inited");
// NativeModule c++ module invoke test
NativeModules.HelloCxxModule.foo((r) => {
    NAConsole.log("js HelloCxxModule invoke test:" + r);
});

```
+ 点击init初始化jsBridge以及加载js-bridge-bundle.js
+ 点击invoke js测试native调用js module

<img src="https://github.com/sanyinchen/jsbridge/blob/master/source/demo.png" alt="demo"  height="700">



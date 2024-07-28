/**
 * Created by sanyinchen on 19-11-24.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-11-24
 */

const Bridge = require('./bridge/Bridge');
const NativeModules = require('./bridge/NativeModules')
global.HelloJavaScriptModule = {
    showMessage: (message) => {
        NativeModules.NativeLog.log('from HelloJavaScriptModule:' + message);
    }
};
Bridge.registerCallableModule('HelloJavaScriptModule', global.HelloJavaScriptModule)

global.NativeLog = NativeModules.NativeLog;
NativeLog.log("hello world ! from js test");

NativeModules.HelloCxxModule.foo((r) => {
    NativeModules.NativeLog.log(r);
});

/**
 * Created by sanyinchen on 19-11-24.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-11-24
 */

const Bridge = require('./bridge/Bridge');
const NativeModules = require('./bridge/NativeModules')
NativeModules.TestSum.sum(1, 2)
    .then(result => {
        console.log('Sum:', result);
        NAConsole.log("Sum" + result);
    })
    .catch(error => {
        console.error('Error:', error);
        NAConsole.log("Error" + error);
    });

global.HelloJavaScriptModule = {
    showMessage: (message) => {
        NativeModules.NativeLog.log('from HelloJavaScriptModule:' + message);
    }
};
Bridge.registerCallableModule('HelloJavaScriptModule', global.HelloJavaScriptModule)

NAConsole.log("js bridge inited");
NativeModules.HelloCxxModule.foo((r) => {
    NAConsole.log("get HelloCxxModule invoke:" + r);
});
NativeModules.TestSum.sum(2, 4)
    .then(result => {
        console.log('Sum:', result);
        NAConsole.log("Sum" + result);
    })
    .catch(error => {
        console.error('Error:', error);
        NAConsole.log("Error" + error);
    });

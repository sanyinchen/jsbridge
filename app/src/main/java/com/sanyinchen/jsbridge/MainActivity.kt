package com.sanyinchen.jsbridge

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.facebook.soloader.SoLoader
import com.sanyinchen.jsbridge.business.BusinessPackages
import com.sanyinchen.jsbridge.business.jsmodule.HelloJavaScriptModule
import com.sanyinchen.jsbridge.ui.theme.MainLayoutTheme


class MainActivity : ComponentActivity() {
    val mainHandle = Handler(Looper.getMainLooper())
    val textViewMsg = mutableStateOf("Hello, World!")
    var jsBridgeInstanceManager: JsBridgeManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SoLoader.init(this, false)

        setContent {
            mainContent()
        }
    }

    private fun init() {

        jsBridgeInstanceManager = JsBridgeManagerBuilder()
            .setApplication(application)
            .setBundleAssetName("js-bridge-bundle.js")
            .setNativeModuleCallExceptionHandler { e -> e.printStackTrace() }
            .addPackage(BusinessPackages() {
                mainHandle.post {
                    textViewMsg.value += "\n $it"
                }
            })
            .build()
        jsBridgeInstanceManager?.run()

    }

    @Composable
    private fun mainContent() {
        val scrollState = rememberScrollState()
        MainLayoutTheme {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(2.dp)
            ) {
                Text(
                    text = textViewMsg.value
                )
                Button(
                    onClick = { init() }
                ) {
                    Text("js 测试")
                }
                Button(
                    onClick = {
                        val helloJavaScriptModule =
                            jsBridgeInstanceManager?.currentReactContext?.getJSModule(
                                HelloJavaScriptModule::class.java
                            )
                        helloJavaScriptModule?.showMessage("test")
                    }
                ) {
                    Text("invoke js ")
                }
                Button(
                    onClick = {
                        textViewMsg.value = ""
                    }
                ) {
                    Text("clean")
                }
            }
        }
    }
}



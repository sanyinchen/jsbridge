package com.sanyinchen.jsbridge

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.facebook.soloader.SoLoader
import com.sanyinchen.jsbridge.module.BusinessPackages
import com.sanyinchen.jsbridge.ui.theme.MainLayoutTheme
import com.sanyinchen.jsbridge.utils.UiThreadUtil

class MainActivity : ComponentActivity() {
    val mainHandle = Handler(Looper.getMainLooper())
    val textViewMsg = mutableStateOf("Hello, World!")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SoLoader.init(this, false)

        setContent {
            mainContent()
        }
    }

    private fun init() {
        val jsBridgeInstanceManager = JsBridgeManagerBuilder()
            .setApplication(application)
            .setBundleAssetName("js-bridge-bundle.js")
            .setNativeModuleCallExceptionHandler { e -> e.printStackTrace() }
            .addPackage(BusinessPackages() {
                mainHandle.post {
                    textViewMsg.value = "data from $it"
                }
            })
            .build()
        jsBridgeInstanceManager.run()
    }

    @Composable
    private fun mainContent() {
        MainLayoutTheme {
            Column(
                modifier = Modifier.padding(2.dp)
            ) {
                Text(
                    text = textViewMsg.value
                )
                Button(
                    onClick = { init() }
                ) {
                    Text("测试")
                }
            }
        }
    }
}



package com.sanyinchen.jsbridge

import android.os.Bundle
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
import com.sanyinchen.jsbridge.ui.theme.MainLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        setContent {
            mainContent()
        }
    }

    private fun init() {
        val jsBridgeInstanceManager = JsBridgeManagerBuilder()
            .setApplication(application)
            .setBundleAssetName("js-bridge-bundle.js")
            .setNativeModuleCallExceptionHandler { e -> e.printStackTrace() }
            .build()
        jsBridgeInstanceManager.run()
    }

    @Composable
    private fun mainContent() {
        val textViewMsg = remember { mutableStateOf("Hello, World!") }
        MainLayoutTheme {
            Column(
                modifier = Modifier.padding(2.dp)
            ) {
                Text(
                    text = textViewMsg.value
                )
                Button(
                    onClick = { textViewMsg.value = "ss" }
                ) {
                    Text("测试")
                }
            }
        }
    }
}



package com.kelvsricafort101.wordpress.tiptime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kelvsricafort101.wordpress.tiptime.ui.TipTimeApp
import com.kelvsricafort101.wordpress.tiptime.ui.theme.TipTimeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TipTimeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TipTimeApp()
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun TipTimeAppPreview() {
    TipTimeTheme(darkTheme = false) {
        Surface {
            TipTimeApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TipTimeAppDarkPreview() {
    TipTimeTheme(darkTheme = true) {
        Surface {
            TipTimeApp()
        }
    }
}
package com.gpetuhov.android.compose.basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gpetuhov.android.compose.basics.ui.theme.JetpackComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeBasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainActivityUI()
                }
            }
        }
    }
}

@Composable
fun MainActivityUI() {
    Button(
        onClick = { onButtonClick() },
        modifier = Modifier
            .width(200.dp)
            .height(48.dp)
        // This can also be done as
//        modifier = Modifier
//            .size(width = 200.dp, height = 48.dp)

    ) {
        Text(text = "Press me")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeBasicsTheme {
        MainActivityUI()
    }
}

private fun onButtonClick() {
    // TODO
}
package com.gpetuhov.android.compose.basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                    MainActivityUI2()
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

    // same as width = match_parent
    // Modifier.fillMaxWidth()

    // same as height = match_parent
    // Modifier.fillMaxHeight()

    // Modifier.clickable(onClick = { onTextClick() })

    ) {
        Text(text = "Press me")
    }
}

@Composable
fun MainActivityUI2() {
    // There are no margins (because there is no box model),
    // but we can combine multiple paddings

    Text(
        text = "Hello, world",
        modifier = Modifier
            .clickable(onClick = { onTextClick() }) // make widget clickable
            .padding(16.dp) // this works like margin
            .border(1.dp, Color.Black)
            .padding(16.dp) // this works like padding
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeBasicsTheme {
        MainActivityUI2()
    }
}

private fun onButtonClick() {
    // TODO
}

private fun onTextClick() {
    // TODO
}
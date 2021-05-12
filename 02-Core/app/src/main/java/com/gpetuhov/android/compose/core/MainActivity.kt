package com.gpetuhov.android.compose.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen2()
        }
    }
}

@Composable
fun MainScreen() {
    // Surface is a portion of the screen with color.
    // Surface can have only one child.
    Surface(
        color = Color.DarkGray,
        modifier = Modifier.fillMaxSize()
    ) {
        // We can nest as many Composables, as needed.
        // This Surface acts like a background of the Text.
        Surface(
            color = Color.Yellow,
            modifier = Modifier.wrapContentSize( // now this Surface has size of its contents, not the parent
                align = Alignment.TopCenter // we can change alignment of Composables, which wrap their content
            )
        ) {
            Text(text = "Hello, world")
        }
    }
}

@Composable
fun MainScreen2() {
    Surface(
        color = Color.DarkGray,
        modifier = Modifier.fillMaxSize()
    ) {
        // Row can have many children arranged horizontally
        Row {
            VerticalBar(color = Color.Yellow)
            VerticalBar(color = Color.Green)
            VerticalBar(color = Color.Red)
        }
    }
}

@Composable
fun VerticalBar(color: Color) {
    Surface(
        color = color,
        modifier = Modifier
            .height(300.dp)
            .width(60.dp)
    ) { }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen2()
}
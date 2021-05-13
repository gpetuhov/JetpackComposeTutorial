package com.gpetuhov.android.compose.dynamic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

val namesList = mutableListOf(
    "John",
    "Bill",
    "Kate"
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    Column {
        NamesList()
    }
}

@Composable
fun NamesList() {
    namesList.forEach {
        Text(text = it)
    }

    Button(onClick = { namesList.add("New name") }) {
        Text(text = "Add new name")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}
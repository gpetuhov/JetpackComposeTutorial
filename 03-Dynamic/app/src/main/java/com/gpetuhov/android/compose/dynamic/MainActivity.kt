package com.gpetuhov.android.compose.dynamic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
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
            MainScreen3()
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

    // This will NOT update screen,
    // because here namesList is NOT the state of our Composable
    Button(onClick = { namesList.add("New name") }) {
        Text(text = "Add new name")
    }
}

@Composable
fun MainScreen2() {
    Column {
        NamesListWithState()
    }
}

@Composable
fun NamesListWithState() {
    // Here a Composable holds and controls its own state, and this is not good.
    // We have to lift up the state (aka state hoisting) - see MainScreen3
    val namesListState = remember { mutableStateListOf("John", "Bill", "Kate") }

    namesListState.forEach {
        Text(text = it)
    }

    // Here the state is updated, and this will trigger screen update
    // (screen updte is called Recomposition)
    Button(onClick = { namesListState.add("New name") }) {
        Text(text = "Add new name")
    }
}

@Composable
fun MainScreen3() {
    val namesListState = remember { mutableStateListOf("John", "Bill", "Kate") }

    Column {
        NamesList(namesListState) { namesListState.add("New name") }
    }
}

@Composable
fun NamesList(
    names: List<String>,
    onButtonClick: () -> Unit
) {
    names.forEach {
        Text(text = it)
    }

    Button(onClick = onButtonClick) {
        Text(text = "Add new name")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen3()
}
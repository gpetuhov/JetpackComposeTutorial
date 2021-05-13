package com.gpetuhov.android.compose.dynamic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider

val namesList = mutableListOf(
    "John",
    "Bill",
    "Kate"
)

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setContent {
            MainScreen4(viewModel = viewModel)
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
    // Here all state is contained in the top-level Composable.
    // But it is even more better to lift up the state into ViewModel - see MainScreen4

    val namesListState = remember {
        mutableStateListOf("John", "Bill", "Kate")
    }

    val newNameState = remember {
        mutableStateOf("")
    }

    Column {
        NamesList(
            names = namesListState,
            textFieldValue = newNameState.value,
            onButtonClick = {
                namesListState.add(newNameState.value)
                newNameState.value = ""
            },
            onTextInputChange = { newValue -> newNameState.value = newValue }
        )
    }
}

@Composable
fun NamesList(
    names: List<String>,
    textFieldValue: String,
    onButtonClick: () -> Unit,
    onTextInputChange: (newValue: String) -> Unit
) {
    names.forEach {
        Text(text = it)
    }

    TextField(
        value = textFieldValue,
        onValueChange = onTextInputChange
    )

    Button(onClick = onButtonClick) {
        Text(text = "Add new name")
    }
}

@Composable
fun MainScreen4(viewModel: MainViewModel = MainViewModel()) {
    // To convert LiveData into State add
    // implementation "androidx.compose.runtime:runtime-livedata:$compose_version"
    // to module-level build.gradle script
    val newNameState = viewModel.textFieldState.observeAsState("")

    Column {
        NameInput(
            textFieldValue = newNameState.value,
            onTextInputChange = { newValue -> viewModel.onTextChanged(newValue) }
        )
    }
}

@Composable
fun NameInput(
    textFieldValue: String,
    onTextInputChange: (newValue: String) -> Unit
) {
    TextField(
        value = textFieldValue,
        onValueChange = onTextInputChange
    )

    Button(onClick = { /* Do nothing */ }) {
        Text(text = textFieldValue)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen4()
}
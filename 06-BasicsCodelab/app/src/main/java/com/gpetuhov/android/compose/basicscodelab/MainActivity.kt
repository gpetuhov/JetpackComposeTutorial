package com.gpetuhov.android.compose.basicscodelab

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gpetuhov.android.compose.basicscodelab.ui.theme.JetpackComposeBasicsCodelabTheme

// This is needed for 'by remember {...}' to work
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreenContent()
            }
        }
    }
}

// This way MyApp composable can be reused throughout the app
// (this is called a container composable function)
@Composable
fun MyApp(content: @Composable () -> Unit) {
    JetpackComposeBasicsCodelabTheme() {
        Surface(color = Color.Yellow) {
            content()
        }
    }
}

@Composable
fun MyScreenContent(names: List<String> = List(1000) { "Hello Android #$it" }) {
    val counterState = remember { mutableStateOf(0) }

    // fillMaxHeight here is needed to occupy all the screen
    Column(modifier = Modifier.fillMaxHeight()) {
        // This Composable has weight of 1,
        // so it will occupy all available space of the parent.
        // This will place Counter at the bottom of the parent.
        NameList(names, Modifier.weight(1f))

        Counter(
            count = counterState.value,
            updateCount = { newCount ->
                counterState.value = newCount
            }
        )
    }
}

@Composable
fun NameList(names: List<String>, modifier: Modifier = Modifier) {
    // This is like RecyclerView (renders only the visible items on screen).
    // Note: LazyColumn doesn't recycle its children like RecyclerView.
    // It emits new Composables as you scroll through it and is still performant
    // as emitting Composables is relatively cheap compared to
    // instantiating Android Views.
    // Note 2: Another option is to use ScrollableColumn,
    // which is equivalent to ScrollView (renders all its children at the same time),
    // but this does not fit for lists with many items.
    LazyColumn(modifier = modifier) {
        items(
            items = names,
            itemContent = { name ->
                Greeting(name = name)

                // Creates horizontal divider
                Divider(color = Color.Black)
            }
        )
    }
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(
        onClick = { updateCount(count+1) },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (count > 5) Color.Green else Color.White
        )
    ) {
        Text("I've been clicked $count times")
    }
}

@Composable
fun Greeting(name: String) {
    var isSelected by remember { mutableStateOf(false) }
    val backgroundColor by animateColorAsState(if (isSelected) Color.Red else Color.Transparent)

    Text(
        text = "Hello $name!",
        modifier = Modifier
            .padding(24.dp)
            .background(color = backgroundColor)
            .clickable(onClick = { isSelected = !isSelected })
    )
}

@Preview
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreenContent()
    }
}
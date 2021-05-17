package com.gpetuhov.android.compose.layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gpetuhov.android.compose.layouts.ui.theme.JetpackComposeLayoutsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeLayoutsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LayoutsCodelab()
                }
            }
        }
    }
}

@Composable
fun LayoutsCodelab() {
    Scaffold { innerPadding ->
        // innerPadding is the padding that should be applied
        // to the content root composable to constrain
        // the items appropriately on the screen.
        Text(text = "Hi there!", modifier = Modifier.padding(innerPadding))
    }
}

@Preview(showBackground = true)
@Composable
fun LayoutsCodelabPreview() {
    JetpackComposeLayoutsTheme {
        LayoutsCodelab()
    }
}

@Composable
fun PhotographerCard(modifier: Modifier = Modifier) {
    Row(modifier) {
        Surface(
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
            // Image goes here
        }
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text("Alfred Sisley", fontWeight = FontWeight.Bold)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text("3 minutes ago", style = MaterialTheme.typography.body2)
            }
        }
    }
}
@Preview (showBackground = true)
@Composable
fun PhotographerCardPreview() {
    JetpackComposeLayoutsTheme {
        PhotographerCard()
    }
}
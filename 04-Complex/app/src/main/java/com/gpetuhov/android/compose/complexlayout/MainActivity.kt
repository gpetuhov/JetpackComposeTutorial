package com.gpetuhov.android.compose.complexlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gpetuhov.android.compose.complexlayout.ui.theme.JetpackComposeComplexLayoutTheme

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
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.LightGray
    ) {
        ProfileCard()
    }
}

@Composable
fun ProfileCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier.wrapContentSize()
        ) {
            ProfilePicture()
            ProfileContent()
        }
    }
}

@Composable
fun ProfilePicture() {
    Image(
        painter = painterResource(id = R.drawable.avatar01),
        contentDescription = stringResource(id = R.string.app_name),
        modifier = Modifier.size(72.dp)
    )
}

@Composable
fun ProfileContent() {
    Text(text = "Kate Smith")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}
package com.gpetuhov.android.compose.complexlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.google.accompanist.coil.rememberCoilPainter
import com.gpetuhov.android.compose.complexlayout.ui.theme.MyTheme
import com.gpetuhov.android.compose.complexlayout.ui.theme.lightGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                UserApplication()
            }
        }
    }
}

@Composable
fun UserApplication() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "users_list") {
        composable("users_list") {
            UserListScreen(users = userList, navController = navController)
        }

        composable(
            route = "user_details/{userId}",
            arguments = listOf(
                navArgument("userId") { type = NavType.IntType }
            )
        ) { navBackStackEntry ->
            UserDetailsScreen(
                userId = navBackStackEntry.arguments!!.getInt("userId"),
                navController = navController
            )
        }
    }
}

@Composable
fun UserListScreen(users: List<User> = userList, navController: NavHostController? = null) {
    Scaffold(
        topBar = {
            AppBar(
                title = "User list",
                icon = Icons.Default.Home
            ) { /* Do nothing */ }
        }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            // This is like RecyclerView
            LazyColumn {
                items(users) { user ->
                    ProfileCard(user = user) {
                        navController?.navigate(route = "user_details/${user.id}")
                    }
                }
            }
        }
    }
}

@Composable
fun UserDetailsScreen(userId: Int = 0, navController: NavHostController? = null) {
    val user = userList.first { it.id == userId }
    Scaffold(
        topBar = {
            AppBar(
                title = "User details",
                icon = Icons.Default.ArrowBack
            ) {
                navController?.navigateUp()
            }
        }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                ProfilePicture(user = user, imageSize = 240.dp)
                ProfileContent(user = user, alignment = Alignment.CenterHorizontally)
            }
        }
    }
}

@Composable
fun AppBar(title: String, icon: ImageVector, onIconClick: () -> Unit) {
    TopAppBar(
        navigationIcon = { Icon(
            imageVector = icon,
            contentDescription = "Navigation icon",
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .clickable(onClick = onIconClick)
        ) },
        title = { Text(text = title) }
    )
}

@Composable
fun ProfileCard(user: User, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .clickable(onClick = onClick),
        elevation = 8.dp,
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture(user = user, imageSize = 72.dp)
            ProfileContent(user = user, alignment = Alignment.Start)
        }
    }
}

@Composable
fun ProfilePicture(user: User, imageSize: Dp) {
    Card(
        shape = CircleShape,
        border = BorderStroke(
            width = 2.dp,
            color = if (user.isOnline) MaterialTheme.colors.lightGreen
                    else Color.Red
        ),
        modifier = Modifier.padding(16.dp),
        elevation = 4.dp
    ) {
        Image(
            painter = rememberCoilPainter(
                request = user.pictureUrl,
                previewPlaceholder = R.drawable.ic_baseline_person_24

            ),
            contentDescription = "Profile picture",
            modifier = Modifier.size(imageSize),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ProfileContent(user: User, alignment: Alignment.Horizontal) {
    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = alignment
    ) {
        // this adds alpha
        CompositionLocalProvider(
            LocalContentAlpha provides
                    if (user.isOnline) 1f else ContentAlpha.medium
        ) {
            Text(
                text = user.name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.h5
            )
        }

        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = if (user.isOnline) "Active now" else "Offline",
                style = MaterialTheme.typography.body2
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserListScreenPreview() {
    MyTheme {
        UserListScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun UserDetailsScreenPreview() {
    MyTheme {
        UserDetailsScreen()
    }
}
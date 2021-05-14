package com.gpetuhov.android.compose.complexlayout

data class User(
    val name: String,
    val isOnline: Boolean,
    val drawableId: Int
)

val userList = listOf(
    User("Kate Smith", true, R.drawable.avatar01),
    User("Jane May", false, R.drawable.avatar02),
    User("Maria Johnson", true, R.drawable.avatar03),
    User("Kate Smith", true, R.drawable.avatar01),
    User("Jane May", false, R.drawable.avatar02),
    User("Maria Johnson", true, R.drawable.avatar03),
    User("Kate Smith", true, R.drawable.avatar01),
    User("Jane May", false, R.drawable.avatar02),
    User("Maria Johnson", true, R.drawable.avatar03),
    User("Kate Smith", true, R.drawable.avatar01),
    User("Jane May", false, R.drawable.avatar02),
    User("Maria Johnson", true, R.drawable.avatar03),
    User("Kate Smith", true, R.drawable.avatar01),
    User("Jane May", false, R.drawable.avatar02),
    User("Maria Johnson", true, R.drawable.avatar03),
    User("Kate Smith", true, R.drawable.avatar01),
    User("Jane May", false, R.drawable.avatar02),
    User("Maria Johnson", true, R.drawable.avatar03),
    User("Kate Smith", true, R.drawable.avatar01),
    User("Jane May", false, R.drawable.avatar02),
    User("Maria Johnson", true, R.drawable.avatar03),
)
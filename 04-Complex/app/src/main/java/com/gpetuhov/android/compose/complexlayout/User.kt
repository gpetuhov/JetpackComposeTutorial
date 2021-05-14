package com.gpetuhov.android.compose.complexlayout

data class User(
    val name: String,
    val isOnline: Boolean,
    val pictureUrl: String
)

val userList = listOf(
    User(
        name = "Kate Smith",
        isOnline = true,
        pictureUrl = "https://images.unsplash.com/photo-1554652297-6e7a24cf8fde?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1325&q=80"
    ),
    User(
        name = "Jane May",
        isOnline = false,
        pictureUrl = "https://images.unsplash.com/photo-1508186225823-0963cf9ab0de?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
    ),
    User(
        name = "Maria Johnson",
        isOnline = true,
        pictureUrl = "https://images.unsplash.com/photo-1553682233-501482563afc?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
    ),
    User(
        name = "Kate Smith",
        isOnline = true,
        pictureUrl = "https://images.unsplash.com/photo-1554652297-6e7a24cf8fde?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1325&q=80"
    ),
    User(
        name = "Jane May",
        isOnline = false,
        pictureUrl = "https://images.unsplash.com/photo-1508186225823-0963cf9ab0de?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
    ),
    User(
        name = "Maria Johnson",
        isOnline = true,
        pictureUrl = "https://images.unsplash.com/photo-1553682233-501482563afc?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
    ),
    User(
        name = "Kate Smith",
        isOnline = true,
        pictureUrl = "https://images.unsplash.com/photo-1554652297-6e7a24cf8fde?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1325&q=80"
    ),
    User(
        name = "Jane May",
        isOnline = false,
        pictureUrl = "https://images.unsplash.com/photo-1508186225823-0963cf9ab0de?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
    ),
    User(
        name = "Maria Johnson",
        isOnline = true,
        pictureUrl = "https://images.unsplash.com/photo-1553682233-501482563afc?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
    ),
    User(
        name = "Kate Smith",
        isOnline = true,
        pictureUrl = "https://images.unsplash.com/photo-1554652297-6e7a24cf8fde?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1325&q=80"
    ),
    User(
        name = "Jane May",
        isOnline = false,
        pictureUrl = "https://images.unsplash.com/photo-1508186225823-0963cf9ab0de?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
    ),
    User(
        name = "Maria Johnson",
        isOnline = true,
        pictureUrl = "https://images.unsplash.com/photo-1553682233-501482563afc?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
    ),
    User(
        name = "Kate Smith",
        isOnline = true,
        pictureUrl = "https://images.unsplash.com/photo-1554652297-6e7a24cf8fde?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1325&q=80"
    ),
    User(
        name = "Jane May",
        isOnline = false,
        pictureUrl = "https://images.unsplash.com/photo-1508186225823-0963cf9ab0de?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
    ),
    User(
        name = "Maria Johnson",
        isOnline = true,
        pictureUrl = "https://images.unsplash.com/photo-1553682233-501482563afc?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
    ),
    User(
        name = "Kate Smith",
        isOnline = true,
        pictureUrl = "https://images.unsplash.com/photo-1554652297-6e7a24cf8fde?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1325&q=80"
    ),
    User(
        name = "Jane May",
        isOnline = false,
        pictureUrl = "https://images.unsplash.com/photo-1508186225823-0963cf9ab0de?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
    ),
    User(
        name = "Maria Johnson",
        isOnline = true,
        pictureUrl = "https://images.unsplash.com/photo-1553682233-501482563afc?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
    ),
)
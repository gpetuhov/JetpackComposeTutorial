package com.gpetuhov.android.compose.complexlayout

data class User(
    val id: Int,
    val name: String,
    val isOnline: Boolean,
    val pictureUrl: String
)

val userList = listOf(
    User(
        id = 0,
        name = "Kate Smith",
        isOnline = true,
        pictureUrl = "https://images.unsplash.com/photo-1554652297-6e7a24cf8fde?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1325&q=80"
    ),
    User(
        id = 1,
        name = "Jane May",
        isOnline = false,
        pictureUrl = "https://images.unsplash.com/photo-1508186225823-0963cf9ab0de?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
    ),
    User(
        id = 2,
        name = "Maria Johnson",
        isOnline = true,
        pictureUrl = "https://images.unsplash.com/photo-1553682233-501482563afc?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
    ),
    User(
        id = 3,
        name = "Kate Smith",
        isOnline = true,
        pictureUrl = "https://images.unsplash.com/photo-1554652297-6e7a24cf8fde?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1325&q=80"
    ),
    User(
        id = 4,
        name = "Jane May",
        isOnline = false,
        pictureUrl = "https://images.unsplash.com/photo-1508186225823-0963cf9ab0de?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
    ),
    User(
        id = 5,
        name = "Maria Johnson",
        isOnline = true,
        pictureUrl = "https://images.unsplash.com/photo-1553682233-501482563afc?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
    ),
    User(
        id = 6,
        name = "Kate Smith",
        isOnline = true,
        pictureUrl = "https://images.unsplash.com/photo-1554652297-6e7a24cf8fde?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1325&q=80"
    ),
    User(
        id = 7,
        name = "Jane May",
        isOnline = false,
        pictureUrl = "https://images.unsplash.com/photo-1508186225823-0963cf9ab0de?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
    ),
    User(
        id = 8,
        name = "Maria Johnson",
        isOnline = true,
        pictureUrl = "https://images.unsplash.com/photo-1553682233-501482563afc?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
    ),
    User(
        id = 9,
        name = "Kate Smith",
        isOnline = true,
        pictureUrl = "https://images.unsplash.com/photo-1554652297-6e7a24cf8fde?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1325&q=80"
    ),
    User(
        id = 10,
        name = "Jane May",
        isOnline = false,
        pictureUrl = "https://images.unsplash.com/photo-1508186225823-0963cf9ab0de?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
    ),
    User(
        id = 11,
        name = "Maria Johnson",
        isOnline = true,
        pictureUrl = "https://images.unsplash.com/photo-1553682233-501482563afc?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
    ),
    User(
        id = 12,
        name = "Kate Smith",
        isOnline = true,
        pictureUrl = "https://images.unsplash.com/photo-1554652297-6e7a24cf8fde?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1325&q=80"
    ),
    User(
        id = 13,
        name = "Jane May",
        isOnline = false,
        pictureUrl = "https://images.unsplash.com/photo-1508186225823-0963cf9ab0de?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
    ),
    User(
        id = 14,
        name = "Maria Johnson",
        isOnline = true,
        pictureUrl = "https://images.unsplash.com/photo-1553682233-501482563afc?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
    ),
    User(
        id = 15,
        name = "Kate Smith",
        isOnline = true,
        pictureUrl = "https://images.unsplash.com/photo-1554652297-6e7a24cf8fde?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1325&q=80"
    ),
    User(
        id = 16,
        name = "Jane May",
        isOnline = false,
        pictureUrl = "https://images.unsplash.com/photo-1508186225823-0963cf9ab0de?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
    ),
    User(
        id = 17,
        name = "Maria Johnson",
        isOnline = true,
        pictureUrl = "https://images.unsplash.com/photo-1553682233-501482563afc?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
    ),
)
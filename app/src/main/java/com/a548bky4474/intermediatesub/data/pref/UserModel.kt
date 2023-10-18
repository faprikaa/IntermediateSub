package com.a548bky4474.intermediatesub.data.pref

data class UserModel(
    val email: String,
    val token: String,
    val isLogin: Boolean = false
)
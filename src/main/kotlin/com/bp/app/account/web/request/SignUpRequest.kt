package com.bp.app.account.web.request

data class SignUpRequest(
    val name: String,
    val phone: String,
    val email: String,
    val password: String
)
package com.bp.app.user.web.request

import com.bp.app.user.domain.User

data class SignUpRequest(
    val name: String,
    val phone: String,
    val email: String,
    val password: String
)

fun SignUpRequest.toEntity() = User(
    name = name,
    phone = phone,
    email = email,
    password = password
)

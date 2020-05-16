package com.bp.app.account.web.request

import com.bp.app.account.domain.Account

data class SignUpRequest(
    val name: String,
    val phone: String,
    val email: String,
    val password: String
)

fun SignUpRequest.toEntity() = Account(
    name = name,
    phone = phone,
    email = email,
    password = password
)

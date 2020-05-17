package com.bp.app.user.domain

import com.bp.app.user.service.UserDto

fun User.toDto() = UserDto(
    id = id!!,
    name = name!!,
    phone = phone!!,
    email = email!!
)
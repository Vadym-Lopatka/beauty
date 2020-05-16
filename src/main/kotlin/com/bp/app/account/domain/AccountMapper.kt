package com.bp.app.account.domain

import com.bp.app.account.service.AccountDto

fun Account.toDto() = AccountDto(
    id = id!!,
    name = name!!,
    phone = phone!!,
    email = email!!
)
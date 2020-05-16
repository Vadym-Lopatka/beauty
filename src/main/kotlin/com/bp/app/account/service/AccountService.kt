package com.bp.app.account.service

import com.bp.app.account.Account
import com.bp.app.account.AccountDto
import com.bp.app.account.AccountRepository
import com.bp.app.account.web.request.SignUpRequest
import org.springframework.stereotype.Service

@Service
class AccountService(private val repository: AccountRepository) {

    fun save(request: SignUpRequest): AccountDto {
        return repository.save(request.toEntity()).toDto()
    }
}

fun SignUpRequest.toEntity() = Account(
    name = name,
    phone = phone,
    email = email,
    password = password
)

fun Account.toDto() = AccountDto(
    id = id!!,
    name = name!!,
    phone = phone!!,
    email = email!!
)
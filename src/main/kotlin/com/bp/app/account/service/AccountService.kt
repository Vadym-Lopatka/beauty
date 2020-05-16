package com.bp.app.account.service

import com.bp.app.account.domain.AccountRepository
import com.bp.app.account.domain.toDto
import com.bp.app.account.web.request.SignUpRequest
import com.bp.app.account.web.request.toEntity
import org.springframework.stereotype.Service

@Service
class AccountService(private val repository: AccountRepository) {

    fun save(request: SignUpRequest): AccountDto {
        return repository.save(request.toEntity()).toDto()
    }
}

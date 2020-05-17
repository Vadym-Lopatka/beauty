package com.bp.app.user.service

import com.bp.app.user.domain.UserRepository
import com.bp.app.user.domain.toDto
import com.bp.app.user.web.request.SignUpRequest
import com.bp.app.user.web.request.toEntity
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository) {

    fun save(request: SignUpRequest): UserDto {
        return repository.save(request.toEntity()).toDto()
    }
}

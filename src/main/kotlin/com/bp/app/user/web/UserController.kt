package com.bp.app.user.web

import com.bp.app.user.service.UserDto
import com.bp.app.user.service.UserService
import com.bp.app.user.web.UserController.Companion.USER_URL
import com.bp.app.user.web.request.SignUpRequest
import com.bp.app.config.URLConfiguration.API_PREFIX
import com.bp.app.config.getLogger
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping(USER_URL)
class UserController(private val service: UserService) {
    private val log = getLogger(javaClass)

    @PostMapping
    fun signUp(@RequestBody @Valid request: SignUpRequest): UserDto {
        log.debug("[API] SignUp request: $request")
        return service.save(request)
    }

    companion object {
        const val USER_URL = "${API_PREFIX}/user"
    }
}
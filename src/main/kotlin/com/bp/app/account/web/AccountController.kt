package com.bp.app.account.web

import com.bp.app.account.AccountDto
import com.bp.app.account.service.AccountService
import com.bp.app.account.web.AccountController.Companion.ACCOUNT_URL
import com.bp.app.account.web.request.SignUpRequest
import com.bp.app.config.URLConfiguration.API_PREFIX
import com.bp.app.config.getLogger
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping(ACCOUNT_URL)
class AccountController(private val service: AccountService) {
    private val log = getLogger(javaClass)

    @PostMapping
    fun signUp(@RequestBody @Valid request: SignUpRequest): AccountDto {
        log.debug("[API] SignUp request: $request")
        return service.save(request)
    }

    companion object {
        const val ACCOUNT_URL = "${API_PREFIX}/account"
    }
}
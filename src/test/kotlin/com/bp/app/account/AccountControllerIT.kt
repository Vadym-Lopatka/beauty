package com.bp.app.account

import com.bp.app.account.domain.AccountRepository
import com.bp.app.account.service.AccountDto
import com.bp.app.account.web.AccountController.Companion.ACCOUNT_URL
import com.bp.app.account.web.request.SignUpRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AccountControllerIT {

    @Autowired
    private lateinit var testRestTemplate: TestRestTemplate

    @Autowired
    private lateinit var accountRepository: AccountRepository

    @Test
    fun `should sign-up client`() {
        // given
        val signUpRequest = buildSignUpRequest()
        val sizeBefore = accountRepository.findAll().size

        // when
        val httpRequest = HttpEntity(signUpRequest)
        val response = testRestTemplate.exchange(ACCOUNT_URL, HttpMethod.POST, httpRequest, AccountDto::class.java)
        assertTrue(response.statusCode.is2xxSuccessful)
        val account = response.body!!
        val sizeAfter = accountRepository.findAll().size

        //then
        assertThat(sizeBefore + 1).isEqualTo(sizeAfter)
        assertThat(account.id).isNotNull()
        assertThat(signUpRequest.name).isEqualTo(account.name)
        assertThat(signUpRequest.phone).isEqualTo(account.phone)
        assertThat(signUpRequest.email).isEqualTo(account.email)
    }

    private fun buildSignUpRequest() = SignUpRequest(
        name = "viktor yanukovych",
        phone = "0661234567",
        email = "straus-father@rostov.ru",
        password = "vitya1958"
    )
}
package com.bp.app.account.domain

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "account")
class Account(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @get: NotNull
    @Column(name = "phone", nullable = false)
    var phone: String? = null,

    @get: NotNull
    @Column(name = "email", nullable = false)
    var email: String? = null,

    @get: NotNull
    @Column(name = "name", nullable = false)
    var name: String? = null,

    @get: NotNull
    @Column(name = "password", nullable = false)
    var password: String? = null

) : Serializable {

    override fun toString() = "Account{" +
        "id=$id" +
        ", phone='$phone'" +
        ", email='$email'" +
        ", name='$name'" +
        "}"
}

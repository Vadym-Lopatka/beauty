package com.bp.app.profile

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "profile")
class Profile(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @get: NotNull
    @Column(name = "brand_id", nullable = false)
    var phone: String? = null,

    @get: NotNull
    @Column(name = "name", nullable = false)
    var email: String? = null,

    @get: NotNull
    @Column(name = "subject", nullable = false)
    var name: String? = null

) : Serializable {

    override fun toString() = "Profile{" +
        "id=$id" +
        ", phone='$phone'" +
        ", email='$email'" +
        ", name='$name'" +
        "}"
}

package com.bp.app.user.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.BatchSize
import org.hibernate.annotations.Cache
import org.hibernate.annotations.CacheConcurrencyStrategy
import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "beauty_user")
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @get: NotNull
    @Column(name = "phone", nullable = false)
    var phone: String? = null,

    @get: NotNull
    @Column(name = "email", nullable = false)
    var email: String? = null,

    @field:NotNull
    @Column(nullable = false)
    var activated: Boolean = false,

    @get: NotNull
    @Column(name = "name", nullable = false)
    var name: String? = null,

    @JsonIgnore
    @get: NotNull
    @Column(name = "password", nullable = false)
    var password: String? = null,

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "user_authority",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "authority_name", referencedColumnName = "name")]
    )
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @BatchSize(size = 20)
    var authorities: MutableSet<Authority> = mutableSetOf()

) : Serializable {

    override fun toString() = "User{" +
        "id=$id" +
        ", phone='$phone'" +
        ", email='$email'" +
        ", activated='$activated'" +
        ", name='$name'" +
        "}"
}

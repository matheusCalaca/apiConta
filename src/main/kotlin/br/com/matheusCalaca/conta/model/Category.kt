package br.com.matheusCalaca.conta.model

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
data class Category(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @Column(unique = true)
        @get: NotBlank
        var name: String
)

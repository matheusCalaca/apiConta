package br.com.matheusCalaca.conta.model

import javax.persistence.*

@Entity
data class Category(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(unique = true)
    var name: String?
)

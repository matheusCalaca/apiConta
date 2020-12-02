package br.com.matheusCalaca.conta.model

import javax.persistence.*

@Entity
data class PaymentMethod(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(name = "institution_name")
    var institutionName: String,
    @Column(name = "payment_method")
    var paymentMethod: String
)


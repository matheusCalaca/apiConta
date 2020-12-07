package br.com.matheusCalaca.conta.model

import com.sun.istack.NotNull
import java.util.*
import javax.persistence.*

@Entity
data class Payment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    @ManyToOne
    @NotNull
    val bill: Bill,
    var datePayment: Date = Date(),
    @ManyToOne
    @NotNull
    val paymentMethod: PaymentMethod,
    var description: String,
    var receipt: String,
    var status: Boolean = true

)


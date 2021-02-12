package br.com.matheusCalaca.conta.model

import br.com.matheusCalaca.conta.model.enum.EnumBillStatus
import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity(name = "bill")
data class Bill(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    var ownerIdentification: String,

    var maturityDate: Date,

    var price: BigDecimal,

    var description: String,

    var status: EnumBillStatus,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_category")
    var category: Category

)

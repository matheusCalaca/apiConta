package br.com.matheusCalaca.conta.model

import br.com.matheusCalaca.conta.model.enum.EnumBillStatus
import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
data class Bill(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,

        var maturityDate: Date,

        var price: BigDecimal,

        var description: String,

        var status: EnumBillStatus,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "bill_category")
        var category: Category

)

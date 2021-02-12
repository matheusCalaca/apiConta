package br.com.matheusCalaca.conta.model.DTO

import br.com.matheusCalaca.conta.model.enum.EnumBillStatus
import java.math.BigDecimal
import java.util.*

data class BillDto(


    var maturityDate: Date,

    var price: BigDecimal,

    var description: String,

    var categoryId: Long,

    )

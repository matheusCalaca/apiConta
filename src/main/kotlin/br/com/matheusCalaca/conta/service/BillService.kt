package br.com.matheusCalaca.conta.service

import br.com.matheusCalaca.conta.model.Bill
import org.springframework.stereotype.Component

@Component
interface BillService {

    fun save(bill: Bill): Bill

    fun update(id: Long, bill: Bill): Bill
}

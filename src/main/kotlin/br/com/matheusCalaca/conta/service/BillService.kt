package br.com.matheusCalaca.conta.service

import br.com.matheusCalaca.conta.model.Bill
import br.com.matheusCalaca.conta.model.DTO.ConfTableDto
import br.com.matheusCalaca.conta.model.enum.EnumBillStatus
import org.springframework.stereotype.Component

@Component
interface BillService {

    fun creatBill(token: String, bill: Bill): Bill

    fun update(id: Long, bill: Bill): Bill

    fun delete(id: Long)

    fun getBills(token: String, page: Long, size: Long, year: String?, month: String?): List<Bill>

    fun hasCategoryByBill(idCategory: Long): Boolean

    fun isBillWasPaid(billId: Long): Boolean

    fun changeSatusBill(id: Long, billStatus: EnumBillStatus): Bill

    fun getBillsConf(token: String, year: String?, month: String?): ConfTableDto
}

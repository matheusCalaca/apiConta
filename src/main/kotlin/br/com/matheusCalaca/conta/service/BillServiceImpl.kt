package br.com.matheusCalaca.conta.service

import br.com.matheusCalaca.conta.model.Bill
import br.com.matheusCalaca.conta.model.enum.EnumBillStatus
import br.com.matheusCalaca.conta.repository.BillRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@Transactional
@Qualifier("billService")
class BillServiceImpl : BillService {

    @Autowired
    lateinit var repository: BillRepository


    override fun save(bill: Bill): Bill {
        return repository.save(bill)
    }

    fun findByid(id: Long): Bill {
        return repository.findById(id).get()
    }

    override fun update(id: Long, bill: Bill): Bill {
        val billReturn: Bill = findByid(id)
        bill.id = billReturn.id
        return repository.save(bill)
    }

    override fun delete(id: Long) {
        repository.deleteById(id)
    }

    override fun getBills(page: Long, size: Long): List<Bill> {
        return repository.getBills(page, size)
    }

    override fun hasCategoryByBill(idCategory: Long): Boolean {
        val categoryCont = repository.findHasPayment(idCategory)
        return categoryCont > 0;

    }

    override fun isBillWasPaid(billId: Long): Boolean {
        val bill = findByid(billId)
        val isPayment = bill.status == EnumBillStatus.PAYMENT
        if (isPayment) {
            return true
        }

        return false
    }

    override fun changeSatusBill(id: Long, billStatus: EnumBillStatus): Bill {
        val bill = setNewStatusBill(id, billStatus)
        return update(id, bill)
    }


    private fun setNewStatusBill(id: Long, billStatus: EnumBillStatus): Bill {
        val bill = findByid(id)
        bill.status = billStatus
        return bill
    }

}

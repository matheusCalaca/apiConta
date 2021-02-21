package br.com.matheusCalaca.conta.service

import br.com.matheusCalaca.conta.model.Bill
import br.com.matheusCalaca.conta.model.DTO.ConfTableDto
import br.com.matheusCalaca.conta.model.enum.EnumBillStatus
import br.com.matheusCalaca.conta.repository.BillRepository
import br.com.matheusCalaca.conta.userAPI.service.UserService
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

    @Autowired
    lateinit var userService: UserService

    @Autowired
    @Qualifier("paymentService")
    lateinit var servicePayment: PaymentService


    override fun creatBill(token: String, bill: Bill): Bill {
        val cpfResponseDto = userService.getUserCpf(token)
        bill.ownerIdentification = cpfResponseDto?.cpf!!
        bill.status = EnumBillStatus.OPEN
        val hasOwner = userService.verifyHasOwner(bill.ownerIdentification)
        if (hasOwner == false) {
            throw java.lang.IllegalArgumentException("Cliente não localizado para registrar a conta")
        }
        return save(bill)
    }

    fun save(bill: Bill): Bill {
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
        val hasBillPaymentActive: Boolean = servicePayment.hasBillPaymentActive(id)

        if (hasBillPaymentActive) {
            throw IllegalArgumentException("Não pode deletar conta com pagamento ativo!")
        }

        repository.deleteById(id)
    }

    override fun getBills(token: String, page: Long, size: Long, year: String?, month: String?): List<Bill> {
        val cpfResponseDto = userService.getUserCpf(token)

        if(year != null && month != null ){
            return repository.getBills(page, size, cpfResponseDto?.cpf!!, year, month)

        }
        if(year != null && month == null ){
            return repository.getBills(page, size, cpfResponseDto?.cpf!!, year)

        }
        return repository.getBills(page, size, cpfResponseDto?.cpf!!)
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

    override fun getBillsConf(token: String, year: String?, month: String?): ConfTableDto {
        val cpfResponseDto = userService.getUserCpf(token)

        val qt = if(year != null && month != null ){
            repository.countToken(cpfResponseDto?.cpf!!, year, month)
        }else if(year != null && month == null ){
            repository.countToken(cpfResponseDto?.cpf!!, year)
        }else{
            repository.countToken(cpfResponseDto?.cpf!!)
        }


        return ConfTableDto(qt)
    }


    private fun setNewStatusBill(id: Long, billStatus: EnumBillStatus): Bill {
        val bill = findByid(id)
        bill.status = billStatus
        return bill
    }

}

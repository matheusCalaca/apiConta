package br.com.matheusCalaca.conta.service

import br.com.matheusCalaca.conta.model.Payment
import br.com.matheusCalaca.conta.model.enum.EnumBillStatus
import br.com.matheusCalaca.conta.repository.PaymentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service


@Service
@Qualifier("paymentService")
class PaymentServiceImpl : PaymentService {

    @Autowired
    lateinit var repository: PaymentRepository


    @Autowired
    @Qualifier("billService")
    lateinit var serviceBill: BillService

    override fun save(payment: Payment): Payment {

        valied(payment)

        serviceBill.changeSatusBill(payment.bill.id, EnumBillStatus.PAYMENT)

        return repository.save(payment)
    }

    private fun valied(payment: Payment) {
        val isBillWasPaid: Boolean = serviceBill.isBillWasPaid(payment.bill.id)
        if (isBillWasPaid) {
            throw IllegalArgumentException("A conta ja Foi Paga")
        }
    }

    override fun delete(id: Long) {
        repository.deleteById(id)
    }

    override fun hasPaymentMethodInPayment(idPaymentMethod: Long): Boolean {
        val countPayment: Long = repository.countPaymentMethod(idPaymentMethod)
        return countPayment > 0
    }
}

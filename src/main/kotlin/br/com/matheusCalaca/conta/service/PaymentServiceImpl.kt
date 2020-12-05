package br.com.matheusCalaca.conta.service

import br.com.matheusCalaca.conta.model.Payment
import br.com.matheusCalaca.conta.repository.PaymentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service


@Service
@Qualifier("paymentService")
class PaymentServiceImpl: PaymentService {

    @Autowired
    lateinit var repository: PaymentRepository

    override fun save(payment: Payment): Payment {
        return repository.save(payment)
    }

    override fun delete(id: Long) {
        repository.deleteById(id)
    }

    override fun hasPaymentMethodInPayment(idPaymentMethod: Long): Boolean {
        val countPayment:Long  = repository.countPaymentMethod(idPaymentMethod)
        return countPayment > 0
    }
}

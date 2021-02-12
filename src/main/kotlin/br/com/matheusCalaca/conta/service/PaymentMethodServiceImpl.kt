package br.com.matheusCalaca.conta.service

import br.com.matheusCalaca.conta.model.PaymentMethod
import br.com.matheusCalaca.conta.repository.PaymentMethodRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
@Qualifier("paymentMethodService")
class PaymentMethodServiceImpl : PaymentMethodService {

    @Autowired
    lateinit var repository: PaymentMethodRepository

    @Autowired
    @Qualifier("paymentService")
    lateinit var servicePayment: PaymentService

    override fun save(paymentMethod: PaymentMethod): PaymentMethod {
        return repository.save(paymentMethod)
    }

    fun findById(id: Long): PaymentMethod {
        return repository.findById(id).get()
    }

    override fun update(id: Long, paymentMethod: PaymentMethod): PaymentMethod {
        val paymentMethodReturn = findById(id)
        paymentMethod.id = paymentMethodReturn.id
        return repository.save(paymentMethod)
    }

    override fun findAll(): Iterable<PaymentMethod> {
        return repository.findAll()
    }

    override fun delete(id: Long) {
        val hasPaymentMethodInPayment = servicePayment.hasPaymentMethodInPayment(id)
        if (hasPaymentMethodInPayment) {
            throw IllegalArgumentException("Não pode ser excluido, ele esta ativo em Payment")
        }
        repository.deleteById(id)

    }
}

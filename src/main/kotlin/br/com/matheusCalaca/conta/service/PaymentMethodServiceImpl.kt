package br.com.matheusCalaca.conta.service

import br.com.matheusCalaca.conta.model.PaymentMethod
import br.com.matheusCalaca.conta.repository.PaymentMethodRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PaymentMethodServiceImpl : PaymentMethodService {

    @Autowired
    lateinit var repository: PaymentMethodRepository

    override fun save(paymentMethod: PaymentMethod): PaymentMethod {
        return repository.save(paymentMethod)
    }
}

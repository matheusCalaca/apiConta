package br.com.matheusCalaca.conta.service

import br.com.matheusCalaca.conta.model.Payment
import br.com.matheusCalaca.conta.repository.PaymentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class PaymentServiceImpl: PaymentService {

    @Autowired
    lateinit var repository: PaymentRepository

    override fun save(payment: Payment): Payment {
        return repository.save(payment)
    }
}

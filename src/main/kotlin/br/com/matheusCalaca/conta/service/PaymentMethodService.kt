package br.com.matheusCalaca.conta.service

import br.com.matheusCalaca.conta.model.PaymentMethod
import org.springframework.stereotype.Component

@Component
interface PaymentMethodService {
    fun save(paymentMethod: PaymentMethod): PaymentMethod
    fun update(id: Long, paymentMethod: PaymentMethod): PaymentMethod
    fun findAll(): Iterable<PaymentMethod>
}

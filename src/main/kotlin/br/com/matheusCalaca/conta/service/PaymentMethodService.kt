package br.com.matheusCalaca.conta.service

import br.com.matheusCalaca.conta.model.PaymentMethod
import org.apache.juli.logging.Log
import org.springframework.stereotype.Component

@Component
interface PaymentMethodService {
    fun save(paymentMethod: PaymentMethod): PaymentMethod
    fun update(id: Long, paymentMethod: PaymentMethod): PaymentMethod
}

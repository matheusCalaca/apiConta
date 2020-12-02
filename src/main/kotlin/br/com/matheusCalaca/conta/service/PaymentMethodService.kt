package br.com.matheusCalaca.conta.service

import br.com.matheusCalaca.conta.model.PaymentMethod
import org.springframework.stereotype.Component

@Component
interface PaymentMethodService {
    fun save(paymentMethod: PaymentMethod): PaymentMethod
}

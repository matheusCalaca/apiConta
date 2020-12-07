package br.com.matheusCalaca.conta.service

import br.com.matheusCalaca.conta.model.Payment
import org.springframework.stereotype.Component

@Component
interface PaymentService {
    fun save(payment: Payment): Payment
    fun delete(id: Long)
    fun hasPaymentMethodInPayment(idPaymentMethod: Long): Boolean
    fun hasBillPaymentActive(idBill: Long): Boolean

}

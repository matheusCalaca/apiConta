package br.com.matheusCalaca.conta.repository

import br.com.matheusCalaca.conta.model.PaymentMethod
import org.springframework.data.repository.CrudRepository

interface PaymentMethodRepository: CrudRepository<PaymentMethod, Long> {
}

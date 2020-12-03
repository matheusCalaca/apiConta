package br.com.matheusCalaca.conta.repository

import br.com.matheusCalaca.conta.model.Payment
import org.springframework.data.repository.CrudRepository

interface PaymentRepository: CrudRepository<Payment, Long> {

}

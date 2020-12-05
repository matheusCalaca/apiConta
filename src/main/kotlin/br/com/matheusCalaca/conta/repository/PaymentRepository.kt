package br.com.matheusCalaca.conta.repository

import br.com.matheusCalaca.conta.model.Payment
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface PaymentRepository : CrudRepository<Payment, Long> {

    @Query("select count (p.id) from Payment p  where p.paymentMethod.id = ?1 ")
    fun countPaymentMethod(idPaymentMethod: Long): Long

}

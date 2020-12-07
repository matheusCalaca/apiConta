package br.com.matheusCalaca.conta.repository

import br.com.matheusCalaca.conta.model.Payment
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface PaymentRepository : CrudRepository<Payment, Long> {

    @Query("select count (p.id) from Payment p  where p.paymentMethod.id = ?1 ")
    fun countPaymentMethod(idPaymentMethod: Long): Long

    @Query("select  p from Payment p where p.bill.id = ?1")
    fun findPaymentByBill(idBill: Long): List<Payment>

}

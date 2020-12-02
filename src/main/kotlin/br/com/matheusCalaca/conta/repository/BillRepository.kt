package br.com.matheusCalaca.conta.repository

import br.com.matheusCalaca.conta.model.Bill
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface BillRepository : CrudRepository<Bill, Long> {

    @Query("select * from bill  limit ?2 offset ?1 ", nativeQuery = true)
    fun getBills(page: Long, size: Long): List<Bill>

}

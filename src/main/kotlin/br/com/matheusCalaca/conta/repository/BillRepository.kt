package br.com.matheusCalaca.conta.repository

import br.com.matheusCalaca.conta.model.Bill
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface BillRepository : CrudRepository<Bill, Long> {

    @Query(
        "select * from bill b where b.owner_identification = ?3 and YEAR(b.maturity_date) = ?4 and MONTH(b.maturity_date) = ?5 order by 1 desc limit ?2 offset ?1  ",
        nativeQuery = true
    )
    fun getBills(page: Long, size: Long, token: String, year: String, month: String): List<Bill>

    @Query(
        "select * from bill b where b.owner_identification = ?3 and YEAR(b.maturity_date) = ?4  order by 1 desc limit ?2 offset ?1  ",
        nativeQuery = true
    )
    fun getBills(page: Long, size: Long, token: String, year: String): List<Bill>

    @Query(
        "select * from bill b where b.owner_identification = ?3 order by 1 desc limit ?2 offset ?1  ",
        nativeQuery = true
    )
    fun getBills(page: Long, size: Long, token: String): List<Bill>

    @Query("select count (b.id) from bill b  where b.category.id = ?1 ")
    fun findHasPayment(idPayment: Long): Long

    @Query("select count (b) from bill b  where b.ownerIdentification = ?1 ")
    fun countToken(token: String): Long

    @Query(
        "select COUNT(b.id) from bill b  where b.owner_identification = ?1  and YEAR(b.maturity_date) = ?2",
        nativeQuery = true
    )
    fun countToken(token: String, year: String): Long

    @Query(
        "select COUNT(*) from bill b  where b.owner_identification = ?1 and YEAR(b.maturity_date) = ?2 and MONTH(b.maturity_date) = ?3 ",
        nativeQuery = true
    )
    fun countToken(token: String, year: String, month: String): Long

}

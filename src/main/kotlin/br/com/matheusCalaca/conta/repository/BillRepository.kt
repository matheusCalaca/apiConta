package br.com.matheusCalaca.conta.repository

import br.com.matheusCalaca.conta.model.Bill
import org.springframework.data.repository.CrudRepository

interface BillRepository : CrudRepository<Bill, Long> {

}

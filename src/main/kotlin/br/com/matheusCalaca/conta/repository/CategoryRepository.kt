package br.com.matheusCalaca.conta.repository

import br.com.matheusCalaca.conta.model.Category
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface CategoryRepository : CrudRepository<Category, Long> {

    @Query("select c from Category c where c.name = ?1")
    fun findByName(name: String): Category
}

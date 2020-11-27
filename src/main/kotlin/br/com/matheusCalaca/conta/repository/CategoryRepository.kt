package br.com.matheusCalaca.conta.repository

import br.com.matheusCalaca.conta.model.Category
import org.springframework.data.repository.CrudRepository

interface CategoryRepository : CrudRepository<Category, Long> {
}

package br.com.matheusCalaca.conta.service

import br.com.matheusCalaca.conta.model.Category
import org.springframework.stereotype.Component

@Component
interface CategoryService {
    fun save(category: Category): Category
}

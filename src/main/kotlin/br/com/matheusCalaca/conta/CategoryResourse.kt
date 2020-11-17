package br.com.matheusCalaca.conta

import br.com.matheusCalaca.conta.model.Category
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CategoryResourse {

    @PostMapping("/category")
    fun createCategory(@RequestBody category: Category): Category {
        println(category)
        return category
    }


}

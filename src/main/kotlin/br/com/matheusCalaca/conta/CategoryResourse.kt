package br.com.matheusCalaca.conta

import br.com.matheusCalaca.conta.model.Category
import br.com.matheusCalaca.conta.service.CategoryService
import br.com.matheusCalaca.conta.service.CategoryServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CategoryResourse {

    @Autowired
    lateinit var categoryService: CategoryService

    @PostMapping("/category")
    fun createCategory(@RequestBody category: Category): Category {
        categoryService.save(category)
        println(category)
        return category
    }


}

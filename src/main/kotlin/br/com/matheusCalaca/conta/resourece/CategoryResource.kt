package br.com.matheusCalaca.conta.resourece

import br.com.matheusCalaca.conta.model.Category
import br.com.matheusCalaca.conta.model.DTO.CategoryDto
import br.com.matheusCalaca.conta.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("category")
class CategoryResource {

    @Autowired
    lateinit var categoryService: CategoryService

    @PostMapping
    fun createCategory(@RequestBody category: Category): Category {
        categoryService.save(category)
        return category
    }

    @GetMapping
    fun getCategory(@RequestParam("name") name: String): Category {
        return categoryService.findCategory(name)
    }

    @GetMapping("/all")
    fun getAllCategory(): Iterable<Category> {
        return categoryService.findAllCategory()
    }

    @PutMapping("/{id}")
    fun putCategory(@PathVariable("id") id: Long, @RequestBody dto: CategoryDto): Category {
        return categoryService.updateCategory(id, dto.name)
    }

    @DeleteMapping("/{id}")
    fun deleteCategory(@PathVariable("id") id: Long): String {
        categoryService.deleteCategory(id)
        return "Deletado com sucesso!"
    }


}

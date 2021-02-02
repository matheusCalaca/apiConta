package br.com.matheusCalaca.conta.resourece

import br.com.matheusCalaca.conta.model.Category
import br.com.matheusCalaca.conta.model.DTO.CategoryDto
import br.com.matheusCalaca.conta.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping(
    "category",
    consumes = [MediaType.APPLICATION_JSON_VALUE, MediaType.ALL_VALUE],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class CategoryResource {

    @Autowired
    lateinit var categoryService: CategoryService

    @PostMapping
    fun createCategory(@RequestBody category: Category): ResponseEntity<Category> {
        categoryService.save(category)
        return ResponseEntity.status(HttpStatus.CREATED).body(category)
    }

    @GetMapping
    fun getCategory(@RequestParam("name") name: String): ResponseEntity<Category> {
        return ResponseEntity.ok(categoryService.findCategory(name))
    }

    @GetMapping("/all")
    fun getAllCategory(): ResponseEntity<Iterable<Category>> {
        return ResponseEntity.ok(categoryService.findAllCategory())
    }

    @PutMapping("/{id}")
    fun putCategory(@PathVariable("id") id: Long, @RequestBody dto: CategoryDto): ResponseEntity<Category> {
        return ResponseEntity.ok(categoryService.updateCategory(id, dto.name))
    }

    @DeleteMapping("/{id}")
    fun deleteCategory(@PathVariable("id") id: Long): ResponseEntity<String> {
        categoryService.deleteCategory(id)
        return ResponseEntity.ok("Deletado com sucesso!")
    }


}

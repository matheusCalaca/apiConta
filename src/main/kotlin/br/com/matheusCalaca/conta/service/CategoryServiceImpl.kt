package br.com.matheusCalaca.conta.service

import br.com.matheusCalaca.conta.model.Category
import br.com.matheusCalaca.conta.repository.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class CategoryServiceImpl : CategoryService{

    @Autowired
    lateinit var repository: CategoryRepository

    @Transactional
    override fun save(category: Category): Category {
        return repository.save(category)
    }

    override fun findCategory(name: String): Category {
        return repository.findByName(name);
    }
    fun findCategoryByID(id: Long): Category {
        return repository.findById(id).get();
    }

    override fun findAllCategory(): Iterable<Category> {
        return repository.findAll();
    }

    override fun updateCatgory(id: Long, name: String): Category {
        val category = findCategoryByID(id);
        category.name =  name;
        return repository.save(category);
    }
}

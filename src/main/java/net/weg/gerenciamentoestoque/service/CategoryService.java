package net.weg.gerenciamentoestoque.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import net.weg.gerenciamentoestoque.model.entity.Category;
import net.weg.gerenciamentoestoque.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category findOneById(Integer id) {
        if (categoryRepository.existsById(id)) {
            return categoryRepository.findById(id).get();
        }
        throw new EntityNotFoundException();
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category update(Category category) {
        if (categoryRepository.existsById(
                category.getId())) {
            return categoryRepository.save(category);
        }
        throw new EntityNotFoundException();
    }

    public void delete(Integer id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        }
        throw new EntityNotFoundException();
    }
    
}

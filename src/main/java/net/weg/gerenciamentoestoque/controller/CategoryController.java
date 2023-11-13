package net.weg.gerenciamentoestoque.controller;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import net.weg.gerenciamentoestoque.model.entity.Category;
import net.weg.gerenciamentoestoque.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> save(
            @RequestBody Category category) {
        try {
            return new ResponseEntity<>(
                    categoryService.save(category), HttpStatus.OK);

        } catch (EntityExistsException e) {
            return new ResponseEntity<>(
                    HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findOneById(
            @PathVariable Integer id) {
        try {
            return new ResponseEntity<>(
                    categoryService.findOneById(id), HttpStatus.OK);

        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        return new ResponseEntity<>(
                categoryService.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Category> update(
            @RequestBody Category category) {
        try {
            return new ResponseEntity<>(
                    categoryService.update(category), HttpStatus.OK);

        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> delete(
            @RequestParam Integer id) {
        try {
            return new ResponseEntity<>(
                    HttpStatus.OK);

        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(
                    e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
}

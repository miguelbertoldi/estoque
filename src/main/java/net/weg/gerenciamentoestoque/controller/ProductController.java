package net.weg.gerenciamentoestoque.controller;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import net.weg.gerenciamentoestoque.model.exceptions.InvalidInformationException;
import net.weg.gerenciamentoestoque.model.entity.Product;
import net.weg.gerenciamentoestoque.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

    ProductService productService;

    @PostMapping
    public ResponseEntity<Product> save(
            @RequestBody Product product) {
        try {
            return new ResponseEntity<>(
                    productService.save(product), HttpStatus.OK);

        } catch (EntityExistsException e) {
            return new ResponseEntity<>(
                    HttpStatus.CONFLICT);

        } catch (InvalidInformationException e) {
            return new ResponseEntity<>(
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> findOneById(
            @PathVariable Integer id) {
        try {
            return new ResponseEntity<>(
                    productService.findOneById(id), HttpStatus.OK);

        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(
                    HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return new ResponseEntity<>(
                productService.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Product> update(
            @RequestBody Product product) {
        try {
            return new ResponseEntity<>(
                    productService.update(product), HttpStatus.OK);

        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> delete(
            @RequestParam Integer id) {
        try {
            productService.delete(id);
            return new ResponseEntity<>(
                    HttpStatus.OK);

        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(
                    e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}

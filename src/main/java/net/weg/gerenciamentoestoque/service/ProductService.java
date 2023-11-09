package net.weg.gerenciamentoestoque.service;

import lombok.AllArgsConstructor;
import net.weg.gerenciamentoestoque.exceptions.ProductAlreadyExistsException;
import net.weg.gerenciamentoestoque.exceptions.ProductNotFoundException;
import net.weg.gerenciamentoestoque.model.entity.Product;
import net.weg.gerenciamentoestoque.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    ProductRepository productRepository;

    public Product save(Product product) {
        if (!productRepository.existsByNameAndDescriptionAndManufacturer(
                product.getName(),
                product.getDescription(),
                product.getManufacturer())) {
            return productRepository.save(product);
        }
        throw new ProductAlreadyExistsException();
    }

    public Product findOneById(Integer id) {
        if (productRepository.existsById(id)) {
            return productRepository.findById(id).get();
        }
        throw new ProductNotFoundException();
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product update(Product product) {
        if (productRepository.existsById(
                product.getId())) {
            return productRepository.save(product);
        }
        throw new ProductNotFoundException();
    }

    public void delete(Integer id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        }
        throw new ProductNotFoundException();
    }


}

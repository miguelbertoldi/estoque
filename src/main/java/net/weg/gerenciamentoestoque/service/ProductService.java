package net.weg.gerenciamentoestoque.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import net.weg.gerenciamentoestoque.model.entity.Manufacturer;
import net.weg.gerenciamentoestoque.model.entity.Product;
import net.weg.gerenciamentoestoque.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public Product save(Product product) {
        if (!productRepository.existsByNameAndDescriptionAndManufacturer(
                product.getName(),
                product.getDescription(),
                product.getManufacturer())) {
            return productRepository.save(product);
        }
        throw new EntityExistsException();
    }

    public Product findOneById(Integer id) {
        if (productRepository.existsById(id)) {
            return productRepository.findById(id).get();
        }
        throw new EntityNotFoundException();
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product update(Product product) {
        if (productRepository.existsById(
                product.getId())) {
            return productRepository.save(product);
        }
        throw new EntityNotFoundException();
    }

    public void delete(Integer id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        }
        throw new EntityNotFoundException();
    }


}

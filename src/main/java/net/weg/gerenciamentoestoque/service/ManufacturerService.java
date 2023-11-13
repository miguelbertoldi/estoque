package net.weg.gerenciamentoestoque.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import net.weg.gerenciamentoestoque.model.entity.Manufacturer;
import net.weg.gerenciamentoestoque.repository.ManufacturerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ManufacturerService {

    private ManufacturerRepository manufacturerRepository;

    public Manufacturer save(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    public Manufacturer findOneById(Integer id) {
        if (manufacturerRepository.existsById(id)) {
            return manufacturerRepository.findById(id).get();
        }
        throw new EntityNotFoundException();
    }

    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }

    public Manufacturer update(Manufacturer manufacturer) {
        if (manufacturerRepository.existsById(
                manufacturer.getId())) {
            return manufacturerRepository.save(manufacturer);
        }
        throw new EntityNotFoundException();
    }

    public void delete(Integer id) {
        if (manufacturerRepository.existsById(id)) {
            manufacturerRepository.deleteById(id);
        }
        throw new EntityNotFoundException();
    }

}

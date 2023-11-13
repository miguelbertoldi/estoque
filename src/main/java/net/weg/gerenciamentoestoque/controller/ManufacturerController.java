package net.weg.gerenciamentoestoque.controller;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import net.weg.gerenciamentoestoque.model.entity.Manufacturer;
import net.weg.gerenciamentoestoque.service.ManufacturerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/manufacturer")
public class ManufacturerController {

    private ManufacturerService manufacturerService;

    @PostMapping
    public ResponseEntity<Manufacturer> save(
            @RequestBody Manufacturer manufacturer) {
        try {
            return new ResponseEntity<>(
                    manufacturerService.save(manufacturer), HttpStatus.OK);

        } catch (EntityExistsException e) {
            return new ResponseEntity<>(
                    HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manufacturer> findOneById(
            @PathVariable Integer id) {
        try {
            return new ResponseEntity<>(
                    manufacturerService.findOneById(id), HttpStatus.OK);

        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(
                     HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Manufacturer>> findAll() {
        return new ResponseEntity<>(
                manufacturerService.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Manufacturer> update(
            @RequestBody Manufacturer manufacturer) {
        try {
            return new ResponseEntity<>(
                    manufacturerService.update(manufacturer), HttpStatus.OK);

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

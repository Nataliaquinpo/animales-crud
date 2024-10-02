package com.example.animales_crud.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.animales_crud.model.Animal;
import com.example.animales_crud.repository.AnimalRepository;

@RestController
@RequestMapping("/animales")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    @PostMapping
    public Animal crearAnimal(@RequestBody Animal animal) {
        return animalRepository.save(animal);
    }

    @GetMapping
    public List<Animal> listarAnimales() {
    Iterable<Animal> animales = animalRepository.findAll();
    
    return StreamSupport.stream(animales.spliterator(), false)
                        .collect(Collectors.toList());
}
    @GetMapping("/{id}")
    public ResponseEntity<Animal> obtenerAnimalPorId(@PathVariable Long id) {
        Optional<Animal> animalOpt = animalRepository.findById(id);
        if (animalOpt.isPresent()) {
            return ResponseEntity.ok(animalOpt.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> actualizarAnimal(@PathVariable Long id, @RequestBody Animal detallesAnimal) {
        Optional<Animal> animalOpt = animalRepository.findById(id);
        if (animalOpt.isPresent()) {
            Animal animalExistente = animalOpt.get();
        
            animalExistente.setNombre(detallesAnimal.getNombre());
            animalExistente.setEspecie(detallesAnimal.getEspecie());
            animalExistente.setEdad(detallesAnimal.getEdad());
            animalExistente.setPeso(detallesAnimal.getPeso());
            animalExistente.setEstado(detallesAnimal.getEstado());
            animalExistente.setFechaIngreso(detallesAnimal.getFechaIngreso());

            Animal animalActualizado = animalRepository.save(animalExistente);
            return ResponseEntity.ok(animalActualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAnimal(@PathVariable Long id) {
        Optional<Animal> animalOpt = animalRepository.findById(id);
        if (animalOpt.isPresent()) {
            animalRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
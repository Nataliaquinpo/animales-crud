package com.example.animales_crud.repository;

import com.example.animales_crud.model.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
}

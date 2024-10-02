package com.example.animales_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.animales_crud.model.Animal;
import com.example.animales_crud.repository.AnimalRepository;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }
}
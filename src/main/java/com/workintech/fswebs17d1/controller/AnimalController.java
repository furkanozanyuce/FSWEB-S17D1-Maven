package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    private Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping
    public List<Animal> getAllAnimals() {
        return new ArrayList<>(animals.values());
    }

    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable Integer id) {
        return animals.get(id);
    }

    @PostMapping
    public Animal createAnimal(@RequestBody Animal newAnimal) {
        animals.put(newAnimal.getId(), newAnimal);
        return newAnimal;
    }

    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable Integer id, @RequestBody Animal updatedAnimal) {
        if (animals.containsKey(id)) {
            updatedAnimal.setId(id);
            animals.put(id, updatedAnimal);
            return updatedAnimal;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteAnimal(@PathVariable Integer id) {
        if (animals.containsKey(id)) {
            animals.remove(id);
            return "Animal id: " + id + " silindi.";
        }
        return "Animal id: " + id + " bulunamadı.";
    }
}

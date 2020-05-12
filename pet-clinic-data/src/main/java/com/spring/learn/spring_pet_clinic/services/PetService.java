package com.spring.learn.spring_pet_clinic.services;

import com.spring.learn.spring_pet_clinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}

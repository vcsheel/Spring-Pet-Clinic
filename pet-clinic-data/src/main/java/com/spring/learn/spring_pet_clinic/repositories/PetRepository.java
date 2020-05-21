package com.spring.learn.spring_pet_clinic.repositories;

import com.spring.learn.spring_pet_clinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}

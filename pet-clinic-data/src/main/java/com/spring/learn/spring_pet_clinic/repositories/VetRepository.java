package com.spring.learn.spring_pet_clinic.repositories;

import com.spring.learn.spring_pet_clinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}

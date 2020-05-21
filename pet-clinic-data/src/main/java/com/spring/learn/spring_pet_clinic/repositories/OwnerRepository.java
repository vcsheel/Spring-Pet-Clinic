package com.spring.learn.spring_pet_clinic.repositories;

import com.spring.learn.spring_pet_clinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}

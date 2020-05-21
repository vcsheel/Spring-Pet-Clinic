package com.spring.learn.spring_pet_clinic.repositories;

import com.spring.learn.spring_pet_clinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}

package com.spring.learn.spring_pet_clinic.repositories;

import com.spring.learn.spring_pet_clinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}

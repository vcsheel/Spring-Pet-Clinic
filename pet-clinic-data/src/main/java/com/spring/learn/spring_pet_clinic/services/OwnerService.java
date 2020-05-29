package com.spring.learn.spring_pet_clinic.services;

import com.spring.learn.spring_pet_clinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

}

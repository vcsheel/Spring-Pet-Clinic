package com.spring.learn.spring_pet_clinic.services;

import com.spring.learn.spring_pet_clinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}

package com.spring.learn.spring_pet_clinic.services;

import java.util.Set;

public interface CrudService<T, ID> {

    T findById(ID id);

    T save(T object);

    Set<T> findAll();

    void delete(T obj);

    void deleteById(ID id);
}

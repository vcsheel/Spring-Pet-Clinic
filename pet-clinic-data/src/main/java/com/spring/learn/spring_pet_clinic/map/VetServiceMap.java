package com.spring.learn.spring_pet_clinic.map;

import com.spring.learn.spring_pet_clinic.model.Vet;
import com.spring.learn.spring_pet_clinic.services.CrudService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long>  implements CrudService<Vet, Long> {

    @Override
    public Vet findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet obj) {
        super.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
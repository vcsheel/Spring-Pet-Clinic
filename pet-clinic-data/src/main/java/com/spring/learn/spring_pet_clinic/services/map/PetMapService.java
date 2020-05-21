package com.spring.learn.spring_pet_clinic.services.map;

import com.spring.learn.spring_pet_clinic.model.Pet;
import com.spring.learn.spring_pet_clinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Pet findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Pet obj) {
        super.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}

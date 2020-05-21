package com.spring.learn.spring_pet_clinic.services.map;

import com.spring.learn.spring_pet_clinic.model.PetType;
import com.spring.learn.spring_pet_clinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public PetType findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(PetType obj) {
        super.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}

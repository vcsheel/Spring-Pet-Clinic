package com.spring.learn.spring_pet_clinic.services.map;

import com.spring.learn.spring_pet_clinic.model.Speciality;
import com.spring.learn.spring_pet_clinic.model.Vet;
import com.spring.learn.spring_pet_clinic.services.SpecialityService;
import com.spring.learn.spring_pet_clinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long>  implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }


    @Override
    public Vet findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Vet save(Vet object) {

        if(object.getSpecialities().size() > 0) {

            object.getSpecialities().forEach( speciality -> {
                if(speciality.getId() == null) {
                    Speciality savedSp = specialityService.save(speciality);
                    speciality.setId(savedSp.getId());
                }
            });
        }

        return super.save(object);
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

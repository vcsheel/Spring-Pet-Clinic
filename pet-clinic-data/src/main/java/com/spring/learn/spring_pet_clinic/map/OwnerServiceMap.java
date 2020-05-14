package com.spring.learn.spring_pet_clinic.map;

import com.spring.learn.spring_pet_clinic.model.Owner;
import com.spring.learn.spring_pet_clinic.services.OwnerService;
import com.spring.learn.spring_pet_clinic.services.PetService;
import com.spring.learn.spring_pet_clinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        if(object != null) {

            //save pet and petType to database if they are not saved into database
            if(object.getPets() != null) {
                object.getPets().forEach(pet -> {

                    if(pet.getPetType() != null) {
                        if(pet.getPetType().getId() == null) {
                            petTypeService.save(pet.getPetType());
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }

                    if(pet.getId() == null) {
                        petService.save(pet);
                        System.out.println("Saved pet into db: "+pet.getName());
                    }
                });
            }

            return super.save(object);

        } else {
            return null;
        }
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner obj) {
        super.delete(obj);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}

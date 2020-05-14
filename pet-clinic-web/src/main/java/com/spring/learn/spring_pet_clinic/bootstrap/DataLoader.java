package com.spring.learn.spring_pet_clinic.bootstrap;

import com.spring.learn.spring_pet_clinic.model.Owner;
import com.spring.learn.spring_pet_clinic.model.PetType;
import com.spring.learn.spring_pet_clinic.model.Vet;
import com.spring.learn.spring_pet_clinic.services.OwnerService;
import com.spring.learn.spring_pet_clinic.services.PetTypeService;
import com.spring.learn.spring_pet_clinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("============================================");
        System.out.println("Loading data...");

        //adding owner data
        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Snow");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Danny");
        owner2.setLastName("Targereon");

        ownerService.save(owner2);

        System.out.println("Owners' data loaded");

        //adding vet data
        Vet vet1 = new Vet();
        vet1.setFirstName("Robert");
        vet1.setLastName("Baratheon");

        vetService.save(vet1);

        Vet vet2= new Vet();
        vet2.setFirstName("Ned");
        vet2.setLastName("Stark");

        vetService.save(vet2);

        System.out.println("Vets data loaded");

        //adding pet Type data
        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);

        System.out.println("PetType data loaded");

        System.out.println("Data loading finished..");

        System.out.println("============================================");
    }
}

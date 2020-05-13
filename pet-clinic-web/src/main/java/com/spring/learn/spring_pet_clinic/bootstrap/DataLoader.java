package com.spring.learn.spring_pet_clinic.bootstrap;

import com.spring.learn.spring_pet_clinic.model.Owner;
import com.spring.learn.spring_pet_clinic.model.Vet;
import com.spring.learn.spring_pet_clinic.services.OwnerService;
import com.spring.learn.spring_pet_clinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("============================================");
        System.out.println("Loading data...");

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("John");
        owner1.setLastName("Snow");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Danny");
        owner2.setLastName("Targereon");

        ownerService.save(owner2);

        System.out.println("Owners' data loaded");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Robert");
        vet1.setLastName("Baratheon");

        vetService.save(vet1);

        Vet vet2= new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Ned");
        vet2.setLastName("Stark");

        vetService.save(vet2);

        System.out.println("Vets data loaded");

        System.out.println("Data loading finished..");

        System.out.println("============================================");
    }
}

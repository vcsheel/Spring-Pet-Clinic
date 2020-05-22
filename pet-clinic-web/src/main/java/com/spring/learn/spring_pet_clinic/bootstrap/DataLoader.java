package com.spring.learn.spring_pet_clinic.bootstrap;

import com.spring.learn.spring_pet_clinic.model.*;
import com.spring.learn.spring_pet_clinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0) {
            LoadData();
        }
    }

    private void LoadData() {
        System.out.println("============================================");
        System.out.println("Loading data...");

        //adding specialities
        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        //adding pet Type data
        PetType dragon = new PetType();
        dragon.setName("Dragon");
        PetType savedDragon = petTypeService.save(dragon);

        PetType wolf = new PetType();
        wolf.setName("Direwolf");
        PetType direwolf = petTypeService.save(wolf);

        System.out.println("PetType data loaded");

        //adding owner data
        Owner owner1 = new Owner();
        owner1.setFirstName("Jon");
        owner1.setLastName("Snow");
        owner1.setAddress("Winterfell");
        owner1.setCity("The Wall");
        owner1.setTelephone("1234567890");

        Pet ghost = new Pet();
        ghost.setName("Ghost");
        ghost.setBirthDate(LocalDate.now());
        ghost.setPetType(direwolf);
        ghost.setOwner(owner1);

        owner1.getPets().add(ghost);

        ownerService.save(owner1);
        petService.save(ghost);

        System.out.println("Owner1 done");

        Owner owner2 = new Owner();
        owner2.setFirstName("Daenerys");
        owner2.setLastName("Targaryen");
        owner2.setAddress("Westeros");
        owner2.setCity("Dragonstone");
        owner2.setTelephone("9876543210");
        Pet rhaegal = new Pet();
        rhaegal.setOwner(owner2);
        rhaegal.setName("Rhaegal");
        rhaegal.setPetType(savedDragon);
        rhaegal.setBirthDate(LocalDate.now());
        owner2.getPets().add(rhaegal);

        ownerService.save(owner2);

        System.out.println("Owners' data loaded");

        //adding vet data
        Vet vet1 = new Vet();
        vet1.setFirstName("Robert");
        vet1.setLastName("Baratheon");
        vet1.getSpecialities().add(savedDentistry);
        vet1.getSpecialities().add(savedSurgery);
        vetService.save(vet1);

        Vet vet2= new Vet();
        vet2.setFirstName("Ned");
        vet2.setLastName("Stark");
        vet2.getSpecialities().add(savedRadiology);
        vetService.save(vet2);

        System.out.println("Vets data loaded");

        //add visit for dragon
        Visit dragonVisit = new Visit();
        dragonVisit.setPet(rhaegal);
        dragonVisit.setDate(LocalDate.now());
        dragonVisit.setDescription("Fire testing");

        visitService.save(dragonVisit);

        System.out.println("Data loading finished..");

        System.out.println("============================================");
    }
}

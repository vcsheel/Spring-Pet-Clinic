package com.spring.learn.spring_pet_clinic.controllers;

import com.spring.learn.spring_pet_clinic.model.Owner;
import com.spring.learn.spring_pet_clinic.model.Pet;
import com.spring.learn.spring_pet_clinic.model.PetType;
import com.spring.learn.spring_pet_clinic.services.OwnerService;
import com.spring.learn.spring_pet_clinic.services.PetService;
import com.spring.learn.spring_pet_clinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

    private final String CREATE_OR_UPDATE_PET_FORM_VIEW = "pets/createOrUpdatePetForm";

    private final PetTypeService petTypeService;
    private final PetService petService;
    private final OwnerService ownerService;

    public PetController(PetTypeService petTypeService, PetService petService, OwnerService ownerService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.ownerService = ownerService;
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable Long ownerId) {
        return ownerService.findById(ownerId);
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return petTypeService.findAll();
    }

    @InitBinder("owner")
    public void initOwnerBinder (WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }


    @GetMapping("/pets/new")
    public String initCreatePetForm(Owner owner, Model model) {
        Pet pet = new Pet();
        pet.setOwner(owner);
        owner.getPets().add(pet);
        model.addAttribute("pet", pet);
        return CREATE_OR_UPDATE_PET_FORM_VIEW;
    }

    @PostMapping("/pets/new")
    public String processCreatePetForm(Owner owner, @Valid Pet pet, BindingResult result, Model model) {

        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null) {
            result.rejectValue("name", "duplicate", "already exists");
        }

        pet.setOwner(owner);
        owner.getPets().add(pet);

        if(result.hasErrors()) {
            model.addAttribute("pet", pet);
            return CREATE_OR_UPDATE_PET_FORM_VIEW;
        } else {
            petService.save(pet);
            return "redirect:/owners/" + owner.getId();
        }

    }
}

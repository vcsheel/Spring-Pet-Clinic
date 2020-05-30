package com.spring.learn.spring_pet_clinic.controllers;

import com.spring.learn.spring_pet_clinic.model.Pet;
import com.spring.learn.spring_pet_clinic.model.Visit;
import com.spring.learn.spring_pet_clinic.services.PetService;
import com.spring.learn.spring_pet_clinic.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/owners/*/pets/{petId}")
public class VisitController {

    private final String CREATE_OR_UPDATE_VISIT_VIEW = "/pets/createOrUpdateVisitForm";

    private final PetService petService;
    private final VisitService visitService;

    public VisitController(PetService petService, VisitService visitService) {
        this.petService = petService;
        this.visitService = visitService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    //gets called before any request mapping
    @ModelAttribute("visit")
    public Visit initPetAndVisits (@PathVariable Long petId, Model model) {

        Pet pet = petService.findById(petId);
        Visit visit = new Visit();
        pet.getVisits().add(visit);
        visit.setPet(pet);
        model.addAttribute("pet", pet);
        return visit;
    }

    @GetMapping("/visits/new")
    public String initNewVisitForm (@PathVariable Long petId, Model model) {
        return CREATE_OR_UPDATE_VISIT_VIEW;
    }

    @PostMapping("/visits/new")
    public String processNewVisitForm (@Valid Visit visit, Pet pet, BindingResult result, Model model) {

        if(result.hasErrors()) {
            return CREATE_OR_UPDATE_VISIT_VIEW;
        } else {
            visitService.save(visit);
            return "redirect:/owners/" + pet.getOwner().getId();
        }

    }
}

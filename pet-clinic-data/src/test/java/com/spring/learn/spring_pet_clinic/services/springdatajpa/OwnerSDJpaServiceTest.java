package com.spring.learn.spring_pet_clinic.services.springdatajpa;

import com.spring.learn.spring_pet_clinic.model.Owner;
import com.spring.learn.spring_pet_clinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;
    Owner savedOwner;
    Long ownerId = 1L;
    String lastName = "Snow";

    @BeforeEach
    void setUp() {
        savedOwner = Owner.builder().id(ownerId).lastName(lastName).build();
    }

    @Test
    void findByLastName() {
        //use when->thenReturn orElse it returns null
        when(ownerRepository.findByLastName(any())).thenReturn(savedOwner);
        Owner owner = ownerSDJpaService.findByLastName(lastName);
        assertEquals(ownerId, owner.getId());
        //optional to check number of times a method was called, default times(1)
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(savedOwner));
        Owner owner = ownerSDJpaService.findById(ownerId);
        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void save() {
        Owner owner = Owner.builder().id(2L).build();
        when(ownerRepository.save(any())).thenReturn(owner);

        Owner returnOwner = ownerSDJpaService.save(owner);
        assertNotNull(returnOwner);
        assertEquals(2L, returnOwner.getId());
    }

    @Test
    void findAll() {
        when(ownerRepository.findAll()).thenReturn(Collections.singleton(savedOwner));
        Set<Owner> owners = ownerSDJpaService.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(savedOwner);
        verify(ownerRepository,times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(ownerId);
        verify(ownerRepository).deleteById(anyLong());
    }
}
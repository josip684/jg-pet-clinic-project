package com.example.jgpetclinicproject.services.springdatajpa;

import com.example.jgpetclinicproject.model.Owner;
import com.example.jgpetclinicproject.repositories.OwnerRepository;
import com.example.jgpetclinicproject.repositories.PetRepository;
import com.example.jgpetclinicproject.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    public static final String LAST_NAME = "Smith";


    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner returnOwner;
    Owner o1 = new Owner();

    @BeforeEach
    void setUp() {

        o1.setId(5L);
        o1.setLastName("Doe");

        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner smith = service.findByLastName(LAST_NAME);

        //assertEquals(LAST_NAME, smith.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returOwnersSet = new HashSet<>();
        returOwnersSet.add(Owner.builder().id(1L).build());
        returOwnersSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returOwnersSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());

    }

    @Test
    void findById() {

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(o1));

        Owner owner = service.findById(1L);

        System.out.println(owner);
        System.out.println(owner.getId());
        System.out.println(owner.getLastName());

        assertNotNull(owner);

        assertEquals(5, owner.getId());


    }

    @Test
    void save() {
        /*//My test
        Set<Owner> setOwners = new HashSet<>();
        when(ownerRepository.save(any())).thenReturn(o1);
        setOwners.add(service.save(o1));
        assertEquals(1, setOwners.size());*/

        Owner ownerToSave = Owner.builder().id(1L).build();
        when(ownerRepository.save(any())).thenReturn(returnOwner);
        Owner savedOwner = service.save(ownerToSave);
        assertNotNull(savedOwner);
    }

    @Test
    void delete() {
        service.delete(returnOwner);
        verify(ownerRepository, times(1)).delete(any());

    }

    @Test
    void deleteById() {
        service.deleteById(o1.getId());
        verify(ownerRepository).deleteById(anyLong());

    }
}
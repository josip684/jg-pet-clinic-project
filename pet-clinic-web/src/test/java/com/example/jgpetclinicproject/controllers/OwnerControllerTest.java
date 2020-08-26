package com.example.jgpetclinicproject.controllers;

import com.example.jgpetclinicproject.model.Owner;
import com.example.jgpetclinicproject.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController controller;

    Set<Owner> owners;

    MockMvc mockMvc;


    @BeforeEach
    void setUp() {


        owners = new HashSet<>();
        Owner o1 = new Owner();
        o1.setId(1L);
        Owner o2 = new Owner();
        o2.setId(2L);
        //owners.add(Owner.builder().id(1L).build());
        //owners.add(Owner.builder().id(2L).build());
        owners.add(o1);
        owners.add(o2);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();


    }

    @Test
    void listOwners() {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
       when(ownerService.findAll()).thenReturn(owners);
       //mockMvc.perform(get("/owners")).andExpect(status().is(200));

    }

    @Test
    void findOwners() {
    }
}
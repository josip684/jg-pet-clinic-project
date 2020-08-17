package com.example.jgpetclinicproject.services;


import com.example.jgpetclinicproject.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}

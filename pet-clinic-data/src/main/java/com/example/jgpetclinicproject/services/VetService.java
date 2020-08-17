package com.example.jgpetclinicproject.services;

import com.example.jgpetclinicproject.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();

}

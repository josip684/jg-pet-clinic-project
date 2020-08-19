package com.example.jgpetclinicproject.repositories;

import com.example.jgpetclinicproject.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}

package com.example.jgpetclinicproject.repositories;

import com.example.jgpetclinicproject.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
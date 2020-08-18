package com.example.jgpetclinicproject.services;

import com.example.jgpetclinicproject.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}

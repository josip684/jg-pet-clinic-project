package com.example.jgpetclinicproject.bootstrap;

import com.example.jgpetclinicproject.model.Owner;
import com.example.jgpetclinicproject.model.Vet;
import com.example.jgpetclinicproject.services.OwnerService;
import com.example.jgpetclinicproject.services.VetService;
import com.example.jgpetclinicproject.services.map.OwnerServiceMap;
import com.example.jgpetclinicproject.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("****************************RUNNER POKRENUT***********************************");

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstname("Michael");
        owner1.setLastname("Weston");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstname("Fiona");
        owner2.setLastname("Glennann");
        ownerService.save(owner2);

        System.out.println("Loaded Owners ...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstname("Sam");
        vet1.setLastname("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstname("Bob");
        vet2.setLastname("Doe");
        vetService.save(vet2);

        System.out.println("Loaded Vets ...");

    }
}

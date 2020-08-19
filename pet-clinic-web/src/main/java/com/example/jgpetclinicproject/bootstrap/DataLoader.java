package com.example.jgpetclinicproject.bootstrap;

import com.example.jgpetclinicproject.model.Owner;
import com.example.jgpetclinicproject.model.Pet;
import com.example.jgpetclinicproject.model.PetType;
import com.example.jgpetclinicproject.model.Vet;
import com.example.jgpetclinicproject.services.OwnerService;
import com.example.jgpetclinicproject.services.PetTypeService;
import com.example.jgpetclinicproject.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("****************************RUNNER POKRENUT***********************************");

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstname("Michael");
        owner1.setLastname("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("New York");
        owner1.setTelephone("121233232");
        ownerService.save(owner1);

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        Owner owner2 = new Owner();
        owner2.setFirstname("Fiona");
        owner2.setLastname("Glennann");
        owner2.setAddress("222 Miami Beach");
        owner2.setCity("Miami");
        owner2.setTelephone("333444232");
        ownerService.save(owner2);

        Pet fionasCat = new Pet();
        fionasCat.setPetType(savedCatPetType);
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setName("Catica");
        owner2.getPets().add(fionasCat);

        System.out.println("Loaded Owners ...");

        Vet vet1 = new Vet();
        vet1.setFirstname("Sam");
        vet1.setLastname("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstname("Bob");
        vet2.setLastname("Doe");
        vetService.save(vet2);

        System.out.println("Loaded Vets ...");

    }
}

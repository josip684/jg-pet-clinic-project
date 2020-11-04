package com.example.jgpetclinicproject;

import com.example.jgpetclinicproject.services.map.OwnerMapService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories(basePackageClasses = {OwnerSDJpaService.class})
@EnableJpaRepositories(basePackageClasses = {OwnerMapService.class})
@SpringBootApplication
public class JgPetClinicProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(JgPetClinicProjectApplication.class, args);
        System.out.println("-------------##################################-------------");
        System.out.println("-------------___________________________________------------");
    }

}

package com.petz.demo.service;

import com.petz.demo.entity.Pet;
import com.petz.demo.repository.PetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    PetRepository repository;

    public Pet obter(String nome){
        Pet pet = new Pet();
        pet.setNome(nome);
        Example<Pet> examplePet = Example.of(pet);
        logger.info("obter -> " + nome);

        return repository.findOne(examplePet).orElse(null);

    }

}

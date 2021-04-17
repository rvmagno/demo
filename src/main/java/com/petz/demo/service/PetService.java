package com.petz.demo.service;

import com.petz.demo.entity.Cliente;
import com.petz.demo.entity.Pet;
import com.petz.demo.repository.PetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    PetRepository repository;


    public List<Pet> listar(){
        logger.info("listar -> todos");
        return repository.findAll();
    }


    public Pet obter(String nome){
        Example<Pet> examplePet = Example.of(Pet.builder().nome(nome).build());
        logger.info("obter -> " + nome);

        return repository.findOne(examplePet).orElse(null);
    }

    public Pet salvar(Pet pet){
        Optional<Pet> optPet = repository.findOne(Example.of(Pet.builder().nome(pet.getNome()).build()));
        if(optPet.isPresent()){
            logger.info(String.format("Pet [%s] ja existente", pet.getNome()));
            return optPet.get();
        }

        return repository.save(pet);
    }

    public Pet atualizar(Pet pet, Long idPet ){
        Optional<Pet> optPet = repository.findById(idPet);
        if(optPet.isEmpty()){
            logger.info(String.format("Pet [%s] n encontrado. Adicionando.", pet.toString()));
            repository.save(pet);
            return optPet.get();
        }

        Pet petFounded = optPet.get();
        petFounded.setNome(pet.getNome());
        pet.setRaca(pet.getRaca());
        return repository.saveAndFlush(pet);
    }


    public void remover(Long idPet){
        Optional<Pet> optPet = repository.findById(idPet);
        if(optPet.isEmpty()){
            logger.info(String.format("Pet [%s]  n encontrado", idPet));
            return;
        }

        repository.delete(optPet.get());
    }

}

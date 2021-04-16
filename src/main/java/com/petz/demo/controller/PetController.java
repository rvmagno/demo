package com.petz.demo.controller;

import com.petz.demo.entity.Pet;
import com.petz.demo.service.PetService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping(value = "v1/pet")
public class PetController {

    private final String ofPattern = "dd/MM/yyyy HH:mm:ss";

    @Autowired
    PetService service;

    @GetMapping (value = "/")
    @ApiOperation(
            value = "Operacao criada para obter um cliente atraves do nome", produces = "application/json", response = Pet.class)
    public ResponseEntity<Pet> obter(String pet){
        StringBuilder builder = new StringBuilder();
        builder.append(pet);
        builder.append(" GET ");
        builder.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern(ofPattern)));

        return ResponseEntity.status(HttpStatus.OK).body(service.obter(pet));
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> cadastrar(String pet){
        StringBuilder builder = new StringBuilder();
        builder.append(pet);
        builder.append(" POST ");
        builder.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern(ofPattern)));

        return ResponseEntity.status(HttpStatus.OK).body(builder.toString());
    }

    @PutMapping(value = "/")
    public ResponseEntity<String> atualizar(String pet){
        StringBuilder builder = new StringBuilder();

        builder.append(pet);
        builder.append(" PUT ");
        builder.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern(ofPattern)));

        return ResponseEntity.status(HttpStatus.OK).body(builder.toString());
    }
    @DeleteMapping(value = "/")
    public ResponseEntity<String> remover(String pet){
        StringBuilder builder = new StringBuilder();

        builder.append(pet);
        builder.append(" DELETE ");
        builder.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern(ofPattern)));

        return ResponseEntity.status(HttpStatus.OK).body(builder.toString());
    }



}

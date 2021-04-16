package com.petz.demo.controller;

import com.petz.demo.entity.Cliente;
import com.petz.demo.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping(value = "v1/cliente")
public class ClienteController {

    private final String ofPattern = "dd/MM/yyyy HH:mm:ss";

    @Autowired
    private ClienteService service;

    @GetMapping (value = "/")
    @ApiOperation(value = "Operacao criada para obter um cliente pelo nome", produces = "application/json", response = Cliente.class)
    public ResponseEntity<Cliente> obter(String nome){
        StringBuilder builder = new StringBuilder();
        builder.append(nome);
        builder.append(" GET ");
        builder.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern(ofPattern)));

        return ResponseEntity.status(HttpStatus.OK).body(service.obter(nome));
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> cadastrar(String pet){
        StringBuilder builder = new StringBuilder();
        builder.append(pet);
        builder.append(" POST ");
        builder.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern(ofPattern)));
//        TODO implementar operacoes

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

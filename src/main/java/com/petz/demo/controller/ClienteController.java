package com.petz.demo.controller;

import com.petz.demo.entity.Cliente;
import com.petz.demo.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping(value = "v1/cliente")
public class ClienteController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final String ofPattern = "dd/MM/yyyy HH:mm:ss";

    @Autowired
    private ClienteService service;

    @GetMapping (value = "/listar")
    @ApiOperation(
            value = "Operacao criada para obter um cliente pelo nome",
            produces = "application/json",
            response = Cliente.class,
            responseContainer = "List"
    )
    public ResponseEntity<List<Cliente>> listar(){
        logger.info(" GET -> " + LocalDateTime.now().format(DateTimeFormatter.ofPattern(ofPattern)));
        return ResponseEntity.status(HttpStatus.OK).body(service.listar());
    }

    @GetMapping (value = "/")
    @ApiOperation(value = "Operacao criada para obter um cliente pelo nome", produces = "application/json", response = Cliente.class)
    public ResponseEntity<Cliente> obter(String nome){
        logger.info(" GET -> " + LocalDateTime.now().format(DateTimeFormatter.ofPattern(ofPattern)));
        return ResponseEntity.status(HttpStatus.OK).body(service.obter(nome));
    }

    @PostMapping(value = "/")
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente ){
        logger.info(" POST -> " + LocalDateTime.now().format(DateTimeFormatter.ofPattern(ofPattern)));
        return ResponseEntity.status(HttpStatus.OK).body(service.salvar(cliente));
    }

    @PutMapping(value = "/{idCliente}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long idCliente,  @RequestBody Cliente cliente){
        logger.info(" PUT -> "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern(ofPattern)));
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizar(cliente, idCliente));
    }

    @DeleteMapping(value = "/{idCliente}")
    public ResponseEntity<String> remover(@PathVariable Long idCliente){
        logger.info(" DELETE -> " + LocalDateTime.now().format(DateTimeFormatter.ofPattern(ofPattern)));
        service.remover(idCliente);

        return ResponseEntity.status(HttpStatus.OK).body("");
    }

}

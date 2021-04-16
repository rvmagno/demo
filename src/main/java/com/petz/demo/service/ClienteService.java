package com.petz.demo.service;

import com.petz.demo.entity.Cliente;
import com.petz.demo.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ClienteRepository repository;

    public Cliente obter(String nome){
        logger.info("obter -> " + nome);
        return repository.findByName(nome);
    }
}

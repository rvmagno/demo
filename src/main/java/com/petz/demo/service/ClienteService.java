package com.petz.demo.service;

import com.petz.demo.entity.Cliente;
import com.petz.demo.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ClienteRepository repository;

    public List<Cliente> listar(){
        logger.info("listar -> todos");
        return repository.findAll();
    }

    public Cliente obter(String nome){
        logger.info("obter -> " + nome);
        Optional<Cliente> byName = repository.findByName(nome);
        return byName.orElse(null);

    }

    public Cliente salvar(Cliente cliente){
        Optional<Cliente> optCliente = repository.findByName(cliente.getNome());
        if(optCliente.isPresent()){
            logger.info(String.format("Cliente [%s] ja existente", cliente.getNome()));
            return optCliente.get();
        }

        return repository.save(cliente);
    }

    public Cliente atualizar(Cliente cliente, Long idCliente ){
        Optional<Cliente> optCliente = repository.findById(idCliente);
        if(optCliente.isEmpty()){
            logger.info(String.format("Cliente [%s] n encontrado. Adicionando.", cliente.getNome()));
            repository.save(cliente);
            return optCliente.get();
        }

        Cliente clienteEncontrado = optCliente.get();
        clienteEncontrado.setNome(cliente.getNome());
        clienteEncontrado.setCelular(cliente.getCelular());
        clienteEncontrado.setNascimento(cliente.getNascimento());

        return repository.saveAndFlush(clienteEncontrado);
    }
    public void remover(Long idCliente){
        Optional<Cliente> optCliente = repository.findById(idCliente);
        if(optCliente.isEmpty()){
            logger.info(String.format("Cliente [%s]  n encontrado", idCliente));
            return;
        }

        repository.delete(optCliente.get());
    }
}

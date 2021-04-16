package com.petz.demo.repository;

import com.petz.demo.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(name = "findByName",  value = "Select c from Cliente c where c.nome = ?1" )
    Cliente findByName(String nome);

}

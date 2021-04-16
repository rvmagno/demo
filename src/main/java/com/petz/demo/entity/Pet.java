package com.petz.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data  @Entity  @Table
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String raca;

}

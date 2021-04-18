package com.petz.demo.service;

import com.petz.demo.entity.Pet;
import com.petz.demo.repository.PetRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PetServiceTest {

    @InjectMocks
    PetService serviceUnderTest;

    @Mock
    PetRepository repository;

    AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        when(repository.findAll()).thenReturn(returnAllPet());
    }

    @Test
    void testListarTodos() {
        List<Pet> listar = serviceUnderTest.listar();

        assertEquals(3, listar.size());
    }

    private List<Pet> returnAllPet() {
        List<Pet> pets = new ArrayList<Pet>();
        pets.add(Pet.builder().nome("cachorro").raca("RND_1").build());
        pets.add(Pet.builder().nome("gato").raca("RND_1").build());
        pets.add(Pet.builder().nome("papagaio").raca("arara azul").build());

        return pets;
    }

    @AfterEach
    void teadDown() throws Exception {
        autoCloseable.close();
    }
}
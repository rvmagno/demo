//package com.petz.demo.controller;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.ResponseEntity;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//class PetControllerTest {
//
//    @InjectMocks
//    PetController controller;
//
//    Logger logger = LoggerFactory.getLogger(getClass());
//
//    @BeforeEach
//    void setUp() {
//        logger.info("setUp PetControllerTest");
//    }
//
//    @Test
//    void obter() {
//        ResponseEntity<Pet> pet = controller.obter("pet");
//        assertEquals(pet.getStatusCode().value(), 200);
//    }
//}
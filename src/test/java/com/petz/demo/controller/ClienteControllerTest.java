//package com.petz.demo.controller;
//
//import com.petz.demo.entity.Cliente;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.ResponseEntity;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class ClienteControllerTest {
//
//    Logger logger = LoggerFactory.getLogger(getClass());
//
//    @InjectMocks
//    ClienteController controller;
//
//    @BeforeEach
//    void setUp() {
//        logger.info("setUp ClienteControllerTest");
//    }
//
//    @Test
//    void obter() {
//        mockito
//        ResponseEntity<Cliente> cliente = controller.obter("pet");
//        assertEquals(200, cliente.getStatusCode().value());
//    }
//}
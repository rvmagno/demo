package com.petz.demo.service;

import com.petz.demo.entity.Cliente;
import com.petz.demo.repository.ClienteRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Any;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class ClienteServiceTest {

    @InjectMocks
    ClienteService serviceUnderTest;

    @Mock
    ClienteRepository repository;

    AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        when(repository.findAll()).thenReturn(returnListaCliente());
        when(repository.findByName("Cliente um")).thenReturn(Optional.of(Cliente.builder().nome("Cliente um").celular(11998766789l).nascimento(LocalDateTime.now()).build()));
        when(repository.findByName("Terceiro Cliente")).thenReturn(Optional.of(Cliente.builder().nome("Cliente um").celular(11998766789l).nascimento(LocalDateTime.now()).build()));

    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testListarTodos() {
        List<Cliente> listar = serviceUnderTest.listar();
        assertEquals(2, listar.size());
    }

    @Test
    void testObterCliente() {
        Cliente cliente_um = serviceUnderTest.obter("Cliente um");

        assertEquals(11998766789l, cliente_um.getCelular());
    }

    @Test
    void testNegativoObterCliente() {
        Cliente cliente_tres = serviceUnderTest.obter("Terceiro Cliente");
        assertNotEquals( 12934546776l, cliente_tres.getCelular());
    }

    @Test
    @Disabled
    void testAtualizar(){

    }

    @Test
    @Disabled
    void testRemover(){

    }

    private List<Cliente> returnListaCliente() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(Cliente.builder().nome("Cliente um").celular(11998766789l).nascimento(LocalDateTime.now()).build());
        clientes.add(Cliente.builder().nome("Segundo Cliente").celular(12934546776l).nascimento(LocalDateTime.now()).build());

        return clientes;
    }
}
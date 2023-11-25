package com.org.tr.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTest {

	Cliente c = new Cliente();
	DetalleCliente dc = new DetalleCliente();
	
	@BeforeEach
	void setUp() throws Exception {
		
		c.setIdCliente(1);
		c.setTelefono("939212311");
		c.setEstado(true);
		c.setRuc("2004321121");
		c.setEmail("admin@admin.com");
		dc.setApellidoPaterno("Guierrez");
		c.setDetalleCliente(dc);
		
	}

	@Test
	void gettersTest() {
		
		assertNotNull(c.getIdCliente());
		assertNotNull(c.getTelefono());
		assertNotNull(c.isEstado());
		assertNotNull(c.getRuc());
		assertNotNull(c.getEmail());
		
		assertNotNull(dc.getCliente());
		assertEquals(c.getIdCliente(), dc.getCliente().getIdCliente());
		
	}
	
	
	@Test
	void removeDetalleTest() {
		
		System.out.print(c.getDetalleCliente().getCliente().getIdCliente());
		c.removerDetalleCliente();
		assertNull(c.getDetalleCliente().getCliente());
		
	}

}

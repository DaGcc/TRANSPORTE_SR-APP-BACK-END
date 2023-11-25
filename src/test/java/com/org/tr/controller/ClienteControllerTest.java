package com.org.tr.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.org.tr.model.Cliente;
import com.org.tr.service.IClienteService;

class ClienteControllerTest {

	//* para que use a los que estan anotados con @Mock para inyectarlos en esta clase.
	@InjectMocks
	ClienteController controller;
	
	//* creando un clon del servicio => espacio en memoria 
	@Mock
	private IClienteService service;
	
	
	@BeforeEach
	public void initEach() {
		
		//Con esto haces que la configuracion de inyeccion y creacion de mocks sea segura
		MockitoAnnotations.openMocks(this);
		
	}
	
	@Test
	void testReadAllTest() {
		
		// readAll => llamada http del controller.
		//* Permite simular una peticion http
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		
		Pageable p = PageRequest.of(0, 4);
		
		// this.service.readByPage(pageable) => servicio a simular;
		// cuando encuentre cualquier servicio con el metodo`readByPage`
		// va a retornar lo siguiente con el thenReturn.
		when(this.service.readByPage(any(Pageable.class))).thenReturn(
				new PageImpl<Cliente>(new ArrayList<>()));
		
		//* hacemos la llamada al controller
		ResponseEntity<?> response = controller.readByPage(p);
		
		//* assertThat es de otra libreria, puede ser de -> `hamcrest` o `assertj` 
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
	}

	
}

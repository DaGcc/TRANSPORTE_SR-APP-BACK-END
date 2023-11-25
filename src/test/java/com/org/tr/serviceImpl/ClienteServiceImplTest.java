package com.org.tr.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.org.tr.model.Usuario;
import com.org.tr.service.IClienteService;

@SpringBootTest
class ClienteServiceImplTest {
	

    // Inyecciones de dependecia
    @Autowired
    private IClienteService clienteService;

    
    /**
     * Si funciona el filtro
     */
    @Test
    void pruebaPaginacionConFiltroTest() {
    	
    	//long inicio = System.currentTimeMillis();
    	
        assertTimeout(Duration.ofMillis(100) ,()->{
        	return this.clienteService.filtroClientes(0, 1, "777");
        }, "Problemas de rendimiento de la paginacion con filtro!");
        
        long fin = System.currentTimeMillis();
        
       // long tiempoDeEjecucion = fin - inicio;
        
       //assertEquals(100,tiempoDeEjecucion );
    }
    
    
}

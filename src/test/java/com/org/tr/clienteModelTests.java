/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr;

import com.org.tr.model.Cliente;
import com.org.tr.service.IClienteService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootTest
public class clienteModelTests {
    
    @Autowired
    private IClienteService service;
    
    private Pageable pageable;
    
    private Cliente c;
    
    /**
     * Primera ejecucion del ciclo de vida de la prueba unitario
     */
    @BeforeAll
    public static void initTest(){
        
    }
    @BeforeEach
    public void initEach() {
    	this.pageable = PageRequest.of(0, 5);
    }
    
    @Test
    public void paginacionTest(){
      
    	Page<Cliente> p = this.service.readByPage(pageable);
    	
    	assertNotNull(p.getContent());
    	
        
    }
    
}

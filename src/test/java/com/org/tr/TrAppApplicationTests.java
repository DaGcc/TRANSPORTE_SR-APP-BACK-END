package com.org.tr;

import com.org.tr.model.Usuario;
import com.org.tr.service.IClienteService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class TrAppApplicationTests {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    String pass = "123";
    
    String passEncode;
    
    @BeforeEach
    public void initTest() {
    	passEncode = passwordEncoder.encode(pass);
    	System.out.println(passEncode);
    }
    
    @Test
    void encriptarPasswordLoads() {
    										// pass o un numero en duro 
    	assertTrue(this.passwordEncoder.matches(pass, passEncode));
        
        
    }

    
}

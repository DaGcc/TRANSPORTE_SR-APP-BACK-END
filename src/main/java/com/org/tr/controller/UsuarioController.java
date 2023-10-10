package com.org.tr.controller;


import com.org.tr.model.Usuario;
import com.org.tr.service.IUsuarioService;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@RestController
@RequestMapping(value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController extends CommonController<Usuario, IUsuarioService> {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @PostMapping("/detach")
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody Usuario obj) {
        Usuario entidad = obj;
        String password = entidad.getPassword();
        entidad.setPassword(passwordEncoder.encode(password));
        //System.out.print(entidad.getPassword());
        return super.create(entidad);
    }

    @GetMapping("/encontrar-email/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(this.service.findByEmail(email));
    }


   
}

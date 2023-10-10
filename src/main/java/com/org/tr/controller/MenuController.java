package com.org.tr.controller;

import com.org.tr.model.Menu;
import com.org.tr.service.IMenuService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/menus",produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuController extends CommonController<Menu,IMenuService>{

    /**
     * 
     * busca los menus en base al email del usuario, es decir,
     * primero buscara el rol del usuario con el email, luego, 
     * se evalua cuales son los menus a retornar de ese rol encontrado.
     * 
     * @param email
     * @return 
     */
    @GetMapping(value="/usuario/{email}",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Menu>> findAllUserMenuByRolWithEmail(@PathVariable String email){
        List<Menu> listaMenu = service.listarMenuPorEmailUsuario(email);
        return new ResponseEntity(listaMenu,HttpStatus.OK);
    }

}

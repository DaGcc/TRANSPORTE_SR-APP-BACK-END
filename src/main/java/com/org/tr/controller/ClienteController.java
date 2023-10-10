/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr.controller;

import com.org.tr.excepcions.ModelNotFoundException;
import com.org.tr.model.Cliente;
import com.org.tr.service.IClienteService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController extends CommonController<Cliente, IClienteService> {

    @DeleteMapping("/detach/{id}")
    public ResponseEntity<?> deleteById(
            @RequestParam(name = "deep", defaultValue = "false") boolean deep,
            @PathVariable("id") int id) {
        //verificamos si existe en la base de datos
        Cliente clienteBD = this.service.readById(id);

        //si existe
        if (clienteBD != null) {
            
            //vemos si es una eliminacion profunda 
            if (deep == false) {
                //si no lo es, solo cambiaremos el estado a falso y de respuesta sea 204
                clienteBD.setEstado(false);
                this.service.update(clienteBD);//guardamos esa actualizacion en la bbdd
                return ResponseEntity.noContent().build();// respuesta http_204
            } else {
                //si lo es, elimminamos ese registro de la base de datos
                return super.deleteById(id);//llamamos al metodo core
            }
        } else {
            //si no existe mandamos la excepcion con estado http 404
            throw new ModelNotFoundException("Entidad de tipo: " + Cliente.class.getSimpleName() + " con id: " + id + ", no encontrado");
        }

    }

    
}
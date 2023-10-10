package com.org.tr.controller;

import com.org.tr.excepcions.ModelNotFoundException;
import com.org.tr.service.ICRUD;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CommonController<T, S extends ICRUD<T>> {

    @Autowired
    protected S service;

    //SOBREESCRIBE 
    @GetMapping("/paginado")
    public ResponseEntity<?> readByPage(Pageable pageable) {
        Page<T> page = this.service.readByPage(pageable);
//        page.getContent().stream().filter(e -> {
//           return e.getEstado();
//        }).toList();
        // Filtra la lista utilizando el método getEstado() si está presente

        return ResponseEntity.ok(page);
    }

    //Y
    @GetMapping("/{id}")
    public ResponseEntity<?> readById(@PathVariable("id") Integer id) {
        T tbd = this.service.readById(id);
        if(tbd!=null){
            return ResponseEntity.ok(tbd);
        }else{
            throw new ModelNotFoundException("Entidad de con id: " + id + ", no encontrado");
        }
    }

    //Y : EL ID ENVIADO POR LA URL DEBE COINCIDIR CON EL ID DEL JSON ENVIADO POR EL BODY
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @Valid @RequestBody T tBody) {
        T tbd = this.service.readById(id);
        if (tbd == null) {
            throw new ModelNotFoundException("Entidad con id: " + id + ", no encontrado");
        } else {
            tbd = this.service.update(tBody);
        }
        return ResponseEntity.ok(tbd);
    }

    //Y
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody T t) {
        T tbd = this.service.create(t);
        return ResponseEntity.ok(tbd);
    }

    
    
    //SOBREESCRIBE: PARA HACER LA LOGICA CON EL PARAMETRO "deep" Y CAMBIAR ESTADOS "TRUE o FALSE"
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
        
        T tbd = this.service.readById(id);
        if (tbd == null) {
            throw new ModelNotFoundException("Entidad con id: " + id + ", no encontrado");
        } else {
            this.service.deleteById(id);
            return ResponseEntity.ok(tbd);
        }

    }

}

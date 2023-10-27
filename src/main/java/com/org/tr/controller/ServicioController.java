package com.org.tr.controller;


import com.org.tr.model.Servicio;
import com.org.tr.service.IServicioService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/servicios", produces = MediaType.APPLICATION_JSON_VALUE)
public class ServicioController extends CommonController<Servicio, IServicioService> {

}

package com.org.tr.controller;

import com.org.tr.model.TipoVehiculo;
import com.org.tr.service.ITipoVehiculoService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tipo-vehiculos", produces = MediaType.APPLICATION_JSON_VALUE)
public class TipoVehiculoController extends CommonController<TipoVehiculo, ITipoVehiculoService> {


}

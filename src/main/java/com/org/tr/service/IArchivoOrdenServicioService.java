package com.org.tr.service;

import com.org.tr.model.ArchivoOrdenServicio;

public interface IArchivoOrdenServicioService extends ICRUD<ArchivoOrdenServicio> {

    ArchivoOrdenServicio readArchivoByOrdenServicio(Integer idOrdenServicio);
}

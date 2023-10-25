
package com.org.tr.serviceImpl;

import com.org.tr.model.ArchivoOrdenServicio;
import com.org.tr.repo.IArchivoOrdenServicioRepo;
import com.org.tr.service.IArchivoOrdenServicioService;
import org.springframework.stereotype.Service;

@Service
public class ArchivoOrdenServicioServiceImp extends CommonServiceImpl<ArchivoOrdenServicio, IArchivoOrdenServicioRepo> implements IArchivoOrdenServicioService {

    @Override
    public ArchivoOrdenServicio readArchivoByOrdenServicio(Integer idOrdenServicio) {
        return this.repo.readArchivoByOrdenServicio(idOrdenServicio).orElse(null);
    }

}

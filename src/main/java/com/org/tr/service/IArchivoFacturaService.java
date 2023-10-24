package com.org.tr.service;

import com.org.tr.model.ArchivoFactura;
import java.util.Optional;
public interface IArchivoFacturaService extends ICRUD<ArchivoFactura> {
    
    ArchivoFactura readArchivoByfactura(Integer idFactura);
}

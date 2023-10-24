/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr.serviceImpl;

import com.org.tr.model.ArchivoFactura;
import com.org.tr.repo.IArchivoFacturaRepo;
import com.org.tr.service.IArchivoFacturaService;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ArchivoFacturaServiceImp extends CommonServiceImpl<ArchivoFactura, IArchivoFacturaRepo> implements IArchivoFacturaService {

    @Override
    public ArchivoFactura  readArchivoByfactura(Integer idFactura) {//??
        ArchivoFactura arfBD = this.repo.readArchivoByfactura(idFactura).orElse(null);
        return arfBD;
    }

}

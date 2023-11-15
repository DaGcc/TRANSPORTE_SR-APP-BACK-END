/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr.serviceImpl;

import com.org.tr.model.Cliente;
import com.org.tr.model.Solicitud;
import com.org.tr.service.ISolicitudService;
import org.springframework.stereotype.Service;
import com.org.tr.repo.ISolicitudRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class SolicitudServiceImpl extends CommonServiceImpl<Solicitud, ISolicitudRepo> implements ISolicitudService {

    @Override
    public Page<Solicitud> readPageByStatus(boolean estado, Pageable pageable) {
        return this.repo.readPageByStatus(estado,pageable);
    }


}

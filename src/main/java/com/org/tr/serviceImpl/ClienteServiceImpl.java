/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr.serviceImpl;

import com.org.tr.DTO.EntityPageFilterDTO;
import com.org.tr.model.Cliente;
import com.org.tr.model.DetalleCliente;
import com.org.tr.model.Genero;
import com.org.tr.model.TipoCliente;
import com.org.tr.repo.IClienteRepository;
import com.org.tr.service.IClienteService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl extends CommonServiceImpl<Cliente, IClienteRepository> implements IClienteService {

    @Transactional(readOnly = true)
    @Override
    public  EntityPageFilterDTO<Cliente> filtroClientes(Integer pageIndex, Integer pageSize, String filtro) {

        
        EntityPageFilterDTO<Cliente> epf = new EntityPageFilterDTO();

        List<Cliente> content = this.repo.filtroClientes(pageIndex, pageSize, filtro).stream().map(r -> {
            Cliente c = new Cliente();
            c.setIdCliente(Integer.parseInt(r[0].toString()));
            c.setEmail(r[1].toString());
            c.setNombres(r[2].toString());

            if (r[3] != null) {
                c.setRuc(r[3].toString());
            }

            c.setTelefono(r[4].toString());
            TipoCliente tc = new TipoCliente();
            tc.setIdTipoCliente(Integer.parseInt(r[5].toString()));
            tc.setTipo(r[6].toString());
            c.setTipoCliente(tc);

            c.setEstado(Boolean.parseBoolean(r[7].toString()));

            var aux = r[8];
            if (aux != null) {
                DetalleCliente dc = new DetalleCliente();
                dc.setIdDetalleCliente(Integer.parseInt(aux.toString()));
                dc.setApellidoMaterno(r[9].toString());
                dc.setApellidoPaterno(r[10].toString());
                dc.setDni(r[11].toString());
                dc.setEdad(r[12].toString());
                dc.setFoto(null);
                Genero g = new Genero();
                g.setIdGenero(Integer.parseInt(r[14].toString()));
                g.setTipo(r[15].toString());
                dc.setGenero(g);
                c.setDetalleCliente(dc);
            }
            
            //PARA LA PROPEIDAD DE PAGINACION 
            epf.setTotalElements(Integer.parseInt(r[16].toString()));
            epf.setFirstPage(Boolean.parseBoolean(r[17].toString()));
            epf.setLastPage(Boolean.parseBoolean(r[18].toString()));
            return c;
        }).collect(Collectors.toList());
        
        epf.setContent(content);
        
        return epf;

    }

    @Override
    public Page<Cliente> readPageByStatus(boolean estado,Pageable pageable) {
        return this.repo.readPageByStatus(estado,pageable);
    }

}

package com.org.tr.service;

import com.org.tr.DTO.EntityPageFilterDTO;
import com.org.tr.model.Cliente;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IClienteService extends ICRUD<Cliente> {

    Page<Cliente> readPageByStatus(boolean estado, Pageable pageable);
 
    EntityPageFilterDTO<Cliente> filtroClientes(Integer pageIndex, Integer pageSize, String filtro);

}

package com.org.tr.service;

import com.org.tr.DTO.EntityPageFilterDTO;
import com.org.tr.model.Cliente;
import java.util.List;
public interface IClienteService extends ICRUD<Cliente> {

    EntityPageFilterDTO<Cliente> filtroClientes(Integer pageIndex,Integer pageSize,String filtro);
}

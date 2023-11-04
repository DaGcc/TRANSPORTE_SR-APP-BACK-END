
package com.org.tr.serviceImpl;

import com.org.tr.DTO.EntityPageFilterDTO;
import com.org.tr.model.Vehiculo;
import com.org.tr.model.Genero;
import com.org.tr.repo.IVehiculoRepo;
import com.org.tr.service.IVehiculoService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VehiculoServiceImp extends CommonServiceImpl<Vehiculo, IVehiculoRepo> implements IVehiculoService {

    @Transactional(readOnly = true)
    @Override
    public EntityPageFilterDTO<Vehiculo> filtroVehiculos(Integer pageIndex, Integer pageSize, String filtro) {
        // falta impl
        EntityPageFilterDTO<Vehiculo> epf = new EntityPageFilterDTO();
        return epf;
    }

    @Override
    public Page<Vehiculo> readPageByStatus(boolean estado, Pageable pageable) {
        return this.repo.readPageByStatus(estado, pageable);
    }

}

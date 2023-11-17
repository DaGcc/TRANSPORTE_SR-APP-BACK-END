package com.org.tr.serviceImpl;

import com.org.tr.DTO.EntityPageFilterDTO;
import com.org.tr.model.Actividad;
import com.org.tr.repo.IActividadRepo;
import com.org.tr.service.IActividadService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ActividadServiceImp extends CommonServiceImpl<Actividad, IActividadRepo> implements IActividadService {

    @Transactional(readOnly = true)
    @Override
    public EntityPageFilterDTO<Actividad> filtroActividads(Integer pageIndex, Integer pageSize, String filtro) {
        
       return new EntityPageFilterDTO<Actividad>();
    }

    @Override
    public Page<Actividad> readPageByStatus(boolean estado, Pageable pageable) {
        return this.repo.readPageByStatus(estado, pageable);
    }

}

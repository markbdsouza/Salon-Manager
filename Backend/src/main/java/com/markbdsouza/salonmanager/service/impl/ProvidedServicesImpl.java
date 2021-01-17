package com.markbdsouza.salonmanager.service.impl;

import com.markbdsouza.salonmanager.io.entity.ServicesEntity;
import com.markbdsouza.salonmanager.io.repository.ServicesRepository;
import com.markbdsouza.salonmanager.service.ProvidedServicesService;
import com.markbdsouza.salonmanager.shared.dto.ServicesDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProvidedServicesImpl implements ProvidedServicesService {

    @Autowired
    ServicesRepository servicesRepository;
    @Override
    public List<ServicesDTO> getAllServices() {
        List<ServicesEntity> servicesEntities = (List<ServicesEntity>) servicesRepository.findAll();
        List<ServicesDTO> returnServiceList = new ArrayList<>();
        ServicesDTO servicesDTO;
        for (ServicesEntity servicesEntity : servicesEntities) {
            servicesDTO = new ServicesDTO();
            BeanUtils.copyProperties(servicesEntity, servicesDTO);
            returnServiceList.add(servicesDTO);
        }
        return returnServiceList;
    }
}

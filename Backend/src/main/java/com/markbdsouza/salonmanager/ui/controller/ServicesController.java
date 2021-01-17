package com.markbdsouza.salonmanager.ui.controller;

import com.markbdsouza.salonmanager.service.ProvidedServicesService;
import com.markbdsouza.salonmanager.shared.dto.ServicesDTO;
import com.markbdsouza.salonmanager.ui.model.response.ServicesResponseModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("services")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ServicesController {

    @Autowired
    ProvidedServicesService providedServicesService;

    @GetMapping()
    public ResponseEntity<List<ServicesResponseModel>> GetCustomerDetails() {
        List<ServicesDTO> servicesDTOList = providedServicesService.getAllServices();
        // copy details to returnObject
        List<ServicesResponseModel> servicesResponseModelList = new ArrayList<>();
        ServicesResponseModel userRest;
        for (ServicesDTO servicesDTO : servicesDTOList) {
            userRest = new ServicesResponseModel();
            BeanUtils.copyProperties(servicesDTO, userRest);
            servicesResponseModelList.add(userRest);
        }
        return new ResponseEntity<>(servicesResponseModelList, HttpStatus.OK);
    }
}

package com.hss.hcms.service.services;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.hss.hcms.entity.Services;
import com.hss.hcms.entity.bean.ServiceDto;
import com.hss.hcms.repo.ServiceRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicesServiceImpl implements ServicesService{

    @Autowired
    private ServiceRepo serviceRepo;

    @Override
    public List<ServiceDto> list() {
        List<ServiceDto> list = new ArrayList<>();
        serviceRepo.findAll().forEach(services -> {
            list.add(new ServiceDto(services));
        });
        return list;
    }

    @Override
    public ServiceDto add(ServiceDto dto) {
        Services service = new Services();
        BeanUtils.copyProperties(dto, service);
        return new ServiceDto(serviceRepo.save(service));
    }
}

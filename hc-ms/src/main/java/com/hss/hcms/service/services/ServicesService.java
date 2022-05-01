package com.hss.hcms.service.services;

import com.hss.hcms.entity.Services;
import com.hss.hcms.entity.bean.ServiceDto;

import java.util.List;

public interface ServicesService {

    public List<ServiceDto> list();

    public ServiceDto add(ServiceDto dto);

}

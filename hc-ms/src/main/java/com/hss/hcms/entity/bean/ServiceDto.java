package com.hss.hcms.entity.bean;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.hss.hcms.entity.Services;
import org.springframework.beans.BeanUtils;

public class ServiceDto {

    public ServiceDto() {}

    public ServiceDto(Services services){
        BeanUtils.copyProperties(services, this);
    }

    private String serviceId;

    private String serviceName, remarks, description;

    private Integer priority;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}

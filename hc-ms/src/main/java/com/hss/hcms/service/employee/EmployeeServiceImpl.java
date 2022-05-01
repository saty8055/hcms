package com.hss.hcms.service.employee;

import com.hss.hcms.entity.Employee;
import com.hss.hcms.entity.bean.EmployeeDto;
import com.hss.hcms.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepo repo;

    @Override
    public List<Employee> list() {
        return repo.findAll();
    }

    @Override
    public Employee add(Employee dto) {
        return repo.save(dto);
    }
}

package com.hss.hcms.service.employee;

import com.hss.hcms.entity.Employee;
import com.hss.hcms.entity.bean.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    public List<Employee> list();

    public Employee add(Employee dto);

}

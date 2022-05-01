package com.hss.hcms.web;

import com.hss.hcms.config.constants.Url;
import com.hss.hcms.config.exception.DataValidityException;
import com.hss.hcms.entity.Employee;
import com.hss.hcms.entity.bean.ServiceDto;
import com.hss.hcms.entity.bean.TaskDto;
import com.hss.hcms.service.employee.EmployeeService;
import com.hss.hcms.service.services.ServicesService;
import com.hss.hcms.service.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description controller service for App
 */
@CrossOrigin
@RestController
@RequestMapping(Url.SECURE_URL)
public class Controller {

    @Autowired
    TaskService taskService;

    @Autowired
    ServicesService service;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/task")
    public ResponseEntity<List<TaskDto>> tasks(){
        return ResponseEntity.ok(taskService.list());
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> employees(){
        return ResponseEntity.ok(employeeService.list());
    }

    @GetMapping("/services")
    public ResponseEntity<List<ServiceDto>> services(){
        return ResponseEntity.ok(service.list());
    }

    @PostMapping("/task")
    public ResponseEntity<TaskDto> addTask(@RequestBody TaskDto task) throws DataValidityException {
        return ResponseEntity.ok(taskService.add(task));
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.add(employee));
    }

    @PostMapping("/services")
    public ResponseEntity<ServiceDto> addService(@RequestBody ServiceDto services){
        return ResponseEntity.ok(service.add(services));
    }


}

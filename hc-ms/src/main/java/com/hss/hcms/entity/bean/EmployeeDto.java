package com.hss.hcms.entity.bean;

import com.hss.hcms.entity.Employee;
import com.hss.hcms.entity.Tasks;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDto {

    public EmployeeDto(){

    }

    public EmployeeDto(Employee employee){
        BeanUtils.copyProperties(employee,this);
    }

    private String employeeId;

    private String name, email, employeeCode, phone;

    private List<TaskDto> tasks;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<TaskDto> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDto> tasks) {
        this.tasks = tasks;
    }

    public void setTask(List<Tasks> tasks) {
        this.tasks = new ArrayList<>();
        tasks.forEach(task->{
            this.tasks.add(new TaskDto(task));
        });
    }
}

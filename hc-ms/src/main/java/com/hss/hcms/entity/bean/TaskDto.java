package com.hss.hcms.entity.bean;

import com.hss.hcms.entity.Tasks;
import org.springframework.beans.BeanUtils;

public class TaskDto {

    private String taskId;

    private String taskName;

    private EmployeeDto employee;

    public TaskDto(){}

    public TaskDto(Tasks task){
        BeanUtils.copyProperties(task, this);
        this.employee = new EmployeeDto(task.getEmployee());

    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }
}

package com.hss.hcms.service.task;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.hss.hcms.config.exception.DataValidityException;
import com.hss.hcms.entity.Tasks;
import com.hss.hcms.entity.bean.TaskDto;
import com.hss.hcms.repo.EmployeeRepo;
import com.hss.hcms.repo.TaskRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public TaskDto add(TaskDto taskDto) throws DataValidityException {
        Tasks task = new Tasks();
        BeanUtils.copyProperties(taskDto, task);
        if(taskDto.getEmployee() == null || taskDto.getEmployee().getEmployeeId()==null || taskDto.getEmployee().getEmployeeId().isEmpty())
            throw new DataValidityException("Invalid Employee ID");
        task.setEmployee(employeeRepo.findById(taskDto.getEmployee().getEmployeeId()).get());
        return new TaskDto(taskRepo.save(task));
    }

    @Override
    public List<TaskDto> list(){
        List<TaskDto> list = new ArrayList<>();
        taskRepo.findAll().forEach(tasks -> {
            list.add(new TaskDto(tasks));
        });
        return list;
    }

}

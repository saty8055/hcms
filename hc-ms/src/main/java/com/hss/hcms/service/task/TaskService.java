package com.hss.hcms.service.task;

import com.hss.hcms.config.exception.DataValidityException;
import com.hss.hcms.entity.bean.TaskDto;

import java.util.List;

public interface TaskService {
    TaskDto add(TaskDto taskDto) throws DataValidityException;

    List<TaskDto> list();
}

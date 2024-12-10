package com.sunrise.mapper;

import com.sunrise.domain.task.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaskMapper {
    List<Task> list();

    void addTask(Task task);

    void updateById(Task task);

    Task selectById(Integer taskId);

    Task selectByName(Task task);
}

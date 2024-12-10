package com.sunrise.mapper;

import com.sunrise.domain.TaskPoint;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaskPointMapper {
    void insertStu(TaskPoint taskPoint);

    List<TaskPoint> stuList(Long taskId);

    void setPoint(TaskPoint taskPoint);
}

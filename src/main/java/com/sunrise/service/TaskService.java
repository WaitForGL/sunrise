package com.sunrise.service;

import com.sunrise.domain.TaskPoint;
import com.sunrise.domain.seat.Seat;
import com.sunrise.domain.task.Task;

import java.util.List;

public interface TaskService {
    List<Task> list();

    void addTask(Task task);

    void updateById(Task task);

    List<TaskPoint> stuList(Long taskId);

    void setPoint(TaskPoint taskPoint);

    List<Seat> signStu(Seat seat);
}

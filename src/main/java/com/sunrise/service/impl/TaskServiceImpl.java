package com.sunrise.service.impl;

import com.sunrise.domain.TaskPoint;
import com.sunrise.domain.classmanage.ClassManage;
import com.sunrise.domain.seat.Seat;
import com.sunrise.domain.task.Task;
import com.sunrise.domain.user.User;
import com.sunrise.mapper.*;
import com.sunrise.service.TaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Resource
    TaskMapper taskMapper;

    @Resource
    ClassManageMapper classManageMapper;

    @Resource
    UserMapper userMapper;

    @Resource
    TaskPointMapper taskPointMapper;
    @Resource
    SeatMapper seatMapper;


    @Override
    public List<Task> list() {
        return taskMapper.list();
    }

    @Override
    public void addTask(Task task) {
        ClassManage classManage =new ClassManage();
        classManage.setClassName(task.getClassName());
        ClassManage classManages = classManageMapper.selectById(Integer.valueOf(task.getClassName()));
        task.setShouldNum(classManages.getStuNum());
        taskMapper.addTask(task);
        User user = new User();
        user.setBelongId(Math.toIntExact(classManages.getId()));
        List<User> list = userMapper.selectList(user);
        TaskPoint taskPoint = new TaskPoint();
        Task newTask = taskMapper.selectByName(task);
        for(User user1 :list){
            taskPoint.setTaskId(newTask.getId());
            taskPoint.setStuId(user1.getId());
            taskPointMapper.insertStu(taskPoint);
        }
    }

    @Override
    public void updateById(Task task) {
        taskMapper.updateById(task);
    }

    @Override
    public List<TaskPoint> stuList(Long taskId) {
        List<TaskPoint> list = taskPointMapper.stuList(taskId);
        for(TaskPoint taskPoint :list){
            User user = userMapper.selectById(taskPoint.getStuId());
            taskPoint.setUsername(user.getUsername());
        }
        return list;
    }

    @Override
    public void setPoint(TaskPoint taskPoint) {
        taskPointMapper.setPoint(taskPoint);
    }

    @Override
    public List<Seat> signStu(Seat seat) {
        List<Seat> list = seatMapper.selectById(seat.getRoomId());
        for(Seat seat1 :list){

        }
        return list;
    }
}

package com.sunrise.controller;

import com.sunrise.common.AjaxResult;
import com.sunrise.domain.TaskPoint;
import com.sunrise.domain.seat.Seat;
import com.sunrise.domain.task.Task;
import com.sunrise.service.TaskService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Resource
    private TaskService taskService;

    @GetMapping("/list")
    public AjaxResult list(){
        List<Task> list = taskService.list();
        return AjaxResult.success(list);
    }

    @PostMapping("/add")
    public AjaxResult addTask(@RequestBody Task task){
        taskService.addTask(task);
        return AjaxResult.success("新增成功");
    }

    @PostMapping("/update")
    public AjaxResult updateById(@RequestBody Task task){
        taskService.updateById(task);
        return AjaxResult.success("更新成功");
    }

    @PostMapping("/remove")
    public AjaxResult removeById(@RequestBody Task task){
        Task newtask = new Task();
        newtask.setId(task.getId());
        newtask.setStatus(1);
        taskService.updateById(newtask);
        return AjaxResult.success("删除成功");
    }


    @GetMapping("/stuList")
    public AjaxResult stuList(Long taskId){
        List<TaskPoint> list = taskService.stuList(taskId);
        return AjaxResult.success(list);
    }

    @PostMapping("/setPoint")
    public AjaxResult setPoint(@RequestBody TaskPoint taskPoint){
        taskService.setPoint(taskPoint);
        return AjaxResult.success();
    }

    @PostMapping("/signStu")
    public AjaxResult signStu(@RequestBody Seat seat){
        List<Seat> list = taskService.signStu(seat);
        return AjaxResult.success(list);
    }
}

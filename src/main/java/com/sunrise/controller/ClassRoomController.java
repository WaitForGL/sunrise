package com.sunrise.controller;

import com.sunrise.common.AjaxResult;
import com.sunrise.domain.classmanage.ClassManage;
import com.sunrise.domain.classroom.ClassRoom;
import com.sunrise.domain.user.User;
import com.sunrise.service.ClassRoomService;
import com.sunrise.utils.QueryWithPageDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/room")
@RestController
public class ClassRoomController {

    @Resource
    private ClassRoomService classRoomService;

    @GetMapping("/list")
    public Object list(Integer pageNo, Integer pageSize, ClassRoom classRoom){
        if(pageNo==null){
            pageNo = 1;
        }
        if(pageSize==null){
            pageSize = 10;
        }
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ClassRoom> list = classRoomService.selectList(classRoom);
        //调用pageable分页参数
        int pageNumber = pageable.getPageNumber();
        int size = pageable.getPageSize();
        //总条数
        int totalRows = list.size();
        List result = new ArrayList();
        if (pageNumber * size < totalRows) {// 判断是否为最后一页
            result = list.subList((pageNumber - 1) * size, pageNumber * size);
        } else {
            result = list.subList((pageNumber - 1) * size, totalRows);
        }

        QueryWithPageDTO resultDto = new QueryWithPageDTO();
        resultDto.setCode(200);
        resultDto.setList(result);
        resultDto.setTotal(Long.valueOf(totalRows + ""));
        return resultDto;

    }

    @PostMapping("/detail")
    public AjaxResult detail(@RequestBody ClassRoom classRoom){
        ClassRoom newClassRoom = classRoomService.detail(classRoom);
        return AjaxResult.success("详情",newClassRoom);
    }

    @PostMapping("/add")
    public AjaxResult addUser(@RequestBody ClassRoom classRoom){
        classRoomService.addClassRoom(classRoom);
        return AjaxResult.success("新增成功");
    }

    @PostMapping("/update")
    public AjaxResult updateById(@RequestBody ClassRoom classRoom){
        classRoomService.updateById(classRoom);
        return AjaxResult.success("更新成功");
    }

    @PostMapping("/remove")
    public AjaxResult removeById(@RequestBody ClassRoom classRoom){
        ClassRoom newRoom = new ClassRoom();
        newRoom.setId(classRoom.getId());
        newRoom.setStatus(1);
        classRoomService.updateById(newRoom);
        return AjaxResult.success("删除成功");
    }
}

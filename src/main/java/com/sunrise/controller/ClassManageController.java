package com.sunrise.controller;

import com.sunrise.common.AjaxResult;
import com.sunrise.domain.classmanage.ClassManage;
import com.sunrise.domain.user.User;
import com.sunrise.service.ClassManageService;
import com.sunrise.utils.QueryWithPageDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassManageController {

    @Resource
    private ClassManageService classManageService;

    @GetMapping("/list")
    public Object list(Integer pageNo, Integer pageSize, ClassManage classManage){
        if(pageNo==null){
            pageNo = 1;
        }
        if(pageSize==null){
            pageSize = 10;
        }
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ClassManage> list = classManageService.selectList(classManage);
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

    @GetMapping("/detail")
    public AjaxResult detail(ClassManage classManage){
        List<User> userList = classManageService.detail(classManage);
        return AjaxResult.success("班级学生",userList);
    }

    @PostMapping("/add")
    public AjaxResult addUser(@RequestBody ClassManage classManage){
        classManageService.addClassManage(classManage);
        return AjaxResult.success("新增成功");
    }

    @PostMapping("/update")
    public AjaxResult updateById(@RequestBody ClassManage classManage){
        classManageService.updateById(classManage);
        return AjaxResult.success("更新成功");
    }

    @PostMapping("/remove")
    public AjaxResult removeById(@RequestBody ClassManage classManage){
        ClassManage newClass = new ClassManage();
        newClass.setId(classManage.getId());
        newClass.setStatus(1);
        classManageService.updateById(newClass);
        return AjaxResult.success("删除成功");
    }
}

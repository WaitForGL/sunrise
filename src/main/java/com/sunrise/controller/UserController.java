package com.sunrise.controller;

import cn.hutool.core.util.ObjectUtil;
import com.sunrise.common.AjaxResult;
import com.sunrise.domain.classmanage.ClassManage;
import com.sunrise.domain.user.User;
import com.sunrise.service.ClassManageService;
import com.sunrise.service.UserService;
import com.sunrise.utils.QueryWithPageDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private ClassManageService classManageService;

    @GetMapping("/list")
    public Object list(Integer pageNo, Integer pageSize,User user){
        if(pageNo==null){
            pageNo = 1;
        }
        if(pageSize==null){
            pageSize = 10;
        }
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<User> list = userService.selectList(user);
        for(User newuser:list){
            ClassManage classManage = classManageService.selectById(newuser.getBelongId());
            newuser.setClassName(classManage.getClassName());
            newuser.setMajorName(classManage.getMajorName());
        }
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

    @PostMapping("/add")
    public AjaxResult addUser(@RequestBody User user){
        userService.addUser(user);
        return AjaxResult.success("新增成功");
    }

    @PostMapping("/update")
    public AjaxResult updateById(@RequestBody User user){
        userService.updateById(user);
        return AjaxResult.success("更新成功");
    }

    @PostMapping("/remove")
    public AjaxResult removeById(@RequestBody User user){
        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setStatus(1);
        userService.updateById(newUser);
        return AjaxResult.success("删除成功");
    }
}

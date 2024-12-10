package com.sunrise.controller;

import com.sunrise.common.AjaxResult;
import com.sunrise.domain.classroom.ClassRoom;
import com.sunrise.domain.seat.Seat;
import com.sunrise.service.SeatService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/seat")
public class SeatController {

    @Resource
    private SeatService seatService;

    @PostMapping("/sign")
    public AjaxResult sign(@RequestBody Seat seat){
        seatService.sign(seat);
        return AjaxResult.success("签到成功");
    }

    @PostMapping("/handup")
    public AjaxResult handup(@RequestBody Seat seat){
        seatService.handup(seat);
        return AjaxResult.success("举手成功");
    }

    @GetMapping("/signList")
    public AjaxResult signList(ClassRoom classRoom){
        List<Seat> list = seatService.signList(classRoom);
        return AjaxResult.success("签到列表",list);
    }
}

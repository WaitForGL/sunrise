package com.sunrise.service.impl;

import com.sunrise.domain.classroom.ClassRoom;
import com.sunrise.domain.seat.Seat;
import com.sunrise.domain.task.Task;
import com.sunrise.mapper.ClassRoomMapper;
import com.sunrise.mapper.SeatMapper;
import com.sunrise.mapper.TaskMapper;
import com.sunrise.service.SeatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    @Resource
    SeatMapper seatMapper;
    @Resource
    TaskMapper taskMapper;

    @Override
    public void sign(Seat seat) {
        seatMapper.sign(seat);
        Task task = taskMapper.selectById(seat.getTaskId());
        task.setAlreadyNum(task.getAlreadyNum()+1);
        taskMapper.updateById(task);
    }

    @Override
    public void handup(Seat seat) {
        seatMapper.handup(seat);
    }

    @Override
    public List<Seat> signList(ClassRoom classRoom) {
        return seatMapper.signList(classRoom);
    }

}

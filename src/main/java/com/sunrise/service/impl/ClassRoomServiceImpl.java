package com.sunrise.service.impl;

import com.sunrise.domain.classroom.ClassRoom;
import com.sunrise.domain.seat.Seat;
import com.sunrise.mapper.ClassManageMapper;
import com.sunrise.mapper.ClassRoomMapper;
import com.sunrise.mapper.SeatMapper;
import com.sunrise.service.ClassManageService;
import com.sunrise.service.ClassRoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    @Resource
    private ClassRoomMapper classRoomMapper;

    @Resource
    private SeatMapper seatMapper;
    @Override
    public List<ClassRoom> selectList(ClassRoom classRoom) {
        return classRoomMapper.selectList(classRoom);
    }

    @Override
    public void addClassRoom(ClassRoom classRoom) {
        classRoomMapper.addClassRoom(classRoom);
        ClassRoom newClassRoom =classRoomMapper.selectById(classRoom.getRoomName());
        for(Seat seat:classRoom.getSeatList()){
            seat.setRoomId(newClassRoom.getId());
            seatMapper.insertSeat(seat);
        }
    }

    @Override
    public void updateById(ClassRoom classRoom) {
        classRoomMapper.updateById(classRoom);

    }

    @Override
    public ClassRoom detail(ClassRoom classRoom) {
        ClassRoom classRoom1 = classRoomMapper.detail(classRoom);
        List<Seat> list = seatMapper.selectById(classRoom1.getId());
        classRoom1.setSeatList(list);
        return classRoom1;
    }

}

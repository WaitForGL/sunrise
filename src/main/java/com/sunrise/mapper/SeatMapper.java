package com.sunrise.mapper;

import com.sunrise.domain.classroom.ClassRoom;
import com.sunrise.domain.seat.Seat;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SeatMapper {
    void insertSeat(Seat seat);

    List<Seat> selectById(Long id);

    void sign(Seat seat);

    void handup(Seat seat);

    List<Seat> signList(ClassRoom classRoom);
}

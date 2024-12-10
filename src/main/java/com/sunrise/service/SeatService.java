package com.sunrise.service;

import com.sunrise.domain.classroom.ClassRoom;
import com.sunrise.domain.seat.Seat;

import java.util.List;

public interface SeatService {
    void sign(Seat seat);

    void handup(Seat seat);

    List<Seat> signList(ClassRoom classRoom);
}

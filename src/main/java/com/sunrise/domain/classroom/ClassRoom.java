package com.sunrise.domain.classroom;

import com.sunrise.domain.seat.Seat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ClassRoom {

    private Long id;
    private String roomName;
    private Integer roomSize;
    private Integer useStatus;
    private Date createTime;
    private Integer status;

    private List<Seat> seatList;
}

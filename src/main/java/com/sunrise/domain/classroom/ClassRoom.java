package com.sunrise.domain.classroom;

import lombok.Data;

import java.util.Date;

@Data
public class ClassRoom {

    private Long id;
    private String roomName;
    private Integer roomSize;
    private Integer useStatus;
    private Date createTime;
    private Integer status;
}

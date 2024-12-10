package com.sunrise.domain.task;

import lombok.Data;

import java.util.Date;

@Data
public class Task {
    private Long id;
    private String taskName;
    private String roomName;
    private String proName;
    private String className;
    private String teacherName;
    private Date startTime;
    private Date endTime;
    private Integer status;
    private Date createTime;
    private Integer shouldNum;
    private Integer alreadyNum;
}

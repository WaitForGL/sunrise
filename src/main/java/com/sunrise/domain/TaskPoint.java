package com.sunrise.domain;

import lombok.Data;

@Data
public class TaskPoint {
    private Long id;
    private Long taskId;
    private Long stuId;
    private Double stuPoint;


    private String username;
}

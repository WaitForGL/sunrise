package com.sunrise.domain.seat;

import lombok.Data;

@Data
public class Seat {
    private Long id;
    private Integer lineNum;
    private Integer verticalNum;
    private Long roomId;
    private String username;
    private Integer status;
    private Integer handStatus;
    private Integer signStatus;

    private Integer taskId;
}

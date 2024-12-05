package com.sunrise.domain.vo;

import lombok.Data;

@Data
public class LoginTokenVo {
    private Long userId;
    private String userName;
    private String belongArea;

    private String token;
}

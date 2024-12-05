package com.sunrise.domain.user;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Long id;
    private String username;
    private String className;
    private String majorName;
    private Integer userType;
    private Date createTime;
    private Integer status;
}

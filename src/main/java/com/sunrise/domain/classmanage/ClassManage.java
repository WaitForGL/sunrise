package com.sunrise.domain.classmanage;

import lombok.Data;

import java.util.Date;

@Data
public class ClassManage {

    private Long id;
    private String className;
    private String majorName;
    private Integer stuNum;
    private Date createTime;
    private Integer status;
}

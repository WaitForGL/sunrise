package com.sunrise.domain.user;

import com.sunrise.common.BaseDomain;
import lombok.Data;

import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "tb_user")
public class User {

    private Long id;
    private String username;
    private String password;
    private Integer userType;
    private Date createTime;
    private Integer status;
    private Integer belongId;

    //
    private String className;
    private String majorName;
}

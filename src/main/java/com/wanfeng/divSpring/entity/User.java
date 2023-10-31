package com.wanfeng.divSpring.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 身份证
     */
    private String idcard;

}

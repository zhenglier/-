package com.tuhf.project16.model;

import lombok.Getter;

/**
 * 登录和权限管理部分的自定义用户对象
 */
@Getter
public class LoginUser {
    private Long id;

    private String username;

    private String password;

    private String role;

    public LoginUser() {
    }

    public LoginUser(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}

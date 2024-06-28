package com.tuhf.project16.mapper;

import com.tuhf.project16.model.LoginUser;

public interface LoginUserMapper {
    /* Create */

    public int addLoginUser(LoginUser loginUser);

    /* Request */

    public LoginUser getLoginUserById(Long id);

    public LoginUser getLoginUserByUsername(String username);

    /* Update */

    public int updatePasswordById(Long id, String password);

    public int updatePasswordByUsername(Long id, String username);

    /* Delete */

    public int deleteLoginUserById(Long id);
}

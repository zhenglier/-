package com.tuhf.project16.service;

import com.tuhf.project16.model.LoginUser;

public interface ILoginUserService {
    /* Create */

    int addLoginUser(LoginUser loginUser);

    /* Request */

    LoginUser getLoginUserById(Long id);

    LoginUser getLoginUserByUsername(String username);

    boolean checkUsernameUnique(String username);

    /* Update */

    int updatePasswordById(Long id, String password);

    int updatePasswordByUsername(Long id, String username);

    /* Delete */

    int deleteLoginUserById(Long id);
}
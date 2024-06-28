package com.tuhf.project16.service;

import com.tuhf.project16.model.LoginUser;

public interface ILoginUserService {
    /* Create */

    public int addLoginUser(LoginUser loginUser);

    /* Request */

    public LoginUser getLoginUserById(Long id);

    public LoginUser getLoginUserByUsername(String username);

    public boolean checkUsernameUnique(String username);

    /* Update */

    public int updatePasswordById(Long id, String password);

    public int updatePasswordByUsername(Long id, String username);

    /* Delete */

    public int deleteLoginUserById(Long id);
}

package com.tuhf.project16.mapper;

import com.tuhf.project16.model.LoginUser;

public interface LoginUserMapper {
    /* Create */

    int addLoginUser(LoginUser loginUser);

    /* Request */

    LoginUser getLoginUserById(Long id);

    LoginUser getLoginUserByUsername(String username);

    Long getEntityIdById(Long id);

    /* Update */

    int updatePasswordById(Long id, String password);

    int updatePasswordByUsername(Long id, String username);

    /* Delete */

    int deleteLoginUserById(Long id);

    int createBound(Long loginId, Long entityId, String entityType);
}

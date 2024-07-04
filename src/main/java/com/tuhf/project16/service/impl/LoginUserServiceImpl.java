package com.tuhf.project16.service.impl;

import com.tuhf.project16.mapper.LoginUserMapper;
import com.tuhf.project16.model.LoginUser;
import com.tuhf.project16.service.ILoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUserServiceImpl implements ILoginUserService {

    @Autowired
    private LoginUserMapper loginUserMapper;

    @Override
    public int addLoginUser(LoginUser loginUser) {
        return loginUserMapper.addLoginUser(loginUser);
    }

    @Override
    public LoginUser getLoginUserById(Long id) {
        return loginUserMapper.getLoginUserById(id);
    }

    @Override
    public LoginUser getLoginUserByUsername(String username) {
        return loginUserMapper.getLoginUserByUsername(username);
    }

    @Override
    public Long getIdByUsername(String username) {
        return getLoginUserByUsername(username).getId();
    }

    @Override
    public Long getEntityIdByUsername(String username) {
        return loginUserMapper.getEntityIdById(getIdByUsername(username));
    }

    @Override
    public Long getEntityIdById(Long id) {
        return loginUserMapper.getEntityIdById(id);
    }

    @Override
    public boolean checkUsernameUnique(String username) {
        return getLoginUserByUsername(username) == null;
    }

    @Override
    public int updatePasswordById(Long id, String password) {
        return loginUserMapper.updatePasswordById(id, password);
    }

    @Override
    public int updatePasswordByUsername(Long id, String username) {
        return loginUserMapper.updatePasswordByUsername(id, username);
    }

    @Override
    public int deleteLoginUserById(Long id) {
        return loginUserMapper.deleteLoginUserById(id);
    }
}

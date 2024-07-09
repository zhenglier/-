package com.tuhf.project16.util;

import com.tuhf.project16.service.IEntityService;
import com.tuhf.project16.service.ILoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserUtil {

    @Autowired
    ILoginUserService loginUserService;

    public Long getEtpId() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return loginUserService.getEntityIdByUsername(username);
    }

    public Long getCrrId() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return loginUserService.getEntityIdByUsername(username);
    }

    public Long getGovId() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return loginUserService.getEntityIdByUsername(username);
    }

    public Long getUserId() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return loginUserService.getIdByUsername(username);
    }
}

package com.tuhf.project16.service.impl;

import com.tuhf.project16.mapper.EnterpriseMapper;
import com.tuhf.project16.model.Enterprise;
import com.tuhf.project16.payload.response.EnterpriseBriefResponse;
import com.tuhf.project16.service.IEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EnterpriseService implements IEnterpriseService {

    @Autowired
    EnterpriseMapper enterpriseMapper;

    @Override
    public int addEnterprise(Enterprise enterprise) {
        return enterpriseMapper.addEnterprise(enterprise);
    }

    @Override
    public int updateEnterprise(Enterprise enterprise) {
        return enterpriseMapper.updateEnterprise(enterprise);
    }

    @Override
    public Enterprise getEnterpriseById(long id) {
        return enterpriseMapper.getEnterpriseById(id);
    }

    @Override
    public EnterpriseBriefResponse getBriefById(long id) {
        return enterpriseMapper.getBriefById(id);
    }

    @Override
    public Collection<EnterpriseBriefResponse> getAllBriefs() {
        return enterpriseMapper.getAllBriefs();
    }

}

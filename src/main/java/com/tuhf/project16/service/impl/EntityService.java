package com.tuhf.project16.service.impl;

import com.tuhf.project16.mapper.EntityMapper;
import com.tuhf.project16.model.Enterprise;
import com.tuhf.project16.payload.response.EnterpriseBriefResponse;
import com.tuhf.project16.service.IEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EntityService implements IEntityService {

    @Autowired
    EntityMapper entityMapper;

    @Override
    public int addEnterprise(Enterprise enterprise) {
        return entityMapper.addEnterprise(enterprise);
    }

    @Override
    public int updateEnterprise(Enterprise enterprise) {
        return entityMapper.updateEnterprise(enterprise);
    }

    @Override
    public Enterprise getEnterpriseById(long id) {
        return entityMapper.getEnterpriseById(id);
    }

    @Override
    public EnterpriseBriefResponse getBriefById(long id) {
        return entityMapper.getBriefById(id);
    }

    @Override
    public Collection<EnterpriseBriefResponse> getAllBriefs() {
        return entityMapper.getAllBriefs();
    }


    @Override
    public Long getParentIdForCarrier(long carrierId) {
        return entityMapper.getParentIdForCarrier(carrierId);
    }

}

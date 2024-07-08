package com.tuhf.project16.service.impl;

import com.tuhf.project16.mapper.EntityMapper;
import com.tuhf.project16.model.Carrier;
import com.tuhf.project16.model.Enterprise;
import com.tuhf.project16.model.Government;
import com.tuhf.project16.payload.response.EnterpriseBriefResponse;
import com.tuhf.project16.service.IEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class EntityService implements IEntityService {

    @Autowired
    EntityMapper entityMapper;

    @Override
    public Map<String, Long> getAllCarriersNameAndId() {
        return Map.of();
    }

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
    public Carrier getCarrierById(long id) {
        return null;
    }

    @Override
    public Government getGovernmentById(long id) {
        return null;
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
    public int setEnterpriseAdditionalData(long id, String data) {
        return 0;
    }

    @Override
    public Long getParentIdForEnterprise(long EnterpriseId) {
        return 0L;
    }


    @Override
    public Long getParentIdForCarrier(long carrierId) {
        return entityMapper.getParentIdForCarrier(carrierId);
    }

}

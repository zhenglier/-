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
import java.util.List;
import java.util.Map;

@Service
public class EntityService implements IEntityService {

    @Autowired
    EntityMapper entityMapper;

    @Override
    public int addEnterprise(Enterprise enterprise) {
        return entityMapper.addEnterprise(enterprise);
    }

    @Override
    public int addCarrier(Carrier carrier) {
        return entityMapper.addCarrier(carrier);
    }

    @Override
    public int addGovernment(Government government) {
        return entityMapper.addGovernment(government);
    }

    @Override
    public int updateEnterprise(Enterprise enterprise) {
        return entityMapper.updateEnterprise(enterprise);
    }

    @Override
    public int updateCarrier(Carrier carrier) {
        return entityMapper.updateCarrier(carrier);
    }

    @Override
    public int updateEnterpriseAdditionalData(long id, String additionalData) {
        return entityMapper.updateEnterpriseAdditionalData(id, additionalData);
    }

    @Override
    public Enterprise getEnterpriseById(long id) {
        return entityMapper.getEnterpriseById(id);
    }

    @Override
    public Carrier getCarrierById(long id) {
        return entityMapper.getCarrierById(id);
    }

    @Override
    public Government getGovernmentById(long id) {
        return entityMapper.getGovernmentById(id);
    }

    @Override
    public Map<Long, String> getAllCarriersIdAndName() {
        return entityMapper.getAllCarriersIdAndName();
    }

    @Override
    public String getEnterpriseNameById(long id) {
        return entityMapper.getEnterpriseNameById(id);
    }

    @Override
    public String getCarrierNameById(long id) {
        return entityMapper.getCarrierNameById(id);
    }

    @Override
    public String getGovernmentNameById(long id) {
        return entityMapper.getGovernmentNameById(id);
    }

    @Override
    public EnterpriseBriefResponse getEnterpriseBriefById(long id) {
        return entityMapper.getEnterpriseBriefById(id);
    }

    @Override
    public Collection<EnterpriseBriefResponse> getAllEnterpriseBriefs() {
        return entityMapper.getAllEnterpriseBriefs();
    }

    @Override
    public Long getParentIdForEnterprise(long EnterpriseId) {
        return entityMapper.getParentIdForEnterprise(EnterpriseId);
    }

    @Override
    public Long getParentIdForCarrier(long carrierId) {
        return entityMapper.getParentIdForCarrier(carrierId);
    }

}

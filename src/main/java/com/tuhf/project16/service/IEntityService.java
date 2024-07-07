package com.tuhf.project16.service;

import com.tuhf.project16.model.Carrier;
import com.tuhf.project16.model.Enterprise;
import com.tuhf.project16.model.Government;
import com.tuhf.project16.payload.response.EnterpriseBriefResponse;

import java.util.Collection;
import java.util.Map;

public interface IEntityService {
    Map<String, Long> getAllCarriersNameAndId();

    int addEnterprise(Enterprise enterprise);

    int updateEnterprise(Enterprise enterprise);

    Enterprise getEnterpriseById(long id);

    Carrier getCarrierById(long id);

    Government getGovernmentById(long id);

    EnterpriseBriefResponse getBriefById(long id);

    Collection<EnterpriseBriefResponse> getAllBriefs();

    int setEnterpriseAdditionalData(long id, String data);


    Long getParentIdForEnterprise(long EnterpriseId);
    Long getParentIdForCarrier(long carrierId);
}

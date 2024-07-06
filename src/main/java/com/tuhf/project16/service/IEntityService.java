package com.tuhf.project16.service;

import com.tuhf.project16.model.Enterprise;
import com.tuhf.project16.payload.response.EnterpriseBriefResponse;

import java.util.Collection;

public interface IEntityService {
    int addEnterprise(Enterprise enterprise);

    int updateEnterprise(Enterprise enterprise);

    Enterprise getEnterpriseById(long id);

    EnterpriseBriefResponse getBriefById(long id);

    Collection<EnterpriseBriefResponse> getAllBriefs();


    Long getParentIdForCarrier(long carrierId);
}

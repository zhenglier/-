package com.tuhf.project16.mapper;

import com.tuhf.project16.model.Carrier;
import com.tuhf.project16.model.Enterprise;
import com.tuhf.project16.payload.response.EnterpriseBriefResponse;

import java.util.Collection;

public interface EntityMapper {
    int addEnterprise(Enterprise enterprise);

    int updateEnterprise(Enterprise enterprise);

    Enterprise getEnterpriseById(long id);

    Carrier getCarrierById(long id);

    EnterpriseBriefResponse getBriefById(long id);

    Collection<EnterpriseBriefResponse> getAllBriefs();


    Long getParentIdForCarrier(long carrierId);
}

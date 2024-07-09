package com.tuhf.project16.service;

import com.tuhf.project16.model.Carrier;
import com.tuhf.project16.model.Enterprise;
import com.tuhf.project16.model.Government;
import com.tuhf.project16.payload.response.EnterpriseBriefResponse;

import java.util.Collection;
import java.util.Map;

public interface IEntityService {

    int addEnterprise(Enterprise enterprise);

    int addCarrier(Carrier carrier);

    int addGovernment(Government government);


    int updateEnterprise(Enterprise enterprise);

    int updateCarrier(Carrier carrier);

    int updateEnterpriseAdditionalData(long id, String additionalData);


    Enterprise getEnterpriseById(long id);

    Carrier getCarrierById(long id);

    Government getGovernmentById(long id);

    Map<Long, String> getAllCarriersIdAndName();


    String getEnterpriseNameById(long id);

    String getCarrierNameById(long id);

    String getGovernmentNameById(long id);


    EnterpriseBriefResponse getEnterpriseBriefById(long id);

    Collection<EnterpriseBriefResponse> getAllEnterpriseBriefs();


    Long getParentIdForEnterprise(long enterpriseId);

    Long getParentIdForCarrier(long carrierId);
}

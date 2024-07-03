package com.tuhf.project16.service;

import com.tuhf.project16.model.Enterprise;

public interface IEnterpriseService {
    public int addEnterprise(Enterprise enterprise);

    public int updateEnterprise(Enterprise enterprise);

    public Enterprise getEnterpriseById(long id);

    //TODO brief
}

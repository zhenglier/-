package com.tuhf.project16.mapper;

import com.tuhf.project16.model.Enterprise;

public interface EnterpriseMapper {
    public int addEnterprise(Enterprise enterprise);

    public int updateEnterprise(Enterprise enterprise);

    public Enterprise getEnterpriseById(long id);

    //TODO brief
}

package com.tuhf.project16.mapper;

import com.tuhf.project16.model.TransOutApplication;

import java.util.Collection;

public interface TransApplicationMapper {
    public Collection<TransOutApplication> getAll();

    public TransOutApplication getById(long id);

    public Collection<TransOutApplication> getByCarrierId(long carrierId);

    public Collection<TransOutApplication> getByEnterpriseId(long enterpriseId);

    public int add(TransOutApplication transOutApplication);

    public Collection<TransOutApplication> getByStatus(String status);
}

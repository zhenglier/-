package com.tuhf.project16.mapper;

import com.tuhf.project16.model.TransInApplication;
import com.tuhf.project16.model.TransOutApplication;

import java.util.Collection;

public interface TransApplicationMapper {
    public Collection<TransOutApplication> getAll();

    public TransOutApplication getById(long id);

    public Collection<TransInApplication> getInByCarrierId(long carrierId);

    public Collection<TransOutApplication> getOutByCarrierId(long carrierId);

    public Collection<TransOutApplication> getByEnterpriseId(long enterpriseId);

    public int add(TransOutApplication transOutApplication);

    public Collection<TransOutApplication> getByStatus(String status);
}

package com.tuhf.project16.mapper;

import com.tuhf.project16.model.MoveApplication;

import java.util.Collection;

public interface MoveApplicationMapper {
    public Collection<MoveApplication> getAll();

    public MoveApplication getById(long id);

    public Collection<MoveApplication> getByCarrierId(long carrierId);

    public Collection<MoveApplication> getByEnterpriseId(long enterpriseId);

    public int add(MoveApplication moveApplication);

    public Collection<MoveApplication> getByStatus(String status);
}

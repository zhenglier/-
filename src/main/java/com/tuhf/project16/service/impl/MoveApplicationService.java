package com.tuhf.project16.service.impl;

import com.tuhf.project16.mapper.MoveApplicationMapper;
import com.tuhf.project16.model.TransOutApplication;
import com.tuhf.project16.service.ITransApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MoveApplicationService implements ITransApplicationService {

    @Autowired
    MoveApplicationMapper moveApplicationMapper;

    @Override
    public Collection<TransOutApplication> getAll() {
        return moveApplicationMapper.getAll();
    }

    @Override
    public TransOutApplication getById(long id) {
        return moveApplicationMapper.getById(id);
    }

    @Override
    public Collection<TransOutApplication> getByCarrierId(long carrierId) {
        return moveApplicationMapper.getByCarrierId(carrierId);
    }

    @Override
    public Collection<TransOutApplication> getByEnterpriseId(long enterpriseId) {
        return moveApplicationMapper.getByEnterpriseId(enterpriseId);
    }

    @Override
    public int add(TransOutApplication transOutApplication) {
        return moveApplicationMapper.add(transOutApplication);
    }

    @Override
    public Collection<TransOutApplication> getByStatus(String status) {
        return moveApplicationMapper.getByStatus(status);
    }
}

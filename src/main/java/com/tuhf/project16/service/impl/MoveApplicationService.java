package com.tuhf.project16.service.impl;

import com.tuhf.project16.mapper.MoveApplicationMapper;
import com.tuhf.project16.model.MoveApplication;
import com.tuhf.project16.service.IMoveApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MoveApplicationService implements IMoveApplicationService {

    @Autowired
    MoveApplicationMapper moveApplicationMapper;

    @Override
    public Collection<MoveApplication> getAll() {
        return moveApplicationMapper.getAll();
    }

    @Override
    public MoveApplication getById(long id) {
        return moveApplicationMapper.getById(id);
    }

    @Override
    public Collection<MoveApplication> getByCarrierId(long carrierId) {
        return moveApplicationMapper.getByCarrierId(carrierId);
    }

    @Override
    public Collection<MoveApplication> getByEnterpriseId(long enterpriseId) {
        return moveApplicationMapper.getByEnterpriseId(enterpriseId);
    }

    @Override
    public int add(MoveApplication moveApplication) {
        return moveApplicationMapper.add(moveApplication);
    }

    @Override
    public Collection<MoveApplication> getByStatus(String status) {
        return moveApplicationMapper.getByStatus(status);
    }
}

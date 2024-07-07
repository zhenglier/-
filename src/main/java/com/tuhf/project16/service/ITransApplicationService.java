package com.tuhf.project16.service;

import com.tuhf.project16.model.TransInApplication;
import com.tuhf.project16.model.TransOutApplication;

import java.util.Collection;

public interface ITransApplicationService {
    public int addTransOutApplication(TransOutApplication transOutApplication);
    public int addTransInApplication(TransInApplication transInApplication);

    public Collection<TransOutApplication> getAll();

    public TransOutApplication getById(long id);

    public Collection<TransOutApplication> getByCarrierId(long carrierId);

    public Collection<TransOutApplication> getByEnterpriseId(long enterpriseId);

    public int add(TransOutApplication transOutApplication);

    public Collection<TransOutApplication> getByStatus(String status);
}

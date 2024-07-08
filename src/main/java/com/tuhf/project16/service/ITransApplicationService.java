package com.tuhf.project16.service;

import com.tuhf.project16.model.TransInApplication;
import com.tuhf.project16.model.TransOutApplication;

import java.util.Collection;

public interface ITransApplicationService {
    public int addTransOutApplication(TransOutApplication transOutApplication);

    public int addTransInApplication(TransInApplication transInApplication);

    public Collection<TransInApplication> getInByCarrierId(long carrierId);

    public Collection<TransOutApplication> getOutByCarrierId(long carrierId);
}

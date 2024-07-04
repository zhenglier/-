package com.tuhf.project16.service;

import com.tuhf.project16.model.PerformanceAppraisalApplicationItem;
import com.tuhf.project16.model.PerformanceAppraisalItem;
import com.tuhf.project16.model.PerformanceAppraisalTemplate;
import com.tuhf.project16.model.PerformanceExamineItem;
import com.tuhf.project16.payload.response.PerformanceExamineItemResponse;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public interface PerformanceService {
    public void addPerformanceAppraisalTemplate(PerformanceAppraisalTemplate performanceAppraisalTemplate);
    public void addPerformanceAppraisalItem(PerformanceAppraisalItem performanceAppraisalItem);
    public PerformanceAppraisalTemplate getPerformanceAppraisalTemplateByID(int PATid);
    public void addPerformanceAppraisalApplicationItem(PerformanceAppraisalApplicationItem performanceAppraisalApplicationItem);
    public ArrayList<PerformanceAppraisalApplicationItem>getPerformanceAppraisalApplicationItemsByTime(int PAIid,Date date);
    public ArrayList<PerformanceAppraisalApplicationItem>getPerformanceAppraisalApplicationItemsByContainer(int PAIid,int Cid );
    public ArrayList<PerformanceExamineItem> getPerformanceAppraisalApplicationItemsByPAIid(int PAIid );

}

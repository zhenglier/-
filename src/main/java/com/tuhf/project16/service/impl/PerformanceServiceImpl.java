package com.tuhf.project16.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tuhf.project16.mapper.PerformanceAppraisalApplicationItemMapper;
import com.tuhf.project16.mapper.PerformanceAppraisalItemMapper;
import com.tuhf.project16.mapper.PerformanceAppraisalTemplateMapper;
import com.tuhf.project16.model.PerformanceAppraisalApplicationItem;
import com.tuhf.project16.model.PerformanceAppraisalItem;
import com.tuhf.project16.model.PerformanceAppraisalTemplate;
import com.tuhf.project16.model.PerformanceExamineItem;
import com.tuhf.project16.payload.response.PerformanceExamineItemResponse;
import com.tuhf.project16.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PerformanceServiceImpl implements PerformanceService {

    @Autowired
    PerformanceAppraisalItemMapper performanceAppraisalItemMapper;
    @Autowired
    PerformanceAppraisalTemplateMapper performanceAppraisalTemplateMapper;
    @Autowired
    PerformanceAppraisalApplicationItemMapper performanceAppraisalApplicationItemMapper;
    @Override
    public void addPerformanceAppraisalTemplate(PerformanceAppraisalTemplate performanceAppraisalTemplate) {

        performanceAppraisalTemplateMapper.insert(performanceAppraisalTemplate);
    }

    @Override
    public void addPerformanceAppraisalItem(PerformanceAppraisalItem performanceAppraisalItem) {
        performanceAppraisalItemMapper.insert(performanceAppraisalItem);
    }

    @Override
    public PerformanceAppraisalTemplate getPerformanceAppraisalTemplateByID(int PATid) {
        LambdaQueryWrapper<PerformanceAppraisalTemplate> lqw = new LambdaQueryWrapper<PerformanceAppraisalTemplate>();
        lqw.eq(PerformanceAppraisalTemplate::getId, PATid);
        PerformanceAppraisalTemplate PAT = performanceAppraisalTemplateMapper.selectOne(lqw);
        System.out.println(PAT);
        return PAT;
    }

    @Override
    public void addPerformanceAppraisalApplicationItem(PerformanceAppraisalApplicationItem performanceAppraisalApplicationItem) {
        performanceAppraisalApplicationItemMapper.insert(performanceAppraisalApplicationItem);
    }

    @Override
    public ArrayList<PerformanceAppraisalApplicationItem> getPerformanceAppraisalApplicationItemsByTime(int PAIid, Date date) {
        return null;
    }

    @Override
    public ArrayList<PerformanceAppraisalApplicationItem> getPerformanceAppraisalApplicationItemsByContainer(int PAIid, int Cid) {
        return null;
    }

    @Override
    public ArrayList<PerformanceExamineItem> getPerformanceAppraisalApplicationItemsByPAIid(int PAIid) {
//        Map<String, Object> PAAImap = new HashMap<>();
//        PAAImap.put("pf_item_id", PAIid);
//        List<PerformanceAppraisalApplicationItem> PAAIList = performanceAppraisalApplicationItemMapper.selectByMap(PAAImap);
        LambdaQueryWrapper<PerformanceAppraisalApplicationItem> lqw = new LambdaQueryWrapper<PerformanceAppraisalApplicationItem>();
        lqw.eq(PerformanceAppraisalApplicationItem::getPf_item_id, PAIid);
        List<PerformanceAppraisalApplicationItem> PAAIList = performanceAppraisalApplicationItemMapper.selectList(lqw);
        ArrayList<PerformanceExamineItem>PEIRList=new ArrayList<>();
        for(int i=0;i<PAAIList.size();i++){
            PerformanceExamineItem p=new PerformanceExamineItem();
            PerformanceAppraisalApplicationItem PAAI=PAAIList.get(i);
            LambdaQueryWrapper<PerformanceAppraisalItem> lqw1 = new LambdaQueryWrapper<PerformanceAppraisalItem>();
            lqw1.eq(PerformanceAppraisalItem::getId,PAAI.getPf_item_id());
            PerformanceAppraisalItem PAI = performanceAppraisalItemMapper.selectOne(lqw1);
            p.setPf_name(PAI.getName());
            p.setEnd_date(PAI.getEnd_date());
            p.setCarrier_name(PAAI.getCarrier_name());
            p.setScore(PAAI.getScore());
            PEIRList.add(p);
        }
        return PEIRList;
    }
}

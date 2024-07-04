package com.tuhf.project16.controller;

import com.tuhf.project16.model.PerformanceExamineItem;
import com.tuhf.project16.payload.request.PerformanceExamineRequest;
import com.tuhf.project16.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/user/performance")//点击填写后的Map
public class PerformanceExamineController {
    @Autowired
    PerformanceService performanceService;
    @PostMapping("/PerformanceExamine")
    public ArrayList<PerformanceExamineItem> PerformanceExamine(@RequestBody PerformanceExamineRequest performanceExamineRequest){
       return performanceService.getPerformanceAppraisalApplicationItemsByPAIid(performanceExamineRequest.pf_item_id());
    }
}

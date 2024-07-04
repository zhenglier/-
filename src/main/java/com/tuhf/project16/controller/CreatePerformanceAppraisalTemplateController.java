package com.tuhf.project16.controller;

import com.tuhf.project16.model.PerformanceAppraisalItem;
import com.tuhf.project16.model.PerformanceAppraisalTemplate;
import com.tuhf.project16.payload.request.createPfRequest;
import com.tuhf.project16.payload.request.createPfTemplateRequest;
import com.tuhf.project16.payload.response.MessageResponse;
import com.tuhf.project16.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/performance")//创建绩效模板Map
public class CreatePerformanceAppraisalTemplateController {
    @Autowired
    PerformanceService performanceService;
    @PostMapping(value = "/CreatePfTemplate")
    public ResponseEntity<?> createTemplate(@RequestBody createPfTemplateRequest createPfTemplateRequest){
        PerformanceAppraisalTemplate performanceAppraisalTemplate=new PerformanceAppraisalTemplate(createPfTemplateRequest.id(),createPfTemplateRequest.name(),createPfTemplateRequest.json_data());
        performanceService.addPerformanceAppraisalTemplate(performanceAppraisalTemplate);
        return ResponseEntity.ok().body(
                new MessageResponse("Create successfully!"));
    }
    @PostMapping(value = "/CreatePf")
    public ResponseEntity<?> createPf(@RequestBody createPfRequest createPfRequest){
        PerformanceAppraisalItem performanceAppraisalItem=new PerformanceAppraisalItem(createPfRequest.id(),createPfRequest.template_id(),createPfRequest.name(),createPfRequest.type(),createPfRequest.begin_date(),createPfRequest.end_date(),createPfRequest.performance_year(),createPfRequest.description());
        performanceService.addPerformanceAppraisalItem(performanceAppraisalItem);
        return ResponseEntity.ok().body(
                new MessageResponse("Create successfully!"));
    }
}

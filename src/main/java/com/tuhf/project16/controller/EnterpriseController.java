package com.tuhf.project16.controller;

import com.tuhf.project16.model.Enterprise;
import com.tuhf.project16.model.MoveApplication;
import com.tuhf.project16.payload.response.MessageResponse;
import com.tuhf.project16.service.IEnterpriseService;
import com.tuhf.project16.service.IMoveApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/etp")
public class EnterpriseController {

    @Autowired
    IEnterpriseService enterpriseService;

    @Autowired
    IMoveApplicationService moveApplicationService;

    @PostMapping("/")
    public ResponseEntity<?> addEnterprise(@RequestBody Enterprise enterprise) {
        enterpriseService.addEnterprise(enterprise);
        return ResponseEntity.ok().body(enterprise);
    }

    @PostMapping("/edit")
    public ResponseEntity<?> editEnterprise(@RequestBody Enterprise enterprise) {
        if (enterprise.getId() == null) {
            return ResponseEntity.badRequest().body(new MessageResponse("id needed!"));
        }
        int rows = enterpriseService.updateEnterprise(enterprise);
        if (rows == 0) {
            return ResponseEntity.badRequest().body(new MessageResponse("nothing changed."));
        }
        enterprise = enterpriseService.getEnterpriseById(enterprise.getId());
        return ResponseEntity.ok().body(enterprise);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEnterprise(@PathVariable long id) {
        Enterprise enterprise = enterpriseService.getEnterpriseById(id);
        return ResponseEntity.ok().body(enterprise);
    }

    @GetMapping("/brief")
    public ResponseEntity<?> getAllBriefs() {
        return ResponseEntity.ok().body(enterpriseService.getAllBriefs());
    }

    @GetMapping("/brief/{id}")
    public ResponseEntity<?> getBriefById(@PathVariable long id) {
        return ResponseEntity.ok().body(enterpriseService.getBriefById(id));
    }

    @PostMapping("/move")
    public ResponseEntity<?> move(@RequestBody MoveApplication moveApplication) {
        return ResponseEntity.ok().body(moveApplication);
    }
}

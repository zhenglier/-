package com.tuhf.project16.controller;

import com.tuhf.project16.model.Policy;
import com.tuhf.project16.service.IPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class PolicyController {

    @Autowired
    IPolicyService policyService;

    @PostMapping("/policy")
    public ResponseEntity<?> addPolicy(@RequestBody Policy policy) {
        policyService.addPolicy(policy);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/policy/{id}")
    public ResponseEntity<?> getPolicy(@PathVariable long id) {
        return ResponseEntity.ok(policyService.getPolicyById(id));
    }
}

package com.tuhf.project16.controller;

import com.tuhf.project16.model.Policy;
import com.tuhf.project16.payload.response.PolicyBriefResponse;
import com.tuhf.project16.service.IPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class PolicyController {

    @Autowired
    IPolicyService policyService;

    @PostMapping("/policy")
    public ResponseEntity<?> addPolicy(@RequestBody Policy policy) {
        policyService.addPolicy(policy);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/policy/{id}")
    public ResponseEntity<?> getPolicyById(@PathVariable long id) {
        policyService.increaseClicks(id);
        return ResponseEntity.ok(policyService.getPolicyById(id));
    }

    @RequestMapping(value = "/policy", method = RequestMethod.GET, params = {"tag"})
    public ResponseEntity<?> getPoliciesByTags(@RequestParam Map<String, String> params) {
        Collection<Policy> policies = policyService.getPoliciesByTags(params.values());
        return ResponseEntity.ok().body(policies);
    }

    @GetMapping("/policy")
    public ResponseEntity<?> getAllPolicies() {
            Collection<Policy> policies = policyService.getAllPolicies();
            return ResponseEntity.ok().body(policies);
    }

    @RequestMapping(value = "/policy/brief", method = RequestMethod.GET, params = {"tag"})
    public ResponseEntity<?> getBriefsByTags(@RequestParam Map<String, String> params) {
        PolicyBriefResponse policies = policyService.getBriefByTags(params.values());
        return ResponseEntity.ok().body(policies);
    }

    @RequestMapping(value = "/policy/brief", method = RequestMethod.GET, params = {"page"})
    public ResponseEntity<?> getBriefsByPage(@RequestParam Map<String, String> params) {
        Collection<PolicyBriefResponse> policies = policyService.getBriefsByPage(Integer.parseInt(params.get("page")));
        return ResponseEntity.ok().body(policies);
    }

    @GetMapping("/policy/brief")
    public ResponseEntity<?> getAllBriefs() {
        Collection<PolicyBriefResponse> policies = policyService.getAllBriefs();
        return ResponseEntity.ok().body(policies);
    }
}

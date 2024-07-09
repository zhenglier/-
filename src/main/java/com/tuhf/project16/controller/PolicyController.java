package com.tuhf.project16.controller;

import com.tuhf.project16.model.Government;
import com.tuhf.project16.model.Policy;
import com.tuhf.project16.payload.response.MessageResponse;
import com.tuhf.project16.payload.response.PolicyBriefResponse;
import com.tuhf.project16.service.IEntityService;
import com.tuhf.project16.service.ILoginUserService;
import com.tuhf.project16.service.IPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/policy")
@CrossOrigin("*")
@PreAuthorize("hasAnyAuthority('enterprise', 'carrier', 'enterprise')")
public class PolicyController {

    @Autowired
    IPolicyService policyService;

    @Autowired
    IEntityService entityService;

    @Autowired
    ILoginUserService loginUserService;

    @PreAuthorize("hasAuthority('government')")
    @PostMapping("/")
    public MessageResponse addPolicy(@RequestBody Policy policy) {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Government gov = entityService.getGovernmentById(loginUserService.getEntityIdByUsername(username));
        policy.setIssuerId(gov.getId());
        policy.setIssuerName(gov.getName());
        policyService.addPolicy(policy);
        return new MessageResponse("Policy added successfully");
    }

    @GetMapping("/{id}")
    public Policy getPolicyById(@PathVariable long id) {
        policyService.increaseClicks(id);  // 点击量
        return policyService.getPolicyById(id);
    }

    /*
    @RequestMapping(value = "/", method = RequestMethod.GET, params = {"tag"})
    public Collection<Policy> getPoliciesByTags(@RequestParam Map<String, String> params) {
        Collection<Policy> policies = policyService.getPoliciesByTags(params.values());
        return policies;
    }

    @GetMapping("/")
    public Collection<Policy> getAllPolicies() {
        Collection<Policy> policies = policyService.getAllPolicies();
        return policies;
    }
    */

    /* 按标签获取概要，只要包含tag标签就触发，所有请求参数都会被当作标签 */
    @RequestMapping(value = "/brief", method = RequestMethod.GET, params = {"tag"})
    public Collection<PolicyBriefResponse> getBriefsByTags(@RequestParam Map<String, String> params) {
        Collection<PolicyBriefResponse> policies = policyService.getBriefsByTags(params.values());
        return policies;
    }

    /* 按页获取概要 */
    @RequestMapping(value = "/brief", method = RequestMethod.GET, params = {"page"})
    public Collection<PolicyBriefResponse> getBriefsByPage(@RequestParam Map<String, String> params) {
        Collection<PolicyBriefResponse> policies = policyService.getBriefsByPage(Integer.parseInt(params.get("page")));
        return policies;
    }

    @GetMapping("/brief")
    public Collection<PolicyBriefResponse> getAllBriefs() {
        Collection<PolicyBriefResponse> policies = policyService.getAllBriefs();
        return policies;
    }

    // TODO: 排序
}

package com.tuhf.project16.controller;

import com.tuhf.project16.model.PerfApplication;
import com.tuhf.project16.model.PerfItem;
import com.tuhf.project16.model.PerfReview;
import com.tuhf.project16.model.PerfTemplate;
import com.tuhf.project16.payload.response.MessageResponse;
import com.tuhf.project16.service.IEntityService;
import com.tuhf.project16.service.ILoginUserService;
import com.tuhf.project16.service.IPerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
//@RequestMapping("/user/performance")
@RequestMapping("/performance")
//@PreAuthorize("hasAuthority('carrier') or hasAuthority('government')")
public class PerformanceController {

    @Autowired
    IPerformanceService performanceService;

    @Autowired
    ILoginUserService loginUserService;

    @Autowired
    IEntityService entityService;

    /**
     * 载体端：获取本载体所属政务端发布的考核项
     */
    @PreAuthorize("hasAuthority('carrier')")
    @GetMapping("/item")
    public ResponseEntity<?> getItemsForCarrier() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok().body(
                performanceService.getItemsByIssuerId(
                        entityService.getParentIdForCarrier(loginUserService.getIdByUsername(username)))
        );
    }
    /**
     * 载体端：提交考核表单
     * @param perfApplication
     * @return 消息
     */
    @PreAuthorize("hasAuthority('carrier')")
    @PostMapping("/commit")
    public ResponseEntity<?> commitItem(@RequestBody PerfApplication perfApplication){
        performanceService.addApplication(perfApplication);
        return ResponseEntity.ok().body(
                new MessageResponse("Commit successfully!"));
    }

    /**
     * 载体端：获取绩效模板
     * @param id 模板id
     * @return PerfTemplate
     */
    @PreAuthorize("hasAuthority('carrier')")
    @GetMapping("/template/{id}")
    public ResponseEntity<?> getTemplate(@PathVariable long id) {
        return ResponseEntity.ok().body(
                performanceService.getTemplateById(id)
        );
    }

    /**
     * 载体端：查看本端的所有申请项目
     */
    @PreAuthorize("hasAuthority('carrier')")
    @GetMapping("/app")
    public ResponseEntity<?> getMyAppsForCarrier() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok().body(
                performanceService.getApplicationByCarrierId(loginUserService.getIdByUsername(username))
        );
    }

    /**
     * 载体端：查看本端的所有审批结果
     */
    @PreAuthorize("hasAuthority('carrier')")
    @GetMapping("/review/crr")
    public ResponseEntity<?> getMyReviewsForCarrier() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok().body(
                performanceService.getReviewsForCarrier(loginUserService.getIdByUsername(username))
        );
    }

    /**
     *政务端：获取所有模板
     * @return Collection of PerfTemplate
     */
    @PreAuthorize("hasAuthority('government')")
    @GetMapping("/template")
    public ResponseEntity<?> getAllTemplates() {
        return ResponseEntity.ok().body(
                performanceService.getAllTemplates()
        );
    }

    /**
     * 政务端：发布考核表单模板
     * @param template
     * @return 消息
     */
    @PreAuthorize("hasAuthority('government')")
    @PostMapping("/template")
    public ResponseEntity<?> createTemplate(@RequestBody PerfTemplate template){
        performanceService.addTemplate(template);
        return ResponseEntity.ok().body(
                new MessageResponse("Create successfully!"));
    }

    /**
     * 政务端：发布一次考核
     * @param item
     * @return 消息
     */
    @PreAuthorize("hasAuthority('government')")
    @PostMapping("/issue")
    public ResponseEntity<?> issuePerf(@RequestBody PerfItem item){
        performanceService.addItem(item);
        return ResponseEntity.ok().body(
                new MessageResponse("Successfully issued!"));
    }

    /**
     * 政务端：添加添加审核结果
     */
    @PreAuthorize("hasAuthority('government')")
    @PostMapping("/review")
    public ResponseEntity<?> addReview(@RequestBody PerfReview review){
        performanceService.addReview(review);
        return ResponseEntity.ok().body(
                new MessageResponse("Successfully added review!")
        );
    }

    /**
     * 政务端：查看需要本端审批的审核条目
     * @return
     */
    @PreAuthorize("hasAuthority('government')")
    @GetMapping("/review/gov")
    public ResponseEntity<?> getMyReviewsForIssuer() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok().body(
            performanceService.getReviewsForGov(loginUserService.getIdByUsername(username))
        );
    }

    /**
     * 根据申请项获取当前申请项的审核结果
     * @param appId 申请项id
     * @return
     */
    @PreAuthorize("hasAnyAuthority('government', 'carrier')")
    @GetMapping("/review/{id}")
    public ResponseEntity<?> reviewPerf(@RequestParam long appId){
        return ResponseEntity.ok().body(
                performanceService.getReviewByAppId(appId)
        );
    }

}

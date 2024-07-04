package com.tuhf.project16.controller;


import com.tuhf.project16.mapper.ProgramMapper;
import com.tuhf.project16.model.ProgramApplication;
import com.tuhf.project16.model.ProgramReview;
import com.tuhf.project16.model.ProgramTemplate;
import com.tuhf.project16.payload.request.AddProgramApplicationRequest;
import com.tuhf.project16.payload.request.AddProgramReviewRequest;
import com.tuhf.project16.payload.request.AddProgramTemplateRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author 30805
 */
@RestController
@RequestMapping("/api/program")
public class ProgramController {

    @Autowired
    ProgramMapper programMapper;

    @PostMapping("template/add")
    @PreAuthorize("hasAnyAuthority('enterprise','carrier','government')")
    public ResponseEntity<?> addProgramTemplate(@RequestBody AddProgramTemplateRequest addProgramTemplateRequest) {
        try {
            programMapper.addProgramTemplate(new ProgramTemplate(addProgramTemplateRequest));
            return ResponseEntity.ok("Add program template successful!");
        }catch (Exception e) {
            return ResponseEntity.ok("Add program template failed!");
        }
    }

    @GetMapping("template/query")
    @PreAuthorize("hasAnyAuthority('enterprise','carrier','government')")
    public ResponseEntity<?> getTemplateById(@RequestParam(value = "id") Long id) {
        return ResponseEntity.ok(programMapper.getProgramTemplateById(id));
    }

    @GetMapping("application/query")
    @PreAuthorize("hasAnyAuthority('enterprise','carrier','government')")
    public ResponseEntity<?> getApplicationById(@RequestParam(value = "id",defaultValue = "-1") Long id,
                                                @RequestParam(value = "sourceId",defaultValue = "-1") Long sourceId,
                                                @RequestParam(value = "sourceType",defaultValue = "-1") int sourceType,
                                                @RequestParam(value = "destinationId",defaultValue = "-1") Long destinationId,
                                                @RequestParam(value = "destinationType",defaultValue = "-1") int destinationType) {
        if(id!=-1) {
            return ResponseEntity.ok(programMapper.getProgramApplicationById(id));
        }else{
            return ResponseEntity.ok(programMapper.getProgramApplications(sourceId,sourceType,destinationId,destinationType));
        }
    }

    @PostMapping("application/add")
    @PreAuthorize("hasAnyAuthority('enterprise','carrier','government')")
    public ResponseEntity<?> addApplication(@RequestBody AddProgramApplicationRequest addProgramApplicationRequest){
        programMapper.addProgramApplication(new ProgramApplication(addProgramApplicationRequest));
        return ResponseEntity.ok("Add program application successful!");
    }

    @PostMapping("review/add")
    @PreAuthorize("hasAnyAuthority('enterprise','carrier','government')")
    public ResponseEntity<?> addReview(@RequestBody AddProgramReviewRequest addProgramReviewRequest){
        programMapper.addProgramReview(new ProgramReview(addProgramReviewRequest));
        return ResponseEntity.ok("Add program review successful!");
    }

    @GetMapping("review/query")
    @PreAuthorize("hasAnyAuthority('enterprise','carrier','government')")
    public ResponseEntity<?> getReviewById(@RequestParam Long id){
        return ResponseEntity.ok(programMapper.getProgramReviewById(id));
    }

}

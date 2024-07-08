package com.tuhf.project16.controller;

import com.tuhf.project16.model.File;
import com.tuhf.project16.payload.response.MessageResponse;
import com.tuhf.project16.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
//@PreAuthorize("hasAnyAuthority('enterprise', 'carrier', 'government')")
@CrossOrigin("*")
@RequestMapping("/file")
public class FileController {

    @Autowired
    IFileService fileService;

    @PostMapping("/upload")
    public MessageResponse upload(@RequestBody MultipartFile file) {
        fileService.upload(file);
        return new MessageResponse("Success");
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> download(@RequestParam String hash, @RequestParam Long id) {
        File file =  fileService.download(id, hash);
        ByteArrayResource resource = new ByteArrayResource(file.getData());
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName());

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.getData().length)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }
}

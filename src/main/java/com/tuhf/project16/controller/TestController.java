package com.tuhf.project16.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@RestController
@RequestMapping("/test")
@CrossOrigin("*")
public class TestController {
    @GetMapping("/etp")
    @PreAuthorize("hasAuthority('enterprise')")
    public String enterprise() {
        return "Hello, Enterprise user.";
    }
    @GetMapping("/crr")
    @PreAuthorize("hasAuthority('carrier')")
    public String carrier() {
        return "Hello, Carrier user.";
    }
    @GetMapping("/gov")
    @PreAuthorize("hasAuthority('government')")
    public String government() {
        return "Hello, Government user.";
    }

    @PostMapping("/test")
    public String test(@RequestParam Map<String,MultipartFile> file) throws IOException {
        String name=file.keySet().iterator().next();
        System.out.println(name);
        System.out.println(new String(FileCopyUtils.copyToByteArray(file.get(name).getInputStream()), StandardCharsets.UTF_8));
        return null;
    }
}

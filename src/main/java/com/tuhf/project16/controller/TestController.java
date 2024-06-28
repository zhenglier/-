package com.tuhf.project16.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
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
}

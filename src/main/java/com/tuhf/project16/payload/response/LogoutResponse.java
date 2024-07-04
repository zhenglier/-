package com.tuhf.project16.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * @author 30805
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogoutResponse {
    int code;
    String message;
}

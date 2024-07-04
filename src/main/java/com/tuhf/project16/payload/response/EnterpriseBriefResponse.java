package com.tuhf.project16.payload.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnterpriseBriefResponse {
    private Long id;

    private String name;

    private String address;

    private String carrierId;

    private String carrierName;

    private String industry;

    private String status;
}

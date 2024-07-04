package com.tuhf.project16.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enterprise {
    private Long id;

    private String name;

    private String creditCode;

    private Integer registeredCapital;

    private String address;

    private String business;

    private String type;

    private String industry;

    private Date registerAt;

    private Date enterAt;

    private String operatorName;

    private String contactName;

    private String contactPhone;

    private String bank;

    private String bankAccount;

    private Long carrierId;

    private String carrierName;

    private String status;

    private String juridicalName;

    private String juridicalPhone;

    private String juridicalEmail;

    private String logo;

    private String additionalData;

    private String material;
}

package com.tuhf.project16.model;

import com.tuhf.project16.payload.request.TransInRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enterprise {
    public static final int DELETED = 0;
    public static final int NORMAL = 1;
    public static final int PRE_IN = 2;
    public static final int PRE_OUT = 3;
    public static final int INFO = 4;

    private Long id;

    private Long carrierId;

    private String name;

    private String creditCode;

    private Integer registeredCapital;

    private String address;

    private String business;

    private String type;

    private String industry;

    private Date registerAt;

    private Date transInAt;

    private String additionalData;

    private String operatorName;

    /*
    private String contactName;

    private String contactPhone;

    private String bank;

    private String bankAccount;


    private String carrierName;

    private String status;

    private String juridicalName;

    private String juridicalPhone;

    private String juridicalEmail;

    private String logo;

    private String material;
    */

    private String status;

    /* 正常1 预入驻2 预搬离3 信息载体4 删除 0 */
//    private int sysStatus;

    public Enterprise(TransInApplication application) {
        this.carrierId = application.getCarrierId();
        this.name = application.getName();
        this.creditCode = application.getCreditCode();
        this.registeredCapital = application.getRegisteredCapital();
        this.address = application.getAddress();
        this.business = application.getBusiness();
        this.type = application.getType();
        this.registerAt = application.getRegisterAt();
        this.additionalData = application.getAdditionalData();
        this.status = "预设状态";

//        this.sysStatus = PRE_IN;
    }
}

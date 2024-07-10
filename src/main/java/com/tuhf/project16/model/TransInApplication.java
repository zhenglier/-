package com.tuhf.project16.model;

import com.tuhf.project16.payload.request.TransInRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransInApplication {
    private Long id;

    private Long userId;

    private String name;

    private Long carrierId;

    private String creditCode;

    private Integer registeredCapital;

    private String address;

    /* 主营业务 */
    private String business;

    /* 企业性质 */
    private String type;

//        String industry;

    /* 注册时间 */
    private Date registerAt;

    /* 认证情况，用下划线分割 */
    private String certification;

    /* JSON */
    private String additionalData;

    private String status;

    private Date createAt;

    public TransInApplication(TransInRequest request) {
        this.name = request.name();
        this.carrierId = request.carrierId();
        this.creditCode = request.creditCode();
        this.registeredCapital = request.registeredCapital();
        this.address = request.address();
        this.business = request.business();
        this.type = request.type();
        this.registerAt = request.registerAt();
        this.certification = request.certification();
        this.additionalData = request.additionalData();
        this.status = "待审批";
    }
}

package com.tuhf.project16.payload.request;

import java.util.Date;

public record TransInRequest(

        String name,

        Long carrierId,

        String creditCode,

        Integer registeredCapital,

        String address,

        /* 主营业务 */
        String business,

        /* 企业性质 */
        String type,

//        String industry,

        /* 注册时间 */
        Date registerAt,

        /* 认证情况，用下划线分割 */
        String certification,

        /* JSON */
        String additionalData

){
}

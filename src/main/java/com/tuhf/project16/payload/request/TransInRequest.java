package com.tuhf.project16.payload.request;

import java.util.Date;

public record TransInRequest(

        String name,

        Long carrierId,

        String creditCode,

        Integer registeredCapital,

        /* 注册地址 */
        String address,

        /* 主营业务 */
        String business,

        /* 企业性质 */
        String type,

//        String industry,

        /* 注册时间 */
        Date registerAt,

        /*
        认证情况，用下划线分割
        如 “高企_科技小巨人”
        */
        String certification,

        /* JSON，上面没有的所有其他字段都放这里 */
        String additionalData

){
}

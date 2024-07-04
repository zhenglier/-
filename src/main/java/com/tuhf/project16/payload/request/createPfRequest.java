package com.tuhf.project16.payload.request;

import java.sql.Date;

public record createPfRequest( int id,
         int template_id,
        //basicInfo
         String name,
         String type,
         Date begin_date,
         Date end_date,
         String performance_year,
         String description) {
}

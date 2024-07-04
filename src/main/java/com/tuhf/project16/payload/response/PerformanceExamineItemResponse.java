package com.tuhf.project16.payload.response;

import java.sql.Date;

public record PerformanceExamineItemResponse(String pf_name, String carrier_name, Date end_date, int score) {
}

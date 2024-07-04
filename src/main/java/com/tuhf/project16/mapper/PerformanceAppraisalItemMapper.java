package com.tuhf.project16.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tuhf.project16.model.PerformanceAppraisalItem;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PerformanceAppraisalItemMapper  extends BaseMapper<PerformanceAppraisalItem> {
}

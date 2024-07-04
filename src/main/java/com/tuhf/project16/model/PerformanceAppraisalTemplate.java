package com.tuhf.project16.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@TableName("pf_template")
public class PerformanceAppraisalTemplate implements Serializable {//绩效考察模板
  @TableId
  private int id;
  private String name;
  private String json_data;

  public PerformanceAppraisalTemplate(int id, String name, String json_data) {
    this.id = id;
    this.name = name;
    this.json_data = json_data;
  }
}

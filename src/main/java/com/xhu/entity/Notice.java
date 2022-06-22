package com.xhu.entity;


import com.alibaba.druid.filter.AutoLoad;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {

  private Integer id;
  private String title;
  private String content;
  private String recept_role;
  private String sendtime;

}

package com.xhu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

  private Integer id;
  private String teacherId;
  private String teacherName;
  private Integer sex;
  private Timestamp birthday;
  private String grade;
  private String rank;
  private Timestamp jobDate;
  private String college;
  private String password;
  private String phone;
  private Integer roleId;
  private String jobsign;
  private Integer status;

}

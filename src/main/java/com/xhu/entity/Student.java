package com.xhu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

  private Integer id;
  private String studentId;
  private String studentName;
  private Timestamp birthday;
  private String phone;
  private String email;
  private String address;
  private String note;
  private Integer status;
  private String level;
  private Timestamp createTime;
  private Integer roleId;
  private Integer sex;
  private String password;

}

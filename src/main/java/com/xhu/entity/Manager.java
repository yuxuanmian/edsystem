package com.xhu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {

  private Integer id;
  private String managerId;
  private String managerName;
  private String password;
  private String nickName;
  private Integer roleId;
  private String roleName;
  private Integer sex;
  private String phone;
  private String email;

}

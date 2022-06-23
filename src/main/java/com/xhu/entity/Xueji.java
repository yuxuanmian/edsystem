package com.xhu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Xueji {

  private Integer searchId;
  private Integer id;
  private String username;
  private Integer sex;
  private String phone;
  private String email;
  private String address;
  private String xuejixinxi;

}

package com.xhu.entity;


public class Xueji {

  private Integer id;
  private String username;
  private int sex;
  private String phone;
  private String email;
  private String address;
  private String xuejixinxi;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public int getSex() {
    return sex;
  }

  public void setSex(int sex) {
    this.sex = sex;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }



  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "Xueji{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", sex=" + sex +
            ", phone='" + phone + '\'' +
            ", email='" + email + '\'' +
            ", address='" + address + '\'' +
            ", xuejixinxi='" + xuejixinxi + '\'' +
            '}';
  }

  public String getXuejixinxi() {
    return xuejixinxi;
  }

  public void setXuejixinxi(String xuejixinxi) {
    this.xuejixinxi = xuejixinxi;
  }

}

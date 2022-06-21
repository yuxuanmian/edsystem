package com.xhu.entity;

public class Manager {

  private int id;
  private String managerId;
  private String managerName;
  private String password;
  private String nickName;
  private int roleId;
  private String roleName;
  private int sex;
  private String phone;
  private String email;

  public Manager() {
  }

  public Manager(int id, String managerId, String managerName, String password, String nickName, int roleId, String roleName, int sex, String phone, String email) {
    this.id = id;
    this.managerId = managerId;
    this.managerName = managerName;
    this.password = password;
    this.nickName = nickName;
    this.roleId = roleId;
    this.roleName = roleName;
    this.sex = sex;
    this.phone = phone;
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getManagerId() {
    return managerId;
  }

  public void setManagerId(String managerId) {
    this.managerId = managerId;
  }

  public String getManagerName() {
    return managerName;
  }

  public void setManagerName(String managerName) {
    this.managerName = managerName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public int getRoleId() {
    return roleId;
  }

  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public int getSex() {
    return sex;
  }

  public void setSex(int sex) {
    this.sex = sex;
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

  @Override
  public String toString() {
    return "Manager{" +
            "id=" + id +
            ", managerId='" + managerId + '\'' +
            ", managerName='" + managerName + '\'' +
            ", password='" + password + '\'' +
            ", nickName='" + nickName + '\'' +
            ", roleId=" + roleId +
            ", roleName='" + roleName + '\'' +
            ", sex=" + sex +
            ", phone='" + phone + '\'' +
            ", email='" + email + '\'' +
            '}';
  }
}

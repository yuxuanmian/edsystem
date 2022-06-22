package com.xhu.entity;

import java.sql.Timestamp;

public class Student {

  private Integer id;
  private String studentId;
  private String studentName;
  private Timestamp birthday;
  private String phone;
  private String email;
  private String address;
  private String note;
  private int status;
  private String level;
  private Timestamp createTime;
  private int roleId;
  private int sex;
  private String password;

  public Student(int id, String studentId, String studentName, Timestamp birthday, String phone, String email, String address, String note, int status, String level, Timestamp createTime, int roleId, int sex, String password) {
    this.id = id;
    this.studentId = studentId;
    this.studentName = studentName;
    this.birthday = birthday;
    this.phone = phone;
    this.email = email;
    this.address = address;
    this.note = note;
    this.status = status;
    this.level = level;
    this.createTime = createTime;
    this.roleId = roleId;
    this.sex = sex;
    this.password = password;
  }

  public Student() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getStudentId() {
    return studentId;
  }

  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public Timestamp getBirthday() {
    return birthday;
  }

  public void setBirthday(Timestamp birthday) {
    this.birthday = birthday;
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

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }

  public int getRoleId() {
    return roleId;
  }

  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }

  public int getSex() {
    return sex;
  }

  public void setSex(int sex) {
    this.sex = sex;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "Student{" +
            "id=" + id +
            ", studentId='" + studentId + '\'' +
            ", studentName='" + studentName + '\'' +
            ", birthday=" + birthday +
            ", phone='" + phone + '\'' +
            ", email='" + email + '\'' +
            ", address='" + address + '\'' +
            ", note='" + note + '\'' +
            ", status=" + status +
            ", level='" + level + '\'' +
            ", createTime=" + createTime +
            ", roleId=" + roleId +
            ", sex=" + sex +
            ", password='" + password + '\'' +
            '}';
  }
}

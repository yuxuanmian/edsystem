package com.xhu.entity;

import java.sql.Timestamp;

public class Teacher {

  private int id;
  private String teacherId;
  private String teacherName;
  private int sex;
  private Timestamp birthday;
  private String grade;
  private String rank;
  private Timestamp jobDate;
  private String college;
  private String password;
  private String phone;
  private int roleId;
  private String jobsign;
  private int status;

  public Teacher() {
  }

  public Teacher(int id, String teacherId, String teacherName, int sex, Timestamp birthday, String grade, String rank, Timestamp jobDate, String college, String password, String phone, int roleId) {
    this.id = id;
    this.teacherId = teacherId;
    this.teacherName = teacherName;
    this.sex = sex;
    this.birthday = birthday;
    this.grade = grade;
    this.rank = rank;
    this.jobDate = jobDate;
    this.college = college;
    this.password = password;
    this.phone = phone;
    this.roleId = roleId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(String teacherId) {
    this.teacherId = teacherId;
  }

  public String getTeacherName() {
    return teacherName;
  }

  public void setTeacherName(String teacherName) {
    this.teacherName = teacherName;
  }

  public int getSex() {
    return sex;
  }

  public void setSex(int sex) {
    this.sex = sex;
  }

  public Timestamp getBirthday() {
    return birthday;
  }

  public void setBirthday(Timestamp birthday) {
    this.birthday = birthday;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public String getRank() {
    return rank;
  }

  public void setRank(String rank) {
    this.rank = rank;
  }

  public Timestamp getJobDate() {
    return jobDate;
  }

  public void setJobDate(Timestamp jobDate) {
    this.jobDate = jobDate;
  }

  public String getCollege() {
    return college;
  }

  public void setCollege(String college) {
    this.college = college;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public int getRoleId() {
    return roleId;
  }

  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }

  public String getJobsign() {
    return jobsign;
  }

  public void setJobsign(String jobsign) {
    this.jobsign = jobsign;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Teacher{" +
            "id=" + id +
            ", teacherId='" + teacherId + '\'' +
            ", teacherName='" + teacherName + '\'' +
            ", sex=" + sex +
            ", birthday=" + birthday +
            ", grade='" + grade + '\'' +
            ", rank='" + rank + '\'' +
            ", jobDate=" + jobDate +
            ", college='" + college + '\'' +
            ", password='" + password + '\'' +
            ", phone='" + phone + '\'' +
            ", roleId=" + roleId +
            ", jobsign='" + jobsign + '\'' +
            ", status=" + status +
            '}';
  }
}

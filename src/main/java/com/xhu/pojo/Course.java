package com.xhu.pojo;


public class Course {

  private Integer id;
  private String courseId;
  private String courseName;
  private Integer courseTime;
  private String lessonType;
  private String examTime;
  private String examPlace;
  private Integer credit;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCourseId() {
    return courseId;
  }

  public void setCourseId(String courseId) {
    this.courseId = courseId;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public Integer getCourseTime() {
    return courseTime;
  }

  public void setCourseTime(Integer courseTime) {
    this.courseTime = courseTime;
  }

  public String getLessonType() {
    return lessonType;
  }

  public void setLessonType(String lessonType) {
    this.lessonType = lessonType;
  }

  public String getExamTime() {
    return examTime;
  }

  public void setExamTime(String examTime) {
    this.examTime = examTime;
  }

  public String getExamPlace() {
    return examPlace;
  }

  public void setExamPlace(String examPlace) {
    this.examPlace = examPlace;
  }

  public Integer getCredit() {
    return credit;
  }

  public void setCredit(Integer credit) {
    this.credit = credit;
  }

  @Override
  public String toString() {
    return "Course{" +
            "id=" + id +
            ", courseId='" + courseId + '\'' +
            ", courseName='" + courseName + '\'' +
            ", courseTime=" + courseTime +
            ", lessonType='" + lessonType + '\'' +
            ", examTime='" + examTime + '\'' +
            ", examPlace='" + examPlace + '\'' +
            ", credit=" + credit +
            '}';
  }
}

package com.xhu.pojo;

public class StudentCourse {

  private int id;
  private String studentId;
  private String courseId;
  private String teacherId;
  private int score;

  public StudentCourse() {
  }

  public StudentCourse(int id, String studentId, String courseId, String teacherId, int score) {
    this.id = id;
    this.studentId = studentId;
    this.courseId = courseId;
    this.teacherId = teacherId;
    this.score = score;
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

  public String getCourseId() {
    return courseId;
  }

  public void setCourseId(String courseId) {
    this.courseId = courseId;
  }

  public String getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(String teacherId) {
    this.teacherId = teacherId;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  @Override
  public String toString() {
    return "StudentCourse{" +
            "id=" + id +
            ", studentId='" + studentId + '\'' +
            ", courseId='" + courseId + '\'' +
            ", teacherId='" + teacherId + '\'' +
            ", score=" + score +
            '}';
  }
}

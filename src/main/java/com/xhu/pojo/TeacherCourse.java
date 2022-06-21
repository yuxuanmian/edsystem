package com.xhu.pojo;

public class TeacherCourse {

  private int id;
  private String courseId;
  private String place;
  private String teacherId;
  private String lessonTime;
  private boolean isOpen;

  public TeacherCourse() {
  }

  public TeacherCourse(int id, String courseId, String place, String teacherId, String lessonTime, boolean isOpen) {
    this.id = id;
    this.courseId = courseId;
    this.place = place;
    this.teacherId = teacherId;
    this.lessonTime = lessonTime;
    this.isOpen = isOpen;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCourseId() {
    return courseId;
  }

  public void setCourseId(String courseId) {
    this.courseId = courseId;
  }

  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }

  public String getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(String teacherId) {
    this.teacherId = teacherId;
  }

  public String getLessonTime() {
    return lessonTime;
  }

  public void setLessonTime(String lessonTime) {
    this.lessonTime = lessonTime;
  }

  public boolean isOpen() {
    return isOpen;
  }

  public void setOpen(boolean open) {
    isOpen = open;
  }

  @Override
  public String toString() {
    return "TeacherCourse{" +
            "id=" + id +
            ", courseId='" + courseId + '\'' +
            ", place='" + place + '\'' +
            ", teacherId='" + teacherId + '\'' +
            ", lessonTime='" + lessonTime + '\'' +
            ", isOpen=" + isOpen +
            '}';
  }
}

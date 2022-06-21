package com.xhu.common.vo;
import java.io.Serializable;

public class TCourse implements Serializable {
    private String courseId;
    private String teacherId;
    private String courseName;
    private int courseTime;
    private int credit;
    private String lessonType;
    private String teacherName;
    private String lessonTime;
    private String place;
    private boolean isCheck=false;
    private int checkCount;
    private boolean isOpen;

    public TCourse() {
    }

    public TCourse(String courseId, String teacherId, String courseName, int courseTime, int credit, String lessonType, String teacherName, String lessonTime, String place, boolean isCheck, int checkCount, boolean isOpen) {
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.courseName = courseName;
        this.courseTime = courseTime;
        this.credit = credit;
        this.lessonType = lessonType;
        this.teacherName = teacherName;
        this.lessonTime = lessonTime;
        this.place = place;
        this.isCheck = isCheck;
        this.checkCount = checkCount;
        this.isOpen = isOpen;
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(int courseTime) {
        this.courseTime = courseTime;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getLessonType() {
        return lessonType;
    }

    public void setLessonType(String lessonType) {
        this.lessonType = lessonType;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getLessonTime() {
        return lessonTime;
    }

    public void setLessonTime(String lessonTime) {
        this.lessonTime = lessonTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public int getCheckCount() {
        return checkCount;
    }

    public void setCheckCount(int checkCount) {
        this.checkCount = checkCount;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public String toString() {
        return "TCourse{" +
                "courseId='" + courseId + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseTime=" + courseTime +
                ", credit=" + credit +
                ", lessonType='" + lessonType + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", lessonTime='" + lessonTime + '\'' +
                ", place='" + place + '\'' +
                ", isCheck=" + isCheck +
                ", checkCount=" + checkCount +
                ", isOpen=" + isOpen +
                '}';
    }
}

package com.xhu.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于学生成绩查询返回值
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SCourse {
    private String studentId;
    private String studentName;
    private String studentPhone;
    private String address;
    private String level;
    private Integer studentSex;

    private String courseId;
    private String courseName;
    private Integer courseTime;
    private Integer credit;
    private String lessonType;

    private Integer score;
    private Integer id;

    private String teacherId;
    private String teacherName;
    private Integer teacherSex;
    /**
     * 职位
     */
    private String grade;
    /**
     * 教师级别
     */
    private String rank;
    private String teacherPhone;

}

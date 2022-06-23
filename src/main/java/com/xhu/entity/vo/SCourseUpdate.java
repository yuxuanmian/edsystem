package com.xhu.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SCourseUpdate {
    private String studentId;
    private String studentName;
    private String teacherId;
    private String teacherName;
    private String courseId;
    private String courseName;
    private Integer score;
}

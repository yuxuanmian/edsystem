package com.xhu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourse {

  private Integer id;
  private String studentId;
  private String courseId;
  private String teacherId;
  private Integer score;
}

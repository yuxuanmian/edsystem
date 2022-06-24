package com.xhu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

  private Integer id;
  private String courseId;
  private String courseName;
  private Integer courseTime;
  private String lessonType;
  private String examTime;
  private String examPlace;
  private Integer credit;

}

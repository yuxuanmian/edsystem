package com.xhu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherCourse {

  private Integer id;
  private String courseId;
  private String place;
  private String teacherId;
  private String lessonTime;
  private boolean isOpen;

}

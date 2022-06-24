package com.xhu.entity.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TCourse implements Serializable {
    private String courseId;
    private String teacherId;
    private String courseName;
    private Integer courseTime;
    private Integer credit;
    private String lessonType;
    private String teacherName;
    private String lessonTime;
    private String place;
    private boolean isCheck=false;
    private Integer checkCount;
    private boolean isOpen;

}

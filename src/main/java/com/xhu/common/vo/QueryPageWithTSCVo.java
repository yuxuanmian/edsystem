package com.xhu.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class QueryPageWithTSCVo implements Serializable {
    private String studentId;
    private String studentName;
    private String teacherId;
    private String teacherName;
    private String courseId;
    private String courseName;
    private String lessonTime;

    //页数
    private Integer page;

    //分页大小
    private Integer limit;

    //开始序号
    private Integer startIndex;


}

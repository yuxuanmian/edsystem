package com.xhu.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryPageWithTSCVo {
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

    /**
     * 计算开始序号
     * @return
     */
    public Integer getStartIndex() {
        this.startIndex=(this.page-1)*this.limit;
        return startIndex;
    }

}

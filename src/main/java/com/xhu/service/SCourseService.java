package com.xhu.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhu.common.vo.ResultVo;
import com.xhu.entity.StudentCourse;
import com.xhu.entity.vo.SCourse;

import java.util.Map;

public interface SCourseService {

    /**
     * 管理员查看所有学生成绩
     * @param map 包含studentId,studentName,courseName,courseId,teacherId,teacherName,page,limit
     * @return
     */
    IPage<SCourse> managerCherckAllStudetScore(Map<String,String> map);



}

package com.xhu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.edsystem.result.QueryResult;
import com.xhu.entity.vo.TCourse;

import java.util.Map;

public interface TeacherCourseService {
    IPage<TCourse> query(Map<String,?> map);

    IPage<TCourse> queryCheckStudent(String teacherId,String courseId,int page,int size);
}

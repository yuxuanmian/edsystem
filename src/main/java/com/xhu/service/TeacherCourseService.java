package com.xhu.service;

import com.edsystem.result.QueryResult;

import java.util.Map;

public interface TeacherCourseService {
    QueryResult query(Map map);

    QueryResult queryCheckStudent(String teacherId,String courseId,int page,int size);
}

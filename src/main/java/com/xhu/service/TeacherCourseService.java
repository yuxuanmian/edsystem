package com.xhu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhu.entity.Student;
import com.xhu.entity.vo.TCourse;

import java.util.Map;

public interface TeacherCourseService {
    IPage<TCourse> query(Map<String, Object> map, int page, int limit);

    IPage<Student> queryCheckStudent(String teacherId, String courseId, int page, int size);
}

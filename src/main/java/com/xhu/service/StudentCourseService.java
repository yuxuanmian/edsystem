package com.xhu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhu.common.bo.SimplePage;
import com.xhu.entity.StudentCourse;
import com.xhu.entity.Teacher;
import com.xhu.entity.vo.TCourse;

import java.util.Map;

public interface StudentCourseService {
    //查询全校课表
    IPage<TCourse> query(Map<String, Object> map, SimplePage page);

    //查询已选全部课程
    IPage<TCourse> queryIsSelect(Map<String, Object> map, SimplePage page);

    //查询全部未选课程
    IPage<TCourse> queryNoSelect(Map<String, Object> map, SimplePage page);

    //通过老师名查询老师
    Teacher queryByTeacherName(String teacherName);

    //通过学号，老师号，课程号查询唯一记录
    StudentCourse queryBySidAndCid(String studentId, String courseId, String teacherId);

    //学生选课
    void selectStudentCourse(String lessonTime, StudentCourse studentCourse);

    //退课
    void deleteStudentCourse(StudentCourse studentCourse);
}

package com.xhu.service;

import com.edsystem.pojo.StudentCourse;
import com.edsystem.pojo.Teacher;
import com.edsystem.result.QueryResult;

import java.util.Map;

public interface StudentCourseService {
    //查询全校课表
    QueryResult query(Map map);

    //查询已选全部课程
    QueryResult queryIsSelect(Map map);

    //查询全部未选课程
    QueryResult queryNoSelect(Map map);

    //通过老师名查询老师
    Teacher queryByTeacherName(String teacherName);

    //通过学号，老师号，课程号查询唯一记录
    StudentCourse queryBySidAndCid(String studentId, String courseId,String teacherId);

    //学生选课
    int selectStudentCourse(String lessonTime, StudentCourse studentCourse);

    //退课
    int deleteStudentCourse(StudentCourse studentCourse);
}

package com.xhu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhu.entity.vo.TCourse;
import com.xhu.entity.*;

import java.util.List;
import java.util.Map;

public interface ManagerCourseService {
    //查询全校课表
    IPage<TCourse> queryAll(Map map,IPage<TCourse> iPage);

    //查询当前学生是否选择该课程
    StudentCourse queryBySidCidTid(StudentCourse studentCourse);

    //根据学生Id查询有无该学生
    Student queryStudentBySid(String studentId);

    //为当前学生选课7
    public int selectStudentCourse(String lessonTime, StudentCourse studentCourse) ;

    //退课
    int deleteStudentCourse(StudentCourse studentCourse);

    //添加课程信息
    int addCourse(Course course);

    //添加任课教师信息
    int addTeacherCourse(TeacherCourse teacherCourse);

    //获取所有课程
    IPage queryCourse(IPage<Course> iPage);

    //获取最大的Cid
    String getMaxCid();

    //查询未教授该门课的老师
    List<Teacher> queryNoTeachByCid(String courseId);
}

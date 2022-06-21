package com.xhu.service;

import com.edsystem.pojo.StudentCourse;
import com.edsystem.utils.CountUtils;
import com.edsystem.utils.JsonUtils2;

public interface SCourseService {

    Integer countStudentCourseTotalSize();

    CountUtils findStudentCourseList(Integer page, Integer limit);

    //添加学生成绩
    JsonUtils2 addStudentCourse(StudentCourse studentCourse);


    /*根据课程查询选课学生成绩*/
    JsonUtils2 selectBycouseID(String courseId);

    /*根据序号Id查询学生成绩信息*/
    JsonUtils2 selectByID(Integer Id);

    /*根据序号修改学生成绩信息*/
    JsonUtils2 updateByID(StudentCourse studentCourse);

    /*根据Id删除学生信息 */
    JsonUtils2 deleteByID(Integer Id);

    CountUtils findStudentCourseByStudentList(String studentId, Integer page, Integer limit);

    CountUtils findStudentCourseByTeacherList(String teacherId, Integer page, Integer limit);


    CountUtils glyselect(String studentId, String teacherId, String courseId, Integer page, Integer limit);

    CountUtils lsselect(String studentId, String courseId, Integer page, Integer limit);

    CountUtils xsselect(String courseId, Integer page, Integer limit);



}

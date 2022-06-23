package com.xhu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhu.common.vo.ResultVo;
import com.xhu.entity.Course;
import com.xhu.entity.StudentCourse;
import com.xhu.entity.Teacher;
import com.xhu.entity.TeacherCourse;
import com.xhu.entity.vo.SCourse;
import com.xhu.entity.vo.TCourse;
import jdk.nashorn.internal.ir.LiteralNode;

import java.util.List;
import java.util.Map;

public interface SCourseService {

    /**
     * 管理员查看所有学生成绩
     *
     * @param map 包含studentId,studentName,courseName,courseId,teacherId,teacherName,page,limit
     * @return
     */
    IPage<SCourse> managerCherckAllStudetScore(Map<String, String> map);

    /**
     * 管理员根据id修改学生成绩
     *
     * @param studentCourse
     * @return
     */
    boolean managerUpdateStudentScore(StudentCourse studentCourse);

    /**
     * 查询所有老师信息
     * @return
     */
    List<Teacher> queryAllTeacher();

    /**
     * 查询所有课程信息
     * @return
     */
    List<Course> queryAllCourse();

    /**
     * 老师查看自己所授课程的成绩
     *
     * @param map
     * @return
     */
    IPage<SCourse> teacherCherckAllStudetScore(Map<String, String> map);

    List<TCourse> queryMyCourse(String teacherId);

    /**
     * 老师添加学生成绩
     * @param studentCourse
     * @return
     */
    boolean teacherAddStduentScore(StudentCourse studentCourse);

    /**
     * 学生查看自己所有课程成绩
     * @return
     */
    IPage<SCourse> studentCheckMyScore(Map<String,String> map);
}

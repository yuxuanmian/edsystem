package com.xhu.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhu.entity.Course;
import com.xhu.entity.StudentCourse;
import com.xhu.entity.Teacher;
import com.xhu.entity.TeacherCourse;
import com.xhu.entity.vo.SCourse;
import com.xhu.entity.vo.SCourseUpdate;
import com.xhu.entity.vo.TCourse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Repository
public interface SCourseMapper {
    //管理员课程成绩模块
    /**
     * 管理员查看所有学生成绩
     * @param map studentId,studentName,courseName,courseId,teacherId,teacherName
     * @param iPage page,limit
     * @return
     */
    IPage<SCourse> managerCherckAllStudetScore(@Param("map") Map<String,String> map, IPage<SCourse> iPage);

    /**
     * 管理员修改学生成绩
     * @param studentCourse
     * @return
     */
    Integer managerUpdateStudentScore(StudentCourse studentCourse);

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

    //老师课程成绩管理模块

    /**
     * 老师查看所有学生成绩
     * @param map teacherId（必须）,studentId,studentName,courseName,courseId
     * @param iPage page,limit
     * @return
     */
    IPage<SCourse> teacherCherckAllStudetScore(@Param("map") Map<String,String> map, IPage<SCourse> iPage);

    /**
     * 老师添加学生成绩，本质是修改
     * @param studentCourse
     * @return
     */
    Integer teacherAddStduentScore(StudentCourse studentCourse);

    //查询老师教授的所有课程
    List<TCourse> queryMyCourse(@Param("teacherId") String teacherId);

    //学生成绩管理模块

    /**
     * 学生查看个人成绩
     * @param map studentId（必须）,courseName,courseId,teacherId,teacherName
     * @param iPage
     * @return
     */
    IPage<SCourse> studentCheckMyScore(@Param("map") Map<String,String> map, IPage<SCourse> iPage);
}

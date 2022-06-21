package com.xhu.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhu.common.vo.TCourse;
import com.xhu.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface ManagerCourseMapper {
    //查询全校课程
    IPage<TCourse> query(Map map,IPage<TCourse> iPage);
    //查询全校课表总数
    int queryConunt(Map map);
    //查询每课的选课人数
    int queryCheckCount(@Param("courseId") String courseId,@Param("teacherId") String teacherId);

    //根据学生id查询学生是否存在
    Student queryStudentBySid(String studentId);
    //查询当前学生是否选择该课程
    StudentCourse queryBySidCidTid(StudentCourse studentCourse);
    //查询该学生所有课的时间
    List<String> queryLessonTime(StudentCourse studentCourse);
    //为当前学生选课
    int addStudentCourse(StudentCourse studentCourse);

    //退课
    int deleteStudentCourse(StudentCourse studentCourse);

    //添加课程信息
    int addCourse(Course course);

    //通过老师名查询老师信息
    Teacher queryByTeacherName(@Param("teacherName") String teacherName);
    //添加开课信息
    int addTeacherCourse(TeacherCourse teacherCourse);

    //查询所有课程
    IPage<Course> queryCourse(IPage<Course> iPage);
    int queryCourseCount(Map map);

    //查询最大的CourseId
    String getMaxCid();

    //根据Id查询没有教该门课的老师信息
    List<Teacher> queryNoTeachByCid(@Param("courseId") String courseId);
}

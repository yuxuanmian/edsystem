package com.xhu.mapper;

import com.edsystem.pojo.StudentCourse;
import com.edsystem.pojo.Teacher;
import com.edsystem.pojo.vo.TCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentCourseMapper {
    //查询全校课表
    List<TCourse> query(Map map);
    //查询全校课表总数
    int queryConunt(Map map);

    //通过courserID和studentId查询学生
    StudentCourse queryBySidAndCid(@Param("studentId") String studentId,@Param("courseId") String courseId,@Param("teacherId") String TeacherId);

    //查询自己已选所有课
    List<TCourse> queryIsSelect(Map map);
    //查询总数
    int queryIsSelectConunt(Map map);

    //查询自己未选所有课
    List<TCourse> queryNoSelect(Map map);
    //查询总数
    int queryNoSelectCount(Map map);

    //通过老师名查询老师信息
    Teacher queryByTeacherName(String teacherName);

    //选课
    //查询自己所选所有课的时间
    List<String> queryLessonTime(StudentCourse studentCourse);
    //向学生课程表中添加记录
    int addStudentCourse(StudentCourse studentCourse);

    //退课
    int deleteStudentCourse(StudentCourse studentCourse);

}

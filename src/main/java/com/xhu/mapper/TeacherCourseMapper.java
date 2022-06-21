package com.xhu.mapper;

import com.edsystem.pojo.Student;
import com.edsystem.pojo.vo.TCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TeacherCourseMapper {
    List<TCourse> query(Map map);
    int queryConunt(Map map);
    //查询每课的选课人数
    int queryCheckCount(@Param("courseId") String courseId,@Param("teacherId") String teacherId);
    //查询选课学生
    List<Student> queryCheckStudent(@Param("teacherId") String teacherId,@Param("courseId") String cid,@Param("page") int page,@Param("size") int size);
    int queryCheckStudentCount(@Param("teacherId") String teacherId,@Param("courseId") String cid);
}

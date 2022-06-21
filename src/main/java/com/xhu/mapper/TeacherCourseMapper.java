package com.xhu.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhu.entity.Student;
import com.xhu.entity.vo.TCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TeacherCourseMapper {
    IPage<TCourse> query(Map<String,?> map);

    int queryConunt(Map<String,?> map);

    //查询每课的选课人数
    int queryCheckCount(@Param("courseId") String courseId, @Param("teacherId") String teacherId);

    //查询选课学生
    IPage<Student> queryCheckStudent(@Param("teacherId") String teacherId, @Param("courseId") String cid, @Param("page") int page, @Param("size") int size);

    int queryCheckStudentCount(@Param("teacherId") String teacherId, @Param("courseId") String cid);
}

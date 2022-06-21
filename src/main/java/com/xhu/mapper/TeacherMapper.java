package com.xhu.mapper;

import com.edsystem.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    List<Teacher> findAllList(Integer page,Integer limit);
    Integer countTeacherTotalSize();
    int addTeacherList(Teacher teacher);
    int deleteTeacherList(String teacherId);

    int updateTeacherList(Teacher teacher);

    List<Teacher> searchTeacher(String SearchId);

    int addTeacherjobsign(@Param("teacherId")String teacherId, @Param("jobsign")String jobsign);
}

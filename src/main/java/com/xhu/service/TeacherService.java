package com.xhu.service;

import com.edsystem.pojo.Teacher;
import com.edsystem.result.JsonResult;
import com.edsystem.result.R;
import org.apache.ibatis.annotations.Param;

public interface TeacherService {

    JsonResult findAllList(Integer page,Integer limit);

    R addTeacherList(Teacher teacher);

    R deleteTeacherList(String teacherId);

    R updateTeacherList(Teacher teacher);

    R searchTeacher(String  SearchId);

    R addTeacherjobsign(@Param("teacherId")String Id, @Param("jobsign")String jobsign);
}

package com.xhu.mapper;

import com.edsystem.pojo.Manager;
import com.edsystem.pojo.Student;
import com.edsystem.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

public interface ResetPwdMapper {
    //通过id和电话号码查询管理员
    Manager queryManagerInfo(@Param("managerId") String id, @Param("phone") String phone);

    //通过id和电话号码查询老师
    Teacher queryTeacherInfo(@Param("teacherId") String id, @Param("phone") String phone);

    //通过id和电话号码查询学生
    Student queryStudentInfo(@Param("studentId") String id, @Param("phone") String phone);

    //重置密码
    int updateManagerPwd(@Param("id") String id,@Param("password") String pwd);

    //重置密码
    int updateTeacherPwd(@Param("id") String id,@Param("password") String pwd);

    //重置密码
    int updateStudentPwd(@Param("id") String id,@Param("password") String pwd);


    //查询密码是否正确

}
